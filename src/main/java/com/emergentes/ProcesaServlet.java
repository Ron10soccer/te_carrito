
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtener acceso al obejteo session 
        HttpSession ses = request.getSession();
        //se elimina la session
        ses.invalidate();
        //metodo que nos permite saltar a otro recurso
        //trasnfiere el control a inde.jsp
        response.sendRedirect("index.jsp");
        }
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          //recupera el producto enviado desde formulario
            String producto = request.getParameter("producto");
            // se obtiene el acceso ala session
            HttpSession ses = request.getSession();
            // se obtiene la lista que esta como  atributo de session
            ArrayList<String> lista = (ArrayList<String>)ses.getAttribute("lista");
            // A la coleccion se adiciona el elmento producto
            lista.add(producto);
            //se redirecciona a index.jsp
            response.sendRedirect("index.jsp");
            }
    

}
