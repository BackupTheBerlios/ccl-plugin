/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: EmbeddedContextPropertyValue.java,v 1.2 2002/02/11 23:55:45 ali Exp $
 */

package org.cocons.uml.ccl.context_property1_3.xmlembed.castor;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision: 1.2 $ $Date: 2002/02/11 23:55:45 $
**/
public class EmbeddedContextPropertyValue implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _tag;

    private java.lang.String _stereotype;

    private org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType _type;

    private java.util.Vector _ECPVEntryList;


      //----------------/
     //- Constructors -/
    //----------------/

    public EmbeddedContextPropertyValue() {
        super();
        _ECPVEntryList = new Vector();
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyValue()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vECPVEntry
    **/
    public void addECPVEntry(ECPVEntry vECPVEntry)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECPVEntryList.addElement(vECPVEntry);
    } //-- void addECPVEntry(ECPVEntry) 

    /**
     * 
     * @param index
     * @param vECPVEntry
    **/
    public void addECPVEntry(int index, ECPVEntry vECPVEntry)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECPVEntryList.insertElementAt(vECPVEntry, index);
    } //-- void addECPVEntry(int, ECPVEntry) 

    /**
    **/
    public java.util.Enumeration enumerateECPVEntry()
    {
        return _ECPVEntryList.elements();
    } //-- java.util.Enumeration enumerateECPVEntry() 

    /**
     * 
     * @param index
    **/
    public ECPVEntry getECPVEntry(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECPVEntryList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (ECPVEntry) _ECPVEntryList.elementAt(index);
    } //-- ECPVEntry getECPVEntry(int) 

    /**
    **/
    public ECPVEntry[] getECPVEntry()
    {
        int size = _ECPVEntryList.size();
        ECPVEntry[] mArray = new ECPVEntry[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ECPVEntry) _ECPVEntryList.elementAt(index);
        }
        return mArray;
    } //-- ECPVEntry[] getECPVEntry() 

    /**
    **/
    public int getECPVEntryCount()
    {
        return _ECPVEntryList.size();
    } //-- int getECPVEntryCount() 

    /**
    **/
    public java.lang.String getStereotype()
    {
        return this._stereotype;
    } //-- java.lang.String getStereotype() 

    /**
    **/
    public java.lang.String getTag()
    {
        return this._tag;
    } //-- java.lang.String getTag() 

    /**
    **/
    public org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType getType()
    {
        return this._type;
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType getType() 

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
    **/
    public void removeAllECPVEntry()
    {
        _ECPVEntryList.removeAllElements();
    } //-- void removeAllECPVEntry() 

    /**
     * 
     * @param index
    **/
    public ECPVEntry removeECPVEntry(int index)
    {
        Object obj = _ECPVEntryList.elementAt(index);
        _ECPVEntryList.removeElementAt(index);
        return (ECPVEntry) obj;
    } //-- ECPVEntry removeECPVEntry(int) 

    /**
     * 
     * @param index
     * @param vECPVEntry
    **/
    public void setECPVEntry(int index, ECPVEntry vECPVEntry)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECPVEntryList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _ECPVEntryList.setElementAt(vECPVEntry, index);
    } //-- void setECPVEntry(int, ECPVEntry) 

    /**
     * 
     * @param ECPVEntryArray
    **/
    public void setECPVEntry(ECPVEntry[] ECPVEntryArray)
    {
        //-- copy array
        _ECPVEntryList.removeAllElements();
        for (int i = 0; i < ECPVEntryArray.length; i++) {
            _ECPVEntryList.addElement(ECPVEntryArray[i]);
        }
    } //-- void setECPVEntry(ECPVEntry) 

    /**
     * 
     * @param stereotype
    **/
    public void setStereotype(java.lang.String stereotype)
    {
        this._stereotype = stereotype;
    } //-- void setStereotype(java.lang.String) 

    /**
     * 
     * @param tag
    **/
    public void setTag(java.lang.String tag)
    {
        this._tag = tag;
    } //-- void setTag(java.lang.String) 

    /**
     * 
     * @param type
    **/
    public void setType(org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType type)
    {
        this._type = type;
    } //-- void setType(org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyValue unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyValue) Unmarshaller.unmarshal(org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyValue.class, reader);
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyValue unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
