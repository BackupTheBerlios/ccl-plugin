package org.cocons.uml.xmi;

import ru.novosoft.uml.xmi.XMIReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

import java.util.StringTokenizer;

import java.io.*;

import org.jdom.*;

import ru.novosoft.uml.foundation.core.*;
import org.cocons.uml.ccl.*;
import org.cocons.uml.*;

import org.xml.sax.*;
import javax.xml.parsers.*;


/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class CCLXMIReader extends XMIReader {

  public CCLXMIReader() throws SAXException,
                            ParserConfigurationException

  {
    super(MCCLFactoryImpl.getFactory());
  }

  public CCLXMIReader(MCCLFactoryImpl p_factory) throws SAXException,
                                              ParserConfigurationException
  {
    super(p_factory);
  }

  public CCLXMIReader(boolean validating) throws SAXException,
                                              ParserConfigurationException
  {
    super(MCCLFactoryImpl.getFactory(), validating);
  }

  public CCLXMIReader(MCCLFactoryImpl p_factory, boolean validating) throws SAXException,
                                              ParserConfigurationException
  {
    super(p_factory, validating);
  }

  protected Object processUnknown(boolean ref, String p_name, AttributeList p_attrs)
  {
    String lastName = null;
    String nodeName = p_name;

    if (nodeName.startsWith("CoCons.Uml.Ccl.",0))
    {
      lastName = nodeName.substring(15);

      if (lastName.equals("ContextPropertyTag"))
      {
        if (ref)
        {
          Object o = getObjectByRef(p_attrs);
          if (null == o || this == o)
          {
            putObjectByRef(p_attrs, this);
            Link l = new Link();
            l.parameterXMIID = p_attrs.getValue("xmi.idref");
            l.parameterXMIUUID = p_attrs.getValue("xmi.uuidref");
            return l;
          }

          MContextPropertyTag o2 = (MContextPropertyTag)o;
          String nodeXMIUUID = p_attrs.getValue("xmi.uuidref");

          if (null != nodeXMIUUID)
          {
            o2.setUUID(nodeXMIUUID);
          }
          putObjectByRef(p_attrs, o2);

          return o2;
        }
        else
        {
          MContextPropertyTag o2;
          Object o = getObject(p_attrs);
          if (null == o || this == o)
          {
            o2 = ((MCCLFactoryImpl)factory).createContextPropertyTag();
          }
          else
          {
            o2 = (MContextPropertyTag)o;
          }

          String nodeXMIUUID = p_attrs.getValue("xmi.uuid");

          if (null != nodeXMIUUID)
          {
            o2.setUUID(nodeXMIUUID);
          }
          putObject(p_attrs, o2);

          return o2;
        }
      }
      else if (lastName.equals("ContextbasedConstraint"))
      {
        if (ref)
        {
          Object o = getObjectByRef(p_attrs);
          if (null == o || this == o)
          {
            putObjectByRef(p_attrs, this);
            Link l = new Link();
            l.parameterXMIID = p_attrs.getValue("xmi.idref");
            l.parameterXMIUUID = p_attrs.getValue("xmi.uuidref");
            return l;
          }

          MContextbasedConstraint o2 = (MContextbasedConstraint)o;
          String nodeXMIUUID = p_attrs.getValue("xmi.uuidref");

          if (null != nodeXMIUUID)
          {
            o2.setUUID(nodeXMIUUID);
          }
          putObjectByRef(p_attrs, o2);

          return o2;
        }
        else
        {
          MContextbasedConstraint o2;
          Object o = getObject(p_attrs);
          if (null == o || this == o)
          {
            o2 = ((MCCLFactoryImpl)factory).createContextbasedConstraint();
          }
          else
          {
            o2 = (MContextbasedConstraint)o;
          }

          String nodeXMIUUID = p_attrs.getValue("xmi.uuid");

          if (null != nodeXMIUUID)
          {
            o2.setUUID(nodeXMIUUID);
          }
          putObject(p_attrs, o2);

          return o2;
        }
      }
    }
    return super.processUnknown(ref, p_name, p_attrs);
  }

  protected boolean startUnknown(Object o, String p_name, AttributeList p_attrs)
  {
    boolean processed = false;
    if (o instanceof MContextPropertyTag)
    {
      processed = processContextPropertyTagMain(p_name, p_attrs);
    }
    else if (o instanceof MContextbasedConstraint)
    {
      processed = processContextbasedConstraintMain(p_name, p_attrs);
    }
    else
    {
      processed = super.startUnknown(o, p_name, p_attrs);
    }
    return processed;
  }

  protected void endUnknown(Object o, String p_name)
  {
    if (o instanceof MContextPropertyTag)
    {
      postprocessContextPropertyTagMain(p_name);
    }
    if (o instanceof MContextbasedConstraint)
    {
      postprocessContextbasedConstraintMain(p_name);
    }
    else
    {
      super.endUnknown(o, p_name);
    }
  }

  public boolean processContextPropertyTagMain(String p_name, AttributeList p_attrs)
  {
    MContextPropertyTag o = (MContextPropertyTag)liStack.get(liStack.size()-1);

    if (processContextPropertyTagAttributes(p_name, p_attrs, o))
    {
      return true;
    }

    if (processContextPropertyTagRoles(p_name, p_attrs, o))
    {
      return true;
    }
    return processXMIExtensionMain(p_name, p_attrs);
  }

  public void postprocessContextPropertyTagMain(String p_name)
  {
    MContextPropertyTag o = (MContextPropertyTag)liStack.get(liStack.size()-2);

    if (postprocessContextPropertyTagAttributes(p_name, o))
    {
      return;
    }

    if (postprocessContextPropertyTagRoles(p_name, o))
    {
      return;
    }
    postprocessXMIExtensionMain(p_name, o);
  }

  public boolean processContextPropertyTagAttributes(String p_name, AttributeList p_attrs, MContextPropertyTag o)
  {
    if (processTagDefinitionAttributes(p_name, p_attrs, o))
    {
      return true;
    }
    if (p_name.startsWith("CoCons.Uml.Ccl.ContextPropertyTag."))
    {
      String lastName = p_name.substring(34);
    }
    return false;
  }

  public boolean postprocessContextPropertyTagAttributes(String p_name, MContextPropertyTag o)
  {
    if (postprocessTagDefinitionAttributes(p_name, o))
    {
      return true;
    }
    if (p_name.startsWith("CoCons.Uml.Ccl.ContextPropertyTag."))
    {
      String lastName = p_name.substring(34);
    }
    return false;
  }

  public boolean processContextPropertyTagRoles(String p_name, AttributeList p_attrs, MContextPropertyTag o)
  {
    if (processTagDefinitionRoles(p_name, p_attrs, o))
    {
      return true;
    }
    if (p_name.startsWith("CoCons.Uml.Ccl.ContextPropertyTag."))
    {
      String lastName = p_name.substring(34);

      if (lastName.equals("valueValidation"))
      {
        lastMethod = "valueValidation";
        lastMethodType = true;
        liStack.add(STATE_SINGLE);
        liNameStack.add(p_name);
        return true;
      }
    }
    return false;
  }

  public boolean postprocessContextPropertyTagRoles(String p_name, MContextPropertyTag o)
  {
    if (postprocessTagDefinitionRoles(p_name, o))
    {
      return true;
    }
    if (p_name.startsWith("CoCons.Uml.Ccl.ContextPropertyTag."))
    {
      String lastName = p_name.substring(34);

      if (lastName.equals("valueValidation"))
      {
        MConstraint el = (MConstraint)lastObject;
        if (null != el)
        {
          o.setValueValidation(el);
          return true;
        }
        return false;
      }
    }
    return false;
  }
  public boolean processContextbasedConstraintMain(String p_name, AttributeList p_attrs)
  {
    MContextbasedConstraint o = (MContextbasedConstraint)liStack.get(liStack.size()-1);

    if (processContextbasedConstraintAttributes(p_name, p_attrs, o))
    {
      return true;
    }

    if (processContextbasedConstraintRoles(p_name, p_attrs, o))
    {
      return true;
    }
    return processXMIExtensionMain(p_name, p_attrs);
  }

  public void postprocessContextbasedConstraintMain(String p_name)
  {
    MContextbasedConstraint o = (MContextbasedConstraint)liStack.get(liStack.size()-2);

    if (postprocessContextbasedConstraintAttributes(p_name, o))
    {
      return;
    }

    if (postprocessContextbasedConstraintRoles(p_name, o))
    {
      return;
    }
    postprocessXMIExtensionMain(p_name, o);
  }

  public boolean processContextbasedConstraintAttributes(String p_name, AttributeList p_attrs, MContextbasedConstraint o)
  {
    if (processConstraintAttributes(p_name, p_attrs, o))
    {
      return true;
    }
    if (p_name.startsWith("CoCons.Uml.Ccl.ContextbasedConstraint."))
    {
      String lastName = p_name.substring(38);
      if (lastName.equals("priority"))
      {
        lastMethod = "priority";
        lastMethodType = true;
        liStack.add(o);
        liNameStack.add(p_name);
        return true;
      }
    }
    return false;
  }

  public boolean postprocessContextbasedConstraintAttributes(String p_name, MContextbasedConstraint o)
  {
    if (postprocessConstraintAttributes(p_name, o))
    {
      return true;
    }
    if (p_name.startsWith("CoCons.Uml.Ccl.ContextbasedConstraint."))
    {
      String lastName = p_name.substring(38);
      if (lastName.equals("priority"))
      {
        o.setPriority(new Integer(lastString.toString()));
        return true;
      }
    }
    return false;
  }

  public boolean processContextbasedConstraintRoles(String p_name, AttributeList p_attrs, MContextbasedConstraint o)
  {
    if (processConstraintRoles(p_name, p_attrs, o))
    {
      return true;
    }
    if (p_name.startsWith("CoCons.Uml.Ccl.ContextbasedConstraint."))
    {
      String lastName = p_name.substring(38);

    }
    return false;
  }

  public boolean postprocessContextbasedConstraintRoles(String p_name, MContextbasedConstraint o)
  {
    if (postprocessConstraintRoles(p_name, o))
    {
      return true;
    }
    if (p_name.startsWith("CoCons.Uml.Ccl.ContextbasedConstraint."))
    {
      String lastName = p_name.substring(38);

    }
    return false;
  }
}