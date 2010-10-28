package org.eclipse.papyrus.marte.vsl.extensions ;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

import org.eclipse.papyrus.marte.vsl.vSL.AdditiveExpression;
import org.eclipse.papyrus.marte.vsl.vSL.AndOrXorExpression;
import org.eclipse.papyrus.marte.vsl.vSL.BooleanLiteralRule;
//import org.eclipse.papyrus.marte.vsl.vSL.Choice;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.ConditionalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.DateTimeLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.DefaultLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.IntegerLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.Interval;
import org.eclipse.papyrus.marte.vsl.vSL.JitterExp;
import org.eclipse.papyrus.marte.vsl.vSL.Literal;
import org.eclipse.papyrus.marte.vsl.vSL.MultiplicativeExpression;
//import org.eclipse.papyrus.marte.vsl.vSL.Name;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.vSL.NullLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.RealLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.StringLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression;
import org.eclipse.papyrus.marte.vsl.vSL.TimeExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Tuple;
import org.eclipse.papyrus.marte.vsl.vSL.UnaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.UnlimitedLiteralRule;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;
import org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification;
import org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration;
//import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.ExpectedKind;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;



/**
 * @author Arnaud Cuccuru, CEA LIST, LISE
 *
 */
public class VSLTypeInferenceUtil {
	
	//private Namespace model ;
	//private Element contextElement ;
	private Type expectedType ;
	//private ExpectedKind expectedKind ;
	private VSLTypeInferenceUtil self ;
	
	
	
	public VSLTypeInferenceUtil(Type expectedType) {
		this.expectedType = expectedType ;
//		if (this.expectedType != null) { // TODO : handle the case where it is null
//			if(expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType")!=null)
//				expectedKind = ExpectedKind._TUPLE ;
//			else if (expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType")!=null)
//				expectedKind = ExpectedKind._COLLECTION ;
//			else if (expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType")!=null)
//				expectedKind = ExpectedKind._INTERVAL ;
//			else if (expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType")!=null)
//				expectedKind = ExpectedKind._CHOICE ;
//			else if (expectedType instanceof Enumeration)
//				expectedKind = ExpectedKind._ENUM ;
//			else
//				expectedKind = ExpectedKind._DATATYPE ;
//		}
		self = this ;
	}
	
//	public VSLTypeInferenceUtil(Type expectedType) {
//		this(expectedType, null) ;
//	}

	/**
	 * @param exp
	 * @return
	 */
	public Type typeOfExpression (Expression exp) {
		//Type oldGloballyExpectedType = VSLJavaValidator.expectedType ;
		//ExpectedKind oldGloballyExpectedKind = VSLJavaValidator.expectedKind ;
		//VSLJavaValidator.expectedKind = expectedKind ;
		//VSLJavaValidator.expectedType = expectedType ;
		Type inferedType =  typeOfAndOrXorExpression(exp.getExp()) ;
		//VSLJavaValidator.expectedType = oldGloballyExpectedType ;
		//VSLJavaValidator.expectedKind = oldGloballyExpectedKind ;
		return inferedType ;
	}
	
	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfAndOrXorExpression(AndOrXorExpression exp) {
		if (exp.getExp().size() > 1 ) {
			Type firstOperandType = typeOfEqualityExpression(exp.getExp().get(0)) ;
			Type secondOperandType ;
			for (int i=1 ; i<exp.getExp().size() ; i++) {
				secondOperandType = typeOfEqualityExpression(exp.getExp().get(i)) ;
				firstOperandType = VSLJavaValidator.opSignatures.get(
						exp.getOp().get(i-1) + "(" + 
						(firstOperandType != null ? firstOperandType.getName() : "null") + "," +
						(secondOperandType != null ? secondOperandType.getName() : "null") + ")") ;
			}
			return firstOperandType ;
		}
		return typeOfEqualityExpression (exp.getExp().get(0)) ;
	}

	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfEqualityExpression(EqualityExpression exp) {
		if (exp.getExp().size() > 1 ) {
			Type firstOperandType = typeOfRelationalExpression(exp.getExp().get(0)) ;
			Type secondOperandType ;
			for (int i=1 ; i<exp.getExp().size() ; i++) {
				secondOperandType = typeOfRelationalExpression(exp.getExp().get(i)) ;
				firstOperandType = VSLJavaValidator.opSignatures.get(
						exp.getOp().get(i-1) + "(" + 
						(firstOperandType != null ? firstOperandType.getName() : "null") + "," +
						(secondOperandType != null ? secondOperandType.getName() : "null") + ")") ;
			}
			return firstOperandType ;
		}
		return typeOfRelationalExpression (exp.getExp().get(0)) ;
	}

	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfRelationalExpression (RelationalExpression exp) {
		if (exp.getExp().size() > 1 ) {
			Type firstOperandType = typeOfConditionalExpression(exp.getExp().get(0)) ;
			Type secondOperandType ;
			for (int i=1 ; i<exp.getExp().size() ; i++) {
				secondOperandType = typeOfConditionalExpression(exp.getExp().get(i)) ;
				firstOperandType = VSLJavaValidator.opSignatures.get(
						exp.getOp().get(i-1) + "(" + 
						(firstOperandType != null ? firstOperandType.getName() : "null") + "," +
						(secondOperandType != null ? secondOperandType.getName() : "null") + ")") ;
			}
			return firstOperandType ;
		}
		return typeOfConditionalExpression (exp.getExp().get(0)) ;
	}

	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfConditionalExpression (ConditionalExpression exp) {
		Classifier thenOperandType ;
		Classifier elseOperandType ;
		if (exp.getExp().size()==3) {
			thenOperandType = (exp.getExp().get(1) != null) ? (Classifier)typeOfAdditiveExpression(exp.getExp().get(1)) : null;
			elseOperandType = (exp.getExp().get(2) != null) ? (Classifier)typeOfAdditiveExpression(exp.getExp().get(2)) : null;
			if (thenOperandType == elseOperandType)
				return thenOperandType ;
			else if (thenOperandType != null && areTypesCompatible(thenOperandType, elseOperandType) )
				return elseOperandType ;
			else if (elseOperandType != null && areTypesCompatible(elseOperandType, thenOperandType) )
				return thenOperandType ;
			else
				return null ;
		}
		else if (exp.getExp().size() == 2)
			return null ;
		else
			return typeOfAdditiveExpression (exp.getExp().get(0)) ;
	}
		
	/**
	 * @param exp
	 * @return
	 */
	public Type typeOfAdditiveExpression (AdditiveExpression exp) {
		if (exp.getExp().size() > 1 ) {
			Type firstOperandType = typeOfMultiplicativeExpression(exp.getExp().get(0)) ;
			Type secondOperandType ;
			for (int i=1 ; i<exp.getExp().size() ; i++) {
				secondOperandType = typeOfMultiplicativeExpression(exp.getExp().get(i)) ;
				firstOperandType = VSLJavaValidator.opSignatures.get(
						exp.getOp().get(i-1) + "(" + 
						(firstOperandType != null ? firstOperandType.getName() : "null") + "," +
						(secondOperandType != null ? secondOperandType.getName() : "null") + ")") ;
			}
			return firstOperandType ;
		}
		return typeOfMultiplicativeExpression (exp.getExp().get(0)) ;
	}

	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfMultiplicativeExpression (MultiplicativeExpression exp) {
		if (exp.getExp().size() > 1 ) {
			Type firstOperandType = typeOfUnaryExpression(exp.getExp().get(0)) ;
			Type secondOperandType ;
			for (int i=1 ; i<exp.getExp().size() ; i++) {
				secondOperandType = typeOfUnaryExpression(exp.getExp().get(i)) ;
				firstOperandType = VSLJavaValidator.opSignatures.get(
						exp.getOp().get(i-1) + "(" + 
						(firstOperandType != null ? firstOperandType.getName() : "null") + "," +
						(secondOperandType != null ? secondOperandType.getName() : "null") + ")") ;
			}
			return firstOperandType ;
		}
		return exp.getExp().size() > 0 ? typeOfUnaryExpression (exp.getExp().get(0)) : null;
	}
		
	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfUnaryExpression (UnaryExpression exp) {
		if (exp.getOp()!=null) {
			Type typeOfUnary = typeOfUnaryExpression(exp.getUnary()) ;
			return VSLJavaValidator.opSignatures.get(exp.getOp()+ "("+ 
								(typeOfUnary != null ? typeOfUnary.getName() : "null") 
												+")") ;
		}
		else if (exp.getExp() != null)
			return typeOfPrimaryExpression (exp.getExp());
		else
			return null ;
	}

	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfPrimaryExpression(PrimaryExpression exp) {
		if (exp.getSuffix() != null) { // && exp.getSuffix() != suffixExpressionToIgnore) {
			return typeOfSuffixPression(exp.getSuffix()) ;
		}
		return typeOfValueSpecification (exp.getPrefix());
	}

	private Type typeOfSuffixPression(SuffixExpression exp) {
		if (exp instanceof OperationCallExpression) {
			return typeOfOperationCallExpression((OperationCallExpression)exp) ;
		}
		else { // PropertyCallExpression
			return typeOfPropertyCallExpression((PropertyCallExpression)exp) ;
		}
	}
	
	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfOperationCallExpression(OperationCallExpression exp) {
		if (exp.getSuffix() != null) // && exp.getSuffix() != suffixExpressionToIgnore)
			return typeOfSuffixPression(exp.getSuffix()) ;
		return exp.getOperation() != null ? exp.getOperation().getType() : null ;
	}
	
	/**
	 * @param exp
	 * @return
	 */
	private Type typeOfPropertyCallExpression(PropertyCallExpression exp) {
		if (exp.getSuffix() != null) // && exp.getSuffix() != suffixExpressionToIgnore)
			return typeOfSuffixPression(exp.getSuffix()) ;
		return exp.getProperty() != null ? exp.getProperty().getType() : null ;
	}
	
	
	/**
	 * @param value
	 * @return
	 */
	public Type typeOfValueSpecification (ValueSpecification value) {

		if (value instanceof Literal)
			return typeOfLiteral((Literal)value) ;
		if (value instanceof NameOrChoiceOrBehaviorCall)
			return typeOfNameOrChoiceOrBehaviorCall((NameOrChoiceOrBehaviorCall)value) ;
		if (value instanceof TimeExpression)
			return typeOfTimeExpression((TimeExpression)value) ;
		if (value instanceof VariableDeclaration)
			return typeOfVariableDeclaration((VariableDeclaration)value) ;
		if (value instanceof Expression)
			return typeOfExpression((Expression)value) ;
		//if (value instanceof Choice) {
		//	return typeOfChoice ((Choice)value) ;
		//}
		if (value instanceof Interval) {
			return typeOfInterval((Interval)value) ;
		}
		if (value instanceof Tuple) {
			return typeOfTuple((Tuple)value) ;
		}
		if (value instanceof CollectionOrTuple) {
			return typeOfCollectionOrTuple ((CollectionOrTuple)value);
		}
		
		return null ;
	}
	
	
	/**
	 * @param literal
	 * @return
	 */
	private Type typeOfLiteral (Literal literal) {
		if (literal instanceof IntegerLiteralRule) {
			return VSLJavaValidator._integer ;
		}
		if (literal instanceof UnlimitedLiteralRule) {
			return VSLJavaValidator._unlimitedNatural ;
		}
		if (literal instanceof RealLiteralRule) {
			return VSLJavaValidator._real ;
		}
		if (literal instanceof DateTimeLiteralRule) {
			return VSLJavaValidator._datetime ;
		}
		if (literal instanceof BooleanLiteralRule) {
			return VSLJavaValidator._boolean ;
		}
		if (literal instanceof NullLiteralRule) {
			Type locallyExpected = VSLContextUtil.getExpectedType(literal) ;
			//return expectedType ;
			return locallyExpected ;
		}
		if (literal instanceof DefaultLiteralRule) {
			Type locallyExpected = VSLContextUtil.getExpectedType(literal) ;
			//return expectedType ;
			return locallyExpected ;
		}
		if (literal instanceof StringLiteralRule) {
			return VSLJavaValidator._string ;
		}
		return null ;
	}
	
	
	/**
	 * @param name
	 * @return
	 */
	private Type typeOfNameOrChoiceOrBehaviorCall (NameOrChoiceOrBehaviorCall name) {
		if (name.getId() != null) {
			if (name.getId() instanceof EnumerationLiteral) {
				return ((EnumerationLiteral) name.getId()).getEnumeration() ;
			}
			if (name.getId() instanceof Property) {
				if (name.getId().getNamespace().getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType") != null)
					return (Type)name.getId().getNamespace() ;
				return ((Property)name.getId()).getType() ;
			}
			if (name.getId() instanceof Behavior)
				for (Parameter p : ((Behavior)name.getId()).getOwnedParameters())
					if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
						return p.getType() ;
				return null ;
		}
		return null ;
	}

	/**
	 * @param timeExpression
	 * @return
	 */
	private Type typeOfTimeExpression (TimeExpression timeExpression) {
		if (timeExpression instanceof InstantObsExpression)
			return VSLJavaValidator._datetime ;
		else if (timeExpression instanceof DurationObsExpression)
			return VSLJavaValidator._real ;
		else if (timeExpression instanceof JitterExp)
			return VSLJavaValidator._real ;
		else
			return null ;
	}

	/**
	 * @param variableDeclaration
	 * @return
	 */
	private Type typeOfVariableDeclaration (VariableDeclaration variableDeclaration) {
		if (variableDeclaration.getType() != null)
			return variableDeclaration.getType().getType() ;
		else if (variableDeclaration.getInitValue() != null)
			return typeOfExpression(variableDeclaration.getInitValue()) ;
		return null ;
	}

	/**
	 * @param choice
	 * @return
	 */
	//private Type typeOfChoice (Choice choice) {
	//	if (choice.getChosenAlternative() != null)
	//		return (Type)choice.getChosenAlternative().getNamespace() ;
	//	return null ;
	//}

	/**
	 * @param interval
	 * @return
	 */
	private Type typeOfInterval (Interval interval) { // TODO: Works only for a depth-level of one
		
		final class IntervalTypeProposal {
			
			private Type boundsType = null ;
			
			public IntervalTypeProposal(Interval interval) {
				Type typeOfLower ;
				Type typeOfUpper ;
				VSLTypeInferenceUtil localTypeChecker = self ;
				if (expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType") != null) {
					Type expectedBoundType ;
					Stereotype intervalStereotype = expectedType.
											getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType") ;
					EObject stereotypeApplication = expectedType.getStereotypeApplication(intervalStereotype) ;
					EStructuralFeature intervalAttrib = stereotypeApplication.eClass().getEStructuralFeature("intervalAttrib") ;
					Property intervalProperty = (Property) stereotypeApplication.eGet(intervalAttrib) ;
					expectedBoundType = intervalProperty.getType() ;
					if(expectedBoundType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType")!=null ||
							expectedBoundType.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType")!=null ||
							expectedBoundType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType")!=null ||
							expectedBoundType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType")!=null ||
							expectedBoundType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType")!=null)
						localTypeChecker = new VSLTypeInferenceUtil(expectedBoundType) ;
				}
				if (interval.getLower() != null && interval.getUpper() != null) {
					typeOfLower = localTypeChecker.typeOfExpression (interval.getLower()) ;
					typeOfUpper = localTypeChecker.typeOfExpression (interval.getUpper()) ;
					if (typeOfLower != null && typeOfUpper != null) {
						if (areTypesCompatible(typeOfLower, typeOfUpper) || areTypesCompatible(typeOfUpper, typeOfLower)) {
							if (areTypesCompatible(typeOfLower,typeOfUpper)) 
								this.boundsType = typeOfUpper ;
							else 
								this.boundsType = typeOfLower ;
						}
					}
				}
			}

			public boolean matchesExpectedType(Type expectedType) {
				if (this.boundsType == null)
					return false ;
				
				Stereotype intervalStereotype = expectedType.
							getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType") ;
				if (intervalStereotype != null) { // i.e. the expected type is indeed an IntervalType
					EObject stereotypeApplication = expectedType.getStereotypeApplication(intervalStereotype) ;
					EStructuralFeature intervalAttrib = stereotypeApplication.eClass().getEStructuralFeature("intervalAttrib") ;
					Property intervalProperty = (Property) stereotypeApplication.eGet(intervalAttrib) ;
					if (areTypesCompatible(boundsType, intervalProperty.getType())) {
						return true ;
					}
				}
				return false ;
			}
		
			public Type makeTypeProsal() {
				//TODO: to be implemented
				return null ;
			}
		}
		
		IntervalTypeProposal proposal = new IntervalTypeProposal(interval) ;
		if (proposal.matchesExpectedType(expectedType)) {
			return expectedType ;
		}
		else 
			return proposal.makeTypeProsal() ;
	}
	
	/**
	 * @param tuple
	 * @return
	 */
	private Type typeOfTuple (Tuple tuple) { // TODO: Works only for a depth-level of one
		
		final class TupleTypeProposal {
			
			private List<Property> tupleAttribs = new ArrayList<Property>() ;
			
			public TupleTypeProposal(Tuple tuple) {
				for (ValueNamePair v : tuple.getListOfValueNamePairs().getValueNamePairs()) {
					if (v.getProperty() != null)
						tupleAttribs.add(v.getProperty()) ;
				}
			}

			public boolean matchesExpectedType(Type expectedType) {
				Stereotype tupleStereotype = expectedType.
							getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") ;
				if (tupleStereotype == null)
					tupleStereotype = expectedType.
							getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType") ;
				if (tupleStereotype != null) { // i.e. the expected type is indeed a TupleType
					EObject stereotypeApplication = expectedType.getStereotypeApplication(tupleStereotype) ;
					EStructuralFeature tupleAttrib = stereotypeApplication.eClass().getEStructuralFeature("tupleAttrib") ;
					List<Property> tupleProperty = (List<Property>) stereotypeApplication.eGet(tupleAttrib) ;
					if (tupleProperty.isEmpty())
						return ((DataType)expectedType).getAllAttributes().containsAll(tupleAttribs) ;
					else 
						return tupleProperty.containsAll(tupleAttribs) ;
				}
				//TODO: Handle the case where the tuple syntax is used for fixing a value for a default chosen alternative in a choice
				return false ;
			}
			
			public Type makeTypeProposal() {
				//TODO: To be implemented
				return null ;
			}
		}
		
		TupleTypeProposal proposal = new TupleTypeProposal(tuple) ;
		if (proposal.matchesExpectedType(expectedType)) {
			return expectedType ;
		}
		else 
			return proposal.makeTypeProposal() ;
	}
	
	/**
	 * @param collOrtuple
	 * @return
	 */
	private Type typeOfCollectionOrTuple (CollectionOrTuple collOrtuple) { // TODO : Works only for a depth-level of one
		
		final class CollectionOrTupleTypeProposal {
			
			private List<Type> collectionOrTupleElemTypes = new ArrayList<Type>() ;
			
			public CollectionOrTupleTypeProposal(CollectionOrTuple collOrTuple) {
				VSLTypeInferenceUtil localTypeChecker = self ;
				List<VSLTypeInferenceUtil> localListOfTypeCheckers = new ArrayList<VSLTypeInferenceUtil>() ;
				if (expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") != null) {
					Type expectedElementType ;
					Stereotype collectionStereotype = expectedType.
											getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") ;
					EObject stereotypeApplication = expectedType.getStereotypeApplication(collectionStereotype) ;
					EStructuralFeature collectionAttrib = stereotypeApplication.eClass().getEStructuralFeature("collectionAttrib") ;
					Property collectionProperty = (Property) stereotypeApplication.eGet(collectionAttrib) ;
					expectedElementType = collectionProperty.getType() ;
					if(expectedElementType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType")!=null ||
							expectedElementType.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType")!=null ||
							expectedElementType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType")!=null ||
							expectedElementType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType")!=null ||
							expectedElementType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType")!=null)
						localTypeChecker = new VSLTypeInferenceUtil(expectedElementType) ;
				}
				else if (expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") != null ||
						expectedType.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType")!=null) {
					//Stereotype tupleStereotype = expectedType.
					//						getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") ;
					//EObject stereotypeApplication = expectedType.getStereotypeApplication(tupleStereotype) ;
					//EStructuralFeature tupleAttrib = stereotypeApplication.eClass().getEStructuralFeature("tupleAttrib") ;
					//List<Property> collectionProperty = (List<Property>) stereotypeApplication.eGet(tupleAttrib) ;
					List<Property> collectionProperty = new ArrayList<Property>() ;
					collectionProperty.addAll(((Classifier)expectedType).getAllAttributes()) ;
					if (collectionProperty.isEmpty())
						collectionProperty = ((Classifier)expectedType).getAllAttributes() ;
					for (int i = 0 ; i < collOrTuple.getListOfValues().getValues().size() ; i++) {
						Type expectedElementType ;
						expectedElementType = i < collectionProperty.size() ? collectionProperty.get(i).getType() : null ;
						if(expectedElementType != null &&
								(expectedElementType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType")!=null ||
								expectedElementType.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType")!=null ||
								expectedElementType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType")!=null ||
								expectedElementType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::IntervalType")!=null ||
								expectedElementType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::ChoiceType")!=null))
							localListOfTypeCheckers.add(new VSLTypeInferenceUtil(expectedElementType)) ;
						else
							localListOfTypeCheckers.add(self) ;
					}
				}
				for (int i = 0 ; i < collOrTuple.getListOfValues().getValues().size() ; i++) {
					Expression exp = collOrTuple.getListOfValues().getValues().get(i);
					Type typeOfExp = ((expectedType.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") != null || 
										expectedType.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType")!= null) 
										? localListOfTypeCheckers.get(i) : localTypeChecker).typeOfExpression(exp) ; 
					//if (typeOfExp != null)
						collectionOrTupleElemTypes.add(typeOfExp) ;
				}
			}

			public boolean matchesExpectedType(Type expectedType) {
				Stereotype tupleStereotype = expectedType.
							getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") ;
				tupleStereotype = expectedType.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType") ;
				Stereotype collectionStereotype = expectedType.
							getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") ;
				if (collectionStereotype != null) { // i.e. the expected type is indeed a CollectionType
					// there must be one distinguishable type in collectionOrTupleElemTypes
					// and it must conform to the type of the collectionAttrib
					EObject stereotypeApplication = expectedType.getStereotypeApplication(collectionStereotype) ;
					EStructuralFeature collectionAttrib = stereotypeApplication.eClass().getEStructuralFeature("collectionAttrib") ;
					Property collectionProperty = (Property) stereotypeApplication.eGet(collectionAttrib) ;
					if (collectionProperty.getType() != null) {
						// collectionOrTupleElemTypes must not be empty
						// and each of its types must conform to collectionProperty.getType
						if (collectionOrTupleElemTypes.isEmpty())
							return false ;
						for (Type t : collectionOrTupleElemTypes) {
							if (! areTypesCompatible(t, collectionProperty.getType()))
								return false ;
						}
						return true ;
					}
				}
				else if (tupleStereotype != null) { // i.e. the expected type is indeed a TupleType
					//EObject stereotypeApplication = expectedType.getStereotypeApplication(tupleStereotype) ;
					//EStructuralFeature tupleAttrib = stereotypeApplication.eClass().getEStructuralFeature("tupleAttrib") ;
					//List<Property> tupleProperty = (List<Property>) stereotypeApplication.eGet(tupleAttrib) ;
					List<Property> tupleProperty = new ArrayList<Property>();
					tupleProperty.addAll(((Classifier)expectedType).getAllAttributes()) ;
					if (tupleProperty.isEmpty()) {
						int numberOfElementsToTest = Math.min(((DataType)expectedType).getAllAttributes().size() , collectionOrTupleElemTypes.size()) ;
//						if (((DataType)expectedType).getAllAttributes().size() != collectionOrTupleElemTypes.size())
//							return false ;
//						else {
						for (int i = 0 ; i < numberOfElementsToTest ; i++) {
							if (collectionOrTupleElemTypes.get(i) != null &&
									((DataType)expectedType).getAllAttributes().get(i) != null &&
									((DataType)expectedType).getAllAttributes().get(i).getType() != null) {
								if (! areTypesCompatible(collectionOrTupleElemTypes.get(i), ((DataType)expectedType).getAllAttributes().get(i).getType()))
									return false ;
							}
							else return false ;
						}
						return true ;
						//}
					}
					else {
						int numberOfElementsToTest = Math.min(((DataType)expectedType).getAllAttributes().size() , collectionOrTupleElemTypes.size()) ;
						//if (tupleProperty.size() != collectionOrTupleElemTypes.size())
//						if (tupleProperty.size() > collectionOrTupleElemTypes.size())
//							return false ;
//						else {
							//for (int i = 0 ; i < collectionOrTupleElemTypes.size() ; i++) {
						for (int i = 0 ; i < numberOfElementsToTest ; i++) {
							if (collectionOrTupleElemTypes.get(i) != null &&
									tupleProperty.get(i) != null &&
									tupleProperty.get(i).getType() != null) {
								if (!areTypesCompatible(collectionOrTupleElemTypes.get(i), tupleProperty.get(i).getType()))
									return false ;
							}
							else return false ;
						}
						return true ;
//						}
					}
				}
				//TODO: Handle the case where the tuple syntax is used for fixing a value for a default chosen alternative in a choice
				return false ;
			}
		
			public Type makeTypeProposal() {
				//TODO: to be implemented
				return null ;
			}
		}
		
		CollectionOrTupleTypeProposal proposal = new CollectionOrTupleTypeProposal(collOrtuple) ;
		if (proposal.matchesExpectedType(expectedType)) {
			return expectedType ;
		}
		else
			return proposal.makeTypeProposal() ;
	}
	
	public boolean areTypesCompatible (Type found, Type expected) {
		
		if (found == null)
			return false ;
		
		if (found == VSLJavaValidator._integer && expected == VSLJavaValidator._unlimitedNatural)
			return true ;
		
		return found.conformsTo(expected) ;
	}
}
