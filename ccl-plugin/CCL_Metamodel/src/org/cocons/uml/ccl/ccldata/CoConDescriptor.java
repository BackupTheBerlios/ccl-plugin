/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConDescriptor.java,v 1.3 2002/02/09 18:47:49 ali Exp $
 */

package org.cocons.uml.ccl.ccldata;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.mapping.AccessMode;
import org.exolab.castor.mapping.ClassDescriptor;
import org.exolab.castor.mapping.FieldDescriptor;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.FieldValidator;
import org.exolab.castor.xml.TypeValidator;
import org.exolab.castor.xml.XMLFieldDescriptor;
import org.exolab.castor.xml.handlers.*;
import org.exolab.castor.xml.util.XMLFieldDescriptorImpl;
import org.exolab.castor.xml.validators.*;

/**
 * 
 * @version $Revision: 1.3 $ $Date: 2002/02/09 18:47:49 $
**/
public class CoConDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String nsPrefix;

    private java.lang.String nsURI;

    private java.lang.String xmlName;

    private org.exolab.castor.xml.XMLFieldDescriptor identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConDescriptor() {
        super();
        xmlName = "CoCon";
        XMLFieldDescriptorImpl  desc           = null;
        XMLFieldHandler         handler        = null;
        FieldValidator          fieldValidator = null;
        
        //-- set grouping compositor
        setCompositorAsSequence();
        //-- initialize attribute descriptors
        
        //-- _type
        desc = new XMLFieldDescriptorImpl(java.lang.String.class, "_type", "type", NodeType.Attribute);
        desc.setImmutable(true);
        handler = (new XMLFieldHandler() {
            public Object getValue( Object object ) 
                throws IllegalStateException
            {
                CoCon target = (CoCon) object;
                return target.getType();
            }
            public void setValue( Object object, Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CoCon target = (CoCon) object;
                    target.setType( (java.lang.String) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return null;
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _type
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
            StringValidator sv = new StringValidator();
            sv.setWhiteSpace("preserve");
            fieldValidator.setValidator(sv);
        }
        desc.setValidator(fieldValidator);
        
        //-- initialize element descriptors
        
        //-- _coConSetList
        desc = new XMLFieldDescriptorImpl(CoConSet.class, "_coConSetList", "CoConSet", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public Object getValue( Object object ) 
                throws IllegalStateException
            {
                CoCon target = (CoCon) object;
                return target.getCoConSet();
            }
            public void setValue( Object object, Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CoCon target = (CoCon) object;
                    target.addCoConSet( (CoConSet) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new CoConSet();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _coConSetList
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(1);
        desc.setValidator(fieldValidator);
        
        //-- _coConAttributeList
        desc = new XMLFieldDescriptorImpl(CoConAttribute.class, "_coConAttributeList", "CoConAttribute", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public Object getValue( Object object ) 
                throws IllegalStateException
            {
                CoCon target = (CoCon) object;
                return target.getCoConAttribute();
            }
            public void setValue( Object object, Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CoCon target = (CoCon) object;
                    target.addCoConAttribute( (CoConAttribute) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new CoConAttribute();
            }
        } );
        desc.setHandler(handler);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _coConAttributeList
        fieldValidator = new FieldValidator();
        desc.setValidator(fieldValidator);
        
    } //-- org.cocons.uml.ccl.ccldata.CoConDescriptor()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public org.exolab.castor.mapping.AccessMode getAccessMode()
    {
        return null;
    } //-- org.exolab.castor.mapping.AccessMode getAccessMode() 

    /**
    **/
    public org.exolab.castor.mapping.ClassDescriptor getExtends()
    {
        return null;
    } //-- org.exolab.castor.mapping.ClassDescriptor getExtends() 

    /**
    **/
    public org.exolab.castor.mapping.FieldDescriptor getIdentity()
    {
        return identity;
    } //-- org.exolab.castor.mapping.FieldDescriptor getIdentity() 

    /**
    **/
    public java.lang.Class getJavaClass()
    {
        return org.cocons.uml.ccl.ccldata.CoCon.class;
    } //-- java.lang.Class getJavaClass() 

    /**
    **/
    public java.lang.String getNameSpacePrefix()
    {
        return nsPrefix;
    } //-- java.lang.String getNameSpacePrefix() 

    /**
    **/
    public java.lang.String getNameSpaceURI()
    {
        return nsURI;
    } //-- java.lang.String getNameSpaceURI() 

    /**
    **/
    public org.exolab.castor.xml.TypeValidator getValidator()
    {
        return this;
    } //-- org.exolab.castor.xml.TypeValidator getValidator() 

    /**
    **/
    public java.lang.String getXMLName()
    {
        return xmlName;
    } //-- java.lang.String getXMLName() 

}
