package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: TokenStreamException.java,v 1.1 2003/07/12 18:49:17 layekers Exp $
 */

/**
 * Anything that goes wrong while generating a stream of tokens.
 */
public class TokenStreamException extends ANTLRException {
	public TokenStreamException() {
	}
public TokenStreamException(String s) {
	super(s);
}
}
