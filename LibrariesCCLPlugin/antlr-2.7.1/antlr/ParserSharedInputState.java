package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: ParserSharedInputState.java,v 1.1 2003/07/12 18:49:15 layekers Exp $
 */

/** This object contains the data associated with an
 *  input stream of tokens.  Multiple parsers
 *  share a single ParserSharedInputState to parse
 *  the same stream of tokens.
 */
public class ParserSharedInputState {
    /** Where to get token objects */
    protected TokenBuffer input;

    /** Are we guessing (guessing>0)? */
    public int guessing = 0;

    /** What file (if known) caused the problem? */
    protected String filename;
}
