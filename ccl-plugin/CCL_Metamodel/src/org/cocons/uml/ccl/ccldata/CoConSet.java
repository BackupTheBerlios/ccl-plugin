/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSet.java,v 1.1 2002/02/06 12:11:20 ali Exp $
 */

package org.cocons.uml.ccl.ccldata;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.cocons.uml.ccl.ccldata.types.IdType;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision: 1.1 $ $Date: 2002/02/06 12:11:20 $
**/
public class CoConSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private org.cocons.uml.ccl.ccldata.types.IdType _id;

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSet() {
        super();
        _items = new Vector();
    } //-- org.cocons.uml.ccl.ccldata.CoConSet()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vCoConSetItem
    **/
    public void addCoConSetItem(org.cocons.uml.ccl.ccldata.CoConSetItem vCoConSetItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vCoConSetItem);
    } //-- void addCoConSetItem(org.cocons.uml.ccl.ccldata.CoConSetItem) 

    /**
     * 
     * @param index
     * @param vCoConSetItem
    **/
    public void addCoConSetItem(int index, org.cocons.uml.ccl.ccldata.CoConSetItem vCoConSetItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vCoConSetItem, index);
    } //-- void addCoConSetItem(int, org.cocons.uml.ccl.ccldata.CoConSetItem) 

    /**
    **/
    public java.util.Enumeration enumerateCoConSetItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateCoConSetItem() 

    /**
     * 
     * @param index
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetItem getCoConSetItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (org.cocons.uml.ccl.ccldata.CoConSetItem) _items.elementAt(index);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetItem getCoConSetItem(int) 

    /**
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetItem[] getCoConSetItem()
    {
        int size = _items.size();
        org.cocons.uml.ccl.ccldata.CoConSetItem[] mArray = new org.cocons.uml.ccl.ccldata.CoConSetItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoConSetItem) _items.elementAt(index);
        }
        return mArray;
    } //-- org.cocons.uml.ccl.ccldata.CoConSetItem[] getCoConSetItem() 

    /**
    **/
    public int getCoConSetItemCount()
    {
        return _items.size();
    } //-- int getCoConSetItemCount() 

    /**
    **/
    public org.cocons.uml.ccl.ccldata.types.IdType getId()
    {
        return this._id;
    } //-- org.cocons.uml.ccl.ccldata.types.IdType getId() 

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
    public void removeAllCoConSetItem()
    {
        _items.removeAllElements();
    } //-- void removeAllCoConSetItem() 

    /**
     * 
     * @param index
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetItem removeCoConSetItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (org.cocons.uml.ccl.ccldata.CoConSetItem) obj;
    } //-- org.cocons.uml.ccl.ccldata.CoConSetItem removeCoConSetItem(int) 

    /**
     * 
     * @param index
     * @param vCoConSetItem
    **/
    public void setCoConSetItem(int index, org.cocons.uml.ccl.ccldata.CoConSetItem vCoConSetItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vCoConSetItem, index);
    } //-- void setCoConSetItem(int, org.cocons.uml.ccl.ccldata.CoConSetItem) 

    /**
     * 
     * @param coConSetItemArray
    **/
    public void setCoConSetItem(org.cocons.uml.ccl.ccldata.CoConSetItem[] coConSetItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < coConSetItemArray.length; i++) {
            _items.addElement(coConSetItemArray[i]);
        }
    } //-- void setCoConSetItem(org.cocons.uml.ccl.ccldata.CoConSetItem) 

    /**
     * 
     * @param id
    **/
    public void setId(org.cocons.uml.ccl.ccldata.types.IdType id)
    {
        this._id = id;
    } //-- void setId(org.cocons.uml.ccl.ccldata.types.IdType) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSet unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSet) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSet.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSet unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
