<%@page import="java.util.ArrayList"%>
<%
    // verifica si existe la coleccion en el objeto session
    if(session.getAttribute("lista") == null){
    //inicilaizar la lista 
    
    ArrayList<String> lis = new ArrayList<String>();
    // creando un atributo con una coleccion vacia 
    session.setAttribute("lista", lis);
    }
    
    //se obtiene la coleccion lista qe esta como atributo de session
    ArrayList<String> lista = (ArrayList<String>)session.getAttribute("lista");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrito de compras</h1>
        <p>Inserte los productos que desea</p>
        <form action="ProcesaServlet" method="post">
            producto : <input type="text" name="producto">
            <input type="submit" value="Enviar">
                              
        </form ><br><br>
        <a href="ProcesaServlet">Vaciar el Carrito</a>
        <h3>Contenido del carrito : </h3>
        <ul>
            <%
                if(lista !=null){
                    for(String item : lista){
                        out.print("<li>"+item+"</li>");
                }
                }
            %>
                
        </ul>
    </body>
</html>
