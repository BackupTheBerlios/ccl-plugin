package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: TokenStream.java,v 1.1 2003/07/12 18:38:19 layekers Exp $
 */

public interface TokenStream {
	public Token nextToken() throws TokenStreamException;
}
