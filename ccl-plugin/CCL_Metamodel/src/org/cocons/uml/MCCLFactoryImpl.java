package org.cocons.uml;

import ru.novosoft.uml.*;
import org.cocons.uml.ccl.*;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class MCCLFactoryImpl extends MFactoryImpl {

  protected static MCCLFactoryImpl singleton = new MCCLFactoryImpl();

  public static MFactory getFactory()
  {
    singleton = new MCCLFactoryImpl();
    return singleton;
  }

  public final MContextPropertyTag createContextPropertyTag()
  {
    return new MContextPropertyTagImpl();
  }
  public final MContextbasedConstraint createContextbasedConstraint()
  {
    return new MContextbasedConstraintImpl();
  }
}