/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: UsedComponents.java,v 1.1 2002/03/19 18:56:06 ali Exp $
 */

package de.fhg.isst.ComponentML;

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
 * @version $Revision: 1.1 $ $Date: 2002/03/19 18:56:06 $
**/
public class UsedComponents implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public UsedComponents() {
        super();
        _items = new Vector();
    } //-- de.fhg.isst.ComponentML.UsedComponents()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vUsedComponentsItem
    **/
    public void addUsedComponentsItem(de.fhg.isst.ComponentML.UsedComponentsItem vUsedComponentsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vUsedComponentsItem);
    } //-- void addUsedComponentsItem(de.fhg.isst.ComponentML.UsedComponentsItem) 

    /**
     * 
     * @param index
     * @param vUsedComponentsItem
    **/
    public void addUsedComponentsItem(int index, de.fhg.isst.ComponentML.UsedComponentsItem vUsedComponentsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vUsedComponentsItem, index);
    } //-- void addUsedComponentsItem(int, de.fhg.isst.ComponentML.UsedComponentsItem) 

    /**
    **/
    public java.util.Enumeration enumerateUsedComponentsItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateUsedComponentsItem() 

    /**
     * 
     * @param index
    **/
    public de.fhg.isst.ComponentML.UsedComponentsItem getUsedComponentsItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.fhg.isst.ComponentML.UsedComponentsItem) _items.elementAt(index);
    } //-- de.fhg.isst.ComponentML.UsedComponentsItem getUsedComponentsItem(int) 

    /**
    **/
    public de.fhg.isst.ComponentML.UsedComponentsItem[] getUsedComponentsItem()
    {
        int size = _items.size();
        de.fhg.isst.ComponentML.UsedComponentsItem[] mArray = new de.fhg.isst.ComponentML.UsedComponentsItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (UsedComponentsItem) _items.elementAt(index);
        }
        return mArray;
    } //-- de.fhg.isst.ComponentML.UsedComponentsItem[] getUsedComponentsItem() 

    /**
    **/
    public int getUsedComponentsItemCount()
    {
        return _items.size();
    } //-- int getUsedComponentsItemCount() 

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
    public void removeAllUsedComponentsItem()
    {
        _items.removeAllElements();
    } //-- void removeAllUsedComponentsItem() 

    /**
     * 
     * @param index
    **/
    public de.fhg.isst.ComponentML.UsedComponentsItem removeUsedComponentsItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (de.fhg.isst.ComponentML.UsedComponentsItem) obj;
    } //-- de.fhg.isst.ComponentML.UsedComponentsItem removeUsedComponentsItem(int) 

    /**
     * 
     * @param index
     * @param vUsedComponentsItem
    **/
    public void setUsedComponentsItem(int index, de.fhg.isst.ComponentML.UsedComponentsItem vUsedComponentsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vUsedComponentsItem, index);
    } //-- void setUsedComponentsItem(int, de.fhg.isst.ComponentML.UsedComponentsItem) 

    /**
     * 
     * @param usedComponentsItemArray
    **/
    public void setUsedComponentsItem(de.fhg.isst.ComponentML.UsedComponentsItem[] usedComponentsItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < usedComponentsItemArray.length; i++) {
            _items.addElement(usedComponentsItemArray[i]);
        }
    } //-- void setUsedComponentsItem(de.fhg.isst.ComponentML.UsedComponentsItem) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.UsedComponents unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.UsedComponents) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.UsedComponents.class, reader);
    } //-- de.fhg.isst.ComponentML.UsedComponents unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
