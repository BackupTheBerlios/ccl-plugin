/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: Binding.java,v 1.1 2003/07/12 18:21:45 layekers Exp $
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
 *     The binding element describes a binding of a component-spec 
 *     with its implementation.
 *     Used in: binding-section.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:45 $
**/
public class Binding implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private ComponentName _componentName;

    private ComponentImplName _componentImplName;


      //----------------/
     //- Constructors -/
    //----------------/

    public Binding() {
        super();
    } //-- de.fhg.isst.ComponentML.Binding()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public ComponentImplName getComponentImplName()
    {
        return this._componentImplName;
    } //-- ComponentImplName getComponentImplName() 

    /**
    **/
    public ComponentName getComponentName()
    {
        return this._componentName;
    } //-- ComponentName getComponentName() 

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
     * @param componentImplName
    **/
    public void setComponentImplName(ComponentImplName componentImplName)
    {
        this._componentImplName = componentImplName;
    } //-- void setComponentImplName(ComponentImplName) 

    /**
     * 
     * @param componentName
    **/
    public void setComponentName(ComponentName componentName)
    {
        this._componentName = componentName;
    } //-- void setComponentName(ComponentName) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.Binding unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.Binding) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.Binding.class, reader);
    } //-- de.fhg.isst.ComponentML.Binding unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
