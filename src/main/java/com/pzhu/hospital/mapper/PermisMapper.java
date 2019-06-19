package com.pzhu.hospital.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pzhu.hospital.entity.Permis;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface PermisMapper extends BaseMapper<Permis> {
	List<Permis> selectPermissionsByRoleId(Integer id);

	List<Permis> selectPermissionsByUserCode(String userCode);
}
