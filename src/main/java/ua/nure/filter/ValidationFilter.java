package ua.nure.filter;


import ua.nure.validator.PlayerValidator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import static ua.nure.util.Constants.*;

public class ValidationFilter implements Filter {

    private PlayerValidator validator = new PlayerValidator();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String option = request.getParameter(OPTION);
        if (option.equals(ADD) || option.equals(EDIT)) {
            if (validator.validate(request)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                throw new IllegalStateException();
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
    }
}
