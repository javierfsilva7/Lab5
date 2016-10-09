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
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.CaptureEvent;
import org.primefaces.event.RowEditEvent;
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

public class RegistroForosBean implements Serializable{
    
    ServiciosForo sp=ServiciosForo.getInstance();
    private String correoRes;
    private String nombre;
    private String contenido;
    public String email;
    public String comentario;
    public String titulo;
    
    
    public void nuevaNombre(CaptureEvent event){
        String n= event.toString();
        this.nombre = n;
    }
    
    public void nuevoMail(CaptureEvent event){
        String n= event.toString();
        this.correoRes= n;
    }
    
    public void nuevoContenido(CaptureEvent event){
        String n= event.toString();
        this.contenido = n;
    }
    
    public void registraRespuesta(EntradaForo foro) throws ExcepcionServiciosForos{
        Usuario usr=new Usuario(this.correoRes, this.nombre);
        Comentario respuesta= new Comentario(usr, this.contenido, java.sql.Date.valueOf(LocalDate.MIN));
        sp.agregarRespuestaForo(foro.getIdentificador(), respuesta);
        /*Set<Comentario> respuestas= foro.getRespuestas();
        respuestas.add(respuesta);
        foro.setRespuestas(respuestas);*/
    }
          
         
    public String getCorreo() {
        return correoRes;
    }

    public void setCorreo(String correo) {
        this.correoRes = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
