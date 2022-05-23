package games.linkin.controller.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从客户端获取session,并判断是否有
        //1.获取session对象
        HttpSession session = request.getSession();
        //2.从session对象中获取值
        Object linkin = session.getAttribute("linkin");

        if (null != linkin){
            //登录了。放行
            System.out.println("成功放行");
            return true;
        }else{
            //没有登录。跳转登录页面，并且输出 “您尚登入，请登入”
            System.out.println("转跳");
            response.sendRedirect("/page/login.html");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
