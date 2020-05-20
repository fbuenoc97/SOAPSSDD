package comerciowebservice;

import java.util.Vector;

public class Pedido implements java.io.Serializable{

    private int id;
    private Producto carrito;
    private Usuario usuario;
    private float precio;
    private String direccion;

    public Pedido(int id, Producto carrito, Usuario usuario, float precio, String direccion){
	this.id=id;
	this.carrito=carrito;
	this.usuario=usuario;
	this.precio=precio;
	this.direccion=direccion;

    }

    public void setId(int id){
	this.id=id;
    }

    public void setCarrito(Producto carrito){
	this.carrito=carrito;
    }

    public void setUsuario(Usuario usuario){
	this.usuario=usuario;
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

    public Usuario getUsuario(){
	return this.usuario;
    }

    public float getPrecio(){
	return this.precio;
    }

    public String getDireccion(){
	return this.direccion;
    }
}
