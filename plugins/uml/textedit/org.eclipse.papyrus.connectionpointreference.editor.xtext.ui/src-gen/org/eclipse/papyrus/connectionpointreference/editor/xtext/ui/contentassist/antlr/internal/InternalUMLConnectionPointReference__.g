lexer grammar InternalUMLConnectionPointReference;
@header {
package org.eclipse.papyrus.connectionpointreference.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'entry' ;
T12 : ',' ;
T13 : 'exit' ;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext.ui/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g" 505
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext.ui/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g" 507
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext.ui/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g" 509
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext.ui/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g" 511
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext.ui/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g" 513
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext.ui/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g" 515
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.connectionpointreference.editor.xtext.ui/src-gen/org/eclipse/papyrus/connectionpointreference/editor/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g" 517
RULE_ANY_OTHER : .;


