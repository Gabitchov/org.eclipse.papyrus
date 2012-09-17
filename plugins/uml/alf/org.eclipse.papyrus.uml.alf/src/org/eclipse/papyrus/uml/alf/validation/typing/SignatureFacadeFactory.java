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
package org.eclipse.papyrus.uml.alf.validation.typing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationTupleElement;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.uml.alf.scoping.AlfScopeProvider;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;

public class SignatureFacadeFactory {

	public static SignatureFacadeFactory eInstance = new SignatureFacadeFactory() ;
	
	public SignatureFacade createSignatureFacade(EObject o) {
		return new SignatureFacade(o) ;
	}
	
	public SignatureFacade createConstructorFacade(InstanceCreationExpression exp) throws Exception {
		List<TypeExpression> arguments = new ArrayList<TypeExpression>() ;
		Map<String, TypeExpression> argumentsMap = new HashMap<String, TypeExpression>() ;
		
		if (exp.getTuple().getInstanceCreationTupleElement() != null) {
			for (InstanceCreationTupleElement tupleElement : exp.getTuple().getInstanceCreationTupleElement()) {
				TypeExpression typeOfArgument = new TypeUtils().getTypeOfExpression(tupleElement.getObject()) ;
				if (typeOfArgument.getTypeFacade() instanceof ErrorTypeFacade)
					throw new TypeInferenceException(typeOfArgument) ;
				arguments.add(typeOfArgument) ;
				argumentsMap.put(tupleElement.getRole(), typeOfArgument) ;
			}
		}
		
		// first try to determine if the expression directly refers to a Class or a DataType
		TypeFacade cddClassifier = TypeFacadeFactory.eInstance.createVoidFacade(exp.getConstructor()) ;
		boolean errorInResolutionOfClassifier = false ;
		if (cddClassifier instanceof ErrorTypeFacade) {
			errorInResolutionOfClassifier = true ;
		}
		else {
			Classifier referencedType = cddClassifier.extractActualType() ;
			if (referencedType instanceof PrimitiveType) {
				throw new Exception("Constructor invocations do not apply to primitive types") ;
			}
			if (referencedType instanceof Enumeration) {
				throw new Exception("Constructor invocations do not apply to enumerations") ;
			}
			if (referencedType.isAbstract()) {
				throw new Exception("Abstract classifiers cannot be instantiated") ;
			}

			// The classifier has been resolved. Must determine if arguments match with possible constructors
			if (referencedType instanceof org.eclipse.uml2.uml.Class) {
				List<EObject> visibleConstructor = AlfScopeProvider.scopingTool.getVisibleOperationsOrBehaviors(referencedType).resolveByName(referencedType.getName()) ;
				if (visibleConstructor.size() > 1) {
					// try to match with arguments
					// if does not match, raise an exception
					List<SignatureFacade> visibleConstructorSignatures = new ArrayList<SignatureFacade>() ;
					for (EObject cddConstructor : visibleConstructor) {
						SignatureFacade cddConstructorSignature = SignatureFacadeFactory.eInstance.createSignatureFacade(cddConstructor) ;
						if (cddConstructorSignature.isAConstructor())
							visibleConstructorSignatures.add(cddConstructorSignature) ;
					}
					List<SignatureFacade> matchingSignatures = SignatureFacade.findNearestSignature(arguments, visibleConstructorSignatures) ;
					if (matchingSignatures.size() > 1) {
						String errorMessage = referencedType.getName() + "(" ;
						boolean first = true ;
						for (TypeExpression arg : arguments) {
							if (first) first = false ; else errorMessage += ", " ;
							errorMessage += arg.getLabel() ;
						}
						errorMessage += ") resolves to multiple constructors" ;
						throw new Exception(errorMessage) ;
					}
					else if (matchingSignatures.size() == 0) {
						String errorMessage = "Constructor " + referencedType.getName() + "(" ;
						boolean first = true ;
						for (TypeExpression arg : arguments) {
							if (first) first = false ; else errorMessage += ", " ;
							errorMessage += arg.getLabel() ;
						}
						errorMessage += ") is undefined" ;
						throw new Exception(errorMessage) ;
					}
					else { // exactly one match
						return matchingSignatures.get(0) ;
					}
				}
				else if (visibleConstructor.size() == 0) {
					if (arguments.size() > 0) {
						// Throw an exception
						String errorMessage = "Constructor " + referencedType.getName() + "(";
						boolean first = true ;
						for (TypeExpression t : arguments) {
							if (first) first = false ; else errorMessage += ", " ;
							errorMessage += t.getLabel() ;
						}
						errorMessage += ") is undefined" ;
						throw new Exception(errorMessage) ;
					}
					return new DefaultConstructorFacade((Class)referencedType) ;
				}
				else { // exactly one constructor found
					// Tries to determine if arguments match
					SignatureFacade constructor = createSignatureFacade(visibleConstructor.get(0)) ;
					if (!constructor.isAConstructor()) {
						// Throw an exception
						String errorMessage = "Constructor " + referencedType.getName() + "(";
						boolean first = true ;
						for (TypeExpression t : arguments) {
							if (first) first = false ; else errorMessage += ", " ;
							errorMessage += t.getLabel() ;
						}
						errorMessage += ") is undefined" ;
						throw new Exception(errorMessage) ;
					}
					String potentialErrorMessage = constructor.isCompatibleWithMe(argumentsMap) ;
					if (potentialErrorMessage.length() == 0)
						return constructor ;
					else
						throw new Exception(potentialErrorMessage) ;
				}
			}
			else if (referencedType instanceof DataType){ // This is a data type. 
				//must match arguments with visible properties of the data type
				SignatureFacade defaultDataTypeConstructor = new DefaultConstructorFacade((DataType)referencedType) ;
				String errorMessage = defaultDataTypeConstructor.isCompatibleWithMe(argumentsMap) ;
				if (!(errorMessage.length() == 0))
					throw new Exception(errorMessage) ;
				else
					return defaultDataTypeConstructor ;
			}
		}

		if (errorInResolutionOfClassifier) {
			// We can try again, but considering that:
			// - the last element in the qualified name as the name of a constructor
			// - the element before the last element is a class name

			if (exp.getConstructor().getRemaining() == null)
				throw new Exception("Constructor " + exp.getConstructor().getId() + " is undefined") ;

			QualifiedNameWithBinding remaining = exp.getConstructor() ;
			QualifiedNameWithBinding cddClassName = exp.getConstructor() ;
			QualifiedNameWithBinding cddConstructorName = exp.getConstructor() ;
			EObject previousPackage = null ;

			while (cddConstructorName.getRemaining() != null) {
				cddClassName = cddConstructorName ;
				cddConstructorName = cddConstructorName.getRemaining() ;
			}

			if (remaining != cddClassName) {
				List<EObject> visiblePackages = AlfScopeProvider.scopingTool.getVisiblePackages(exp).resolveByName(remaining.getId()) ;
				if (visiblePackages.isEmpty()) {
					throw new Exception("Could not resolve package " + remaining.getId()) ;
				}
				else if (visiblePackages.size() > 1) {
					throw new Exception(remaining.getId() + " resolves to multiple packages") ;
				}
				else {
					List<EObject> nestedVisiblePackages ;
					previousPackage = visiblePackages.get(0) ;
					remaining = remaining.getRemaining() ;
					while (remaining != cddClassName) {
						nestedVisiblePackages = AlfScopeProvider.scopingTool.getVisiblePackages(previousPackage).resolveByName(remaining.getId()) ;
						if (nestedVisiblePackages.isEmpty()) {
							throw new Exception("Could not resolve package " + remaining.getId()) ;
						}
						else if (nestedVisiblePackages.size() > 1) {
							throw new Exception(remaining.getId() + " resolves to multiple packages") ;
						}
						previousPackage = nestedVisiblePackages.get(0) ;
						remaining = remaining.getRemaining() ;
					}
				}
			}


			// At this point, the (potential) path has been validated
			// cddClassName should resolve to a classifier
			List<EObject> visibleClassifiers = null ;
			EObject resolvedClassifier = null ;
			if (previousPackage != null) 
				visibleClassifiers = AlfScopeProvider.scopingTool.getVisibleClassifiers(previousPackage).resolveByName(cddClassName.getId()) ;
			else
				visibleClassifiers = AlfScopeProvider.scopingTool.getVisibleClassifiers(exp).resolveByName(cddClassName.getId()) ;
			if (visibleClassifiers.isEmpty()) {
				throw new Exception("Could not resolve classifier " + cddClassName.getId()) ;
			}
			else if (visibleClassifiers.size() > 1) {
				throw new Exception(remaining.getId() + " resolves to multiple classifiers.") ;
			}
			else {
				resolvedClassifier = visibleClassifiers.get(0) ;
			}
			List<EObject> visibleConstructor = AlfScopeProvider.scopingTool.getVisibleOperationsOrBehaviors(resolvedClassifier).resolveByName(cddConstructorName.getId()) ;
			if (visibleConstructor.size() > 1) {
				// try to match with arguments
				// if does not match, raise an exception
				List<SignatureFacade> visibleConstructorSignatures = new ArrayList<SignatureFacade>() ;
				for (EObject cddConstructor : visibleConstructor) {
					SignatureFacade cddConstructorSignature = SignatureFacadeFactory.eInstance.createSignatureFacade(cddConstructor) ;
					if (cddConstructorSignature.isAConstructor())
						visibleConstructorSignatures.add(cddConstructorSignature) ;
				}
				List<SignatureFacade> matchingSignatures = SignatureFacade.findNearestSignature(arguments, visibleConstructorSignatures) ;
				if (matchingSignatures.size() > 1) {
					String errorMessage = cddConstructorName.getId() + "(" ;
					boolean first = true ;
					for (TypeExpression arg : arguments) {
						if (first) first = false ; else errorMessage += ", " ;
						errorMessage += arg.getLabel() ;
					}
					errorMessage += ") resolves to multiple constructors" ;
					throw new Exception(errorMessage) ;
				}
				else if (matchingSignatures.size() == 0) {
					String errorMessage = "Constructor " + cddConstructorName.getId() + "(" ;
					boolean first = true ;
					for (TypeExpression arg : arguments) {
						if (first) first = false ; else errorMessage += ", " ;
						errorMessage += arg.getLabel() ;
					}
					errorMessage += ") is undefined" ;
					throw new Exception(errorMessage) ;
				}
				else { // exactly one match
					return matchingSignatures.get(0) ;
				}
			}
			else if (visibleConstructor.size() == 0) {
				String errorMessage = "Constructor " + cddConstructorName.getId() + "(" ;
				boolean first = true ;
				for (TypeExpression arg : arguments) {
					if (first) first = false ; else errorMessage += ", " ;
					errorMessage += arg.getLabel() ;
				}
				errorMessage += ") is undefined" ;
				throw new Exception(errorMessage) ;
			}
			else { // exactly one constructor
				// Tries to determine if arguments match
				SignatureFacade constructor = createSignatureFacade(visibleConstructor.get(0)) ;
				if (!constructor.isAConstructor()) {
					// Throw an exception
					String errorMessage = "Constructor " + cddConstructorName.getId() + "(";
					boolean first = true ;
					for (TypeExpression t : arguments) {
						if (first) first = false ; else errorMessage += ", " ;
						errorMessage += t.getLabel() ;
					}
					errorMessage += ") is undefined" ;
					throw new Exception(errorMessage) ;
				}
				String potentialErrorMessage = constructor.isCompatibleWithMe(arguments, true) ;
				if (potentialErrorMessage.length() == 0)
					return constructor ;
				else
					throw new Exception(potentialErrorMessage) ;
			}
		}

		throw new Exception("Not supported case") ;
	}
}
