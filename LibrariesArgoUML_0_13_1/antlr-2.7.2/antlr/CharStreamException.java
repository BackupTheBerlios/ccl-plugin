package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: CharStreamException.java,v 1.1 2003/07/12 18:39:46 layekers Exp $
 */

/**
 * Anything that goes wrong while generating a stream of characters
 */
public class CharStreamException extends ANTLRException {
    /**
     * CharStreamException constructor comment.
     * @param s java.lang.String
     */
    public CharStreamException(String s) {
        super(s);
    }
}
