lexer grammar InternalUmlParameter;
@header {
package org.eclipse.papyrus.parameter.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : ':' ;
T13 : '<Undefined>' ;
T14 : '{' ;
T15 : ',' ;
T16 : '}' ;
T17 : 'effect: ' ;
T18 : '::' ;
T19 : '[' ;
T20 : '..' ;
T21 : ']' ;
T22 : 'exception' ;
T23 : 'stream' ;
T24 : 'ordered' ;
T25 : 'unique' ;
T26 : 'create' ;
T27 : 'read' ;
T28 : 'update' ;
T29 : 'delete' ;
T30 : '+' ;
T31 : '-' ;
T32 : '#' ;
T33 : '~' ;
T34 : 'in' ;
T35 : 'out' ;
T36 : 'inout' ;
T37 : 'return' ;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g" 854
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g" 856
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g" 858
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g" 860
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g" 862
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g" 864
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g" 866
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext/src-gen/org/eclipse/papyrus/parameter/editor/xtext/parser/antlr/internal/InternalUmlParameter.g" 868
RULE_ANY_OTHER : .;


