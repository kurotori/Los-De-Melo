package ventanas;

import losdemelo.basedatos.Leer;

/**
 * @author Victor Neves
 */
public class Principal { 
    //static Leer leer = new Leer();
    
    public static void main(String[] args) throws Exception{
        //leer.BuscarTurnoDisponible();
        
        DatosSesion datosSesion = new DatosSesion();
        
        Login log= new Login(datosSesion);
        
        log.setVisible(true);
    }
}