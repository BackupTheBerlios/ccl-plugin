/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ExportSectionChoiceSequence.java,v 1.1 2003/07/12 18:21:46 layekers Exp $
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
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:46 $
**/
public class ExportSectionChoiceSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The business-export element specifies a collection 
     * methods
     *     exported by the specified component.
     *     Used in: export-section.
     *    
    **/
    private BusinessExport _businessExport;

    /**
     * 
     *     The type-export element specifies a set of types
     * exported by the
     *     specified component.
     *    
    **/
    private TypeExport _typeExport;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExportSectionChoiceSequence() {
        super();
    } //-- de.fhg.isst.ComponentML.ExportSectionChoiceSequence()


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
    public TypeExport getTypeExport()
    {
        return this._typeExport;
    } //-- TypeExport getTypeExport() 

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
     * @param typeExport
    **/
    public void setTypeExport(TypeExport typeExport)
    {
        this._typeExport = typeExport;
    } //-- void setTypeExport(TypeExport) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ExportSectionChoiceSequence unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ExportSectionChoiceSequence) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ExportSectionChoiceSequence.class, reader);
    } //-- de.fhg.isst.ComponentML.ExportSectionChoiceSequence unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
