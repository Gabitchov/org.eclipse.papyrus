/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.operation.editor.xtext.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.alf.scoping.AlfScopeProvider;
import org.eclipse.papyrus.alf.validation.AlfJavaValidator;
import org.eclipse.papyrus.alf.validation.typing.AssignmentPolicy;
import org.eclipse.papyrus.alf.validation.typing.ErrorTypeFacade;
import org.eclipse.papyrus.alf.validation.typing.MultiplicityFacadeFactory;
import org.eclipse.papyrus.alf.validation.typing.SignatureFacade;
import org.eclipse.papyrus.alf.validation.typing.SignatureFacadeFactory;
import org.eclipse.papyrus.alf.validation.typing.TypeExpression;
import org.eclipse.papyrus.alf.validation.typing.TypeFacade;
import org.eclipse.papyrus.alf.validation.typing.TypeFacadeFactory;
import org.eclipse.papyrus.operation.editor.xtext.operation.FormalParameter;
import org.eclipse.papyrus.operation.editor.xtext.operation.Multiplicity;
import org.eclipse.papyrus.operation.editor.xtext.operation.MultiplicityRange;
import org.eclipse.papyrus.operation.editor.xtext.operation.OperationDefinitionOrStub;
import org.eclipse.papyrus.operation.editor.xtext.operation.OperationPackage;
import org.eclipse.papyrus.operation.editor.xtext.operation.TypeName;
import org.eclipse.papyrus.operation.editor.xtext.operation.TypePart;
import org.eclipse.papyrus.operation.editor.xtext.scoping.OperationEditorScopingTool;
import org.eclipse.papyrus.operation.editor.xtext.scoping.OperationScopeProvider;
import org.eclipse.papyrus.operation.editor.xtext.validation.typing.OperationEditorAssignmentPolicy;
import org.eclipse.papyrus.operation.editor.xtext.validation.typing.OperationEditorMultiplicityFacadeFactory;
import org.eclipse.papyrus.operation.editor.xtext.validation.typing.OperationEditorSignatureFacadeFactory;
import org.eclipse.papyrus.operation.editor.xtext.validation.typing.OperationEditorTypeFacadeFactory;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace; 
import org.eclipse.uml2.uml.Operation;
import org.eclipse.xtext.validation.Check;

public class OperationJavaValidator extends AbstractOperationJavaValidator {

	private static Namespace model ;
	private static Element contextElement ;
	private static boolean valid_abstract_part = true ;
	private static boolean valid_formal_parameters = true ;
	private static boolean valid_return_parameter = true ;
	private static boolean valid_distinguishable_signature = true ;
	
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.papyrus.operation.editor.xtext.operation.OperationPackage.eINSTANCE);
	    result.add(org.eclipse.papyrus.alf.alf.AlfPackage.eINSTANCE);
		return result;
	}

	public static void init(Element _contextElement) {
		contextElement = _contextElement ;
		AlfJavaValidator.setContextClassifier((Classifier)((Operation)contextElement).getNamespace()) ;
		AlfScopeProvider.scopingTool = new OperationEditorScopingTool() ;
		TypeFacadeFactory.eInstance = new OperationEditorTypeFacadeFactory() ;
		MultiplicityFacadeFactory.eInstance = new OperationEditorMultiplicityFacadeFactory() ;
		SignatureFacadeFactory.eInstance = new OperationEditorSignatureFacadeFactory() ;
		AssignmentPolicy.eInstance = new OperationEditorAssignmentPolicy() ;
		if (contextElement != null) {
			Element elem = contextElement.getOwner() ;
			while (elem.getOwner() != null) {
				elem = elem.getOwner() ;
			}
			model = (Namespace)elem ;
		}
	}

	public static Namespace getModel() {
		return model ;
	}
	
	public static Element getContextElement() {
		return contextElement ;
	}
	
	public static boolean validate() {
		return valid_abstract_part && valid_formal_parameters && valid_distinguishable_signature ;
	}

	
	/**
	 * @param declaration
	 * 
	 *  Checks the following rules:
	 *  1. Checks if the operation is valid with respect to the fact it is abstract or not
	 *  2. Checks if formal parameters carry type/multiplicity errors
	 *  3. Checks if return parameter carries type/multiplicity errors
	 *  4. If there are no errors with formal parameters, check if operation is distinguishable from others
	 *  5. //TODO Check if the operation can actually redefine identified redefined operations
	 */
	@Check
	public void checkOperationDefinitionOrStub(OperationDefinitionOrStub declaration) {
		valid_abstract_part = false ;
		// 1. Checks if the operation is valid with respect to the fact it is abstract or not
		if (declaration.getDeclaration() != null 
				&& declaration.getDeclaration().isAbstract() 
				&& declaration.getBody() != null) {
			String errorMessage = "An abstract operation cannot specify a body." ;
			error(errorMessage, OperationPackage.eINSTANCE.getOperationDefinitionOrStub_Body()) ;
		}
		else if (declaration.getDeclaration() != null 
				&& declaration.getDeclaration().isAbstract() == false
				&& declaration.getBody() == null) {
			String errorMessage = "The operation should be abstract or specify a body." ;
			error(errorMessage, OperationPackage.eINSTANCE.getOperationDefinitionOrStub_Body()) ;
		}
		valid_abstract_part = true ;
		
		// 2. Checks if formal parameters carry type/multiplicity errors
		valid_formal_parameters = true ;
		if (declaration.getDeclaration() != null && declaration.getDeclaration().getFormalParameters().getFormalParameterList() != null) {
			for (FormalParameter param : declaration.getDeclaration().getFormalParameters().getFormalParameterList().getFormalParameter()) {
				checkFormalParameter(param) ;
			}
		}
		
		// 3. Checks if return parameter carries type/multiplicity errors
		valid_return_parameter = true ;
		if (OperationScopeProvider.scopingTool.isAReturnStatementExpected(declaration)) {
			TypeExpression expectedType = OperationScopeProvider.scopingTool.getExpectedReturnType(declaration) ;
			if (expectedType.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)expectedType.getTypeFacade() ;
				error (error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				valid_return_parameter = true ;
			}
			if (declaration.getDeclaration().getReturnType().getMultiplicity() != null) {
				Multiplicity multiplicity = declaration.getDeclaration().getReturnType().getMultiplicity() ;
				if (multiplicity.getRange() != null) {
					MultiplicityRange range = multiplicity.getRange() ;
					String lower = "" ;
					String upper = "" ;
					int lowerValue = 0 ;
					int upperValue = 0 ;
					if (range.getLower() != null)
						lower += range.getLower().getValue() ;
					if (range.getUpper() != null)
						upper += range.getUpper().getValue() ;
					if (! upper.isEmpty()) {
						if (upper.equals("*"))
							upperValue = -1 ; // multiplicity is valid
						else {
							try {
								upperValue = new Integer(upper).intValue() ;
							}
							catch (NumberFormatException e) {
								error("Invalid upper bound", range, OperationPackage.eINSTANCE.getMultiplicityRange_Upper(), INSIGNIFICANT_INDEX) ;
								valid_return_parameter = true ;
							}
						}
					}
					if (! lower.isEmpty()) {
						if (lower.equals("*")) {
							error("Invalid lower bound", range, OperationPackage.eINSTANCE.getMultiplicityRange_Lower(), INSIGNIFICANT_INDEX) ;
							valid_return_parameter = true ;
						}
						else {
							try {
								lowerValue = new Integer(lower).intValue() ;
							}
							catch (NumberFormatException e) {
								error("Invalid lower bound", range, OperationPackage.eINSTANCE.getMultiplicityRange_Lower(), INSIGNIFICANT_INDEX) ;
								valid_return_parameter = true ;
							}
							if (lowerValue > upperValue && upperValue != -1) {
								error("Lower bound must not be greater than upper bound)", range, OperationPackage.eINSTANCE.getMultiplicityRange_Lower(), INSIGNIFICANT_INDEX) ;
								valid_return_parameter = true ;
							}
						}
					}
				}
			}
		}
		
		// 4. If there are no errors with formal parameters, check if operation is distinguishable from others
		valid_distinguishable_signature = true ;
		if (valid_formal_parameters && valid_return_parameter && declaration.getDeclaration() != null) {
			List<SignatureFacade> otherOperations = new ArrayList<SignatureFacade>() ;
			for (NamedElement n : ((Classifier)contextElement.getOwner()).getOwnedMembers()) {
				if (n instanceof Operation && n != contextElement)
					otherOperations.add(SignatureFacadeFactory.eInstance.createSignatureFacade(n)) ;
			}
			SignatureFacade editedOperationSignature = SignatureFacadeFactory.eInstance.createSignatureFacade(declaration.getDeclaration()) ;
			List<SignatureFacade> isNotDistinguishableFrom = editedOperationSignature.isNotDistinguishableFrom(otherOperations);
			if (! isNotDistinguishableFrom.isEmpty()) {
				String errorMessage = editedOperationSignature.getLabel() + " is not distinguishable from the following signatures:" ;
				for (SignatureFacade s : isNotDistinguishableFrom) {
					errorMessage += "'\n . " + s.getLabel() ;
				}
				error (errorMessage, OperationPackage.eINSTANCE.getOperationDefinitionOrStub_Declaration()) ;
				valid_distinguishable_signature = false ;
			}
		}
		
		// 5. //TODO Check if the operation can actually redefine identified redefined operations
		if (declaration.getDeclaration().getRedefinition() != null) {
			String warningMessage = "Redefinitions are ignored in this version of the Alf editor" ;
			warning(warningMessage, declaration.getDeclaration(), OperationPackage.eINSTANCE.getOperationDeclaration_Redefinition(), INSIGNIFICANT_INDEX) ;
		}
	}
	
	
	private void checkFormalParameter(FormalParameter param) {
		if (param.getType() != null) {
			// first checks if all types can be resolved
			TypePart typePart = param.getType() ;
			if (typePart.getTypeName() != null) {
				TypeName typeName = typePart.getTypeName() ;
				if (typeName.getQualifiedName() != null) {
					TypeFacade typeFacade = TypeFacadeFactory.eInstance.createVoidFacade(typeName.getQualifiedName()) ;
					if (typeFacade instanceof ErrorTypeFacade) {
						ErrorTypeFacade error = (ErrorTypeFacade)typeFacade ;
						error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
						valid_formal_parameters = false ;
					}
				}
			}
			// then checks if multiplicities are correct
			if (typePart.getMultiplicity() != null) {
				Multiplicity multiplicity = typePart.getMultiplicity() ;
				if (multiplicity.getRange() != null) {
					MultiplicityRange range = multiplicity.getRange() ;
					String lower = "" ;
					String upper = "" ;
					int lowerValue = 0 ;
					int upperValue = 0 ;
					if (range.getLower() != null)
						lower += range.getLower().getValue() ;
					if (range.getUpper() != null)
						upper += range.getUpper().getValue() ;
					if (! upper.isEmpty()) {
						if (upper.equals("*"))
							upperValue = -1 ; // multiplicity is valid
						else {
							try {
								upperValue = new Integer(upper).intValue() ;
							}
							catch (NumberFormatException e) {
								error("Invalid upper bound", range, OperationPackage.eINSTANCE.getMultiplicityRange_Upper(), INSIGNIFICANT_INDEX) ;
								valid_formal_parameters = false ;
							}
						}
					}
					if (! lower.isEmpty()) {
						if (lower.equals("*")) {
							error("Invalid lower bound", range, OperationPackage.eINSTANCE.getMultiplicityRange_Lower(), INSIGNIFICANT_INDEX) ;
							valid_formal_parameters = false ;
						}
						else {
							try {
								lowerValue = new Integer(lower).intValue() ;
							}
							catch (NumberFormatException e) {
								error("Invalid lower bound", range, OperationPackage.eINSTANCE.getMultiplicityRange_Lower(), INSIGNIFICANT_INDEX) ;
								valid_formal_parameters = false ;
							}
							if (lowerValue > upperValue && upperValue != -1) {
								error("Lower bound must not be greater than upper bound)", range, OperationPackage.eINSTANCE.getMultiplicityRange_Lower(), INSIGNIFICANT_INDEX) ;
								valid_formal_parameters = false ;
							}
						}
					}
				}
			}
		}
	}

	
}
