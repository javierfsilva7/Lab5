/*
 * Copyright (C) 2016 hcadavid
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

import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*Clases de equivalencia:

    Clase de equivalencia 1: No se debe  agregar una respuesta a un foro que no existe 
    Tipo: Normal
    Se espera un error: si() no(x)

    Clase de equivalencia 2: No se debe porder agregar una respuesta al foro si el Usuario no existe
    Tipo: Normal
    Se espera un error: si() no(x)

    Clase de equivalencia 3: Cuanto la respuesta que se quiere agregar posee una fecha menor de la fecha del foro
    Tipo: Frontera
    Se espera un error: si(x) no()

*/

/**
 *
 * @author hcadavid
 */
public class ComentariosTest {
    
    private ServiciosForo serviForo;
    
    @Before
    public void setUp(){
        serviForo = ServiciosForo.getInstance();
    }
    
    @Test
    public void registrarNuevaEntradaForoExistenteTest() throws ExcepcionServiciosForos{
        EntradaForo ef= new EntradaForo(0,serviForo.consultarUsuario("juan.ortiz@gmail.com"),"¿Por que el fuego quema?","Prueba",java.sql.Date.valueOf("2220-07-02"));
        serviForo.registrarNuevaEntradaForo(ef);
        
        List<EntradaForo> listaForos = serviForo.consultarEntradasForo();
        EntradaForo pruebaExistencia = null;
        for(EntradaForo f : listaForos){
            if(f.getTitulo()=="Prueba" && f.getFechayHora().equals(java.sql.Date.valueOf("2220-07-02"))){
                pruebaExistencia = f;
            }
        }
        
        assertEquals("La entrada no quedo registrada exitosamente",ef,pruebaExistencia);
    }
    
    
    
}
