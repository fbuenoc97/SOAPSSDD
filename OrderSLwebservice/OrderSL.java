package OrderSLwebservice;

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
import java.io.*;

class OrderSL  {
	List<Usuario> Usuarios;
        List <Producto> Productos;
	List <Pedido> Pedidos;
    OrderSL() throws RemoteException {
	Usuarios = new LinkedList<Usuario>();  //Inicializamos las listas de objetos
       	Productos = new LinkedList<Producto>();
	Pedidos = new LinkedList<Pedido>();	
     }
        public Usuario crearUsuario(String nombre,  float saldo, String direccion) throws RemoteException { 
	Usuario usuario = new Usuario(nombre, saldo, direccion);  //Crea el usuario y devuelve el objeto
        Usuarios.add(usuario);
	return usuario;
    }
	public void crearProducto(String nombre, float precio) throws RemoteException { //Crea el producto
		boolean repetido = false;
		int id;
		do{
		Random numAleatorio = new Random();   // Genera un int de forma aleatoria, comprueba que no esté repetido en la lista 
		id = numAleatorio.nextInt();  //y que no sea negativo
		if (id<0)
			id = id * (-1);
		for (Producto i: Productos){
			if(id==i.obtenerId())
				repetido = true;		
		}
		}while(repetido);
		Producto producto = new Producto(nombre,id,precio);
		Productos.add(producto);
	    }
	public void realizarPedido(int listaProductos[], String nomUsu) throws RemoteException{ //Crea una nueva Lista de Productos  
	List <Producto> Carrito=new LinkedList<Producto>(); 				         //que será el carrito
	float precio=0;
	
	
	for(int i=0; i<listaProductos.length;i++){  //Estará compuesto por los productos cuya id coincida con las id proporcionadas por el cliente
		for(Producto j: Productos){
			if (j.obtenerId()==listaProductos[i]){
				Carrito.add(j);
				precio+=j.obtenerPrecio();
			}
		}
	}
	int id;
	boolean repetido = false;
		do{
		Random numAleatorio = new Random();   // Genera un int de forma aleatoria, comprueba que no esté repetido en la lista	
		id = numAleatorio.nextInt();     // y que no sea negativo
		if (id<0)
			id = id * (-1);
		for (Pedido i: Pedidos){
			if(id==i.obtenerId() )
				repetido = true;		
		}
		}while(repetido);
	Date fecha = new Date();
	for (Usuario i: Usuarios) {
	    if(nomUsu.equals(i.obtenerNombre())){
		Usuario usuario;
		usuario=i;
		String direccion = usuario.obtenerDireccion();
		Pedido ped = new Pedido(id,fecha,Carrito,usuario,precio,direccion);
		Pedidos.add(ped);      //Añadimos el pedido a la lista de pedidos
	    }
	}
	
	
    }
   

    public boolean existeUsuario(String nombre) throws RemoteException { //Para comprobar si el usuario existe, devuelve 1 si existe
        boolean existe = false;                                // y 0 en caso contrario
            for (Usuario i: Usuarios) {
                if(nombre.equals(i.obtenerNombre()))
					existe = true;
			}
        return existe;
  	}
    
	public boolean existeProducto(String nombre) throws RemoteException { //Para comprobar si el producto existe
        boolean existe = false;                                       //devuelve 1 si existe y 0 en caso contrario
            for (Producto i: Productos) {
                if(nombre.equals(i.obtenerNombre()))
					existe = true;
            }
        return existe;
  	}
    public List<Producto> obtenerProductos() throws RemoteException{   //Obtener todos los productos existentes

	return Productos;
    }
    public List<Pedido> obtenerPedidos(String nomUsu) throws RemoteException{    //Obtener todos los pedidos existentes
	List<Pedido> pedidosUsu = new LinkedList<Pedido>();
	
	for (Pedido i: Pedidos) {
	    if(nomUsu.equals(i.obtenerUsuario().obtenerNombre()))
		pedidosUsu.add(i);
			}
	return pedidosUsu;
    }

    public float añadirSaldo(String nomUsu, float dinero){
	Iterator<Usuario> recorrer_usuarios = Usuarios.iterator();
	Usuario usuario=null;
	boolean flag=true;
	while (recorrer_usuarios.hasNext() && flag==true){                                            
	    usuario = recorrer_usuarios.next(); 
	    if (usuario.obtenerNombre().equals(nomUsu)){
		usuario.añadirSaldo(dinero);
		flag=false;
	    }
	}
	return usuario.obtenerSaldo();
    }


    public void cambiarDireccion(String nomUsu, String nueva_direccion) throws RemoteException{
	Iterator<Usuario> recorrer_usuarios = Usuarios.iterator();
	Usuario usuario=null;
	boolean flag=true;
	while (recorrer_usuarios.hasNext() && flag==true){                                          
	    usuario = recorrer_usuarios.next(); 
	    if (usuario.obtenerNombre().equals(nomUsu)){
		usuario.cambiarDireccion(nueva_direccion);
		flag=false;
	    }
	}
      
    }


    public float obtenerSaldo(String nomUsu) throws RemoteException{
	Iterator<Usuario> recorrer_usuarios = Usuarios.iterator();
	Usuario usuario=null;
	boolean flag=true;
	float saldo=0;
	while (recorrer_usuarios.hasNext() && flag==true){                                         
	    usuario = recorrer_usuarios.next(); 
	    if (usuario.obtenerNombre().equals(nomUsu)){
		saldo=usuario.obtenerSaldo();
		flag=false;
	    }
	}
	return saldo;
    }
    
}

