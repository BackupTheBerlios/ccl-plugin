/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ConfigurationSection.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 *     The configuration-section element specifies how other
 * components are 
 *     used in aggregation oder composition.
 *     Used in: component-spec.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class ConfigurationSection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The used-components element contains a collection of
     * specs
     *     of used components.
     *    
    **/
    private UsedComponents _usedComponents;

    /**
     * 
     *     The composed-components element contains a collection of
     * specs
     *     composed components.
     *     Used in: configuration-section. 
     *    
    **/
    private ComposedComponents _composedComponents;


      //----------------/
     //- Constructors -/
    //----------------/

    public ConfigurationSection() {
        super();
    } //-- de.fhg.isst.ComponentML.ConfigurationSection()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public ComposedComponents getComposedComponents()
    {
        return this._composedComponents;
    } //-- ComposedComponents getComposedComponents() 

    /**
    **/
    public UsedComponents getUsedComponents()
    {
        return this._usedComponents;
    } //-- UsedComponents getUsedComponents() 

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
     * @param composedComponents
    **/
    public void setComposedComponents(ComposedComponents composedComponents)
    {
        this._composedComponents = composedComponents;
    } //-- void setComposedComponents(ComposedComponents) 

    /**
     * 
     * @param usedComponents
    **/
    public void setUsedComponents(UsedComponents usedComponents)
    {
        this._usedComponents = usedComponents;
    } //-- void setUsedComponents(UsedComponents) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ConfigurationSection unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ConfigurationSection) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ConfigurationSection.class, reader);
    } //-- de.fhg.isst.ComponentML.ConfigurationSection unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
