package com.yicai.taotalent.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by RamboLi
 * Date 2018/5/10 0010
 * Time 14:46
 */
public class CustomRealm extends AuthorizingRealm {
    Map<String,String> userMap = new HashMap<>(16);
    {
        userMap.put("Mark","19a4043d350d95458fde5e192e4b9a43");
        super.setName("customRealm");
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roleset = getRolesByUserName(username);
        Set<String> permissionset = getPermissionByUserName(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissionset);
        authorizationInfo.setRoles(roleset);
        return authorizationInfo;
    }

    /**
     * 模拟数据库操作
     * @param username
     * @return
     */
    private Set<String> getPermissionByUserName(String username) {
        Set<String> sets = new HashSet<>();
        sets.add("user:update");
        sets.add("user:add");
        return sets;
    }

    /**
     * 模拟数据库操作
     * @param username
     * @return
     */
    private Set<String> getRolesByUserName(String username) {
        Set<String> sets = new HashSet<>();
        sets.add("admin");
        sets.add("user");
        return sets;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1、从主体传过来的认证中，获得用户名
        String username = (String) authenticationToken.getPrincipal();
        //2、通过用户名获取
        String password = getPasswordByUserName(username);
        if (password == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("Mark",password,"customRealm");
        //加盐
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("saltobject"));
        return authenticationInfo;
    }

    /**
     * 模拟数据库查询
     * @param username
     * @return
     */
    private String getPasswordByUserName(String username) {
        return userMap.get(username);
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("1234567","saltobject");
        System.out.println("md5jiamiguohou------------>"+md5Hash.toString());
    }
}
