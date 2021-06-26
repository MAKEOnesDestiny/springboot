// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/dsl/qu/Quality.g4 by ANTLR 4.9
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
		T__0=1, T__1=2, T__2=3, T__3=4, DECIMAL=5, BOOLEAN=6, ID=7, ID2=8, WS=9, 
		DELIMITER=10, MUL=11, DIV=12, ADD=13, SUB=14, AND=15, OR=16, GT=17, LT=18, 
		GTE=19, LTE=20, EQ=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "DECIMAL", "DIGIT", "BOOLEAN", "ID", 
			"ID2", "WS", "DELIMITER", "MUL", "DIV", "ADD", "SUB", "AND", "OR", "GT", 
			"LT", "GTE", "LTE", "EQ"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", "'('", "')'", "'.'", null, null, null, null, null, "';'", 
			"'*'", "'/'", "'+'", "'-'", "'&'", "'||'", "'>'", "'<'", "'>='", "'<='", 
			"'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "DECIMAL", "BOOLEAN", "ID", "ID2", "WS", 
			"DELIMITER", "MUL", "DIV", "ADD", "SUB", "AND", "OR", "GT", "LT", "GTE", 
			"LTE", "EQ"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0088\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\5\69\n\6\3\6\6\6<\n\6\r\6\16\6=\3\6\3\6\6\6B\n"+
		"\6\r\6\16\6C\3\6\5\6G\n\6\3\6\6\6J\n\6\r\6\16\6K\5\6N\n\6\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b[\n\b\3\t\6\t^\n\t\r\t\16\t_\3\n\6"+
		"\nc\n\n\r\n\16\nd\3\13\6\13h\n\13\r\13\16\13i\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\2\2\30\3\3\5\4\7\5\t"+
		"\6\13\7\r\2\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%"+
		"\23\'\24)\25+\26-\27\3\2\6\3\2\62;\4\2C\\c|\5\2C\\aac|\5\2\13\f\17\17"+
		"\"\"\2\u0090\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2"+
		"\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2\17Z\3"+
		"\2\2\2\21]\3\2\2\2\23b\3\2\2\2\25g\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33"+
		"q\3\2\2\2\35s\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#y\3\2\2\2%|\3\2\2\2\'~\3\2"+
		"\2\2)\u0080\3\2\2\2+\u0083\3\2\2\2-\u0086\3\2\2\2/\60\7#\2\2\60\4\3\2"+
		"\2\2\61\62\7*\2\2\62\6\3\2\2\2\63\64\7+\2\2\64\b\3\2\2\2\65\66\7\60\2"+
		"\2\66\n\3\2\2\2\679\7/\2\28\67\3\2\2\289\3\2\2\29;\3\2\2\2:<\5\r\7\2;"+
		":\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2?A\7\60\2\2@B\5\r\7\2"+
		"A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DN\3\2\2\2EG\7/\2\2FE\3\2\2\2"+
		"FG\3\2\2\2GI\3\2\2\2HJ\5\r\7\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2"+
		"LN\3\2\2\2M8\3\2\2\2MF\3\2\2\2N\f\3\2\2\2OP\t\2\2\2P\16\3\2\2\2QR\7v\2"+
		"\2RS\7t\2\2ST\7w\2\2T[\7g\2\2UV\7h\2\2VW\7c\2\2WX\7n\2\2XY\7u\2\2Y[\7"+
		"g\2\2ZQ\3\2\2\2ZU\3\2\2\2[\20\3\2\2\2\\^\t\3\2\2]\\\3\2\2\2^_\3\2\2\2"+
		"_]\3\2\2\2_`\3\2\2\2`\22\3\2\2\2ac\t\4\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2"+
		"\2de\3\2\2\2e\24\3\2\2\2fh\t\5\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2"+
		"\2\2jk\3\2\2\2kl\b\13\2\2l\26\3\2\2\2mn\7=\2\2n\30\3\2\2\2op\7,\2\2p\32"+
		"\3\2\2\2qr\7\61\2\2r\34\3\2\2\2st\7-\2\2t\36\3\2\2\2uv\7/\2\2v \3\2\2"+
		"\2wx\7(\2\2x\"\3\2\2\2yz\7~\2\2z{\7~\2\2{$\3\2\2\2|}\7@\2\2}&\3\2\2\2"+
		"~\177\7>\2\2\177(\3\2\2\2\u0080\u0081\7@\2\2\u0081\u0082\7?\2\2\u0082"+
		"*\3\2\2\2\u0083\u0084\7>\2\2\u0084\u0085\7?\2\2\u0085,\3\2\2\2\u0086\u0087"+
		"\7?\2\2\u0087.\3\2\2\2\r\28=CFKMZ_di\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}