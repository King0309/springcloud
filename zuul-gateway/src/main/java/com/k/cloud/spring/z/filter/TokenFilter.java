package com.k.cloud.spring.z.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {//过滤器的类型
        return "pre";
    }

    @Override
    public int filterOrder() {//过滤器执行的顺序 一个请求在同一个阶段存在多个过滤器时候，多个过滤器执行顺序问题
        return 0;
    }

    @Override
    public boolean shouldFilter() {//判断过滤器是否生效
        return true;
    }

    @Override
    public Object run() throws ZuulException {//编写顾虑器拦截业务逻辑代码
        // 案例：拦截所有都服务接口，判断服务接口上是否有传递userToekn参数
        //获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //验证token时候 token的参数 从请求头获取
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)) {
            //返回错误提示
            currentContext.setSendZuulResponse(false);  //false  不会继续往下执行 不会调用服务接口了 网关直接响应给客户了
            currentContext.setResponseBody("no no no  you have not userToken");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        //否则正常执行 调用服务接口...
        return null;
    }

}
