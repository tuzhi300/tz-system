package net.kuper.tz.system.auth;

import net.kuper.tz.core.controller.ResCode;
import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.properties.TransportProperties;
import net.kuper.tz.core.utils.ShiroUtils;
import net.kuper.tz.core.utils.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * oauth2过滤器
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 13:00
 */
public class OAuth2Filter extends FormAuthenticationFilter {

    private TransportProperties transportProperties;

    public void setTransportProperties(TransportProperties transportProperties) {
        this.transportProperties = transportProperties;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        //获取请求token
        String token = getRequestToken((HttpServletRequest) request);
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        return new OAuth2Token(token);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        ShiroUtils.getSession().setTimeout(900000);
        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String token = getRequestToken((HttpServletRequest) request);
        if (!ShiroUtils.isLogin() && !StringUtils.isEmpty(token)) {
            OAuth2Token oAuth2Token = new OAuth2Token(token);
            Subject subject = this.getSubject(request, response);
            subject.login(oAuth2Token);
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        throw new ApiException(ResCode.ERROR_SYS_AUTH_UNLOGIN);
//        return super.onLoginFailure(token, e, request, response);
    }

    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest) {
        //从header中获取token
        String tokenKey = transportProperties.getReqHeaderTokenKey();
        String token = httpRequest.getHeader(tokenKey);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isEmpty(token)) {
            token = httpRequest.getParameter(tokenKey);
        }
        return token;
    }


}
