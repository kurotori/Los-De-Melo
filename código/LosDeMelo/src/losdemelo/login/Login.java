/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import losdemelo.misc.Herramientas;
import losdemelo.basedatos.Acceso;
import losdemelo.basedatos.Guardar;
import losdemelo.basedatos.Leer;
import losdemelo.basedatos.Modificar;

/**
 * Métodos para generar registros de usuario y login/logout del mismo en la base de
 * datos.
 * @author Sebastian de los Ángeles
 */
public class Login {
    
    Guardar guardar = new Guardar();
    Leer leer = new Leer();
    Modificar modificar = new Modificar();
    Hasheo hasheo =  new Hasheo();
    Herramientas herramientas = new Herramientas();
    String base = "systurno";
    String tb_usuarios="usuarios";
    String tb_sesiones="sesiones";
    String tb_inician = "inicia";
    
    
    /**
     * Permite registrar el usuario en el sistema, generando un hash de su contraseña
     * y una sal para encriptarla.
     * @param CI El número de cédula del usuario, que lo identifica en el sistema.
     * @param contrasenia La contraseña elegida por el usuario.
     * @param Nombre Dato del usuario
     * @param Apellido Dato del usuario
     * @param Telefono Dato del usuario
     * @param email Dato del usuario
     * @return Cualquier mensaje del servidor acerca de la operación.
     * @throws Exception 
     */
     //TODO Se debe actualizar las tablas para que sean las mismas que en el sistema final
    public String registrarUsuario(
                                    String CI, 
                                    String Nombre, 
                                    String Apellido, 
                                    String Telefono,
                                    String email,
                                    String contrasenia) throws Exception{
        String resultado = "";
        String[] campos = {"CI","Nombre","Apellido","Telefono","email","sal","hash"};
        
        int existe = leer.contarDatosDeTabla(base, tb_usuarios, campos[0], "CI = "+CI);
        
        if(existe<1){
            byte[] sal= hasheo.nuevaSal();
            String salS=herramientas.SalAString(sal);
            String hash = hasheo.hashContrasenia(contrasenia, sal);
            String[] datos = {CI,Nombre,Apellido,Telefono,email,salS,hash};
            resultado = guardar.guardarDatosEnTabla(base, tb_usuarios,campos,datos);
        }
        else{
            resultado = "ERROR: El usuario ya existe";
        }
        
        return resultado;
    }
    
    
    /**
     * Permite gestionar el login de un usuario en el sistema
     * @param CI Un String con la cédula del usuario
     * @param contrasenia Un String con la contraseña del usuario
     * @return Un String con los mensajes de error o confirmación
     * @throws Exception 
     */
    public String loginUsuario(String CI, String contrasenia) throws Exception{
        String resultado = "";
        String[] camposUsuario = {"CI","sal","hash"};
        String[] camposSesion = {"estado"};
        String[] camposInicia = {"CI_usuario","ID_sesion"};
        
        //1 - ¿El usuario existe?
        // Se busca el usuario en la base de datos. La búsqueda debe devolver 1,
        //si existe, ó 0, si no existe.
        int existe = leer.contarDatosDeTabla(base, tb_usuarios, camposUsuario[0], "CI = "+CI);
        
        if(existe==1){
            //2- Si existe se chequea la contraseña
            // Se genera una matriz llamada datosUsuario donde se almacenarán en
            //memoria el hash, la sal y la CI
            /**
             * Estructura de la matriz de datos del usuario:
             * 
             *_____|   0   |   1   |   2   |
             *  0  | "CI"  | "sal" | "hash"| -> fila 0: encabezados, nombres de campo
             *  1  |  ##   |   ##  |  ##   | -> fila 1: datos de cada campo
             * 
             * Para obtener los datos de la matriz se utiliza el método get(), de
             * forma sucesiva para la fila y la columna:
             *      matriz.get(numFila).get(numColumna); .
             * Ej.:  Para obtener la CI del usuario, esta se encuentra en la fila
             *  1, columna 0. El código necesario sería:
             *      datosUsuario.get(1).get(1);
             */

            ArrayList<ArrayList<String>> datosUsuario = 
                    leer.leerDatosDeTabla(base, tb_usuarios, camposUsuario, "CI = "+CI);
            //Recuperamos la sal
            byte[] sal = herramientas.StringASal(datosUsuario.get(1).get(1));
            //Recreamos el hash con la sal recuperada y la contraseña entregada
            //por el usuario.
            String hash = new String();
            hash = hasheo.hashContrasenia(contrasenia, sal);
            //Obtenemos el hash de la matriz y lo comparamos con el hash recreado
            String hashBD = datosUsuario.get(2).get(1);
            if(hashBD.equals(hash)){
                //Si la comparación devuelve true, se inicia el proceso de inicio de sesión
                //A - Se crea un array con los datos para la sesión nueva
                String[] datosSesion = {"activa"};
                
                //B - Se genera la sesión en la base de datos y se obtiene la ID de sesión
                int id = guardar.guardarDatosEnTablaVerID(base, tb_sesiones, camposSesion, datosSesion);
                String[] datosInicia = {CI,""+id};
                //C - Se asocia la ID de sesión con la CI en la tabla Inician.
                guardar.guardarDatosEnTabla(base, tb_inician, camposInicia, datosInicia);
                resultado="Login exitoso: "+id;
            }
            else{
                resultado="ERROR: La contraseña es errónea";
            } 
        }
        else{
            resultado="El Usuario "+CI+" no existe";
        }
        System.out.println(resultado);
        return resultado;
    }
    
    /**
     * Permite cerrar una sesión iniciada en el sistema (marcando la sesión como
     * 'cerrada' en la tabla 'inicia'.
     * @param CI Un String con la CI del usuario que inició sesión
     * @param sesion Un int con el identificador de la sesión
     * @return Un String con la confirmación o el mensaje de error del servidor
     * @throws Exception
     */
    public String logoutUsuario(String CI, int sesion) throws Exception{
        String resultado="";
        Acceso acceso = new Acceso();
        
        String sql = "UPDATE sesiones INNER JOIN inicia SET "+
                     "sesiones.estado = 'cerrada'"+
                     "WHERE inicia.Ci_usuario = ? "+
                     " AND sesiones.ID = ? "+
                     " AND sesiones.ID = inicia.ID_sesion";
        
        try{
            Connection con = acceso.CrearConexionABase(base);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, CI);
            ps.setInt(2, sesion);
            ps.executeUpdate();
            con.close();
            resultado="OK";
        }
        catch(Exception ex){
            //System.out.println(ex.getMessage());
            resultado=ex.getMessage();
        }
        System.out.println(resultado);
        return resultado;
    }
    
}


/**
 *         
        
        
        
        
        
        String resultado="--";
        String tabla1 = "sesiones INNER JOIN inicia";
        String condicion1 = "CI_usuario ="+CI+"";

        String condicion3 = "";
               inicia.Ci_usuario="45751221"
AND sesiones.ID = inicia.ID_sesion
        String valor = "'cerrada'";
        
        //int sesiones = leer.contarDatosDeTabla(base, tb_inician, "sesiones.ID", condicion1);
        //System.out.println(sesiones);
        //if(sesiones>=1){
            String r = modificar.actualizarTablaCondicion(base, tb_sesiones, "sesiones.estado", valor, condicion3);
            System.out.println(r);
        //}        
                
                
        
        
        
 */