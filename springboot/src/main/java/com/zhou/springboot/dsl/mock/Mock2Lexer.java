// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/dsl/mock/Mock2.g4 by ANTLR 4.9
package com.zhou.springboot.dsl.mock;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Mock2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INTEGER_VALUE=11, DECIMAL_VALUE=12, STRING=13, BOOLEAN=14, FUNC=15, 
		ID=16, INT=17, DELIMITER=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "INTEGER_VALUE", "DECIMAL_VALUE", "DIGIT", "STRING", "BOOLEAN", 
			"FUNC", "ID", "INT", "DELIMITER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'>'", "'.'", "'['", "'*'", "','", "']'", "'('", "')'", 
			"'null'", null, null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INTEGER_VALUE", 
			"DECIMAL_VALUE", "STRING", "BOOLEAN", "FUNC", "ID", "INT", "DELIMITER", 
			"WS"
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


	public Mock2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mock2.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0087\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\5"+
		"\fD\n\f\3\f\6\fG\n\f\r\f\16\fH\3\r\5\rL\n\r\3\r\6\rO\n\r\r\r\16\rP\3\r"+
		"\3\r\6\rU\n\r\r\r\16\rV\3\16\3\16\3\17\3\17\7\17]\n\17\f\17\16\17`\13"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20m\n\20"+
		"\3\21\3\21\6\21q\n\21\r\21\16\21r\3\22\6\22v\n\22\r\22\16\22w\3\23\6\23"+
		"{\n\23\r\23\16\23|\3\24\3\24\3\25\6\25\u0082\n\25\r\25\16\25\u0083\3\25"+
		"\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\2\35\17\37\20!\21#\22%\23\'\24)\25\3\2\7\3\2\62;\4\2$$^^\5\2C\\aa"+
		"c|\4\2C\\c|\5\2\13\f\17\17\"\"\2\u0090\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2"+
		"\2\2\5-\3\2\2\2\7/\3\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17"+
		"\67\3\2\2\2\219\3\2\2\2\23;\3\2\2\2\25=\3\2\2\2\27C\3\2\2\2\31K\3\2\2"+
		"\2\33X\3\2\2\2\35Z\3\2\2\2\37l\3\2\2\2!n\3\2\2\2#u\3\2\2\2%z\3\2\2\2\'"+
		"~\3\2\2\2)\u0081\3\2\2\2+,\7?\2\2,\4\3\2\2\2-.\7@\2\2.\6\3\2\2\2/\60\7"+
		"\60\2\2\60\b\3\2\2\2\61\62\7]\2\2\62\n\3\2\2\2\63\64\7,\2\2\64\f\3\2\2"+
		"\2\65\66\7.\2\2\66\16\3\2\2\2\678\7_\2\28\20\3\2\2\29:\7*\2\2:\22\3\2"+
		"\2\2;<\7+\2\2<\24\3\2\2\2=>\7p\2\2>?\7w\2\2?@\7n\2\2@A\7n\2\2A\26\3\2"+
		"\2\2BD\7/\2\2CB\3\2\2\2CD\3\2\2\2DF\3\2\2\2EG\5\33\16\2FE\3\2\2\2GH\3"+
		"\2\2\2HF\3\2\2\2HI\3\2\2\2I\30\3\2\2\2JL\7/\2\2KJ\3\2\2\2KL\3\2\2\2LN"+
		"\3\2\2\2MO\5\33\16\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2\2\2"+
		"RT\7\60\2\2SU\5\33\16\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\32\3"+
		"\2\2\2XY\t\2\2\2Y\34\3\2\2\2Z^\7$\2\2[]\n\3\2\2\\[\3\2\2\2]`\3\2\2\2^"+
		"\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7$\2\2b\36\3\2\2\2cd\7v\2\2"+
		"de\7t\2\2ef\7w\2\2fm\7g\2\2gh\7h\2\2hi\7c\2\2ij\7n\2\2jk\7u\2\2km\7g\2"+
		"\2lc\3\2\2\2lg\3\2\2\2m \3\2\2\2np\7a\2\2oq\t\4\2\2po\3\2\2\2qr\3\2\2"+
		"\2rp\3\2\2\2rs\3\2\2\2s\"\3\2\2\2tv\t\5\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2"+
		"\2\2wx\3\2\2\2x$\3\2\2\2y{\t\2\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2"+
		"\2\2}&\3\2\2\2~\177\7=\2\2\177(\3\2\2\2\u0080\u0082\t\6\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\b\25\2\2\u0086*\3\2\2\2\16\2CHKPV^lrw|\u0083"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}