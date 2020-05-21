/**
 * Pedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.uc3m.www.WS.OrderSL;

public class Pedido  implements java.io.Serializable {
    private es.uc3m.www.WS.OrderSL.Producto carrito;

    private java.lang.String direccion;

    private int id;

    private float precio;

    private es.uc3m.www.WS.OrderSL.Usuario usuario;

    public Pedido() {
    }

    public Pedido(
           es.uc3m.www.WS.OrderSL.Producto carrito,
           java.lang.String direccion,
           int id,
           float precio,
           es.uc3m.www.WS.OrderSL.Usuario usuario) {
           this.carrito = carrito;
           this.direccion = direccion;
           this.id = id;
           this.precio = precio;
           this.usuario = usuario;
    }


    /**
     * Gets the carrito value for this Pedido.
     * 
     * @return carrito
     */
    public es.uc3m.www.WS.OrderSL.Producto getCarrito() {
        return carrito;
    }


    /**
     * Sets the carrito value for this Pedido.
     * 
     * @param carrito
     */
    public void setCarrito(es.uc3m.www.WS.OrderSL.Producto carrito) {
        this.carrito = carrito;
    }


    /**
     * Gets the direccion value for this Pedido.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this Pedido.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the id value for this Pedido.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Pedido.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the precio value for this Pedido.
     * 
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }


    /**
     * Sets the precio value for this Pedido.
     * 
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }


    /**
     * Gets the usuario value for this Pedido.
     * 
     * @return usuario
     */
    public es.uc3m.www.WS.OrderSL.Usuario getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this Pedido.
     * 
     * @param usuario
     */
    public void setUsuario(es.uc3m.www.WS.OrderSL.Usuario usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pedido)) return false;
        Pedido other = (Pedido) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.carrito==null && other.getCarrito()==null) || 
             (this.carrito!=null &&
              this.carrito.equals(other.getCarrito()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            this.id == other.getId() &&
            this.precio == other.getPrecio() &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCarrito() != null) {
            _hashCode += getCarrito().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        _hashCode += getId();
        _hashCode += new Float(getPrecio()).hashCode();
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pedido.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.uc3m.es/WS/OrderSL", "Pedido"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carrito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carrito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc3m.es/WS/OrderSL", "Producto"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.uc3m.es/WS/OrderSL", "Usuario"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
