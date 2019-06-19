package com.pzhu.hospital.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pzhu.hospital.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeMapper extends BaseMapper<Employee> {

	/**
	 * 登录验证
	 * @param employeeNumber
	 * @return
	 */
	Employee checkLogin(@Param("employeeNumber") Integer employeeNumber);
	
	/**
	 * 根据employeeNumber查询信息
	 * @param employeeNumber
	 * @return
	 */
	Employee selectByNumber(Integer employeeNumber);

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @Return: com.pzhu.hospital.entity.Employee
	 * @Date: 2019/6/12 15:58
	 */
	Employee selectEmployeeById(Integer id);
	
}
