lexer grammar InternalUmlState;
@header {
package org.eclipse.papyrus.state.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : ':' ;
T12 : '::' ;
T13 : 'entry' ;
T14 : 'do' ;
T15 : 'exit' ;
T16 : 'Activity' ;
T17 : 'StateMachine' ;
T18 : 'OpaqueBehavior' ;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 654
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 656
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 658
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 660
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 662
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 664
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g" 666
RULE_ANY_OTHER : .;


