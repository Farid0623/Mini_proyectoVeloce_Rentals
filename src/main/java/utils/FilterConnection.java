package utils;


import database.DatabaseConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class FilterConnection implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Método de inicialización del filtro, puede ser utilizado para realizar configuraciones iniciales
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try (Connection conn = (Connection) DatabaseConnection.getInstance()) {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            try {
                servletRequest.setAttribute("conn", conn);
                filterChain.doFilter(servletRequest, servletResponse);
                conn.commit();
            } catch (SQLException | ServiceExceptionJdbc e) {
                conn.rollback();
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        // Método de destrucción del filtro, puede ser utilizado para realizar limpieza de recursos
    }
}