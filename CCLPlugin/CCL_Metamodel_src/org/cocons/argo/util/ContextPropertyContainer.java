package org.cocons.argo.util;

import java.util.Vector;
/**
 * <p>Überschrift: ContextPropertyContainer</p>
 * <p>Beschreibung: Kapselt ContextProperty</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Organisation: TU- Berlin</p>
 * @author Ute von Angern
 * @version 1.0
 */

public class ContextPropertyContainer {

  private String contextPropertyName;
  private Vector values = new Vector();
  public ContextPropertyContainer() {
  }

  public void setContextPropertyName(String name) {
    contextPropertyName = name;
  }

  public void setContextPropertyValues(Vector val) {
    for(int i=0; i<val.size(); i++) {
      values.addElement(val.elementAt(i));
    }
  }

  public String getContextPropertyName() {
    return contextPropertyName;
  }

  public Vector getContextPropertyValues() {
    return values;
  }

}