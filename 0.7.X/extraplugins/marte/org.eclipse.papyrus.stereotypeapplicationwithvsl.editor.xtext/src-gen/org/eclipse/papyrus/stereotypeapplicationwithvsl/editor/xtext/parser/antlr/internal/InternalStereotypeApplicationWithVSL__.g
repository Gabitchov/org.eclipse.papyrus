lexer grammar InternalStereotypeApplicationWithVSL;
@header {
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T16 : '<<' ;
T17 : '>>' ;
T18 : ',' ;
T19 : '->' ;
T20 : '=' ;
T21 : 'import' ;
T22 : 'context' ;
T23 : 'and' ;
T24 : 'or' ;
T25 : 'xor' ;
T26 : '==' ;
T27 : '<>' ;
T28 : '<' ;
T29 : '>' ;
T30 : '<=' ;
T31 : '>=' ;
T32 : '?' ;
T33 : ':' ;
T34 : '+' ;
T35 : '-' ;
T36 : '*' ;
T37 : '/' ;
T38 : 'mod' ;
T39 : 'not' ;
T40 : '.' ;
T41 : '(' ;
T42 : ')' ;
T43 : '::' ;
T44 : ']' ;
T45 : '[' ;
T46 : '..' ;
T47 : '{' ;
T48 : '}' ;
T49 : '@' ;
T50 : 'when' ;
T51 : '&' ;
T52 : 'jitter(' ;
T53 : '$' ;
T54 : 'in' ;
T55 : 'out' ;
T56 : 'inout' ;

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3723
RULE_INTEGERLITERAL : ('+'|'-')? (('0'..'9')+|'0x' ('0'..'9'|'A'..'F'|'a'..'f')+|'0b' ('0'..'1')+);

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3725
RULE_REALLITERAL : ('+'|'-')? ('0'..'9')+ '.' ('0'..'9')+ ('E' ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3727
RULE_DATETIMELITERAL : (('0'..'1' '0'..'9'|'2' '0'..'3') ':' '0'..'5' '0'..'9' (':' '0'..'5' '0'..'9' (':' '0'..'9' '0'..'9')?)? (' ' '0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')))? (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|'0'..'9' '0'..'9' '0'..'9' '0'..'9' '/' ('0' '0'..'9'|'1' '0'..'2') '/' ('0'..'2' '0'..'9'|'3' ('0'|'1')) (' ' ('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'))?|('Mon'|'Tue'|'Wed'|'Thr'|'Fri'|'Sat'|'Sun'));

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3729
RULE_BOOLEANLITERAL : ('true'|'false');

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3731
RULE_NULLLITERAL : 'null';

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3733
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3735
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3737
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3739
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3741
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3743
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g" 3745
RULE_ANY_OTHER : .;


