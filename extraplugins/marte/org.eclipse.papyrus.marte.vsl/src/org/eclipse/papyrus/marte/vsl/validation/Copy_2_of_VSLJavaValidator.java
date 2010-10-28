package org.eclipse.papyrus.marte.vsl.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package; 
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.xtext.validation.Check;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.marte.vsl.extensions.VSLTypeInferenceUtil;
import org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression;
import org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Context;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.Model;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;  
import org.eclipse.papyrus.marte.vsl.vSL.Tuple;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;

public class Copy_2_of_VSLJavaValidator extends AbstractVSLJavaValidator {
	
	private static Namespace model ;
	private static Element contextElement ;
	private static Type expectedType ;
	
	public static Type _integer ;
	public static Type _unlimitedNatural ;
	public static Type _real ;
	public static Type _datetime ;
	public static Type _boolean ;
	public static Type _string ;
	
	public static Map<String, Type> opSignatures ;
	
	public static void init(Element _contextElement) {
		contextElement = _contextElement ;
		if (contextElement != null) {
			Element elem = contextElement.getOwner() ;
			while (elem.getOwner() != null) {
				elem = elem.getOwner() ;
			}
			model = (Namespace)elem ;
			boolean typesResolved = false ;
			for (Package importedPackage : model.getImportedPackages()) {
				if (!typesResolved)
					typesResolved = initPredefinedTypes(importedPackage) ;
			}
			if (typesResolved) initPredefinedOpSignatures() ;
		}
	}
	
	/**
	 * @param typeLibrary
	 * @return 
	 */
	private static boolean initPredefinedTypes (Package typeLibrary) {
		for (Element elem : typeLibrary.allOwnedElements()) {
			if (elem instanceof Type) {
				Type t = (Type)elem ;
				if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::Boolean"))
					_boolean = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::Integer"))
					_integer = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::String"))
					_string = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::UnlimitedNatural"))
					_unlimitedNatural = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::Real"))
					_real = t ;
				else if (t.getQualifiedName().equals("MARTE_Library::MARTE_PrimitivesTypes::DateTime"))
					_datetime = t ;
			}
		}
		return _integer != null &&
				_unlimitedNatural != null &&
				_real != null &&
				_datetime != null &&
				_boolean != null &&
				_string != null;
	}
	
	/**
	 * 
	 */
	private static void initPredefinedOpSignatures() {
		opSignatures = new HashMap<String, Type>();
		
		//unary ops
		opSignatures.put("+(" + _integer.getName() + ")", _integer) ;		// +(int) : int
		opSignatures.put("+(" + _real.getName() + ")", _real) ;				// +(real) : real
		opSignatures.put("-(" + _integer.getName() + ")", _integer) ;		// -(int) : int
		opSignatures.put("-(" + _real.getName() + ")", _real) ;				// -(real) : real
		opSignatures.put("not(" + _boolean.getName() + ")", _boolean) ;		// not(boolean) : boolean
		
		//binary ops

		// and, or, xor
		opSignatures.put("and(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// and(boolean, boolean) : boolean
		opSignatures.put("or(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// or(boolean, boolean) : boolean
		opSignatures.put("xor(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// xor(boolean, boolean) : boolean
		
		// ==, <>
		opSignatures.put("==(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// ==(int, int) : boolean
		opSignatures.put("==(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// ==(real, real) : boolean
		opSignatures.put("==(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// ==(int, real) : boolean
		opSignatures.put("==(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// ==(real, int) : boolean
		opSignatures.put("==(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// ==(boolean, boolean) : boolean
		opSignatures.put("==(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// ==(string, string) : boolean
		opSignatures.put("<>(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// <>(int, int) : boolean
		opSignatures.put("<>(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// <>(real, real) : boolean
		opSignatures.put("<>(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// <>(int, real) : boolean
		opSignatures.put("<>(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// <>(real, int) : boolean
		opSignatures.put("<>(" + _boolean.getName() + ',' + _boolean.getName() + ")", _boolean) ;// <>(boolean, boolean) : boolean
		opSignatures.put("<>(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// <>(string, string) : boolean
		
		//'<' | '>' | '<=' | '>='
		opSignatures.put("<(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// <(int, int) : boolean
		opSignatures.put("<(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// <(real, real) : boolean
		opSignatures.put("<(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// <(int, real) : boolean
		opSignatures.put("<(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// <(real, int) : boolean
		opSignatures.put("<(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// <(string, string) : boolean
		opSignatures.put(">(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// >(int, int) : boolean
		opSignatures.put(">(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// >(real, real) : boolean
		opSignatures.put(">(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// >(int, real) : boolean
		opSignatures.put(">(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// >(real, int) : boolean
		opSignatures.put(">(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// >(string, string) : boolean
		opSignatures.put("<=(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// <=(int, int) : boolean
		opSignatures.put("<=(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// <=(real, real) : boolean
		opSignatures.put("<=(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// <=(int, real) : boolean
		opSignatures.put("<=(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// <=(real, int) : boolean
		opSignatures.put("<=(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// <=(string, string) : boolean
		opSignatures.put(">=(" + _integer.getName() + ',' + _integer.getName() + ")", _boolean) ;// >=(int, int) : boolean
		opSignatures.put(">=(" + _real.getName() + ',' + _real.getName() + ")", _boolean) ;// >=(real, real) : boolean
		opSignatures.put(">=(" + _integer.getName() + ',' + _real.getName() + ")", _boolean) ;// >=(int, real) : boolean
		opSignatures.put(">=(" + _real.getName() + ',' + _integer.getName() + ")", _boolean) ;// >=(real, int) : boolean
		opSignatures.put(">=(" + _string.getName() + ',' + _string.getName() + ")", _boolean) ;// >=(string, string) : boolean
		
		//'*' | '/' | 'mod'
		opSignatures.put("*(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// *(int, int) : int
		opSignatures.put("*(" + _real.getName() + ',' + _real.getName() + ")", _real) ;// *(real, real) : real
		opSignatures.put("*(" + _real.getName() + ',' + _integer.getName() + ")", _real) ;// *(real, int) : real
		opSignatures.put("*(" + _integer.getName() + ',' + _real.getName() + ")", _real) ;// *(int, real) : real
		opSignatures.put("/(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// /(int, int) : int
		opSignatures.put("/(" + _real.getName() + ',' + _real.getName() + ")", _real) ;// /(real, real) : real
		opSignatures.put("/(" + _real.getName() + ',' + _integer.getName() + ")", _real) ;// /(real, int) : real
		opSignatures.put("/(" + _integer.getName() + ',' + _real.getName() + ")", _real) ;// /(int, real) : real// /(int, int) : int
		opSignatures.put("mod(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// mod(int, int) : int
		
		//'+' | '-'
		opSignatures.put("+(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// +(int, int) : int
		opSignatures.put("+(" + _real.getName() + ',' + _real.getName() + ")", _real) ;// +(real, real) : real
		opSignatures.put("+(" + _real.getName() + ',' + _integer.getName() + ")", _real) ;// +(real, int) : real
		opSignatures.put("+(" + _integer.getName() + ',' + _real.getName() + ")", _real) ;// +(int, real) : real
		opSignatures.put("+(" + _datetime.getName() + ',' + _real.getName() + ")", _datetime) ;// +(date, real) : date
		opSignatures.put("+(" + _real.getName() + ',' + _datetime.getName() + ")", _datetime) ;// +(real, date) : date
		
		opSignatures.put("-(" + _integer.getName() + ',' + _integer.getName() + ")", _integer) ;// _(int, int) : int
		opSignatures.put("-(" + _real.getName() + ',' + _real.getName() + ")", _real) ;// -(real, real) : real
		opSignatures.put("-(" + _real.getName() + ',' + _integer.getName() + ")", _real) ;// -(real, int) : real
		opSignatures.put("-(" + _integer.getName() + ',' + _real.getName() + ")", _real) ;// -(int, real) : real
		opSignatures.put("-(" + _datetime.getName() + ',' + _datetime.getName() + ")", _real) ;// -(date, date) : real
	}
	
	public static void setExpectedType(Type _expectedType) {
		expectedType = _expectedType;
	}

	public static Type getExpectedType() {
		return expectedType;
	}
	
	public static Namespace getModel() {
		return model ;
	}
	
	public static Element getContextElement() {
		return contextElement ;
	}
	
//	@Check
//	public void checkExpressionRule(Expression exp) {
//		//if (exp.eContainer() instanceof Model) {
//			Type inferedType = new VSLTypeInferenceUtil(model, contextElement, expectedType).typeOfExpression(exp);
//			if (inferedType == null) {
//				error ("Could not infer type of expression", null) ;
//			}
//			else {
//				warning("Type of expression: " + inferedType.getName(), null) ;
//			}
//		//}
//	}
	
	@Check
	public void NameOrChoiceOrBehaviorCall(NameOrChoiceOrBehaviorCall exp) {
		if (exp.getId() != null) {
			if (exp.getId() instanceof Behavior) {
				// this is a behavior call expression
				if (exp.getArguments() == null) {
					error("Arguments are missing for call to behavior " + exp.getId().getQualifiedName(),
							VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL) ;
				}
				else {
					int nbOfParametersForBehavior = 0 ;
					for (Parameter p : ((Behavior)exp.getId()).getOwnedParameters())
						if (p.getDirection()!= ParameterDirectionKind.RETURN_LITERAL)
							nbOfParametersForBehavior ++ ;
					if (nbOfParametersForBehavior != exp.getArguments().getValues().size()) {
						error ("Invalid number of arguments for call to behavior " + exp.getId().getQualifiedName(),
							VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL) ;
					}
					else {
						// TODO: type verification on arguments
					}
						
				}
			}
			else if ((exp.getId().getNamespace() != null &&
						exp.getId().getNamespace()
							.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType") != null)) {
				if (exp.getArguments() == null) {
					error("Argument is missing for the chosen alternative " + exp.getId().getName(),
							VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL) ;
				}
				else if (exp.getArguments().getValues().size() > 1) {
					error("There must be one single argument for the chosen alternative " + exp.getId().getName(),
							VSLPackage.NAME_OR_CHOICE_OR_BEHAVIOR_CALL) ;
				}
				else {
					Type inferedType = new VSLTypeInferenceUtil(((TypedElement)exp.getId()).getType())
												.typeOfExpression(exp.getArguments().getValues().get(0)) ;
					if (inferedType != ((TypedElement)exp.getId()).getType()) {
						String message = "" +
						(inferedType == null ? 
								"Could not infer type of expression. " :
									"Found an expression of type " + inferedType.getName()+ ". ");
						message += "Expecting an expression of type " 
									+ ((TypedElement)exp.getId()).getType().getName() 
									+ ".";
						error(message, exp.getArguments().getValues().get(0), VSLPackage.EXPRESSION__EXP) ;
					}
				}
			}
		}
	}

	@Check
	public void TupleExpression(Tuple exp) {
		//if (VSLJavaValidator.expectedKind != ExpectedKind._TUPLE)
		//	return ;
		if (exp.getListOfValueNamePairs() == null) {
			error("Arguments are missing for the tuple " + exp.getExpectedType().getName(),
					VSLPackage.TUPLE__LIST_OF_VALUE_NAME_PAIRS) ;
		}
		else {
			List<Property> referencedProperties = new ArrayList<Property>() ;
			for (ValueNamePair valueNamePair : exp.getListOfValueNamePairs().getValueNamePairs()) {
				if (valueNamePair.getProperty() != null)
					referencedProperties.add(valueNamePair.getProperty()) ;
			}
			//if (! ((Classifier)exp.getExpectedType()).getAttributes().containsAll(referencedProperties))
			//	return ;
			
			for (ValueNamePair valueNamePair : exp.getListOfValueNamePairs().getValueNamePairs()) {
				Type expectedType = valueNamePair.getProperty() != null ? 
										valueNamePair.getProperty().getType() :
									null ;
				Type inferedType = new VSLTypeInferenceUtil(expectedType).typeOfExpression(valueNamePair.getValue()) ;
				if (inferedType != expectedType) {
					String message = "" +
					(inferedType == null ? 
							"Could not infer type of expression. " :
								"Found an expression of type " + inferedType.getName()+ ". ");
					message += "Expecting an expression of type " 
								+ (expectedType != null ? expectedType.getName() : "NULL") 
								+ ".";
					error(message, valueNamePair.getValue(), VSLPackage.EXPRESSION) ;
				}
			}
				
		}
	}

	@Check
	public void ConditionExpression (ConditionalExpression exp) {
//		if (exp.getOp() != null && !exp.getOp().isEmpty() && exp.getOp().get(0).equals("?")) {
//			if (exp.getExp() != null && !exp.getExp().isEmpty()) {
//				
//				AdditiveExpression condition = exp.getExp().get(0) ;
//				Type typeOfCondition = new VSLTypeInferenceUtil(_boolean).typeOfAdditiveExpression(condition) ;
//				if (typeOfCondition != _boolean) {
//					String message = "" +
//					(typeOfCondition == null ? 
//							"Could not infer type of expression. " :
//								"Found an expression of type " + typeOfCondition.getName()+ ". ");
//					message += "Expecting an expression of type Boolean.";
//					error(message, condition, VSLPackage.EXPRESSION) ;
//				}
//			}
//		}
		ContionExpression_impl(exp) ;
	}
	
	private Type ContionExpression_impl(ConditionalExpression exp) {
		if (exp.getOp() != null && !exp.getOp().isEmpty() && exp.getOp().get(0).equals("?")) {
			if (exp.getExp() != null && !exp.getExp().isEmpty()) {
				
				AdditiveExpression condition = exp.getExp().get(0) ;
				Type typeOfCondition = new VSLTypeInferenceUtil(_boolean).typeOfAdditiveExpression(condition) ;
				if (typeOfCondition != _boolean) {
					String message = "" +
					(typeOfCondition == null ? 
							"Could not infer type of expression. " :
								"Found an expression of type " + typeOfCondition.getName()+ ". ");
					message += "Expecting an expression of type Boolean.";
					error(message, condition, VSLPackage.EXPRESSION) ;
				}
				return typeOfCondition ;
			}
		}
		return null ;
	}
}
