/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ServiceOriented.java,v 1.1 2003/07/12 18:21:47 layekers Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import de.fhg.isst.ComponentML.types.YesNoType;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     The empty service-oriented element characterizes a component
 * as 
 *     a service-oriented component. 
 *     The value of the preserve-state attribute characterizes that
 * 
 *     component as a stateful (preserve-state="yes") or as a
 * stateless 
 *     (preserve-state="no") component.
 *     Used in: component-category.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:47 $
**/
public class ServiceOriented implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private de.fhg.isst.ComponentML.types.YesNoType _preserveState = de.fhg.isst.ComponentML.types.YesNoType.valueOf("yes");;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceOriented() {
        super();
    } //-- de.fhg.isst.ComponentML.ServiceOriented()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public de.fhg.isst.ComponentML.types.YesNoType getPreserveState()
    {
        return this._preserveState;
    } //-- de.fhg.isst.ComponentML.types.YesNoType getPreserveState() 

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
     * @param preserveState
    **/
    public void setPreserveState(de.fhg.isst.ComponentML.types.YesNoType preserveState)
    {
        this._preserveState = preserveState;
    } //-- void setPreserveState(de.fhg.isst.ComponentML.types.YesNoType) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ServiceOriented unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ServiceOriented) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ServiceOriented.class, reader);
    } //-- de.fhg.isst.ComponentML.ServiceOriented unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
