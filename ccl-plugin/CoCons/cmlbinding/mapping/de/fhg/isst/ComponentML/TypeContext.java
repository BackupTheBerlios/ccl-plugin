/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TypeContext.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import de.fhg.isst.ComponentML.types.PredefinedTypeContextType;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     Definition of the structure of a type-context element.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class TypeContext implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private de.fhg.isst.ComponentML.types.PredefinedTypeContextType _contextName;

    private ContextRef _contextRef;


      //----------------/
     //- Constructors -/
    //----------------/

    public TypeContext() {
        super();
    } //-- de.fhg.isst.ComponentML.TypeContext()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public de.fhg.isst.ComponentML.types.PredefinedTypeContextType getContextName()
    {
        return this._contextName;
    } //-- de.fhg.isst.ComponentML.types.PredefinedTypeContextType getContextName() 

    /**
    **/
    public ContextRef getContextRef()
    {
        return this._contextRef;
    } //-- ContextRef getContextRef() 

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
     * @param contextName
    **/
    public void setContextName(de.fhg.isst.ComponentML.types.PredefinedTypeContextType contextName)
    {
        this._contextName = contextName;
    } //-- void setContextName(de.fhg.isst.ComponentML.types.PredefinedTypeContextType) 

    /**
     * 
     * @param contextRef
    **/
    public void setContextRef(ContextRef contextRef)
    {
        this._contextRef = contextRef;
    } //-- void setContextRef(ContextRef) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.TypeContext unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.TypeContext) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.TypeContext.class, reader);
    } //-- de.fhg.isst.ComponentML.TypeContext unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
