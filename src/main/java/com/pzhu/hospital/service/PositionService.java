/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: PositionService
 * @Author: Guo Huaijian
 * @Date: 2019/6/12 18:35
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.pzhu.hospital.entity.Position;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/12 18:35

 * @description:职称表的操作

 */
public interface PositionService extends IService<Position> {

    /**
     * 根据权限号查询权限
     * @param positionNumber
     * @Return: com.pzhu.hospital.entity.Position
     * @Date: 2019/6/12 18:39
     */
    Position selectByNumber(Integer positionNumber);

    /**
     * 分页查询所有职称
     * @param pageNo
     * @Return: com.baomidou.mybatisplus.plugins.Page<com.pzhu.hospital.entity.Position>
     * @Date: 2019/6/12 18:57
     */
    Page<Position> selectListByPage(int pageNo);
}
