package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: DefaultFileLineFormatter.java,v 1.1 2003/07/12 18:49:30 layekers Exp $
 */

public class DefaultFileLineFormatter extends FileLineFormatter {
    public String getFormatString(String fileName, int line) {
	if ( fileName != null ) {
	    return fileName+":"+line+": ";
	}
	else {
	    return "line "+line+": ";
	}
    }
};
