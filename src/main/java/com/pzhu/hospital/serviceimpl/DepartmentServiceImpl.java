/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.serviceimpl
 * @ClassName: DepartmentServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/6/12 18:40
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.serviceimpl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pzhu.hospital.entity.Department;
import com.pzhu.hospital.mapper.DepartmentMapper;
import com.pzhu.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/12 18:40

 * @description:

 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department selectByNumber(Integer departmentNumber) {
        Department department = departmentMapper.selectByNumber(departmentNumber);
        return department;
    }

    @Override
    public Page<Department> selectListByPage(int pageNo) {
        Page<Department> page = new Page<Department>(pageNo, 10, "id");
        //是否为升序 ASC（ 默认： true ）
        page.setAsc(false);
        page.setRecords(baseMapper.selectPage(page, null));
        return page;
    }
}
