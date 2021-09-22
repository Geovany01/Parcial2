
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Marcas {
    private int idMarca;
    private String marca;
    private Conexion nuevaConexion;

    public Marcas() {
        
    }

    public Marcas(int idMarca, String marca) {
        this.idMarca = idMarca;
        this.marca = marca;
    }

    public Conexion getNuevaConexion() {
        return nuevaConexion;
    }

    public void setNuevaConexion(Conexion nuevaConexion) {
        this.nuevaConexion = nuevaConexion;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
     public HashMap dropSangre() {
        HashMap<String, String> drop = new HashMap();
        try{
            String query = "SELECT id_marca as id, marca FROM marcas";
            nuevaConexion = new Conexion();
            nuevaConexion.abrirConexion();
            ResultSet consulta = nuevaConexion.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()) {
                drop.put(consulta.getString("id"), consulta.getString("marca"));
            }
            nuevaConexion.cerrarConexion();
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return drop;
    }
    
}
