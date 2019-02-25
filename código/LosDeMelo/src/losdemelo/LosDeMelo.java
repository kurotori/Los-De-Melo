/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo;
import losdemelo.misc.Herramientas;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import losdemelo.basedatos.Acceso;
import losdemelo.basedatos.ChequeoBD;
import losdemelo.basedatos.Guardar;
import losdemelo.basedatos.Leer;
import losdemelo.ventanas.*;
import losdemelo.login.*;
/**
 * Clase inicial, contiene las instancias y métodos para iniciar el sistema.
 * También contiene, de forma temporal, restos de ejecuciones de prueba que deberán 
 * eliminarse para la versión final.
 * @author Sebastian de los Ángeles
 * @version 0.1
 */
public class LosDeMelo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        Inicio inicio_1 = new Inicio();
//        inicio_1.setVisible(true);
//        inicio_1.setSize(800, 600);
//
//        inicio_1.getContentPane().setBackground(Color.WHITE);
//        
//        ChequeoBD chequear = new ChequeoBD();
//        Acceso acceso = new Acceso();
//        Guardar guardar = new Guardar();
//        System.out.println(acceso.chequearConexion());
//        
//        chequear.VerificarBD();
//        
//        
//        String[] lista = {"hola","que","tal"};
//        guardar.recorrerListaCampos(lista);
        String[] campos = {"nombre","apellido","telefono"};
//        String[] datos = {"Sebaaaaaaaa","Delosa","4654654654"};
//        
//        guardar.guardarDatosEnTabla("systurno","pruebas", campos, datos);

          Hasheo hasheo = new Hasheo();
          Herramientas herramientas = new Herramientas();
          Login login = new Login();
          Leer leer = new Leer();
          
          ArrayList<ArrayList<String>> resultado = new ArrayList<ArrayList<String>>();
          resultado = leer.leerDatosDeTabla("systurno", "pruebas", campos, "1");
          leer.mostrarResultadosSinH(resultado);
          
          //String pruebalogin = login.registrarUsuario("45751221", "25252525");
          //System.out.println(pruebalogin);
          
          login.loginUsuario("45751221", "25252525");
          
          System.out.println(leer.contarDatosDeTabla("systurno", "login", "CI", "CI = 45751221"));
    }
    
}
