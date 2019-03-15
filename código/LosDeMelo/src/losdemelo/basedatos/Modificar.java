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
package losdemelo.basedatos;


/**
 *
 * @author Sebastian
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import losdemelo.basedatos.Acceso;
import losdemelo.misc.Herramientas;

/**
 * Métodos para generar modificaciones en registros existentes en la base de datos
 * @author Sebastian de los Ángeles
 */
public class Modificar {
    
    Acceso acceso = new Acceso();
    Herramientas herramientas = new Herramientas();
    
    /**
     * Permite modificar registros en una tabla de la base de datos. 
     * Tambien es posible modificar datos en tablas realcionadas mediante el comando
     * JOIN (INNER, LEFT o RIGHT)
     * @param base String conteniendo la base de datos a usar
     * @param tabla String con el nombre de la tabla cuyos registros se desean modificar
     * @param campos Array de tipo string con los campos cuyo contenido se quiere modificar
     * @param valores Array de tipo String con los valores modificados que se quieren introducir
     * @param condicion String con la condición WHERE de la consulta.
     * @return Un string con una confirmación o el mensaje de error del servidor
     */
    public String actualizarTablaCondicion( String base,
                                            String tabla,
                                            String[] campos,
                                            String[] valores,
                                            String condicion)
    {
        String resultado="";
        String valoresStr =campos[0]+"='"+valores[0]+"'";
        
        for(int i=1;i<campos.length;i++){
            valoresStr = valoresStr + ","+campos[i]+"='"+valores[i]+"'";
        }
        
        String sql = "UPDATE "+tabla+" SET "+valoresStr+" WHERE "+condicion;
        
        
        try{
            Connection c = acceso.CrearConexionABase(base);
            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
            resultado="OK";
            c.close();
        }
        catch(Exception ex){
            resultado = "ERROR: No fue posible modificar la base de datos.\n"+
                        ex.getMessage();
        }        
                
        return resultado;
    }
    
    /**
     * Permite modificar registros en un campo de una tabla de la base de datos. 
     * Tambien es posible modificar datos en tablas relacionadas mediante el comando
     * JOIN (INNER, LEFT o RIGHT)
     * 
     * @param base String conteniendo la base de datos a usar
     * @param tabla String con el nombre de la tabla cuyos registros se desean modificar
     * @param campo String con el campo cuyo contenido se quiere modificar
     * @param valor String con el valor modificado que se quieren introducir
     * @param condicion String con la condición WHERE de la consulta.
     * @return Un String con una confirmación o el mensaje de error del servidor.
     */
    public String actualizarTablaCondicion( String base,
                                            String tabla,
                                            String campo,
                                            String valor,
                                            String condicion)
    {
        String resultado="";
        String valoresStr =campo+"="+valor;
        
        String sql = "UPDATE "+tabla+" SET "+valoresStr+" WHERE "+condicion;
        
        
        try{
            Connection c = acceso.CrearConexionABase(base);
            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
            resultado="OK";
            c.close();
        }
        catch(Exception ex){
            resultado = "ERROR: No fue posible modificar la base de datos.\n"+
                        ex.getMessage();
        }        
                
        return resultado;
    }
    
}
