/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoCon.java,v 1.1 2002/02/06 12:11:20 ali Exp $
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
public class CoCon implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _type;

    private java.util.Vector _coConSetList;

    private java.util.Vector _coConAttributeList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoCon() {
        super();
        _coConSetList = new Vector();
        _coConAttributeList = new Vector();
    } //-- org.cocons.uml.ccl.ccldata.CoCon()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vCoConAttribute
    **/
    public void addCoConAttribute(CoConAttribute vCoConAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        _coConAttributeList.addElement(vCoConAttribute);
    } //-- void addCoConAttribute(CoConAttribute) 

    /**
     * 
     * @param index
     * @param vCoConAttribute
    **/
    public void addCoConAttribute(int index, CoConAttribute vCoConAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        _coConAttributeList.insertElementAt(vCoConAttribute, index);
    } //-- void addCoConAttribute(int, CoConAttribute) 

    /**
     * 
     * @param vCoConSet
    **/
    public void addCoConSet(CoConSet vCoConSet)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_coConSetList.size() < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _coConSetList.addElement(vCoConSet);
    } //-- void addCoConSet(CoConSet) 

    /**
     * 
     * @param index
     * @param vCoConSet
    **/
    public void addCoConSet(int index, CoConSet vCoConSet)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_coConSetList.size() < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _coConSetList.insertElementAt(vCoConSet, index);
    } //-- void addCoConSet(int, CoConSet) 

    /**
    **/
    public java.util.Enumeration enumerateCoConAttribute()
    {
        return _coConAttributeList.elements();
    } //-- java.util.Enumeration enumerateCoConAttribute() 

    /**
    **/
    public java.util.Enumeration enumerateCoConSet()
    {
        return _coConSetList.elements();
    } //-- java.util.Enumeration enumerateCoConSet() 

    /**
     * 
     * @param index
    **/
    public CoConAttribute getCoConAttribute(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConAttributeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (CoConAttribute) _coConAttributeList.elementAt(index);
    } //-- CoConAttribute getCoConAttribute(int) 

    /**
    **/
    public CoConAttribute[] getCoConAttribute()
    {
        int size = _coConAttributeList.size();
        CoConAttribute[] mArray = new CoConAttribute[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoConAttribute) _coConAttributeList.elementAt(index);
        }
        return mArray;
    } //-- CoConAttribute[] getCoConAttribute() 

    /**
    **/
    public int getCoConAttributeCount()
    {
        return _coConAttributeList.size();
    } //-- int getCoConAttributeCount() 

    /**
     * 
     * @param index
    **/
    public CoConSet getCoConSet(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConSetList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (CoConSet) _coConSetList.elementAt(index);
    } //-- CoConSet getCoConSet(int) 

    /**
    **/
    public CoConSet[] getCoConSet()
    {
        int size = _coConSetList.size();
        CoConSet[] mArray = new CoConSet[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoConSet) _coConSetList.elementAt(index);
        }
        return mArray;
    } //-- CoConSet[] getCoConSet() 

    /**
    **/
    public int getCoConSetCount()
    {
        return _coConSetList.size();
    } //-- int getCoConSetCount() 

    /**
    **/
    public java.lang.String getType()
    {
        return this._type;
    } //-- java.lang.String getType() 

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
    public void removeAllCoConAttribute()
    {
        _coConAttributeList.removeAllElements();
    } //-- void removeAllCoConAttribute() 

    /**
    **/
    public void removeAllCoConSet()
    {
        _coConSetList.removeAllElements();
    } //-- void removeAllCoConSet() 

    /**
     * 
     * @param index
    **/
    public CoConAttribute removeCoConAttribute(int index)
    {
        Object obj = _coConAttributeList.elementAt(index);
        _coConAttributeList.removeElementAt(index);
        return (CoConAttribute) obj;
    } //-- CoConAttribute removeCoConAttribute(int) 

    /**
     * 
     * @param index
    **/
    public CoConSet removeCoConSet(int index)
    {
        Object obj = _coConSetList.elementAt(index);
        _coConSetList.removeElementAt(index);
        return (CoConSet) obj;
    } //-- CoConSet removeCoConSet(int) 

    /**
     * 
     * @param index
     * @param vCoConAttribute
    **/
    public void setCoConAttribute(int index, CoConAttribute vCoConAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConAttributeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _coConAttributeList.setElementAt(vCoConAttribute, index);
    } //-- void setCoConAttribute(int, CoConAttribute) 

    /**
     * 
     * @param coConAttributeArray
    **/
    public void setCoConAttribute(CoConAttribute[] coConAttributeArray)
    {
        //-- copy array
        _coConAttributeList.removeAllElements();
        for (int i = 0; i < coConAttributeArray.length; i++) {
            _coConAttributeList.addElement(coConAttributeArray[i]);
        }
    } //-- void setCoConAttribute(CoConAttribute) 

    /**
     * 
     * @param index
     * @param vCoConSet
    **/
    public void setCoConSet(int index, CoConSet vCoConSet)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConSetList.size())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(index < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _coConSetList.setElementAt(vCoConSet, index);
    } //-- void setCoConSet(int, CoConSet) 

    /**
     * 
     * @param coConSetArray
    **/
    public void setCoConSet(CoConSet[] coConSetArray)
    {
        //-- copy array
        _coConSetList.removeAllElements();
        for (int i = 0; i < coConSetArray.length; i++) {
            _coConSetList.addElement(coConSetArray[i]);
        }
    } //-- void setCoConSet(CoConSet) 

    /**
     * 
     * @param type
    **/
    public void setType(java.lang.String type)
    {
        this._type = type;
    } //-- void setType(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoCon unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoCon) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoCon.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoCon unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
