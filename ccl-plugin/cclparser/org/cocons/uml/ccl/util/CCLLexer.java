package org.cocons.uml.ccl.util;
// $ANTLR 2.7.2: "ccl.g" -> "CCLLexer.java"$

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class CCLLexer extends antlr.CharScanner implements CCLTokenTypes, TokenStream
 {
public CCLLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public CCLLexer(Reader in) {
	this(new CharBuffer(in));
}
public CCLLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public CCLLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(true);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("VALUE", this), new Integer(72));
	literals.put(new ANTLRHashString("CONTAIN", this), new Integer(54));
	literals.put(new ANTLRHashString("LEAST", this), new Integer(23));
	literals.put(new ANTLRHashString("AT", this), new Integer(22));
	literals.put(new ANTLRHashString("EQUAL", this), new Integer(57));
	literals.put(new ANTLRHashString("CONTAINS", this), new Integer(52));
	literals.put(new ANTLRHashString("PROTECTED", this), new Integer(94));
	literals.put(new ANTLRHashString("USERS", this), new Integer(35));
	literals.put(new ANTLRHashString("CONTAINER", this), new Integer(39));
	literals.put(new ANTLRHashString("INTERESTED", this), new Integer(103));
	literals.put(new ANTLRHashString("REMOVEABLE", this), new Integer(80));
	literals.put(new ANTLRHashString("THE", this), new Integer(27));
	literals.put(new ANTLRHashString("COMMENT", this), new Integer(109));
	literals.put(new ANTLRHashString("EXACTLY", this), new Integer(67));
	literals.put(new ANTLRHashString("BY", this), new Integer(77));
	literals.put(new ANTLRHashString("ACCESSIBLE", this), new Integer(74));
	literals.put(new ANTLRHashString("AS", this), new Integer(70));
	literals.put(new ANTLRHashString("ELEMENTS", this), new Integer(31));
	literals.put(new ANTLRHashString("A", this), new Integer(63));
	literals.put(new ANTLRHashString("PRIORITY", this), new Integer(110));
	literals.put(new ANTLRHashString("TO", this), new Integer(75));
	literals.put(new ANTLRHashString("INTERFACE", this), new Integer(42));
	literals.put(new ANTLRHashString("CONDITION", this), new Integer(87));
	literals.put(new ANTLRHashString("EITHER", this), new Integer(61));
	literals.put(new ANTLRHashString("FULFILLING", this), new Integer(85));
	literals.put(new ANTLRHashString("REDIRECTED", this), new Integer(93));
	literals.put(new ANTLRHashString("NOT", this), new Integer(50));
	literals.put(new ANTLRHashString("WITH", this), new Integer(18));
	literals.put(new ANTLRHashString("READABLE", this), new Integer(76));
	literals.put(new ANTLRHashString("COCONNAME", this), new Integer(107));
	literals.put(new ANTLRHashString("ALL", this), new Integer(29));
	literals.put(new ANTLRHashString("EXISTS", this), new Integer(25));
	literals.put(new ANTLRHashString("EXECUTEABLE", this), new Integer(79));
	literals.put(new ANTLRHashString("ELEMENT", this), new Integer(37));
	literals.put(new ANTLRHashString("WRITEABLE", this), new Integer(78));
	literals.put(new ANTLRHashString("BE", this), new Integer(17));
	literals.put(new ANTLRHashString("ELSE-ACTION", this), new Integer(106));
	literals.put(new ANTLRHashString("THIS", this), new Integer(28));
	literals.put(new ANTLRHashString("BOTH", this), new Integer(60));
	literals.put(new ANTLRHashString("ONLY", this), new Integer(73));
	literals.put(new ANTLRHashString("ACTION", this), new Integer(105));
	literals.put(new ANTLRHashString("INTERSECTS", this), new Integer(58));
	literals.put(new ANTLRHashString("COMPUTER", this), new Integer(40));
	literals.put(new ANTLRHashString("SYNCHRONOUSLY", this), new Integer(97));
	literals.put(new ANTLRHashString("THEM", this), new Integer(66));
	literals.put(new ANTLRHashString("AMONG", this), new Integer(20));
	literals.put(new ANTLRHashString("EXIST", this), new Integer(24));
	literals.put(new ANTLRHashString("COMPUTERS", this), new Integer(34));
	literals.put(new ANTLRHashString("SAME", this), new Integer(68));
	literals.put(new ANTLRHashString("AND", this), new Integer(19));
	literals.put(new ANTLRHashString("COMPONENTS", this), new Integer(32));
	literals.put(new ANTLRHashString("MUST", this), new Integer(16));
	literals.put(new ANTLRHashString("ERRORHANDLED", this), new Integer(91));
	literals.put(new ANTLRHashString("INFORMED", this), new Integer(99));
	literals.put(new ANTLRHashString("WHOM", this), new Integer(21));
	literals.put(new ANTLRHashString("ASYNCHRONOUSLY", this), new Integer(96));
	literals.put(new ANTLRHashString("CONTEXT", this), new Integer(86));
	literals.put(new ANTLRHashString("LOGGED", this), new Integer(92));
	literals.put(new ANTLRHashString("ENCRYPTED", this), new Integer(88));
	literals.put(new ANTLRHashString("VALUES", this), new Integer(69));
	literals.put(new ANTLRHashString("COMPONENT", this), new Integer(38));
	literals.put(new ANTLRHashString("IN", this), new Integer(104));
	literals.put(new ANTLRHashString("CONTAINERS", this), new Integer(33));
	literals.put(new ANTLRHashString("WHERE", this), new Integer(43));
	literals.put(new ANTLRHashString("DOES", this), new Integer(53));
	literals.put(new ANTLRHashString("TRANSACTION", this), new Integer(95));
	literals.put(new ANTLRHashString("EQUALS", this), new Integer(55));
	literals.put(new ANTLRHashString("INTERFACES", this), new Integer(36));
	literals.put(new ANTLRHashString("WHEN", this), new Integer(89));
	literals.put(new ANTLRHashString("ASYNCHONOUSLY", this), new Integer(84));
	literals.put(new ANTLRHashString("ONE", this), new Integer(71));
	literals.put(new ANTLRHashString("USER", this), new Integer(41));
	literals.put(new ANTLRHashString("BUT", this), new Integer(62));
	literals.put(new ANTLRHashString("OF", this), new Integer(65));
	literals.put(new ANTLRHashString("ALLOCATED", this), new Integer(81));
	literals.put(new ANTLRHashString("OR", this), new Integer(26));
	literals.put(new ANTLRHashString("ANYONE", this), new Integer(102));
	literals.put(new ANTLRHashString("CALLING", this), new Integer(90));
	literals.put(new ANTLRHashString("HANDLED", this), new Integer(98));
	literals.put(new ANTLRHashString("IS", this), new Integer(48));
	literals.put(new ANTLRHashString("COCONAUTHOR", this), new Integer(108));
	literals.put(new ANTLRHashString("COMBINATION", this), new Integer(64));
	literals.put(new ANTLRHashString("AVAILABLE", this), new Integer(101));
	literals.put(new ANTLRHashString("INTERESTING", this), new Integer(100));
	literals.put(new ANTLRHashString("EMPTY", this), new Integer(49));
	literals.put(new ANTLRHashString("REPLICATED", this), new Integer(83));
	literals.put(new ANTLRHashString("SYNCHONOUSLY", this), new Integer(82));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':  case '_':  case 'a':
				case 'b':  case 'c':  case 'd':  case 'e':
				case 'f':  case 'g':  case 'h':  case 'i':
				case 'j':  case 'k':  case 'l':  case 'm':
				case 'n':  case 'o':  case 'p':  case 'q':
				case 'r':  case 's':  case 't':  case 'u':
				case 'v':  case 'w':  case 'x':  case 'y':
				case 'z':
				{
					mALPHA(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case '\'':
				{
					mQUOTED(true);
					theRetToken=_returnToken;
					break;
				}
				case '=':
				{
					mEQUAL(true);
					theRetToken=_returnToken;
					break;
				}
				case '(':
				{
					mOPEN_PAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mCLOSE_PAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mWS(true);
					theRetToken=_returnToken;
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mNumber(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='<'||LA(1)=='>')) {
						mNOT_EQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<')) {
						mNOT_EQ(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>')) {
						mGT(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mALPHA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ALPHA;
		int _saveIndex;

		{
		int _cnt95=0;
		_loop95:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			default:
			{
				if ( _cnt95>=1 ) { break _loop95; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt95++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;

		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mQUOTED(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUOTED;
		int _saveIndex;

		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mEQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUAL;
		int _saveIndex;

		match('=');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mOPEN_PAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OPEN_PAREN;
		int _saveIndex;

		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mCLOSE_PAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CLOSE_PAREN;
		int _saveIndex;

		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;

		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mNOT_EQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT_EQUAL;
		int _saveIndex;

		switch ( LA(1)) {
		case '<':
		{
			mNOT_EQ(false);
			break;
		}
		case '>':
		{
			mGT(false);
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mNOT_EQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT_EQ;
		int _saveIndex;

		match('<');
		{
		switch ( LA(1)) {
		case '>':
		{
			{
			match('>');
			}
			break;
		}
		case '=':
		{
			{
			match('=');
			}
			break;
		}
		default:
			{
			}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mGT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GT;
		int _saveIndex;

		match('>');
		{
		if ((LA(1)=='=')) {
			match('=');
		}
		else {
		}

		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;

		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		case '\r':
		{
			match('\r');
			match('\n');
			newline();
			break;
		}
		case '\n':
		{
			match('\n');
			newline();
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		_ttype = Token.SKIP;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mNumber(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Number;
		int _saveIndex;

		matchRange('0','9');
		{
		_loop113:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				break _loop113;
			}

		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}



	}
