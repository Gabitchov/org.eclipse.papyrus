lexer grammar InternalVSL;
@header {
package org.eclipse.papyrus.marte.vsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T16 : 'value' ;
T17 : 'import' ;
T18 : 'context' ;
T19 : 'and' ;
T20 : 'or' ;
T21 : 'xor' ;
T22 : '==' ;
T23 : '<>' ;
T24 : '<' ;
T25 : '>' ;
T26 : '<=' ;
T27 : '>=' ;
T28 : '?' ;
T29 : ':' ;
T30 : '+' ;
T31 : '-' ;
T32 : '*' ;
T33 : '/' ;
T34 : 'mod' ;
T35 : 'not' ;
T36 : '.' ;
T37 : '(' ;
T38 : ')' ;
T39 : '::' ;
T40 : ']' ;
T41 : '[' ;
T42 : '..' ;
T43 : '{' ;
T44 : '}' ;
T45 : ',' ;
T46 : '=' ;
T47 : '@' ;
T48 : 'when' ;
T49 : '&' ;
T50 : 'jitter(' ;
T51 : '$' ;
T52 : 'in' ;
T53 : 'out' ;
T54 : 'inout' ;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3481
RULE_INTEGERLITERAL : ('+'|'-')? (('0'..'9')+|'0x' ('0'..'9'|'A'..'F'|'a'..'f')+|'0b' ('0'..'1')+);

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3483
RULE_REALLITERAL : ('+'|'-')? ('0'..'9')+ '.' ('0'..'9')+ ('E' ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3485
RULE_DATETIMELITERAL : (('0'..'1' '0'..'9'|'2' '0'..'3') ':' '0'..'5' '0'..'9' (':' '0'..'5' '0'..'9' (':' '0'..'9' '0'..'9')?)? (' ' '0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')))? (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|'0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')) (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'));

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3487
RULE_BOOLEANLITERAL : ('true'|'false');

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3489
RULE_NULLLITERAL : 'null';

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3491
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3493
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3495
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3497
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3499
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3501
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g" 3503
RULE_ANY_OTHER : .;


