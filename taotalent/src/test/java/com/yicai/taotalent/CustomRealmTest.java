package com.yicai.taotalent;

import com.alibaba.druid.pool.DruidDataSource;
import com.yicai.taotalent.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by RamboLi
 * Date 2018/5/10 0010
 * Time 15:45
 */
public class CustomRealmTest {
    private final static Logger logger = LoggerFactory.getLogger(AuthenticationTest.class);
    @Test
    public void testAuthentication(){
        CustomRealm customRealm = new CustomRealm();
        //1、构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        //加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(matcher);
        //2、主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("Mark","1234567");
        subject.login(usernamePasswordToken);

        logger.info("subject.isAuthenticated()="+subject.isAuthenticated());

//        subject.checkRole("admin");
//        subject.checkRoles("admin","user");
//        subject.checkPermission("user:update");
//        subject.checkPermissions("user:update","user:add");


//        subject.checkRoles("admin","user");
//        subject.logout();
//        logger.info("subject.isAuthenticated()="+subject.isAuthenticated());
    }
}
