/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: TxnRequirements.java,v 1.1 2003/07/12 18:21:47 layekers Exp $
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
 *     The txn-requrements element specifies a collection of 
 *     txn-requirements.
 *     Used in: runtime-environment.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:47 $
**/
public class TxnRequirements implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The txn-requirement element specifies a single
     * txn-requirement.
     *     Used in: txn-requirements.
     *    
    **/
    private java.util.Vector _txnRequirementList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TxnRequirements() {
        super();
        _txnRequirementList = new Vector();
    } //-- de.fhg.isst.ComponentML.TxnRequirements()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vTxnRequirement
    **/
    public void addTxnRequirement(TxnRequirement vTxnRequirement)
        throws java.lang.IndexOutOfBoundsException
    {
        _txnRequirementList.addElement(vTxnRequirement);
    } //-- void addTxnRequirement(TxnRequirement) 

    /**
     * 
     * @param index
     * @param vTxnRequirement
    **/
    public void addTxnRequirement(int index, TxnRequirement vTxnRequirement)
        throws java.lang.IndexOutOfBoundsException
    {
        _txnRequirementList.insertElementAt(vTxnRequirement, index);
    } //-- void addTxnRequirement(int, TxnRequirement) 

    /**
    **/
    public java.util.Enumeration enumerateTxnRequirement()
    {
        return _txnRequirementList.elements();
    } //-- java.util.Enumeration enumerateTxnRequirement() 

    /**
     * 
     * @param index
    **/
    public TxnRequirement getTxnRequirement(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _txnRequirementList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (TxnRequirement) _txnRequirementList.elementAt(index);
    } //-- TxnRequirement getTxnRequirement(int) 

    /**
    **/
    public TxnRequirement[] getTxnRequirement()
    {
        int size = _txnRequirementList.size();
        TxnRequirement[] mArray = new TxnRequirement[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (TxnRequirement) _txnRequirementList.elementAt(index);
        }
        return mArray;
    } //-- TxnRequirement[] getTxnRequirement() 

    /**
    **/
    public int getTxnRequirementCount()
    {
        return _txnRequirementList.size();
    } //-- int getTxnRequirementCount() 

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
    public void removeAllTxnRequirement()
    {
        _txnRequirementList.removeAllElements();
    } //-- void removeAllTxnRequirement() 

    /**
     * 
     * @param index
    **/
    public TxnRequirement removeTxnRequirement(int index)
    {
        Object obj = _txnRequirementList.elementAt(index);
        _txnRequirementList.removeElementAt(index);
        return (TxnRequirement) obj;
    } //-- TxnRequirement removeTxnRequirement(int) 

    /**
     * 
     * @param index
     * @param vTxnRequirement
    **/
    public void setTxnRequirement(int index, TxnRequirement vTxnRequirement)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _txnRequirementList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _txnRequirementList.setElementAt(vTxnRequirement, index);
    } //-- void setTxnRequirement(int, TxnRequirement) 

    /**
     * 
     * @param txnRequirementArray
    **/
    public void setTxnRequirement(TxnRequirement[] txnRequirementArray)
    {
        //-- copy array
        _txnRequirementList.removeAllElements();
        for (int i = 0; i < txnRequirementArray.length; i++) {
            _txnRequirementList.addElement(txnRequirementArray[i]);
        }
    } //-- void setTxnRequirement(TxnRequirement) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.TxnRequirements unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.TxnRequirements) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.TxnRequirements.class, reader);
    } //-- de.fhg.isst.ComponentML.TxnRequirements unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
