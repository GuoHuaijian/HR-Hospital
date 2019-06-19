/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: HistoryService
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 17:12
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.pzhu.hospital.entity.History;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 17:12

 * @description:

 */
public interface HistoryService extends IService<History> {

    /**
     * 分页查询离休员工
     * @param pageNo
     * @return
     */
    Page<History> selectRetireByPage(int pageNo);

    /**
     * 查询一个员工档案信息
     * @param id
     * @return
     */
    History selectHistory(Integer id);

    /**
     * 分页查询所有员工档案
     * @param pageNo
     * @return
     */
    Page<History> selectLisByPage(int pageNo);

    /**
     * 根据员工的工号查询信息
     * @param employeeNumber
     * @return
     */
    History selectByNumber(Integer employeeNumber);

    /**
     * 查询所有员工档案信息
     * @return
     */
    List<History> selectList();
}
