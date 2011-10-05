lexer grammar InternalUmlCommon;
@header {
package org.eclipse.papyrus.common.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '::' ;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g" 281
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g" 283
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g" 285
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g" 287
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g" 289
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g" 291
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g" 293
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.common.editor.xtext.ui/src-gen/org/eclipse/papyrus/common/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCommon.g" 295
RULE_ANY_OTHER : .;


