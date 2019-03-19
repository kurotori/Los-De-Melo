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
package ventanas;

/**
 *
 * @author Sebastian
 */

import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import losdemelo.basedatos.Leer;
import losdemelo.login.*;
import losdemelo.misc.Herramientas;


public class CapaLogica {
    String base = "systurno";
    
    losdemelo.login.Login login = new losdemelo.login.Login();
    losdemelo.basedatos.Leer leer = new Leer();
    Herramientas herramientas = new Herramientas();
    
    public void mostrarDialogoError(String msgError, Frame ventanaOrigen){
        MsgError dlg_error = new MsgError(ventanaOrigen, true, msgError);
        Point punto = MouseInfo.getPointerInfo().getLocation();
        dlg_error.setLocation(punto);
        dlg_error.setVisible(true);
    }
    
   public void iniciarSesion(Login ventanaLogin, JTextField CI, JPasswordField pf_contrasenia){
        DatosSesion nuevaSesion = ventanaLogin.nuevaSesion;
        String ci = CI.getText();
        String contrasenia = herramientas.leerContrasenia(pf_contrasenia);
        String resultado="";
        
        if(ci.length()<8){
            //Error: No se ingresó una CI o faltan dígitos en la CI ingresada
            mostrarDialogoError("No se ingresó una CI o faltan dígitos en la CI ingresada", 
                                ventanaLogin);
        }
        else{
            if(contrasenia.length()<8){
                //Error: No se ingresó una contraseña o es demasiado corta.
                mostrarDialogoError("No se ingresó una contraseña o es demasiado corta.", 
                        ventanaLogin);
            }
            else{
                try{
                    resultado=login.loginUsuario(ci, contrasenia);
                    
                    
                    nuevaSesion.setIdSesion(Integer.parseInt(resultado));
                    nuevaSesion.setCI(ci);
                    MenuNuevo menu = new MenuNuevo(nuevaSesion);
                    menu.setVisible(true);
                    ventanaLogin.setVisible(false);
                }
                catch(Exception ex){
                    resultado=ex.getMessage();
                    mostrarDialogoError(resultado, ventanaLogin);
                }      
            }
        }
    }
   
   public void cerrarSesion(DatosSesion infoSesion)throws Exception{
       String CI = infoSesion.getCI();
       int sesion = infoSesion.getIdSesion();
       login.logoutUsuario(CI, sesion);
        
   }
   
   public void crearUsuario(Registro vRegistro){
       String CI = vRegistro.getCI();
       String Nombre = vRegistro.getNombre();
       String Apellido =  vRegistro.getApellido();
       String Telefono = vRegistro.getTelefono();
       String email = vRegistro.getEmail();
       char[] contra1 = vRegistro.getContrasenia();
       char[] contra2 = vRegistro.getRepContra();
       String contrasenia = herramientas.leerContrasenia(vRegistro.getCampoContraseña());
       
       if( CI.length()<8 ){
           mostrarDialogoError("Debe proporcionar una CI válida", vRegistro);
       }
       
       
       
       
       
       if(herramientas.compararContrasenia(contra1, contra2)){
           try{
               login.registrarUsuario(CI, Nombre, Apellido, Telefono, email, contrasenia);
           }
           catch(Exception ex){
               mostrarDialogoError(ex.getMessage(), vRegistro);
           }
       }
       //else
       
       
       
   }
   
   public void mostrarMedicamentosRecetados(DatosSesion infoSesion, JTable tabla){
       String CI = infoSesion.getCI();
       DefaultTableModel datos = leer.listaMedicamentosRecetados(base, CI, false);
       tabla.setModel(datos);
   }
   
   //public void buscarTurnoLibre(JTextField numero, JTextField fecha)
   
   
}
