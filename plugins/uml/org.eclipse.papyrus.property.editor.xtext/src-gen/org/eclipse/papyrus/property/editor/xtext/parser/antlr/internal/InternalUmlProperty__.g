lexer grammar InternalUmlProperty;
@header {
package org.eclipse.papyrus.property.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '/' ;
T13 : ':' ;
T14 : '<Undefined>' ;
T15 : '::' ;
T16 : '[' ;
T17 : '..' ;
T18 : ']' ;
T19 : '{' ;
T20 : ',' ;
T21 : '}' ;
T22 : 'redefines' ;
T23 : 'subsets' ;
T24 : '=' ;
T25 : '+' ;
T26 : '-' ;
T27 : '#' ;
T28 : '~' ;
T29 : 'readOnly' ;
T30 : 'union' ;
T31 : 'ordered' ;
T32 : 'unique' ;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 909
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 911
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 913
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 915
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 917
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 919
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 921
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 923
RULE_ANY_OTHER : .;


