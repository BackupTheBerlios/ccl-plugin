package ru.novosoft.uml.foundation.extension_mechanisms;

import java.util.*;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

import org.cocons.uml.*;

/**
 * Interface to a UML 1.4 TagDefinition metaclass.
 * Includes support for a subset of the UML 1.4 specifications as well as the
 * CCL specifications.
 * @author Martin Skinner
 * @version 1.0
 */
public interface MTagDefinition extends MModelElement {

  /**
   * Gets the value of the attribute TagType.
   *
   * @return current value of the TagType attribute
   */
  String getTagType();
  /**
   * Sets the value of the attribute TagType.
   *
   * @param __arg value to set the TagType to.
   */
  void setTagType(String _arg);
  /**
   * Gets the value of the attribute Multiplicity.
   *
   * @return current value of the Multiplicity attribute
   */
  MMultiplicity getMultiplicity();
  /**
   * Sets the value of the attribute Multiplicity.
   *
   * @param __arg value to set the Multiplicity to. May be one of the
   *              predefined Multiplicity constants.
   * @see MMultiplicity
   */
  void setMultiplicity(MMultiplicity _arg);

  /**
   * Gets all the links of the association type(TagDefinition)
   * / typedValue(TaggedValue).
   *
   * @return unmodifyable copy of the current TypedValues collection
   */
  Collection getTypedValues();
  /**
   * Sets all the links of the association type(TagDefinition)
   * / typedValue(TaggedValue).
   *
   * @param __arg new collection of TypedValues or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setTypedValues(Collection __arg);
  /**
   * Adds a link to the association type(TagDefinition)
   * / typedValue(TaggedValue).
   *
   * @param __arg TypedValue to be linked to this instance
   */
  void addTypedValue(MTaggedValue __arg);
  /**
   * Removes a link from the association type(TagDefinition)
   * / typedValue(TaggedValue).
   *
   * @param __arg TypedValue to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeTypedValue(MTaggedValue __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg TypedValue to be referenced
   */
  void internalRefByTypedValue(MTaggedValue __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg DefinedTag to be unreferenced
   */
  void internalUnrefByTypedValue(MTaggedValue __arg);

  /**
   * Gets the link of the association owner(Stereotype)
   * / definedTag(TagDefinition).
   *
   * @return current owner of the instance
   */
  MStereotype getOwner();
  /**
   * Sets the link of the association owner(Stereotype)
   * / definedTag(TagDefinition).
   *
   * @param __arg new owner of the instance
   */
  void setOwner(MStereotype __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg Owner to be referenced
   */
  void internalRefByOwner(MStereotype __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg Owner to be unreferenced
   */
  void internalUnrefByOwner(MStereotype __arg);

}