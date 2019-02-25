/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.basedatos;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import losdemelo.basedatos.Acceso;
import losdemelo.misc.Herramientas;

/**
 * Contiene métodos para obtener los resultados de la Base de Datos de
 * diferentes formas
 * @author Sebastian de los Ángeles
 */
public class Leer {
    
    Acceso acceso = new Acceso();
    Herramientas herramientas =  new Herramientas();
    
    /**
     * Permite obtener los datos de la tabla como una matriz de tipo ArrayList
     * @param base String conteniendo el nombre de la base de datos
     * @param tabla Tabla de donde se quiere obtener los datos
     * @param campos Arreglo con los campos que se quieren mostrar en el resultado
     * @param condicion condición WHERE de la consulta
     * @return 
     */
    public ArrayList<ArrayList<String>> leerDatosDeTabla(
                            String base, 
                            String tabla, 
                            String[] campos, 
                            String condicion) {
        //Creo una matriz de ArrayList para almacenar el resultado
        ArrayList<ArrayList<String>> respuesta = new ArrayList<ArrayList<String>>();
        
        String listaCampos=herramientas.recorrerListaCampos(campos);
        String consulta = "SELECT "+listaCampos+  " FROM "+tabla+" WHERE "+condicion;

        try{
            Connection conexion  = acceso.CrearConexionABase(base);
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            //Obtengo el número de columnas del resultado
            int columnas = rs.getMetaData().getColumnCount();
            //System.out.println("---->>"+columnas);
            //Agrego esas columnas a la matriz de respuesta
            for(int i=1; i<=columnas;i++){
                //Creo un ArrayList para cada columna de datos
                ArrayList<String> columna = new ArrayList<>();
                //Le agrego el nombre de la columna como primer dato
                columna.add(rs.getMetaData().getColumnName(i));
                
                //Agrego esa columna a la matriz
                respuesta.add(columna);
            }
            
            while(rs.next()){
                for(int i=0; i<columnas;i++){
                    
                    respuesta.get(i).add(rs.getString(i+1));
                }
            }
            conexion.close();
        }
        catch(Exception e){
            System.out.println(
            e.getMessage().toString());
        }
        
        return respuesta;
    }
    
    /**
     * Permite mostrar los datos de un resultset. Solo funciona dentro del 
     * try/catch de acceso a la Base de Datos
     * @param rs El objeto ResultSet que devuelve la consulta.
     * @throws SQLException 
     */
    private void mostrarResultados(ResultSet rs) throws SQLException{
        String resultado="";
        try{
            int columnas = rs.getMetaData().getColumnCount();
            //System.out.println("---->>"+columnas);
            for(int i=1; i<=columnas; i++){
                resultado=resultado+rs.getMetaData().getColumnName(i)+"--";
                }
            System.out.println(resultado);
            while(rs.next()){
                String linea="";
                for(int i=1; i<=columnas; i++){
                    linea= linea+rs.getString(i)+"--";
                }
                System.out.println(linea);
                linea="";
            }
            
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage().toString());
        }
        
    }
    
    /**
     * Permite mostrar en la consola el resultado contenido en una matriz de ArrayList
     * incluyendo los contenidos del encabezado (o 'header')
     * @param resultado La matriz de ArrayList con el resultad de la consulta
     */
    public void mostrarResultadosConH(ArrayList<ArrayList<String>> resultado){
        int columnas = resultado.size();
        
        int filas = resultado.get(0).size();
     
        String linea="";
        for(int f=0;f<filas;f++){
            for(int c = 0; c<columnas;c++){
                linea=linea+resultado.get(c).get(f)+"\t";
            }
            System.out.println(linea);
            linea="";
        }
    }
    
    /**
     * Permite mostrar en la consola el resultado contenido en una matriz de ArrayList
     * sin incluír los contenidos del encabezado (o 'header')
     * @param resultado 
     */
    public void mostrarResultadosSinH(ArrayList<ArrayList<String>> resultado){
        int columnas = resultado.size();
        
        int filas = resultado.get(0).size();
     
        String linea="";
        for(int f=1;f<filas;f++){
            for(int c = 0; c<columnas;c++){
                linea=linea+resultado.get(c).get(f)+"\t";
            }
            System.out.println(linea);
            linea="";
        }
    }
    
    /**
     * Devuelve el conteo de registros de una tabla determinada basándose en una
     * condición
     * @param base La base de datos donde esta la información.
     * @param tabla La tabla que se desea consultar.
     * @param campo El campo según el cuál se realizará el conteo. Se recomineda
     * que sea el campo primario de la tabla
     * @param condicion La condición WHERE de la consulta para realizar el conteo.
     * @return Un int con el valor de conteo obtenido.
     */
    public int contarDatosDeTabla(
                            String base, 
                            String tabla, 
                            String campo, 
                            String condicion) {
        int resultado = 0;
        //String listaCampos=herramientas.recorrerListaCampos(campos);
        String consulta = "SELECT COUNT("+campo+  ") FROM "+tabla+" WHERE "+condicion;
        try{
            Connection conexion  = acceso.CrearConexionABase(base);
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                resultado = rs.getInt(1);
            }
            
            conexion.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage().toString());
        }
        
        return resultado;
    }
     
    public String ver1dato1campo(
                            String base, 
                            String tabla, 
                            String campo, 
                            String condicion) {
        String resultado = "";
        
        String consulta = "SELECT "+campo+  " FROM "+tabla+" WHERE "+condicion;
        try{
            Connection conexion  = acceso.CrearConexionABase(base);
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                resultado=rs.getString(0);
            }
            
            conexion.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage().toString());
        }
        
        return resultado;
    }
    
}
