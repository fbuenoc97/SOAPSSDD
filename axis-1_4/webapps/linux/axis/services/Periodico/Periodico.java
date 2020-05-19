/**
 * Periodico.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package linux.axis.services.Periodico;

public interface Periodico extends java.rmi.Remote {
    public void insert(es.uc3m.www.WS.Periodico.Noticia in0) throws java.rmi.RemoteException;
    public es.uc3m.www.WS.Periodico.Noticia[] query(java.lang.String in0) throws java.rmi.RemoteException;
}
