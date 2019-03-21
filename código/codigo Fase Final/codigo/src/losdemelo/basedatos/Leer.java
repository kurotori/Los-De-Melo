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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
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
     
    /**
     * Permite obtener un dato concreto de una tabla. Es un método pensado para
     * consultas que deben devolver un solo registro de un solo campo.
     * @param base La base de datos donde se encuentra la tabla
     * @param tabla La tabla donde se encuentran los datos
     * @param campo El campo puntual que se quiere consultar.
     * @param condicion La condición WHERE de la consulta
     * @return Un String con el resultado de la consulta
     */
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
    
    /**
     * @deprecated No Funcional. Se incluyó en otro método para permitir funcionalidad.
     * @param base
     * @return 
     */
    public int verIdUltimoRegistro(String base){
        int id = 0;
        Connection conexion = null;
        String consulta = "SELECT LAST_INSERT_ID();";
        try{
            conexion  = acceso.CrearConexionABase(base);
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id=rs.getInt(1);
            }

            conexion.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage().toString());
        }
        
        return id;
    }
    
    public DefaultTableModel listaMedicamentosRecetados(
                                       String base, 
                                       String CI,
                                       boolean retirados
                                       ){
        
        DefaultTableModel resultado;
        resultado = new DefaultTableModel();
        
        int est_retirado = 0;
        if(retirados){
            est_retirado=1;
        }

        
        String consulta = ""+
        "SELECT "+ 
         "(SELECT concat_ws(',',medicamentos.Nombre,medicamentos.presentacion) "+
	"FROM medicamentos WHERE medicamentos.id = contiene.medicamentos_ID) "+
                 "AS Medicamento,"+
         "contiene.cantidad "+
                 "AS Cantidad, "+
         "(SELECT medicamentos.stock  FROM medicamentos "+
         "WHERE medicamentos.id = contiene.medicamentos_ID) "+
                 "AS Disponibilidad "+
         "FROM contiene INNER JOIN recibe "+
         "WHERE recibe.Usuarios_CI = ? AND "+
         "contiene.entregado = ? AND "+
         "contiene.recetas_ID = recibe.recetas_ID";
        
        try{
            Connection conexion = acceso.CrearConexionABase(base);
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, CI);
            ps.setInt(2, est_retirado);
            ResultSet rs = ps.executeQuery();
            
            int numColumnas = rs.getMetaData().getColumnCount();
            Object[] nomColumnas = new Object[numColumnas];
            
            for(int i = 0; i < numColumnas; i++){
	        	nomColumnas[i] = rs.getMetaData().getColumnLabel(i + 1);
	        }
            
            resultado.setColumnIdentifiers(nomColumnas);
            
            
            while(rs.next()){
                Object[] fila = new Object[numColumnas];
                for(int i=0;i<numColumnas-1;i++){
                    fila[i]=rs.getObject(i+1);
	        	}
                int disp = rs.getInt(3)-rs.getInt(2);
                if(disp < 0){
                    fila[2]="NO DISPONIBLE";
                }
                else{
                    fila[2]="DISPONIBLE";
                }
                
                resultado.addRow(fila);
            }
            conexion.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    
    public String[] BuscarTurnoDisponible(){
        String[] resultado = new String[3];
        String base = "systurno";
        Connection conexion;
        String consulta = ""
                + "SELECT `ID`,`fechahora` "
                + "FROM `turnos` "
                + "WHERE estado = 'abierto' "
                + "ORDER BY fechahora ASC LIMIT 1";
        
        try{
            conexion = acceso.CrearConexionABase(base);
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                resultado[0]=rs.getString(1);
                resultado[1]=rs.getDate(2).toString();
                resultado[2]=rs.getTime(2).toString();
            }
            System.out.println("T:"+resultado[0]+" D:"+resultado[1]+" H:"+resultado[2]+"");
            rs.close();
            conexion.close();
        }
        catch(Exception ex){
            
        }
            
        return resultado;
    }
    
}
