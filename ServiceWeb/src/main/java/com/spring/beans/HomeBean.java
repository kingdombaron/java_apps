package com.spring.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="homeBean")
@RequestScoped
public class HomeBean implements Serializable{

	private String mensaje = "BEAN HOME INICIALIZADO";

	public String mostrarMensaje(){
		mensaje = "MOSTRANDO MENSAJE HOME BEAN";
		return mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
	
}
