package view;

import Service.impl.RepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vehicle;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/findVehicle")
public class FindVehicle extends HttpServlet {
    private static RepositoryImpl service;

    public void init() throws ServletException {
        service = new RepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            req.getRequestDispatcher("/findVehicle.jsp").forward(req, resp);
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Optional<Vehicle> vehicle = service.byId(id);
            if (!vehicle.isPresent()) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Vehicle not found");
            } else {
                resp.setContentType("application/json");
                resp.getWriter().write(vehicle.get().toString());
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Vehicle ID format");
        }
    }
}

