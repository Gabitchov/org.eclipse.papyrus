package org.eclipse.papyrus.marte.vsl.extensions;

import org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression;
import org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.DataTypeName;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsName;
import org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsName;
import org.eclipse.papyrus.marte.vsl.vSL.Interval;
import org.eclipse.papyrus.marte.vsl.vSL.JitterExp;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValues;
import org.eclipse.papyrus.marte.vsl.vSL.Literal;
import org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.QualifiedName;
import org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.StringLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression;
import org.eclipse.papyrus.marte.vsl.vSL.TimeExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Tuple;
import org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;
import org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification;
import org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration;

public class VSLSerializationUtil {

	public static String printExpression(Expression exp) {
		return printAndOrXorExpression(exp.getExp()) ;
	}
	
	public static String printAndOrXorExpression(AndOrXorExpression exp) {
		String stringRep = "" + printEqualityExpression(exp.getExp().get(0)) ;
		for (int i = 1 ; i < exp.getExp().size() ; i++) {
			stringRep += " " + exp.getOp().get(i-1) + " " + printEqualityExpression(exp.getExp().get(i)) ;
		}
		return stringRep ;
	}
	
	public static String printEqualityExpression(EqualityExpression exp) {
		String stringRep = "" + printRelationalExpression(exp.getExp().get(0)) ;
		for (int i = 1 ; i < exp.getExp().size() ; i++) {
			stringRep += " " + exp.getOp().get(i-1) + " " + printRelationalExpression(exp.getExp().get(i)) ;
		}
		return stringRep ;
	}
	
	public static String printRelationalExpression(RelationalExpression exp) {
		String stringRep = "" + printConditionalExpression(exp.getExp().get(0)) ;
		for (int i = 1 ; i < exp.getExp().size() ; i++) {
			stringRep += " " + exp.getOp().get(i-1) + " " + printConditionalExpression(exp.getExp().get(i)) ;
		}
		return stringRep ;
	}
	
	public static String printConditionalExpression(ConditionalExpression exp) {
		String stringRep = "" + printAdditiveExpression(exp.getExp().get(0)) ;
		if (exp.getExp().size() == 3) {
			stringRep += " ? " 
						+ printAdditiveExpression(exp.getExp().get(1)) 
						+ " : " 
						+ printAdditiveExpression(exp.getExp().get(2)) ;
		}
		return stringRep ;
	}
	
	public static String printAdditiveExpression(AdditiveExpression exp) {
		String stringRep = "" + printMultiplicativeExpression(exp.getExp().get(0)) ;
		for (int i = 1 ; i < exp.getExp().size() ; i++) {
			stringRep += " " + exp.getOp().get(i-1) + " " + printMultiplicativeExpression(exp.getExp().get(i)) ;
		}
		return stringRep ;
	}
	
	public static String printMultiplicativeExpression(MultiplicativeExpression exp) {
		String stringRep = "" + printUnaryExpression(exp.getExp().get(0)) ;
		for (int i = 1 ; i < exp.getExp().size() ; i++) {
			stringRep += " " + exp.getOp().get(i-1) + " " + printUnaryExpression(exp.getExp().get(i)) ;
		}
		return stringRep ;
	}
	
	public static String printUnaryExpression(UnaryExpression exp) {
		String stringRep = "" ;
		if (exp.getUnary() != null) {
			stringRep += exp.getOp() + " " + printUnaryExpression(exp.getUnary()) ;
		}
		else {
			stringRep += printPrimaryExpression(exp.getExp()) ;
		}
		return stringRep ;
	}
	
	public static String printPrimaryExpression(PrimaryExpression exp) {
		String stringRep = "" + printValueSpecification(exp.getPrefix());
		if (exp.getSuffix() != null) {
			stringRep += "." + printSuffixExpression(exp.getSuffix()) ;
		}
		return stringRep ;
	}
	
	public static String printSuffixExpression(SuffixExpression suffix) {
		if (suffix instanceof PropertyCallExpression)
			return printPropertyCallExpression((PropertyCallExpression)suffix) ;
		// suffix instanceof OperationCallExpression
		return printOperationCallExpression((OperationCallExpression)suffix) ;
	}

	public static String printOperationCallExpression(OperationCallExpression suffix) {
		String stringRep = "" + suffix.getOperation().getName() + "(";
		if (suffix.getArguments() != null)
			stringRep+=printListOfValues(suffix.getArguments()) ;
		stringRep += ")" ;
		if (suffix.getSuffix() != null)
			stringRep += "." + printSuffixExpression(suffix.getSuffix()) ;
		return stringRep;
	}

	public static String printPropertyCallExpression(PropertyCallExpression suffix) {
		String stringRep = "" + suffix.getProperty().getName() ;
		if (suffix.getSuffix() != null)
			stringRep += "." + printSuffixExpression(suffix.getSuffix()) ;
		return stringRep;
	}

	public static String printValueSpecification(ValueSpecification exp) {
		if (exp instanceof StringLiteralRule)
			return "\"" + ((Literal)exp).getValue() + "\"" ;
		else if (exp instanceof Literal)
			return ((Literal)exp).getValue() ;
		else if (exp instanceof NameOrChoiceOrBehaviorCall) {
			return printNameOrChoiceOrBehaviorCall((NameOrChoiceOrBehaviorCall)exp) ;
		}
		else if (exp instanceof Interval) {
			return printInterval((Interval)exp) ;
		}
		else if (exp instanceof CollectionOrTuple) {
			return printCollectionOrTuple((CollectionOrTuple)exp) ;
		}
		else if (exp instanceof Tuple) {
			return printTuple((Tuple)exp) ;
		}
		else if (exp instanceof TimeExpression) {
			return printTimeExpression((TimeExpression)exp) ;
		}
		else if (exp instanceof VariableDeclaration) {
			return printVariableDeclaration((VariableDeclaration)exp) ;
		}
		else if (exp instanceof Expression) {
			return "(" + printExpression((Expression)exp) + ")" ;
		}
		return "" ; // should not occur
	}

	public static String printVariableDeclaration(VariableDeclaration exp) {
		String stringRep = "" ;
		if (exp.getVariableDeclaration() != null && !exp.getVariableDeclaration().equals("")) {
			stringRep += exp.getVariableDeclaration() + " " ;
		}
		stringRep += "$" + exp.getName() ;
		if (exp.getType() != null)
			stringRep += " : " + printDataTypeName(exp.getType()) ;
		if (exp.getInitValue() != null)
			stringRep += " = (" + printExpression(exp.getInitValue()) + ")" ;
			return stringRep ;
	}

	public static String printDataTypeName(DataTypeName type) {
		String stringRep = "" ;
		if (type.getPath() != null)
			stringRep += printQualifiedName(type.getPath()) ;
		stringRep += type.getType().getName() ;
		return stringRep;
	}

	public static String printTimeExpression(TimeExpression exp) {
		if (exp instanceof InstantObsExpression)
			return printInstantObsExpression((InstantObsExpression)exp) ;
		if (exp instanceof DurationObsExpression)
			return printDurationObsExpression((DurationObsExpression)exp) ;
		// exp instanceof JitterExp
		return printJitterExp((JitterExp)exp) ;
	}

	public static String printJitterExp(JitterExp exp) {
		String stringRep = "jitter(" ;
		stringRep += printInstantObsExpression(exp.getFirstInstant()) ;
		if (exp.getSecondInstant() != null)
			stringRep += " - " + printInstantObsExpression(exp.getSecondInstant()) ;
		stringRep += ")" ;
		return stringRep ;
	}

	public static String printInstantObsExpression(InstantObsExpression exp) {
		String stringRep = "@" + printInstantObsName(exp.getId());
		if (exp.getIndex() != null)
			stringRep += "(" + printExpression(exp.getIndex()) + ")" ;
		if (exp.getCondition() != null)
			stringRep += " when (" + printExpression(exp.getCondition()) + ")" ;
		return stringRep ;
	}

	public static String printInstantObsName(InstantObsName id) {
		String stringRep = "" ;
		if (id.getPath() != null)
			stringRep += printQualifiedName(id.getPath()) ;
		stringRep+=id.getInstantId().getName() ;
		return stringRep;
	}
	
	public static String printDurationObsExpression(DurationObsExpression exp) {
		String stringRep = "&" + printDurationObsName(exp.getId());
		if (exp.getIndex() != null)
			stringRep += "(" + printExpression(exp.getIndex()) + ")" ;
		if (exp.getCondition() != null)
			stringRep += " when (" + printExpression(exp.getCondition()) + ")" ;
		return stringRep ;
	}

	public static String printDurationObsName(DurationObsName id) {
		String stringRep = "" ;
		if (id.getPath() != null)
			stringRep += printQualifiedName(id.getPath()) ;
		stringRep+=id.getDurationId().getName() ;
		return stringRep;
	}

	public static String printTuple(Tuple exp) {
		String stringRep = "{" ;
		stringRep += printListOfValueNamePairs(exp.getListOfValueNamePairs()) ;
		stringRep += "}" ;
		return stringRep ;
	}

	
	
	public static String printListOfValueNamePairs(ListOfValueNamePairs listOfValueNamePairs) {
		String stringRep = "" ;
		boolean first = true ;
		for (ValueNamePair exp : listOfValueNamePairs.getValueNamePairs()) {
			if (first) {
				first = false ;
			}
			else {
				stringRep += ", " ;
			}
			stringRep+= printValueNamePair(exp) ;
		}
		return stringRep;
	}

	
	
	public static String printValueNamePair(ValueNamePair exp) {
		String stringRep = "" ;
		stringRep += exp.getProperty().getName()
					+ " = "
					+ printExpression(exp.getValue()) ;
		return stringRep ;
	}

	public static String printCollectionOrTuple(CollectionOrTuple exp) {
		String stringRep = "{" ;
		stringRep += printListOfValues(exp.getListOfValues()) ;
		stringRep += "}" ;
		return stringRep;
	}

	public static String printInterval(Interval exp) {
		String stringRep = "" ;
		stringRep+= (exp.getIsLowerIncluded()!= null && ! exp.getIsLowerIncluded().equals("")) ? "[" : "]" ;
		stringRep+= printExpression(exp.getLower()) ;
		stringRep+= " .. " ;
		stringRep+= printExpression(exp.getUpper()) ;
		stringRep+= (exp.getIsUpperIncluded()!= null && ! exp.getIsUpperIncluded().equals("")) ? "]" : "[" ;
		return stringRep ;
	}

	public static String printNameOrChoiceOrBehaviorCall(NameOrChoiceOrBehaviorCall exp) {
		String stringRep = "" ;
		if (exp.getPath() != null)
			stringRep += printQualifiedName(exp.getPath()) ;
		stringRep+=exp.getId().getName() ;
		if (exp.getArguments() != null) {
			stringRep+= "(" + printListOfValues(exp.getArguments()) + ")" ;
		}
		return stringRep;
	}

	public static String printListOfValues(ListOfValues arguments) {
		String stringRep = "" ;
		boolean first = true ;
		for (Expression exp : arguments.getValues()) {
			if (first) {
				first = false ;
			}
			else {
				stringRep += ", " ;
			}
			stringRep+= printExpression(exp) ;
		}
		return stringRep;
	}

	public static String printQualifiedName(QualifiedName exp) {
		String stringRep = exp.getPath().getName() + "::" ;
		if (exp.getRemaining()!=null)
			stringRep += printQualifiedName(exp.getRemaining()) ;
		return stringRep;
	}
	
	public static NameOrChoiceOrBehaviorCall extractNameReference(Expression exp) {
		return isANameOrBehaviorCall(exp.getExp()) ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(AndOrXorExpression exp) {
		return isANameOrBehaviorCall(exp.getExp().get(0)) ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(EqualityExpression exp) {
		return isANameOrBehaviorCall(exp.getExp().get(0)) ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(RelationalExpression exp) {
		return isANameOrBehaviorCall(exp.getExp().get(0)) ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(ConditionalExpression exp) {
		if (exp.getExp().size() == 1)
			return isANameOrBehaviorCall(exp.getExp().get(0)) ;
		if (exp.getExp().size() == 3) {
			NameOrChoiceOrBehaviorCall coll = isANameOrBehaviorCall(exp.getExp().get(1)) ;
			return coll != null ? isANameOrBehaviorCall(exp.getExp().get(2)) : null ;
		}
		return null ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(AdditiveExpression exp) {
		return isANameOrBehaviorCall(exp.getExp().get(0)) ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(MultiplicativeExpression exp) {
		return exp.getExp().isEmpty() ? null : isANameOrBehaviorCall(exp.getExp().get(0)) ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(UnaryExpression exp) {
		return isANameOrBehaviorCall(exp.getExp()) ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(PrimaryExpression exp) {
		return exp.getSuffix() == null ? isANameOrBehaviorCall(exp.getPrefix()) : null ;
	}
	
	private static NameOrChoiceOrBehaviorCall isANameOrBehaviorCall(ValueSpecification exp) {
		return exp instanceof NameOrChoiceOrBehaviorCall ? (NameOrChoiceOrBehaviorCall) exp : null ;
	}
}
	
