/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losdemelo.misc;

/**
 * Contiene métodos de uso general para diferentes necesidades del sistema, incluyendo
 * conversores de tipos, facilitadores de acceso y otros.
 * @author Sebastian de los Ángeles
 */
public class Herramientas {
    
    
    /**
     * Permite generar un String con los campos de tabla a usar a partir de un 
     * arreglo de tipo String.
     * @param lista Un arreglo de tipo String con los campos de la tabla.
     * @return Un String con los nombres de los campos separados por coma.
     */
    public String recorrerListaCampos(String[] lista){
        int longitud = lista.length;
        String elementosLista=lista[0];
        for(int i = 1; i<longitud; i++){
            elementosLista = elementosLista + "," + lista[i]  ;
        }
        //System.out.println(elementosLista);
        return elementosLista;
    }
    
    /**
     * Permite generar un String con los datos que se quiere guardar a partir 
     * de un arreglo de tipo String.
     * @param lista Un arreglo de tipo String con los datos a guardar. Deben
     * mostrar el mismo orden que los campos.
     * @return Un String con los datos entre apóstrofes y separados por coma.
     */
    public String recorrerListaDatos(String[] lista){
        int longitud = lista.length;
        String elementosLista="'"+lista[0]+"'";
        for(int i = 1; i<longitud; i++){
            elementosLista = elementosLista + ",'" + lista[i]+"'"  ;
        }
        //System.out.println(elementosLista);
        return elementosLista;
    }
    
    /**
     * Permite generar un String a partir del arreglo de tipo byte que contiene
     * la sal para facilitar su almacenamiento en la base de datos.
     * @param sal Un arreglo de tipo byte contniendo la sal generada por el método
     * nuevaSal() de la clase Hasheo
     * @return Un string con los valores de la sal separados por comas.
     */
    public String SalAString(byte[] sal){
        String resultado="";
        for(int i=0; i<(sal.length-1);i++){
            resultado=resultado+sal[i]+",";
        }
        resultado=resultado+sal[sal.length-1];
        //System.out.println("--->>"+resultado);
        return resultado;
    }
    
    /**
     * Permite regenerar la sal a partir de un String conteniendo valores separados
     * por comas, tras recuperarlo de la base de datos.
     * @param sal Un String con los valores de la sal separados por comas.
     * @return Un arreglo de tipo byte con la sal recreada.
     */
    public byte[] StringASal(String sal){
        String[] lista= sal.split(",");
        byte[] resultado = new byte[lista.length];
        for(int i=0; i<lista.length;i++){
            int n =Integer.parseInt(lista[i]);
            resultado[i]=(byte) n;
        }
        //System.out.println("---888"+resultado);
        return resultado;
    }    
}
