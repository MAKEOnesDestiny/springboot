// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/dsl/Quality.g4 by ANTLR 4.9
package com.zhou.springboot.dsl.qu;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QualityLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, DECIMAL=5, STRING=6, BOOLEAN=7, ID=8, 
		ID2=9, WS=10, DELIMITER=11, MUL=12, DIV=13, ADD=14, SUB=15, AND=16, OR=17, 
		GT=18, LT=19, GTE=20, LTE=21, EQ=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "DECIMAL", "DIGIT", "STRING", "BOOLEAN", 
			"ID", "ID2", "WS", "DELIMITER", "MUL", "DIV", "ADD", "SUB", "AND", "OR", 
			"GT", "LT", "GTE", "LTE", "EQ"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", "'('", "')'", "'.'", null, null, null, null, null, null, 
			"';'", "'*'", "'/'", "'+'", "'-'", "'&'", "'||'", "'>'", "'<'", "'>='", 
			"'<='", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "DECIMAL", "STRING", "BOOLEAN", "ID", "ID2", 
			"WS", "DELIMITER", "MUL", "DIV", "ADD", "SUB", "AND", "OR", "GT", "LT", 
			"GTE", "LTE", "EQ"
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


	public QualityLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Quality.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\5\6;\n\6\3\6\6\6>\n\6\r\6\16\6?\3\6\3"+
		"\6\6\6D\n\6\r\6\16\6E\3\6\5\6I\n\6\3\6\6\6L\n\6\r\6\16\6M\5\6P\n\6\3\7"+
		"\3\7\3\b\3\b\7\bV\n\b\f\b\16\bY\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\tf\n\t\3\n\6\ni\n\n\r\n\16\nj\3\13\6\13n\n\13\r\13\16\13"+
		"o\3\f\6\fs\n\f\r\f\16\ft\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21\t\23"+
		"\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30"+
		"\3\2\7\3\2\62;\4\2$$^^\4\2C\\c|\5\2C\\aac|\5\2\13\f\17\17\"\"\2\u009c"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2"+
		"\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17S\3"+
		"\2\2\2\21e\3\2\2\2\23h\3\2\2\2\25m\3\2\2\2\27r\3\2\2\2\31x\3\2\2\2\33"+
		"z\3\2\2\2\35|\3\2\2\2\37~\3\2\2\2!\u0080\3\2\2\2#\u0082\3\2\2\2%\u0084"+
		"\3\2\2\2\'\u0087\3\2\2\2)\u0089\3\2\2\2+\u008b\3\2\2\2-\u008e\3\2\2\2"+
		"/\u0091\3\2\2\2\61\62\7#\2\2\62\4\3\2\2\2\63\64\7*\2\2\64\6\3\2\2\2\65"+
		"\66\7+\2\2\66\b\3\2\2\2\678\7\60\2\28\n\3\2\2\29;\7/\2\2:9\3\2\2\2:;\3"+
		"\2\2\2;=\3\2\2\2<>\5\r\7\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3"+
		"\2\2\2AC\7\60\2\2BD\5\r\7\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FP"+
		"\3\2\2\2GI\7/\2\2HG\3\2\2\2HI\3\2\2\2IK\3\2\2\2JL\5\r\7\2KJ\3\2\2\2LM"+
		"\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2O:\3\2\2\2OH\3\2\2\2P\f\3\2\2\2"+
		"QR\t\2\2\2R\16\3\2\2\2SW\7$\2\2TV\n\3\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2"+
		"\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7$\2\2[\20\3\2\2\2\\]\7v\2\2]^\7t\2"+
		"\2^_\7w\2\2_f\7g\2\2`a\7h\2\2ab\7c\2\2bc\7n\2\2cd\7u\2\2df\7g\2\2e\\\3"+
		"\2\2\2e`\3\2\2\2f\22\3\2\2\2gi\t\4\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2j"+
		"k\3\2\2\2k\24\3\2\2\2ln\t\5\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2"+
		"\2p\26\3\2\2\2qs\t\6\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2"+
		"\2\2vw\b\f\2\2w\30\3\2\2\2xy\7=\2\2y\32\3\2\2\2z{\7,\2\2{\34\3\2\2\2|"+
		"}\7\61\2\2}\36\3\2\2\2~\177\7-\2\2\177 \3\2\2\2\u0080\u0081\7/\2\2\u0081"+
		"\"\3\2\2\2\u0082\u0083\7(\2\2\u0083$\3\2\2\2\u0084\u0085\7~\2\2\u0085"+
		"\u0086\7~\2\2\u0086&\3\2\2\2\u0087\u0088\7@\2\2\u0088(\3\2\2\2\u0089\u008a"+
		"\7>\2\2\u008a*\3\2\2\2\u008b\u008c\7@\2\2\u008c\u008d\7?\2\2\u008d,\3"+
		"\2\2\2\u008e\u008f\7>\2\2\u008f\u0090\7?\2\2\u0090.\3\2\2\2\u0091\u0092"+
		"\7?\2\2\u0092\60\3\2\2\2\16\2:?EHMOWejot\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}