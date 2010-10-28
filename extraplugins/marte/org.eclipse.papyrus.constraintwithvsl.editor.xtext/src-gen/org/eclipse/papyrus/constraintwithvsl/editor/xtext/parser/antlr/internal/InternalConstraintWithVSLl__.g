lexer grammar InternalConstraintWithVSLl;
@header {
package org.eclipse.papyrus.constraintwithvsl.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T16 : 'import' ;
T17 : 'context' ;
T18 : 'and' ;
T19 : 'or' ;
T20 : 'xor' ;
T21 : '==' ;
T22 : '<>' ;
T23 : '<' ;
T24 : '>' ;
T25 : '<=' ;
T26 : '>=' ;
T27 : '?' ;
T28 : ':' ;
T29 : '+' ;
T30 : '-' ;
T31 : '*' ;
T32 : '/' ;
T33 : 'mod' ;
T34 : 'not' ;
T35 : '.' ;
T36 : '(' ;
T37 : ')' ;
T38 : '::' ;
T39 : ']' ;
T40 : '[' ;
T41 : '..' ;
T42 : '{' ;
T43 : '}' ;
T44 : ',' ;
T45 : '=' ;
T46 : '@' ;
T47 : 'when' ;
T48 : '&' ;
T49 : 'jitter(' ;
T50 : '$' ;
T51 : 'in' ;
T52 : 'out' ;
T53 : 'inout' ;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3478
RULE_INTEGERLITERAL : ('+'|'-')? (('0'..'9')+|'0x' ('0'..'9'|'A'..'F'|'a'..'f')+|'0b' ('0'..'1')+);

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3480
RULE_REALLITERAL : ('+'|'-')? ('0'..'9')+ '.' ('0'..'9')+ ('E' ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3482
RULE_DATETIMELITERAL : (('0'..'1' '0'..'9'|'2' '0'..'3') ':' '0'..'5' '0'..'9' (':' '0'..'5' '0'..'9' (':' '0'..'9' '0'..'9')?)? (' ' '0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')))? (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|'0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')) (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'));

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3484
RULE_BOOLEANLITERAL : ('true'|'false');

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3486
RULE_NULLLITERAL : 'null';

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3488
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3490
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3492
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3494
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3496
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3498
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g" 3500
RULE_ANY_OTHER : .;


