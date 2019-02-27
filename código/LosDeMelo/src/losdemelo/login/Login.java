/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.login;

import java.util.ArrayList;
import losdemelo.misc.Herramientas;
import losdemelo.basedatos.Acceso;
import losdemelo.basedatos.Guardar;
import losdemelo.basedatos.Leer;

/**
 * Métodos para generar registros de usuario y login del mismo en la base de
 * datos.
 * @author Sebastian de los Ángeles
 */
public class Login {
    
    Guardar guardar = new Guardar();
    Leer leer = new Leer();
    Hasheo hasheo =  new Hasheo();
    Herramientas herramientas = new Herramientas();
    String base = "systurno";
    
    /**
     * Permite registrar el usuario en el sistema, generando un hash de su contraseña
     * y una sal para encriptarla.
     * @param CI El número de cédula del usuario, que lo identifica en el sistema.
     * @param contrasenia La contraseña elegida por el usuario.
     * @return Cualquier mensaje del servidor acerca de la operación.
     * @throws Exception 
     */
     //TODO Se debe actualizar las tablas para que sean las mismas que en el sistema final
    public String registrarUsuario(String CI, String contrasenia) throws Exception{
        String resultado = "";
        String[] campos = {"CI","sal","hash"};
        
        int existe = leer.contarDatosDeTabla(base, "login", campos[0], "CI = "+CI);
        
        if(existe<1){
            byte[] sal= hasheo.nuevaSal();
            String salS=herramientas.SalAString(sal);
            String hash = hasheo.hashContrasenia(contrasenia, sal);
            String[] datos = {CI,salS,hash};
            resultado = guardar.guardarDatosEnTabla("systurno", "login",campos,datos);
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
        String[] camposLogin = {"CI","sal","hash"};
        String[] camposSesion = {"CI","estado",};
        
        int existe = leer.contarDatosDeTabla(base, "login", camposLogin[0], "CI = "+CI);
        
        if(existe==1){
            ArrayList<ArrayList<String>> datosUsuario = leer.leerDatosDeTabla(
                    base, "login", camposLogin, "CI = "+CI);
            byte[] sal = herramientas.StringASal(datosUsuario.get(1).get(1));
            String hash = new String();
            hash = hasheo.hashContrasenia(contrasenia, sal);
            System.out.println(datosUsuario.get(2).get(1));
            if(datosUsuario.get(2).get(1).equals(hash)){
                String[] datosSesion = {CI,"activa"};
                //guardar.guardarDatosEnTabla(base, "sesion", camposSesion, datosSesion);
                resultado="Login exitoso";
            }
            else{
                resultado="Login fracasó";
            } 
        }
        else{
            resultado="Usuario no existe";
        }
        System.out.println(resultado);
        return resultado;
    }
    
}
