lexer grammar InternalUMLConnectionPointReference;
@header {
package org.eclipse.papyrus.connectionpointreference.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'entry' ;
T12 : ',' ;
T13 : 'exit' ;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g" 172
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g" 174
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g" 176
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g" 178
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g" 180
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g" 182
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/parser/antlr/internal/InternalUMLConnectionPointReference.g" 184
RULE_ANY_OTHER : .;


