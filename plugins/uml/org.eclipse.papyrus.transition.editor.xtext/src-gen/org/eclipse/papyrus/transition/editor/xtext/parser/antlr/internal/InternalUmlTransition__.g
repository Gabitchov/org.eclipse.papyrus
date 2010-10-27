lexer grammar InternalUmlTransition;
@header {
package org.eclipse.papyrus.transition.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : ',' ;
T12 : 'all' ;
T13 : 'after' ;
T14 : 'at' ;
T15 : 'when' ;
T16 : '[' ;
T17 : ']' ;
T18 : '/' ;
T19 : 'Activity' ;
T20 : 'StateMachine' ;
T21 : 'OpaqueBehavior' ;

// $ANTLR src "../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g" 695
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g" 697
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g" 699
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g" 701
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g" 703
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g" 705
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g" 707
RULE_ANY_OTHER : .;


