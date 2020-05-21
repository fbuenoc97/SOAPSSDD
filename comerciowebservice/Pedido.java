package comerciowebservice;

import java.util.Vector;

public class Pedido implements java.io.Serializable{

    private int id;
    private Producto carrito;
    private String nombre;
    private float precio;
    private String direccion;

    public Pedido(int id, Producto carrito, String nombre, float precio, String direccion){
	this.id=id;
	this.carrito=carrito;
	this.nombre=nombre;
	this.precio=precio;
	this.direccion=direccion;

    }

    public void setId(int id){
	this.id=id;
    }

    public void setCarrito(Producto carrito){
	this.carrito=carrito;
    }

    public void setNombre(String nombre){
	this.nombre=nombre;
    }

    public void setPrecio(float precio){
	this.precio=precio;
    }

    public void setDireccion(String direccion){
	this.direccion=direccion;
    }

    public int getId(){
	return this.id;
    }

    public Producto getCarrito(){
	return this.carrito;
    }

    public String getNombre(){
	return this.nombre;
    }

    public float getPrecio(){
	return this.precio;
    }

    public String getDireccion(){
	return this.direccion;
    }
}
