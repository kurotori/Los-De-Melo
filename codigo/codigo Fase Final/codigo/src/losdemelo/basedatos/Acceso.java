/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.basedatos;

import java.sql.*;
import java.io.File;
import org.ini4j.*;

/**
 * Contiene métodos para facilitar la creación y el chequeo de una conexión a la 
 * base de datos.
 * @author Sebastian de los Ángeles
 */
public class Acceso {
    private Connection coneccion = null;
    private Statement sentencia = null;
    private PreparedStatement sentenciaPreparada = null;
    private ResultSet resultado = null;
    public String base = "systurno";
    private String usuario = "losdemelo";
    private String passwd = "zevGfk297yDr5Ebj";
    private String opcMSQL = "?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-3";
    private String servidor = "jdbc:mysql://localhost";

    /**
     * Permite obtener el nombre de usuario para acceder a la base de datos
     * @return un String con el nombre de usuario
     */
    public Acceso(){
        String URLArchivo="systurno.ini";
        try{
            Wini ini = new Wini(new File(URLArchivo));
            String servidorIni =  ini.get("mysql","servidor");
            servidor = "jdbc:mysql://"+servidorIni;
            System.out.println(servidor);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
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
     * A ver si esta porqueria aparece.
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
     * Permite establecer el URL del servidor de bases de datos
     * @param servidor URL del servidor donde se aloja la base de datos
     */
    public void setServidor(String servidor) {
        String baseURL = "jdbc:mysql://";
        this.servidor = baseURL+servidor;
    }
    
    
    
    /**
     * Crea un objeto de conexión hacia el servidor
     * @return un objeto de tipo Connection con los parámetros del servidor
     * @throws Exception en caso de no encontrar el driver apropiado
     */
    public Connection CrearConexion() throws Exception{
        Connection resultado = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        resultado = DriverManager.getConnection(servidor+opcMSQL,usuario,passwd);
        return resultado;
    }
        /**
         * Crea un objeto de conexión hacia la base de datos
         * @param base El nombre de la base de datos
         * @return
         * @throws Exception 
         */
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
     * @return Un String con la versión actual del motor de la base de datos.
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

    /**
     *
     * @param cosa
     */
    public void porqueria( String cosa){
        
    }
}
