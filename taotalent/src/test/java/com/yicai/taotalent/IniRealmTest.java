package com.yicai.taotalent;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by RamboLi
 * Date 2018/5/10 0010
 * Time 1:02
 */
public class IniRealmTest {
    private final static Logger logger = LoggerFactory.getLogger(AuthenticationTest.class);
    @Test
    public void testAuthentication(){
        IniRealm iniRealm = new IniRealm("classpath:user.ini");
        //1、构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);
        //2、主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("liyongsheng2","123456");
        subject.login(usernamePasswordToken);

        logger.info("subject.isAuthenticated()="+subject.isAuthenticated());

        subject.checkRoles("admin","user");
        subject.checkPermission("user:update");
//        subject.checkRoles("admin","user");
//        subject.logout();
//        logger.info("subject.isAuthenticated()="+subject.isAuthenticated());
    }
}
