package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: TokenStreamRecognitionException.java,v 1.1 2003/07/12 18:38:19 layekers Exp $
 */

/**
 * Wraps a RecognitionException in a TokenStreamException so you
 * can pass it along.
 */
public class TokenStreamRecognitionException extends TokenStreamException {
    public RecognitionException recog;
    public TokenStreamRecognitionException(RecognitionException re) {
	super(re.getMessage());
	this.recog = re;
    }
}
