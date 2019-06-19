/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: DepartmentController
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 18:51
 * @Version:
 * @Description: 部门信息
 */
package com.pzhu.hospital.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pzhu.hospital.entity.Department;
import com.pzhu.hospital.serviceimpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 18:51

 * @description: 部门信息

 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    /**
     * 部门列表信息
     * @param model
     * @param pageNo
     * @Return: java.lang.String
     * @Date: 2019/6/17 18:55
     */
    @RequestMapping("/listPage")
    public String selectListByPgae(Model model, int pageNo){
        Page<Department> page = departmentService.selectListByPage(pageNo);
        model.addAttribute("page",page);
        return "admin/department_list";
    }


    /**
     * 跳转到添加部门页面
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/19 21:14
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<Department> dList = departmentService.selectList(new EntityWrapper<Department>()
                .orderBy("department_number", false));
        model.addAttribute("departmentNumber", dList.get(0).getDepartmentNumber()+1);
        return "admin/department_add";
    }

    /**
     * 添加部门
     * @param department
     * @Return: java.lang.String
     * @Date: 2019/6/19 21:15
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(Department department){
        try {
            departmentService.insert(department);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "fail";
        }
        return "success";
    }

    /**
     * 跳转到修改部门信息页面
     * @param id
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/19 21:15
     */
    @RequestMapping("/{id}/toUpdate")
    public String toUpdate(@PathVariable Integer id, Model model){
        Department department = departmentService.selectById(id);
        model.addAttribute("department", department);
        return "admin/department_update";
    }

    /**
     * 提交修改的部门信息
     * @param id
     * @param department
     * @Return: java.lang.String
     * @Date: 2019/6/19 21:16
     */
    @RequestMapping("/{id}/update")
    @ResponseBody
    public String updateById(@PathVariable Integer id, Department department){
        try {
            department.setId(id);
            departmentService.updateById(department);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    /**
     * 删除部门信息
     * @param id
     * @Return: java.lang.String
     * @Date: 2019/6/19 21:16
     */
    @RequestMapping("/{id}/delete")
    @ResponseBody
    public String deleteById(@PathVariable Integer id){
        try {
            departmentService.deleteById(id);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

}
