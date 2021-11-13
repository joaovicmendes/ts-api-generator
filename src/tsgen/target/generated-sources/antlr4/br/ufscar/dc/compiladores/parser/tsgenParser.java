// Generated from br/ufscar/dc/compiladores/parser/tsgen.g4 by ANTLR 4.9.2
package br.ufscar.dc.compiladores.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tsgenParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUMBER=7, KEYWORD=8, TYPE=9, 
		COLON=10, OPN_SQR_BRACKET=11, CLS_SQR_BRACKET=12, OPN_CRL_BRACKET=13, 
		CLS_CRL_BRACKET=14, WS=15, IDENT=16, STRING=17, COMMENT=18, UNCLOSED_STRING=19, 
		INVALID_CHAR=20;
	public static final int
		RULE_program = 0, RULE_models = 1, RULE_model = 2, RULE_field = 3, RULE_endpoints = 4, 
		RULE_endpoint = 5, RULE_route = 6, RULE_method = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "models", "model", "field", "endpoints", "endpoint", "route", 
			"method"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'model'", "'endpoints'", "'GET'", "'POST'", "'PUT'", "'DELETE'", 
			null, null, null, "':'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "NUMBER", "KEYWORD", "TYPE", 
			"COLON", "OPN_SQR_BRACKET", "CLS_SQR_BRACKET", "OPN_CRL_BRACKET", "CLS_CRL_BRACKET", 
			"WS", "IDENT", "STRING", "COMMENT", "UNCLOSED_STRING", "INVALID_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "tsgen.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tsgenParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ModelsContext models() {
			return getRuleContext(ModelsContext.class,0);
		}
		public EndpointsContext endpoints() {
			return getRuleContext(EndpointsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(tsgenParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsgenVisitor ) return ((tsgenVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			models();
			setState(17);
			endpoints();
			setState(18);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelsContext extends ParserRuleContext {
		public TerminalNode OPN_SQR_BRACKET() { return getToken(tsgenParser.OPN_SQR_BRACKET, 0); }
		public TerminalNode CLS_SQR_BRACKET() { return getToken(tsgenParser.CLS_SQR_BRACKET, 0); }
		public List<ModelContext> model() {
			return getRuleContexts(ModelContext.class);
		}
		public ModelContext model(int i) {
			return getRuleContext(ModelContext.class,i);
		}
		public ModelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_models; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).enterModels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).exitModels(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsgenVisitor ) return ((tsgenVisitor<? extends T>)visitor).visitModels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelsContext models() throws RecognitionException {
		ModelsContext _localctx = new ModelsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_models);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(T__0);
			setState(21);
			match(OPN_SQR_BRACKET);
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				model();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(27);
			match(CLS_SQR_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelContext extends ParserRuleContext {
		public FieldContext field;
		public List<FieldContext> fields = new ArrayList<FieldContext>();
		public TerminalNode IDENT() { return getToken(tsgenParser.IDENT, 0); }
		public TerminalNode OPN_CRL_BRACKET() { return getToken(tsgenParser.OPN_CRL_BRACKET, 0); }
		public TerminalNode CLS_CRL_BRACKET() { return getToken(tsgenParser.CLS_CRL_BRACKET, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsgenVisitor ) return ((tsgenVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(IDENT);
			setState(30);
			match(OPN_CRL_BRACKET);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				((ModelContext)_localctx).field = field();
				((ModelContext)_localctx).fields.add(((ModelContext)_localctx).field);
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(36);
			match(CLS_CRL_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(tsgenParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(tsgenParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(tsgenParser.TYPE, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsgenVisitor ) return ((tsgenVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(IDENT);
			setState(39);
			match(COLON);
			setState(40);
			match(TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndpointsContext extends ParserRuleContext {
		public TerminalNode OPN_SQR_BRACKET() { return getToken(tsgenParser.OPN_SQR_BRACKET, 0); }
		public TerminalNode CLS_SQR_BRACKET() { return getToken(tsgenParser.CLS_SQR_BRACKET, 0); }
		public List<EndpointContext> endpoint() {
			return getRuleContexts(EndpointContext.class);
		}
		public EndpointContext endpoint(int i) {
			return getRuleContext(EndpointContext.class,i);
		}
		public EndpointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endpoints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).enterEndpoints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).exitEndpoints(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsgenVisitor ) return ((tsgenVisitor<? extends T>)visitor).visitEndpoints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndpointsContext endpoints() throws RecognitionException {
		EndpointsContext _localctx = new EndpointsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_endpoints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__1);
			setState(43);
			match(OPN_SQR_BRACKET);
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				endpoint();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(49);
			match(CLS_SQR_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndpointContext extends ParserRuleContext {
		public RouteContext route;
		public List<RouteContext> routes = new ArrayList<RouteContext>();
		public TerminalNode IDENT() { return getToken(tsgenParser.IDENT, 0); }
		public TerminalNode OPN_CRL_BRACKET() { return getToken(tsgenParser.OPN_CRL_BRACKET, 0); }
		public TerminalNode CLS_CRL_BRACKET() { return getToken(tsgenParser.CLS_CRL_BRACKET, 0); }
		public List<RouteContext> route() {
			return getRuleContexts(RouteContext.class);
		}
		public RouteContext route(int i) {
			return getRuleContext(RouteContext.class,i);
		}
		public EndpointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endpoint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).enterEndpoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).exitEndpoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsgenVisitor ) return ((tsgenVisitor<? extends T>)visitor).visitEndpoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndpointContext endpoint() throws RecognitionException {
		EndpointContext _localctx = new EndpointContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_endpoint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(IDENT);
			setState(52);
			match(OPN_CRL_BRACKET);
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				((EndpointContext)_localctx).route = route();
				((EndpointContext)_localctx).routes.add(((EndpointContext)_localctx).route);
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0) );
			setState(58);
			match(CLS_CRL_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RouteContext extends ParserRuleContext {
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public TerminalNode STRING() { return getToken(tsgenParser.STRING, 0); }
		public RouteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_route; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).enterRoute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).exitRoute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsgenVisitor ) return ((tsgenVisitor<? extends T>)visitor).visitRoute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouteContext route() throws RecognitionException {
		RouteContext _localctx = new RouteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_route);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			method();
			setState(61);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsgenListener ) ((tsgenListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsgenVisitor ) return ((tsgenVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26D\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\6\3\32\n\3\r\3\16\3\33\3\3\3\3\3\4\3\4\3\4\6\4#\n\4\r\4\16\4"+
		"$\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\6\6\60\n\6\r\6\16\6\61\3\6\3\6\3"+
		"\7\3\7\3\7\6\79\n\7\r\7\16\7:\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\2\2\n\2"+
		"\4\6\b\n\f\16\20\2\3\3\2\5\b\2?\2\22\3\2\2\2\4\26\3\2\2\2\6\37\3\2\2\2"+
		"\b(\3\2\2\2\n,\3\2\2\2\f\65\3\2\2\2\16>\3\2\2\2\20A\3\2\2\2\22\23\5\4"+
		"\3\2\23\24\5\n\6\2\24\25\7\2\2\3\25\3\3\2\2\2\26\27\7\3\2\2\27\31\7\r"+
		"\2\2\30\32\5\6\4\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2"+
		"\2\2\34\35\3\2\2\2\35\36\7\16\2\2\36\5\3\2\2\2\37 \7\22\2\2 \"\7\17\2"+
		"\2!#\5\b\5\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%&\3\2\2\2&\'\7"+
		"\20\2\2\'\7\3\2\2\2()\7\22\2\2)*\7\f\2\2*+\7\13\2\2+\t\3\2\2\2,-\7\4\2"+
		"\2-/\7\r\2\2.\60\5\f\7\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2"+
		"\2\2\62\63\3\2\2\2\63\64\7\16\2\2\64\13\3\2\2\2\65\66\7\22\2\2\668\7\17"+
		"\2\2\679\5\16\b\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2"+
		"<=\7\20\2\2=\r\3\2\2\2>?\5\20\t\2?@\7\23\2\2@\17\3\2\2\2AB\t\2\2\2B\21"+
		"\3\2\2\2\6\33$\61:";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}