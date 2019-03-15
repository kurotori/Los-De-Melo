package ventanas;
/**
 * @author Victor Neves
 */
public class Principal { 

    
    public static void main(String[] args) throws Exception{
        
        losdemelo.login.Login logueo = new losdemelo.login.Login();
        logueo.registrarUsuario("12345678", "Juan", "Perez", "0000000000", "algo@algo.com", "12345678");
        
        DatosSesion datosSesion = new DatosSesion();
        
        Login log= new Login(datosSesion);
        log.setVisible(true);
    }
}