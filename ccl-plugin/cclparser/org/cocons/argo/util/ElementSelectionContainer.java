package org.cocons.argo.util;

import ru.novosoft.uml.foundation.core.MModelElement;
import java.util.Vector;
import org.cocons.argo.util.ContextPropertyContainer;

/**
 * <p>Überschrift: ElementSelectin</p>
 * <p>Beschreibung: Kapselt Modelelement mit ContextProperty</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Organisation: TU-Berlin</p>
 * @author Ute von Angern
 * @version 1.0
 */

public class ElementSelectionContainer {

  private MModelElement mElement;
  private Vector cp = new Vector();

  public ElementSelectionContainer() {
  }

  public void setModelelement(MModelElement melement) {
    mElement = melement;
  }

  public void setContextPropertyContainer(String name, Vector val) {
    ContextPropertyContainer cpc = new ContextPropertyContainer();
    cpc.setContextPropertyName(name);
    cpc.setContextPropertyValues(val);
    cp.addElement(cpc);
  }

  public MModelElement getModelelement() {
    return mElement;
  }

  public Vector getContextPropertyList() {
    return cp;
  }

  public String getContextPropertyNameAt(int i) {
    if(i < cp.size()) {
      ContextPropertyContainer cpc = (ContextPropertyContainer) cp.elementAt(i);
      return cpc.getContextPropertyName();
    }
    else {
      return null;
    }
  }

  public int getIndexOf(String name) {
    int j=-1;
    for(int i=0; i<cp.size(); i++) {
      ContextPropertyContainer cpc = (ContextPropertyContainer) cp.elementAt(i);
      if(name.trim().equals(cpc.getContextPropertyName())) {
        j=i;
      }
    }
    return j;
  }

  public Vector getContextPropertyValueList(int i) {
    if(i < cp.size()) {
      ContextPropertyContainer cpc = (ContextPropertyContainer) cp.elementAt(i);
      return cpc.getContextPropertyValues();
    }
    else {
      return null;
    }
  }

}