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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name="registroForosBean")
@SessionScoped
public class RegistroForosBean implements Serializable{
    
    ServiciosForo sp=ServiciosForo.getInstance();
    public String us;
    public String comentario;
    public String titulo;
    private List<EntradaForo> foros;
    
    
    public RegistroForosBean(){}
    
    public void setUsuario(String email){
        this.us = email;
    }
    
    public String getUsuario(){
        return us;
    }
    
    
    public void setComentario(String comentario){
        this.comentario=comentario;
    }
    
    public String getComentario(){
        return comentario;
    }
    
    
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void creaForo(){
        try{ 
            /*EntradaForo nuevoForo= new EntradaForo();
            nuevoForo.setAutor(us);
            nuevoForo.setComentario(comentario);
            nuevoForo.setTitulo(titulo);
            nuevoForo.setFechayHora(new Date(2016,11,7*/
            EntradaForo ef=new EntradaForo(0, sp.consultarUsuario("juan.perez@gmail.com"),"hola?", this.titulo, java.sql.Date.valueOf("2005-01-01"));
            sp.registrarNuevaEntradaForo(ef);
        
            this.foros=sp.consultarEntradasForo();
        }catch(ExcepcionServiciosForos e){
            e.printStackTrace();
        }
       
    }
    
    public List<EntradaForo> getForos() throws ExcepcionServiciosForos{
        return sp.consultarEntradasForo();
    }
    

    
}
