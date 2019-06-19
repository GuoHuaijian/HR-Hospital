package com.pzhu.hospital.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.pzhu.hospital.entity.History;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HistoryMapper extends BaseMapper<History> {

	/**
	 * 分页查询离休休员工（倒序）
	 * @param page
	 * @param status
	 * @return
	 */
	List<History> selectRetireByPage(Pagination page);
	
	/**
	 * 根据员工的工号查询信息
	 * @param employeeNumber
	 * @return
	 */
	History selectByNumber(Integer employeeNumber);
}
