/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: Method.java,v 1.1 2003/07/12 18:21:47 layekers Exp $
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
 *     The method element describes an exported exposed or imported
 * method.
 *     Used in: business-expose, business-export, lifecycle-export,
 *              lifecycle-import.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:47 $
**/
public class Method implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _description;

    /**
     * 
     *     The method-name element specifies the name of a method.
     *     Specifying the rename-as attribute the method-name could
     * be changed.
     *     Used in: method.
     *    
    **/
    private MethodName _methodName;

    /**
     * 
     *     The method-parameters element describes a collection of
     * method 
     *     parameters.
     *     Used in: method.
     *    
    **/
    private MethodParameters _methodParameters;

    /**
     * 
     *     The method-return-type-ref specifies a reference to the 
     * type of the 
     *     return-value of the method. Using the container-type
     * attribute 
     *     array or collection types can be specified. 
     *     Used in: method.
     *    
    **/
    private MethodReturnTypeRef _methodReturnTypeRef;

    /**
     * 
     *     The raised-exceptions element specifies a collection of 
     *     exception-type-ref elements describing the types of
     * exceptions 
     *     raised by that method.
     *     Used in: method.
     *    
    **/
    private RaisedExceptions _raisedExceptions;

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

    public Method() {
        super();
    } //-- de.fhg.isst.ComponentML.Method()


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
    public MethodName getMethodName()
    {
        return this._methodName;
    } //-- MethodName getMethodName() 

    /**
    **/
    public MethodParameters getMethodParameters()
    {
        return this._methodParameters;
    } //-- MethodParameters getMethodParameters() 

    /**
    **/
    public MethodReturnTypeRef getMethodReturnTypeRef()
    {
        return this._methodReturnTypeRef;
    } //-- MethodReturnTypeRef getMethodReturnTypeRef() 

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

    /**
    **/
    public RaisedExceptions getRaisedExceptions()
    {
        return this._raisedExceptions;
    } //-- RaisedExceptions getRaisedExceptions() 

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
     * @param methodName
    **/
    public void setMethodName(MethodName methodName)
    {
        this._methodName = methodName;
    } //-- void setMethodName(MethodName) 

    /**
     * 
     * @param methodParameters
    **/
    public void setMethodParameters(MethodParameters methodParameters)
    {
        this._methodParameters = methodParameters;
    } //-- void setMethodParameters(MethodParameters) 

    /**
     * 
     * @param methodReturnTypeRef
    **/
    public void setMethodReturnTypeRef(MethodReturnTypeRef methodReturnTypeRef)
    {
        this._methodReturnTypeRef = methodReturnTypeRef;
    } //-- void setMethodReturnTypeRef(MethodReturnTypeRef) 

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
     * @param raisedExceptions
    **/
    public void setRaisedExceptions(RaisedExceptions raisedExceptions)
    {
        this._raisedExceptions = raisedExceptions;
    } //-- void setRaisedExceptions(RaisedExceptions) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.Method unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.Method) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.Method.class, reader);
    } //-- de.fhg.isst.ComponentML.Method unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
