lexer grammar InternalUmlProperty;
@header {
package org.eclipse.papyrus.property.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '<Undefined>' ;
T13 : '+' ;
T14 : '-' ;
T15 : '#' ;
T16 : '~' ;
T17 : 'readOnly' ;
T18 : 'union' ;
T19 : 'ordered' ;
T20 : 'unique' ;
T21 : ':' ;
T22 : '::' ;
T23 : '[' ;
T24 : ']' ;
T25 : '..' ;
T26 : '{' ;
T27 : '}' ;
T28 : ',' ;
T29 : 'redefines' ;
T30 : 'subsets' ;
T31 : '=' ;
T32 : '/' ;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g" 1838
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g" 1840
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g" 1842
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g" 1844
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g" 1846
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g" 1848
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g" 1850
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.property.editor.xtext.ui/src-gen/org/eclipse/papyrus/property/editor/xtext/ui/contentassist/antlr/internal/InternalUmlProperty.g" 1852
RULE_ANY_OTHER : .;


