package org.argouml.util.plugin;

/**
 * This custom class loader simply loads compiled class files.
 *
 * @see PluginClassFile
 *
 * @author Martin Skinner <mailto:mskinner@cs.tu-berlin.de>
 * @version 1.0
 */

import java.io.*;
import java.util.*;
import java.util.jar.*;

class FileClassLoader extends ClassLoader {

  File _sourceDir;

  public FileClassLoader(File sourceDir) {
    _sourceDir = sourceDir;
  }

  protected Class findClass(String className)
    throws ClassNotFoundException {

    byte classData[];

    // try to load it from the class file
    classData = getClassDataFromFile(className);
    if (classData == null) {
      throw new ClassNotFoundException();
    }
    // parse it
    return defineClass(className, classData, 0, classData.length);
  }

  private byte[] getClassDataFromFile(String classname) {

    File classfile = new File(_sourceDir, classname.replace('.', File.separatorChar )+ ".class");

    try {
      System.out.println("loading " + classfile);
      InputStream is = new FileInputStream(classfile);
      ByteArrayOutputStream out = new ByteArrayOutputStream();

      int c = is.read();
      while (c != -1) {
        out.write(c);
        c = is.read();
      }
      return out.toByteArray();
    }
    catch (IOException e) {
      System.out.println("Error opening " + classfile + " : " + e.getLocalizedMessage());
      return null;
    }
  }

}