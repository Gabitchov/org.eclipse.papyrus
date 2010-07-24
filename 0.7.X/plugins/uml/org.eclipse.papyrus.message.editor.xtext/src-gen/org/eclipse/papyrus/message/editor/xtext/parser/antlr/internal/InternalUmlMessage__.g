lexer grammar InternalUmlMessage;
@header {
package org.eclipse.papyrus.message.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '.' ;
T13 : ':' ;
T14 : '*' ;
T15 : '[' ;
T16 : ']' ;

// $ANTLR src "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g" 342
RULE_NAMERULE : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'-'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g" 344
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g" 346
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g" 348
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g" 350
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g" 352
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g" 354
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.message.editor.xtext/src-gen/org/eclipse/papyrus/message/editor/xtext/parser/antlr/internal/InternalUmlMessage.g" 356
RULE_ANY_OTHER : .;


