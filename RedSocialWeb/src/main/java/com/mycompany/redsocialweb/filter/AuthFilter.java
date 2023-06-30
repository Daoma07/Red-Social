/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redsocialweb.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    private static String[] pathsPublicos = {"login.jsp", "login", "resources/css/login.css", "register.jap", "resources/css/register.css"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = this.getPathSolicitado(httpRequest);
        boolean isPatchPrivado = this.isPathPrivado(path);
        boolean isUsuarioLogeado = this.isUsuarioLoegeado(httpRequest);
        if (isPatchPrivado && !isUsuarioLogeado) {
            request.getServletContext().
                    getRequestDispatcher("/login.jsp").
                    forward(request, response);
            return;
        }
        //avanza normalmente
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    private String getPathSolicitado(HttpServletRequest request) {
        String uriSolicitada = request.getRequestURI();
        String path = uriSolicitada.substring(request.getContextPath().length());
        return path;
    }

    private boolean isPathPrivado(String path) {
        for (String pathPublico : AuthFilter.pathsPublicos) {
            if (path.startsWith("/" + pathPublico)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUsuarioLoegeado(HttpServletRequest request) {
        // el false es para no crear la sesion
        HttpSession sesion = request.getSession(false);
        return (sesion != null && sesion.getAttribute("usuario") != null);

    }

}
