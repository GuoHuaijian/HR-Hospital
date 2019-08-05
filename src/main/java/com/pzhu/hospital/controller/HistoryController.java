/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: HistoryController
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 17:11
 * @Version:
 * @Description:
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
import com.pzhu.hospital.service.HistoryService;
import com.pzhu.hospital.service.PositionService;
import com.pzhu.hospital.util.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 17:11

 * @description:

 */
@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    /**
     * 离休员工列表
     * @param pageNo
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:21
     */
    @RequestMapping("/retireListPage")
    public String RetireListByPage(int pageNo, Model model){
        Page<History> page = historyService.selectRetireByPage(pageNo);
        model.addAttribute("page", page);
        return "admin/retire_list";
    }

    /**
     * 所有员工档案列表
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:24
     */
    @RequestMapping("/list")
    public String list(Model model){
        List<History> hList = historyService.selectList();
        model.addAttribute("hList", hList);
        return "admin/history_list";
    }

    /**
     * 查看退休员工信息
     * @param id
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/19 15:42
     */
    @RequestMapping("/{id}/detail")
    public String selectHistory(@PathVariable Integer id, Model model){
        History history = historyService.selectHistory(id);
        model.addAttribute("history", history);
        return "admin/history_detail";
    }

    /**
     * 如果是在职员工就跳转到在职员工修改页面否则就跳转到离休员工修改页面
     * @param model
     * @param id
     * @Return: java.lang.String
     * @Date: 2019/6/19 16:46
     */
    @RequestMapping("/{id}/toUpdate")
    public String toUpdate(Model model, @PathVariable Integer id){
        History history = historyService.selectHistory(id);
        if (history.getStatus().equals("在职")) {
            Employee employee = employeeService.selectById(id);
            model.addAttribute("employee", employee);
            List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
            model.addAttribute("dList", dList);
            List<Position> pList = positionService.selectList(new EntityWrapper<Position>());
            model.addAttribute("pList", pList);
            return "admin/history_update";
        }else{
            model.addAttribute("history", history);
            return "admin/retire_update";
        }
    }

    /**
     * 修改离休员工
     * @param id
     * @param history
     * @Return: java.lang.String
     * @Date: 2019/6/19 16:47
     */
    @RequestMapping("/updateRetire")
    @ResponseBody
    public String updateRetire(Integer id, History history){
        history.setId(id);
        String date = history.getDate();
        history.setBirthday(MTimeUtil.stringParse(date));
        try {
            historyService.updateById(history);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    /**
     * 修改档案在职员工信息    //未完成需要添加多表修改同时修改history和employee表
     * @param history
     * @Return: java.lang.String
     * @Date: 2019/6/19 17:23
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateById( History history){
        System.out.println(history);
        History history1 = historyService.selectByNumber(history.getEmployeeNumber());
        String date = history.getDate();
        history.setId(history1.getId());
        history.setBirthday(MTimeUtil.stringParse(date));
        try {
            System.out.println(history);
            historyService.updateById(history);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }
}
