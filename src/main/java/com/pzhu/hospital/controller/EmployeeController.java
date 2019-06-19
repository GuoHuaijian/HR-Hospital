/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: EmployeeController
 * @Author: Guo Huaijian
 * @Date: 2019/6/12 16:02
 * @Version:
 * @Description: 员工信息操作
 */
package com.pzhu.hospital.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pzhu.hospital.entity.Department;
import com.pzhu.hospital.entity.Employee;
import com.pzhu.hospital.entity.History;
import com.pzhu.hospital.entity.Position;
import com.pzhu.hospital.service.DepartmentService;
import com.pzhu.hospital.service.EmployeeService;
import com.pzhu.hospital.service.PositionService;
import com.pzhu.hospital.serviceimpl.HistoryServiceImpl;
import com.pzhu.hospital.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/12 16:02

 * @description: 个人信息操作

 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private HistoryServiceImpl historyService;

    /**
     * 查看个人信息
     * @param id
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/12 17:30
     */
    @RequestMapping("/information")
    public String SelectEmployeeById(Integer id, Model model){
        Employee employee = employeeService.selectEmployeeById(id);
        model.addAttribute("employee",employee);
        return "admin/oneself_detail";
    }

    /**
     * 跳转到个人信息修改页面
     * @param id
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/12 17:35
     */
    @RequestMapping("/information2")
    public String SelectEmployeeById2(Integer id, Model model){
        Employee employee = employeeService.selectById(id);
        model.addAttribute("employee", employee);
        return "admin/oneself_update";
    }

    /**
     * 修改信息（个人信息，在职员工信息）
     * @param employee
     * @param session
     * @Return: java.lang.String
     * @Date: 2019/6/14 9:14
     */
    @PostMapping("/update")
    @ResponseBody
    public String updateEmployee(Employee employee, HttpSession session){
        String date = employee.getDate();
        String status = employee.getStatus();
        employee.setBirthday(MTimeUtil.stringParse(date));
        Employee employee1 = (Employee)session.getAttribute("user"); //操作人员的名字
        try {
            employeeService.updateEmployee(employee,status ,employee1.getName());
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    /**
     * 查询在职员工列表
     * @param pageNo
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:42
     */
    @RequestMapping("/employeeList")
    public String employeeList(int pageNo,Model model){
        Page<Employee> page = employeeService.selectListByPage(pageNo);
        model.addAttribute("page", page);
        return "admin/employee_list";
    }

    /**
     * 跳转到员工添加页面
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/19 9:47
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<History> eList = historyService.selectList(new EntityWrapper<History>()
                .orderBy("employee_number", false));
        model.addAttribute("employeeNumber",eList.get(0).getEmployeeNumber()+1);
        List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
        model.addAttribute("dList", dList);
        List<Position> pList = positionService.selectList(new EntityWrapper<Position>());
        model.addAttribute("pList", pList);
        return "admin/employee_add";
    }

    /**
     * 员工添加
     * @param employee
     * @Return: java.lang.String
     * @Date: 2019/6/19 9:50
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(Employee employee) {
        String date = employee.getDate();
        employee.setBirthday(MTimeUtil.stringParse(date));
        try {
            employeeService.addEmployee(employee);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    /**
     * 查看员工信息
     * @param id
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/19 10:17
     */
    @RequestMapping("/{id}/detial")
    public String selectEmployee(@PathVariable Integer id, Model model){
        Employee employee = employeeService.selectEmployee(id);
        model.addAttribute("employee", employee);
        return "admin/employee_detail";
    }

    /**
     * 跳转到员工信息修改页面
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/12 17:35
     */
    @RequestMapping("/toUpdate")
    public String SelectEmployee2(Model model,Integer id){
        Employee employee = employeeService.selectById(id);
        model.addAttribute("employee", employee);
        List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
        model.addAttribute("dList", dList);
        List<Position> pList = positionService.selectList(new EntityWrapper<Position>());
        model.addAttribute("pList", pList);
        return "admin/employee_update";
    }

    /**
     * 删除在职员工
     * @param id
     * @Return: java.lang.String
     * @Date: 2019/6/19 15:41
     */
    @RequestMapping("/{id}/delete")
    @ResponseBody
    public String deleteById(@PathVariable Integer id){
        try {
            employeeService.deleteEmployee(id);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }
}
