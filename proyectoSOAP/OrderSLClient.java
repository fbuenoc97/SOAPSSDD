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
	
        usu=port.crearUsuario("jaime", 20, "Sevilla");

        

        System.out.println(usu.getNombre());
      }
    }

