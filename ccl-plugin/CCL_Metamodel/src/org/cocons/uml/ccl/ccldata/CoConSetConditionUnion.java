/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionUnion.java,v 1.2 2002/02/09 18:47:49 ali Exp $
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
public class CoConSetConditionUnion implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionUnion() {
        super();
        _items = new Vector();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionUnion()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vCoConSetConditionUnionItem
    **/
    public void addCoConSetConditionUnionItem(org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem vCoConSetConditionUnionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vCoConSetConditionUnionItem);
    } //-- void addCoConSetConditionUnionItem(org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionUnionItem
    **/
    public void addCoConSetConditionUnionItem(int index, org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem vCoConSetConditionUnionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vCoConSetConditionUnionItem, index);
    } //-- void addCoConSetConditionUnionItem(int, org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem) 

    /**
    **/
    public java.util.Enumeration enumerateCoConSetConditionUnionItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateCoConSetConditionUnionItem() 

    /**
     * 
     * @param index
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem getCoConSetConditionUnionItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem) _items.elementAt(index);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem getCoConSetConditionUnionItem(int) 

    /**
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem[] getCoConSetConditionUnionItem()
    {
        int size = _items.size();
        org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem[] mArray = new org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoConSetConditionUnionItem) _items.elementAt(index);
        }
        return mArray;
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem[] getCoConSetConditionUnionItem() 

    /**
    **/
    public int getCoConSetConditionUnionItemCount()
    {
        return _items.size();
    } //-- int getCoConSetConditionUnionItemCount() 

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
    public void removeAllCoConSetConditionUnionItem()
    {
        _items.removeAllElements();
    } //-- void removeAllCoConSetConditionUnionItem() 

    /**
     * 
     * @param index
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem removeCoConSetConditionUnionItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem) obj;
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem removeCoConSetConditionUnionItem(int) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionUnionItem
    **/
    public void setCoConSetConditionUnionItem(int index, org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem vCoConSetConditionUnionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vCoConSetConditionUnionItem, index);
    } //-- void setCoConSetConditionUnionItem(int, org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem) 

    /**
     * 
     * @param coConSetConditionUnionItemArray
    **/
    public void setCoConSetConditionUnionItem(org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem[] coConSetConditionUnionItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < coConSetConditionUnionItemArray.length; i++) {
            _items.addElement(coConSetConditionUnionItemArray[i]);
        }
    } //-- void setCoConSetConditionUnionItem(org.cocons.uml.ccl.ccldata.CoConSetConditionUnionItem) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetConditionUnion unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionUnion) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetConditionUnion.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionUnion unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
