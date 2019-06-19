/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.controller
 * @ClassName: LoginController
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 9:53
 * @Version:
 * @Description: 登陆相关
 */
package com.pzhu.hospital.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.pzhu.hospital.entity.Employee;
import com.pzhu.hospital.entity.Position;
import com.pzhu.hospital.service.EmployeeService;
import com.pzhu.hospital.util.R;
import com.pzhu.hospital.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 9:53

 * @description: 登陆相关

 */
@Controller
public class LoginController {

    @Autowired
    private Producer producer;

    @Autowired
    private EmployeeService employeeService;

    /**
     * 生成验证码
     *
     * @param response
     * @Return: void
     * @Date: 2019/6/9 10:06
     */
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session（注意：如果没有securityManager配置，则暂时无法工作，测试时先注释掉）
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.flush();
    }

    /**
     * 登陆跳转
     *
     * @param
     * @Return: java.lang.String
     * @Date: 2019/6/9 10:09
     */
    @GetMapping("/login")
    public String hello() {
        return "login";
    }
    /**
     * 没有权限跳转的页面
     * @param
     * @Return: java.lang.String
     * @Date: 2019/6/12 15:18
     */
    @RequestMapping("/unauthorized")
    public String toUnauthorized(){
        return "unauthorized";
    }

    /**
     * 登陆验证
     * @param session
     * @param map
     * @Return: com.pzhu.hospital.util.R
     * @Date: 2019/6/9 16:36
     */
    @PostMapping("/checkLogin")
    @ResponseBody
    public R checkLogin(HttpSession session, @RequestBody Map<String, String>map) {

        String error =null;
        String username = map.get("username");
        String password = map.get("password");
        String captcha = map.get("captcha");
        int isRememberMe = Integer.parseInt(map.get("isRememberMe"));

        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            error = "验证码错误！";
            return R.error(error);
        }
        Md5Hash md5Hash = new Md5Hash(password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, md5Hash.toString());
        //记住我
       if (isRememberMe == 1) {
           token.setRememberMe(true);
       }

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名或密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名或密码错误";
        } catch (ExcessiveAttemptsException e) {
            // TODO: handle exception
            error = "登录失败多次，账户锁定10分钟";
        }
        if (error != null) {// 出错了，返回登录页面
            return R.error(error);
        } else {// 登录成功

            Employee employee = employeeService.CheckLogin(Integer.parseInt(username));
            session.setAttribute("user", employee);
            Position position = employeeService.selectByNumber(employee.getPositionNumber());
            String level = position.getLevel();
            if (level.equals("人事部主任")) {
                return R.ok();
            } else if (level.equals("人事部员工")) {
                return R.ok("index2");
            } else if (level.equals("部门主任")) {
                return R.ok("index3");
            } else {
                return R.ok("index4");
            }

        }
    }
}