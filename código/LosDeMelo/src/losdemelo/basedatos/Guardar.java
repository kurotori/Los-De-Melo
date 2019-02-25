/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import losdemelo.basedatos.Acceso;
import losdemelo.misc.Herramientas;

/**
 * Esta clase contiene los métodos necesarios para guardar datos de forma 
 * genérica en la base de datos.
 * @author Sebastian de los Ángeles
 */
public class Guardar {
    Acceso acceso = new Acceso();
    Herramientas herramientas = new Herramientas();
    
    
    /**
     * Permite almacenar un conjunto de datos en los campos de una tabla 
     * específica en una base de datos.
     * @param base La base de datos en la que se encuentra la tabla.
     * @param tabla La tabla donde se guardarán los datos.
     * @param campos Los campos de dicha tabla.
     * @param datos Los datos a guardar.
     * @return El mensaje del servidor tras ejecutarse la consulta o un detalle
     * de error tomado de la excepción.
     * @throws Exception 
     */
    public String guardarDatosEnTabla(  String base,
                                        String tabla, 
                                        String[] campos, 
                                        String[] datos ) throws Exception{
        String respServidor="";
        String listaCampos=herramientas.recorrerListaCampos(campos);
        String listaDatos=herramientas.recorrerListaDatos(datos);
        String sql="INSERT INTO "+tabla+"("+listaCampos+") VALUES("+
                listaDatos+")";
        //System.out.println(sql);
        try{
            Connection conexion = acceso.CrearConexionABase(base);
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            respServidor = "OK";
            conexion.close();
        }
        catch(Exception e){
            respServidor=e.getMessage().toString();
        }
        //System.out.println(respServidor);
        return respServidor;
    }
}
