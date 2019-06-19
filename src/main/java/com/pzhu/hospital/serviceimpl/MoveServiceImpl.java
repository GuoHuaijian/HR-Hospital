/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.serviceimpl
 * @ClassName: MoveServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 17:32
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.serviceimpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pzhu.hospital.entity.Department;
import com.pzhu.hospital.entity.Employee;
import com.pzhu.hospital.entity.Move;
import com.pzhu.hospital.entity.Overtime;
import com.pzhu.hospital.mapper.DepartmentMapper;
import com.pzhu.hospital.mapper.EmployeeMapper;
import com.pzhu.hospital.mapper.MoveMapper;
import com.pzhu.hospital.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 17:32

 * @description:

 */
@Service
public class MoveServiceImpl extends ServiceImpl<MoveMapper, Move> implements MoveService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 为overtime对象设置Department，Position对象
     *
     * @param overtime
     * @return
     */
    public Overtime setObject(Overtime overtime) {
        Integer departmentNumber = overtime.getDepartmentNumber();
        Department department = departmentMapper.selectByNumber(departmentNumber);
        overtime.setDepartment(department);

        Integer employeeNumber = overtime.getEmployeeNumber();
        Employee employee = employeeMapper.selectByNumber(employeeNumber);
        overtime.setEmployee(employee);
        return overtime;
    }

    @Override
    public List<Move> selectList() {
        //查询所有记录，根据id倒序排序
        List<Move> list = baseMapper.selectList(new EntityWrapper<Move>().
                orderBy("id", false));
        for (Move move : list) {
            Employee employee = employeeMapper.selectByNumber(move.getEmployeeNumber());
            move.setEmployee(employee);
            Department department = departmentMapper.selectByNumber(move.getBefore());
            move.setDepartment(department);
            Department department2 = departmentMapper.selectByNumber(move.getAfter());
            move.setDepartment2(department2);
        }
        return list;
    }
}
