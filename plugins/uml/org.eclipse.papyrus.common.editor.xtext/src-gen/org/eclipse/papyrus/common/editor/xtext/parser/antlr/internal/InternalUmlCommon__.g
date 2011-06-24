lexer grammar InternalUmlCommon;
@header {
package org.eclipse.papyrus.common.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '::' ;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g" 197
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g" 199
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g" 201
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g" 203
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g" 205
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g" 207
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g" 209
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g" 211
RULE_ANY_OTHER : .;


