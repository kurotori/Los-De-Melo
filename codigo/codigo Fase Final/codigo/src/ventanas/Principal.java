package ventanas;

import losdemelo.basedatos.Leer;
import losdemelo.instalador.Instalador;

/**
 * @author Victor Neves
 */
public class Principal { 
    //static Leer leer = new Leer();
    
    public static void main(String[] args) throws Exception{
        //leer.BuscarTurnoDisponible();
        if(args.length>0){
            if(args[0].equals("-instalar")){
            Instalador instalador = new Instalador();
            instalador.setVisible(true);
            }
        }
        
        else{
            DatosSesion datosSesion = new DatosSesion();
            Login log= new Login(datosSesion);
            log.setVisible(true);
        }
        
    }
}