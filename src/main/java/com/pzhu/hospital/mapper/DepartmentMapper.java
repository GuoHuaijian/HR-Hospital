package com.pzhu.hospital.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pzhu.hospital.entity.Department;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentMapper extends BaseMapper<Department> {

	/**
	 * 根据DepartmentNumber查询信息
	 * @param departmentNumber
	 * @return
	 */
	Department selectByNumber(Integer departmentNumber);

}
