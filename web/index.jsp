<%-- 
    Document   : index
    Created on : 20/09/2021, 19:40:07
    Author     : gvosc
--%>

<%@page import="modelo.Productos"%>
<%@page import="modelo.Marcas"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products Form</title>
        <link href="style.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body class="body">
        <h1 style="text-align: center;">Productos</h1>
        <div class="container">
            <div class="container-form">
                <form action="SrProductos" method="post" class="form-group">
                    <label for="lblProducto"><b>Producto</b></label>
                    <input type="text" name="txtProducto" id="txtProducto" class="form-control" placeholder="Nombre del Producto">
                    <label for="lblIdMarca"><b>idMarca</b></label>
                    <select name="dropMarcas" id="dropMarcas" class="form-control">
                        <%
                            Marcas marca = new Marcas();
                            HashMap<String,String> drop = marca.dropSangre();
                            for(String i: drop.keySet()) {
                                out.println("<option value='" + i + "' >" + drop.get(i) + "</option>");
                            }
                        %>
                    </select>

                    <label for="lblDescripcion"><b>Descripcion</b></label>
                    <input type="text" name="txtDescripcion" id="txtDescripcion" class="form-control" placeholder="Descripción">
                    <label for="lblPrecioCosto"><b>PrecioCosto</b></label>
                    <input type="text" name="txtPrecioCosto" id="txtPrecioCosto" class="form-control" placeholder="Precio de Compra">
                    <label for="lblPrecioVenta"><b>PrecioVenta</b></label>
                    <input type="text" name="txtPrecioVenta" id="txtPrecioVenta" class="form-control" placeholder="Precio de Venta">
                    <label for="lblExistencia"><b>Existencias</b></label>
                    <input type="text" name="txtExistencia" id="txtExistencia" class="form-control" placeholder="Cantidad en Existencias">
                    <br>
                    <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary btn-lg">Agregar</button>
                </form>
            </div>
            <div class="container-table">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>idMarca</th>
                            <th>Descripcion</th>
                            <th>PrecioCosto</th>
                            <th>PrecioVenta</th>
                            <th>Existencias</th>
                        </tr>
                    </thead>
                    <tbody id="tblProductos">
                        <%
             Productos producto = new Productos();
             DefaultTableModel tabla = new DefaultTableModel();
             tabla = producto.leer();
             for (int t=0;t <tabla.getRowCount();t++){
                 out.println("<tr>");
                 out.println("<td>"+ tabla.getValueAt(t, 1)+"</td>");
                 out.println("<td>"+ tabla.getValueAt(t, 2)+"</td>");
                 out.println("<td>"+ tabla.getValueAt(t, 3)+"</td>");
                 out.println("<td>"+ tabla.getValueAt(t, 4)+"</td>");
                 out.println("<td>"+ tabla.getValueAt(t, 5)+"</td>");
                 out.println("<td>"+ tabla.getValueAt(t, 6)+"</td>");
             
                 out.println("</tr>");
             }
        
                        %>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
