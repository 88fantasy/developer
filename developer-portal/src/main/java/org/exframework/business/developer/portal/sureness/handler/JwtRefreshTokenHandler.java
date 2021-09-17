package org.exframework.business.developer.portal.sureness.handler;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.usthe.sureness.handler.SuccessHandler;
import com.usthe.sureness.subject.Subject;
import com.usthe.sureness.subject.SubjectSum;
import com.usthe.sureness.subject.creater.JwtSubjectServletCreator;
import com.usthe.sureness.util.JsonWebTokenUtil;
import io.jsonwebtoken.Claims;
import org.exframework.business.developer.portal.service.AdminUserService;
import org.exframework.support.common.util.SpringContextUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 更新 token 处理
 *
 * @author rwe
 * @date 2021/9/17 14:13
 **/

public class JwtRefreshTokenHandler implements SuccessHandler {

    private long expired;

    public JwtRefreshTokenHandler(long expired) {
        this.expired = expired;
    }

    @Override
    public void processHandler(SubjectSum subjectSum, Object o) {
        String account = (String) subjectSum.getPrincipal();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) o;
        HttpServletResponse response = servletRequestAttributes.getResponse();
        Subject subject = new JwtSubjectServletCreator().createSubject(o);
        Claims claims = JsonWebTokenUtil.parseJwt((String) subject.getCredential());
        Date exp = claims.getExpiration();
        long between = DateUtil.between(DateUtil.date(), exp, DateUnit.SECOND, true);
        if (between < 600) {
            AdminUserService userService = SpringContextUtils.getBeanByClass(AdminUserService.class);
            response.setHeader("refresh-token", userService.token(account, expired));
        }
    }
}
