/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionQuerySet.java,v 1.1 2002/02/06 12:11:20 ali Exp $
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
import org.cocons.uml.ccl.ccldata.types.OperatorType;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision: 1.1 $ $Date: 2002/02/06 12:11:20 $
**/
public class CoConSetConditionQuerySet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _property;

    private org.cocons.uml.ccl.ccldata.types.OperatorType _operator;

    private java.util.Vector _coConSetConditionQueryForSetValueList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionQuerySet() {
        super();
        _coConSetConditionQueryForSetValueList = new Vector();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySet()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vCoConSetConditionQueryForSetValue
    **/
    public void addCoConSetConditionQueryForSetValue(CoConSetConditionQueryForSetValue vCoConSetConditionQueryForSetValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _coConSetConditionQueryForSetValueList.addElement(vCoConSetConditionQueryForSetValue);
    } //-- void addCoConSetConditionQueryForSetValue(CoConSetConditionQueryForSetValue) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionQueryForSetValue
    **/
    public void addCoConSetConditionQueryForSetValue(int index, CoConSetConditionQueryForSetValue vCoConSetConditionQueryForSetValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _coConSetConditionQueryForSetValueList.insertElementAt(vCoConSetConditionQueryForSetValue, index);
    } //-- void addCoConSetConditionQueryForSetValue(int, CoConSetConditionQueryForSetValue) 

    /**
    **/
    public java.util.Enumeration enumerateCoConSetConditionQueryForSetValue()
    {
        return _coConSetConditionQueryForSetValueList.elements();
    } //-- java.util.Enumeration enumerateCoConSetConditionQueryForSetValue() 

    /**
     * 
     * @param index
    **/
    public CoConSetConditionQueryForSetValue getCoConSetConditionQueryForSetValue(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConSetConditionQueryForSetValueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (CoConSetConditionQueryForSetValue) _coConSetConditionQueryForSetValueList.elementAt(index);
    } //-- CoConSetConditionQueryForSetValue getCoConSetConditionQueryForSetValue(int) 

    /**
    **/
    public CoConSetConditionQueryForSetValue[] getCoConSetConditionQueryForSetValue()
    {
        int size = _coConSetConditionQueryForSetValueList.size();
        CoConSetConditionQueryForSetValue[] mArray = new CoConSetConditionQueryForSetValue[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoConSetConditionQueryForSetValue) _coConSetConditionQueryForSetValueList.elementAt(index);
        }
        return mArray;
    } //-- CoConSetConditionQueryForSetValue[] getCoConSetConditionQueryForSetValue() 

    /**
    **/
    public int getCoConSetConditionQueryForSetValueCount()
    {
        return _coConSetConditionQueryForSetValueList.size();
    } //-- int getCoConSetConditionQueryForSetValueCount() 

    /**
    **/
    public org.cocons.uml.ccl.ccldata.types.OperatorType getOperator()
    {
        return this._operator;
    } //-- org.cocons.uml.ccl.ccldata.types.OperatorType getOperator() 

    /**
    **/
    public java.lang.String getProperty()
    {
        return this._property;
    } //-- java.lang.String getProperty() 

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
    public void removeAllCoConSetConditionQueryForSetValue()
    {
        _coConSetConditionQueryForSetValueList.removeAllElements();
    } //-- void removeAllCoConSetConditionQueryForSetValue() 

    /**
     * 
     * @param index
    **/
    public CoConSetConditionQueryForSetValue removeCoConSetConditionQueryForSetValue(int index)
    {
        Object obj = _coConSetConditionQueryForSetValueList.elementAt(index);
        _coConSetConditionQueryForSetValueList.removeElementAt(index);
        return (CoConSetConditionQueryForSetValue) obj;
    } //-- CoConSetConditionQueryForSetValue removeCoConSetConditionQueryForSetValue(int) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionQueryForSetValue
    **/
    public void setCoConSetConditionQueryForSetValue(int index, CoConSetConditionQueryForSetValue vCoConSetConditionQueryForSetValue)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConSetConditionQueryForSetValueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _coConSetConditionQueryForSetValueList.setElementAt(vCoConSetConditionQueryForSetValue, index);
    } //-- void setCoConSetConditionQueryForSetValue(int, CoConSetConditionQueryForSetValue) 

    /**
     * 
     * @param coConSetConditionQueryForSetValueArray
    **/
    public void setCoConSetConditionQueryForSetValue(CoConSetConditionQueryForSetValue[] coConSetConditionQueryForSetValueArray)
    {
        //-- copy array
        _coConSetConditionQueryForSetValueList.removeAllElements();
        for (int i = 0; i < coConSetConditionQueryForSetValueArray.length; i++) {
            _coConSetConditionQueryForSetValueList.addElement(coConSetConditionQueryForSetValueArray[i]);
        }
    } //-- void setCoConSetConditionQueryForSetValue(CoConSetConditionQueryForSetValue) 

    /**
     * 
     * @param operator
    **/
    public void setOperator(org.cocons.uml.ccl.ccldata.types.OperatorType operator)
    {
        this._operator = operator;
    } //-- void setOperator(org.cocons.uml.ccl.ccldata.types.OperatorType) 

    /**
     * 
     * @param property
    **/
    public void setProperty(java.lang.String property)
    {
        this._property = property;
    } //-- void setProperty(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySet unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySet) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySet.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionQuerySet unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
