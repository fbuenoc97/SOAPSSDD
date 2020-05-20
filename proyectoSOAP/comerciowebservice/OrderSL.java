package comerciowebservice;

import java.util.Vector;

public class OrderSL{

    private Vector usuarios =null;
    private Vector productos=null;
    private Vector pedidos=null;

    public OrderSL(){

	usuarios=new Vector();
	productos=new Vector();
	pedidos=new Vector();

    }

    public Usuario crearUsuario(String nomUsu, float saldo, String direccion) throws Exception{

	Usuario usu=null;
	
	if(nomUsu==null || direccion==null)
	   throw new Exception("Datos invalidos");
	else{
	    usu=new Usuario(nomUsu, saldo, direccion);
	    usuarios.add(usu);
	}
	return usu;
    }

    public Producto crearProducto(String nombre, int id, float precio) throws Exception{

	Producto prod=null;
	
	    if(nombre==null )
		throw new Exception("Datos invalidos");
	    else{
		prod= new Producto(nombre, id, precio);
		productos.add(prod);
	    }
	return prod;
    }

}
