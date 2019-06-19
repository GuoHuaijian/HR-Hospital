/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.serviceimpl
 * @ClassName: PositionServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/6/12 18:49
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.serviceimpl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pzhu.hospital.entity.Position;
import com.pzhu.hospital.mapper.PositionMapper;
import com.pzhu.hospital.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/12 18:49

 * @description:

 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService{

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Position selectByNumber(Integer positionNumber) {
        Position position = positionMapper.selectByNumber(positionNumber);
        return position;
    }

    @Override
    public Page<Position> selectListByPage(int pageNo) {
        Page<Position> page = new Page<Position>(pageNo, 20, "id");
        page.setAsc(false);
        page.setRecords(baseMapper.selectPage(page, null));
        return page;
    }
}
