/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: Import.java,v 1.1 2003/07/12 18:21:46 layekers Exp $
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
 *     The import element specifies an import from a facade given
 * by a 
 *     facade-name.
 *     Used in: connector-spec.
 *    
 * @version $Revision: 1.1 $ $Date: 2003/07/12 18:21:46 $
**/
public class Import implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _from;

    /**
     * 
     *     The business-import element specifies a collection of
     * business methods 
     *     a component imports from a given component.
     *     If the rename-as attribute of the method-name element is
     * specified the 
     *     method is imported with the name given there.
     *     Used in: import-section, connector-spec.
     *    
    **/
    private java.util.Vector _businessImportList;

    /**
     * 
     *     The type-import element specifies a collection of types
     * imported 
     *     from the given component.
     *     If the rename-as attribute is specified a type will be
     * known with the 
     *     name specified there.
     *     Used in: connector-spec, import-section.
     *    
    **/
    private TypeImport _typeImport;


      //----------------/
     //- Constructors -/
    //----------------/

    public Import() {
        super();
        _businessImportList = new Vector();
    } //-- de.fhg.isst.ComponentML.Import()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vBusinessImport
    **/
    public void addBusinessImport(BusinessImport vBusinessImport)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_businessImportList.size() < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessImportList.addElement(vBusinessImport);
    } //-- void addBusinessImport(BusinessImport) 

    /**
     * 
     * @param index
     * @param vBusinessImport
    **/
    public void addBusinessImport(int index, BusinessImport vBusinessImport)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_businessImportList.size() < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessImportList.insertElementAt(vBusinessImport, index);
    } //-- void addBusinessImport(int, BusinessImport) 

    /**
    **/
    public java.util.Enumeration enumerateBusinessImport()
    {
        return _businessImportList.elements();
    } //-- java.util.Enumeration enumerateBusinessImport() 

    /**
     * 
     * @param index
    **/
    public BusinessImport getBusinessImport(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _businessImportList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (BusinessImport) _businessImportList.elementAt(index);
    } //-- BusinessImport getBusinessImport(int) 

    /**
    **/
    public BusinessImport[] getBusinessImport()
    {
        int size = _businessImportList.size();
        BusinessImport[] mArray = new BusinessImport[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (BusinessImport) _businessImportList.elementAt(index);
        }
        return mArray;
    } //-- BusinessImport[] getBusinessImport() 

    /**
    **/
    public int getBusinessImportCount()
    {
        return _businessImportList.size();
    } //-- int getBusinessImportCount() 

    /**
    **/
    public java.lang.String getFrom()
    {
        return this._from;
    } //-- java.lang.String getFrom() 

    /**
    **/
    public TypeImport getTypeImport()
    {
        return this._typeImport;
    } //-- TypeImport getTypeImport() 

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
    public void removeAllBusinessImport()
    {
        _businessImportList.removeAllElements();
    } //-- void removeAllBusinessImport() 

    /**
     * 
     * @param index
    **/
    public BusinessImport removeBusinessImport(int index)
    {
        Object obj = _businessImportList.elementAt(index);
        _businessImportList.removeElementAt(index);
        return (BusinessImport) obj;
    } //-- BusinessImport removeBusinessImport(int) 

    /**
     * 
     * @param index
     * @param vBusinessImport
    **/
    public void setBusinessImport(int index, BusinessImport vBusinessImport)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _businessImportList.size())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(index < 2)) {
            throw new IndexOutOfBoundsException();
        }
        _businessImportList.setElementAt(vBusinessImport, index);
    } //-- void setBusinessImport(int, BusinessImport) 

    /**
     * 
     * @param businessImportArray
    **/
    public void setBusinessImport(BusinessImport[] businessImportArray)
    {
        //-- copy array
        _businessImportList.removeAllElements();
        for (int i = 0; i < businessImportArray.length; i++) {
            _businessImportList.addElement(businessImportArray[i]);
        }
    } //-- void setBusinessImport(BusinessImport) 

    /**
     * 
     * @param from
    **/
    public void setFrom(java.lang.String from)
    {
        this._from = from;
    } //-- void setFrom(java.lang.String) 

    /**
     * 
     * @param typeImport
    **/
    public void setTypeImport(TypeImport typeImport)
    {
        this._typeImport = typeImport;
    } //-- void setTypeImport(TypeImport) 

    /**
     * 
     * @param reader
    **/
    public static de.fhg.isst.ComponentML.Import unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (de.fhg.isst.ComponentML.Import) Unmarshaller.unmarshal(de.fhg.isst.ComponentML.Import.class, reader);
    } //-- de.fhg.isst.ComponentML.Import unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
