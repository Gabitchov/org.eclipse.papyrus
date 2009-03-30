lexer grammar PropertyLabel;
options {
  language=Java;

}
@header {
package org.eclipse.papyrus.parsers.antlr;

import org.eclipse.uml2.uml.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;

import org.eclipse.papyrus.parsers.texteditor.propertylabel.IContext;
}

T54 : '<Undefined>' ;
T55 : 'readOnly' ;
T56 : 'union' ;
T57 : 'ordered' ;
T58 : 'unique' ;
T59 : 'nonunique' ;
T60 : 'subsets' ;
T61 : 'redefines' ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 574
NL 
  : ( '\r' '\n' 
    | '\n' '\r'  //Improbable
    | '\r'
    | '\n'
    )
  { $channel=HIDDEN;}
  ;


// White spaces
// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 585
WS
  : ( ' '
    | '\t'   
    )
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 591
QUESTION_MARK
  : '?'
  ;
  
// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 595
LNOT
  : '!'
  ;
    
// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 599
DOUBLE_QUOTE
  : '\"'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 603
SINGLE_QUOTE  
  : '\''
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 607
LPAREN
  : '('
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 611
RPAREN
  : ')'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 615
LSQUARE
  : '['
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 619
RSQUARE
  : ']'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 623
LCURLY
  : '{'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 627
DOUBLE_LCURLY
  : '{{' ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 630
RCURLY
  : '}'
  ;
  
// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 634
DOUBLE_RCURLY
  : '}}'
  ;
  
// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 638
LOGICAL_AND
  : '&'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 642
DOUBLE_LOGICAL_AND
  : '&&'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 646
PIPE
  : '|'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 650
DOUBLE_PIPE
  : '||'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 654
POINT
  : '.'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 658
POINT_POINT
  : '..'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 662
COMMA
  : ','
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 666
SEMI
  : ';'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 670
SHARP
  : '#'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 674
TILDE
  : '~'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 678
COLON
  : ':'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 682
FOUR_POINTS
  : '::'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 686
RULE_ASSIGN
  : '::=' ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 689
ARROW
  : '->'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 693
STAR
  : '*'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 697
DIV
  : '/'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 701
PLUS
  : '+'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 705
MINUS
  : '-'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 709
EQ
  : '='
  ;


// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 714
ISEQ
  : '=='
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 718
ISNE
  : '!='
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 722
LT : '<';

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 724
DOUBLE_LT
  : '<<'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 728
LE
  : '<='
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 732
GT
  : '>'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 736
DOUBLE_GT
  : '>>'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 740
GE
  : '>='
  ;


// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 745
INCR
  : '++'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 749
DECR
  : '--'
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 753
CALLOPERATION
  : ':='
  ;


// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 758
DIGIT
  : '0'..'9'
  ;


// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 763
ALPHA
  : 'a'..'z' 
  | 'A'..'Z'
  ;


// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 769
UNDERSCORE
  : '_'
  ;


// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 774
INTEGER
  : (DIGIT)+
  ;


// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 779
REAL
  : INTEGER '.' INTEGER
  ;

// $ANTLR src "D:\Workspaces\Ganymede\p2_dev_ws\org.eclipse.papyrus.parsers\resources/grammars/PropertyLabel.g" 783
IDENTIFIER
  : (ALPHA|UNDERSCORE)(ALPHA|DIGIT|UNDERSCORE)*
  ;
  