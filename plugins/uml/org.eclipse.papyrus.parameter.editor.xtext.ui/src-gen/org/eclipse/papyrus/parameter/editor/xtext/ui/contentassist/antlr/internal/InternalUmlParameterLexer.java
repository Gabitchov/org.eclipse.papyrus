/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parameter.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlParameterLexer extends Lexer {

	public static final int RULE_ID = 4;

	public static final int RULE_UNLIMITEDLITERAL = 5;

	public static final int RULE_ANY_OTHER = 11;

	public static final int T29 = 29;

	public static final int T28 = 28;

	public static final int T27 = 27;

	public static final int T26 = 26;

	public static final int T25 = 25;

	public static final int Tokens = 38;

	public static final int T24 = 24;

	public static final int EOF = -1;

	public static final int RULE_SL_COMMENT = 9;

	public static final int T23 = 23;

	public static final int T22 = 22;

	public static final int T21 = 21;

	public static final int T20 = 20;

	public static final int RULE_ML_COMMENT = 8;

	public static final int RULE_STRING = 7;

	public static final int RULE_INT = 6;

	public static final int T37 = 37;

	public static final int T12 = 12;

	public static final int T13 = 13;

	public static final int T14 = 14;

	public static final int T34 = 34;

	public static final int RULE_WS = 10;

	public static final int T15 = 15;

	public static final int T33 = 33;

	public static final int T16 = 16;

	public static final int T36 = 36;

	public static final int T17 = 17;

	public static final int T35 = 35;

	public static final int T18 = 18;

	public static final int T30 = 30;

	public static final int T19 = 19;

	public static final int T32 = 32;

	public static final int T31 = 31;

	public InternalUmlParameterLexer() {
		;
	}

	public InternalUmlParameterLexer(CharStream input) {
		super(input);
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g";
	}

	// $ANTLR start T12
	public final void mT12() throws RecognitionException {
		try {
			int _type = T12;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:10:5: ( '<Undefined>' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:10:7: '<Undefined>'
			{
				match("<Undefined>");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T12

	// $ANTLR start T13
	public final void mT13() throws RecognitionException {
		try {
			int _type = T13;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:11:5: ( 'exception' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:11:7: 'exception'
			{
				match("exception");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T13

	// $ANTLR start T14
	public final void mT14() throws RecognitionException {
		try {
			int _type = T14;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:12:5: ( 'stream' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:12:7: 'stream'
			{
				match("stream");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T14

	// $ANTLR start T15
	public final void mT15() throws RecognitionException {
		try {
			int _type = T15;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:13:5: ( 'ordered' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:13:7: 'ordered'
			{
				match("ordered");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T15

	// $ANTLR start T16
	public final void mT16() throws RecognitionException {
		try {
			int _type = T16;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:14:5: ( 'unique' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:14:7: 'unique'
			{
				match("unique");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T16

	// $ANTLR start T17
	public final void mT17() throws RecognitionException {
		try {
			int _type = T17;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:15:5: ( 'create' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:15:7: 'create'
			{
				match("create");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T17

	// $ANTLR start T18
	public final void mT18() throws RecognitionException {
		try {
			int _type = T18;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:16:5: ( 'read' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:16:7: 'read'
			{
				match("read");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T18

	// $ANTLR start T19
	public final void mT19() throws RecognitionException {
		try {
			int _type = T19;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:17:5: ( 'update' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:17:7: 'update'
			{
				match("update");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T19

	// $ANTLR start T20
	public final void mT20() throws RecognitionException {
		try {
			int _type = T20;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:18:5: ( 'delete' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:18:7: 'delete'
			{
				match("delete");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T20

	// $ANTLR start T21
	public final void mT21() throws RecognitionException {
		try {
			int _type = T21;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:19:5: ( '+' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:19:7: '+'
			{
				match('+');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T21

	// $ANTLR start T22
	public final void mT22() throws RecognitionException {
		try {
			int _type = T22;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:20:5: ( '-' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:20:7: '-'
			{
				match('-');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T22

	// $ANTLR start T23
	public final void mT23() throws RecognitionException {
		try {
			int _type = T23;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:21:5: ( '#' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:21:7: '#'
			{
				match('#');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T23

	// $ANTLR start T24
	public final void mT24() throws RecognitionException {
		try {
			int _type = T24;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:22:5: ( '~' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:22:7: '~'
			{
				match('~');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T24

	// $ANTLR start T25
	public final void mT25() throws RecognitionException {
		try {
			int _type = T25;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:23:5: ( 'in' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:23:7: 'in'
			{
				match("in");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T25

	// $ANTLR start T26
	public final void mT26() throws RecognitionException {
		try {
			int _type = T26;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:24:5: ( 'out' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:24:7: 'out'
			{
				match("out");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T26

	// $ANTLR start T27
	public final void mT27() throws RecognitionException {
		try {
			int _type = T27;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:25:5: ( 'inout' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:25:7: 'inout'
			{
				match("inout");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T27

	// $ANTLR start T28
	public final void mT28() throws RecognitionException {
		try {
			int _type = T28;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:26:5: ( 'return' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:26:7: 'return'
			{
				match("return");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T28

	// $ANTLR start T29
	public final void mT29() throws RecognitionException {
		try {
			int _type = T29;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:27:5: ( ':' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:27:7: ':'
			{
				match(':');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T29

	// $ANTLR start T30
	public final void mT30() throws RecognitionException {
		try {
			int _type = T30;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:28:5: ( '{' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:28:7: '{'
			{
				match('{');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T30

	// $ANTLR start T31
	public final void mT31() throws RecognitionException {
		try {
			int _type = T31;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:29:5: ( '}' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:29:7: '}'
			{
				match('}');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T31

	// $ANTLR start T32
	public final void mT32() throws RecognitionException {
		try {
			int _type = T32;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:30:5: ( ',' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:30:7: ','
			{
				match(',');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T32

	// $ANTLR start T33
	public final void mT33() throws RecognitionException {
		try {
			int _type = T33;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:31:5: ( 'effect: ' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:31:7: 'effect: '
			{
				match("effect: ");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T33

	// $ANTLR start T34
	public final void mT34() throws RecognitionException {
		try {
			int _type = T34;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:32:5: ( '::' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:32:7: '::'
			{
				match("::");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T34

	// $ANTLR start T35
	public final void mT35() throws RecognitionException {
		try {
			int _type = T35;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:33:5: ( '[' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:33:7: '['
			{
				match('[');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T35

	// $ANTLR start T36
	public final void mT36() throws RecognitionException {
		try {
			int _type = T36;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:34:5: ( ']' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:34:7: ']'
			{
				match(']');

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T36

	// $ANTLR start T37
	public final void mT37() throws RecognitionException {
		try {
			int _type = T37;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:35:5: ( '..' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:35:7: '..'
			{
				match("..");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T37

	// $ANTLR start RULE_UNLIMITEDLITERAL
	public final void mRULE_UNLIMITEDLITERAL() throws RecognitionException {
		try {
			int _type = RULE_UNLIMITEDLITERAL;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1732:23: ( ( '0' .. '9' ( '0' .. '9' )* | '*' ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1732:25: ( '0' .. '9' ( '0' .. '9' )* | '*' )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1732:25: ( '0' .. '9' ( '0' .. '9' )* | '*' )
				int alt2 = 2;
				int LA2_0 = input.LA(1);

				if(((LA2_0 >= '0' && LA2_0 <= '9'))) {
					alt2 = 1;
				} else if((LA2_0 == '*')) {
					alt2 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("1732:25: ( '0' .. '9' ( '0' .. '9' )* | '*' )", 2, 0, input);

					throw nvae;
				}
				switch(alt2) {
				case 1:
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1732:26: '0' .. '9' ( '0' .. '9' )*
				{
					matchRange('0', '9');
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1732:35: ( '0' .. '9' )*
					loop1: do {
						int alt1 = 2;
						int LA1_0 = input.LA(1);

						if(((LA1_0 >= '0' && LA1_0 <= '9'))) {
							alt1 = 1;
						}


						switch(alt1) {
						case 1:
							// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1732:36: '0' .. '9'
						{
							matchRange('0', '9');

						}
							break;

						default:
							break loop1;
						}
					} while(true);


				}
					break;
				case 2:
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1732:47: '*'
				{
					match('*');

				}
					break;

				}


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_UNLIMITEDLITERAL

	// $ANTLR start RULE_ID
	public final void mRULE_ID() throws RecognitionException {
		try {
			int _type = RULE_ID;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1734:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1734:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1734:11: ( '^' )?
				int alt3 = 2;
				int LA3_0 = input.LA(1);

				if((LA3_0 == '^')) {
					alt3 = 1;
				}
				switch(alt3) {
				case 1:
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1734:11: '^'
				{
					match('^');

				}
					break;

				}

				if((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1734:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
				loop4: do {
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if(((LA4_0 >= '0' && LA4_0 <= '9') || (LA4_0 >= 'A' && LA4_0 <= 'Z') || LA4_0 == '_' || (LA4_0 >= 'a' && LA4_0 <= 'z'))) {
						alt4 = 1;
					}


					switch(alt4) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:
					{
						if((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						break loop4;
					}
				} while(true);


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_ID

	// $ANTLR start RULE_INT
	public final void mRULE_INT() throws RecognitionException {
		try {
			int _type = RULE_INT;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1736:10: ( ( '0' .. '9' )+ )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1736:12: ( '0' .. '9' )+
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1736:12: ( '0' .. '9' )+
				int cnt5 = 0;
				loop5: do {
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if(((LA5_0 >= '0' && LA5_0 <= '9'))) {
						alt5 = 1;
					}


					switch(alt5) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1736:13: '0' .. '9'
					{
						matchRange('0', '9');

					}
						break;

					default:
						if(cnt5 >= 1)
							break loop5;
						EarlyExitException eee = new EarlyExitException(5, input);
						throw eee;
					}
					cnt5++;
				} while(true);


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_INT

	// $ANTLR start RULE_STRING
	public final void mRULE_STRING() throws RecognitionException {
		try {
			int _type = RULE_STRING;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
				int alt8 = 2;
				int LA8_0 = input.LA(1);

				if((LA8_0 == '\"')) {
					alt8 = 1;
				} else if((LA8_0 == '\'')) {
					alt8 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("1738:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 8, 0, input);

					throw nvae;
				}
				switch(alt8) {
				case 1:
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
				{
					match('\"');
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
					loop6: do {
						int alt6 = 3;
						int LA6_0 = input.LA(1);

						if((LA6_0 == '\\')) {
							alt6 = 1;
						} else if(((LA6_0 >= '\u0000' && LA6_0 <= '!') || (LA6_0 >= '#' && LA6_0 <= '[') || (LA6_0 >= ']' && LA6_0 <= '\uFFFE'))) {
							alt6 = 2;
						}


						switch(alt6) {
						case 1:
							// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
						{
							match('\\');
							if(input.LA(1) == '\"' || input.LA(1) == '\'' || input.LA(1) == '\\' || input.LA(1) == 'b' || input.LA(1) == 'f' || input.LA(1) == 'n' || input.LA(1) == 'r' || input.LA(1) == 't') {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
							break;
						case 2:
							// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:62: ~ ( ( '\\\\' | '\"' ) )
						{
							if((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFE')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
							break;

						default:
							break loop6;
						}
					} while(true);

					match('\"');

				}
					break;
				case 2:
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
				{
					match('\'');
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
					loop7: do {
						int alt7 = 3;
						int LA7_0 = input.LA(1);

						if((LA7_0 == '\\')) {
							alt7 = 1;
						} else if(((LA7_0 >= '\u0000' && LA7_0 <= '&') || (LA7_0 >= '(' && LA7_0 <= '[') || (LA7_0 >= ']' && LA7_0 <= '\uFFFE'))) {
							alt7 = 2;
						}


						switch(alt7) {
						case 1:
							// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
						{
							match('\\');
							if(input.LA(1) == '\"' || input.LA(1) == '\'' || input.LA(1) == '\\' || input.LA(1) == 'b' || input.LA(1) == 'f' || input.LA(1) == 'n' || input.LA(1) == 'r' || input.LA(1) == 't') {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
							break;
						case 2:
							// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1738:129: ~ ( ( '\\\\' | '\\'' ) )
						{
							if((input.LA(1) >= '\u0000' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFE')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
							break;

						default:
							break loop7;
						}
					} while(true);

					match('\'');

				}
					break;

				}


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_STRING

	// $ANTLR start RULE_ML_COMMENT
	public final void mRULE_ML_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_ML_COMMENT;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1740:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1740:19: '/*' ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1740:24: ( options {greedy=false; } : . )*
				loop9: do {
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if((LA9_0 == '*')) {
						int LA9_1 = input.LA(2);

						if((LA9_1 == '/')) {
							alt9 = 2;
						} else if(((LA9_1 >= '\u0000' && LA9_1 <= '.') || (LA9_1 >= '0' && LA9_1 <= '\uFFFE'))) {
							alt9 = 1;
						}


					} else if(((LA9_0 >= '\u0000' && LA9_0 <= ')') || (LA9_0 >= '+' && LA9_0 <= '\uFFFE'))) {
						alt9 = 1;
					}


					switch(alt9) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1740:52: .
					{
						matchAny();

					}
						break;

					default:
						break loop9;
					}
				} while(true);

				match("*/");


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_ML_COMMENT

	// $ANTLR start RULE_SL_COMMENT
	public final void mRULE_SL_COMMENT() throws RecognitionException {
		try {
			int _type = RULE_SL_COMMENT;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
			{
				match("//");

				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:24: (~ ( ( '\\n' | '\\r' ) ) )*
				loop10: do {
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if(((LA10_0 >= '\u0000' && LA10_0 <= '\t') || (LA10_0 >= '\u000B' && LA10_0 <= '\f') || (LA10_0 >= '\u000E' && LA10_0 <= '\uFFFE'))) {
						alt10 = 1;
					}


					switch(alt10) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:24: ~ ( ( '\\n' | '\\r' ) )
					{
						if((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						break loop10;
					}
				} while(true);

				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:40: ( ( '\\r' )? '\\n' )?
				int alt12 = 2;
				int LA12_0 = input.LA(1);

				if((LA12_0 == '\n' || LA12_0 == '\r')) {
					alt12 = 1;
				}
				switch(alt12) {
				case 1:
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:41: ( '\\r' )? '\\n'
				{
					// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:41: ( '\\r' )?
					int alt11 = 2;
					int LA11_0 = input.LA(1);

					if((LA11_0 == '\r')) {
						alt11 = 1;
					}
					switch(alt11) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1742:41: '\\r'
					{
						match('\r');

					}
						break;

					}

					match('\n');

				}
					break;

				}


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_SL_COMMENT

	// $ANTLR start RULE_WS
	public final void mRULE_WS() throws RecognitionException {
		try {
			int _type = RULE_WS;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1744:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1744:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
				// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1744:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
				int cnt13 = 0;
				loop13: do {
					int alt13 = 2;
					int LA13_0 = input.LA(1);

					if(((LA13_0 >= '\t' && LA13_0 <= '\n') || LA13_0 == '\r' || LA13_0 == ' ')) {
						alt13 = 1;
					}


					switch(alt13) {
					case 1:
						// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:
					{
						if((input.LA(1) >= '\t' && input.LA(1) <= '\n') || input.LA(1) == '\r' || input.LA(1) == ' ') {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						if(cnt13 >= 1)
							break loop13;
						EarlyExitException eee = new EarlyExitException(13, input);
						throw eee;
					}
					cnt13++;
				} while(true);


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_WS

	// $ANTLR start RULE_ANY_OTHER
	public final void mRULE_ANY_OTHER() throws RecognitionException {
		try {
			int _type = RULE_ANY_OTHER;
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1746:16: ( . )
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1746:18: .
			{
				matchAny();

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_ANY_OTHER

	public void mTokens() throws RecognitionException {
		// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | RULE_UNLIMITEDLITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
		int alt14 = 34;
		alt14 = dfa14.predict(input);
		switch(alt14) {
		case 1:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:10: T12
		{
			mT12();

		}
			break;
		case 2:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:14: T13
		{
			mT13();

		}
			break;
		case 3:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:18: T14
		{
			mT14();

		}
			break;
		case 4:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:22: T15
		{
			mT15();

		}
			break;
		case 5:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:26: T16
		{
			mT16();

		}
			break;
		case 6:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:30: T17
		{
			mT17();

		}
			break;
		case 7:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:34: T18
		{
			mT18();

		}
			break;
		case 8:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:38: T19
		{
			mT19();

		}
			break;
		case 9:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:42: T20
		{
			mT20();

		}
			break;
		case 10:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:46: T21
		{
			mT21();

		}
			break;
		case 11:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:50: T22
		{
			mT22();

		}
			break;
		case 12:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:54: T23
		{
			mT23();

		}
			break;
		case 13:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:58: T24
		{
			mT24();

		}
			break;
		case 14:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:62: T25
		{
			mT25();

		}
			break;
		case 15:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:66: T26
		{
			mT26();

		}
			break;
		case 16:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:70: T27
		{
			mT27();

		}
			break;
		case 17:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:74: T28
		{
			mT28();

		}
			break;
		case 18:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:78: T29
		{
			mT29();

		}
			break;
		case 19:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:82: T30
		{
			mT30();

		}
			break;
		case 20:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:86: T31
		{
			mT31();

		}
			break;
		case 21:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:90: T32
		{
			mT32();

		}
			break;
		case 22:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:94: T33
		{
			mT33();

		}
			break;
		case 23:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:98: T34
		{
			mT34();

		}
			break;
		case 24:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:102: T35
		{
			mT35();

		}
			break;
		case 25:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:106: T36
		{
			mT36();

		}
			break;
		case 26:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:110: T37
		{
			mT37();

		}
			break;
		case 27:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:114: RULE_UNLIMITEDLITERAL
		{
			mRULE_UNLIMITEDLITERAL();

		}
			break;
		case 28:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:136: RULE_ID
		{
			mRULE_ID();

		}
			break;
		case 29:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:144: RULE_INT
		{
			mRULE_INT();

		}
			break;
		case 30:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:153: RULE_STRING
		{
			mRULE_STRING();

		}
			break;
		case 31:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:165: RULE_ML_COMMENT
		{
			mRULE_ML_COMMENT();

		}
			break;
		case 32:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:181: RULE_SL_COMMENT
		{
			mRULE_SL_COMMENT();

		}
			break;
		case 33:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:197: RULE_WS
		{
			mRULE_WS();

		}
			break;
		case 34:
			// ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1:205: RULE_ANY_OTHER
		{
			mRULE_ANY_OTHER();

		}
			break;

		}

	}


	protected DFA14 dfa14 = new DFA14(this);

	static final String DFA14_eotS = "\1\uffff\1\35\7\41\4\uffff\1\41\1\60\5\uffff\1\35\1\67\1\uffff\1" + "\35\1\uffff\3\35\3\uffff\2\41\1\uffff\10\41\4\uffff\1\111\11\uffff" + "\1\67\4\uffff\3\41\1\115\10\41\1\uffff\3\41\1\uffff\4\41\1\135\12" + "\41\1\uffff\2\41\1\152\2\41\1\155\1\41\1\157\1\160\1\161\1\162\1" + "\163\2\uffff\1\41\1\uffff\1\165\5\uffff\1\41\1\uffff\1\167\1\uffff";

	static final String DFA14_eofS = "\170\uffff";

	static final String DFA14_minS = "\1\0\1\125\1\146\1\164\1\162\1\156\1\162\2\145\4\uffff\1\156\1\72" + "\5\uffff\1\56\1\60\1\uffff\1\101\1\uffff\2\0\1\52\3\uffff\1\146" + "\1\143\1\uffff\1\162\1\164\1\144\1\151\1\144\1\145\1\141\1\154\4" + "\uffff\1\60\11\uffff\1\60\4\uffff\3\145\1\60\1\145\1\161\2\141\1" + "\144\1\165\1\145\1\165\1\uffff\1\143\1\160\1\141\1\uffff\1\162\1" + "\165\2\164\1\60\1\162\4\164\1\155\4\145\1\uffff\1\156\1\145\1\60" + "\1\72\1\151\1\60\1\144\5\60\2\uffff\1\157\1\uffff\1\60\5\uffff\1" + "\156\1\uffff\1\60\1\uffff";

	static final String DFA14_maxS = "\1\ufffe\1\125\1\170\1\164\1\165\1\160\1\162\2\145\4\uffff\1\156" + "\1\72\5\uffff\1\56\1\71\1\uffff\1\172\1\uffff\2\ufffe\1\57\3\uffff" + "\1\146\1\143\1\uffff\1\162\1\164\1\144\1\151\1\144\1\145\1\164\1" + "\154\4\uffff\1\172\11\uffff\1\71\4\uffff\3\145\1\172\1\145\1\161" + "\2\141\1\144\1\165\1\145\1\165\1\uffff\1\143\1\160\1\141\1\uffff" + "\1\162\1\165\2\164\1\172\1\162\4\164\1\155\4\145\1\uffff\1\156\1" + "\145\1\172\1\72\1\151\1\172\1\144\5\172\2\uffff\1\157\1\uffff\1" + "\172\5\uffff\1\156\1\uffff\1\172\1\uffff";

	static final String DFA14_acceptS = "\11\uffff\1\12\1\13\1\14\1\15\2\uffff\1\23\1\24\1\25\1\30\1\31\2" + "\uffff\1\33\1\uffff\1\34\3\uffff\1\41\1\42\1\1\2\uffff\1\34\10\uffff" + "\1\12\1\13\1\14\1\15\1\uffff\1\27\1\22\1\23\1\24\1\25\1\30\1\31" + "\1\32\1\33\1\uffff\1\36\1\40\1\37\1\41\14\uffff\1\16\3\uffff\1\17" + "\17\uffff\1\7\14\uffff\1\20\1\26\1\uffff\1\3\1\uffff\1\5\1\10\1" + "\6\1\21\1\11\1\uffff\1\4\1\uffff\1\2";

	static final String DFA14_specialS = "\170\uffff}>";

	static final String[] DFA14_transitionS = { "\11\35\2\34\2\35\1\34\22\35\1\34\1\35\1\31\1\13\3\35\1\32\2" + "\35\1\26\1\11\1\21\1\12\1\24\1\33\12\25\1\16\1\35\1\1\4\35\32" + "\30\1\22\1\35\1\23\1\27\1\30\1\35\2\30\1\6\1\10\1\2\3\30\1\15" + "\5\30\1\4\2\30\1\7\1\3\1\30\1\5\5\30\1\17\1\35\1\20\1\14\uff80" + "\35", "\1\36", "\1\37\21\uffff\1\40", "\1\42", "\1\44\2\uffff\1\43", "\1\45\1\uffff\1\46", "\1\47", "\1\50", "\1\51", "", "", "", "", "\1\56", "\1\57", "", "", "", "", "", "\1\66", "\12\70", "", "\32\41\4\uffff\1\41\1\uffff\32\41", "", "\uffff\71", "\uffff\71", "\1\73\4\uffff\1\72", "", "", "", "\1\75", "\1\76", "", "\1\77", "\1\100", "\1\101", "\1\102", "\1\103", "\1\104", "\1\105\22\uffff\1\106", "\1\107", "", "", "", "", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\110\13\41", "", "", "", "", "", "", "", "", "", "\12\70", "", "", "", "", "\1\112", "\1\113", "\1\114", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "\1\116", "\1\117", "\1\120", "\1\121", "\1\122", "\1\123", "\1\124", "\1\125", "", "\1\126", "\1\127", "\1\130", "", "\1\131", "\1\132", "\1\133", "\1\134", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "\1\136", "\1\137", "\1\140", "\1\141", "\1\142", "\1\143", "\1\144", "\1\145", "\1\146", "\1\147", "", "\1\150", "\1\151", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "\1\153", "\1\154", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "\1\156", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "", "", "\1\164", "", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "", "", "", "", "", "\1\166", "", "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41", "" };

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);

	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);

	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);

	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);

	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);

	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);

	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for(int i = 0; i < numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}

		public String getDescription() {
			return "1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | RULE_UNLIMITEDLITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
		}
	}


}
