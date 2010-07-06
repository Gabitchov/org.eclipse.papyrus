lexer grammar InternalUmlState;
@header {
package org.eclipse.papyrus.state.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'entry' ;
T12 : 'do' ;
T13 : 'exit' ;
T14 : 'Activity' ;
T15 : 'StateMachine' ;
T16 : 'OpaqueBehavior' ;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 500
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 502
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 504
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 506
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 508
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 510
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 512
RULE_ANY_OTHER : .;


