package org.argouml.util.plugin;

/**
 * This custom class loader extracts classes from a java archive (JAR).
 *
 * @see PluginJarFile
 *
 * @author Martin Skinner <mailto:mskinner@cs.tu-berlin.de>
 * @version 1.0
 */

import java.io.*;
import java.util.*;
import java.util.jar.*;

class JarClassLoader extends ClassLoader {

  JarFile _jarFile;

  public JarClassLoader(JarFile jarFile) {
    _jarFile = jarFile;
  }

  protected Class findClass(String className)
    throws ClassNotFoundException {

    byte classData[];

    // try to load it from the JarFile
    classData = getClassDataFromJar(className);
    if (classData == null) {
      throw new ClassNotFoundException();
    }

    // parse it
    return defineClass(className, classData, 0, classData.length);
  }

  private byte[] getClassDataFromJar(String classname) {

    InputStream is;
    String filename = classname.replace('.', '/')+ ".class";

    try {
      Object o = _jarFile.entries();
      JarEntry jarEntry = _jarFile.getJarEntry(filename);
      is = _jarFile.getInputStream(jarEntry) ;
    }
    catch (IOException e)  {
     return null;
    }

    BufferedInputStream bis = new BufferedInputStream(is);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try {
      int c = bis.read();
      while (c != -1) {
        out.write(c);
        c = bis.read();
      }
    }
    catch (IOException e) {
      return null;
    }

    return out.toByteArray();
  }

}