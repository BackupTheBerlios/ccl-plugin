/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionIntersectionDescriptor.java,v 1.1 2002/02/08 16:08:27 ali Exp $
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
 * @version $Revision: 1.1 $ $Date: 2002/02/08 16:08:27 $
**/
public class CoConSetConditionIntersectionDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public CoConSetConditionIntersectionDescriptor() {
        super();
        xmlName = "CoConSetConditionIntersection";
        XMLFieldDescriptorImpl  desc           = null;
        XMLFieldHandler         handler        = null;
        FieldValidator          fieldValidator = null;
        
        //-- set grouping compositor
        setCompositorAsChoice();
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _coConSetConditionQuerySingleValue
        desc = new XMLFieldDescriptorImpl(CoConSetConditionQuerySingleValue.class, "_coConSetConditionQuerySingleValue", "CoConSetConditionQuerySingleValue", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public Object getValue( Object object ) 
                throws IllegalStateException
            {
                CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                return target.getCoConSetConditionQuerySingleValue();
            }
            public void setValue( Object object, Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                    target.setCoConSetConditionQuerySingleValue( (CoConSetConditionQuerySingleValue) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new CoConSetConditionQuerySingleValue();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _coConSetConditionQuerySingleValue
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(1);
        desc.setValidator(fieldValidator);
        
        //-- _coConSetConditionQuerySet
        desc = new XMLFieldDescriptorImpl(CoConSetConditionQuerySet.class, "_coConSetConditionQuerySet", "CoConSetConditionQuerySet", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public Object getValue( Object object ) 
                throws IllegalStateException
            {
                CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                return target.getCoConSetConditionQuerySet();
            }
            public void setValue( Object object, Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                    target.setCoConSetConditionQuerySet( (CoConSetConditionQuerySet) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new CoConSetConditionQuerySet();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _coConSetConditionQuerySet
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(1);
        desc.setValidator(fieldValidator);
        
        //-- _coConSetConditionQueryProperty
        desc = new XMLFieldDescriptorImpl(CoConSetConditionQueryProperty.class, "_coConSetConditionQueryProperty", "CoConSetConditionQueryProperty", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public Object getValue( Object object ) 
                throws IllegalStateException
            {
                CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                return target.getCoConSetConditionQueryProperty();
            }
            public void setValue( Object object, Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                    target.setCoConSetConditionQueryProperty( (CoConSetConditionQueryProperty) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new CoConSetConditionQueryProperty();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _coConSetConditionQueryProperty
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(1);
        desc.setValidator(fieldValidator);
        
        //-- _coConSetConditionUnion
        desc = new XMLFieldDescriptorImpl(CoConSetConditionUnion.class, "_coConSetConditionUnion", "CoConSetConditionUnion", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public Object getValue( Object object ) 
                throws IllegalStateException
            {
                CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                return target.getCoConSetConditionUnion();
            }
            public void setValue( Object object, Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                    target.setCoConSetConditionUnion( (CoConSetConditionUnion) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new CoConSetConditionUnion();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _coConSetConditionUnion
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(1);
        desc.setValidator(fieldValidator);
        
        //-- _coConSetConditionIntersection
        desc = new XMLFieldDescriptorImpl(CoConSetConditionIntersection.class, "_coConSetConditionIntersection", "CoConSetConditionIntersection", NodeType.Element);
        handler = (new XMLFieldHandler() {
            public Object getValue( Object object ) 
                throws IllegalStateException
            {
                CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                return target.getCoConSetConditionIntersection();
            }
            public void setValue( Object object, Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CoConSetConditionIntersection target = (CoConSetConditionIntersection) object;
                    target.setCoConSetConditionIntersection( (CoConSetConditionIntersection) value);
                }
                catch (Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public Object newInstance( Object parent ) {
                return new CoConSetConditionIntersection();
            }
        } );
        desc.setHandler(handler);
        desc.setRequired(true);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        
        //-- validation code for: _coConSetConditionIntersection
        fieldValidator = new FieldValidator();
        fieldValidator.setMinOccurs(1);
        desc.setValidator(fieldValidator);
        
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionIntersectionDescriptor()


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
        return org.cocons.uml.ccl.ccldata.CoConSetConditionIntersection.class;
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
