/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.serviceimpl
 * @ClassName: RoleServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 20:39
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.serviceimpl;

import com.pzhu.hospital.entity.Role;
import com.pzhu.hospital.mapper.RoleMapper;
import com.pzhu.hospital.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 20:39

 * @description:

 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectRolesByUserCode(String userCode) {
        List<Role> roles = roleMapper.selectRolesByUserCode(userCode);
        return roles;
    }
}
