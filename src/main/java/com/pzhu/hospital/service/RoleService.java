/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: RoleService
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 20:37
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.service;

import com.pzhu.hospital.entity.Role;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 20:37

 * @description:授权

 */
public interface RoleService {

    /**
     * 通过用户工号 查询用户 拥有的角色
     * @param userCode
     * @Return: java.util.List<com.pzhu.hospital.entity.Role>
     * @Date: 2019/6/9 20:38
     */
    List<Role> selectRolesByUserCode(String userCode);
}
