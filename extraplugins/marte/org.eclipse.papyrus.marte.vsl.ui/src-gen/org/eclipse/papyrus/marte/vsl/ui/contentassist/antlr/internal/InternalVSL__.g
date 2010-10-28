lexer grammar InternalVSL;
@header {
package org.eclipse.papyrus.marte.vsl.ui.contentassist.antlr.internal;

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
T36 : 'value' ;
T37 : 'import' ;
T38 : 'context' ;
T39 : ':' ;
T40 : '.' ;
T41 : '(' ;
T42 : ')' ;
T43 : '::' ;
T44 : '..' ;
T45 : '{' ;
T46 : '}' ;
T47 : ',' ;
T48 : '=' ;
T49 : '@' ;
T50 : 'when' ;
T51 : '&' ;
T52 : 'jitter(' ;
T53 : '$' ;
T54 : '?' ;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7265
RULE_INTEGERLITERAL : ('+'|'-')? (('0'..'9')+|'0x' ('0'..'9'|'A'..'F'|'a'..'f')+|'0b' ('0'..'1')+);

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7267
RULE_REALLITERAL : ('+'|'-')? ('0'..'9')+ '.' ('0'..'9')+ ('E' ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7269
RULE_DATETIMELITERAL : (('0'..'1' '0'..'9'|'2' '0'..'3') ':' '0'..'5' '0'..'9' (':' '0'..'5' '0'..'9' (':' '0'..'9' '0'..'9')?)? (' ' '0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')))? (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|'0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')) (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'));

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7271
RULE_BOOLEANLITERAL : ('true'|'false');

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7273
RULE_NULLLITERAL : 'null';

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7275
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7277
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7279
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7281
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7283
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7285
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g" 7287
RULE_ANY_OTHER : .;


