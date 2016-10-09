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
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.*;
import java.io.Serializable;
import java.sql.Date;

import java.time.LocalDate;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.*;

/**
 *
 * @author hcadavid
 */

@ManagedBean(name = "registroForosBean")
@SessionScoped
public class RegistroForosBean implements Serializable {

    ServiciosForo sp = ServiciosForo.getInstance();
    
    public String email;
    public String comentario;
    public String titulo;
    
    private EntradaForo ef;



    public EntradaForo getEf() {
        return ef;
    }

    public void setEf(EntradaForo ef) {
        this.ef = ef;
    }
    
    


    public void nuevaEntradaTitulo(CaptureEvent event){
        String p= event.toString();
        this.titulo = p;
    }
    
    public void nuevaEntradaEmail(RowEditEvent event){
        String p= event.toString();
        this.email = p;
    }
    
    public void nuevaEntradaComentario(RowEditEvent event){
        String p= event.toString();
        this.comentario = p;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    

   

    public void creaForo() throws ExcepcionServiciosForos {

        /*EntradaForo nuevoForo= new EntradaForo();
         nuevoForo.setAutor(us);
         nuevoForo.setComentario(comentario);
         nuevoForo.setTitulo(titulo);
         nuevoForo.setFechayHora(new Date(2016,11,7*/
        EntradaForo ef = new EntradaForo(0, sp.consultarUsuario(email), comentario, titulo, java.sql.Date.valueOf(LocalDate.MIN));
        sp.registrarNuevaEntradaForo(ef);

        

    }

    public List<EntradaForo> getForos() throws ExcepcionServiciosForos {
        return sp.consultarEntradasForo();
    }
    
    

}
