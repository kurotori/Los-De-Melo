/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    String base = "systurno";
    
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
            //System.out.println("Error de conexion");
            respServidor="Error de conexion: "+e.getMessage().toString();
        }
        System.out.println(respServidor);
        return respServidor;
    }
    
    /**
     * Permite guardar un dato en una tabla con ID autoincremental y recuperar
     * la ID del registro ingresado en la misma
     * @param base La base de datos de la tabla
     * @param tabla La tabla en la que se genera el registro
     * @param campos Un array de tipo String con los nombres de los campos a usar
     * @param datos Un array de tipo String con los datos a guardar
     * @return Un String con la respuesta del servidor en caso de error
     * @throws Exception
     */
    public int guardarDatosEnTablaVerID(  String base,
                                        String tabla, 
                                        String[] campos, 
                                        String[] datos ) throws Exception{
        int resultado=0;
        String respServidor="";
        String listaCampos=herramientas.recorrerListaCampos(campos);
        String listaDatos=herramientas.recorrerListaDatos(datos);
        String sql="INSERT INTO "+tabla+"("+listaCampos+") VALUES("+
                listaDatos+")";
        //System.out.println(sql);
        try{
            Connection conexion = acceso.CrearConexionABase(base);
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            
            //Statement sentencia = conexion.createStatement();
            //sentencia.executeUpdate(sql);
            
            ps = conexion.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                resultado=rs.getInt(1);
            }
            
            respServidor = "OK";
            conexion.close();
        }
        catch(Exception e){
            //System.out.println("Error de conexion");
            respServidor="Error de conexion: "+e.getMessage().toString();
        }
        System.out.println(respServidor);
        return resultado;
    }
    
    public String reservarTurno(String numTurno, String CI, String idReceta) throws Exception{
        String resultado;
        
        Connection conexion;
        
        String sql_1 = ""
                + "UPDATE turnos "
                + "SET turnos.estado = 'confirmado' "
                + "WHERE turnos.ID = ?";
        String sql_2 = ""
                + "INSERT INTO asociado "
                + "(asociado.turnos_ID, asociado.recetas_ID) "
                + "VALUES (?,?)";
        String sql_3 = ""
                + "INSERT INTO genera "
                + "(genera.CI_usuario, genera.ID_turno) " 
                + " VALUES (?,?)";
        
        try{
            conexion = acceso.CrearConexionABase(this.base);
            PreparedStatement ps;
                        
            ps = conexion.prepareStatement(sql_2);
            ps.setString(1, numTurno);
            ps.setString(2, idReceta);
            ps.executeUpdate();
            System.out.println("Insert into asociado");
            
            ps = conexion.prepareStatement(sql_3);
            ps.setString(1, CI);
            ps.setString(2, numTurno);
            ps.executeUpdate();
            System.out.println("Insert into genera");
            
            ps = conexion.prepareStatement(sql_1);
            ps.setString(1, numTurno);
            ps.executeUpdate();
            System.out.println("Update turnos");
            
            resultado="Consulta registrada para "+CI+" turno:"+numTurno+" receta:"+idReceta;
            
        }
        catch(Exception ex){
            resultado = "Error de reserva: "+ex.getMessage();
        }
        
        System.out.println(resultado);
        return resultado;
    }
    
}
