package org.cocons.uml.ccl.xml;

import java.lang.String;

import java.util.Vector;
import java.util.Iterator;
import java.util.Collection;

import java.io.*;

import javax.swing.JOptionPane;

import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.ccldata.*;
import org.exolab.castor.xml.*;
import org.apache.xml.serialize.XMLSerializer;
import org.apache.xml.serialize.OutputFormat;



public class CoConXMLReader
{

	public static CoConXMLReader SINGLETON = new CoConXMLReader();

	public CoConXMLReader()
	{}


	public CoConList readString( String input )
		throws Exception
	{
		StringReader sr = new StringReader(input);
		return readReader( sr );
	}

	public CoConList readFile( String fileName )
		throws Exception
	{
		FileReader fr = new FileReader( fileName );
		return readReader( fr );
	}


	public CoConList readReader( Reader r )
		throws Exception
	{
		Unmarshaller unmarshaller = new Unmarshaller( Class.forName("org.cocons.uml.ccl.ccldata.CoConList"));
		return (CoConList)unmarshaller.unmarshal( r );
	}


}

