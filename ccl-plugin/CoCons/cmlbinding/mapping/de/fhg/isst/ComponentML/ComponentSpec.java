/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ComponentSpec.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 *     The component-spec element is the root element of a
 *     component spec. It contains
 *     - an optional description of the component
 *     - identification of the component
 *     - a specification of exported entities
 *     - an optional specification of types and services required
 * by the 
 *       component
 *     - an optional specification of the component configuration
 *     - an optional specification of bindings between interfaces
 * and 
 *       realizations
 *     - an optional specification of runtime requirements
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class ComponentSpec implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _description;

    /**
     * 
     *     The component-identifier element specifies a unique name
     * of the 
     *     component and maybe more needful things.
     *     Used in: component-spec.
     *    
    **/
    private GlobalSection _globalSection;

    /**
     * 
     *     The export-section element specifies a collection of
     * exports.
     *     Used in: component-spec.
     *    
    **/
    private ExportSection _exportSection;

    /**
     * 
     *     The import-section element specifies a collection types
     * and 
     *     business-functions the component wanted to import.
     *     A concrete binding of imported items and components
     * exporting items 
     *     is specified in the cofiguration section.
     *     Used in: component-spec.
     *    
    **/
    private ImportSection _importSection;

    /**
     * 
     *     The configuration-section element specifies how other
     * components are 
     *     used in aggregation oder composition.
     *     Used in: component-spec.
     *    
    **/
    private ConfigurationSection _configurationSection;

    /**
     * 
     *     The binding-section element describes the binding of
     * component-specs with
     *     their implementation.
     *     Used in: component-application.
     *    
    **/
    private BindingSection _bindingSection;

    /**
     * 
     *     The runtime-environment element contains a collection 
     *     of runtime-requirements like transaction behaviour,
     * security 
     *     requiremente etc needed by the specified  component to
     * work properly.
     *     Used in. component-spec.
     *    
    **/
    private RuntimeEnvironment _runtimeEnvironment;

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

    public ComponentSpec() {
        super();
    } //-- de.fhg.isst.ComponentML.ComponentSpec()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public BindingSection getBindingSection()
    {
        return this._bindingSection;
    } //-- BindingSection getBindingSection() 

    /**
    **/
    public ConfigurationSection getConfigurationSection()
    {
        return this._configurationSection;
    } //-- ConfigurationSection getConfigurationSection() 

    /**
    **/
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
    **/
    public ExportSection getExportSection()
    {
        return this._exportSection;
    } //-- ExportSection getExportSection() 

    /**
    **/
    public GlobalSection getGlobalSection()
    {
        return this._globalSection;
    } //-- GlobalSection getGlobalSection() 

    /**
    **/
    public ImportSection getImportSection()
    {
        return this._importSection;
    } //-- ImportSection getImportSection() 

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

    /**
    **/
    public RuntimeEnvironment getRuntimeEnvironment()
    {
        return this._runtimeEnvironment;
    } //-- RuntimeEnvironment getRuntimeEnvironment() 

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
     * @param bindingSection
    **/
    public void setBindingSection(BindingSection bindingSection)
    {
        this._bindingSection = bindingSection;
    } //-- void setBindingSection(BindingSection) 

    /**
     * 
     * @param configurationSection
    **/
    public void setConfigurationSection(ConfigurationSection configurationSection)
    {
        this._configurationSection = configurationSection;
    } //-- void setConfigurationSection(ConfigurationSection) 

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
     * @param exportSection
    **/
    public void setExportSection(ExportSection exportSection)
    {
        this._exportSection = exportSection;
    } //-- void setExportSection(ExportSection) 

    /**
     * 
     * @param globalSection
    **/
    public void setGlobalSection(GlobalSection globalSection)
    {
        this._globalSection = globalSection;
    } //-- void setGlobalSection(GlobalSection) 

    /**
     * 
     * @param importSection
    **/
    public void setImportSection(ImportSection importSection)
    {
        this._importSection = importSection;
    } //-- void setImportSection(ImportSection) 

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
     * @param runtimeEnvironment
    **/
    public void setRuntimeEnvironment(RuntimeEnvironment runtimeEnvironment)
    {
        this._runtimeEnvironment = runtimeEnvironment;
    } //-- void setRuntimeEnvironment(RuntimeEnvironment) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ComponentSpec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ComponentSpec) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ComponentSpec.class, reader);
    } //-- de.fhg.isst.ComponentML.ComponentSpec unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
