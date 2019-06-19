/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.serviceimpl
 * @ClassName: PermisServiceImpl
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 20:43
 * @Version:
 * @Description:
 */
package com.pzhu.hospital.serviceimpl;

import com.pzhu.hospital.entity.Permis;
import com.pzhu.hospital.mapper.PermisMapper;
import com.pzhu.hospital.service.PermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 20:43

 * @description:

 */
@Service
public class PermisServiceImpl implements PermisService {

    @Autowired
    private PermisMapper permisMapper;


    @Override
    public List<Permis> selectPermissionsByRoleId(Integer id) {
        List<Permis> permis = permisMapper.selectPermissionsByRoleId(id);
        return permis;
    }

    @Override
    public List<Permis> selectPermissionsByUserCode(String UserCode) {
        List<Permis> permis = permisMapper.selectPermissionsByUserCode(UserCode);
        return permis;
    }
}
