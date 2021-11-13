// Generated from br/ufscar/dc/compiladores/parser/tsgen.g4 by ANTLR 4.9.2
package br.ufscar.dc.compiladores.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tsgenLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUMBER=7, KEYWORD=8, TYPE=9, 
		COLON=10, OPN_SQR_BRACKET=11, CLS_SQR_BRACKET=12, OPN_CRL_BRACKET=13, 
		CLS_CRL_BRACKET=14, WS=15, IDENT=16, STRING=17, COMMENT=18, UNCLOSED_STRING=19, 
		INVALID_CHAR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NUMBER", "KEYWORD", 
			"TYPE", "COLON", "OPN_SQR_BRACKET", "CLS_SQR_BRACKET", "OPN_CRL_BRACKET", 
			"CLS_CRL_BRACKET", "WS", "IDENT", "STRING", "COMMENT", "UNCLOSED_STRING", 
			"INVALID_CHAR"
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


	public tsgenLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "tsgen.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00d3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\6\bQ\n\b\r\b\16\bR\3\b\3"+
		"\b\6\bW\n\b\r\b\16\bX\5\b[\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\t{\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0099"+
		"\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\7\21\u00ab\n\21\f\21\16\21\u00ae\13\21\3\22\3\22\7\22\u00b2"+
		"\n\22\f\22\16\22\u00b5\13\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u00bd"+
		"\n\23\f\23\16\23\u00c0\13\23\3\23\3\23\3\23\3\23\3\24\3\24\7\24\u00c8"+
		"\n\24\f\24\16\24\u00cb\13\24\3\24\3\24\3\25\6\25\u00d0\n\25\r\25\16\25"+
		"\u00d1\6\u00b3\u00be\u00c9\u00d1\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\7"+
		"\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\4\2\f\f\17\17\3\2))\2\u00e3"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5\61\3\2\2\2\7;\3\2"+
		"\2\2\t?\3\2\2\2\13D\3\2\2\2\rH\3\2\2\2\17P\3\2\2\2\21z\3\2\2\2\23\u0098"+
		"\3\2\2\2\25\u009a\3\2\2\2\27\u009c\3\2\2\2\31\u009e\3\2\2\2\33\u00a0\3"+
		"\2\2\2\35\u00a2\3\2\2\2\37\u00a4\3\2\2\2!\u00a8\3\2\2\2#\u00af\3\2\2\2"+
		"%\u00b8\3\2\2\2\'\u00c5\3\2\2\2)\u00cf\3\2\2\2+,\7o\2\2,-\7q\2\2-.\7f"+
		"\2\2./\7g\2\2/\60\7n\2\2\60\4\3\2\2\2\61\62\7g\2\2\62\63\7p\2\2\63\64"+
		"\7f\2\2\64\65\7r\2\2\65\66\7q\2\2\66\67\7k\2\2\678\7p\2\289\7v\2\29:\7"+
		"u\2\2:\6\3\2\2\2;<\7I\2\2<=\7G\2\2=>\7V\2\2>\b\3\2\2\2?@\7R\2\2@A\7Q\2"+
		"\2AB\7U\2\2BC\7V\2\2C\n\3\2\2\2DE\7R\2\2EF\7W\2\2FG\7V\2\2G\f\3\2\2\2"+
		"HI\7F\2\2IJ\7G\2\2JK\7N\2\2KL\7G\2\2LM\7V\2\2MN\7G\2\2N\16\3\2\2\2OQ\4"+
		"\62;\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2SZ\3\2\2\2TV\7\60\2\2UW"+
		"\4\62;\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZT\3\2\2\2Z"+
		"[\3\2\2\2[\20\3\2\2\2\\]\7o\2\2]^\7q\2\2^_\7f\2\2_`\7g\2\2`{\7n\2\2ab"+
		"\7g\2\2bc\7p\2\2cd\7f\2\2de\7r\2\2ef\7q\2\2fg\7k\2\2gh\7p\2\2hi\7v\2\2"+
		"i{\7u\2\2jk\7I\2\2kl\7G\2\2l{\7V\2\2mn\7R\2\2no\7Q\2\2op\7U\2\2p{\7V\2"+
		"\2qr\7R\2\2rs\7W\2\2s{\7V\2\2tu\7F\2\2uv\7G\2\2vw\7N\2\2wx\7G\2\2xy\7"+
		"V\2\2y{\7G\2\2z\\\3\2\2\2za\3\2\2\2zj\3\2\2\2zm\3\2\2\2zq\3\2\2\2zt\3"+
		"\2\2\2{\22\3\2\2\2|}\7u\2\2}~\7v\2\2~\177\7t\2\2\177\u0080\7k\2\2\u0080"+
		"\u0081\7p\2\2\u0081\u0099\7i\2\2\u0082\u0083\7p\2\2\u0083\u0084\7w\2\2"+
		"\u0084\u0085\7o\2\2\u0085\u0086\7d\2\2\u0086\u0087\7g\2\2\u0087\u0099"+
		"\7t\2\2\u0088\u0089\7d\2\2\u0089\u008a\7k\2\2\u008a\u008b\7i\2\2\u008b"+
		"\u008c\7k\2\2\u008c\u008d\7p\2\2\u008d\u0099\7v\2\2\u008e\u008f\7d\2\2"+
		"\u008f\u0090\7q\2\2\u0090\u0091\7q\2\2\u0091\u0092\7n\2\2\u0092\u0093"+
		"\7g\2\2\u0093\u0094\7c\2\2\u0094\u0099\7p\2\2\u0095\u0096\7c\2\2\u0096"+
		"\u0097\7p\2\2\u0097\u0099\7{\2\2\u0098|\3\2\2\2\u0098\u0082\3\2\2\2\u0098"+
		"\u0088\3\2\2\2\u0098\u008e\3\2\2\2\u0098\u0095\3\2\2\2\u0099\24\3\2\2"+
		"\2\u009a\u009b\7<\2\2\u009b\26\3\2\2\2\u009c\u009d\7]\2\2\u009d\30\3\2"+
		"\2\2\u009e\u009f\7_\2\2\u009f\32\3\2\2\2\u00a0\u00a1\7}\2\2\u00a1\34\3"+
		"\2\2\2\u00a2\u00a3\7\177\2\2\u00a3\36\3\2\2\2\u00a4\u00a5\t\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\b\20\2\2\u00a7 \3\2\2\2\u00a8\u00ac\t\3\2\2"+
		"\u00a9\u00ab\t\4\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u00b3\7)\2\2\u00b0\u00b2\n\5\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\u00b7\7)\2\2\u00b7$\3\2\2\2\u00b8\u00b9\7\61\2\2"+
		"\u00b9\u00ba\7\61\2\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\n\5\2\2\u00bc\u00bb"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\t\5\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c4\b\23\2\2\u00c4&\3\2\2\2\u00c5\u00c9\7)\2\2\u00c6\u00c8"+
		"\n\6\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00ca\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\t\5"+
		"\2\2\u00cd(\3\2\2\2\u00ce\u00d0\13\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2*\3\2\2\2\r\2RX"+
		"Zz\u0098\u00ac\u00b3\u00be\u00c9\u00d1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}