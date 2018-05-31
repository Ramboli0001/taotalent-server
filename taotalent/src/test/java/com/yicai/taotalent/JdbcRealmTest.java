package com.yicai.taotalent;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by RamboLi
 * Date 2018/5/10 0010
 * Time 1:23
 */
public class JdbcRealmTest {
    private final static Logger logger = LoggerFactory.getLogger(AuthenticationTest.class);
    DruidDataSource druidDataSource = new DruidDataSource();
    {
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/taotalent");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
    }
    @Test
    public void testAuthentication(){
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setDataSource(druidDataSource);
        String authsql="select password from test_users where username = ?";
        jdbcRealm.setAuthenticationQuery(authsql);
        String rolesql="select role_name from test_user_roles where username = ?";
        jdbcRealm.setUserRolesQuery(rolesql);
        String permissionsql="select permission from test_roles_permissions where role_name = ?";
        jdbcRealm.setPermissionsQuery(permissionsql);
        //1、构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);
        //2、主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("xiaoming","123456");
        subject.login(usernamePasswordToken);

        logger.info("subject.isAuthenticated()="+subject.isAuthenticated());

        subject.checkRole("admin");
        subject.checkRoles("admin","user");
        subject.checkPermission("user:update");
//        subject.checkRoles("admin","user");
//        subject.logout();
//        logger.info("subject.isAuthenticated()="+subject.isAuthenticated());
    }
}
