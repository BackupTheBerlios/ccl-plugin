/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: MethodParameter.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import de.fhg.isst.ComponentML.types.IOType;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     The method-parameter element specifies a method parameter.
 *     The type attribute specifies whether the parameter 
 *     is an  input, an output or an in/out parameter. The
 * parameter-attr 
 *     element must be one of the following four:   
 *     Use in method-parameters.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class MethodParameter implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private de.fhg.isst.ComponentML.types.IOType _type = de.fhg.isst.ComponentML.types.IOType.valueOf("inout");;

    private java.lang.String _description;

    private java.lang.String _parameterName;

    private java.lang.String _parameterTypeRef;


      //----------------/
     //- Constructors -/
    //----------------/

    public MethodParameter() {
        super();
    } //-- de.fhg.isst.ComponentML.MethodParameter()


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
    public java.lang.String getParameterName()
    {
        return this._parameterName;
    } //-- java.lang.String getParameterName() 

    /**
    **/
    public java.lang.String getParameterTypeRef()
    {
        return this._parameterTypeRef;
    } //-- java.lang.String getParameterTypeRef() 

    /**
    **/
    public de.fhg.isst.ComponentML.types.IOType getType()
    {
        return this._type;
    } //-- de.fhg.isst.ComponentML.types.IOType getType() 

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
     * @param parameterName
    **/
    public void setParameterName(java.lang.String parameterName)
    {
        this._parameterName = parameterName;
    } //-- void setParameterName(java.lang.String) 

    /**
     * 
     * @param parameterTypeRef
    **/
    public void setParameterTypeRef(java.lang.String parameterTypeRef)
    {
        this._parameterTypeRef = parameterTypeRef;
    } //-- void setParameterTypeRef(java.lang.String) 

    /**
     * 
     * @param type
    **/
    public void setType(de.fhg.isst.ComponentML.types.IOType type)
    {
        this._type = type;
    } //-- void setType(de.fhg.isst.ComponentML.types.IOType) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.MethodParameter unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.MethodParameter) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.MethodParameter.class, reader);
    } //-- de.fhg.isst.ComponentML.MethodParameter unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
