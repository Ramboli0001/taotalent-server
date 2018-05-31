package com.yicai.taotalent;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by RamboLi
 * Date 2018/5/9 0009
 * Time 23:46
 */
public class AuthenticationTest {
    private final static Logger logger = LoggerFactory.getLogger(AuthenticationTest.class);
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("liyongsheng","123456","admin","user");
    }
    @Test
    public void testAuthentication(){
        //1、构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);
        //2、主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("liyongsheng","123456");
        subject.login(usernamePasswordToken);

        logger.info("subject.isAuthenticated()="+subject.isAuthenticated());

        subject.checkRole("admin");
        subject.checkRoles("admin","user");
//        subject.logout();
//        logger.info("subject.isAuthenticated()="+subject.isAuthenticated());
    }
}
