/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ConnectorSpecChoiceSequence.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class ConnectorSpecChoiceSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The import element specifies an import from a facade
     * given by a 
     *     facade-name.
     *     Used in: connector-spec.
     *    
    **/
    private Import _import;

    /**
     * 
     *     The expose element describes imports from and exposes to
     * given facades.
     *     Used in: connector-spec.
     *    
    **/
    private Expose _expose;


      //----------------/
     //- Constructors -/
    //----------------/

    public ConnectorSpecChoiceSequence() {
        super();
    } //-- de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public Expose getExpose()
    {
        return this._expose;
    } //-- Expose getExpose() 

    /**
    **/
    public Import getImport()
    {
        return this._import;
    } //-- Import getImport() 

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
     * @param expose
    **/
    public void setExpose(Expose expose)
    {
        this._expose = expose;
    } //-- void setExpose(Expose) 

    /**
     * 
     * @param _import
    **/
    public void setImport(Import _import)
    {
        this._import = _import;
    } //-- void setImport(Import) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence.class, reader);
    } //-- de.fhg.isst.ComponentML.ConnectorSpecChoiceSequence unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
