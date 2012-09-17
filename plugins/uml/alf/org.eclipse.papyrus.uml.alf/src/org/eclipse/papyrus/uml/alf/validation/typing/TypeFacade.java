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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.alf.Expression;
import org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression;
import org.eclipse.papyrus.uml.alf.alf.SuffixExpression;
import org.eclipse.papyrus.uml.alf.validation.AlfJavaValidator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.TypedElement;

public class TypeFacade {

	protected EObject typeObject ;
	
	public void setTypeObject(EObject typeObject) {
		this.typeObject = typeObject ;
		//TODO this.templateBindingFacade = TemplateBindingFacadeFactory.eInstance.createTemplateBindingFacade(typeObject) ;
	}
	
	public String getLabelWithoutBinding() {
		if (typeObject == null)
			return "<Undefined>" ;
		return "" ;
	}

	public int isCompatibleWithMe(TypeFacade type) {
		Classifier myType = extractActualType(this) ;
		if (myType == null) // i.e. any
			return 3 ;
		Classifier hisType = extractActualType(type) ;
		if (hisType == null)
			return 0 ;
		if (perfectMatch(myType, hisType))
			return 3 ;
		//else if (autoConversionMatch(myType, hisType)) TODO: temporarily commented. Rules need to be clarified
		//	return 2 ;
		else if (inheritanceMatch(myType, hisType))
			return 1 ;
		else
			return 0 ;
	}

	private boolean perfectMatch(Classifier myType, Classifier hisType) {
		boolean myTypeIsPredefined = 
					myType.getName().equals("Integer") ||
					myType.getName().equals("String") ||
					myType.getName().equals("Boolean") ||
					myType.getName().equals("UnlimitedNatural");
		boolean hisTypeIsPredefined = 
			hisType.getName().equals("Integer") ||
			hisType.getName().equals("String") ||
			hisType.getName().equals("Boolean") ||
			hisType.getName().equals("UnlimitedNatural");
		
		if (myTypeIsPredefined && hisTypeIsPredefined)
			return myType.getName().equals(hisType.getName()) ;
		
		return myType == hisType ;
	}
	
	private boolean autoConversionMatch(Classifier myType, Classifier hisType) {
		String autoConvertionOperatorName = "To" + myType.getName() ;
		List<SignatureFacade> availableConversionOperator = 
				AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures(autoConvertionOperatorName) ;
		if (availableConversionOperator.isEmpty())
			return false ;
		else {
			int numberOfMatchingOperators = 0 ;
			for (SignatureFacade cddMatchingConvertionOperator : availableConversionOperator) {
				Classifier parameterType = extractActualType(cddMatchingConvertionOperator.getParameters().get(0).getTypeFacade()) ;
				Classifier returnType = extractActualType(cddMatchingConvertionOperator.getReturnType().getTypeFacade()) ;
				if (perfectMatch(parameterType, hisType) && perfectMatch(returnType, myType))
					numberOfMatchingOperators++ ;
			}
			return numberOfMatchingOperators == 1 ;
		}
	}
	
	private boolean inheritanceMatch(Classifier myType, Classifier hisType) {
		return hisType.getGenerals().contains(myType) ;
	}
	
	public static Classifier extractActualType(TypeFacade t) {
		Classifier actualType = null ;
		if (t.typeObject instanceof Classifier)
			actualType = (Classifier)t.typeObject ;
		else if (t.typeObject instanceof ElementImport){
			ElementImport eImport = (ElementImport)t.typeObject ;
			if (eImport.getImportedElement() instanceof Classifier)
				actualType = (Classifier)eImport.getImportedElement() ;
		}
		else if (t.typeObject instanceof TypedElement) {
			actualType = (Classifier)((TypedElement)t.typeObject).getType() ;
		}
		else if (t instanceof VoidFacade) {
			actualType = extractActualType(((VoidFacade)t).getTypeFacade()) ;
		}
		else if (t.typeObject instanceof SequenceExpansionExpression) {
			// first retrieves the expression nesting this sequence variable
			EObject cddExpression = t.typeObject.eContainer() ;
			while (! (cddExpression instanceof Expression))
				cddExpression = cddExpression.eContainer() ;
			// infers the type of the nesting expression, ignoring the t.typeObject suffix
			TypeExpression typeOfPrefix = new TypeUtils((SuffixExpression)t.typeObject).getTypeOfExpression((Expression)cddExpression) ;
			actualType = extractActualType(typeOfPrefix.getTypeFacade()) ;
			for (Operation o : actualType.getAllOperations()) {
				if (o.getName().equals("toSequence")) {
					actualType = (Classifier) (o.getReturnResult() != null ? o.getReturnResult().getType() : actualType) ;
				}
			}
		}
		return actualType ;
	}
	
	public Classifier extractActualType() {
		return extractActualType(this) ;
	}
	
	public boolean isAbstract() {
		Classifier myType = extractActualType() ;
		return myType != null ? myType.isAbstract() : false ;  
	}
	
	public boolean isATemplate() {
		Classifier myType = extractActualType() ;
		return myType != null ? myType.isTemplate() : false ;  
	}
	
	public boolean equals(Classifier c) {
		return this.typeObject == c ;
	}

	public boolean isACollection() {
		return 
			this.isCompatibleWithMe(TypeUtils._Collection) > 0 
			|| this.isCompatibleWithMe(TypeUtils._Set) > 0 
			|| this.isCompatibleWithMe(TypeUtils._Bag) > 0 
			|| this.isCompatibleWithMe(TypeUtils._Queue) > 0 
			|| this.isCompatibleWithMe(TypeUtils._OrderedSet) > 0 
			|| this.isCompatibleWithMe(TypeUtils._List) > 0 
			|| this.isCompatibleWithMe(TypeUtils._Deque) > 0 
			|| this.isCompatibleWithMe(TypeUtils._Map) > 0 ;
	}

	public boolean isOrdered() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getLabel() {
		return "" ; // TODO: uncomment when template bindings are supported + this.templateBindingFacade.getLabel() ;
	}
	
}
