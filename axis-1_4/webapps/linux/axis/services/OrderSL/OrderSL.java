/**
 * OrderSL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package linux.axis.services.OrderSL;

public interface OrderSL extends java.rmi.Remote {
    public java.lang.Object[] obtenerProductos() throws java.rmi.RemoteException;
    public java.lang.Object[] obtenerPedidos(java.lang.String in0) throws java.rmi.RemoteException;
    public void realizarPedido(int[] in0, java.lang.String in1) throws java.rmi.RemoteException;
    public float obtenerSaldo(java.lang.String in0) throws java.rmi.RemoteException;
    public void cambiarDireccion(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public boolean existeUsuario(java.lang.String in0) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.OrderSL.Usuario crearUsuario(java.lang.String in0, float in1, java.lang.String in2) throws java.rmi.RemoteException;
    public void crearProducto(java.lang.String in0, float in1) throws java.rmi.RemoteException;
    public boolean existeProducto(java.lang.String in0) throws java.rmi.RemoteException;
    public float añadirSaldo(java.lang.String in0, float in1) throws java.rmi.RemoteException;
}
