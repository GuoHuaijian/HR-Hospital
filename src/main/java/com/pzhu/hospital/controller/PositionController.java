/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: PositionController
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 18:57
 * @Version:
 * @Description: 职称信息
 */
package com.pzhu.hospital.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pzhu.hospital.entity.Position;
import com.pzhu.hospital.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 18:57

 * @description: 职称信息

 */
@Controller
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    /**
     * 职称列表信息
     * @param pageNo
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/17 18:59
     */
    @RequestMapping("/listPage")
    public String selecListByPage(int pageNo, Model model){
        Page<Position> page = positionService.selectListByPage(pageNo);
        model.addAttribute("page", page);
        return "admin/position_list";
    }

    /**
     * 跳转到添加职称页面
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/19 22:25
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<Position> dList = positionService.selectList(new EntityWrapper<Position>()
                .orderBy("position_number", false));
        model.addAttribute("positionNumber", dList.get(0).getPositionNumber()+1);
        return "admin/position_add";
    }

    /**
     * 添加职称信息
     * @param position
     * @Return: java.lang.String
     * @Date: 2019/6/19 22:26
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(Position position){
        try {
            positionService.insert(position);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    /**
     * 跳转到修改职称信息页面
     * @param id
     * @param model
     * @Return: java.lang.String
     * @Date: 2019/6/19 22:27
     */
    @RequestMapping("/{id}/toUpdate")
    public String toUpdate(@PathVariable Integer id, Model model){
        Position position = positionService.selectById(id);
        model.addAttribute("position", position);
        return "admin/position_update";
    }

    /**
     * 提交修改的职称信息
     * @param id
     * @param position
     * @Return: java.lang.String
     * @Date: 2019/6/19 22:27
     */
    @RequestMapping("/{id}/update")
    @ResponseBody
    public String updateById(@PathVariable Integer id, Position position){
        try {
            position.setId(id);
            positionService.updateById(position);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    /**
     * 删除职称信息
     * @param id
     * @Return: java.lang.String
     * @Date: 2019/6/19 22:28
     */
    @RequestMapping("/{id}/delete")
    @ResponseBody
    public String deleteById(@PathVariable Integer id){
        try {
            positionService.deleteById(id);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }
}
