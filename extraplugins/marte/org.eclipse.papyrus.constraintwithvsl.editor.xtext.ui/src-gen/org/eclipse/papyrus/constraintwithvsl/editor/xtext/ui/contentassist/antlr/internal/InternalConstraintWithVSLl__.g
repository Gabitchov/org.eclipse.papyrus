lexer grammar InternalConstraintWithVSLl;
@header {
package org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T16 : 'and' ;
T17 : 'or' ;
T18 : 'xor' ;
T19 : '==' ;
T20 : '<>' ;
T21 : '<' ;
T22 : '>' ;
T23 : '<=' ;
T24 : '>=' ;
T25 : '+' ;
T26 : '-' ;
T27 : '*' ;
T28 : '/' ;
T29 : 'mod' ;
T30 : 'not' ;
T31 : ']' ;
T32 : '[' ;
T33 : 'in' ;
T34 : 'out' ;
T35 : 'inout' ;
T36 : 'import' ;
T37 : 'context' ;
T38 : ':' ;
T39 : '.' ;
T40 : '(' ;
T41 : ')' ;
T42 : '::' ;
T43 : '..' ;
T44 : '{' ;
T45 : '}' ;
T46 : ',' ;
T47 : '=' ;
T48 : '@' ;
T49 : 'when' ;
T50 : '&' ;
T51 : 'jitter(' ;
T52 : '$' ;
T53 : '?' ;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7130
RULE_INTEGERLITERAL : ('+'|'-')? (('0'..'9')+|'0x' ('0'..'9'|'A'..'F'|'a'..'f')+|'0b' ('0'..'1')+);

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7132
RULE_REALLITERAL : ('+'|'-')? ('0'..'9')+ '.' ('0'..'9')+ ('E' ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7134
RULE_DATETIMELITERAL : (('0'..'1' '0'..'9'|'2' '0'..'3') ':' '0'..'5' '0'..'9' (':' '0'..'5' '0'..'9' (':' '0'..'9' '0'..'9')?)? (' ' '0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')))? (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|'0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')) (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'));

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7136
RULE_BOOLEANLITERAL : ('true'|'false');

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7138
RULE_NULLLITERAL : 'null';

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7140
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7142
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7144
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7146
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7148
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7150
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/ui/contentassist/antlr/internal/InternalConstraintWithVSLl.g" 7152
RULE_ANY_OTHER : .;


