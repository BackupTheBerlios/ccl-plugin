// $Id: ClassifierNotFoundException.java,v 1.1 2003/07/12 18:28:41 layekers Exp $

package org.argouml.uml.reveng.java;

/**
   This is thrown when a classifier can not be located in the model or
   via the classpath.
*/
class ClassifierNotFoundException extends Exception
{
    public ClassifierNotFoundException(String name)
    {
	super("classifier not found: " + name);
    }
}
	
