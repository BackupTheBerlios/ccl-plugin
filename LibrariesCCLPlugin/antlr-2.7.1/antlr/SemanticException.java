package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: SemanticException.java,v 1.1 2003/07/12 18:49:16 layekers Exp $
 */

public class SemanticException extends RecognitionException {
    public SemanticException(String s) {
	super(s);
    }
    public SemanticException(String s, String fileName, int line) {
	super(s, fileName, line);
    }
}
