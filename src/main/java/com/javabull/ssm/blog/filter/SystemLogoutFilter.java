package com.javabull.ssm.blog.filter;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SystemLogoutFilter extends LogoutFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        //这里获取出来的redirectUrl值为/
        String redirectUrl = getRedirectUrl(request, response, subject);
        //将redirectUrl 重新设置 /goto，到登入界面
        redirectUrl = "/goto";
        try {
            subject.logout();
        } catch (SessionException e) {
            e.printStackTrace();
        }
        issueRedirect(request, response, redirectUrl);
        return false;
    }
}
