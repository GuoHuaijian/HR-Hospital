package com.pzhu.hospital.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pzhu.hospital.entity.Position;
import org.springframework.stereotype.Component;

@Component
public interface PositionMapper extends BaseMapper<Position>{

	/**
	 * 根据PositionNumber查询信息
	 * @param positionNumber
	 * @return
	 */
	Position selectByNumber(Integer positionNumber);

}
