package org.global.designsoftware.patterns.properties_lab;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {


    /*
    * this filter will be created as bean in spring context
    * and  dynamically will be applied to every request.
    * Spring automatically detect this component and ad in context as Servlet Filter
    * */
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String clientAddress  = ((HttpServletRequest) servletRequest).getRemoteAddr();
        if (clientAddress.equals("0:0:0:0:0:0:0:1")){
            httpRequest.setAttribute("role", "admin");
            System.out.println("Role admin is set!!!!");
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
