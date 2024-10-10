package com.sebxama.consumer.model;

public class Espectador {

	private Integer id;
	private String nombre;
	private String estado;
	
	public Espectador() {
		
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String toString() {
		return "Espectador ID: '"+this.id+"'; nombre: '"+this.nombre+"'; estado: '"+this.estado+"';";
	}
}
