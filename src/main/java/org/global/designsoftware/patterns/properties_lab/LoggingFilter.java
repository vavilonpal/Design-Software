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

        httpRequest.setAttribute("StartTime", System.currentTimeMillis());

        filterChain.doFilter(servletRequest, servletResponse);


        long startTime = (long) httpRequest.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Request took " + duration + "ms");

    }
}
