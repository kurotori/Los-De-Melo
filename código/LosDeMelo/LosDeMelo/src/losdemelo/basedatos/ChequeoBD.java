/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import losdemelo.basedatos.Acceso;

/**
 * Esta clase permite el chequeo y la creación dinámicos de las estrucutras de
 * la base de datos del sistema.
 * @author Sebastian de los Ángeles
 */
public class ChequeoBD {
    
    Acceso acceso = new Acceso();
    /** El String sentenciaVerif debe contener el SQL necesario para recrear la base de 
    *   de datos completa en el servidor.
    */
    String sentenciaVerif = "CREATE DATABASE IF NOT EXISTS systurno";
    
    /**
     * Permite verificar la 
     * @throws Exception 
     */
    public void VerificarBD() throws Exception{
        try{
            Connection conexion = acceso.CrearConexion();
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaVerif);
            sentencia.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
    }
    
}
