/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redsocialweb;

import com.mycompany.redsocialweb.Exception.NegocioException;
import com.mycompany.redsocialweb.factory.FabricaBO;
import com.mycompany.redsocialweb.factory.IFabricaBO;
import com.mycompany.redsocialweb.interfaces.IUsuarioBO;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "Login", urlPatterns = {"/login"}, initParams = {
    @WebInitParam(name = "Name", value = "Value")})
public class Login extends HttpServlet {

    IUsuarioBO usuarioBO;

    public Login() {
        IFabricaBO fabricaBO = new FabricaBO();
        this.usuarioBO = fabricaBO.crearUsuarioBO();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //aqui se  valdia se existe el usuario con la base de datos
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contrasenia");
        //solicitar inicio de sesion en las bo

        Usuario usuarioValidado;
        try {
            usuarioValidado = usuarioBO.buscarUsuarioPorCredenciales(correo, contraseña);
            if (usuarioValidado != null) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", usuarioValidado);
                getServletContext().getRequestDispatcher("/index.html")
                        .forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/register.jsp")
                        .forward(request, response);
            }
        } catch (NegocioException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //cerrar sesion
    protected void processLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        getServletContext().getRequestDispatcher("/login.jsp")
                .forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("login")) {
            processLogin(request, response);
            return;
        } else if (action != null && action.equalsIgnoreCase("logout")) {
            processLogout(request, response);
            return;
        }

        processLogin(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
