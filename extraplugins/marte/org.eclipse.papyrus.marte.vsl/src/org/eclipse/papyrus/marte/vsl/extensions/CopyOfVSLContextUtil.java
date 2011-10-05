/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.vsl.extensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsExpression;
import org.eclipse.papyrus.marte.vsl.vSL.Interval;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValues;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;
import org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

public class CopyOfVSLContextUtil {
	
	private static Type getExpectedType_forNestedElement(EObject rule) {
		Type expectedType = null ;
		//EObject container = rule.eContainer() ;
		EObject container = rule ;
		if (container != null) {
			EObject tmpContainer = container ;
			while (tmpContainer != null &&
					!(tmpContainer instanceof Interval) &&
					!(tmpContainer instanceof ListOfValueNamePairs) &&
					!(tmpContainer instanceof NameOrChoiceOrBehaviorCall) &&
					!(tmpContainer instanceof InstantObsExpression) &&
					!(tmpContainer instanceof DurationObsExpression) &&
					!(tmpContainer instanceof VariableDeclaration) &&
					!(tmpContainer instanceof ListOfValues)) {
				container = tmpContainer ;
				tmpContainer = tmpContainer.eContainer() ;
			}
			if (tmpContainer instanceof ListOfValueNamePairs) { 
				return getExpectedType_forNestedElement(tmpContainer.eContainer()) ;
				
			}
			else if (tmpContainer instanceof ListOfValues) { 
				ListOfValues listOfValues = (ListOfValues) tmpContainer ;
				int indexOfExpression = listOfValues.getValues().indexOf(container) ;
				if (listOfValues.eContainer() instanceof CollectionOrTuple) {
					Type typeOfCollectionOrTuple = ((CollectionOrTuple)listOfValues.eContainer()).getExpectedType() ;
					if (typeOfCollectionOrTuple.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") != null) {
						Stereotype collectionStereotype = typeOfCollectionOrTuple.
						getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") ;
						EObject stereotypeApplication = typeOfCollectionOrTuple.getStereotypeApplication(collectionStereotype) ;
						EStructuralFeature collectionAttrib = stereotypeApplication.eClass().getEStructuralFeature("collectionAttrib") ;
						if (collectionAttrib != null) {
							Property collectionProperty = (Property) stereotypeApplication.eGet(collectionAttrib) ;
							return collectionProperty.getType() ;
						}
					}
					else if (typeOfCollectionOrTuple.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") != null ||
							typeOfCollectionOrTuple.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType") != null) {
						if (indexOfExpression < ((Classifier)typeOfCollectionOrTuple).getAllAttributes().size())
							return expectedType = ((Classifier)typeOfCollectionOrTuple).getAllAttributes().get(indexOfExpression).getType() ;
					}

				}
				else if (listOfValues.eContainer() instanceof NameOrChoiceOrBehaviorCall) {
					NameOrChoiceOrBehaviorCall call = (NameOrChoiceOrBehaviorCall) listOfValues.eContainer() ;
					if (call.getId() != null && call.getId() instanceof Behavior) {
						Behavior calledBehavior = (Behavior) call.getId() ;
						if (indexOfExpression < calledBehavior.getOwnedParameters().size())
							return calledBehavior.getOwnedParameters().get(indexOfExpression).getType() ;
					}
					else if (call.getId() != null && call.getId() instanceof Property) { // this is choice
						Property calledProperty = (Property) call.getId() ;
						return calledProperty.getType() ;
					}
				}
				else if (listOfValues.eContainer() instanceof OperationCallExpression) {
					Operation calledOperation = ((OperationCallExpression)listOfValues.eContainer()).getOperation() ;
					if (calledOperation != null) {
						if (indexOfExpression < calledOperation.getOwnedParameters().size())
							return calledOperation.getOwnedParameters().get(indexOfExpression).getType() ;
					}
				}
			}
			else if (tmpContainer instanceof NameOrChoiceOrBehaviorCall) {
				NameOrChoiceOrBehaviorCall obj = (NameOrChoiceOrBehaviorCall) tmpContainer ;
				if (obj.getId() instanceof Property)
					return ((Property)obj.getId()).getType() ;
			}
			else if (tmpContainer instanceof Interval) {
				Exception e = new Exception("Not Implemented: GetExpectedTypeFor_Expression =>  Container instanceof Interval") ;
				e.printStackTrace() ;
			}
			else if (tmpContainer instanceof InstantObsExpression) {
				Exception e = new Exception("Not Implemented: GetExpectedTypeFor_Expression =>  Container instanceof InstantObsExpression") ;
				e.printStackTrace() ;
			}
			else if (tmpContainer instanceof DurationObsExpression) {
				Exception e = new Exception("Not Implemented: GetExpectedTypeFor_Expression =>  Container instanceof DurationObsExpression") ;
				e.printStackTrace() ;
			}
			else if (tmpContainer instanceof VariableDeclaration) {
				Exception e = new Exception("Not Implemented: GetExpectedTypeFor_Expression =>  Container instanceof VariablDeclaration") ;
				e.printStackTrace() ;
			}
			return getExpectedType(tmpContainer) ;
		}
		
		return org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.getExpectedType() ;
	}
	
	public static Type getExpectedType(EObject rule) {
//		if (rule instanceof Expression) {
//			Type expectedType = getExpectedTypeFor_Expression((Expression)rule) ;
//			if (expectedType != null)
//				return expectedType ;
//		}
//		else if (rule instanceof ValueNamePair) {
//			Type expectedType = getExpectedTypeFor_ValueNamePair((ValueNamePair)rule) ;
//			if (expectedType != null)
//				return expectedType ;
//		}
		
		Type expectedType = getExpectedType_forNestedElement(rule) ;
		if (expectedType != null)
			return expectedType ;
		
		if (rule instanceof ValueNamePair) {
			expectedType = getExpectedTypeFor_ValueNamePair((ValueNamePair)rule) ;
			if (expectedType != null)
				return expectedType ;
		}
		
	  	java.lang.reflect.Method m ;
	  	try {
	  		Class<?>[] params = {} ;
	  		m = rule.eContainer().getClass().getMethod("getExpectedType",params);
	  	}
	  	catch (Exception e) {
	  		return org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.getExpectedType() ;
	  	}
       	try {
       		Object[] args = {} ;
       		return (Type) m.invoke(rule.eContainer(),args) ;
       	}
       	catch (Exception e){
       		return null ;
       	}
	}
	
	public static Namespace getModel(EObject rule) {
		java.lang.reflect.Method m ;
	  	try {
	  		Class<?>[] params = {} ;
	  		m = rule.eContainer().getClass().getMethod("getModel",params);
	  	}
	  	catch (Exception e) {
	  		return org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.getModel() ;
	  	}
       	try {
       		Object[] args = {} ;
       		return (Namespace) m.invoke(rule.eContainer(),args) ;
       	}
       	catch (Exception e){
       		return null ;
       	}
	}
	
	public static Element getContextElement(EObject rule) {
		java.lang.reflect.Method m ;
	  	try {
	  		Class<?>[] params = {} ;
	  		m = rule.eContainer().getClass().getDeclaredMethod("getContextElement",params);
	  	}
	  	catch (Exception e) {
	  		return org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.getContextElement() ;
	  	}
       	try {
       		Object[] args = {} ;
       		return (Element) m.invoke(rule.eContainer(),args) ;
       	}
       	catch (Exception e){
       		e.printStackTrace() ;
       		return null ;
       	}
	}

	private static Type getExpectedTypeFor_ValueNamePair(ValueNamePair rule) {
		Type expectedType = null ;
		EObject container = rule.eContainer() ;
		while (container != null 
				&& !(container instanceof NameOrChoiceOrBehaviorCall)
				&& !(container instanceof ValueNamePair)) {
			container = container.eContainer() ;
		}
		if (container != null) {
			if (container instanceof NameOrChoiceOrBehaviorCall) {
				NameOrChoiceOrBehaviorCall obj = (NameOrChoiceOrBehaviorCall) container ;
				if (obj.getId() != null && obj.getId() instanceof Property) {
					return ((Property)obj.getId()).getType() ;
				}
			}
			else if (container instanceof ValueNamePair) {
				ValueNamePair obj = (ValueNamePair) container ;
				if (obj.getProperty() != null)
					return obj.getProperty().getType() ;
			}
		}
		return expectedType ;
	}
	
	private static Type getExpectedTypeFor_Expression(Expression rule) {
		Type expectedType = null ;
		EObject container = rule.eContainer() ;
		if (container != null) {
			EObject tmpContainer = container ;
			while (tmpContainer != null &&
					!(tmpContainer instanceof Interval) &&
					!(tmpContainer instanceof ValueNamePair) &&
					!(tmpContainer instanceof InstantObsExpression) &&
					!(tmpContainer instanceof DurationObsExpression) &&
					!(tmpContainer instanceof VariableDeclaration) &&
					!(tmpContainer instanceof ListOfValues)) {
				tmpContainer = tmpContainer.eContainer() ;	
			}
			if (tmpContainer instanceof ListOfValues) { // TODO: expression can be deeply nested
				ListOfValues listOfValues = (ListOfValues) tmpContainer ;
				int indexOfExpression = listOfValues.getValues().indexOf(rule) ;
				if (listOfValues.eContainer() instanceof CollectionOrTuple) {
					Type typeOfCollectionOrTuple = ((CollectionOrTuple)listOfValues.eContainer()).getExpectedType() ;
					if (typeOfCollectionOrTuple.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") != null) {
						Stereotype collectionStereotype = typeOfCollectionOrTuple.
						getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::CollectionType") ;
						EObject stereotypeApplication = typeOfCollectionOrTuple.getStereotypeApplication(collectionStereotype) ;
						EStructuralFeature collectionAttrib = stereotypeApplication.eClass().getEStructuralFeature("collectionAttrib") ;
						if (collectionAttrib != null) {
							Property collectionProperty = (Property) stereotypeApplication.eGet(collectionAttrib) ;
							return collectionProperty.getType() ;
						}
					}
					else if (typeOfCollectionOrTuple.getAppliedStereotype("MARTE::MARTE_Annexes::VSL::DataTypes::TupleType") != null ||
							typeOfCollectionOrTuple.getAppliedStereotype("MARTE::MARTE_Foundations::NFPs::NfpType") != null) {
						if (indexOfExpression < ((Classifier)typeOfCollectionOrTuple).getAllAttributes().size())
							return expectedType = ((Classifier)typeOfCollectionOrTuple).getAllAttributes().get(indexOfExpression).getType() ;
					}

				}
				else if (listOfValues.eContainer() instanceof NameOrChoiceOrBehaviorCall) {
					NameOrChoiceOrBehaviorCall call = (NameOrChoiceOrBehaviorCall) listOfValues.eContainer() ;
					if (call.getId() != null && call.getId() instanceof Behavior) {
						Behavior calledBehavior = (Behavior) call.getId() ;
						if (indexOfExpression < calledBehavior.getOwnedParameters().size())
							return calledBehavior.getOwnedParameters().get(indexOfExpression).getType() ;
					}
				}
				else if (listOfValues.eContainer() instanceof OperationCallExpression) {
					Operation calledOperation = ((OperationCallExpression)listOfValues.eContainer()).getOperation() ;
					if (calledOperation != null) {
						if (indexOfExpression < calledOperation.getOwnedParameters().size())
							return calledOperation.getOwnedParameters().get(indexOfExpression).getType() ;
					}
				}
			}
			else if (tmpContainer instanceof ValueNamePair) {
				ValueNamePair obj = (ValueNamePair) tmpContainer ;
				if (obj.getProperty() != null) {
					return obj.getProperty().getType() ;
				}
			}
			else if (tmpContainer instanceof Interval) {
				Exception e = new Exception("Not Implemented: GetExpectedTypeFor_Expression =>  Container instanceof Interval") ;
				e.printStackTrace() ;
			}
			else if (tmpContainer instanceof InstantObsExpression) {
				Exception e = new Exception("Not Implemented: GetExpectedTypeFor_Expression =>  Container instanceof InstantObsExpression") ;
				e.printStackTrace() ;
			}
			else if (tmpContainer instanceof DurationObsExpression) {
				Exception e = new Exception("Not Implemented: GetExpectedTypeFor_Expression =>  Container instanceof DurationObsExpression") ;
				e.printStackTrace() ;
			}
			else if (tmpContainer instanceof VariableDeclaration) {
				Exception e = new Exception("Not Implemented: GetExpectedTypeFor_Expression =>  Container instanceof VariablDeclaration") ;
				e.printStackTrace() ;
			}
			return getExpectedType(tmpContainer) ;
		}
		
		return expectedType ;
	}
}
