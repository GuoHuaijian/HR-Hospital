/**
 * @ProjectName: HospitalManagementSystem
 * @Package: com.pzhu.hospital.shiro
 * @ClassName: UserRealm
 * @Author: Guo Huaijian
 * @Date: 2019/6/9 10:15
 * @Version:
 * @Description: 用户登陆认证和授权
 */
package com.pzhu.hospital.shiro;

import com.pzhu.hospital.entity.Employee;
import com.pzhu.hospital.entity.Permis;
import com.pzhu.hospital.entity.Role;
import com.pzhu.hospital.service.EmployeeService;
import com.pzhu.hospital.service.PermisService;
import com.pzhu.hospital.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Guo Huaijian

 * @Date: 2019/6/9 10:15

 * @description: 用户登陆认证和授权

 */
@Component
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermisService permisService;
    /**
     * 授权
     * @param principals
     * @Return: org.apache.shiro.authz.AuthorizationInfo
     * @Date: 2019/6/9 10:17
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo Info = new SimpleAuthorizationInfo();

        String userCode = String.valueOf(principals.getPrimaryPrincipal());
        //取用户角色

        final List<Role> roleInfos = roleService.selectRolesByUserCode(userCode);
        if (roleInfos!=null){
            for (Role role : roleInfos) {
                // 添加角色
                System.err.println(role);
                Info.addRole(role.getRole_sign());
                //取权限
                System.out.println(role.getId());
                final List<Permis> permissions = permisService.selectPermissionsByRoleId(role.getId());
                if (permissions!=null)
                {
                    for (Permis permission : permissions) {
                        // 添加权限
                        System.err.println(permission);
                        Info.addStringPermission(permission.getPermission_sign());
                    }
                }
            }
        }
        //取用户权限
        final List<Permis> userpermissions = permisService.selectPermissionsByUserCode(userCode);
        for (Permis permission : userpermissions) {
            // 添加权限
            System.err.println(permission);
            Info.addStringPermission(permission.getPermission_sign());
        }
        return Info;
    }

    /**
     * 认证
     * @param token
     * @Return: org.apache.shiro.authc.AuthenticationInfo
     * @Date: 2019/6/9 10:18
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //用户输入的账号
        String usernumber = String.valueOf(token.getPrincipal());
        String passwordInput = new String((char[]) token.getCredentials());

        //数据库的数据
        Employee employee = employeeService.CheckLogin(Integer.parseInt(usernumber));
        if (employee ==null){
            // 抛出 帐号找不到异常
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employee, employee.getPassword(), getName());
        return info;
    }
}
