package cn.axboy.smart.chapter6.shiro;

import java.util.Set;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2018/7/17 23:50
 */
public interface SmartSecurity {

    /**
     * 根据用户名获取密码
     * @param userName
     * @return
     */
    String getPasswordByUserName(String userName);

    /**
     * 根据用户名获取角色名集合
     * @param userName
     * @return
     */
    Set<String> getRoleNameSetByUserName(String userName);

    /**
     * 根据角色名获取权限名集合
     * @param roleName
     * @return
     */
    Set<String> getPermissionNameSetByRoleName(String roleName);
}
