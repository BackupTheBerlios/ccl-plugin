/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConList.java,v 1.3 2002/02/09 18:47:49 ali Exp $
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
 * @version $Revision: 1.3 $ $Date: 2002/02/09 18:47:49 $
**/
public class CoConList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _coConList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConList() {
        super();
        _coConList = new Vector();
    } //-- org.cocons.uml.ccl.ccldata.CoConList()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vCoCon
    **/
    public void addCoCon(CoCon vCoCon)
        throws java.lang.IndexOutOfBoundsException
    {
        _coConList.addElement(vCoCon);
    } //-- void addCoCon(CoCon) 

    /**
     * 
     * @param index
     * @param vCoCon
    **/
    public void addCoCon(int index, CoCon vCoCon)
        throws java.lang.IndexOutOfBoundsException
    {
        _coConList.insertElementAt(vCoCon, index);
    } //-- void addCoCon(int, CoCon) 

    /**
    **/
    public java.util.Enumeration enumerateCoCon()
    {
        return _coConList.elements();
    } //-- java.util.Enumeration enumerateCoCon() 

    /**
     * 
     * @param index
    **/
    public CoCon getCoCon(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (CoCon) _coConList.elementAt(index);
    } //-- CoCon getCoCon(int) 

    /**
    **/
    public CoCon[] getCoCon()
    {
        int size = _coConList.size();
        CoCon[] mArray = new CoCon[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (CoCon) _coConList.elementAt(index);
        }
        return mArray;
    } //-- CoCon[] getCoCon() 

    /**
    **/
    public int getCoConCount()
    {
        return _coConList.size();
    } //-- int getCoConCount() 

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
    public void removeAllCoCon()
    {
        _coConList.removeAllElements();
    } //-- void removeAllCoCon() 

    /**
     * 
     * @param index
    **/
    public CoCon removeCoCon(int index)
    {
        Object obj = _coConList.elementAt(index);
        _coConList.removeElementAt(index);
        return (CoCon) obj;
    } //-- CoCon removeCoCon(int) 

    /**
     * 
     * @param index
     * @param vCoCon
    **/
    public void setCoCon(int index, CoCon vCoCon)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _coConList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _coConList.setElementAt(vCoCon, index);
    } //-- void setCoCon(int, CoCon) 

    /**
     * 
     * @param coConArray
    **/
    public void setCoCon(CoCon[] coConArray)
    {
        //-- copy array
        _coConList.removeAllElements();
        for (int i = 0; i < coConArray.length; i++) {
            _coConList.addElement(coConArray[i]);
        }
    } //-- void setCoCon(CoCon) 

    /**
     * 
     * @param reader
    **/
    public static org.cocons.uml.ccl.ccldata.CoConList unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.cocons.uml.ccl.ccldata.CoConList) Unmarshaller.unmarshal(org.cocons.uml.ccl.ccldata.CoConList.class, reader);
    } //-- org.cocons.uml.ccl.ccldata.CoConList unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
