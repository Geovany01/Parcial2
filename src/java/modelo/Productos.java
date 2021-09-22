
package modelo;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Productos {
    private int idProducto, idMarca, existencia;
    private String producto, descripcion;
    private double precioCosto, precioVenta;
    Conexion nuevaConexion;

    public Productos() {
        
    }
    
    public Productos(int idProducto, int idMarca, int existencia, String producto, String descripcion, double precioCosto, double precioVenta) {
        this.idProducto = idProducto;
        this.idMarca = idMarca;
        this.existencia = existencia;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public DefaultTableModel leer() {
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            nuevaConexion = new Conexion();
            String query = "SELECT * FROM db_parcial2.productos;";
            nuevaConexion.abrirConexion();
            ResultSet consulta = nuevaConexion.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id", "Producto", "idMarca", "Descripcion", "Precio Costo", "Precio Venta", "Existencia"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[7];
            while(consulta.next()) {
                datos[0] = consulta.getString("id_producto");
            datos[1] = consulta.getString("producto");
            datos[2] = consulta.getString("id_marca");
            datos[3] = consulta.getString("descripcion");
            datos[4] = consulta.getString("precio_costo");
            datos[5] = consulta.getString("precio_venta");
            datos[6] = consulta.getString("existencia");
                tabla.addRow(datos);
            }
            nuevaConexion.cerrarConexion();
        } catch(Exception ex) {
            System.out.println("Exception = " + ex.getMessage());
        }
        return tabla;
    }
    
    public int agregar() {
        int retorno = 0;
        try {
            PreparedStatement parametro;
            String query;
            nuevaConexion = new Conexion();
            nuevaConexion.abrirConexion();
            query = "INSERT INTO productos(id_producto, producto, id_marca, descripcion,"
                    + "precio_costo, precio_venta, existencia) VALUES(?,?,?,?,?,?,?);";
            parametro = (PreparedStatement) nuevaConexion.conexionBD.prepareStatement(query);
            parametro.setInt(1, getIdProducto());
            parametro.setString(2, getProducto());
            parametro.setInt(3, getIdMarca());
            parametro.setString(4, getDescripcion());
            parametro.setDouble(5, getPrecioCosto());
            parametro.setDouble(6, getPrecioVenta());
            parametro.setInt(7, getExistencia());
            retorno = parametro.executeUpdate();
            nuevaConexion.cerrarConexion();
            /*JOptionPane.showMessageDialog(null, Integer.toString(exec) 
                    + " Registros Ingresados", "Mensaje", JOptionPane.INFORMATION_MESSAGE);*/

        } catch (HeadlessException | SQLException ex) {
            System.out.println("Error..." + ex.getMessage());
        }
        return retorno;
    }
    
}
