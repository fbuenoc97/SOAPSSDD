package comerciowebservice;

import java.util.Vector;
import java.util.*;

public class OrderSL{

    private Vector Usuarios =null;
    private Vector Productos=null;
    private Vector Pedidos=null;

    public OrderSL(){

	Usuarios=new Vector();
	Productos=new Vector();
	Pedidos=new Vector();

    }

    public Usuario crearUsuario(String nomUsu, float saldo, String direccion) throws Exception{

	Usuario usu=null;
	
	if(nomUsu==null || direccion==null)
	   throw new Exception("Datos invalidos");
	else{
	    usu=new Usuario(nomUsu, saldo, direccion);
	    Usuarios.add(usu);
	}
	return usu;
    }

    public Producto crearProducto(String nombre, int id, float precio) throws Exception{

	Producto prod=null;
	
	    if(nombre==null )
		throw new Exception("Datos invalidos");
	    else{
		prod= new Producto(nombre, id, precio);
		Productos.add(prod);
	    }
	return prod;
    }
    public Pedido crearPedido(int id, Producto carrito, Usuario usuario, float precio, String direccion) throws Exception{

	Pedido ped=null;
	ped= new Pedido(id, carrito, usuario, precio, direccion);
	Pedidos.add(ped);
	System.out.println(ped.getDireccion());
	return ped;
    }
    public boolean existeUsuario(String nombre) throws Exception { //Para comprobar si el usuario existe, devuelve 1 si existe
        boolean existe = false;                                // y 0 en caso contrario
	Usuario usuario = null;
	Iterator<Usuario> recorrer_usuarios = Usuarios.iterator();
            while(recorrer_usuarios.hasNext()) {
		usuario = recorrer_usuarios.next(); 
                if(usuario.getNombre().equals(nombre))
			existe = true;
			}
        return existe;
  	}
     public boolean existeProducto(String nombre) throws Exception { //Para comprobar si el usuario existe, devuelve 1 si existe
        boolean existe = false;                                // y 0 en caso contrario
	Producto producto = null;
	Iterator<Producto> recorrer_productos = Productos.iterator();
            while(recorrer_productos.hasNext()) {
		producto = recorrer_productos.next(); 
                if(producto.getNombre().equals(nombre))
			existe = true;
			}
        return existe;
  	}
    public Usuario Saldo(String nomUsu, float dinero){
	Iterator<Usuario> recorrer_usuarios = Usuarios.iterator();
	Usuario usuario=null;
	boolean flag=true;
	while (recorrer_usuarios.hasNext() && flag==true){                                            
	    usuario = recorrer_usuarios.next(); 
	    if (usuario.getNombre().equals(nomUsu)){
		usuario.setSaldo(dinero);
		flag=false;
	    }
	}
	return usuario;
    }
   public Usuario setDireccion(String nomUsu, String nueva_direccion) throws Exception{
	Iterator<Usuario> recorrer_usuarios = Usuarios.iterator();
	Usuario usuario=null;
	boolean flag=true;
	while (recorrer_usuarios.hasNext() && flag==true){                                          
	    usuario = recorrer_usuarios.next(); 
	    if (usuario.getNombre().equals(nomUsu)){
		usuario.setDireccion(nueva_direccion);
		flag=false;
	    }
	}
      return usuario;
    }
   public float getSaldo(String nomUsu) throws Exception{
	Iterator<Usuario> recorrer_usuarios = Usuarios.iterator();
	Usuario usuario=null;
	boolean flag=true;
	float saldo=0;
	while (recorrer_usuarios.hasNext() && flag==true){                                         
	    usuario = recorrer_usuarios.next(); 
	    if (usuario.getNombre().equals(nomUsu)){
		saldo=usuario.getSaldo();
		flag=false;
	    }
	}
	return saldo;
    }
    public Producto [] getProductos() throws Exception{   //Obtener todos los productos existentes
	Producto vp [] = new Producto [Productos.size()];
            for (int k=0; k < Productos.size(); k++) {
                vp[k] = (Producto)Productos.get(k);
            }
            
            return vp;
    }
    public Pedido [] getPedidos(String nombre) throws Exception{    //Obtener todos los pedidos existentes
   	int existe=0; // No existe
	String nombreAux="";
        Vector<Pedido> v = new Vector<Pedido>();
        for (int i=0;i<Pedidos.size();i++){
            Pedido p = (Pedido)Pedidos.get(i);
            nombreAux = p.getUsuario().getNombre();
            if(nombreAux.equals(nombre)) {
                v.add(p);
                existe = 1;
            }
        }
        if (existe == 1){
            Pedido vped [] = new Pedido [v.size()];
            for (int k=0; k < v.size(); k++) {
                vped[k] = (Pedido)v.get(k);
            }
            
            return vped;
        }
        else
            throw new Exception ("Nombre no encontrado");
    }
}
