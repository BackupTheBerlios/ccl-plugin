/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: MethodReturnTypeRef.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import de.fhg.isst.ComponentML.types.ContainerTypeType;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     The method-return-type-ref specifies a reference to the 
 * type of the 
 *     return-value of the method. Using the container-type
 * attribute 
 *     array or collection types can be specified. 
 *     Used in: method.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class MethodReturnTypeRef implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
    **/
    private java.lang.String _content = "";

    private de.fhg.isst.ComponentML.types.ContainerTypeType _containerType = de.fhg.isst.ComponentML.types.ContainerTypeType.valueOf("none");;

    private int _arrayDimension = 0;

    /**
     * keeps track of state for field: _arrayDimension
    **/
    private boolean _has_arrayDimension;


      //----------------/
     //- Constructors -/
    //----------------/

    public MethodReturnTypeRef() {
        super();
    } //-- de.fhg.isst.ComponentML.MethodReturnTypeRef()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public void deleteArrayDimension()
    {
        this._has_arrayDimension= false;
    } //-- void deleteArrayDimension() 

    /**
    **/
    public int getArrayDimension()
    {
        return this._arrayDimension;
    } //-- int getArrayDimension() 

    /**
    **/
    public de.fhg.isst.ComponentML.types.ContainerTypeType getContainerType()
    {
        return this._containerType;
    } //-- de.fhg.isst.ComponentML.types.ContainerTypeType getContainerType() 

    /**
    **/
    public java.lang.String getContent()
    {
        return this._content;
    } //-- java.lang.String getContent() 

    /**
    **/
    public boolean hasArrayDimension()
    {
        return this._has_arrayDimension;
    } //-- boolean hasArrayDimension() 

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
     * @param arrayDimension
    **/
    public void setArrayDimension(int arrayDimension)
    {
        this._arrayDimension = arrayDimension;
        this._has_arrayDimension = true;
    } //-- void setArrayDimension(int) 

    /**
     * 
     * @param containerType
    **/
    public void setContainerType(de.fhg.isst.ComponentML.types.ContainerTypeType containerType)
    {
        this._containerType = containerType;
    } //-- void setContainerType(de.fhg.isst.ComponentML.types.ContainerTypeType) 

    /**
     * 
     * @param content
    **/
    public void setContent(java.lang.String content)
    {
        this._content = content;
    } //-- void setContent(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.MethodReturnTypeRef unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.MethodReturnTypeRef) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.MethodReturnTypeRef.class, reader);
    } //-- de.fhg.isst.ComponentML.MethodReturnTypeRef unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
