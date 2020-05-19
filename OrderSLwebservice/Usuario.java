package OrderSLwebservice;


import java.io.*;
import java.lang.*;
import java.util.*;

class Usuario implements Serializable {
	private String nombre;
	private float saldo; 
	private String direccion;
	private static final long serialVersionUID=6762531975668221922L; //Forzamos la coincidencia del serialVersionUID con los que están guardados en el .dat
	public Usuario(String nombre, float saldo, String direccion)
	{
		this.nombre=nombre;
		this.saldo=saldo;
		this.direccion=direccion;
	}
	public String obtenerNombre() {
        	 return this.nombre;
     	}
   
	public String obtenerDireccion() {
        	 return this.direccion;
     	}
     	public float obtenerSaldo() {
        	 return this.saldo;
     	}
	
	public void cambiarNombre(String nuevo) {
		this.nombre = nuevo;
	}
	
	public void cambiarDireccion(String nueva) {
		this.direccion = nueva;
	}
	public float añadirSaldo(float valor) {
        	this.saldo+=valor;
        	return this.saldo;
    	}
}
