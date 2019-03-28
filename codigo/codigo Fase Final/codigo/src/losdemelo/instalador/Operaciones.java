/*
 * Copyright (C) 2019 Sebastian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package losdemelo.instalador;

/**
 *
 * @author Sebastian
 */
import org.ini4j.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import losdemelo.basedatos.Acceso;

public class Operaciones {
    Consultas_instalador consultas = new Consultas_instalador();
    losdemelo.basedatos.Acceso acceso = new Acceso();
    public String URLArchivo="systurno.ini";
    
    public File crearArchivoIni(){
        File archivo=null;
        try{
            archivo = new File(URLArchivo);
            archivo.createNewFile();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return archivo;
    }
    
    public void escribirEnIni(File archivo,
                              String bloque, 
                              String clave, 
                              String dato 
                              ){
        try{
            Wini archivoIni = new Wini(archivo);
            archivoIni.put(bloque, clave, dato);
            archivoIni.store();
            
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
    }
    
    public void agregarTexto(JTextArea areaTexto, String texto){
        String textoActual = areaTexto.getText() + "\n";
        areaTexto.setText(textoActual + texto);
    }
    
    public Connection TestConexion(String servidor,
                                    String usuario,
                                    String passwd) throws Exception{
        String opcMSQL = "?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-3";
        Connection resultado = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        resultado = DriverManager.getConnection("jdbc:mysql://"+servidor+opcMSQL,usuario,passwd);
        return resultado;
    }
    
    public String comprobarServidor(String servidor,String usuario, String contrasenia){
        Connection conexion;
        String resultado = "";
        String sql = "SELECT version();";
        try{
            conexion = TestConexion(servidor,usuario,contrasenia);
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);
            resultado = "OK";
            conexion.close();
        }
        catch(Exception ex){
            resultado = ex.getMessage();
            System.err.println(ex.getMessage());
        }
        
        return resultado;
    }
    
    public Connection CrearConexionABase(String servidor,
                                         String base,
                                         String usuario,
                                         String passwd) throws Exception{
        String opcMSQL = "?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-3";
        Connection resultado = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        resultado = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+base+opcMSQL,usuario,passwd);
        return resultado;
    }
    
    public void crearBaseDeDatos(String servidor,String usuario, String contrasenia){
        Connection conexion;
        String sql = consultas.getSql_crear_base();
        try{
            conexion = TestConexion(servidor,usuario,contrasenia);
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            conexion.close();
        }
        catch(Exception ex){
            
            System.err.println(ex.getMessage());
        }
    }
    
     public void crearUsuario(String servidor,String usuario, String contrasenia){
        Connection conexion;
        String[] sql_u = consultas.consulta_usuario();
        String[] sql_p = consultas.consulta_permisos();
        try{
            conexion = TestConexion(servidor,usuario,contrasenia);
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql_u[0]);
            sentencia = null;
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql_p[0]);
            sentencia = null;
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql_u[1]);
            sentencia = null;
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql_p[1]);
            conexion.close();
        }
        catch(Exception ex){
            
            System.err.println(ex.getMessage());
        }
    }
    
    public void crearTablas(String servidor,String usuario, String contrasenia,
                            JTextArea areaTexto){
            int cant = consultas.getSql_crear_tabla().length;
            
            for(int i = 0; i<cant; i++){
                agregarTexto(areaTexto, "Creando tabla "+(i+1)+"...");
                Connection conexion;
                String sql = consultas.getSql_crear_tabla()[i];
                try{
                    conexion = TestConexion(servidor,usuario,contrasenia);
                    Statement sentencia = conexion.createStatement();
                    sentencia.executeUpdate(sql);
                    agregarTexto(areaTexto, "Listo");
                    conexion.close();
                }
                catch(Exception ex){
                    agregarTexto(areaTexto, "Error creando la tabla "+(i+1));
                    agregarTexto(areaTexto, "Detalle: "+ex.getMessage());
                    System.err.println(ex.getMessage());
                    break;
                }
            }
        }
    
    public void insertarDatos(String servidor,String usuario, String contrasenia,
                            JTextArea areaTexto){
            int cant = consultas.getSql_crear_datos().length;
            
            for(int i = 0; i<cant; i++){
                agregarTexto(areaTexto, "Insertando datos de prueba en tabla "+(i+1)+"...");
                Connection conexion;
                String sql = consultas.getSql_crear_datos()[i];
                try{
                    conexion = CrearConexionABase(servidor,"systurno",usuario,contrasenia);
                    Statement sentencia = conexion.createStatement();
                    sentencia.executeUpdate(sql);
                    agregarTexto(areaTexto, "Listo");
                    conexion.close();
                }
                catch(Exception ex){
                    agregarTexto(areaTexto, "Error al insertar datos en la tabla "+(i+1));
                    agregarTexto(areaTexto, "Detalle: "+ex.getMessage());
                    System.err.println(ex.getMessage());
                    break;
                }
            }
        }
    
    public void generarIndices(String servidor,String usuario, String contrasenia,
                            JTextArea areaTexto){
            int cant = consultas.getSql_indices_relaciones().length;
            agregarTexto(areaTexto, "Generando índices y relaciones...");
            
            for(int i = 0; i<cant; i++){
                agregarTexto(areaTexto, (i+1)+"...");
                Connection conexion;
                String sql = consultas.getSql_indices_relaciones()[i];
                try{
                    conexion = CrearConexionABase(servidor,"systurno",usuario,contrasenia);
                    Statement sentencia = conexion.createStatement();
                    sentencia.executeUpdate(sql);
                    agregarTexto(areaTexto, "Listo");
                    conexion.close();
                }
                catch(Exception ex){
                    agregarTexto(areaTexto, "Error al generar índice o relación"+(i+1));
                    agregarTexto(areaTexto, "Detalle: "+ex.getMessage());
                    System.err.println(ex.getMessage());
                    break;
                }
            }
        }
    
    public void borrarBaseDeDatos(String servidor,String usuario, String contrasenia,JTextArea areaTexto){
        Connection conexion;
        String sql_b = consultas.getSql_borrar_base();
        String[] sql_u = consultas.sql_borrar_usuario;
        agregarTexto(areaTexto, "Comenzando la desinstalación");
        try{
            conexion = TestConexion(servidor,usuario,contrasenia);
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql_b);
            sentencia = null;
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql_u[0]);
            sentencia = null;
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql_u[1]);
            
            conexion.close();
            agregarTexto(areaTexto, "La base de datos de sysTurno se eliminó con éxito.");
            agregarTexto(areaTexto, "-------------------------------");
            agregarTexto(areaTexto, "Muchas Gracias por probar SysTurno.");
            agregarTexto(areaTexto, "Equipo de Desarrollo LosDeMelo");
        }
        catch(Exception ex){
            agregarTexto(areaTexto, "ERROR:");
            agregarTexto(areaTexto, 
                        "No se pudo establecer conexión con el servidor, revise las"
                      + " credenciales ingresadas");
            agregarTexto(areaTexto,"Detalle del error: \n"+ ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
}
