lexer grammar InternalUmlCollaborationUse;
@header {
package org.eclipse.papyrus.collaborationuse.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '<Undefined>' ;
T13 : '+' ;
T14 : '-' ;
T15 : '#' ;
T16 : '~' ;
T17 : ':' ;
T18 : '::' ;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g" 675
RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g" 677
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g" 679
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g" 681
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g" 683
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g" 685
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g" 687
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.collaborationuse.editor.xtext.ui/src-gen/org/eclipse/papyrus/collaborationuse/editor/xtext/ui/contentassist/antlr/internal/InternalUmlCollaborationUse.g" 689
RULE_ANY_OTHER : .;


