/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ExportSection.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 *     The export-section element specifies a collection of
 * exports.
 *     Used in: component-spec.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class ExportSection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The lifecycle-export element specifies a collection of
     *     lifecycle-methods  exported from the specified
     * component.
     *     Used in: export-section.
     *    
    **/
    private LifecycleExport _lifecycleExport;

    private ExportSectionChoice _exportSectionChoice;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExportSection() {
        super();
    } //-- de.fhg.isst.ComponentML.ExportSection()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public ExportSectionChoice getExportSectionChoice()
    {
        return this._exportSectionChoice;
    } //-- ExportSectionChoice getExportSectionChoice() 

    /**
    **/
    public LifecycleExport getLifecycleExport()
    {
        return this._lifecycleExport;
    } //-- LifecycleExport getLifecycleExport() 

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
     * @param exportSectionChoice
    **/
    public void setExportSectionChoice(ExportSectionChoice exportSectionChoice)
    {
        this._exportSectionChoice = exportSectionChoice;
    } //-- void setExportSectionChoice(ExportSectionChoice) 

    /**
     * 
     * @param lifecycleExport
    **/
    public void setLifecycleExport(LifecycleExport lifecycleExport)
    {
        this._lifecycleExport = lifecycleExport;
    } //-- void setLifecycleExport(LifecycleExport) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ExportSection unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ExportSection) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ExportSection.class, reader);
    } //-- de.fhg.isst.ComponentML.ExportSection unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
