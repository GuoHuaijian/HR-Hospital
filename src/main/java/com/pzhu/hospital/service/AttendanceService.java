/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: AttendanceService
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 10:54
 * @Version:
 * @Description: 考勤相关
 */
package com.pzhu.hospital.service;

import com.baomidou.mybatisplus.service.IService;
import com.pzhu.hospital.entity.Attendance;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 10:54

 * @description: 考勤相关

 */
public interface AttendanceService extends IService<Attendance> {

    /**
     * 插入上班记录
     * @param employeeNumber
     */
    void addStart(Integer employeeNumber);

    /**
     * 更新下班记录
     * @param employeeNumber
     */
    void addEnd(Integer employeeNumber);

    /**
     * 查询所有考勤记录
     * @return
     */
    List<Attendance> selectList();

    /**
     * 查询一个员工的考勤记录
     * @return
     */
    List<Attendance> selectByEmployee(Integer employeeNumber);
}
