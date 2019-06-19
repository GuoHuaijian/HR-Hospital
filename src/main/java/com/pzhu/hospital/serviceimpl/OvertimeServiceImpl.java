/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.serviceimpl
 * @ClassName: OvertimeServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 11:23
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pzhu.hospital.entity.Department;
import com.pzhu.hospital.entity.Employee;
import com.pzhu.hospital.entity.Overtime;
import com.pzhu.hospital.mapper.DepartmentMapper;
import com.pzhu.hospital.mapper.EmployeeMapper;
import com.pzhu.hospital.mapper.OvertimeMapper;
import com.pzhu.hospital.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 11:23

 * @description:

 */
@Service
public class OvertimeServiceImpl extends ServiceImpl<OvertimeMapper, Overtime> implements OvertimeService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * 为加班类加入部门和员工信息
     * @param overtime
     * @Return: com.pzhu.hospital.entity.Overtime
     * @Date: 2019/6/17 11:29
     */
    public Overtime setObject(Overtime overtime){
        Integer departmentNumber = overtime.getDepartmentNumber();
        Department  department = departmentMapper.selectByNumber(departmentNumber);
        overtime.setDepartment(department);

        Integer employeeNumber = overtime.getEmployeeNumber();
        Employee employee = employeeMapper.selectByNumber(employeeNumber);
        overtime.setEmployee(employee);
        return overtime;
    }

    @Override
    public Page<Overtime> selectListByPage(int pageNo) {
        Page<Overtime> page = new Page<Overtime>(pageNo,10,"id");
        //是否为升序 ASC（ 默认： true ）
        page.setAsc(false);
        List<Overtime> oList = baseMapper.selectPage(page, null);
        for(Overtime overtime : oList){
            setObject(overtime);
        }
        page.setRecords(oList);
        return page;
    }

    @Override
    public Page<Overtime> selectByEmployee(int pageNo, Integer employeeNumber) {
        Page<Overtime> page = new Page<Overtime>(pageNo, 10, "id");
        //是否为升序 ASC（ 默认： true ）
        page.setAsc(false);
        //查询一个员工的考勤记录，根据id倒序排序
        List<Overtime> oList = baseMapper.selectPage(page, new EntityWrapper<Overtime>()
                .eq("employee_number", employeeNumber)
                .orderBy("id", false));
        for(Overtime overtime : oList){
            //为attendance对象setEmployee
            setObject(overtime);
        }
        page.setRecords(oList);
        return page;
    }
}
