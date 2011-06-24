lexer grammar InternalUmlParameter;
@header {
package org.eclipse.papyrus.parameter.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '<Undefined>' ;
T13 : 'exception' ;
T14 : 'stream' ;
T15 : 'ordered' ;
T16 : 'unique' ;
T17 : 'create' ;
T18 : 'read' ;
T19 : 'update' ;
T20 : 'delete' ;
T21 : '+' ;
T22 : '-' ;
T23 : '#' ;
T24 : '~' ;
T25 : 'in' ;
T26 : 'out' ;
T27 : 'inout' ;
T28 : 'return' ;
T29 : ':' ;
T30 : '{' ;
T31 : '}' ;
T32 : ',' ;
T33 : 'effect: ' ;
T34 : '::' ;
T35 : '[' ;
T36 : ']' ;
T37 : '..' ;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g" 1732
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g" 1734
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g" 1736
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g" 1738
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g" 1740
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g" 1742
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g" 1744
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g" 1746
RULE_ANY_OTHER : .;


