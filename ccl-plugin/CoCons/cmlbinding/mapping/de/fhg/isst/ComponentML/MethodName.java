/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: MethodName.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 *     The method-name element specifies the name of a method.
 *     Specifying the rename-as attribute the method-name could be
 * changed.
 *     Used in: method.
 *    
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class MethodName implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
    **/
    private java.lang.String _content = "";

    private java.lang.String _renameAs;


      //----------------/
     //- Constructors -/
    //----------------/

    public MethodName() {
        super();
    } //-- de.fhg.isst.ComponentML.MethodName()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public java.lang.String getContent()
    {
        return this._content;
    } //-- java.lang.String getContent() 

    /**
    **/
    public java.lang.String getRenameAs()
    {
        return this._renameAs;
    } //-- java.lang.String getRenameAs() 

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
     * @param content
    **/
    public void setContent(java.lang.String content)
    {
        this._content = content;
    } //-- void setContent(java.lang.String) 

    /**
     * 
     * @param renameAs
    **/
    public void setRenameAs(java.lang.String renameAs)
    {
        this._renameAs = renameAs;
    } //-- void setRenameAs(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.MethodName unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.MethodName) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.MethodName.class, reader);
    } //-- de.fhg.isst.ComponentML.MethodName unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
