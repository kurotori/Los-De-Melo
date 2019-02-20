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
    private String baseDatos = "jdbc:mysql://localhost/test";
    
    
    public void chequearConexion() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            coneccion = DriverManager.getConnection(baseDatos+opcMSQL,usuario,passwd);
            sentencia = coneccion.createStatement();
            resultado=sentencia.executeQuery("select version()");
            while(resultado.next()){
                System.out.println("-->"+resultado.getString(1));
                        }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
}
