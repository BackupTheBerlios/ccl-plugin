package org.cocons.argo.util;

/**
 * Title:        CCL-Plugin for ArgoUML
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      Technische Universität Berlin
 * @author hyshosha@gmx.de ; hasihola@cs.tu-berlin.de
 * @version 1.0
 */

public class MessageContainer {

  private String _message;
  private int _int;
  private float _float;
  private String _string;
  private Object _object;

  public MessageContainer() {
  }

  public void setMessage(String message) { _message = message; }
  public String getMessage() { return(_message); }

  public void setInt(int __int) { _int = __int; }
  public int getInt() { return(_int); }

  public void setFloat(float __float) { _float = __float; }
  public float getFloat() { return(_float); }

  public void setString(String __string) { _string = __string; }
  public String getString() { return(_string); }

  public void setObject(Object __object) { _object = __object; }
  public Object getObject() { return(_object); }

}