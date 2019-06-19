/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: OvertimeController
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 11:22
 * @Version:
 * @Description: 加班信息
 */
package com.pzhu.hospital.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pzhu.hospital.entity.Department;
import com.pzhu.hospital.entity.Employee;
import com.pzhu.hospital.entity.Overtime;
import com.pzhu.hospital.serviceimpl.DepartmentServiceImpl;
import com.pzhu.hospital.serviceimpl.EmployeeServiceImpl;
import com.pzhu.hospital.serviceimpl.OvertimeServiceImpl;
import com.pzhu.hospital.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 11:22

 * @description: 加班信息

 */
@Controller
@RequestMapping("/overtime")
public class OvertimeController {

    @Autowired
    private OvertimeServiceImpl overtimeService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    /**
     *个人加班信息
     * @param employeeNumber
     * @param model
     * @param PageNo
     * @Return: java.lang.String
     * @Date: 2019/6/17 16:01
     */
    @RequestMapping("/{employeeNumber}/oneself")
    public String selectOne(@PathVariable Integer employeeNumber, Model model,@RequestParam(defaultValue = "1") int PageNo){
        Page<Overtime> overtimePage = overtimeService.selectByEmployee(PageNo, employeeNumber);
        model.addAttribute("page",overtimePage);
        return "admin/oneself_overtime";
    }

    /**
     * 加班列表信息
     * @param model
     * @param pageNo
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:41
     */
    @RequestMapping("/listPage")
    public String selectListByPgae(Model model, int pageNo){
        Page<Overtime> page = overtimeService.selectListByPage(pageNo);
        model.addAttribute("page",page);
        return "admin/overtime_list";
    }

    /**
     * 跳转到安排加班页面
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/18 8:13
     */
    @RequestMapping("/toAdd")
    public String overtimeToAdd(Model model){
        //查询出所有的部门
        List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
        model.addAttribute("dList", dList);
        //查询出所有的员工
        List<Employee> eList = employeeService.selectList(new EntityWrapper<Employee>());
        model.addAttribute("eList", eList );
        return "admin/overtime_add";
    }

    /**
     * 安排加班
     * @param overtime
     * @Return: java.lang.String
     * @Date: 2019/6/18 8:37
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(Overtime overtime){
        String date = overtime.getDate();
        overtime.setDay(MTimeUtil.stringParse(date));
        try {
            overtimeService.insert(overtime);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    /**
     * 跳转到加班修改页面
     * @param model
     * @param id
     * @Return: java.lang.String
     * @Date: 2019/6/19 20:29
     */
    @RequestMapping("/{id}/toUpdate")
    public String toUpdate(Model model, @PathVariable Integer id) {
        //查询出要修改的记录信息
        Overtime overtime = overtimeService.selectById(id);
        model.addAttribute("overtime", overtime);
        //查询出所有的部门
        List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
        model.addAttribute("dList", dList);
        //查询出所有的员工
        List<Employee> eList = employeeService.selectList(new EntityWrapper<Employee>());
        model.addAttribute("eList", eList);
        return "admin/overtime_update";
    }

    /**
     * 修改加班信息
     * @param id
     * @param date
     * @param overtime
     * @Return: java.lang.String
     * @Date: 2019/6/19 20:31
     */
    @RequestMapping("/{id}/update")
    public String updateById(@PathVariable Integer id,  String date, Overtime overtime){
        overtime.setId(id);
        overtime.setDay(MTimeUtil.stringParse(date));
        overtimeService.updateById(overtime);
        return "forward:/overtime/listPage?pageNo=1";
    }

    /**
     * 删除加班信息
     * @param id
     * @Return: java.lang.String
     * @Date: 2019/6/19 20:33
     */
    @RequestMapping("/{id}/delete")
    public String deleteById(@PathVariable Integer id){
        overtimeService.deleteById(id);
        return "forward:/overtime/listPage?pageNo=1";
    }
}
