/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: EmployeeService
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 10:58
 * @Version:
 * @Description: 用户表的判断
 */
package com.pzhu.hospital.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.pzhu.hospital.entity.Employee;
import com.pzhu.hospital.entity.Position;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 10:58

 * @description: 用户表的判断及用户相关增删查改

 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 验证登陆
     * @param employeeNumber
     * @Return: Employee
     * @Date: 2019/6/12 15:45
     */
    Employee CheckLogin(Integer employeeNumber);

    /**
     * 查询职称和级别
     * @param positionNumber
     * @Return: com.pzhu.hospital.entity.Position
     * @Date: 2019/6/12 15:44
     */
    Position selectByNumber(Integer positionNumber);

    /**
     * 根据id查询个人信息
     * @param id
     * @Return: com.pzhu.hospital.entity.Employee
     * @Date: 2019/6/12 15:47
     */
    Employee selectEmployeeById(Integer id);

    /**
     * 修改个人信息
     * @param employee
     * @param status
     * @param manager
     * @Return: void
     * @Date: 2019/6/14 9:03
     */
    void updateEmployee(Employee employee,String status,String manager);

    /**
     * 分页查询所有员工（倒序）
     * @return
     */
    Page<Employee> selectListByPage(int pageNo);

    /**
     * 添加员工（同时插入到员工表和员工档案表）
     * @param employee
     * @return
     */
    void addEmployee(Employee employee);

    /**
     * 查询一个员工的信息
     * @param id
     * @return
     */
    Employee selectEmployee(Integer id);

    /**
     * 删除员工信息
     * @param id
     */
    void deleteEmployee(Integer id);

    /**
     * 根据employeeNumber查询信息
     * @param employeeNumber
     * @return
     */
    Employee selectByNumber1(Integer employeeNumber);

}
