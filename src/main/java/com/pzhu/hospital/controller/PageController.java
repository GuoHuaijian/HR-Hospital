/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: PageController
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 23:47
 * @Version:
 * @Description: 页面跳转
 */
package com.pzhu.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 23:47

 * @description: 页面跳转

 */

@Controller
public class PageController {


    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/admin/index1")
    public String index1(){
        return "admin/index1";
    }
}
