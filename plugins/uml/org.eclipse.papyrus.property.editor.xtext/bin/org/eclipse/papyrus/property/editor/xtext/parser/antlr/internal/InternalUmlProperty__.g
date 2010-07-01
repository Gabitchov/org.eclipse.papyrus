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
T15 : '[' ;
T16 : '..' ;
T17 : ']' ;
T18 : '{' ;
T19 : ',' ;
T20 : '}' ;
T21 : '+' ;
T22 : '-' ;
T23 : '#' ;
T24 : '~' ;
T25 : 'readOnly' ;
T26 : 'union' ;
T27 : 'ordered' ;
T28 : 'unique' ;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 566
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 568
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 570
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 572
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 574
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 576
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 578
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g" 580
RULE_ANY_OTHER : .;


