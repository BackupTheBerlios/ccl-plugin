/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: Type.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     The type element specifies a type.
 *     Used in: type-export.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class Type implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _description;

    /**
     * 
     *     The type-name element specifies the name of a type.
     *     To rename the corresponding type the rename-as attribute
     * could be used.
     *     Used in: type.
     *    
    **/
    private TypeName _typeName;

    /**
     * 
     *     The type-attrs element describes a collection of
     * attributes of a type. 
     *     Used in: type.
     *    
    **/
    private TypeAttrs _typeAttrs;

    /**
     * 
     *     The type-methods element describes a collection of
     * methods provided 
     *     by a given type
     *    
    **/
    private TypeMethods _typeMethods;

    /**
     * 
     *     The properties element specifies a sequence of key-value
     * pairs to
     *     contain any information about its parent element.
     *     Used in: component-identifier, import, export, method,
     * type.
     *    
    **/
    private Properties _properties;


      //----------------/
     //- Constructors -/
    //----------------/

    public Type() {
        super();
    } //-- de.fhg.isst.ComponentML.Type()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

    /**
    **/
    public TypeAttrs getTypeAttrs()
    {
        return this._typeAttrs;
    } //-- TypeAttrs getTypeAttrs() 

    /**
    **/
    public TypeMethods getTypeMethods()
    {
        return this._typeMethods;
    } //-- TypeMethods getTypeMethods() 

    /**
    **/
    public TypeName getTypeName()
    {
        return this._typeName;
    } //-- TypeName getTypeName() 

    /**
    **/
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * @param out
    **/
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * @param handler
    **/
    public void marshal(org.xml.sax.DocumentHandler handler)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.DocumentHandler) 

    /**
     * 
     * @param description
    **/
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * 
     * @param properties
    **/
    public void setProperties(Properties properties)
    {
        this._properties = properties;
    } //-- void setProperties(Properties) 

    /**
     * 
     * @param typeAttrs
    **/
    public void setTypeAttrs(TypeAttrs typeAttrs)
    {
        this._typeAttrs = typeAttrs;
    } //-- void setTypeAttrs(TypeAttrs) 

    /**
     * 
     * @param typeMethods
    **/
    public void setTypeMethods(TypeMethods typeMethods)
    {
        this._typeMethods = typeMethods;
    } //-- void setTypeMethods(TypeMethods) 

    /**
     * 
     * @param typeName
    **/
    public void setTypeName(TypeName typeName)
    {
        this._typeName = typeName;
    } //-- void setTypeName(TypeName) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.Type unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.Type) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.Type.class, reader);
    } //-- de.fhg.isst.ComponentML.Type unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
