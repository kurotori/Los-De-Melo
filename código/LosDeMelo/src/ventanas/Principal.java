package ventanas;
/**
 * @author Victor Neves
 */
public class Principal { 

    
    public static void main(String[] args) {
        
        DatosSesion datosSesion = new DatosSesion();
        
        Login log= new Login(datosSesion);
        log.setVisible(true);
    }
}