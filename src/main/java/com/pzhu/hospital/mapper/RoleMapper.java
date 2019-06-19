package com.pzhu.hospital.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pzhu.hospital.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper extends BaseMapper<Role> {
	 List<Role> selectRolesByUserCode(String userCode);
}
