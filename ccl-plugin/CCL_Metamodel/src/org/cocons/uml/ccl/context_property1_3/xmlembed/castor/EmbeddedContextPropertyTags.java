/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: EmbeddedContextPropertyTags.java,v 1.1 2002/02/10 20:38:55 ali Exp $
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
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision: 1.1 $ $Date: 2002/02/10 20:38:55 $
**/
public class EmbeddedContextPropertyTags implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _ECPTEntryList;


      //----------------/
     //- Constructors -/
    //----------------/

    public EmbeddedContextPropertyTags() {
        super();
        _ECPTEntryList = new Vector();
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyTags()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vECPTEntry
    **/
    public void addECPTEntry(ECPTEntry vECPTEntry)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECPTEntryList.addElement(vECPTEntry);
    } //-- void addECPTEntry(ECPTEntry) 

    /**
     * 
     * @param index
     * @param vECPTEntry
    **/
    public void addECPTEntry(int index, ECPTEntry vECPTEntry)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECPTEntryList.insertElementAt(vECPTEntry, index);
    } //-- void addECPTEntry(int, ECPTEntry) 

    /**
    **/
    public java.util.Enumeration enumerateECPTEntry()
    {
        return _ECPTEntryList.elements();
    } //-- java.util.Enumeration enumerateECPTEntry() 

    /**
     * 
     * @param index
    **/
    public ECPTEntry getECPTEntry(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECPTEntryList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (ECPTEntry) _ECPTEntryList.elementAt(index);
    } //-- ECPTEntry getECPTEntry(int) 

    /**
    **/
    public ECPTEntry[] getECPTEntry()
    {
        int size = _ECPTEntryList.size();
        ECPTEntry[] mArray = new ECPTEntry[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ECPTEntry) _ECPTEntryList.elementAt(index);
        }
        return mArray;
    } //-- ECPTEntry[] getECPTEntry() 

    /**
    **/
    public int getECPTEntryCount()
    {
        return _ECPTEntryList.size();
    } //-- int getECPTEntryCount() 

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
    public void removeAllECPTEntry()
    {
        _ECPTEntryList.removeAllElements();
    } //-- void removeAllECPTEntry() 

    /**
     * 
     * @param index
    **/
    public ECPTEntry removeECPTEntry(int index)
    {
        Object obj = _ECPTEntryList.elementAt(index);
        _ECPTEntryList.removeElementAt(index);
        return (ECPTEntry) obj;
    } //-- ECPTEntry removeECPTEntry(int) 

    /**
     * 
     * @param index
     * @param vECPTEntry
    **/
    public void setECPTEntry(int index, ECPTEntry vECPTEntry)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECPTEntryList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _ECPTEntryList.setElementAt(vECPTEntry, index);
    } //-- void setECPTEntry(int, ECPTEntry) 

    /**
     * 
     * @param ECPTEntryArray
    **/
    public void setECPTEntry(ECPTEntry[] ECPTEntryArray)
    {
        //-- copy array
        _ECPTEntryList.removeAllElements();
        for (int i = 0; i < ECPTEntryArray.length; i++) {
            _ECPTEntryList.addElement(ECPTEntryArray[i]);
        }
    } //-- void setECPTEntry(ECPTEntry) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyTags unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyTags) Unmarshaller.unmarshal(org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyTags.class, reader);
    } //-- org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyTags unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
