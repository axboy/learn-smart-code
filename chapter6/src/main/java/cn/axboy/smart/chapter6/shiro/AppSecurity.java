package cn.axboy.smart.chapter6.shiro;

import java.util.Set;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2018/7/17 23:54
 * TODO
 */
public class AppSecurity implements SmartSecurity{

    @Override
    public String getPasswordByUserName(String userName) {
        return null;
    }

    @Override
    public Set<String> getRoleNameSetByUserName(String userName) {
        return null;
    }

    @Override
    public Set<String> getPermissionNameSetByRoleName(String roleName) {
        return null;
    }
}
