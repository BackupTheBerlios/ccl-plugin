package org.cocons.uml.ccl.xml;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class CoConXMLFileFilters
	extends FileFilter
{

	////////////////////////////////////////////////////////////
	// Static Constants

	public static String ANY_XML_SUFFIX        = "xml";
	public static String ANY_XML_DESCRIPTION   = "XML files (*."+ANY_XML_SUFFIX+")";

	public static String COCON_XML_SUFFIX      = "cclxml";
	public static String COCON_XML_DESCRIPTION = "CoCon-XML files (*."+COCON_XML_SUFFIX+")";

	public static CoConXMLFileFilters ANY_XML_FILTER =
		new CoConXMLFileFilters( ANY_XML_SUFFIX,
										 ANY_XML_DESCRIPTION );

	public static CoConXMLFileFilters COCON_XML_FILTER =
		new CoConXMLFileFilters( COCON_XML_SUFFIX,
										 COCON_XML_DESCRIPTION );



	////////////////////////////////////////////////////////////
	// Attributes

	private String _suffix;
	private String _description;



	////////////////////////////////////////////////////////////
	// Constructor

	public CoConXMLFileFilters( String suffix,
										 String description )
	{
		_suffix      = suffix;
		_description = description;
	}

	////////////////////////////////////////////////////////////
	// FileFilter interface

	public boolean accept(File f)
	{
		if (f.isDirectory()) {
			return true;
		}
		String extension = getExtension(f);

		if (extension != null)
			return _suffix.equals(extension);
		else
			return false;
	}

	public String getDescription()
	{ 
		return _description;
	}


	protected String getExtension( File f )
	{
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 &&  i < s.length() - 1)
			ext = s.substring(i+1).toLowerCase();

		return ext;
	}


}
