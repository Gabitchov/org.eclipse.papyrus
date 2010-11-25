lexer grammar InternalUmlCollaborationUse;
@header {
package org.eclipse.papyrus.collaborationuse.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : ':' ;
T13 : '<Undefined>' ;
T14 : '::' ;
T15 : '+' ;
T16 : '-' ;
T17 : '#' ;
T18 : '~' ;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g" 391
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g" 393
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g" 395
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g" 397
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g" 399
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g" 401
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g" 403
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/parser/antlr/internal/InternalUmlCollaborationUse.g" 405
RULE_ANY_OTHER : .;


