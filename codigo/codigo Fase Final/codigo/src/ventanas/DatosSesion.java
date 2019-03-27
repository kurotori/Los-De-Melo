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

import losdemelo.basedatos.Leer;

/**
 * El propósito de esta clase es contener los datos de la sesión durante la ejecución
 * del programa.
 * @author Sebastian de los Angeles
 */
public class DatosSesion {
    
    private int idSesion = 0;
    private String CI = "";
    private String nombreUsuario = "";

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }
    
    

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
        System.out.println("Nueva Sesión: "+idSesion);
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    
    
    
}
