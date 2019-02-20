/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.basedatos;

import java.sql.*;


/**
 *
 * @author Sebastian
 */
public class Acceso {
    private Connection coneccion = null;
    private Statement sentencia = null;
    private PreparedStatement sentenciaPreparada = null;
    private ResultSet resultado = null;
    private String usuario = "losdemelo";
    private String passwd = "zevGfk297yDr5Ebj";
    private String opcMSQL = "?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String servidor = "jdbc:mysql://localhost";

    /**
     * Permite obtener el nombre de usuario para acceder a la base de datos
     * @return un String con el nombre de usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Permite obtener la contraseña para acceder a la base de datos
     * @return un String con la contraseña
     */
    public String getPasswd() {
        return passwd;
    }
    
    /**
     * Permite obtener las opciones de configuración extras para la conexión al 
     * servidor. Estas opciones se deben concatenar al URL del servidor.
     * 
     * @return un String con las opciones de configuración del servidor.
     */
    public String getOpcMSQL() {
        return opcMSQL;
    }

    /**
     * Permite obtener la url por descarte del servidor de bases de datos.
     * @return un String con la url del servidor de bases de datos.
     */
    public String getServidor() {
        return servidor;
    }
    
    /**
     * Crea un objeto de conexión hacia la base de datos
     * @return un objeto de tipo Connection
     * @throws Exception en caso de no encontrar el driver apropiado
     */
    public Connection CrearConexion() throws Exception{
        Connection resultado = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        resultado = DriverManager.getConnection(servidor+opcMSQL,usuario,passwd);
        return resultado;
    }
        
    public Connection CrearConexionABase(String base) throws Exception{
        Connection resultado = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        resultado = DriverManager.getConnection(servidor+"/"+base+opcMSQL,usuario,passwd);
        return resultado;
    }
    
    
    
    /**
     * Es un método que tiene el propósito de confirmar que se puede establecer
     * una conexión a la base de datos.
     * 
     * @return Un String con la versión actual del motro de la base de datos.
     * @throws Exception 
     */
    public String chequearConexion() throws Exception{
        String salida = "";
        try{
            coneccion = CrearConexion();
            sentencia = coneccion.createStatement();
            resultado=sentencia.executeQuery("select version()");
            while(resultado.next()){
                salida=resultado.getString(1);
                        }
        }
        catch(Exception e){
            salida = e.toString();
        }
        
        return salida;
    }
    
    
    
    
    
}
