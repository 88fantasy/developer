package org.exframework.business.developer.portal.service;


import com.usthe.sureness.mgt.SurenessSecurityManager;
import com.usthe.sureness.processor.exception.*;
import com.usthe.sureness.subject.SubjectSum;
import org.exframework.business.developer.portal.entity.User;
import org.exframework.business.developer.portal.exception.ForbiddenException;
import org.exframework.business.developer.portal.exception.NeedLoginException;
import org.exframework.support.rest.exception.ServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rwe
 * @version 创建时间：2021年4月19日 下午11:08:41 登录业务实现类
 */

@Service
public class DeveloperLoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpServletRequest request;

    @Autowired
    AdminUserService accountService;

    public User currentPerson() throws NeedLoginException, ForbiddenException {
        try {
            SubjectSum subject = SurenessSecurityManager.getInstance().checkIn(request);
            // You can consider using SurenessContextHolder to bind subject in threadLocal
            if (subject != null) {
                return accountService.loadAccount((String) subject.getPrincipal());
            }
        } catch (ProcessorNotFoundException | UnknownAccountException | UnsupportedSubjectException e4) {
            logger.debug("this request is illegal");
            throw new ServerException(e4.getMessage());
        } catch (DisabledAccountException | ExcessiveAttemptsException e2) {
            logger.debug("the account is disabled");
            throw new NeedLoginException("帐号已被禁用");
        } catch (IncorrectCredentialsException | ExpiredCredentialsException e3) {
            logger.debug("this account credential is incorrect or expired");
            throw new NeedLoginException("帐号已过期");
        } catch (UnauthorizedException e5) {
            logger.debug("this account can not access this resource");
            throw new ForbiddenException(e5);
        } catch (RuntimeException e) {
            logger.error("other exception happen: ", e);
            throw new ServerException(e.getMessage());
        }

        throw new ServerException();
    }

}
