/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ImportSection.java,v 1.1 2003/07/12 18:21:46 layekers Exp $
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
 *     The import-section element specifies a collection types and 
 *     business-functions the component wanted to import.
 *     A concrete binding of imported items and components
 * exporting items 
 *     is specified in the cofiguration section.
 *     Used in: component-spec.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:46 $
**/
public class ImportSection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _description;

    /**
     * 
     *     The type-import element specifies a collection of types
     * imported 
     *     from the given component.
     *     If the rename-as attribute is specified a type will be
     * known with the 
     *     name specified there.
     *     Used in: connector-spec, import-section.
     *    
    **/
    private TypeImport _typeImport;

    /**
     * 
     *     The business-import element specifies a collection of
     * business methods 
     *     a component imports from a given component.
     *     If the rename-as attribute of the method-name element is
     * specified the 
     *     method is imported with the name given there.
     *     Used in: import-section, connector-spec.
     *    
    **/
    private BusinessImport _businessImport;

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

    public ImportSection() {
        super();
    } //-- de.fhg.isst.ComponentML.ImportSection()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public BusinessImport getBusinessImport()
    {
        return this._businessImport;
    } //-- BusinessImport getBusinessImport() 

    /**
    **/
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
    **/
    public Properties getProperties()
    {
        return this._properties;
    } //-- Properties getProperties() 

    /**
    **/
    public TypeImport getTypeImport()
    {
        return this._typeImport;
    } //-- TypeImport getTypeImport() 

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
     * @param businessImport
    **/
    public void setBusinessImport(BusinessImport businessImport)
    {
        this._businessImport = businessImport;
    } //-- void setBusinessImport(BusinessImport) 

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
     * @param properties
    **/
    public void setProperties(Properties properties)
    {
        this._properties = properties;
    } //-- void setProperties(Properties) 

    /**
     * 
     * @param typeImport
    **/
    public void setTypeImport(TypeImport typeImport)
    {
        this._typeImport = typeImport;
    } //-- void setTypeImport(TypeImport) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ImportSection unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ImportSection) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ImportSection.class, reader);
    } //-- de.fhg.isst.ComponentML.ImportSection unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
