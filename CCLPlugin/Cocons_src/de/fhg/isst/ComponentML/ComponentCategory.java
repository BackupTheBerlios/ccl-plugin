/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ComponentCategory.java,v 1.1 2003/07/12 18:21:45 layekers Exp $
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
 *     The component-category elemend declares the component type.
 *     Components could either be message-oriented,
 * service-oriented 
 *     or type-declaring. 
 * 
 *     If that element is not specified a stateful
 *     service-oriented component will be assumed.
 *     Used in: component-spec.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:45 $
**/
public class ComponentCategory implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The empty message-oriented element characterizes the
     * specified 
     *     component as a message-oriented component.
     *    
    **/
    private MessageOriented _messageOriented;

    /**
     * 
     *     The empty service-oriented element characterizes a
     * component as 
     *     a service-oriented component. 
     *     The value of the preserve-state attribute characterizes
     * that 
     *     component as a stateful (preserve-state="yes") or as a
     * stateless 
     *     (preserve-state="no") component.
     *     Used in: component-category.
     *    
    **/
    private ServiceOriented _serviceOriented;

    /**
     * 
     *     The empty type-declaring element characterizes a
     * component as a 
     *     component which declares only types.
     *    
    **/
    private TypeDeclaring _typeDeclaring;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComponentCategory() {
        super();
    } //-- de.fhg.isst.ComponentML.ComponentCategory()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public MessageOriented getMessageOriented()
    {
        return this._messageOriented;
    } //-- MessageOriented getMessageOriented() 

    /**
    **/
    public ServiceOriented getServiceOriented()
    {
        return this._serviceOriented;
    } //-- ServiceOriented getServiceOriented() 

    /**
    **/
    public TypeDeclaring getTypeDeclaring()
    {
        return this._typeDeclaring;
    } //-- TypeDeclaring getTypeDeclaring() 

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
     * @param messageOriented
    **/
    public void setMessageOriented(MessageOriented messageOriented)
    {
        this._messageOriented = messageOriented;
    } //-- void setMessageOriented(MessageOriented) 

    /**
     * 
     * @param serviceOriented
    **/
    public void setServiceOriented(ServiceOriented serviceOriented)
    {
        this._serviceOriented = serviceOriented;
    } //-- void setServiceOriented(ServiceOriented) 

    /**
     * 
     * @param typeDeclaring
    **/
    public void setTypeDeclaring(TypeDeclaring typeDeclaring)
    {
        this._typeDeclaring = typeDeclaring;
    } //-- void setTypeDeclaring(TypeDeclaring) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ComponentCategory unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ComponentCategory) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ComponentCategory.class, reader);
    } //-- de.fhg.isst.ComponentML.ComponentCategory unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
