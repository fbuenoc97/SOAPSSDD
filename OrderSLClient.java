// Este fichero usa las clases generadas por axis a partir del WSDL

import es.uc3m.www.WS.OrderSL.*;
    import linux.axis.services.OrderSL.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class OrderSLClient {

    //Constantes que utilizaremos para saber qué acción del menú quiere realizar el cliente
    public static final int COMPROBAR_PEDIDOS = 1;
    public static final int MOSTRAR_CATÁLOGO = 2;
    public static final int REALIZAR_PEDIDO = 3;
    public static final int MODIFICAR_DIRECCION = 4;
    public static final int AÑADIR_SALDO = 5;
    public static final int AÑADIR_PRODUCTO = 6;
    public static final int SALIR = 7;

    public static void main(String [] args) throws Exception {

        // Crear un servicio OrderSL
        OrderSLService service = new OrderSLServiceLocator();

        // Obtener un stub que utilizaremos para invocar los métodos remotos
        OrderSL port = service.getOrderSL();

        // Invocar los métodos

	Usuario usu;
	
        System.out.println("Introduzca el nombre de usuario para entrar: ");
	Scanner sc=new Scanner(System.in);
	String nombre;
	nombre=sc.nextLine();
	
	usu= port.existeUsuario(nombre);
	if(usu==null){
	    System.out.println("Introduzca la direccion del usuario: ");
	    String direccion;
	    direccion=sc.nextLine();
	    usu=port.crearUsuario(nombre, 0, direccion);
	    if(usu!=null)
		System.out.println("Usuario creado correctamente");	    
	}
	    
	int flag=1;
	int flag4;
	int i=0;
	Producto [] catalogo;
	Pedido [] pedidos;
	while(flag==1){ //El bucle se seguirá realizando e imprimiendo el menú hasta que el cliente quiera salir
		 
	    
	    System.out.println("¡Bienvenido "+usu.getNombre()+"!");
	    System.out.println("--------------------------------------------------------------------");		
		
	    //Imprimimos por pantalla el archivo "OrderSL.txt" que es donde se encuentra el menú del programa
	    try{
		File f = new File("Menu.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		    
		while((linea=br.readLine())!=null)
		    System.out.println(linea);
	    }catch(Exception e){
		e.printStackTrace();
	    }
	    flag4=1;
	    if(i!=SALIR){		
		do{
		    try{
			i = sc.nextInt(); //La variable i contendrá el valor de la acción del menú que quiere ejecutar el cliente. 
			flag4 = 0;
		    }catch(InputMismatchException e){
			System.out.println("Error introduciendo datos"); 
			sc.next();
		    }
		}while(flag4==1);
	    }
	    catalogo=port.getProductos(); //Obtenemos el catalogo de productos actualizado
	    switch (i){ //Según la opción que haya elegido el cliente ejecutaremos un case u otro
	    case COMPROBAR_PEDIDOS:
		clear(); //Limpiamos el terminal
		pedidos = port.getPedidos(usu.getNombre()); //Llamamos a la función que imprime los pedidos vinculados a este usuario. Devuelve el número de pedidos
		if (pedidos.length==0)
		    System.out.println("No existe ningún pedido vinculado a este usuario");
		else{
		    for(int k=0; k<pedidos.length ; k++){
			Pedido p=pedidos[k];
			System.out.println("Nombre del usuario: "+ p.getNombre());
			System.out.println("Id del pedido: "+ p.getId());
			System.out.println("Nombre del producto: "+ p.getCarrito().getNombre());
			System.out.println("Precio: "+ p.getPrecio());
			System.out.println("Direccion: "+ p.getDireccion());			
		    }
		    
		}
		System.out.println("--------------------------------------------------------------------"); 
		break;
	    case MOSTRAR_CATÁLOGO:
		clear(); //Limpiamos el terminal
		System.out.println("--------------------------------------------------------------------"); 
		if(catalogo.length==0) 
		    System.out.println("Catálogo vacío");
		else{
		    for(int k=0;k<catalogo.length; k++){ //Imprimimos el catálogo por pantalla
			Producto prod= catalogo[k];
			System.out.println(prod.getNombre() + "	precio: " + prod.getPrecio() +" €	id: " + prod.getId()); 
		    }
		}
		System.out.println("---------------------------------------------------------------------"); 
		break;
	    case REALIZAR_PEDIDO:
		clear();
		Pedido ped=realizarPedido(usu, catalogo, port);
		//Realizamos un pedido y devolvemos el usuario
		Thread.sleep(3000);                       
		clear();
		break;
	    case MODIFICAR_DIRECCION:
		clear();
		String direccion="";

		do{
		    System.out.println("Introduzca nueva direccion: ");
		    try{			
			direccion = sc.nextLine();
			if(direccion.length()!=0)
			    flag4 = 0;
		    }catch(InputMismatchException e){
			System.out.println("Error introduciendo datos"); 
		    }
		}while(flag4==1);
		flag4=1;
		usu=port.setDireccion(usu.getNombre(),direccion); //Le cambiamos la direccion en el servidor y obtenemos el usuario actualizado
		System.out.println("Direccion cambiada correctamente");

		
		break;
	    case AÑADIR_SALDO:
		clear();
		float aux=0;

		do{
		    try{
			System.out.println("Saldo actual: "+ port.getSaldo(usu.getNombre()));
			System.out.println("Saldo a añadir: ");
			
			aux = sc.nextFloat();
			flag4 = 0;
		    }catch(InputMismatchException e){
			System.out.println("Error introduciendo datos"); 
		    }
		}while(flag4==1);
		//Se añade el saldo en el servidor y se obtiene el usuario actualizado	
		usu=port.setSaldo(usu.getNombre(),aux);
		System.out.println(" \n Nuevo saldo: "+ port.getSaldo(usu.getNombre())+" € ");
	
		

		
		Thread.sleep(3000);
		clear();
		break;
	    case AÑADIR_PRODUCTO:
		clear();
		añadirProducto(port);
		clear(); 
		System.out.println("Producto añadido correctamente");	
		System.out.println("----------------------------------------------------"); 		   
		
			
		break;
	    case SALIR:
		clear();
		flag = 0;
		break;
	    default:
		System.err.println("Número introducido no válido ");
	    }
	}
	
    }

    public static Pedido realizarPedido(Usuario u, Producto[] catalogo, OrderSL srv){ //Esta función le pasará al servidor todo lo necesario para añadir un nuevo producto al catalogo
	int flag = 0;
	Producto producto=null;
	Pedido pedido=null;//Este objeto pedido será el que se devuelva al main
	int aux=0;
	boolean existe = false;
	int i=0;
	int flag4 = 1;
	float precio_total = 0;
	boolean cancelado = false;
	//Imprimimos el catalogo
	if(catalogo.length==0) 
	    System.out.println("Catálogo vacío"); 
	else{
	    for(int k=0;k<catalogo.length; k++){ //Imprimimos el catálogo por pantalla
		Producto prod= catalogo[k];
		System.out.println(prod.getNombre() + "	precio: " + prod.getPrecio() +" €	id: " + prod.getId());
	    }
	}
	
	System.out.println("-------------------------------------------");	
	while(flag == 0){
	    System.out.println("Introduzca el id del producto");
	    System.out.println("Introduzca 0 para finalizar pedido");
	    System.out.println("Introduzca -1 para cancelar pedido");
	    do{
		try{
		    Scanner sc = new Scanner(System.in);	
		    i = sc.nextInt();
		    flag4 = 0;
		}catch(InputMismatchException e){
		    System.out.println("Error introduciendo datos"); 
		}
	    }while(flag4==1);
	    switch(i){
	    case 0:		
		flag=1;
		break;
	    case -1:
		System.out.println("Pedido cancelado");
		cancelado = true;
		flag = 1;
		break;
	    default:
		for(int k=0;k<catalogo.length; k++){
		    if(catalogo[k].getId() == i){
			existe = true;
			precio_total+=catalogo[k].getPrecio();
			producto=catalogo[k];
		    }
		}
		if(existe){
		    existe=false;
		    try{
			pedido=srv.crearPedido(producto, u.getNombre(), producto.getPrecio(), u.getDireccion());
		    }catch(Exception e){
			System.err.println("No se ha podido crear pedido ");
		    }
		    if (pedido==null)
			System.out.println("Saldo insuficiente");
		    else{
			System.out.println("Pedido realizado");
			flag=1;
		    }
		}
		else{
		    System.out.println("El producto introducido no existe");
		}
	    }
	}
	
	return pedido;
    }

    public static void añadirProducto(OrderSL srv){
	int flag4=1;
	int flag2=1;
	String nombre="";
	float precio=0;
	boolean existe=false;
	do{
	    System.out.println("Nombre del producto a añadir: ");
	    try{
		Scanner sc = new Scanner(System.in);
		nombre = sc.nextLine();
		if(nombre.length()!=0)
		    flag4 = 0;
	    }catch(InputMismatchException e){
		System.out.println("Error introduciendo datos"); 
	    }
	    try{
		existe = srv.existeProducto(nombre); //Comprobamos si existe el producto
		if(existe){
		    System.out.println("El nombre del producto ya existe"); 		
		    flag4=1;
		}
	    }catch(Exception e){
		System.out.println("Excepción comprobando si existe el producto");		
	    }
	}while(flag4==1);
	flag4=1;    
	do{
	    System.out.println("Precio del producto a añadir: ");		
	    try{
		Scanner sc = new Scanner(System.in);
		precio = sc.nextFloat();
		flag4 = 0;
	    }catch(InputMismatchException e){
		System.out.println("Error introduciendo datos"); 
	    }
	}while(flag4==1);
	try{
	    int id;
	    Random numAleatorio = new Random();   // Genera un int de forma aleatoria
		id = numAleatorio.nextInt();
		srv.crearProducto(nombre, id, precio);
	}catch(Exception e){
	}
    }

    public static void clear() {  
	System.out.print("\033[H\033[2J");  
	System.out.flush();  
    } 

}
