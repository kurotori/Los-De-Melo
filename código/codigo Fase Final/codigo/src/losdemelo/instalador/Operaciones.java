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
package losdemelo.instalador;

/**
 *
 * @author Sebastian
 */
import org.ini4j.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextArea;

public class Operaciones {
    
    public String URLArchivo="systurno.ini";
    
    public File crearArchivoIni(){
        File archivo=null;
        try{
            archivo = new File(URLArchivo);
            archivo.createNewFile();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return archivo;
    }
    
    public void escribirEnIni(File archivo,
                              String bloque, 
                              String clave, 
                              String dato 
                              ){
        try{
            Wini archivoIni = new Wini(archivo);
            archivoIni.put(bloque, clave, dato);
            archivoIni.store();
            
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
    }
    
    public void agregarTexto(JTextArea areaTexto, String texto){
        String textoActual = areaTexto.getText() + "\n";
        areaTexto.setText(textoActual + texto);
    }
    
    
}
