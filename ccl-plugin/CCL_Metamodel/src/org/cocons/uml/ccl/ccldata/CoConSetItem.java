/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id: CoConSetItem.java,v 1.2 2002/02/08 16:08:27 ali Exp $
 */

package org.cocons.uml.ccl.ccldata;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import org.exolab.castor.xml.*;

/**
 * 
 * @version $Revision: 1.2 $ $Date: 2002/02/08 16:08:27 $
**/
public class CoConSetItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private CoConSetCondition _coConSetCondition;

    private CoConSetDirectReference _coConSetDirectReference;


      //----------------/
     //- Constructors -/
    //----------------/

    public CoConSetItem() {
        super();
    } //-- org.cocons.uml.ccl.ccldata.CoConSetItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public CoConSetCondition getCoConSetCondition()
    {
        return this._coConSetCondition;
    } //-- CoConSetCondition getCoConSetCondition() 

    /**
    **/
    public CoConSetDirectReference getCoConSetDirectReference()
    {
        return this._coConSetDirectReference;
    } //-- CoConSetDirectReference getCoConSetDirectReference() 

    /**
     * 
     * @param coConSetCondition
    **/
    public void setCoConSetCondition(CoConSetCondition coConSetCondition)
    {
        this._coConSetCondition = coConSetCondition;
    } //-- void setCoConSetCondition(CoConSetCondition) 

    /**
     * 
     * @param coConSetDirectReference
    **/
    public void setCoConSetDirectReference(CoConSetDirectReference coConSetDirectReference)
    {
        this._coConSetDirectReference = coConSetDirectReference;
    } //-- void setCoConSetDirectReference(CoConSetDirectReference) 

}
