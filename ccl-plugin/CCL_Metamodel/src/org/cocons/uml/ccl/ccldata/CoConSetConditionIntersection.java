/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionIntersection.java,v 1.2 2002/02/09 18:47:49 ali Exp $
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
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision: 1.2 $ $Date: 2002/02/09 18:47:49 $
**/
public class CoConSetConditionIntersection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionIntersection() {
        super();
        _items = new Vector();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionIntersection()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vCoConSetConditionIntersectionItem
    **/
    public void addCoConSetConditionIntersectionItem(org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem vCoConSetConditionIntersectionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vCoConSetConditionIntersectionItem);
    } //-- void addCoConSetConditionIntersectionItem(org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionIntersectionItem
    **/
    public void addCoConSetConditionIntersectionItem(int index, org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem vCoConSetConditionIntersectionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vCoConSetConditionIntersectionItem, index);
    } //-- void addCoConSetConditionIntersectionItem(int, org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem) 

    /**
    **/
    public java.util.Enumeration enumerateCoConSetConditionIntersectionItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateCoConSetConditionIntersectionItem() 

    /**
     * 
     * @param index
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem getCoConSetConditionIntersectionItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem) _items.elementAt(index);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem getCoConSetConditionIntersectionItem(int) 

    /**
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem[] getCoConSetConditionIntersectionItem()
    {
        int size = _items.size();
        org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem[] mArray = new org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoConSetConditionIntersectionItem) _items.elementAt(index);
        }
        return mArray;
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem[] getCoConSetConditionIntersectionItem() 

    /**
    **/
    public int getCoConSetConditionIntersectionItemCount()
    {
        return _items.size();
    } //-- int getCoConSetConditionIntersectionItemCount() 

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
    public void removeAllCoConSetConditionIntersectionItem()
    {
        _items.removeAllElements();
    } //-- void removeAllCoConSetConditionIntersectionItem() 

    /**
     * 
     * @param index
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem removeCoConSetConditionIntersectionItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem) obj;
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem removeCoConSetConditionIntersectionItem(int) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionIntersectionItem
    **/
    public void setCoConSetConditionIntersectionItem(int index, org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem vCoConSetConditionIntersectionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vCoConSetConditionIntersectionItem, index);
    } //-- void setCoConSetConditionIntersectionItem(int, org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem) 

    /**
     * 
     * @param coConSetConditionIntersectionItemArray
    **/
    public void setCoConSetConditionIntersectionItem(org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem[] coConSetConditionIntersectionItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < coConSetConditionIntersectionItemArray.length; i++) {
            _items.addElement(coConSetConditionIntersectionItemArray[i]);
        }
    } //-- void setCoConSetConditionIntersectionItem(org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionItem) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetConditionIntersection unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionIntersection) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetConditionIntersection.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionIntersection unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
