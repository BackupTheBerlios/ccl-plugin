/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ConnectorSpec.java,v 1.1 2002/03/19 18:56:06 ali Exp $
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
 *     The connector-spec element specifies a component and the
 * entities imported 
 *     from a component.
 *     Used in: configuration-section.
 *    
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class ConnectorSpec implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _description;

    /**
     * 
     *     The component-spec-ref element describes a reference to
     * a possibly 
     *     remote component-spec described by an URL element.
     * Specified
     *     properties will be compared to given ones in the
     * referenced spec.
     *     Used in: component, connector-spec.
     *    
    **/
    private ComponentSpecRef _componentSpecRef;

    /**
     * 
     *     The lifecycle-import element specifies a collection of
     * lifecycle 
     *     methods imported from the given component.
     *     Used in: connector-spec.
     *    
    **/
    private LifecycleImport _lifecycleImport;

    private ConnectorSpecChoice _connectorSpecChoice;

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

    public ConnectorSpec() {
        super();
    } //-- de.fhg.isst.ComponentML.ConnectorSpec()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public ComponentSpecRef getComponentSpecRef()
    {
        return this._componentSpecRef;
    } //-- ComponentSpecRef getComponentSpecRef() 

    /**
    **/
    public ConnectorSpecChoice getConnectorSpecChoice()
    {
        return this._connectorSpecChoice;
    } //-- ConnectorSpecChoice getConnectorSpecChoice() 

    /**
    **/
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
    **/
    public LifecycleImport getLifecycleImport()
    {
        return this._lifecycleImport;
    } //-- LifecycleImport getLifecycleImport() 

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

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
     * @param componentSpecRef
    **/
    public void setComponentSpecRef(ComponentSpecRef componentSpecRef)
    {
        this._componentSpecRef = componentSpecRef;
    } //-- void setComponentSpecRef(ComponentSpecRef) 

    /**
     * 
     * @param connectorSpecChoice
    **/
    public void setConnectorSpecChoice(ConnectorSpecChoice connectorSpecChoice)
    {
        this._connectorSpecChoice = connectorSpecChoice;
    } //-- void setConnectorSpecChoice(ConnectorSpecChoice) 

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
     * @param lifecycleImport
    **/
    public void setLifecycleImport(LifecycleImport lifecycleImport)
    {
        this._lifecycleImport = lifecycleImport;
    } //-- void setLifecycleImport(LifecycleImport) 

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
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ConnectorSpec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ConnectorSpec) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ConnectorSpec.class, reader);
    } //-- de.fhg.isst.ComponentML.ConnectorSpec unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
