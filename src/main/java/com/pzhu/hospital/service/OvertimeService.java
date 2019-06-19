/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: OvertimeService
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 11:23
 * @Version:
 * @Description: 加班信息
 */
package com.pzhu.hospital.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.pzhu.hospital.entity.Overtime;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 11:23

 * @description: 加班信息

 */
public interface OvertimeService extends IService<Overtime> {

    /**
     * 分页查询所有的加班记录
     * @param pageNo
     * @return
     */
    Page<Overtime> selectListByPage(int pageNo);

    /**
     * 查询一个员工的加班记录
     * @return
     */
    Page<Overtime> selectByEmployee(int pageNo, Integer employeeNumber);

}
