package org.example.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static final String USUARIO = "admin";
    private static final String CONTRASENIA = "password";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        ArrayList<String> mensajes = new ArrayList<>();

        if (usuario == null || usuario.isEmpty()) {
            mensajes.add("Por favor, ingrese un nombre de usuario.");
        }

        if (contrasenia == null || contrasenia.isEmpty()) {
            mensajes.add("Por favor, ingrese una contraseña.");
        }

        if (mensajes.isEmpty()) {
            if (usuario.equals(USUARIO) && contrasenia.equals(CONTRASENIA)) {
                request.getRequestDispatcher("/WEB-INF/exito.jsp").forward(request, response);
            } else {
                mensajes.add("Usuario o contraseña incorrectos.");
                request.setAttribute("mensajes", mensajes);
                request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mensajes", mensajes);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}