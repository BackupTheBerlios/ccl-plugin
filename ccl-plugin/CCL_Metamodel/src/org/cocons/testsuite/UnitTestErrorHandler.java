package org.cocons.testsuite;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class UnitTestErrorHandler extends DefaultHandler {

  public UnitTestErrorHandler() {
  }

  public void error(SAXParseException ex)
    throws SAXParseException {
      throw ex;
   }

}