/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetCondition.java,v 1.2 2002/02/08 16:08:27 ali Exp $
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
 * @version $Revision: 1.2 $ $Date: 2002/02/08 16:08:27 $
**/
public class CoConSetCondition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _range = "all";

    private java.util.Vector _coConSetConditionRestrictionList;

    private CoConSetConditionChoice _coConSetConditionChoice;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetCondition() {
        super();
        _coConSetConditionRestrictionList = new Vector();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetCondition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vCoConSetConditionRestriction
    **/
    public void addCoConSetConditionRestriction(CoConSetConditionRestriction vCoConSetConditionRestriction)
        throws java.lang.IndexOutOfBoundsException
    {
        _coConSetConditionRestrictionList.addElement(vCoConSetConditionRestriction);
    } //-- void addCoConSetConditionRestriction(CoConSetConditionRestriction) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionRestriction
    **/
    public void addCoConSetConditionRestriction(int index, CoConSetConditionRestriction vCoConSetConditionRestriction)
        throws java.lang.IndexOutOfBoundsException
    {
        _coConSetConditionRestrictionList.insertElementAt(vCoConSetConditionRestriction, index);
    } //-- void addCoConSetConditionRestriction(int, CoConSetConditionRestriction) 

    /**
    **/
    public java.util.Enumeration enumerateCoConSetConditionRestriction()
    {
        return _coConSetConditionRestrictionList.elements();
    } //-- java.util.Enumeration enumerateCoConSetConditionRestriction() 

    /**
    **/
    public CoConSetConditionChoice getCoConSetConditionChoice()
    {
        return this._coConSetConditionChoice;
    } //-- CoConSetConditionChoice getCoConSetConditionChoice() 

    /**
     * 
     * @param index
    **/
    public CoConSetConditionRestriction getCoConSetConditionRestriction(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConSetConditionRestrictionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (CoConSetConditionRestriction) _coConSetConditionRestrictionList.elementAt(index);
    } //-- CoConSetConditionRestriction getCoConSetConditionRestriction(int) 

    /**
    **/
    public CoConSetConditionRestriction[] getCoConSetConditionRestriction()
    {
        int size = _coConSetConditionRestrictionList.size();
        CoConSetConditionRestriction[] mArray = new CoConSetConditionRestriction[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoConSetConditionRestriction) _coConSetConditionRestrictionList.elementAt(index);
        }
        return mArray;
    } //-- CoConSetConditionRestriction[] getCoConSetConditionRestriction() 

    /**
    **/
    public int getCoConSetConditionRestrictionCount()
    {
        return _coConSetConditionRestrictionList.size();
    } //-- int getCoConSetConditionRestrictionCount() 

    /**
    **/
    public java.lang.String getRange()
    {
        return this._range;
    } //-- java.lang.String getRange() 

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
    public void removeAllCoConSetConditionRestriction()
    {
        _coConSetConditionRestrictionList.removeAllElements();
    } //-- void removeAllCoConSetConditionRestriction() 

    /**
     * 
     * @param index
    **/
    public CoConSetConditionRestriction removeCoConSetConditionRestriction(int index)
    {
        Object obj = _coConSetConditionRestrictionList.elementAt(index);
        _coConSetConditionRestrictionList.removeElementAt(index);
        return (CoConSetConditionRestriction) obj;
    } //-- CoConSetConditionRestriction removeCoConSetConditionRestriction(int) 

    /**
     * 
     * @param coConSetConditionChoice
    **/
    public void setCoConSetConditionChoice(CoConSetConditionChoice coConSetConditionChoice)
    {
        this._coConSetConditionChoice = coConSetConditionChoice;
    } //-- void setCoConSetConditionChoice(CoConSetConditionChoice) 

    /**
     * 
     * @param index
     * @param vCoConSetConditionRestriction
    **/
    public void setCoConSetConditionRestriction(int index, CoConSetConditionRestriction vCoConSetConditionRestriction)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConSetConditionRestrictionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _coConSetConditionRestrictionList.setElementAt(vCoConSetConditionRestriction, index);
    } //-- void setCoConSetConditionRestriction(int, CoConSetConditionRestriction) 

    /**
     * 
     * @param coConSetConditionRestrictionArray
    **/
    public void setCoConSetConditionRestriction(CoConSetConditionRestriction[] coConSetConditionRestrictionArray)
    {
        //-- copy array
        _coConSetConditionRestrictionList.removeAllElements();
        for (int i = 0; i < coConSetConditionRestrictionArray.length; i++) {
            _coConSetConditionRestrictionList.addElement(coConSetConditionRestrictionArray[i]);
        }
    } //-- void setCoConSetConditionRestriction(CoConSetConditionRestriction) 

    /**
     * 
     * @param range
    **/
    public void setRange(java.lang.String range)
    {
        this._range = range;
    } //-- void setRange(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConSetCondition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConSetCondition) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConSetCondition.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConSetCondition unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
