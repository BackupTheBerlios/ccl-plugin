/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: ExportSectionChoice.java,v 1.2 2002/10/10 14:05:59 oetker Exp $
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
public class ExportSectionChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *     The facade element describes an individual component
     * facade.
     *     Used in: export-section.
     *    
    **/
    private java.util.Vector _facadeList;

    private de.fhg.isst.ComponentML.ExportSectionChoiceSequence _de_fhg_isst_ComponentML_ExportSectionChoiceSequence;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExportSectionChoice() {
        super();
        _facadeList = new Vector();
    } //-- de.fhg.isst.ComponentML.ExportSectionChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vFacade
    **/
    public void addFacade(Facade vFacade)
        throws java.lang.IndexOutOfBoundsException
    {
        _facadeList.addElement(vFacade);
    } //-- void addFacade(Facade) 

    /**
     * 
     * @param index
     * @param vFacade
    **/
    public void addFacade(int index, Facade vFacade)
        throws java.lang.IndexOutOfBoundsException
    {
        _facadeList.insertElementAt(vFacade, index);
    } //-- void addFacade(int, Facade) 

    /**
    **/
    public java.util.Enumeration enumerateFacade()
    {
        return _facadeList.elements();
    } //-- java.util.Enumeration enumerateFacade() 

    /**
    **/
    public de.fhg.isst.ComponentML.ExportSectionChoiceSequence getDe_Fhg_Isst_ComponentML_ExportSectionChoiceSequence()
    {
        return this._de_fhg_isst_ComponentML_ExportSectionChoiceSequence;
    } //-- de.fhg.isst.ComponentML.ExportSectionChoiceSequence getDe_Fhg_Isst_ComponentML_ExportSectionChoiceSequence() 

    /**
     * 
     * @param index
    **/
    public Facade getFacade(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _facadeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Facade) _facadeList.elementAt(index);
    } //-- Facade getFacade(int) 

    /**
    **/
    public Facade[] getFacade()
    {
        int size = _facadeList.size();
        Facade[] mArray = new Facade[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Facade) _facadeList.elementAt(index);
        }
        return mArray;
    } //-- Facade[] getFacade() 

    /**
    **/
    public int getFacadeCount()
    {
        return _facadeList.size();
    } //-- int getFacadeCount() 

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
    public void removeAllFacade()
    {
        _facadeList.removeAllElements();
    } //-- void removeAllFacade() 

    /**
     * 
     * @param index
    **/
    public Facade removeFacade(int index)
    {
        Object obj = _facadeList.elementAt(index);
        _facadeList.removeElementAt(index);
        return (Facade) obj;
    } //-- Facade removeFacade(int) 

    /**
     * 
     * @param de_fhg_isst_ComponentML_ExportSectionChoiceSequence
    **/
    public void setDe_Fhg_Isst_ComponentML_ExportSectionChoiceSequence(de.fhg.isst.ComponentML.ExportSectionChoiceSequence de_fhg_isst_ComponentML_ExportSectionChoiceSequence)
    {
        this._de_fhg_isst_ComponentML_ExportSectionChoiceSequence = de_fhg_isst_ComponentML_ExportSectionChoiceSequence;
    } //-- void setDe_Fhg_Isst_ComponentML_ExportSectionChoiceSequence(de.fhg.isst.ComponentML.ExportSectionChoiceSequence) 

    /**
     * 
     * @param index
     * @param vFacade
    **/
    public void setFacade(int index, Facade vFacade)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _facadeList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _facadeList.setElementAt(vFacade, index);
    } //-- void setFacade(int, Facade) 

    /**
     * 
     * @param facadeArray
    **/
    public void setFacade(Facade[] facadeArray)
    {
        //-- copy array
        _facadeList.removeAllElements();
        for (int i = 0; i < facadeArray.length; i++) {
            _facadeList.addElement(facadeArray[i]);
        }
    } //-- void setFacade(Facade) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.ExportSectionChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.ExportSectionChoice) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.ExportSectionChoice.class, reader);
    } //-- de.fhg.isst.ComponentML.ExportSectionChoice unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
