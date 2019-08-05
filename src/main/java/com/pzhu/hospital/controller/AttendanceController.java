/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: AttendanceController
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 10:50
 * @Version:
 * @Description: 考勤相关操作
 */
package com.pzhu.hospital.controller;

import com.pzhu.hospital.entity.Attendance;
import com.pzhu.hospital.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 10:50

 * @description: 考勤相关操作

 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    /**
     * 个人考勤记录
     * @param employeeNumber
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 11:15
     */
    @RequestMapping("/{employeeNumber}/oneself")
    public String selectOne(@PathVariable Integer employeeNumber, Model model){
        List<Attendance> attendance = attendanceService.selectByEmployee(employeeNumber);
        model.addAttribute("aList",attendance);
        return "admin/oneself_attendance";
    }

    /**
     * 考勤管理列表
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:41
     */
    @RequestMapping("/list")
    public String selectList(Model model){
        List<Attendance> list = attendanceService.selectList();
        model.addAttribute("aList",list);
        return "admin/attendance_list";
    }

    /**
     * 上班签到
     * @param employeeNumber
     * @Return: java.lang.String
     * @Date: 2019/6/19 22:48
     */
    @RequestMapping("/addStart")
    public String addStart(Integer employeeNumber){
        attendanceService.addStart(employeeNumber);
        return "welcome";
    }

    /**
     * 下班签到
     * @param employeeNumber
     * @Return: java.lang.String
     * @Date: 2019/6/19 22:49
     */
    @RequestMapping("/addEnd")
    public String addEnd(Integer employeeNumber){
        attendanceService.addEnd(employeeNumber);
        return "welcome";
    }
}
