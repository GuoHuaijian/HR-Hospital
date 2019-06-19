/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: MoveService
 * @Author: Guo Huaijian
 * @Date: 2019/6/17 17:30
 * @Version:
 * @Description: 员工调动信息
 */
package com.pzhu.hospital.service;

import com.baomidou.mybatisplus.service.IService;
import com.pzhu.hospital.entity.Move;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/17 17:30

 * @description: 员工调动信息

 */
public interface MoveService extends IService<Move> {

    /**
     * 查询所有的调动记录
     * @return
     */
    List<Move> selectList();
}
