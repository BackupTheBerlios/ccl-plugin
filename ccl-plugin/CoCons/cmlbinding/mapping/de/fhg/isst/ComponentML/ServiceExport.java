/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ServiceExport.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
 */

package de.fhg.isst.ComponentML;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import de.fhg.isst.ComponentML.types.ExportScopeType;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 *     The service-export element describes a collection of
 * business and
 *     lifecycle-exports for a given export-scope.
 *     Used in: export-section.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class ServiceExport implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private de.fhg.isst.ComponentML.types.ExportScopeType _exportScope = de.fhg.isst.ComponentML.types.ExportScopeType.valueOf("remote");;

    /**
     * 
     *     The business-export element specifies a collection 
     * methods
     *     exported by the specified component.
     *     Used in: export-section.
     *    
    **/
    private BusinessExport _businessExport;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceExport() {
        super();
    } //-- de.fhg.isst.ComponentML.ServiceExport()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public BusinessExport getBusinessExport()
    {
        return this._businessExport;
    } //-- BusinessExport getBusinessExport() 

    /**
    **/
    public de.fhg.isst.ComponentML.types.ExportScopeType getExportScope()
    {
        return this._exportScope;
    } //-- de.fhg.isst.ComponentML.types.ExportScopeType getExportScope() 

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
     * @param businessExport
    **/
    public void setBusinessExport(BusinessExport businessExport)
    {
        this._businessExport = businessExport;
    } //-- void setBusinessExport(BusinessExport) 

    /**
     * 
     * @param exportScope
    **/
    public void setExportScope(de.fhg.isst.ComponentML.types.ExportScopeType exportScope)
    {
        this._exportScope = exportScope;
    } //-- void setExportScope(de.fhg.isst.ComponentML.types.ExportScopeType) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ServiceExport unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ServiceExport) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ServiceExport.class, reader);
    } //-- de.fhg.isst.ComponentML.ServiceExport unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
