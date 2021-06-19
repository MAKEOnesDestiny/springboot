// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/shift/Shift.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.shift;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShiftLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, INT=5, WS=6, SL_COMM=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "ID", "INT", "WS", "SL_COMM"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ID", "INT", "WS", "SL_COMM"
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


	public ShiftLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Shift.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\67\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\6\5\33\n\5\r\5\16\5\34\3\6\6\6 \n\6\r\6\16\6!\3\7\6\7%"+
		"\n\7\r\7\16\7&\3\7\3\7\3\b\3\b\3\b\3\b\7\b/\n\b\f\b\16\b\62\13\b\3\b\3"+
		"\b\3\b\3\b\3\60\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5\4\2C\\c|\3\2\62"+
		";\5\2\13\f\17\17\"\"\2:\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\25\3\2\2\2\7\27"+
		"\3\2\2\2\t\32\3\2\2\2\13\37\3\2\2\2\r$\3\2\2\2\17*\3\2\2\2\21\22\7k\2"+
		"\2\22\23\7p\2\2\23\24\7v\2\2\24\4\3\2\2\2\25\26\7?\2\2\26\6\3\2\2\2\27"+
		"\30\7=\2\2\30\b\3\2\2\2\31\33\t\2\2\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32"+
		"\3\2\2\2\34\35\3\2\2\2\35\n\3\2\2\2\36 \t\3\2\2\37\36\3\2\2\2 !\3\2\2"+
		"\2!\37\3\2\2\2!\"\3\2\2\2\"\f\3\2\2\2#%\t\4\2\2$#\3\2\2\2%&\3\2\2\2&$"+
		"\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\b\7\2\2)\16\3\2\2\2*+\7\61\2\2+,\7\61"+
		"\2\2,\60\3\2\2\2-/\13\2\2\2.-\3\2\2\2/\62\3\2\2\2\60\61\3\2\2\2\60.\3"+
		"\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\7\f\2\2\64\65\3\2\2\2\65\66\b"+
		"\b\3\2\66\20\3\2\2\2\7\2\34!&\60\4\2\3\2\2\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}