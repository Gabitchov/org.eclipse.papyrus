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
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.VSLValidationResult;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ExpressionValueRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.validation.Check;
 

public class StereotypeApplicationWithVSLJavaValidator extends AbstractStereotypeApplicationWithVSLJavaValidator {

	private static boolean valid_Stereotype = true ;
	private static boolean valid_Expression = true ;
	
	public static boolean validate() {
		return valid_Stereotype && valid_Expression ;
	}
	
//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.GREETING__NAME);
//		}
//	}

	@Check
	public void checkStereotypeApplicationRule_Stereotype(StereotypeApplicationRule stereotypeApplicationRule) {
		Stereotype appliedStereotype = stereotypeApplicationRule.getStereotype() ;
		valid_Stereotype = true ;
		if (appliedStereotype != null) {
			// checks if all the mandatory properties have been fixed
			List<Property> mandatoryProperties = new ArrayList<Property>() ;
			for (Property p : appliedStereotype.getAllAttributes()) {
				if (p.getLower() > 0 && !p.getName().startsWith("base_") && !p.isDerived() && !(p.getDefaultValue() == null)) {
					mandatoryProperties.add(p) ;
				}
			}
			if (mandatoryProperties.isEmpty()) {// not necessary to go further...
				valid_Stereotype = true ;
				return ;
			}
			// determines which mandatory properties have not been specified
			List<Property> actuallySpecifiedProperties = new ArrayList<Property>() ;
			for (TagSpecificationRule tagSpec : stereotypeApplicationRule.getTagSpecification()) {
				actuallySpecifiedProperties.add(tagSpec.getProperty()) ;
			}
			List<String> missingPropertyNames = new ArrayList<String>() ;
			for (Property mandatoryProperty : mandatoryProperties) {
				if (! actuallySpecifiedProperties.contains(mandatoryProperty))
					missingPropertyNames.add(mandatoryProperty.getName()) ;
			}
			if (missingPropertyNames.isEmpty()) {// not necessary to go further...
				valid_Stereotype = true ;
				return ;
			}
			// builds the error message
			valid_Stereotype = false ;
			String errorMessage = (missingPropertyNames.size() > 1 ? "Properties " : "Property ") + missingPropertyNames.get(0) ;
			for (int i = 1 ; i < missingPropertyNames.size() ; i++) {
				errorMessage += ", " + missingPropertyNames.get(i);
			}
			errorMessage += (missingPropertyNames.size() > 1 ? " are " : " is ") + " not optional." ;
			error(errorMessage, stereotypeApplicationRule, StereotypeApplicationWithVSLPackage.eINSTANCE.getStereotypeApplicationRule_Stereotype(), INSIGNIFICANT_INDEX) ;
		}
	}
	
	@Check
	public void checkExpressionValueRule_Expression (ExpressionValueRule expressionValueRule) {
		valid_Expression = true ;
		if (expressionValueRule != null && expressionValueRule.getExpression() != null) {
			Property valuedProperty = ((TagSpecificationRule)expressionValueRule.eContainer()).getProperty() ;
			if (valuedProperty == null) {
				valid_Expression = true ;
				return ;
			}
			VSLJavaValidator.setExpectedType(valuedProperty.getType()) ;
//			Type inferedType = new VSLTypeInferenceUtil(valuedProperty.getType())
//									.typeOfExpression(expressionValueRule.getExpression()) ;
//			
//			if (inferedType != valuedProperty.getType()) {
//				String message = "" +
//					(inferedType == null ? 
//							"Could not infer type of expression. " :
//								"Found an expression of type " + inferedType.getName()+ ". ");
//				message += "Expecting an expression of type " + valuedProperty.getType().getName() ;
//				error(message, StereotypeApplicationWithVSLPackage.EXPRESSION_VALUE_RULE__EXPRESSION) ;
//			}
			
			VSLValidationResult validationResult = VSLJavaValidator.eInstance.checkExpressionRule(expressionValueRule.getExpression()) ;
			if (! validationResult.errorFound()) {
				Type inferedType = validationResult.inferedType() ;
				if (VSLContextUtil.isAChoiceType((Classifier)valuedProperty.getType())) {
					boolean found = false ;
					for (NamedElement n : VSLContextUtil.getChoiceAttribs((Classifier)valuedProperty.getType())) {
						Property p = (Property)n ;
						//ScopingHelper scopingHelper = VSLScopeProvider.eInstance.new ScopingHelper(expressionValueRule.getExpression()) ;
						//if (p.getType() != null && inferedType != null && inferedType.conformsTo(valuedProperty.getType())) {
						if (p.getType() == inferedType || ((Classifier)inferedType).getGenerals().contains(p.getType()))
							found = true ;
					}
					if (!found) { 
						String message = "" +
						(inferedType == null ? 
								"Could not infer type of expression. " :
									"Found an expression of type " + inferedType.getName()+ ". ");
						message += "Expecting an expression of type " + valuedProperty.getType().getName() ;
						error(message, StereotypeApplicationWithVSLPackage.eINSTANCE.getExpressionValueRule_Expression()) ;
						valid_Expression = false ;
					}
					else {
						valid_Expression = true ;
					}
				}
				else if (VSLContextUtil.isAnIntervalType((Classifier)valuedProperty.getType())) {
					boolean found = false ;
					Property p = (Property)VSLContextUtil.getIntervalAttrib((Classifier)valuedProperty.getType()) ;
					if (p.getType() == inferedType || ((Classifier)inferedType).getGenerals().contains(p.getType()))
						found = true ;
					if (!found) { 
						String message = "" +
						(inferedType == null ? 
								"Could not infer type of expression. " :
									"Found an expression of type " + inferedType.getName()+ ". ");
						message += "Expecting an expression of type " + valuedProperty.getType().getName() ;
						error(message, StereotypeApplicationWithVSLPackage.eINSTANCE.getExpressionValueRule_Expression()) ;
						valid_Expression = false ;
					}
					else {
						valid_Expression = true ;
					}
				}
				else if (inferedType != valuedProperty.getType()) {
					if (! (valuedProperty.getType().getName().equals(inferedType.getName()) &&  
							(valuedProperty.getType().getName().equals("String") || 
							 valuedProperty.getType().getName().equals("Integer") ||
							 valuedProperty.getType().getName().equals("UnlimitedNatural") ||
							 valuedProperty.getType().getName().equals("Boolean")))) {
						String message = "" +
						(inferedType == null ? 
								"Could not infer type of expression. " :
									"Found an expression of type " + inferedType.getName()+ ". ");
						message += "Expecting an expression of type " + valuedProperty.getType().getName() ;
						error(message, StereotypeApplicationWithVSLPackage.eINSTANCE.getExpressionValueRule_Expression()) ;
						valid_Expression = false ;
					}
					else {
						valid_Expression = true ;
					}
				}
				if (valuedProperty.getUpper() > 1 || valuedProperty.getUpper() == -1) {
					CollectionOrTuple cddColl = VSLJavaValidator.isACollection(expressionValueRule.getExpression()) ;
					boolean errorFound = false ;
					int cardinality = 1 ;
					if (cddColl == null) {
						errorFound = true ;
					}
					else {
						cardinality = cddColl.getListOfValues() != null ? cddColl.getListOfValues().getValues().size() : 0 ;
						errorFound = cardinality < valuedProperty.getLower() ;
						if (!errorFound && valuedProperty.getUpper() != -1)
							errorFound = cardinality > valuedProperty.getUpper() ;
					}
					if (errorFound) {
						String message = "The multiplicity of property " 
							+ valuedProperty.getName() 
							+ " is [" 
							+ valuedProperty.getLower()
							+ ".."
							+ (valuedProperty.getUpper() == -1 ? "*" : valuedProperty.getUpper())
							+ "]. " ;
						if (cddColl != null) {
							message += "The expression doest not match the expected multiplicity (cardinality = " 
										+ cardinality 
										+ ").";
						}
						else {
							message += "The VSL syntax for collections must be used, i.e., '{'<EXPRESSION>(','<EXPRESSION>)*'}'" ;
						}
						error(message, StereotypeApplicationWithVSLPackage.eINSTANCE.getExpressionValueRule_Expression()) ;
						valid_Expression = false ;
					}
					else {
						valid_Expression = true ;
					}
				}
				else {
					CollectionOrTuple cddColl = VSLJavaValidator.isACollection(expressionValueRule.getExpression()) ;
					if (cddColl != null) {
						String message = "The property " 
							+ valuedProperty.getName() 
							+ " is not a collection. The expression doest not match the expected multiplicity.";
						error(message, StereotypeApplicationWithVSLPackage.eINSTANCE.getExpressionValueRule_Expression()) ;
						valid_Expression = false ;
					}
					else {
						valid_Expression = true ;
					}
				}
			}
			else {
				error(validationResult.errorMessage(),
						validationResult.validatedRule(),
						validationResult.validatedFeature(),
						INSIGNIFICANT_INDEX) ;
				valid_Expression = false ;
			}
		}
	}
	
}
