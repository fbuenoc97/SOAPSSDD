/**
 * OrderSL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package linux.axis.services.OrderSL;

public interface OrderSL extends java.rmi.Remote {
    public boolean existeProducto(java.lang.String in0) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Pedido crearPedido(int in0, es.uc3m.www.WS.OrderSL.Producto in1, java.lang.String in2, float in3, java.lang.String in4) throws java.rmi.RemoteException;
    public float getSaldo(java.lang.String in0) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Usuario setSaldo(java.lang.String in0, float in1) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Usuario setDireccion(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Usuario crearUsuario(java.lang.String in0, float in1, java.lang.String in2) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Producto crearProducto(java.lang.String in0, int in1, float in2) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Usuario existeUsuario(java.lang.String in0) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Producto[] getProductos() throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Pedido[] getPedidos(java.lang.String in0) throws java.rmi.RemoteException;
}