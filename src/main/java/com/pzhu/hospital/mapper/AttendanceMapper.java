package com.pzhu.hospital.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pzhu.hospital.entity.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AttendanceMapper extends BaseMapper<Attendance> {

	/**
	 * 根据employeeNumber和day查询记录
	 * @param employeeNumber
	 * @return
	 */
	Attendance selectByNumber(@Param("employeeNumber") Integer employeeNumber,
                              @Param("day") Date day, @Param("timeType") String timeType);
}
