package comerciowebservice;

public class Producto implements java.io.Serializable{
    
    private String nombre;
    private int id;
    private float precio;
    
    public Producto(String nombre, int id, float precio){
	this.nombre=nombre;
	this.id=id;
	this.precio=precio;
		
    }

    public void setNombre(String nombre){
	this.nombre=nombre;
    }

    public void setId(int id){
	this.id=id;
    }

    public void setPrecio(float precio){
	this.precio=precio;
    }

    public String getNombre(){
	return this.nombre;
    }

    public int getId(){
	return this.id;
    }

    public float getPrecio(){
	return this.precio;
    }

}
