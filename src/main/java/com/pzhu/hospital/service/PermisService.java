/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.service
 * @ClassName: PermisService
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 20:42
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.service;

import com.pzhu.hospital.entity.Permis;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 20:42

 * @description:

 */
public interface PermisService {

    List<Permis> selectPermissionsByRoleId(Integer id);

    List<Permis> selectPermissionsByUserCode(String UserCode);
}
