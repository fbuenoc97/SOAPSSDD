// Este fichero usa las clases generadas por axis a partir del WSDL

import es.uc3m.www.WS.OrderSL.*;
    import linux.axis.services.OrderSL.*;

    public class OrderSLClient {

      public static void main(String [] args) throws Exception {

        // Crear un servicio periodico
        OrderSLService service = new OrderSLServiceLocator();

        // Obtener un stub que utilizaremos para invocar los métodos remotos
        OrderSL port = service.getOrderSL();

        // Invocar los métodos

	Usuario usu;
	
        usu=port.crearUsuario("felipe", 20, "Sevilla");
	Producto prod;
	prod=port.crearProducto("ps4", 25, 300);
	Producto prod2;
	prod2=port.crearProducto("mesa", 2, 10);
	Producto [] productos = port.getProductos();
	for(int k = 0; k < productos.length; k++){
		System.out.println(productos[k].getNombre());
		System.out.println(productos[k].getPrecio());
		System.out.println("-------------------");
	}
	System.out.println("saldo: "+port.getSaldo(usu.getNombre()));
	Pedido ped;
	ped = port.crearPedido(1,prod, usu.getNombre(), prod.getPrecio(), usu.getDireccion());
	if(ped==null)
		System.out.println("Nullaso");	
	Pedido ped2;
	ped2 = port.crearPedido(5,prod2, usu.getNombre(), prod2.getPrecio(), usu.getDireccion());
	Pedido [] pedidos = port.getPedidos(usu.getNombre());
	for(int k = 0; k < pedidos.length; k++){
		System.out.println(pedidos[k].getId());
		System.out.println(pedidos[k].getPrecio());
		System.out.println(pedidos[k].getDireccion());
		System.out.println(pedidos[k].getNombre());
		System.out.println("-------------------");
	}
		System.out.println("saldo: "+port.getSaldo(usu.getNombre()));
      }
    }

