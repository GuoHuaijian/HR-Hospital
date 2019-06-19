/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.serviceimpl
 * @ClassName: EmployeeServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 11:00
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.serviceimpl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pzhu.hospital.entity.*;
import com.pzhu.hospital.mapper.*;
import com.pzhu.hospital.service.EmployeeService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 11:00

 * @description:

 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private MoveMapper moveMapper;

    /**
     * 查询员工的所有信息
     * @param employee
     * @Return: com.pzhu.hospital.entity.Employee
     * @Date: 2019/6/12 15:49
     */
    public Employee setObject(Employee employee){
        Integer departmentNumber = employee.getDepartmentNumber();
        Department department = departmentMapper.selectByNumber(departmentNumber);
        employee.setDepartment(department);

        Integer positionNumber = employee.getPositionNumber();
        Position position = positionMapper.selectByNumber(positionNumber);
        employee.setPosition(position);
        return employee;
    }

    @Override
    public Employee CheckLogin(Integer employeeNumber) {
        Employee employee = employeeMapper.checkLogin(employeeNumber);
        return employee;
    }

    @Override
    public Position selectByNumber(Integer positionNumber) {
        Position position = positionMapper.selectByNumber(positionNumber);
        return position;
    }

    @Override
    public Employee selectEmployeeById(Integer id) {
        Employee employee = employeeMapper.selectEmployeeById(id);
        Employee employee1 = setObject(employee);
        return employee1;
    }

    @Override
    public void updateEmployee(Employee employee, String status, String manager) {
        //判断员工的在职状态是否改变
        if (status.equals("在职")) {
            //状态未改变，更新员工信息
            //获取员工原始信息，用于判断部门或职称是否改变
            Employee employee2 = employeeMapper.selectEmployeeById(employee.getId());
            Move move = new Move();
            move.setEmployeeNumber(employee.getEmployeeNumber());
            move.setTime(new Date());
            move.setManager(manager);
            //判断员工的部门是否改变，若改变向change中插入一条员工变动记录
            if(!employee.getDepartmentNumber().equals(employee2.getDepartmentNumber())){
                move.setBefore(employee2.getDepartmentNumber());
                move.setAfter(employee.getDepartmentNumber());
                moveMapper.insert(move);
            }
            //如果老密码与输入的密码相同则不处理
            if (!employee2.getPassword().equals(employee.getPassword()))
            {
                //密码加密md5
                Md5Hash md5Hashpasswd = new Md5Hash(employee.getPassword());
                employee.setPassword(md5Hashpasswd.toString());
            }
            employeeMapper.updateById(employee);
        }else{
            //状态变为离职或退休
            //删除在职员工记录
            //baseMapper.deleteById(employee.getId());
            //更新员工档案的状态
            History history = historyMapper.selectByNumber(employee.getEmployeeNumber());
            history.setStatus(status);
            history.setOutTime(new Date());
            historyMapper.updateById(history);
        }
    }

    @Override
    public Page<Employee> selectListByPage(int pageNo) {
        Page<Employee> page = new Page<Employee>(pageNo, 10,"id");
        //是否为升序 ASC（ 默认： true ）
        page.setAsc(false);
        List<Employee> eList = baseMapper.selectPage(page, null);
        for(Employee e : eList){
            //为employee对象中setDepartment setPosition
            setObject(e);
        }
        page.setRecords(eList);
        return page;
    }

    @Override
    public void addEmployee(Employee employee) {
        //向employee中插入记录
        employee.setInTime(new Date());
        //密码加密md5
        Md5Hash md5Hashpasswd = new Md5Hash(employee.getPassword());
        employee.setPassword(md5Hashpasswd.toString());
        baseMapper.insert(employee);
        //同时向history中插入记录
        History history = new History();
        history.setEmployeeNumber(employee.getEmployeeNumber());
        history.setName(employee.getName());
        history.setGender(employee.getGender());
        history.setBirthday(employee.getBirthday());
        history.setTelephone(employee.getTelephone());
        history.setEmail(employee.getEmail());
        history.setAddress(employee.getAddress());
        history.setPhoto(employee.getPhoto());
        history.setEducation(employee.getEducation());
        history.setInTime(employee.getInTime());
        history.setDepartmentNumber(employee.getDepartmentNumber());
        history.setPositionNumber(employee.getPositionNumber());
        history.setStatus("在职");
        history.setNotes(employee.getNotes());
        historyMapper.insert(history);
    }

    @Override
    public Employee selectEmployee(Integer id) {
        Employee employee = baseMapper.selectById(id);
        //向employee对象中setDepartment setPosition
        setObject(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
            //先查询再删除，否则NullPointerException
            Employee employee = baseMapper.selectById(id);
            //删除在职员工记录
            baseMapper.deleteById(id);
            //将员工档案表中的状态改为离职
            History history = historyMapper.selectByNumber(employee.getEmployeeNumber());
            history.setStatus("离职");
            historyMapper.updateById(history);

    }

    @Override
    public Employee selectByNumber1(Integer employeeNumber) {
        return baseMapper.selectByNumber(employeeNumber);
    }

}
