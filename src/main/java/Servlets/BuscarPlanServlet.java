/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.PlanEntrenamientoDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.PlanEntrenamientos;

/**
 *
 * @author chemi
 */
@WebServlet(name = "BuscarPlanServlet", urlPatterns = {"/BuscarPlanServlet"})
public class BuscarPlanServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         String palabra=request.getParameter("palabra");
          String dias=request.getParameter("dias");
           String valoracion=request.getParameter("valoracion");
        /*try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>"+palabra+"  "+dias+"  "+valoracion);
            
        }*/
        ArrayList<PlanEntrenamientos> planes=PlanEntrenamientoDB.buscarSimilares(palabra,dias,valoracion);
    
    /*try (PrintWriter out = response.getWriter()) {
            
            PlanEntrenamientos plan=planes.get(0);
            out.println(plan.getDuracion()+"  "+plan.getNombre());
            
        }*/
    
     request.setAttribute("planes", planes);
    
            RequestDispatcher view = request.getRequestDispatcher("buscarPlanResultados.jsp");
            view.forward(request, response);
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
