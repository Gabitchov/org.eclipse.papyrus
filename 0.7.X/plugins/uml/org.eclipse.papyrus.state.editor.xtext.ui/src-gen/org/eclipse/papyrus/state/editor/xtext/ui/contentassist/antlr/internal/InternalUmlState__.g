lexer grammar InternalUmlState;
@header {
package org.eclipse.papyrus.state.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'Activity' ;
T12 : 'StateMachine' ;
T13 : 'OpaqueBehavior' ;
T14 : 'entry' ;
T15 : 'do' ;
T16 : 'exit' ;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g" 848
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g" 850
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g" 852
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g" 854
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g" 856
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g" 858
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g" 860
RULE_ANY_OTHER : .;


