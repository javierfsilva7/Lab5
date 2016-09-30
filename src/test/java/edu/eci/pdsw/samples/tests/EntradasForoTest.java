/*
 * Copyright (C) 2015 hcadavid
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
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class EntradasForoTest {
    
    /* CLASES DE EQUIVALENCIA
    
    CLASE DE EQUIVALENCIA 1: El titulo de la entrada no fue puesto.
    TIPO: (Normal)
    SE ESPERA UN ERROR: SI(X) NO()
    
    CLASE DE EQUIVALENCIA 2: El comentario de la entrada no fue puesto.
    TIPO: (Normal)
    SE ESPERA UN ERROR: SI(X) NO()
    
    CLASE DE EQUIVALENCIA 3: El correo del usuario es invalido.
    TIPO: (Normal)
    SE ESPERA UN ERROR: SI(X) NO()
              
    
    */
    public EntradasForoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void registroPacienteTest(){
       Usuario usr= new Usuario("castellanosisa@gmail.com", "Isabel Castellanos");
       EntradaForo entrada= new EntradaForo(1, usr, "¿Cuando juega millos?", "Fixture Millonarios", (java.sql.Date)new Date(2016,9,12,10,32,12));
       String com= entrada.getComentario();
       assertEquals("El correo esta mal escrito", -1, usr.getEmail().indexOf("@"));
       
       
    }
    
    
}
