/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Métodos de hasheo de la contraseña para login seguro.
 * Este código se basa en documentación y código encontrados en este sitio:
 * https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
 * @author Sebastian de los Ángeles
 */
public class Hasheo {
    
    /**
     * Genera una SAL, una secuencia al azar para hashear de forma segura 
     * la contraseña
     * @return Un arreglo de bytes conteniendo la SAL
     * @throws NoSuchAlgorithmException 
     */
    private static byte[] GenerarSal() 
            throws NoSuchAlgorithmException{
    //Se genera una instancia de un generador aleatorio. SHA1PRNG se considera
    // criptográficamente seguro
    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
    //Creamos el arreglo para la SAL
    byte[] sal = new byte[16];
    //Se rellena el arreglo mediante el generador sr
    sr.nextBytes(sal);
    //se retorna la sal
    return sal;
    
    }
    
    /**
     * Método público para obtener una sal mediante SHA1PRNG
     * @return Un arreglo de bytes conteniendo la SAL
     */
    public byte[] nuevaSal(){
        byte[] sal = new byte[16];
        try{
            sal = GenerarSal();
            for(int i=0;i<sal.length;i++){
                System.out.print(sal[i]+",");
            }
            System.out.println("\n");
        }
        catch(NoSuchAlgorithmException ex){
            System.out.println(ex.getMessage().toString());
        }
        return sal;
    }
    
    /**
     * Genera un hasheo de una constreña mediante el algoritmo MD5 y una sal.
     * @param contrasenia La contraseña que se desa hashear
     * @param sal La sal para aumentar la seguridad del hasheo
     * @return Un String con la contraseña hasheada
     */
    private static String hashearContrasenia(String contrasenia, byte[] sal)
    {
        String generatedPassword = null;
        try {
            // Se crea una instancia MessageDigest para manejar MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // se añade la sal
            md.update(sal);
            //Get the hash's bytes
            byte[] bytes = md.digest(contrasenia.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    /**
     * Método público para hashear contraseñas 
     * @param contrasenia La contraseña a hashear.
     * @param sal La sal necesaria para hashear la constraseña de forma segura.
     * @return Un String con la contraseña hasheada.
     */
    public String hashContrasenia(String contrasenia, byte[] sal){
        String resultado = hashearContrasenia(contrasenia, sal);    
        return resultado;
    }
    
}
