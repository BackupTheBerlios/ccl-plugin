/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionChoice.java,v 1.1 2002/02/06 12:11:20 ali Exp $
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
 * @version $Revision: 1.1 $ $Date: 2002/02/06 12:11:20 $
**/
public class CoConSetConditionChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionChoice() {
        super();
        _items = new Vector();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vCoConSetConditionChoiceItem
    **/
    public void addCoConSetConditionChoiceItem(org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem vCoConSetConditionChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vCoConSetConditionChoiceItem);
    } //-- void addCoConSetConditionChoiceItem(org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionChoiceItem
    **/
    public void addCoConSetConditionChoiceItem(int index, org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem vCoConSetConditionChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vCoConSetConditionChoiceItem, index);
    } //-- void addCoConSetConditionChoiceItem(int, org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem) 

    /**
    **/
    public java.util.Enumeration enumerateCoConSetConditionChoiceItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateCoConSetConditionChoiceItem() 

    /**
     * 
     * @param index
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem getCoConSetConditionChoiceItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem) _items.elementAt(index);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem getCoConSetConditionChoiceItem(int) 

    /**
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem[] getCoConSetConditionChoiceItem()
    {
        int size = _items.size();
        org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem[] mArray = new org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoConSetConditionChoiceItem) _items.elementAt(index);
        }
        return mArray;
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem[] getCoConSetConditionChoiceItem() 

    /**
    **/
    public int getCoConSetConditionChoiceItemCount()
    {
        return _items.size();
    } //-- int getCoConSetConditionChoiceItemCount() 

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
    public void removeAllCoConSetConditionChoiceItem()
    {
        _items.removeAllElements();
    } //-- void removeAllCoConSetConditionChoiceItem() 

    /**
     * 
     * @param index
    **/
    public org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem removeCoConSetConditionChoiceItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem) obj;
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem removeCoConSetConditionChoiceItem(int) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionChoiceItem
    **/
    public void setCoConSetConditionChoiceItem(int index, org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem vCoConSetConditionChoiceItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vCoConSetConditionChoiceItem, index);
    } //-- void setCoConSetConditionChoiceItem(int, org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem) 

    /**
     * 
     * @param coConSetConditionChoiceItemArray
    **/
    public void setCoConSetConditionChoiceItem(org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem[] coConSetConditionChoiceItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < coConSetConditionChoiceItemArray.length; i++) {
            _items.addElement(coConSetConditionChoiceItemArray[i]);
        }
    } //-- void setCoConSetConditionChoiceItem(org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetConditionChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionChoice) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetConditionChoice.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionChoice unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
