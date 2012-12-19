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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.TemplateableElement;

public class SignatureFacade {

	private String name = "";
	protected List<TypeExpression> parameters = new ArrayList<TypeExpression>();
	//
	protected Map<String, TypeExpression> parametersMap = new HashMap<String, TypeExpression>() ;
	//
	//private TypeExpression returnType = TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._undefined, 0, 0, false, false) ;
	private TypeExpression returnType = null ;
	private EObject actualSignatureObject = null ;
	
	public EObject getActualSignatureObject() {
		return actualSignatureObject;
	}

	public SignatureFacade() {
		
	}
	
	public SignatureFacade(EObject o) {
		if (o instanceof Operation) {
			Operation operation = (Operation)o ;
			this.actualSignatureObject = operation ;
			this.name = operation.getName() ;
			for (Parameter p : operation.getOwnedParameters()) {
				if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
					returnType = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
				else {
					TypeExpression typeOfP = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
					parameters.add(typeOfP) ;
					parametersMap.put(p.getName(), typeOfP) ;
				}
			}
		}
		else if (o instanceof Behavior) {
			Behavior behavior = (Behavior) o ;
			this.actualSignatureObject = behavior ;
			this.name = behavior.getName() ;
			for (Parameter p : behavior.getOwnedParameters()) {
				if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
					returnType = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
				else {
					TypeExpression typeOfP = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
					parameters.add(typeOfP) ;
					parametersMap.put(p.getName(), typeOfP) ;
				}
			}
		}
		else if (o instanceof ElementImport) {
			ElementImport eImport = (ElementImport)o ;
			if (eImport.getImportedElement() instanceof Behavior) {
				Behavior b = (Behavior)eImport.getImportedElement() ;
				this.actualSignatureObject = b ;
				if (eImport.getAlias() != null)
					this.name = eImport.getAlias() ;
				else
					this.name = b.getName() ;
				for (Parameter p : b.getOwnedParameters()) {
					if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL)
						returnType = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
					else {
						TypeExpression typeOfP = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
						parameters.add(typeOfP) ;
						parametersMap.put(p.getName(), typeOfP) ;
					}
				}
			}
		}
		else if (o instanceof Reception) {
			Reception r = (Reception)o ;
			this.actualSignatureObject = r ;
			this.name = r.getName() ;
			if (r.getSignal() != null) {
				for (Property p : r.getSignal().getAllAttributes()) {
					TypeExpression typeOfP = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
					parameters.add(typeOfP) ;
					parametersMap.put(p.getName(), typeOfP) ;
				}
			}
		}
	}
	
	public String getName() {
		return name ;
	}
	
	public void setName(String name) {
		this.name = "" + name ;
	}
	
	public List<TypeExpression> getParameters() {
		return parameters ;
	}
	
	public boolean hasReturnType() {
		return returnType != null ;
	}
	
	public TypeExpression getReturnType() {
		return returnType ;
	}
	
	public void setReturnType(TypeExpression returnType) {
		this.returnType = returnType ;
	}
	
	public String isCompatibleWithMe(List<TypeExpression> arguments, boolean getErrorMessage) {
		int compatibilityLevel = this.isCompatibleWithMe(arguments) ;
		String errorMessage = "" ;
		if (compatibilityLevel == 0) {
			errorMessage += this.getLabel() + " does not apply to arguments " ;
			String argumentsString = "(" ;
			boolean first = true ;
			for (TypeExpression type : arguments) {
				if (!first) argumentsString += ", " ; else first = false ;
				argumentsString += type.getLabel() ;
			}
			argumentsString += ")" ;
			errorMessage += argumentsString ;
		}
		return errorMessage ;
	}
	
	public String getLabel() {
		String label = name + "(" ;
		boolean first = true ;
		for (TypeExpression type : parameters) {
			if (!first) label += ", " ; else first = false ;
			label += type.getLabel() ;
		}
		label += ")" ;
		return label ;
	}
	
	public int isCompatibleWithMe(List<TypeExpression> arguments) {
		if (arguments.size() != parameters.size())
			return 0 ;
		else if (arguments.size() == 0 )
			return 3 ;
		int compatibilityLevel = 0 ;
		boolean first = true ;
		for (int i = 0 ; i < parameters.size() ; i++) {
			int currentCompatibilityLevel = parameters.get(i).isCompatibleWithMe(arguments.get(i)) ;
			if (first && currentCompatibilityLevel < 3)
				return 0 ; //TODO: temporary solution. this is to give a higher value to the first argument if it perfectly matches. Should probably consider the context... Check the spec...
			if (currentCompatibilityLevel == 0)
				return 0 ;
			else {
				compatibilityLevel += currentCompatibilityLevel ;
			}
			first = false ;
		}
		return compatibilityLevel ;
	}
	
	public String isCompatibleWithMe(Map<String,TypeExpression> arguments) {
		if (arguments.keySet().size() == 0 )
			return "" ;
		String compatibility = "" ;
		for (String parameterName : arguments.keySet()) {
			if (parametersMap.get(parameterName) == null) {
				compatibility += "Parameter " + parameterName + " is undefined\n"; 
			}
			else {
				int compatibilityLevel = parametersMap.get(parameterName).isCompatibleWithMe(arguments.get(parameterName)) ;
				if (compatibilityLevel == 0) {
					compatibility += "Parameter " + parameterName + " requires an argument of type " + parametersMap.get(parameterName).getLabel() + "\n" ;
				}
			}
		}
		return compatibility ;
	}
	
	public static List<SignatureFacade> findNearestSignature(List<TypeExpression> arguments, List<SignatureFacade> candidates) {
		List<SignatureFacade> matchingSignatures = new ArrayList<SignatureFacade>() ;
		int bestScore = 0 ;
		for (SignatureFacade cddMatchingSignature : candidates) {
			int currentScore = cddMatchingSignature.isCompatibleWithMe(arguments) ;
			if (currentScore != 0) {
				if (currentScore >= bestScore) {
					if (currentScore > bestScore)
						matchingSignatures.clear() ;
					matchingSignatures.add(cddMatchingSignature) ;
					bestScore = currentScore ;
				}
			}
		}
		return matchingSignatures ;
	}
	
	public static List<SignatureFacade> findNearestConstructorSignature(Map<String, TypeExpression> arguments, List<SignatureFacade> candidates) {
		List<SignatureFacade> matchingSignatures = new ArrayList<SignatureFacade>() ;
		for (SignatureFacade cddMatchingSignature : candidates) {
			String compatibility = cddMatchingSignature.isCompatibleWithMe(arguments) ;
			if (compatibility.length()==0) {
				matchingSignatures.add(cddMatchingSignature) ;
			}
		}
		return matchingSignatures ;
	}
	
	public List<SignatureFacade> isNotDistinguishableFrom(List<SignatureFacade> candidates) {
		List<SignatureFacade> matchingSignatures = new ArrayList<SignatureFacade>() ;
		for (SignatureFacade cddMatchingSignature : candidates) {
			if (this.name.equals(cddMatchingSignature.getName())) {
				if (this.parameters.size() == cddMatchingSignature.parameters.size()) {
					boolean parameterThatDoesNotMatchFound = false ;
					for (int i = 0 ; i < this.parameters.size() && !parameterThatDoesNotMatchFound ; ) {
						int compatibilityLevel = this.parameters.get(i).isCompatibleWithMe(cddMatchingSignature.getParameters().get(i)) ;
						if (compatibilityLevel != 3)
							parameterThatDoesNotMatchFound = true ;
						i++ ;
					}
					if (!parameterThatDoesNotMatchFound) {
						matchingSignatures.add(cddMatchingSignature) ;
					}
				}
			}
		}
		return matchingSignatures ;
	}
	
	public boolean equals(Operation o) {
		return this.actualSignatureObject == o ;
	}
	
	public boolean equals(Behavior b) {
		return this.actualSignatureObject == b ;
	}
	
	public boolean isAConstructor() {
		Element signature = null ;
		if (actualSignatureObject instanceof Operation || actualSignatureObject instanceof Behavior)
			signature = (Element)actualSignatureObject ;
		else if (actualSignatureObject instanceof ElementImport)
			signature = (Element)((ElementImport)actualSignatureObject).getImportedElement() ;
		if (signature == null)
			return false ;
		return signature.getAppliedStereotype("Standard::Create") != null ; 
	}
	
	public boolean isADestructor() {
		Element signature = null ;
		if (actualSignatureObject instanceof Operation || actualSignatureObject instanceof Behavior)
			signature = (Element)actualSignatureObject ;
		else if (actualSignatureObject instanceof ElementImport)
			signature = (Element)((ElementImport)actualSignatureObject).getImportedElement() ;
		if (signature == null)
			return false ;
		return signature.getAppliedStereotype("Standard::Destroy") != null ;
	}
	
	public Map<String, TypeExpression> getParametersMap() {
		return this.parametersMap ;
	}
	
	public boolean isATemplate() {
		if (this.actualSignatureObject instanceof TemplateableElement) {
			return ((TemplateableElement)this.actualSignatureObject).isTemplate() ;
		}
		return false ;
	}
	
}
