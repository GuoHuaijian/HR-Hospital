/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: LeaveController
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 16:05
 * @Version:
 * @Description: 请假信息
 */
package com.pzhu.hospital.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.pzhu.hospital.entity.Employee;
import com.pzhu.hospital.entity.Leave;
import com.pzhu.hospital.serviceimpl.LeavaServiceImpl;
import com.pzhu.hospital.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 16:05

 * @description: 请假信息

 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeavaServiceImpl leavaService;

    /**
     * 请假申请页面的跳转
     * @param
     * @Return: java.lang.String
     * @Date: 2019/6/17 16:27
     */
    @RequestMapping("/toAdd")
    public String leaveAdd(){
        return "admin/leave_add";
    }

    /**
     * 查看个人请假记录
     * @param session
     * @param pageNo
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 16:28
     */
    @RequestMapping("/oneself")
    public String selectOne(HttpSession session, int pageNo, Model model){
        Employee employee = (Employee)session.getAttribute("user");
        Page<Leave> page = leavaService.seletByEmployee(employee.getEmployeeNumber(), pageNo);
        model.addAttribute("page", page);
        return "admin/oneself_leave";
    }

    /**
     * 请假未批准列表
     * @param model
     * @param session
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:47
     */
    @RequestMapping("/notlist")
    public String selectNotList(Model model, HttpSession session){
        //获取登录用户的信息
        Employee employee = (Employee) session.getAttribute("user");
        List<Leave> list = leavaService.selectListByStatus(employee.getDepartmentNumber(), "未批准");
        model.addAttribute("list", list);
        return "admin/leave_notlist";
    }

    /**
     * 请假已批准列表
     * @param model
     * @param session
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:48
     */
    @RequestMapping("/yeslist")
    public String selectYesList(Model model, HttpSession session){
        //获取登录用户的信息
        Employee employee = (Employee) session.getAttribute("user");
        List<Leave> list = leavaService.selectListByStatus(employee.getDepartmentNumber(), "已批准");
        model.addAttribute("list", list);
        return "admin/leave_yeslist";
    }

    /**
     * 员工请假记录信息
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:51
     */
    @RequestMapping("/list")
    public String selectList(Model model){
        List<Leave> list = leavaService.selectList();
        model.addAttribute("list", list);
        return "admin/leave_list";
    }

    /**
     * 请假信息提交
     * @param employeeNumber
     * @param leave
     * @Return: java.lang.String
     * @Date: 2019/6/19 9:12
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(Integer employeeNumber, Leave leave){
        String start = leave.getStart();
        String end = leave.getEnd();
        leave.setEmployeeNumber(employeeNumber);
        leave.setStartTime(MTimeUtil.stringParse(start));
        leave.setEndTime(MTimeUtil.stringParse(end));
        try {
            leavaService.insert(leave);
        }catch (Exception e){
            return "fail";
        }

        return "success";
    }

    /**
     * 查看请假信息
     * @param id
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/19 20:58
     */
    @RequestMapping("/{id}/detail")
    public String selectLeave(@PathVariable Integer id, Model model){
        Leave leave = leavaService.selectLeave(id);
        model.addAttribute("leave", leave);
        return "admin/leave_detail";
    }

    /**
     * 批准请假
     * @param id
     * @Return: java.lang.String
     * @Date: 2019/6/19 21:00
     */
    @RequestMapping("/{id}/update")
    public String updateStatus(@PathVariable Integer id){
        leavaService.updateStatus(id);
        return "forward:/leave/notlist";
    }
}
