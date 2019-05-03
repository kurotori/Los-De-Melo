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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import losdemelo.basedatos.Guardar;
import losdemelo.basedatos.Leer;
import losdemelo.basedatos.Modificar;
import losdemelo.login.*;
import losdemelo.misc.Herramientas;


public class CapaLogica {
    String base = "systurno";
    
    losdemelo.login.Login login = new losdemelo.login.Login();
    losdemelo.basedatos.Leer leer = new Leer();
    losdemelo.basedatos.Guardar guardar = new Guardar();
    losdemelo.basedatos.Modificar modificar = new Modificar();
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
                    
                    nuevaSesion.setNombreUsuario(leer.obtenerNombreCompleto(ci));
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
       String contrasenia = herramientas.leerContrasenia(vRegistro.getCampoContrasenia());
       
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
   
   public void mostrarTurnosDisponibles(JFormattedTextField turno,
                                        JFormattedTextField dia, 
                                        JFormattedTextField hora){
       String[] datosTurno = leer.BuscarTurnoDisponible();
       turno.setText(datosTurno[0]);
       dia.setText(datosTurno[1]);
       hora.setText(datosTurno[2]);
       
   }
   
   public void mostrarMedicamentosRecetados(DatosSesion infoSesion, JTable tabla){
       String CI = infoSesion.getCI();
       DefaultTableModel datos = leer.listaMedicamentosRecetados(base, CI, false);
       tabla.setModel(datos);
       tabla.getTableHeader().setReorderingAllowed(false);
       tabla.getTableHeader().setResizingAllowed(false);
       tabla.setCellEditor(null);
       tabla.setEnabled(false);
   }
   
   public boolean seleccionarMedicamentosDisponibles(Reserva ventana,
                                                  JTable tablaRecetados,
                                                  JFormattedTextField turno,
                                                  JFormattedTextField dia,
                                                  JFormattedTextField hora){
       TableModel datos = tablaRecetados.getModel();
       DefaultTableModel disponibles = new DefaultTableModel();
       
       Object[] nomColumnas = {"Medicamento","Cantidad"};
       disponibles.setColumnIdentifiers(nomColumnas);
       
       int filas = datos.getRowCount();
       
       for(int i = 0; i<filas;i++){
           String estado = datos.getValueAt(i, 2).toString();
           //System.out.println(estado);
           if(estado.equals("DISPONIBLE")){
               Object[] fila = new Object[2];
               fila[0]=datos.getValueAt(i, 0);
               fila[1]=datos.getValueAt(i, 1);
               disponibles.addRow(fila);
               System.out.println(fila[0]+"-"+fila[1]);
           }
       }
       String msgTurno="¿Confirma el turno "+turno.getText()+
                       " a las "+hora.getText()+
                       " del día "+dia.getText()+"?";
       ConfirmaReserva confirma = new ConfirmaReserva(ventana, true, msgTurno, disponibles);
       confirma.setVisible(true);
       
       boolean opcion = false;
       opcion = confirma.opcion;
       System.out.println(opcion);
       confirma.dispose();
       return opcion;
   }
   
   public void buscarTurnosConfirmados(DatosSesion sesion, 
                                       JButton bt_reservar)
                                       
   {   
       int turnos = 0;
       try{
       turnos = leer.contarTurnos(sesion.getCI());
       }
       catch(Exception ex){
           System.err.println(ex.getMessage());
       }
       if(turnos > 0){
           bt_reservar.setEnabled(false);
           bt_reservar.setToolTipText(""
                   + "Ya hay un turno a su nombre en el sistema.\n"
                   + "Debe usarlo o cancelarlo para volver a reservar.");
       }
       
   }
   
   public void buscarTurnosCancelables(DatosSesion sesion, 
                                       JButton bt_reservar)
                                       
   {   
       int turnos = 0;
       try{
       turnos = leer.contarTurnos(sesion.getCI());
       }
       catch(Exception ex){
           System.err.println(ex.getMessage());
       }
       if(turnos < 1){
           bt_reservar.setEnabled(false);
           bt_reservar.setToolTipText("No hay turnos a su nombre en el sistema");
       }
       
   }
   
   public void reservarTurno(DatosSesion sesion){
       String CI = sesion.getCI();
       String iDReceta = leer.verIdUltimaReceta(CI);
       String numTurno = leer.BuscarTurnoDisponible()[0];
       try{
            guardar.reservarTurno(numTurno, CI, iDReceta);
       }
       catch(Exception ex){
           System.err.println("Error en reserva de turnos: "+ex.getMessage());
       }
   }
   
   public void verHistorialTurnos(DatosSesion infoSesion, 
                                  JTable tabla, 
                                  JTextField tf_nombre,
                                  JTextField tf_CI){
       String CI = infoSesion.getCI();
       tf_CI.setText(CI);
       tf_nombre.setText(infoSesion.getNombreUsuario());
       DefaultTableModel datos = leer.historialTurnos(base, CI);
       tabla.setModel(datos);
       tabla.getTableHeader().setReorderingAllowed(false);
       tabla.getTableHeader().setResizingAllowed(false);
       tabla.setCellEditor(null);
       tabla.setEnabled(false);
       
   }
   
   public void verDatosTurnoActual(DatosSesion sesion,
                                   JFormattedTextField numTurno,
                                   JFormattedTextField fechaTurno,
                                   JFormattedTextField horaTurno,
                                   String[] datosTurno){
       
       datosTurno = leer.datosTurnoConfirmado(sesion.getCI());
       numTurno.setText(datosTurno[0]);
       fechaTurno.setText(datosTurno[1]);
       horaTurno.setText(datosTurno[2]);
   }
   
   public void cancelarTurno(DatosSesion sesion){
       String CI = sesion.getCI();
       String iDReceta = leer.verIdUltimaReceta(CI);
       System.out.println("Receta:"+iDReceta);
       String[] datosTurno = leer.datosTurnoConfirmado(CI);
       System.out.println("Turno:"+datosTurno[0]);
       try{
           modificar.cancelarTurno(datosTurno[0],iDReceta);
       }
       catch(Exception ex){
           System.err.println("Error en cancelación de turnos: "+ex.getMessage());
       }
       
       
       
   }
   
   public void registrarUsuario(Registro vt_registro){
           if(herramientas.compararContrasenia(vt_registro.getContrasenia(),
                                               vt_registro.getRepContra())){
               boolean registroOk = true;
               String mensaje="";
               
               if(vt_registro.getContrasenia().length<8){
                   registroOk = false;
                   mensaje = "La contraseña debe tener al menos 8 caracteres.";
               }
               if(vt_registro.getNombre().length()==0){
                   registroOk = false;
                   mensaje = "Debe proveer un nombre para el registro.";
               }
               if(vt_registro.getApellido().length()==0){
                   registroOk = false;
                   mensaje = "Debe proveer un apellido para el registro.";
               }
               if(vt_registro.getCI().length()==0){
                   registroOk = false;
                   mensaje = "Debe proveer un número de CI.";
               }
               if(vt_registro.getCI().length()<8){
                   registroOk = false;
                   mensaje = "Faltan dígitos en la CI escrita.";
               }
               if(vt_registro.getEmail().length()==0){
                   registroOk = false;
                   mensaje = "Debe proveer un Email";
               }
               if(vt_registro.getTelefono().length()==0){
                   registroOk = false;
                   mensaje="Debe proveer un Teléfono.";
               }
               if(registroOk){
                   String contrasenia = herramientas.leerContrasenia(
                           vt_registro.getCampoContrasenia());
                   try{
                       login.registrarUsuario(vt_registro.getCI(), 
                                          vt_registro.getNombre(), 
                                          vt_registro.getApellido(), 
                                          vt_registro.getTelefono(), 
                                          vt_registro.getEmail(), 
                                          contrasenia);
                       DialogoMensaje conf = 
                               new DialogoMensaje(vt_registro, 
                                                  true, 
                                                  "Se registró correctamente al usuario "+
                                                   vt_registro.getNombre()+" "+
                                                   vt_registro.getApellido());
                       conf.setVisible(true);
                       vt_registro.volver();
                   }
                   catch(Exception ex){
                       System.err.println("Error de registro: "+ex.getMessage());
                   }
                   
               }
               else{
                   DialogoMensaje advertencia = new DialogoMensaje(vt_registro, true, 
                                                           mensaje);
                   advertencia.setVisible(true);
               }
               
           }
           else{
               DialogoMensaje advertencia = new DialogoMensaje(vt_registro, true, 
                                                           "Las contraseñas no son iguales");
               advertencia.setVisible(true);
           }
       }
}
