/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: GlobalSection.java,v 1.1 2003/07/12 18:21:46 layekers Exp $
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
 *     The component-identifier element specifies a unique name of
 * the 
 *     component and maybe more needful things.
 *     Used in: component-spec.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:46 $
**/
public class GlobalSection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private ComponentName _componentName;

    /**
     * 
     *     The component-category elemend declares the component
     * type.
     *     Components could either be message-oriented,
     * service-oriented 
     *     or type-declaring. 
     * 
     *     If that element is not specified a stateful
     *     service-oriented component will be assumed.
     *     Used in: component-spec.
     *    
    **/
    private ComponentCategory _componentCategory;

    /**
     * 
     *     Definition of the structure of a type-context element.
     *    
    **/
    private TypeContext _typeContext;

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

    public GlobalSection() {
        super();
    } //-- de.fhg.isst.ComponentML.GlobalSection()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public ComponentCategory getComponentCategory()
    {
        return this._componentCategory;
    } //-- ComponentCategory getComponentCategory() 

    /**
    **/
    public ComponentName getComponentName()
    {
        return this._componentName;
    } //-- ComponentName getComponentName() 

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

    /**
    **/
    public TypeContext getTypeContext()
    {
        return this._typeContext;
    } //-- TypeContext getTypeContext() 

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
     * @param componentCategory
    **/
    public void setComponentCategory(ComponentCategory componentCategory)
    {
        this._componentCategory = componentCategory;
    } //-- void setComponentCategory(ComponentCategory) 

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
     * @param properties
    **/
    public void setProperties(Properties properties)
    {
        this._properties = properties;
    } //-- void setProperties(Properties) 

    /**
     * 
     * @param typeContext
    **/
    public void setTypeContext(TypeContext typeContext)
    {
        this._typeContext = typeContext;
    } //-- void setTypeContext(TypeContext) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.GlobalSection unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.GlobalSection) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.GlobalSection.class, reader);
    } //-- de.fhg.isst.ComponentML.GlobalSection unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
