/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetConditionChoiceItem.java,v 1.1 2002/02/06 12:11:20 ali Exp $
 */

package org.cocons.uml.ccl.ccldata;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import org.exolab.castor.xml.*;

/**
 * 
 * @version $Revision: 1.1 $ $Date: 2002/02/06 12:11:20 $
**/
public class CoConSetConditionChoiceItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private CoConSetConditionQuerySingleValue _coConSetConditionQuerySingleValue;

    private CoConSetConditionQuerySet _coConSetConditionQuerySet;

    private CoConSetConditionQueryProperty _coConSetConditionQueryProperty;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetConditionChoiceItem() {
        super();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetConditionChoiceItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public CoConSetConditionQueryProperty getCoConSetConditionQueryProperty()
    {
        return this._coConSetConditionQueryProperty;
    } //-- CoConSetConditionQueryProperty getCoConSetConditionQueryProperty() 

    /**
    **/
    public CoConSetConditionQuerySet getCoConSetConditionQuerySet()
    {
        return this._coConSetConditionQuerySet;
    } //-- CoConSetConditionQuerySet getCoConSetConditionQuerySet() 

    /**
    **/
    public CoConSetConditionQuerySingleValue getCoConSetConditionQuerySingleValue()
    {
        return this._coConSetConditionQuerySingleValue;
    } //-- CoConSetConditionQuerySingleValue getCoConSetConditionQuerySingleValue() 

    /**
     * 
     * @param coConSetConditionQueryProperty
    **/
    public void setCoConSetConditionQueryProperty(CoConSetConditionQueryProperty coConSetConditionQueryProperty)
    {
        this._coConSetConditionQueryProperty = coConSetConditionQueryProperty;
    } //-- void setCoConSetConditionQueryProperty(CoConSetConditionQueryProperty) 

    /**
     * 
     * @param coConSetConditionQuerySet
    **/
    public void setCoConSetConditionQuerySet(CoConSetConditionQuerySet coConSetConditionQuerySet)
    {
        this._coConSetConditionQuerySet = coConSetConditionQuerySet;
    } //-- void setCoConSetConditionQuerySet(CoConSetConditionQuerySet) 

    /**
     * 
     * @param coConSetConditionQuerySingleValue
    **/
    public void setCoConSetConditionQuerySingleValue(CoConSetConditionQuerySingleValue coConSetConditionQuerySingleValue)
    {
        this._coConSetConditionQuerySingleValue = coConSetConditionQuerySingleValue;
    } //-- void setCoConSetConditionQuerySingleValue(CoConSetConditionQuerySingleValue) 

}
