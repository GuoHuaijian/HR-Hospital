/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: MoveController
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 17:28
 * @Version:
 * @Description: 员工调动记录
 */
package com.pzhu.hospital.controller;

import com.pzhu.hospital.entity.Move;
import com.pzhu.hospital.serviceimpl.MoveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 17:28

 * @description: 员工调动记录

 */
@Controller
@RequestMapping("/move")
public class MoveController {

    @Autowired
    private MoveServiceImpl moveService;

    /**
     * 员工调动记录信息
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 17:29
     */
    @RequestMapping("/list")
    public String selectList(Model model){
        List<Move> list = moveService.selectList();
        model.addAttribute("mList",list);
        return "admin/move_list";
    }
}
