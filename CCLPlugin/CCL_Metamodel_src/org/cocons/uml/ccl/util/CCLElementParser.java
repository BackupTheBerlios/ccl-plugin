package org.cocons.uml.ccl.util;
// $ANTLR 2.7.2: "elementselection.g" -> "CCLElementParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;
/**
 *@author modified by Camara Lenuseni, layekers@cs.tu-berlin.de 24.5.03  
 */
public class CCLElementParser extends antlr.LLkParser       implements CCLElementParserTokenTypes
 {

protected CCLElementParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public CCLElementParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);  
}   

protected CCLElementParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public CCLElementParser(TokenStream lexer) {
  this(lexer,1);
}

public CCLElementParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void targetset_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST targetset_statement_AST = null;

		try {      // for error handling
			elementselection();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_AMONG:
			{
				AST tmp1_AST = null;
				tmp1_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp1_AST);
				match(LITERAL_AMONG);
				AST tmp2_AST = null;
				tmp2_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp2_AST);
				match(LITERAL_WHOM);
				AST tmp3_AST = null;
				tmp3_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp3_AST);
				match(LITERAL_AT);
				AST tmp4_AST = null;
				tmp4_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp4_AST);
				match(LITERAL_LEAST);
				elementselection();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_EXIST:
				{
					AST tmp5_AST = null;
					tmp5_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp5_AST);
					match(LITERAL_EXIST);
					break;
				}
				case LITERAL_EXISTS:
				{
					AST tmp6_AST = null;
					tmp6_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp6_AST);
					match(LITERAL_EXISTS);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			case EOF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				targetset_statement_AST = (AST)currentAST.root;
				targetset_statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TARGETSET,"TargetSet")).add(targetset_statement_AST));
				currentAST.root = targetset_statement_AST;
				currentAST.child = targetset_statement_AST!=null &&targetset_statement_AST.getFirstChild()!=null ?
					targetset_statement_AST.getFirstChild() : targetset_statement_AST;
				currentAST.advanceChildToEnd();
			}
			targetset_statement_AST = (AST)currentAST.root;
		}
		catch (Error /*RecognitionException */ ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = targetset_statement_AST;
	}

	public final void elementselection() throws RecognitionException, TokenStreamException 
	{
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementselection_AST = null;

		
		 try {      // for error handling
			{
			
			switch ( LA(1)) 
			{
			case ALL:
			case Number:
			{
				indirect();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_THE:
			case LITERAL_THIS:
			{
				direct();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			_loop9:
			do {
				switch ( LA(1)) 
				{
				case OR:
				{
					AST tmp7_AST = null;
					tmp7_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp7_AST);
					match(OR);
					{
					switch ( LA(1)) {
					case ALL:
					case Number:
					{
						indirect();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case LITERAL_THE:
					case LITERAL_THIS:
					{
						direct();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				case AND:
				{
					AST tmp8_AST = null;
					tmp8_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp8_AST);
					match(AND);
					{
					switch ( LA(1)) {
					case ALL:
					case Number:
					{
						indirect();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					case LITERAL_THE:
					case LITERAL_THIS:
					{
						direct();
						astFactory.addASTChild(currentAST, returnAST);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				default:
				{
					break _loop9;
				}
				}
			} while (true);
			}
			elementselection_AST = (AST)currentAST.root;
		}
		
		
		 catch (Error /*RecognitionException*/ ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_1);
			} else {
			  throw ex;
			}
		}		
		returnAST = elementselection_AST;
	}

	public final void indirect() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST indirect_AST = null;

		try {      // for error handling
			range_statement();
			astFactory.addASTChild(currentAST, returnAST);
			restrictions_statement();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_WHERE:
			{
				where_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case AND:
			case LITERAL_AMONG:
			case LITERAL_EXIST:
			case LITERAL_EXISTS:
			case OR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			indirect_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = indirect_AST;
	}

	public final void direct() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST direct_AST = null;

		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_THE:
			{
				AST tmp9_AST = null;
				tmp9_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp9_AST);
				match(LITERAL_THE);
				restriction_statement();
				astFactory.addASTChild(currentAST, returnAST);
				element();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_THIS:
			{
				AST tmp10_AST = null;
				tmp10_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp10_AST);
				match(LITERAL_THIS);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			direct_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = direct_AST;
	}

	public final void scopeset_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST scopeset_statement_AST = null;

		try {      // for error handling
			elementselection();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_AMONG:
			{
				AST tmp11_AST = null;
				tmp11_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp11_AST);
				match(LITERAL_AMONG);
				AST tmp12_AST = null;
				tmp12_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp12_AST);
				match(LITERAL_WHOM);
				AST tmp13_AST = null;
				tmp13_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp13_AST);
				match(LITERAL_AT);
				AST tmp14_AST = null;
				tmp14_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp14_AST);
				match(LITERAL_LEAST);
				elementselection();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_EXIST:
				{
					AST tmp15_AST = null;
					tmp15_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp15_AST);
					match(LITERAL_EXIST);
					break;
				}
				case LITERAL_EXISTS:
				{
					AST tmp16_AST = null;
					tmp16_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp16_AST);
					match(LITERAL_EXISTS);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			case EOF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				scopeset_statement_AST = (AST)currentAST.root;
				scopeset_statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SCOPESET,"ScopeSet")).add(scopeset_statement_AST));
				currentAST.root = scopeset_statement_AST;
				currentAST.child = scopeset_statement_AST!=null &&scopeset_statement_AST.getFirstChild()!=null ?
					scopeset_statement_AST.getFirstChild() : scopeset_statement_AST;
				currentAST.advanceChildToEnd();
			}
			scopeset_statement_AST = (AST)currentAST.root;
		}
		catch (Error /*RecognitionException */ ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = scopeset_statement_AST;
	}

	public final void range_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST range_statement_AST = null;

		try {      // for error handling
			{
			switch ( LA(1)) {
			case ALL:
			{
				AST tmp17_AST = null;
				tmp17_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp17_AST);
				match(ALL);
				break;
			}
			case Number:
			{
				AST tmp18_AST = null;
				tmp18_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp18_AST);
				match(Number);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			range_statement_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = range_statement_AST;
	}

	public final void restrictions_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST restrictions_statement_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case ELEMENTS:
			{
				AST tmp19_AST = null;
				tmp19_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp19_AST);
				match(ELEMENTS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case COMPONENTS:
			{
				AST tmp20_AST = null;
				tmp20_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp20_AST);
				match(COMPONENTS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case CONTAINERS:
			{
				AST tmp21_AST = null;
				tmp21_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp21_AST);
				match(CONTAINERS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case COMPUTERS:
			{
				AST tmp22_AST = null;
				tmp22_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp22_AST);
				match(COMPUTERS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case USERS:
			{
				AST tmp23_AST = null;
				tmp23_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp23_AST);
				match(USERS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case INTERFACES:
			{
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp24_AST);
				match(INTERFACES);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_4);
			} else {
			  throw ex;
			}
		}
		returnAST = restrictions_statement_AST;
	}

	public final void where_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST where_statement_AST = null;

		try {      // for error handling
			AST tmp25_AST = null;
			tmp25_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp25_AST);
			match(LITERAL_WHERE);
			contextcondition_comand();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				where_statement_AST = (AST)currentAST.root;
				where_statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(WHERE,"Condition")).add(where_statement_AST));
				currentAST.root = where_statement_AST;
				currentAST.child = where_statement_AST!=null &&where_statement_AST.getFirstChild()!=null ?
					where_statement_AST.getFirstChild() : where_statement_AST;
				currentAST.advanceChildToEnd();
			}
			where_statement_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = where_statement_AST;
	}

	public final void restriction_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST restriction_statement_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case ELEMENT:
			{
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(ELEMENT);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case COMPONENT:
			{
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp27_AST);
				match(COMPONENT);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case CONTAINER:
			{
				AST tmp28_AST = null;
				tmp28_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp28_AST);
				match(CONTAINER);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case COMPUTER:
			{
				AST tmp29_AST = null;
				tmp29_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp29_AST);
				match(COMPUTER);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case USER:
			{
				AST tmp30_AST = null;
				tmp30_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp30_AST);
				match(USER);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case INTERFACE:
			{
				AST tmp31_AST = null;
				tmp31_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp31_AST);
				match(INTERFACE);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_5);
			} else {
			  throw ex;
			}
		}
		returnAST = restriction_statement_AST;
	}

	public final void element() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST element_AST = null;

		try {      // for error handling
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(QUOTED);
			{
			int _cnt69=0;
			_loop69:
			do {
				if ((LA(1)==ALPHA)) {
					AST tmp33_AST = null;
					tmp33_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp33_AST);
					match(ALPHA);
				}
				else {
					if ( _cnt69>=1 ) { break _loop69; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt69++;
			} while (true);
			}
			AST tmp34_AST = null;
			tmp34_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp34_AST);
			match(QUOTED);
			element_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_2);
			} else {
			  throw ex;
			}
		}
		returnAST = element_AST;
	}

	public final void logic_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logic_statement_AST = null;

		try {      // for error handling
			{
			switch ( LA(1)) {
			case OR:
			{
				AST tmp35_AST = null;
				tmp35_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp35_AST);
				match(OR);
				break;
			}
			case AND:
			{
				AST tmp36_AST = null;
				tmp36_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp36_AST);
				match(AND);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			logic_statement_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_6);
			} else {
			  throw ex;
			}
		}
		returnAST = logic_statement_AST;
	}

	public final void contextcondition_comand() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contextcondition_comand_AST = null;

		try {      // for error handling
			contextcondition_statement();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop26:
			do {
				if ((LA(1)==AND||LA(1)==OR)) {
					logic_statement();
					astFactory.addASTChild(currentAST, returnAST);
					contextcondition_statement();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop26;
				}

			} while (true);
			}
			if ( inputState.guessing==0 ) {
				contextcondition_comand_AST = (AST)currentAST.root;
				contextcondition_comand_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGIC,"Logic")).add(contextcondition_comand_AST));
				currentAST.root = contextcondition_comand_AST;
				currentAST.child = contextcondition_comand_AST!=null &&contextcondition_comand_AST.getFirstChild()!=null ?
					contextcondition_comand_AST.getFirstChild() : contextcondition_comand_AST;
				currentAST.advanceChildToEnd();
			}
			contextcondition_comand_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = contextcondition_comand_AST;
	}

	public final void contextcondition_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contextcondition_statement_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case OPEN_PAREN:
			{
				AST tmp37_AST = null;
				tmp37_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp37_AST);
				match(OPEN_PAREN);
				contextcondition_comand();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp38_AST = null;
				tmp38_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp38_AST);
				match(CLOSE_PAREN);
				contextcondition_statement_AST = (AST)currentAST.root;
				break;
			}
			case QUOTED:
			{
				contextcondition_statements();
				astFactory.addASTChild(currentAST, returnAST);
				contextcondition_statement_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = contextcondition_statement_AST;
	}

	public final void contextcondition_statements() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contextcondition_statements_AST = null;

		try {      // for error handling
			if ((LA(1)==QUOTED)) {
				comparetwosets_statement();
				astFactory.addASTChild(currentAST, returnAST);
				contextcondition_statements_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==QUOTED)) {
				singleset_statement();
				astFactory.addASTChild(currentAST, returnAST);
				contextcondition_statements_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = contextcondition_statements_AST;
	}

	public final void comparetwosets_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST comparetwosets_statement_AST = null;

		try {      // for error handling
			AST tmp39_AST = null;
			tmp39_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp39_AST);
			match(QUOTED);
			{
			int _cnt36=0;
			_loop36:
			do {
				if ((LA(1)==ALPHA)) {
					AST tmp40_AST = null;
					tmp40_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp40_AST);
					match(ALPHA);
				}
				else {
					if ( _cnt36>=1 ) { break _loop36; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt36++;
			} while (true);
			}
			AST tmp41_AST = null;
			tmp41_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp41_AST);
			match(QUOTED);
			comparecondition();
			astFactory.addASTChild(currentAST, returnAST);
			setofconpropval_statement();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				comparetwosets_statement_AST = (AST)currentAST.root;
				comparetwosets_statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONTEXTCONDITION,"ContextCondition")).add(comparetwosets_statement_AST));
				currentAST.root = comparetwosets_statement_AST;
				currentAST.child = comparetwosets_statement_AST!=null &&comparetwosets_statement_AST.getFirstChild()!=null ?
					comparetwosets_statement_AST.getFirstChild() : comparetwosets_statement_AST;
				currentAST.advanceChildToEnd();
			}
			comparetwosets_statement_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = comparetwosets_statement_AST;
	}

	public final void singleset_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST singleset_statement_AST = null;

		try {      // for error handling
			contextpropertyvalue();
			astFactory.addASTChild(currentAST, returnAST);
			empty_expression();
			astFactory.addASTChild(currentAST, returnAST);
			singleset_statement_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = singleset_statement_AST;
	}

	public final void contextpropertyname() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contextpropertyname_AST = null;

		try {      // for error handling
			AST tmp42_AST = null;
			tmp42_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp42_AST);
			match(QUOTED);
			{
			int _cnt33=0;
			_loop33:
			do {
				if ((LA(1)==ALPHA)) {
					AST tmp43_AST = null;
					tmp43_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp43_AST);
					match(ALPHA);
				}
				else {
					if ( _cnt33>=1 ) { break _loop33; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt33++;
			} while (true);
			}
			AST tmp44_AST = null;
			tmp44_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp44_AST);
			match(QUOTED);
			contextpropertyname_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = contextpropertyname_AST;
	}

	public final void comparecondition() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST comparecondition_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case CONTAINS:
			{
				contains();
				astFactory.addASTChild(currentAST, returnAST);
				comparecondition_AST = (AST)currentAST.root;
				break;
			}
			case EQUALS:
			{
				equals();
				astFactory.addASTChild(currentAST, returnAST);
				comparecondition_AST = (AST)currentAST.root;
				break;
			}
			case INTERSECTS:
			{
				intersectswith();
				astFactory.addASTChild(currentAST, returnAST);
				comparecondition_AST = (AST)currentAST.root;
				break;
			}
			case EQUAL:
			{
				equal();
				astFactory.addASTChild(currentAST, returnAST);
				comparecondition_AST = (AST)currentAST.root;
				break;
			}
			case NOT_EQUAL:
			{
				AST tmp45_AST = null;
				tmp45_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp45_AST);
				match(NOT_EQUAL);
				if ( inputState.guessing==0 ) {
					comparecondition_AST = (AST)currentAST.root;
					comparecondition_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE,"CompareCondition")).add(comparecondition_AST));
					currentAST.root = comparecondition_AST;
					currentAST.child = comparecondition_AST!=null &&comparecondition_AST.getFirstChild()!=null ?
						comparecondition_AST.getFirstChild() : comparecondition_AST;
					currentAST.advanceChildToEnd();
				}
				comparecondition_AST = (AST)currentAST.root;
				break;
			}
			default:
				if ((LA(1)==DOES)) {
					doesnotcontain();
					astFactory.addASTChild(currentAST, returnAST);
					comparecondition_AST = (AST)currentAST.root;
				}
				else if ((LA(1)==DOES)) {
					doesnotequal();
					astFactory.addASTChild(currentAST, returnAST);
					comparecondition_AST = (AST)currentAST.root;
				}
				else if ((LA(1)==DOES)) {
					notintersectswith();
					astFactory.addASTChild(currentAST, returnAST);
					comparecondition_AST = (AST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = comparecondition_AST;
	}

	public final void setofconpropval_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST setofconpropval_statement_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case QUOTED:
			{
				contextpropertyvalue();
				astFactory.addASTChild(currentAST, returnAST);
				setofconpropval_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_BOTH:
			{
				{
				AST tmp46_AST = null;
				tmp46_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp46_AST);
				match(LITERAL_BOTH);
				cp_command_and();
				astFactory.addASTChild(currentAST, returnAST);
				}
				setofconpropval_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_EITHER:
			{
				{
				AST tmp47_AST = null;
				tmp47_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp47_AST);
				match(LITERAL_EITHER);
				cp_command_or();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_BUT:
				{
					AST tmp48_AST = null;
					tmp48_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp48_AST);
					match(LITERAL_BUT);
					AST tmp49_AST = null;
					tmp49_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp49_AST);
					match(NOT);
					AST tmp50_AST = null;
					tmp50_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp50_AST);
					match(LITERAL_A);
					AST tmp51_AST = null;
					tmp51_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp51_AST);
					match(LITERAL_COMBINATION);
					AST tmp52_AST = null;
					tmp52_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp52_AST);
					match(LITERAL_OF);
					AST tmp53_AST = null;
					tmp53_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp53_AST);
					match(LITERAL_THEM);
					break;
				}
				case EOF:
				case AND:
				case LITERAL_AMONG:
				case LITERAL_EXIST:
				case LITERAL_EXISTS:
				case OR:
				case CLOSE_PAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
				setofconpropval_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_EXACTLY:
			{
				{
				AST tmp54_AST = null;
				tmp54_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp54_AST);
				match(LITERAL_EXACTLY);
				AST tmp55_AST = null;
				tmp55_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp55_AST);
				match(LITERAL_THE);
				AST tmp56_AST = null;
				tmp56_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp56_AST);
				match(LITERAL_SAME);
				AST tmp57_AST = null;
				tmp57_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp57_AST);
				match(LITERAL_VALUES);
				AST tmp58_AST = null;
				tmp58_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp58_AST);
				match(LITERAL_AS);
				contextpropertyname();
				astFactory.addASTChild(currentAST, returnAST);
				}
				setofconpropval_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_AT:
			{
				{
				AST tmp59_AST = null;
				tmp59_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp59_AST);
				match(LITERAL_AT);
				AST tmp60_AST = null;
				tmp60_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp60_AST);
				match(LITERAL_LEAST);
				AST tmp61_AST = null;
				tmp61_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp61_AST);
				match(LITERAL_ONE);
				AST tmp62_AST = null;
				tmp62_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp62_AST);
				match(LITERAL_VALUE);
				AST tmp63_AST = null;
				tmp63_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp63_AST);
				match(LITERAL_OF);
				contextpropertyname();
				astFactory.addASTChild(currentAST, returnAST);
				}
				setofconpropval_statement_AST = (AST)currentAST.root;
				break;
			}
			case ONLY:
			{
				{
				AST tmp64_AST = null;
				tmp64_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp64_AST);
				match(ONLY);
				AST tmp65_AST = null;
				tmp65_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp65_AST);
				match(LITERAL_ONE);
				AST tmp66_AST = null;
				tmp66_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp66_AST);
				match(LITERAL_VALUE);
				AST tmp67_AST = null;
				tmp67_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp67_AST);
				match(LITERAL_OF);
				contextpropertyname();
				astFactory.addASTChild(currentAST, returnAST);
				}
				setofconpropval_statement_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = setofconpropval_statement_AST;
	}

	public final void contextpropertyvalue() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contextpropertyvalue_AST = null;

		try {      // for error handling
			AST tmp68_AST = null;
			tmp68_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp68_AST);
			match(QUOTED);
			{
			switch ( LA(1)) {
			case ALPHA:
			{
				{
				int _cnt64=0;
				_loop64:
				do {
					if ((LA(1)==ALPHA)) {
						AST tmp69_AST = null;
						tmp69_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp69_AST);
						match(ALPHA);
					}
					else {
						if ( _cnt64>=1 ) { break _loop64; } else {throw new NoViableAltException(LT(1), getFilename());}
					}

					_cnt64++;
				} while (true);
				}
				break;
			}
			case Number:
			{
				{
				int _cnt66=0;
				_loop66:
				do {
					if ((LA(1)==Number)) {
						AST tmp70_AST = null;
						tmp70_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp70_AST);
						match(Number);
					}
					else {
						if ( _cnt66>=1 ) { break _loop66; } else {throw new NoViableAltException(LT(1), getFilename());}
					}

					_cnt66++;
				} while (true);
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp71_AST = null;
			tmp71_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp71_AST);
			match(QUOTED);
			contextpropertyvalue_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = contextpropertyvalue_AST;
	}

	public final void empty_expression() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST empty_expression_AST = null;

		try {      // for error handling
			{
			if ((LA(1)==IS)) {
				AST tmp72_AST = null;
				tmp72_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp72_AST);
				match(IS);
				AST tmp73_AST = null;
				tmp73_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp73_AST);
				match(EMPTY);
			}
			else if ((LA(1)==IS)) {
				AST tmp74_AST = null;
				tmp74_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp74_AST);
				match(IS);
				AST tmp75_AST = null;
				tmp75_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp75_AST);
				match(NOT);
				AST tmp76_AST = null;
				tmp76_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp76_AST);
				match(EMPTY);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}

			}
			empty_expression_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = empty_expression_AST;
	}

	public final void contains() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contains_AST = null;

		try {      // for error handling
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp77_AST);
			match(CONTAINS);
			if ( inputState.guessing==0 ) {
				contains_AST = (AST)currentAST.root;
				contains_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE,"CompareCondition")).add(contains_AST));
				currentAST.root = contains_AST;
				currentAST.child = contains_AST!=null &&contains_AST.getFirstChild()!=null ?
					contains_AST.getFirstChild() : contains_AST;
				currentAST.advanceChildToEnd();
			}
			contains_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = contains_AST;
	}

	public final void doesnotcontain() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST doesnotcontain_AST = null;

		try {      // for error handling
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(DOES);
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
			match(NOT);
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp80_AST);
			match(CONTAIN);
			if ( inputState.guessing==0 ) {
				doesnotcontain_AST = (AST)currentAST.root;
				doesnotcontain_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE,"CompareCondition")).add(doesnotcontain_AST));
				currentAST.root = doesnotcontain_AST;
				currentAST.child = doesnotcontain_AST!=null &&doesnotcontain_AST.getFirstChild()!=null ?
					doesnotcontain_AST.getFirstChild() : doesnotcontain_AST;
				currentAST.advanceChildToEnd();
			}
			doesnotcontain_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = doesnotcontain_AST;
	}

	public final void equals() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equals_AST = null;

		try {      // for error handling
			AST tmp81_AST = null;
			tmp81_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp81_AST);
			match(EQUALS);
			if ( inputState.guessing==0 ) {
				equals_AST = (AST)currentAST.root;
				equals_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE,"CompareCondition")).add(equals_AST));
				currentAST.root = equals_AST;
				currentAST.child = equals_AST!=null &&equals_AST.getFirstChild()!=null ?
					equals_AST.getFirstChild() : equals_AST;
				currentAST.advanceChildToEnd();
			}
			equals_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = equals_AST;
	}

	public final void doesnotequal() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST doesnotequal_AST = null;

		try {      // for error handling
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp82_AST);
			match(DOES);
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp83_AST);
			match(NOT);
			AST tmp84_AST = null;
			tmp84_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp84_AST);
			match(EQUAL_STRING);
			if ( inputState.guessing==0 ) {
				doesnotequal_AST = (AST)currentAST.root;
				doesnotequal_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE,"CompareCondition")).add(doesnotequal_AST));
				currentAST.root = doesnotequal_AST;
				currentAST.child = doesnotequal_AST!=null &&doesnotequal_AST.getFirstChild()!=null ?
					doesnotequal_AST.getFirstChild() : doesnotequal_AST;
				currentAST.advanceChildToEnd();
			}
			doesnotequal_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = doesnotequal_AST;
	}

	public final void intersectswith() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST intersectswith_AST = null;

		try {      // for error handling
			AST tmp85_AST = null;
			tmp85_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp85_AST);
			match(INTERSECTS);
			AST tmp86_AST = null;
			tmp86_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp86_AST);
			match(WITH);
			if ( inputState.guessing==0 ) {
				intersectswith_AST = (AST)currentAST.root;
				intersectswith_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE,"CompareCondition")).add(intersectswith_AST));
				currentAST.root = intersectswith_AST;
				currentAST.child = intersectswith_AST!=null &&intersectswith_AST.getFirstChild()!=null ?
					intersectswith_AST.getFirstChild() : intersectswith_AST;
				currentAST.advanceChildToEnd();
			}
			intersectswith_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = intersectswith_AST;
	}

	public final void notintersectswith() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST notintersectswith_AST = null;

		try {      // for error handling
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp87_AST);
			match(DOES);
			AST tmp88_AST = null;
			tmp88_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp88_AST);
			match(NOT);
			AST tmp89_AST = null;
			tmp89_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp89_AST);
			match(INTTERSETS);
			AST tmp90_AST = null;
			tmp90_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp90_AST);
			match(WITH);
			if ( inputState.guessing==0 ) {
				notintersectswith_AST = (AST)currentAST.root;
				notintersectswith_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE,"CompareCondition")).add(notintersectswith_AST));
				currentAST.root = notintersectswith_AST;
				currentAST.child = notintersectswith_AST!=null &&notintersectswith_AST.getFirstChild()!=null ?
					notintersectswith_AST.getFirstChild() : notintersectswith_AST;
				currentAST.advanceChildToEnd();
			}
			notintersectswith_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = notintersectswith_AST;
	}

	public final void equal() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equal_AST = null;

		try {      // for error handling
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp91_AST);
			match(EQUAL);
			if ( inputState.guessing==0 ) {
				equal_AST = (AST)currentAST.root;
				equal_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE,"CompareCondition")).add(equal_AST));
				currentAST.root = equal_AST;
				currentAST.child = equal_AST!=null &&equal_AST.getFirstChild()!=null ?
					equal_AST.getFirstChild() : equal_AST;
				currentAST.advanceChildToEnd();
			}
			equal_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = equal_AST;
	}

	public final void cp_command_and() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cp_command_and_AST = null;

		try {      // for error handling
			contextpropertyvalue();
			astFactory.addASTChild(currentAST, returnAST);
			{
			int _cnt57=0;
			_loop57:
			do {
				if ((LA(1)==AND)) {
					AST tmp92_AST = null;
					tmp92_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp92_AST);
					match(AND);
					contextpropertyvalue();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt57>=1 ) { break _loop57; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt57++;
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				cp_command_and_AST = (AST)currentAST.root;
				cp_command_and_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL,"Logical")).add(cp_command_and_AST));
				currentAST.root = cp_command_and_AST;
				currentAST.child = cp_command_and_AST!=null &&cp_command_and_AST.getFirstChild()!=null ?
					cp_command_and_AST.getFirstChild() : cp_command_and_AST;
				currentAST.advanceChildToEnd();
			}
			cp_command_and_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = cp_command_and_AST;
	}

	public final void cp_command_or() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cp_command_or_AST = null;

		try {      // for error handling
			contextpropertyvalue();
			astFactory.addASTChild(currentAST, returnAST);
			{
			int _cnt60=0;
			_loop60:
			do {
				if ((LA(1)==OR)) {
					AST tmp93_AST = null;
					tmp93_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp93_AST);
					match(OR);
					contextpropertyvalue();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt60>=1 ) { break _loop60; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt60++;
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				cp_command_or_AST = (AST)currentAST.root;
				cp_command_or_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL,"Logical")).add(cp_command_or_AST));
				currentAST.root = cp_command_or_AST;
				currentAST.child = cp_command_or_AST!=null &&cp_command_or_AST.getFirstChild()!=null ?
					cp_command_or_AST.getFirstChild() : cp_command_or_AST;
				currentAST.advanceChildToEnd();
			}
			cp_command_or_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_10);
			} else {
			  throw ex;
			}
		}
		returnAST = cp_command_or_AST;
	}

	public final void type_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_statement_AST = null;

		try {      // for error handling
			{
			switch ( LA(1)) {
			case NOT:
			{
				AST tmp94_AST = null;
				tmp94_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp94_AST);
				match(NOT);
				break;
			}
			case ONLY:
			{
				AST tmp95_AST = null;
				tmp95_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp95_AST);
				match(ONLY);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				type_statement_AST = (AST)currentAST.root;
				type_statement_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPECONDITION,"TypeCondition")).add(type_statement_AST));
				currentAST.root = type_statement_AST;
				currentAST.child = type_statement_AST!=null &&type_statement_AST.getFirstChild()!=null ?
					type_statement_AST.getFirstChild() : type_statement_AST;
				currentAST.advanceChildToEnd();
			}
			type_statement_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = type_statement_AST;
	}

	public final void cocontype_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cocontype_statement_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_ACCESSIBLE:
			{
				AST tmp96_AST = null;
				tmp96_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp96_AST);
				match(LITERAL_ACCESSIBLE);
				AST tmp97_AST = null;
				tmp97_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp97_AST);
				match(LITERAL_TO);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_READABLE:
			{
				AST tmp98_AST = null;
				tmp98_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp98_AST);
				match(LITERAL_READABLE);
				AST tmp99_AST = null;
				tmp99_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp99_AST);
				match(LITERAL_BY);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_WRITEABLE:
			{
				AST tmp100_AST = null;
				tmp100_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp100_AST);
				match(LITERAL_WRITEABLE);
				AST tmp101_AST = null;
				tmp101_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp101_AST);
				match(LITERAL_BY);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_EXECUTEABLE:
			{
				AST tmp102_AST = null;
				tmp102_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp102_AST);
				match(LITERAL_EXECUTEABLE);
				AST tmp103_AST = null;
				tmp103_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp103_AST);
				match(LITERAL_BY);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_REMOVEABLE:
			{
				AST tmp104_AST = null;
				tmp104_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp104_AST);
				match(LITERAL_REMOVEABLE);
				AST tmp105_AST = null;
				tmp105_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp105_AST);
				match(LITERAL_BY);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ALLOCATED:
			{
				AST tmp106_AST = null;
				tmp106_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp106_AST);
				match(LITERAL_ALLOCATED);
				AST tmp107_AST = null;
				tmp107_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp107_AST);
				match(LITERAL_TO);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_SYNCHONOUSLY:
			{
				AST tmp108_AST = null;
				tmp108_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp108_AST);
				match(LITERAL_SYNCHONOUSLY);
				AST tmp109_AST = null;
				tmp109_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp109_AST);
				match(LITERAL_REPLICATED);
				AST tmp110_AST = null;
				tmp110_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp110_AST);
				match(LITERAL_TO);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ASYNCHONOUSLY:
			{
				AST tmp111_AST = null;
				tmp111_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp111_AST);
				match(LITERAL_ASYNCHONOUSLY);
				AST tmp112_AST = null;
				tmp112_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp112_AST);
				match(LITERAL_REPLICATED);
				AST tmp113_AST = null;
				tmp113_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp113_AST);
				match(LITERAL_TO);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_THE:
			{
				AST tmp114_AST = null;
				tmp114_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp114_AST);
				match(LITERAL_THE);
				AST tmp115_AST = null;
				tmp115_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp115_AST);
				match(LITERAL_SAME);
				AST tmp116_AST = null;
				tmp116_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp116_AST);
				match(LITERAL_AS);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_FULFILLING:
			{
				AST tmp117_AST = null;
				tmp117_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp117_AST);
				match(LITERAL_FULFILLING);
				AST tmp118_AST = null;
				tmp118_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp118_AST);
				match(LITERAL_THE);
				AST tmp119_AST = null;
				tmp119_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp119_AST);
				match(LITERAL_CONTEXT);
				AST tmp120_AST = null;
				tmp120_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp120_AST);
				match(LITERAL_CONDITION);
				AST tmp121_AST = null;
				tmp121_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp121_AST);
				match(LITERAL_OF);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ENCRYPTED:
			{
				AST tmp122_AST = null;
				tmp122_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp122_AST);
				match(LITERAL_ENCRYPTED);
				AST tmp123_AST = null;
				tmp123_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp123_AST);
				match(LITERAL_WHEN);
				AST tmp124_AST = null;
				tmp124_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp124_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ERRORHANDLED:
			{
				AST tmp125_AST = null;
				tmp125_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp125_AST);
				match(LITERAL_ERRORHANDLED);
				AST tmp126_AST = null;
				tmp126_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp126_AST);
				match(LITERAL_WHEN);
				AST tmp127_AST = null;
				tmp127_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp127_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_LOGGED:
			{
				AST tmp128_AST = null;
				tmp128_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp128_AST);
				match(LITERAL_LOGGED);
				AST tmp129_AST = null;
				tmp129_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp129_AST);
				match(LITERAL_WHEN);
				AST tmp130_AST = null;
				tmp130_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp130_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_REDIRECTED:
			{
				AST tmp131_AST = null;
				tmp131_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp131_AST);
				match(LITERAL_REDIRECTED);
				AST tmp132_AST = null;
				tmp132_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp132_AST);
				match(LITERAL_WHEN);
				AST tmp133_AST = null;
				tmp133_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp133_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_PROTECTED:
			{
				AST tmp134_AST = null;
				tmp134_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp134_AST);
				match(LITERAL_PROTECTED);
				AST tmp135_AST = null;
				tmp135_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp135_AST);
				match(LITERAL_BY);
				AST tmp136_AST = null;
				tmp136_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp136_AST);
				match(LITERAL_A);
				AST tmp137_AST = null;
				tmp137_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp137_AST);
				match(LITERAL_TRANSACTION);
				AST tmp138_AST = null;
				tmp138_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp138_AST);
				match(LITERAL_WHEN);
				AST tmp139_AST = null;
				tmp139_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp139_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ASYNCHRONOUSLY:
			{
				AST tmp140_AST = null;
				tmp140_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp140_AST);
				match(LITERAL_ASYNCHRONOUSLY);
				AST tmp141_AST = null;
				tmp141_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp141_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_SYNCHRONOUSLY:
			{
				AST tmp142_AST = null;
				tmp142_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp142_AST);
				match(LITERAL_SYNCHRONOUSLY);
				AST tmp143_AST = null;
				tmp143_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp143_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_HANDLED:
			{
				AST tmp144_AST = null;
				tmp144_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp144_AST);
				match(LITERAL_HANDLED);
				AST tmp145_AST = null;
				tmp145_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp145_AST);
				match(LITERAL_WHEN);
				AST tmp146_AST = null;
				tmp146_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp146_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_INFORMED:
			{
				AST tmp147_AST = null;
				tmp147_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp147_AST);
				match(LITERAL_INFORMED);
				AST tmp148_AST = null;
				tmp148_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp148_AST);
				match(LITERAL_OF);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_AS:
			{
				AST tmp149_AST = null;
				tmp149_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp149_AST);
				match(LITERAL_AS);
				AST tmp150_AST = null;
				tmp150_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp150_AST);
				match(LITERAL_INTERESTING);
				AST tmp151_AST = null;
				tmp151_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp151_AST);
				match(LITERAL_AS);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_AVAILABLE:
			{
				AST tmp152_AST = null;
				tmp152_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp152_AST);
				match(LITERAL_AVAILABLE);
				AST tmp153_AST = null;
				tmp153_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp153_AST);
				match(LITERAL_TO);
				AST tmp154_AST = null;
				tmp154_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp154_AST);
				match(LITERAL_ANYONE);
				AST tmp155_AST = null;
				tmp155_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp155_AST);
				match(LITERAL_INTERESTED);
				AST tmp156_AST = null;
				tmp156_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp156_AST);
				match(LITERAL_IN);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = cocontype_statement_AST;
	}

	public final void attribute_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_statement_AST = null;

		try {      // for error handling
			attributename();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp157_AST = null;
			tmp157_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp157_AST);
			match(EQUAL);
			attributevalues();
			astFactory.addASTChild(currentAST, returnAST);
			attribute_statement_AST = (AST)currentAST.root;
		}
		catch (Error /*RecognitionException*/ ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = attribute_statement_AST;
	}

	public final void attributename() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attributename_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_ACTION:
			{
				AST tmp158_AST = null;
				tmp158_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp158_AST);
				match(LITERAL_ACTION);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case 106:
			{
				AST tmp159_AST = null;
				tmp159_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp159_AST);
				match(106);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_COCONNAME:
			{
				AST tmp160_AST = null;
				tmp160_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp160_AST);
				match(LITERAL_COCONNAME);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_COCONAUTHOR:
			{
				AST tmp161_AST = null;
				tmp161_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp161_AST);
				match(LITERAL_COCONAUTHOR);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_COMMENT:
			{
				AST tmp162_AST = null;
				tmp162_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp162_AST);
				match(LITERAL_COMMENT);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_PRIORITY:
			{
				AST tmp163_AST = null;
				tmp163_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp163_AST);
				match(LITERAL_PRIORITY);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportErrorError(ex);
				consume();
				consumeUntil(_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = attributename_AST;
	}

	public final void attributevalues() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attributevalues_AST = null;

		try {      // for error handling
			AST tmp164_AST = null;
			tmp164_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp164_AST);
			match(QUOTED);
			{
			int _cnt77=0;
			_loop77:
			do {
				if ((LA(1)==ALPHA)) {
					AST tmp165_AST = null;
					tmp165_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp165_AST);
					match(ALPHA);
				}
				else {
					if ( _cnt77>=1 ) { break _loop77; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt77++;
			} while (true);
			}
			AST tmp166_AST = null;
			tmp166_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp166_AST);
			match(QUOTED);
			{
			_loop79:
			do {
				if ((LA(1)==COMMA)) {
					AST tmp167_AST = null;
					tmp167_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp167_AST);
					match(COMMA);
					attributevalues();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop79;
				}

			} while (true);
			}
			attributevalues_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		returnAST = attributevalues_AST;
	}

	public final void keyword() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST keyword_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_MUST:
			{
				AST tmp168_AST = null;
				tmp168_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp168_AST);
				match(LITERAL_MUST);
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_BE:
			{
				AST tmp169_AST = null;
				tmp169_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp169_AST);
				match(LITERAL_BE);
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_THE:
			{
				AST tmp170_AST = null;
				tmp170_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp170_AST);
				match(LITERAL_THE);
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_WHERE:
			{
				AST tmp171_AST = null;
				tmp171_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp171_AST);
				match(LITERAL_WHERE);
				keyword_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = keyword_AST;
	}


	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"CCL_STATEMENT",
		"TARGETSET",
		"SCOPESET",
		"TYPECONDITION",
		"WHERE",
		"CONTEXTCONDITION",
		"COMPARE",
		"CCL_IDENTIFIER",
		"LOGIC",
		"LOGICAL",
		"RANGE",
		"SEMI",
		"\"MUST\"",
		"\"BE\"",
		"\"WITH\"",
		"\"AND\"",
		"\"AMONG\"",
		"\"WHOM\"",
		"\"AT\"",
		"\"LEAST\"",
		"\"EXIST\"",
		"\"EXISTS\"",
		"\"OR\"",
		"\"THE\"",
		"\"THIS\"",
		"\"ALL\"",
		"Number",
		"\"ELEMENTS\"",
		"\"COMPONENTS\"",
		"\"CONTAINERS\"",
		"\"COMPUTERS\"",
		"\"USERS\"",
		"\"INTERFACES\"",
		"\"ELEMENT\"",
		"\"COMPONENT\"",
		"\"CONTAINER\"",
		"\"COMPUTER\"",
		"\"USER\"",
		"\"INTERFACE\"",
		"\"WHERE\"",
		"OPEN_PAREN",
		"CLOSE_PAREN",
		"QUOTED",
		"ALPHA",
		"\"IS\"",
		"\"EMPTY\"",
		"\"NOT\"",
		"NOT_EQUAL",
		"\"CONTAINS\"",
		"\"DOES\"",
		"\"CONTAIN\"",
		"\"EQUALS\"",
		"EQUAL",
		"\"EQUAL\"",
		"\"INTERSECTS\"",
		"INTTERSETS",
		"\"BOTH\"",
		"\"EITHER\"",
		"\"BUT\"",
		"\"A\"",
		"\"COMBINATION\"",
		"\"OF\"",
		"\"THEM\"",
		"\"EXACTLY\"",
		"\"SAME\"",
		"\"VALUES\"",
		"\"AS\"",
		"\"ONE\"",
		"\"VALUE\"",
		"\"ONLY\"",
		"\"ACCESSIBLE\"",
		"\"TO\"",
		"\"READABLE\"",
		"\"BY\"",
		"\"WRITEABLE\"",
		"\"EXECUTEABLE\"",
		"\"REMOVEABLE\"",
		"\"ALLOCATED\"",
		"\"SYNCHONOUSLY\"",
		"\"REPLICATED\"",
		"\"ASYNCHONOUSLY\"",
		"\"FULFILLING\"",
		"\"CONTEXT\"",
		"\"CONDITION\"",
		"\"ENCRYPTED\"",
		"\"WHEN\"",
		"\"CALLING\"",
		"\"ERRORHANDLED\"",
		"\"LOGGED\"",
		"\"REDIRECTED\"",
		"\"PROTECTED\"",
		"\"TRANSACTION\"",
		"\"ASYNCHRONOUSLY\"",
		"\"SYNCHRONOUSLY\"",
		"\"HANDLED\"",
		"\"INFORMED\"",
		"\"INTERESTING\"",
		"\"AVAILABLE\"",
		"\"ANYONE\"",
		"\"INTERESTED\"",
		"\"IN\"",
		"\"ACTION\"",
		"\"ELSE-ACTION\"",
		"\"COCONNAME\"",
		"\"COCONAUTHOR\"",
		"\"COMMENT\"",
		"\"PRIORITY\"",
		"COMMA",
		"NOT_EQ",
		"GT",
		"WS"
	};

	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};

	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 51380226L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 119013378L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 135291469824L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 8796212035586L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 70368744177664L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 87960930222080L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 35184491102210L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 3458834882568912896L, 520L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 4612002677895200770L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 4611721202918490114L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 72057594037927936L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 2L, 140737488355328L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());

	}
