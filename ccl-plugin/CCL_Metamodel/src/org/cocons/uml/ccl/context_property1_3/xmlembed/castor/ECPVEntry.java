/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ECPVEntry.java,v 1.1 2002/02/10 16:07:15 ali Exp $
 */

package org.cocons.uml.ccl.context_property1_3.xmlembed.castor;

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
 * @version $Revision: 1.1 $ $Date: 2002/02/10 16:07:15 $
**/
public class ECPVEntry implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _value;

    private boolean _selected;

    /**
     * keeps track of state for field: _selected
    **/
    private boolean _has_selected;

    private java.lang.String _dependency;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECPVEntry() {
        super();
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.ECPVEntry()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public java.lang.String getDependency()
    {
        return this._dependency;
    } //-- java.lang.String getDependency() 

    /**
    **/
    public boolean getSelected()
    {
        return this._selected;
    } //-- boolean getSelected() 

    /**
    **/
    public java.lang.String getValue()
    {
        return this._value;
    } //-- java.lang.String getValue() 

    /**
    **/
    public boolean hasSelected()
    {
        return this._has_selected;
    } //-- boolean hasSelected() 

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
     * @param dependency
    **/
    public void setDependency(java.lang.String dependency)
    {
        this._dependency = dependency;
    } //-- void setDependency(java.lang.String) 

    /**
     * 
     * @param selected
    **/
    public void setSelected(boolean selected)
    {
        this._selected = selected;
        this._has_selected = true;
    } //-- void setSelected(boolean) 

    /**
     * 
     * @param value
    **/
    public void setValue(java.lang.String value)
    {
        this._value = value;
    } //-- void setValue(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.context_property1_3.xmlembed.castor.ECPVEntry unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.context_property1_3.xmlembed.castor.ECPVEntry) Unmarshaller.unmarshal(org.cocons.uml.ccl.context_property1_3.xmlembed.castor.ECPVEntry.class, reader);
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.ECPVEntry unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
