/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TypeImport.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
 * @version $Revision: 1.2 $ $Date: 2002/10/10 14:05:59 $
**/
public class TypeImport implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public TypeImport() {
        super();
        _items = new Vector();
    } //-- de.fhg.isst.ComponentML.TypeImport()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vTypeImportItem
    **/
    public void addTypeImportItem(de.fhg.isst.ComponentML.TypeImportItem vTypeImportItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vTypeImportItem);
    } //-- void addTypeImportItem(de.fhg.isst.ComponentML.TypeImportItem) 

    /**
     * 
     * @param index
     * @param vTypeImportItem
    **/
    public void addTypeImportItem(int index, de.fhg.isst.ComponentML.TypeImportItem vTypeImportItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vTypeImportItem, index);
    } //-- void addTypeImportItem(int, de.fhg.isst.ComponentML.TypeImportItem) 

    /**
    **/
    public java.util.Enumeration enumerateTypeImportItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateTypeImportItem() 

    /**
     * 
     * @param index
    **/
    public de.fhg.isst.ComponentML.TypeImportItem getTypeImportItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (de.fhg.isst.ComponentML.TypeImportItem) _items.elementAt(index);
    } //-- de.fhg.isst.ComponentML.TypeImportItem getTypeImportItem(int) 

    /**
    **/
    public de.fhg.isst.ComponentML.TypeImportItem[] getTypeImportItem()
    {
        int size = _items.size();
        de.fhg.isst.ComponentML.TypeImportItem[] mArray = new de.fhg.isst.ComponentML.TypeImportItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (TypeImportItem) _items.elementAt(index);
        }
        return mArray;
    } //-- de.fhg.isst.ComponentML.TypeImportItem[] getTypeImportItem() 

    /**
    **/
    public int getTypeImportItemCount()
    {
        return _items.size();
    } //-- int getTypeImportItemCount() 

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
    public void removeAllTypeImportItem()
    {
        _items.removeAllElements();
    } //-- void removeAllTypeImportItem() 

    /**
     * 
     * @param index
    **/
    public de.fhg.isst.ComponentML.TypeImportItem removeTypeImportItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (de.fhg.isst.ComponentML.TypeImportItem) obj;
    } //-- de.fhg.isst.ComponentML.TypeImportItem removeTypeImportItem(int) 

    /**
     * 
     * @param index
     * @param vTypeImportItem
    **/
    public void setTypeImportItem(int index, de.fhg.isst.ComponentML.TypeImportItem vTypeImportItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vTypeImportItem, index);
    } //-- void setTypeImportItem(int, de.fhg.isst.ComponentML.TypeImportItem) 

    /**
     * 
     * @param typeImportItemArray
    **/
    public void setTypeImportItem(de.fhg.isst.ComponentML.TypeImportItem[] typeImportItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < typeImportItemArray.length; i++) {
            _items.addElement(typeImportItemArray[i]);
        }
    } //-- void setTypeImportItem(de.fhg.isst.ComponentML.TypeImportItem) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.TypeImport unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.TypeImport) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.TypeImport.class, reader);
    } //-- de.fhg.isst.ComponentML.TypeImport unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
