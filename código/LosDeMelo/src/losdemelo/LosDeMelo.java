/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import losdemelo.basedatos.Acceso;
import losdemelo.basedatos.ChequeoBD;
import losdemelo.basedatos.Guardar;
import losdemelo.ventanas.*;
/**
 *
 * @author Sebastian
 */
public class LosDeMelo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Inicio inicio_1 = new Inicio();
        inicio_1.setVisible(true);
        inicio_1.setSize(800, 600);

        inicio_1.getContentPane().setBackground(Color.WHITE);
        
        ChequeoBD chequear = new ChequeoBD();
        Acceso acceso = new Acceso();
        Guardar guardar = new Guardar();
        System.out.println(acceso.chequearConexion());
        
        chequear.VerificarBD();
        
        
        String[] lista = {"hola","que","tal"};
        guardar.recorrerListaCampos(lista);
        String[] campos = {"nombre","apellido","telefono"};
        String[] datos = {"Sebaaaaaaaa","Delosa","4654654654"};
        
        guardar.guardarDatosEnTabla("systurno","pruebas", campos, datos);
        
    }
    
}
