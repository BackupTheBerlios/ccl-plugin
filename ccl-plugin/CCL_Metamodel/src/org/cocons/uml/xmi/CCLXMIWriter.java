package org.cocons.uml.xmi;

import ru.novosoft.uml.xmi.XMIWriter;

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

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
// import ru.novosoft.uml.behavior.*;
import ru.novosoft.uml.behavior.use_cases.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.behavior.state_machines.*;
import ru.novosoft.uml.behavior.collaborations.*;
import ru.novosoft.uml.behavior.activity_graphs.*;
import ru.novosoft.uml.model_management.*;
import org.cocons.uml.ccl.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;



/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class CCLXMIWriter extends XMIWriter {

  /**
   * a constructor
   * @param p_mmodel a MModel
   * @param p_filename a filename
   * @param p_encoding a encoding
   */
  public CCLXMIWriter(MModel p_mmodel, String p_filename, String p_encoding) throws IOException
  {
    super(p_mmodel, p_filename, p_encoding);
  }

  /**
   * a constructor
   * @param p_mmodel a MModel
   * @param p_filename a String
   */
  public CCLXMIWriter(MModel p_mmodel, String p_filename) throws IOException
  {
    super(p_mmodel, p_filename);
  }

  /**
   * a constructor
   * @param p_out a java.io.Writer
   */
  public CCLXMIWriter(MModel p_mmodel, java.io.Writer p_out) throws IOException
  {
    super(p_mmodel, p_out);
  }

  public String getExporterVersion()
  {
    return super.getExporterVersion() + " (0.0.1)";
  }
  public String getExporterName()
  {
    return super.getExporterName() + " + CoCons CCL Extensions";
  }
  public String getXmiName()
  {
    return "CCL";
  }
  public String getXmiVersion()
  {
    return "1.0";
  }

  protected void printMain(Object arg, String roleTypeXMIName) throws SAXException
  {
    if (arg instanceof MContextPropertyTag)
    {
      printContextPropertyTagMain((MContextPropertyTag)arg);
      return;
    }
    if (arg instanceof MContextbasedConstraint)
    {
      printContextbasedConstraintMain((MContextbasedConstraint)arg);
      return;
    }
    super.printMain(arg, roleTypeXMIName);
  }

  public void printContextPropertyTagMain(MContextPropertyTag arg) throws SAXException
  {
    if (null == arg)
    {
      return;
    }

    processElement(arg);

    al.addAttribute("xmi.id", CDATA_TYPE, getXMIID(arg));
    addXMIUUID(arg, al);
    dh.startElement("CoCons.Uml.Ccl.ContextPropertyTag", al); al.clear();
    if (null != arg.getName())
    {
      dh.startElement("Foundation.Core.ModelElement.name", al);
      characters(arg.getName());
      dh.endElement("Foundation.Core.ModelElement.name");
    }
    if (null != arg.getVisibility())
    {
      al.addAttribute("xmi.value", CDATA_TYPE, arg.getVisibility().getName());      dh.startElement("Foundation.Core.ModelElement.visibility", al); al.clear();
      dh.endElement("Foundation.Core.ModelElement.visibility");
    }
    al.addAttribute("xmi.value", CDATA_TYPE, convertBooleanXMI(arg.isSpecification()));    dh.startElement("Foundation.Core.ModelElement.isSpecification", al); al.clear();
    dh.endElement("Foundation.Core.ModelElement.isSpecification");
    if (null != arg.getTagType())
    {
      dh.startElement("Foundation.Extension_Mechanisms.TagDefinition.tagType", al);
      characters(arg.getTagType());
      dh.endElement("Foundation.Extension_Mechanisms.TagDefinition.tagType");
    }
    if (null != arg.getMultiplicity())
    {
      dh.startElement("Foundation.Extension_Mechanisms.TagDefinition.multiplicity", al);
      print(arg.getMultiplicity(), false, "Foundation.Data_Types.Multiplicity");
      dh.endElement("Foundation.Extension_Mechanisms.TagDefinition.multiplicity");
    }
    printXMIExtension(arg);
    if (null != arg.getNamespace())
    {
      dh.startElement("Foundation.Core.ModelElement.namespace", al);
      print(arg.getNamespace(), true, "Foundation.Core.Namespace");
      dh.endElement("Foundation.Core.ModelElement.namespace");
    }
    {
      Iterator i = arg.getClientDependencies().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.clientDependency", al);
        while(i.hasNext())
        {
          MDependency el = (MDependency)i.next();
          print(el, true, "Foundation.Core.Dependency");
        }
        dh.endElement("Foundation.Core.ModelElement.clientDependency");
      }
    }
    {
      Iterator i = arg.getConstraints().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.constraint", al);
        while(i.hasNext())
        {
          MConstraint el = (MConstraint)i.next();
          print(el, true, "Foundation.Core.Constraint");
        }
        dh.endElement("Foundation.Core.ModelElement.constraint");
      }
    }
    {
      Iterator i = arg.getSupplierDependencies().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.supplierDependency", al);
        while(i.hasNext())
        {
          MDependency el = (MDependency)i.next();
          print(el, true, "Foundation.Core.Dependency");
        }
        dh.endElement("Foundation.Core.ModelElement.supplierDependency");
      }
    }
    {
      Iterator i = arg.getPresentations().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.presentation", al);
        while(i.hasNext())
        {
          MPresentationElement el = (MPresentationElement)i.next();
          print(el, true, "Foundation.Core.PresentationElement");
        }
        dh.endElement("Foundation.Core.ModelElement.presentation");
      }
    }
    {
      Iterator i = arg.getTargetFlows().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.targetFlow", al);
        while(i.hasNext())
        {
          MFlow el = (MFlow)i.next();
          print(el, true, "Foundation.Core.Flow");
        }
        dh.endElement("Foundation.Core.ModelElement.targetFlow");
      }
    }
    {
      Iterator i = arg.getSourceFlows().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.sourceFlow", al);
        while(i.hasNext())
        {
          MFlow el = (MFlow)i.next();
          print(el, true, "Foundation.Core.Flow");
        }
        dh.endElement("Foundation.Core.ModelElement.sourceFlow");
      }
    }
    {
      Iterator i = arg.getTemplateParameters3().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.templateParameter3", al);
        while(i.hasNext())
        {
          MTemplateParameter el = (MTemplateParameter)i.next();
          print(el, true, "Foundation.Core.TemplateParameter");
        }
        dh.endElement("Foundation.Core.ModelElement.templateParameter3");
      }
    }
    {
      Iterator i = arg.getBindings().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.binding", al);
        while(i.hasNext())
        {
          MBinding el = (MBinding)i.next();
          print(el, true, "Foundation.Core.Binding");
        }
        dh.endElement("Foundation.Core.ModelElement.binding");
      }
    }
    {
      Iterator i = arg.getComments().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.comment", al);
        while(i.hasNext())
        {
          MComment el = (MComment)i.next();
          print(el, true, "Foundation.Core.Comment");
        }
        dh.endElement("Foundation.Core.ModelElement.comment");
      }
    }
    {
      Iterator i = arg.getElementResidences().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.elementResidence", al);
        while(i.hasNext())
        {
          MElementResidence el = (MElementResidence)i.next();
          print(el, true, "Foundation.Core.ElementResidence");
        }
        dh.endElement("Foundation.Core.ModelElement.elementResidence");
      }
    }
    {
      Iterator i = arg.getTemplateParameters2().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.templateParameter2", al);
        while(i.hasNext())
        {
          MTemplateParameter el = (MTemplateParameter)i.next();
          print(el, true, "Foundation.Core.TemplateParameter");
        }
        dh.endElement("Foundation.Core.ModelElement.templateParameter2");
      }
    }
    {
      Iterator i = arg.getElementImports2().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.elementImport", al);
        while(i.hasNext())
        {
          MElementImport el = (MElementImport)i.next();
          print(el, true, "Model_Management.ElementImport");
        }
        dh.endElement("Foundation.Core.ModelElement.elementImport");
      }
    }
    {
      Iterator i = arg.getTypedValues().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Extension_Mechanisms.TagDefinition.typedValue", al);
        while(i.hasNext())
        {
          MTaggedValue el = (MTaggedValue)i.next();
          print(el, true, "Foundation.Extension_Mechanisms.TaggedValue");
        }
        dh.endElement("Foundation.Extension_Mechanisms.TagDefinition.typedValue");
      }
    }
    if (null != arg.getValueValidation())
    {
      dh.startElement("CoCons.Uml.Ccl.ContextPropertyTag.valueValidation", al);
      print(arg.getValueValidation(), true, "Foundation.Core.Constraint");
      dh.endElement("CoCons.Uml.Ccl.ContextPropertyTag.valueValidation");
    }
    {
      Iterator i = arg.getTemplateParameters().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.templateParameter", al);
        while(i.hasNext())
        {
          MTemplateParameter el = (MTemplateParameter)i.next();
          print(el, false, "Foundation.Core.TemplateParameter");
        }
        dh.endElement("Foundation.Core.ModelElement.templateParameter");
      }
    }
    {
      Iterator i = arg.getTaggedValues().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.taggedValue", al);
        while(i.hasNext())
        {
          MTaggedValue el = (MTaggedValue)i.next();
          print(el, false, "Foundation.Extension_Mechanisms.TaggedValue");
        }
        dh.endElement("Foundation.Core.ModelElement.taggedValue");
      }
    }
    {
      Iterator i = arg.getReferenceTags().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.referenceTag", al);
        while(i.hasNext())
        {
          MTaggedValue el = (MTaggedValue)i.next();
          print(el, true, "Foundation.Extension_Mechanisms.TaggedValue");
        }
        dh.endElement("Foundation.Core.ModelElement.referenceTag");
      }
    }
    dh.endElement("CoCons.Uml.Ccl.ContextPropertyTag");
  }

  public void printContextbasedConstraintMain(MContextbasedConstraint arg) throws SAXException
  {
    if (null == arg)
    {
      return;
    }

    processElement(arg);

    al.addAttribute("xmi.id", CDATA_TYPE, getXMIID(arg));
    addXMIUUID(arg, al);
    dh.startElement("CoCons.Uml.Ccl.ContextbasedConstraint", al); al.clear();
    if (null != arg.getName())
    {
      dh.startElement("Foundation.Core.ModelElement.name", al);
      characters(arg.getName());
      dh.endElement("Foundation.Core.ModelElement.name");
    }
    if (null != arg.getVisibility())
    {
      al.addAttribute("xmi.value", CDATA_TYPE, arg.getVisibility().getName());      dh.startElement("Foundation.Core.ModelElement.visibility", al); al.clear();
      dh.endElement("Foundation.Core.ModelElement.visibility");
    }
    al.addAttribute("xmi.value", CDATA_TYPE, convertBooleanXMI(arg.isSpecification()));    dh.startElement("Foundation.Core.ModelElement.isSpecification", al); al.clear();
    dh.endElement("Foundation.Core.ModelElement.isSpecification");
    if (null != arg.getBody())
    {
      dh.startElement("Foundation.Core.Constraint.body", al);
      print(arg.getBody(), false, "Foundation.Data_Types.BooleanExpression");
      dh.endElement("Foundation.Core.Constraint.body");
    }
    if (null != arg.getPriority())
    {
      dh.startElement("CoCons.Uml.Ccl.ContextbasedConstraint.priority", al);
      characters( arg.getPriority().toString() );
      dh.endElement("CoCons.Uml.Ccl.ContextbasedConstraint.priority");
    }
    printXMIExtension(arg);
    if (null != arg.getNamespace())
    {
      dh.startElement("Foundation.Core.ModelElement.namespace", al);
      print(arg.getNamespace(), true, "Foundation.Core.Namespace");
      dh.endElement("Foundation.Core.ModelElement.namespace");
    }
    {
      Iterator i = arg.getClientDependencies().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.clientDependency", al);
        while(i.hasNext())
        {
          MDependency el = (MDependency)i.next();
          print(el, true, "Foundation.Core.Dependency");
        }
        dh.endElement("Foundation.Core.ModelElement.clientDependency");
      }
    }
    {
      Iterator i = arg.getConstraints().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.constraint", al);
        while(i.hasNext())
        {
          MConstraint el = (MConstraint)i.next();
          print(el, true, "Foundation.Core.Constraint");
        }
        dh.endElement("Foundation.Core.ModelElement.constraint");
      }
    }
    {
      Iterator i = arg.getSupplierDependencies().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.supplierDependency", al);
        while(i.hasNext())
        {
          MDependency el = (MDependency)i.next();
          print(el, true, "Foundation.Core.Dependency");
        }
        dh.endElement("Foundation.Core.ModelElement.supplierDependency");
      }
    }
    {
      Iterator i = arg.getPresentations().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.presentation", al);
        while(i.hasNext())
        {
          MPresentationElement el = (MPresentationElement)i.next();
          print(el, true, "Foundation.Core.PresentationElement");
        }
        dh.endElement("Foundation.Core.ModelElement.presentation");
      }
    }
    {
      Iterator i = arg.getTargetFlows().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.targetFlow", al);
        while(i.hasNext())
        {
          MFlow el = (MFlow)i.next();
          print(el, true, "Foundation.Core.Flow");
        }
        dh.endElement("Foundation.Core.ModelElement.targetFlow");
      }
    }
    {
      Iterator i = arg.getSourceFlows().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.sourceFlow", al);
        while(i.hasNext())
        {
          MFlow el = (MFlow)i.next();
          print(el, true, "Foundation.Core.Flow");
        }
        dh.endElement("Foundation.Core.ModelElement.sourceFlow");
      }
    }
    {
      Iterator i = arg.getTemplateParameters3().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.templateParameter3", al);
        while(i.hasNext())
        {
          MTemplateParameter el = (MTemplateParameter)i.next();
          print(el, true, "Foundation.Core.TemplateParameter");
        }
        dh.endElement("Foundation.Core.ModelElement.templateParameter3");
      }
    }
    {
      Iterator i = arg.getBindings().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.binding", al);
        while(i.hasNext())
        {
          MBinding el = (MBinding)i.next();
          print(el, true, "Foundation.Core.Binding");
        }
        dh.endElement("Foundation.Core.ModelElement.binding");
      }
    }
    {
      Iterator i = arg.getComments().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.comment", al);
        while(i.hasNext())
        {
          MComment el = (MComment)i.next();
          print(el, true, "Foundation.Core.Comment");
        }
        dh.endElement("Foundation.Core.ModelElement.comment");
      }
    }
    {
      Iterator i = arg.getElementResidences().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.elementResidence", al);
        while(i.hasNext())
        {
          MElementResidence el = (MElementResidence)i.next();
          print(el, true, "Foundation.Core.ElementResidence");
        }
        dh.endElement("Foundation.Core.ModelElement.elementResidence");
      }
    }
    {
      Iterator i = arg.getTemplateParameters2().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.templateParameter2", al);
        while(i.hasNext())
        {
          MTemplateParameter el = (MTemplateParameter)i.next();
          print(el, true, "Foundation.Core.TemplateParameter");
        }
        dh.endElement("Foundation.Core.ModelElement.templateParameter2");
      }
    }
    {
      Iterator i = arg.getElementImports2().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.elementImport", al);
        while(i.hasNext())
        {
          MElementImport el = (MElementImport)i.next();
          print(el, true, "Model_Management.ElementImport");
        }
        dh.endElement("Foundation.Core.ModelElement.elementImport");
      }
    }
    {
      Iterator i = arg.getConstrainedElements().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.Constraint.constrainedElement", al);
        while(i.hasNext())
        {
          MModelElement el = (MModelElement)i.next();
          print(el, true, "Foundation.Core.ModelElement");
        }
        dh.endElement("Foundation.Core.Constraint.constrainedElement");
      }
    }
    if (null != arg.getConstrainedStereotype())
    {
      dh.startElement("Foundation.Core.Constraint.constrainedStereotype", al);
      print(arg.getConstrainedStereotype(), true, "Foundation.Extension_Mechanisms.Stereotype");
      dh.endElement("Foundation.Core.Constraint.constrainedStereotype");
    }
    {
      Iterator i = arg.getContextPropertyTags().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.Constraint.contextPropertyTag", al);
        while(i.hasNext())
        {
          print(i.next(), true, "CoCons.Uml.Ccl.ContextPropertyTag");
        }
        dh.endElement("Foundation.Core.Constraint.contextPropertyTag");
      }
    }
    {
      Iterator i = arg.getTemplateParameters().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.templateParameter", al);
        while(i.hasNext())
        {
          MTemplateParameter el = (MTemplateParameter)i.next();
          print(el, false, "Foundation.Core.TemplateParameter");
        }
        dh.endElement("Foundation.Core.ModelElement.templateParameter");
      }
    }
    {
      Iterator i = arg.getTaggedValues().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.taggedValue", al);
        while(i.hasNext())
        {
          MTaggedValue el = (MTaggedValue)i.next();
          print(el, false, "Foundation.Extension_Mechanisms.TaggedValue");
        }
        dh.endElement("Foundation.Core.ModelElement.taggedValue");
      }
    }
    {
      Iterator i = arg.getReferenceTags().iterator();
      if (i.hasNext())
      {
        dh.startElement("Foundation.Core.ModelElement.referenceTag", al);
        while(i.hasNext())
        {
          MTaggedValue el = (MTaggedValue)i.next();
          print(el, true, "Foundation.Extension_Mechanisms.TaggedValue");
        }
        dh.endElement("Foundation.Core.ModelElement.referenceTag");
      }
    }
    dh.endElement("CoCons.Uml.Ccl.ContextbasedConstraint");
  }

  public void preprocessIDs(MBase arg, boolean processed)
  {
    if (null == arg)
    {
      return;
    }
    if (!processed)
    {
      if (arg instanceof MContextPropertyTag)
      {
        MContextPropertyTag arg2 = (MContextPropertyTag)arg;
        {
          Iterator i = arg2.getTemplateParameters().iterator();
          while(i.hasNext())
          {
            preprocessIDs((MBase)i.next(), false);
          }
        }
        {
          Iterator i = arg2.getTaggedValues().iterator();
          while(i.hasNext())
          {
            preprocessIDs((MBase)i.next(), false);
          }
        }
      }
      else if (arg instanceof MContextbasedConstraint)
      {
        MContextbasedConstraint arg2 = (MContextbasedConstraint)arg;
        {
          Iterator i = arg2.getTemplateParameters().iterator();
          while(i.hasNext())
          {
            preprocessIDs((MBase)i.next(), false);
          }
        }
        {
          Iterator i = arg2.getTaggedValues().iterator();
          while(i.hasNext())
          {
            preprocessIDs((MBase)i.next(), false);
          }
        }
        preprocessIDs(arg2.getScopeSet(), false);
        preprocessIDs(arg2.getConstrainedSet(), false);
      }
      else
      {
        super.preprocessIDs(arg, false);
        return;
      }
    }
    super.preprocessIDs(arg, true);
  }
}
