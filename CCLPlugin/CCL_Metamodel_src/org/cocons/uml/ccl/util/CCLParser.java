package org.cocons.uml.ccl.util;
// $ANTLR 2.7.2: "ccl.g" -> "CCLParser.java"$

/**
 * @author modified by Camara Lenuseni, layekers@cs.tu-berlin.de 24.5.03
 */
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

public class CCLParser extends antlr.LLkParser  implements CCLTokenTypes
 {

protected CCLParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public CCLParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected CCLParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public CCLParser(TokenStream lexer) {
  this(lexer,1);
}

public CCLParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void start_rule() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST start_rule_AST = null;

		try {      // for error handling
			{
			int _cnt3=0;
			_loop3:
			do {
				if (((LA(1) >= LITERAL_THE && LA(1) <= Number))) {
					ccl_cocon();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt3>=1 ) { break _loop3; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt3++;
			} while (true);
			}
			AST tmp1_AST = null;
			tmp1_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp1_AST);
			match(Token.EOF_TYPE);
			start_rule_AST = (AST)currentAST.root;
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
		returnAST = start_rule_AST;
	}

	public final void ccl_cocon() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ccl_cocon_AST = null;

		try {      // for error handling
			cocon_command();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case SEMI:
			{
				AST tmp2_AST = null;
				tmp2_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp2_AST);
				match(SEMI);
				break;
			}
			case EOF:
			case LITERAL_THE:
			case LITERAL_THIS:
			case ALL:
			case Number:
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
				ccl_cocon_AST = (AST)currentAST.root;
				ccl_cocon_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CCL_STATEMENT,"ccl_cocon")).add(ccl_cocon_AST));
				currentAST.root = ccl_cocon_AST;
				currentAST.child = ccl_cocon_AST!=null &&ccl_cocon_AST.getFirstChild()!=null ?
					ccl_cocon_AST.getFirstChild() : ccl_cocon_AST;
				currentAST.advanceChildToEnd();
			}
			ccl_cocon_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_1);
			} else {
			  throw ex;
			}
		}
		returnAST = ccl_cocon_AST;
	}

	public final void cocon_command() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cocon_command_AST = null;

		try {      // for error handling
			targetset_statement();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp3_AST = null;
			tmp3_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp3_AST);
			match(LITERAL_MUST);
			{
			switch ( LA(1)) {
			case NOT:
			case ONLY:
			{
				type_statement();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_BE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp4_AST = null;
			tmp4_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp4_AST);
			match(LITERAL_BE);
			cocontype_statement();
			astFactory.addASTChild(currentAST, returnAST);
			scopeset_statement();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case WITH:
			{
				AST tmp5_AST = null;
				tmp5_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp5_AST);
				match(WITH);
				{
				int _cnt10=0;
				_loop10:
				do {
					if (((LA(1) >= LITERAL_ACTION && LA(1) <= LITERAL_PRIORITY))) {
						attribute_statement();
						astFactory.addASTChild(currentAST, returnAST);
					}
					else {
						if ( _cnt10>=1 ) { break _loop10; } else {throw new NoViableAltException(LT(1), getFilename());}
					}

					_cnt10++;
				} while (true);
				}
				{
				_loop12:
				do {
					if ((LA(1)==AND)) {
						AST tmp6_AST = null;
						tmp6_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp6_AST);
						match(AND);
					}
					else {
						break _loop12;
					}

				} while (true);
				}
				break;
			}
			case EOF:
			case SEMI:
			case LITERAL_THE:
			case LITERAL_THIS:
			case ALL:
			case Number:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cocon_command_AST = (AST)currentAST.root;
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
		returnAST = cocon_command_AST;
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
				AST tmp7_AST = null;
				tmp7_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp7_AST);
				match(LITERAL_AMONG);
				AST tmp8_AST = null;
				tmp8_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp8_AST);
				match(LITERAL_WHOM);
				AST tmp9_AST = null;
				tmp9_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp9_AST);
				match(LITERAL_AT);
				AST tmp10_AST = null;
				tmp10_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp10_AST);
				match(LITERAL_LEAST);
				elementselection();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_EXIST:
				{
					AST tmp11_AST = null;
					tmp11_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp11_AST);
					match(LITERAL_EXIST);
					break;
				}
				case LITERAL_EXISTS:
				{
					AST tmp12_AST = null;
					tmp12_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp12_AST);
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
			case LITERAL_MUST:
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
		catch (Error /*RecognitionException*/ ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = targetset_statement_AST;
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
				AST tmp13_AST = null;
				tmp13_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp13_AST);
				match(NOT);
				break;
			}
			case ONLY:
			{
				AST tmp14_AST = null;
				tmp14_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp14_AST);
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
				consumeUntil(_tokenSet_4);
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
				AST tmp15_AST = null;
				tmp15_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp15_AST);
				match(LITERAL_ACCESSIBLE);
				AST tmp16_AST = null;
				tmp16_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp16_AST);
				match(LITERAL_TO);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_READABLE:
			{
				AST tmp17_AST = null;
				tmp17_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp17_AST);
				match(LITERAL_READABLE);
				AST tmp18_AST = null;
				tmp18_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp18_AST);
				match(LITERAL_BY);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_WRITEABLE:
			{
				AST tmp19_AST = null;
				tmp19_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp19_AST);
				match(LITERAL_WRITEABLE);
				AST tmp20_AST = null;
				tmp20_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp20_AST);
				match(LITERAL_BY);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_EXECUTEABLE:
			{
				AST tmp21_AST = null;
				tmp21_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp21_AST);
				match(LITERAL_EXECUTEABLE);
				AST tmp22_AST = null;
				tmp22_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp22_AST);
				match(LITERAL_BY);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_REMOVEABLE:
			{
				AST tmp23_AST = null;
				tmp23_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp23_AST);
				match(LITERAL_REMOVEABLE);
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp24_AST);
				match(LITERAL_BY);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ALLOCATED:
			{
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(LITERAL_ALLOCATED);
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(LITERAL_TO);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_SYNCHONOUSLY:
			{
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp27_AST);
				match(LITERAL_SYNCHONOUSLY);
				AST tmp28_AST = null;
				tmp28_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp28_AST);
				match(LITERAL_REPLICATED);
				AST tmp29_AST = null;
				tmp29_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp29_AST);
				match(LITERAL_TO);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ASYNCHONOUSLY:
			{
				AST tmp30_AST = null;
				tmp30_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp30_AST);
				match(LITERAL_ASYNCHONOUSLY);
				AST tmp31_AST = null;
				tmp31_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp31_AST);
				match(LITERAL_REPLICATED);
				AST tmp32_AST = null;
				tmp32_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp32_AST);
				match(LITERAL_TO);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_THE:
			{
				AST tmp33_AST = null;
				tmp33_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp33_AST);
				match(LITERAL_THE);
				AST tmp34_AST = null;
				tmp34_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp34_AST);
				match(LITERAL_SAME);
				AST tmp35_AST = null;
				tmp35_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp35_AST);
				match(LITERAL_AS);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_FULFILLING:
			{
				AST tmp36_AST = null;
				tmp36_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp36_AST);
				match(LITERAL_FULFILLING);
				AST tmp37_AST = null;
				tmp37_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp37_AST);
				match(LITERAL_THE);
				AST tmp38_AST = null;
				tmp38_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp38_AST);
				match(LITERAL_CONTEXT);
				AST tmp39_AST = null;
				tmp39_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp39_AST);
				match(LITERAL_CONDITION);
				AST tmp40_AST = null;
				tmp40_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp40_AST);
				match(LITERAL_OF);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ENCRYPTED:
			{
				AST tmp41_AST = null;
				tmp41_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp41_AST);
				match(LITERAL_ENCRYPTED);
				AST tmp42_AST = null;
				tmp42_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp42_AST);
				match(LITERAL_WHEN);
				AST tmp43_AST = null;
				tmp43_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp43_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ERRORHANDLED:
			{
				AST tmp44_AST = null;
				tmp44_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp44_AST);
				match(LITERAL_ERRORHANDLED);
				AST tmp45_AST = null;
				tmp45_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp45_AST);
				match(LITERAL_WHEN);
				AST tmp46_AST = null;
				tmp46_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp46_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_LOGGED:
			{
				AST tmp47_AST = null;
				tmp47_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp47_AST);
				match(LITERAL_LOGGED);
				AST tmp48_AST = null;
				tmp48_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp48_AST);
				match(LITERAL_WHEN);
				AST tmp49_AST = null;
				tmp49_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp49_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_REDIRECTED:
			{
				AST tmp50_AST = null;
				tmp50_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp50_AST);
				match(LITERAL_REDIRECTED);
				AST tmp51_AST = null;
				tmp51_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp51_AST);
				match(LITERAL_WHEN);
				AST tmp52_AST = null;
				tmp52_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp52_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_PROTECTED:
			{
				AST tmp53_AST = null;
				tmp53_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp53_AST);
				match(LITERAL_PROTECTED);
				AST tmp54_AST = null;
				tmp54_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp54_AST);
				match(LITERAL_BY);
				AST tmp55_AST = null;
				tmp55_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp55_AST);
				match(LITERAL_A);
				AST tmp56_AST = null;
				tmp56_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp56_AST);
				match(LITERAL_TRANSACTION);
				AST tmp57_AST = null;
				tmp57_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp57_AST);
				match(LITERAL_WHEN);
				AST tmp58_AST = null;
				tmp58_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp58_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_ASYNCHRONOUSLY:
			{
				AST tmp59_AST = null;
				tmp59_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp59_AST);
				match(LITERAL_ASYNCHRONOUSLY);
				AST tmp60_AST = null;
				tmp60_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp60_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_SYNCHRONOUSLY:
			{
				AST tmp61_AST = null;
				tmp61_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp61_AST);
				match(LITERAL_SYNCHRONOUSLY);
				AST tmp62_AST = null;
				tmp62_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp62_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_HANDLED:
			{
				AST tmp63_AST = null;
				tmp63_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp63_AST);
				match(LITERAL_HANDLED);
				AST tmp64_AST = null;
				tmp64_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp64_AST);
				match(LITERAL_WHEN);
				AST tmp65_AST = null;
				tmp65_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp65_AST);
				match(LITERAL_CALLING);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_INFORMED:
			{
				AST tmp66_AST = null;
				tmp66_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp66_AST);
				match(LITERAL_INFORMED);
				AST tmp67_AST = null;
				tmp67_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp67_AST);
				match(LITERAL_OF);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_AS:
			{
				AST tmp68_AST = null;
				tmp68_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp68_AST);
				match(LITERAL_AS);
				AST tmp69_AST = null;
				tmp69_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp69_AST);
				match(LITERAL_INTERESTING);
				AST tmp70_AST = null;
				tmp70_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp70_AST);
				match(LITERAL_AS);
				cocontype_statement_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_AVAILABLE:
			{
				AST tmp71_AST = null;
				tmp71_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp71_AST);
				match(LITERAL_AVAILABLE);
				AST tmp72_AST = null;
				tmp72_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp72_AST);
				match(LITERAL_TO);
				AST tmp73_AST = null;
				tmp73_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp73_AST);
				match(LITERAL_ANYONE);
				AST tmp74_AST = null;
				tmp74_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp74_AST);
				match(LITERAL_INTERESTED);
				AST tmp75_AST = null;
				tmp75_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp75_AST);
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
				consumeUntil(_tokenSet_5);
			} else {
			  throw ex;
			}
		}
		returnAST = cocontype_statement_AST;
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
				AST tmp76_AST = null;
				tmp76_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp76_AST);
				match(LITERAL_AMONG);
				AST tmp77_AST = null;
				tmp77_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp77_AST);
				match(LITERAL_WHOM);
				AST tmp78_AST = null;
				tmp78_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp78_AST);
				match(LITERAL_AT);
				AST tmp79_AST = null;
				tmp79_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp79_AST);
				match(LITERAL_LEAST);
				elementselection();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_EXIST:
				{
					AST tmp80_AST = null;
					tmp80_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp80_AST);
					match(LITERAL_EXIST);
					break;
				}
				case LITERAL_EXISTS:
				{
					AST tmp81_AST = null;
					tmp81_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp81_AST);
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
			case SEMI:
			case WITH:
			case LITERAL_THE:
			case LITERAL_THIS:
			case ALL:
			case Number:
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
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_6);
			} else {
			  throw ex;
			}
		}
		returnAST = scopeset_statement_AST;
	}

	public final void attribute_statement() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attribute_statement_AST = null;

		try {      // for error handling
			attributename();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp82_AST);
			match(EQUAL);
			attributevalues();
			astFactory.addASTChild(currentAST, returnAST);
			attribute_statement_AST = (AST)currentAST.root;
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
		returnAST = attribute_statement_AST;
	}

	public final void elementselection() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementselection_AST = null;

		try {      // for error handling
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
			{
			_loop21:
			do {
				switch ( LA(1)) {
				case OR:
				{
					AST tmp83_AST = null;
					tmp83_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp83_AST);
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
					AST tmp84_AST = null;
					tmp84_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp84_AST);
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
					break _loop21;
				}
				}
			} while (true);
			}
			elementselection_AST = (AST)currentAST.root;
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
			case SEMI:
			case LITERAL_MUST:
			case WITH:
			case AND:
			case LITERAL_AMONG:
			case LITERAL_EXIST:
			case LITERAL_EXISTS:
			case OR:
			case LITERAL_THE:
			case LITERAL_THIS:
			case ALL:
			case Number:
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
				consumeUntil(_tokenSet_9);
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
				AST tmp85_AST = null;
				tmp85_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp85_AST);
				match(LITERAL_THE);
				restriction_statement();
				astFactory.addASTChild(currentAST, returnAST);
				element();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_THIS:
			{
				AST tmp86_AST = null;
				tmp86_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp86_AST);
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
				consumeUntil(_tokenSet_9);
			} else {
			  throw ex;
			}
		}
		returnAST = direct_AST;
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
				AST tmp87_AST = null;
				tmp87_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp87_AST);
				match(ALL);
				break;
			}
			case Number:
			{
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp88_AST);
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
				consumeUntil(_tokenSet_10);
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
				AST tmp89_AST = null;
				tmp89_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp89_AST);
				match(ELEMENTS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case COMPONENTS:
			{
				AST tmp90_AST = null;
				tmp90_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp90_AST);
				match(COMPONENTS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case CONTAINERS:
			{
				AST tmp91_AST = null;
				tmp91_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp91_AST);
				match(CONTAINERS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case COMPUTERS:
			{
				AST tmp92_AST = null;
				tmp92_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp92_AST);
				match(COMPUTERS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case USERS:
			{
				AST tmp93_AST = null;
				tmp93_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp93_AST);
				match(USERS);
				restrictions_statement_AST = (AST)currentAST.root;
				break;
			}
			case INTERFACES:
			{
				AST tmp94_AST = null;
				tmp94_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp94_AST);
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
				consumeUntil(_tokenSet_11);
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
			AST tmp95_AST = null;
			tmp95_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp95_AST);
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
				consumeUntil(_tokenSet_9);
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
				AST tmp96_AST = null;
				tmp96_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp96_AST);
				match(ELEMENT);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case COMPONENT:
			{
				AST tmp97_AST = null;
				tmp97_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp97_AST);
				match(COMPONENT);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case CONTAINER:
			{
				AST tmp98_AST = null;
				tmp98_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp98_AST);
				match(CONTAINER);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case COMPUTER:
			{
				AST tmp99_AST = null;
				tmp99_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp99_AST);
				match(COMPUTER);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case USER:
			{
				AST tmp100_AST = null;
				tmp100_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp100_AST);
				match(USER);
				restriction_statement_AST = (AST)currentAST.root;
				break;
			}
			case INTERFACE:
			{
				AST tmp101_AST = null;
				tmp101_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp101_AST);
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
				consumeUntil(_tokenSet_12);
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
			AST tmp102_AST = null;
			tmp102_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp102_AST);
			match(QUOTED);
			{
			int _cnt81=0;
			_loop81:
			do {
				if ((LA(1)==ALPHA)) {
					AST tmp103_AST = null;
					tmp103_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp103_AST);
					match(ALPHA);
				}
				else {
					if ( _cnt81>=1 ) { break _loop81; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt81++;
			} while (true);
			}
			AST tmp104_AST = null;
			tmp104_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp104_AST);
			match(QUOTED);
			element_AST = (AST)currentAST.root;
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
				AST tmp105_AST = null;
				tmp105_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp105_AST);
				match(OR);
				break;
			}
			case AND:
			{
				AST tmp106_AST = null;
				tmp106_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp106_AST);
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
				consumeUntil(_tokenSet_13);
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
			_loop38:
			do {
				if ((LA(1)==AND||LA(1)==OR)) {
					logic_statement();
					astFactory.addASTChild(currentAST, returnAST);
					contextcondition_statement();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop38;
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
				consumeUntil(_tokenSet_14);
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
				AST tmp107_AST = null;
				tmp107_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp107_AST);
				match(OPEN_PAREN);
				contextcondition_comand();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp108_AST = null;
				tmp108_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp108_AST);
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
				consumeUntil(_tokenSet_14);
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
				consumeUntil(_tokenSet_14);
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
			AST tmp109_AST = null;
			tmp109_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp109_AST);
			match(QUOTED);
			{
			int _cnt48=0;
			_loop48:
			do {
				if ((LA(1)==ALPHA)) {
					AST tmp110_AST = null;
					tmp110_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp110_AST);
					match(ALPHA);
				}
				else {
					if ( _cnt48>=1 ) { break _loop48; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt48++;
			} while (true);
			}
			AST tmp111_AST = null;
			tmp111_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp111_AST);
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
				consumeUntil(_tokenSet_14);
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
				consumeUntil(_tokenSet_14);
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
			AST tmp112_AST = null;
			tmp112_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp112_AST);
			match(QUOTED);
			{
			int _cnt45=0;
			_loop45:
			do {
				if ((LA(1)==ALPHA)) {
					AST tmp113_AST = null;
					tmp113_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp113_AST);
					match(ALPHA);
				}
				else {
					if ( _cnt45>=1 ) { break _loop45; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt45++;
			} while (true);
			}
			AST tmp114_AST = null;
			tmp114_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp114_AST);
			match(QUOTED);
			contextpropertyname_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_14);
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
				AST tmp115_AST = null;
				tmp115_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp115_AST);
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
				consumeUntil(_tokenSet_15);
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
				AST tmp116_AST = null;
				tmp116_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp116_AST);
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
				AST tmp117_AST = null;
				tmp117_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp117_AST);
				match(LITERAL_EITHER);
				cp_command_or();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_BUT:
				{
					AST tmp118_AST = null;
					tmp118_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp118_AST);
					match(LITERAL_BUT);
					AST tmp119_AST = null;
					tmp119_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp119_AST);
					match(NOT);
					AST tmp120_AST = null;
					tmp120_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp120_AST);
					match(LITERAL_A);
					AST tmp121_AST = null;
					tmp121_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp121_AST);
					match(LITERAL_COMBINATION);
					AST tmp122_AST = null;
					tmp122_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp122_AST);
					match(LITERAL_OF);
					AST tmp123_AST = null;
					tmp123_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp123_AST);
					match(LITERAL_THEM);
					break;
				}
				case EOF:
				case SEMI:
				case LITERAL_MUST:
				case WITH:
				case AND:
				case LITERAL_AMONG:
				case LITERAL_EXIST:
				case LITERAL_EXISTS:
				case OR:
				case LITERAL_THE:
				case LITERAL_THIS:
				case ALL:
				case Number:
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
				AST tmp124_AST = null;
				tmp124_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp124_AST);
				match(LITERAL_EXACTLY);
				AST tmp125_AST = null;
				tmp125_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp125_AST);
				match(LITERAL_THE);
				AST tmp126_AST = null;
				tmp126_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp126_AST);
				match(LITERAL_SAME);
				AST tmp127_AST = null;
				tmp127_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp127_AST);
				match(LITERAL_VALUES);
				AST tmp128_AST = null;
				tmp128_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp128_AST);
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
				AST tmp129_AST = null;
				tmp129_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp129_AST);
				match(LITERAL_AT);
				AST tmp130_AST = null;
				tmp130_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp130_AST);
				match(LITERAL_LEAST);
				AST tmp131_AST = null;
				tmp131_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp131_AST);
				match(LITERAL_ONE);
				AST tmp132_AST = null;
				tmp132_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp132_AST);
				match(LITERAL_VALUE);
				AST tmp133_AST = null;
				tmp133_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp133_AST);
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
				AST tmp134_AST = null;
				tmp134_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp134_AST);
				match(ONLY);
				AST tmp135_AST = null;
				tmp135_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp135_AST);
				match(LITERAL_ONE);
				AST tmp136_AST = null;
				tmp136_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp136_AST);
				match(LITERAL_VALUE);
				AST tmp137_AST = null;
				tmp137_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp137_AST);
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
				consumeUntil(_tokenSet_14);
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
			AST tmp138_AST = null;
			tmp138_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp138_AST);
			match(QUOTED);
			{
			switch ( LA(1)) {
			case ALPHA:
			{
				{
				int _cnt76=0;
				_loop76:
				do {
					if ((LA(1)==ALPHA)) {
						AST tmp139_AST = null;
						tmp139_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp139_AST);
						match(ALPHA);
					}
					else {
						if ( _cnt76>=1 ) { break _loop76; } else {throw new NoViableAltException(LT(1), getFilename());}
					}

					_cnt76++;
				} while (true);
				}
				break;
			}
			case Number:
			{
				{
				int _cnt78=0;
				_loop78:
				do {
					if ((LA(1)==Number)) {
						AST tmp140_AST = null;
						tmp140_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp140_AST);
						match(Number);
					}
					else {
						if ( _cnt78>=1 ) { break _loop78; } else {throw new NoViableAltException(LT(1), getFilename());}
					}

					_cnt78++;
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
			AST tmp141_AST = null;
			tmp141_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp141_AST);
			match(QUOTED);
			contextpropertyvalue_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_16);
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
				AST tmp142_AST = null;
				tmp142_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp142_AST);
				match(IS);
				AST tmp143_AST = null;
				tmp143_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp143_AST);
				match(EMPTY);
			}
			else if ((LA(1)==IS)) {
				AST tmp144_AST = null;
				tmp144_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp144_AST);
				match(IS);
				AST tmp145_AST = null;
				tmp145_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp145_AST);
				match(NOT);
				AST tmp146_AST = null;
				tmp146_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp146_AST);
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
				consumeUntil(_tokenSet_14);
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
			AST tmp147_AST = null;
			tmp147_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp147_AST);
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
				consumeUntil(_tokenSet_15);
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
			AST tmp148_AST = null;
			tmp148_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp148_AST);
			match(DOES);
			AST tmp149_AST = null;
			tmp149_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp149_AST);
			match(NOT);
			AST tmp150_AST = null;
			tmp150_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp150_AST);
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
				consumeUntil(_tokenSet_15);
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
			AST tmp151_AST = null;
			tmp151_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp151_AST);
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
				consumeUntil(_tokenSet_15);
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
			AST tmp152_AST = null;
			tmp152_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp152_AST);
			match(DOES);
			AST tmp153_AST = null;
			tmp153_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp153_AST);
			match(NOT);
			AST tmp154_AST = null;
			tmp154_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp154_AST);
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
				consumeUntil(_tokenSet_15);
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
			AST tmp155_AST = null;
			tmp155_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp155_AST);
			match(INTERSECTS);
			AST tmp156_AST = null;
			tmp156_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp156_AST);
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
				consumeUntil(_tokenSet_15);
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
			AST tmp157_AST = null;
			tmp157_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp157_AST);
			match(DOES);
			AST tmp158_AST = null;
			tmp158_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp158_AST);
			match(NOT);
			AST tmp159_AST = null;
			tmp159_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp159_AST);
			match(INTTERSETS);
			AST tmp160_AST = null;
			tmp160_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp160_AST);
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
				consumeUntil(_tokenSet_15);
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
			AST tmp161_AST = null;
			tmp161_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp161_AST);
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
				consumeUntil(_tokenSet_15);
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
			int _cnt69=0;
			_loop69:
			do {
				if ((LA(1)==AND)) {
					AST tmp162_AST = null;
					tmp162_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp162_AST);
					match(AND);
					contextpropertyvalue();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt69>=1 ) { break _loop69; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt69++;
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
				consumeUntil(_tokenSet_14);
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
			int _cnt72=0;
			_loop72:
			do {
				if ((LA(1)==OR)) {
					AST tmp163_AST = null;
					tmp163_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp163_AST);
					match(OR);
					contextpropertyvalue();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt72>=1 ) { break _loop72; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt72++;
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
				consumeUntil(_tokenSet_17);
			} else {
			  throw ex;
			}
		}
		returnAST = cp_command_or_AST;
	}

	public final void attributename() throws RecognitionException, TokenStreamException {

		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attributename_AST = null;

		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_ACTION:
			{
				AST tmp164_AST = null;
				tmp164_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp164_AST);
				match(LITERAL_ACTION);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case 106:
			{
				AST tmp165_AST = null;
				tmp165_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp165_AST);
				match(106);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_COCONNAME:
			{
				AST tmp166_AST = null;
				tmp166_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp166_AST);
				match(LITERAL_COCONNAME);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_COCONAUTHOR:
			{
				AST tmp167_AST = null;
				tmp167_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp167_AST);
				match(LITERAL_COCONAUTHOR);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_COMMENT:
			{
				AST tmp168_AST = null;
				tmp168_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp168_AST);
				match(LITERAL_COMMENT);
				attributename_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_PRIORITY:
			{
				AST tmp169_AST = null;
				tmp169_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp169_AST);
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
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_18);
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
			AST tmp170_AST = null;
			tmp170_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp170_AST);
			match(QUOTED);
			{
			int _cnt89=0;
			_loop89:
			do {
				if ((LA(1)==ALPHA)) {
					AST tmp171_AST = null;
					tmp171_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp171_AST);
					match(ALPHA);
				}
				else {
					if ( _cnt89>=1 ) { break _loop89; } else {throw new NoViableAltException(LT(1), getFilename());}
				}

				_cnt89++;
			} while (true);
			}
			AST tmp172_AST = null;
			tmp172_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp172_AST);
			match(QUOTED);
			{
			_loop91:
			do {
				if ((LA(1)==COMMA)) {
					AST tmp173_AST = null;
					tmp173_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp173_AST);
					match(COMMA);
					attributevalues();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop91;
				}

			} while (true);
			}
			attributevalues_AST = (AST)currentAST.root;
		}
		catch (Error ex) {
			if (inputState.guessing==0) {
				//reportError(ex);
				consume();
				consumeUntil(_tokenSet_19);
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
				AST tmp174_AST = null;
				tmp174_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp174_AST);
				match(LITERAL_MUST);
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_BE:
			{
				AST tmp175_AST = null;
				tmp175_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp175_AST);
				match(LITERAL_BE);
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_THE:
			{
				AST tmp176_AST = null;
				tmp176_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp176_AST);
				match(LITERAL_THE);
				keyword_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_WHERE:
			{
				AST tmp177_AST = null;
				tmp177_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp177_AST);
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
		long[] data = { 2013265922L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 2013298690L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 65536L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 131072L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 2013265920L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 2013560834L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 2013822978L, 138538465099776L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 2065006594L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 2132639746L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 135291469824L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 8798225661954L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 70368744177664L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 87960930222080L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 35186504728578L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 3458834882568912896L, 520L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 4612002679908827138L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 4611721204932116482L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 72057594037927936L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 2013822978L, 279275953455104L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());

	}
