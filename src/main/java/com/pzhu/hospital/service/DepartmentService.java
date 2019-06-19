/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: DepartmentService
 * @Author: Guo Huaijian
 * @Date: 2019/6/12 18:34
 * @Version:
 * @Description: 部门表的操作
 */
package com.pzhu.hospital.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.pzhu.hospital.entity.Department;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/12 18:34

 * @description: 部门表的操作

 */
public interface DepartmentService extends IService<Department> {

    /**
     *根据部门号查询部门
     * @param departmentNumber
     * @Return: com.pzhu.hospital.entity.Department
     * @Date: 2019/6/12 18:37
     */
    Department selectByNumber(Integer departmentNumber);

    /**
     * 分页查询所有部门
     * @param pageNo
     * @Return: com.baomidou.mybatisplus.plugins.Page<com.pzhu.hospital.entity.Department>
     * @Date: 2019/6/12 18:54
     */
    Page<Department> selectListByPage(int pageNo);
}
