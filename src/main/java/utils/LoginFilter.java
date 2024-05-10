package utils;

import Service.impl.LoginServiceImpl;
import Service.impl.LoginServiceSessionImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/vehicles"})
// @WebFilter({"/vehicles", "/User", "subject"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginServiceImpl service = new LoginServiceImpl();
        Optional<String> username = service.getusername((HttpServletRequest)
                request);
        if(username.isPresent()){
            chain.doFilter(request, response);
        } else{
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "No estás autorizado para ingresar a esta página!");
        }
    }


}