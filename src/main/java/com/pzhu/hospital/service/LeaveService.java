/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: LeaveService
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 16:06
 * @Version:
 * @Description: 请假信息
 */
package com.pzhu.hospital.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.pzhu.hospital.entity.Leave;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 16:06

 * @description: 请假信息

 */
public interface LeaveService {

    /**
     * 查询所有请假记录
     * @param pageNo
     * @return
     */
    List<Leave> selectList();

    /**
     * 查询一个请假记录
     * @param id
     * @return
     */
    Leave selectLeave(Integer id);

    /**
     * 更改批准状态
     * @param id
     */
    void updateStatus(Integer id);

    /**
     * 查询一个人的请假记录
     * @param employeeNumber
     * @param pageNo
     * @return
     */
    Page<Leave> seletByEmployee(Integer employeeNumber, int pageNo);

    /**
     * 根据状态查询所有请假记录
     * @param pageNo
     * @return
     */
    List<Leave> selectListByStatus(Integer deparmentNumber, String status);

}
