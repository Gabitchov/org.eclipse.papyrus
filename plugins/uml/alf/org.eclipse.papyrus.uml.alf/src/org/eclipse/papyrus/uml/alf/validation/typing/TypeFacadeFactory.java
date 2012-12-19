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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.uml.alf.alf.AcceptClause;
import org.eclipse.papyrus.uml.alf.alf.AcceptStatement;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.ClassificationExpression;
import org.eclipse.papyrus.uml.alf.alf.Expression;
import org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.LoopVariableDefinition;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression;
import org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression;
import org.eclipse.papyrus.uml.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.uml.alf.scoping.AlfScopeProvider;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TypedElement;

public class TypeFacadeFactory {

	public static TypeFacadeFactory eInstance = new TypeFacadeFactory() ;
	
	public TypeFacade createTypeFacade(EObject typeObject) {
		TypeFacade result = new TypeFacade() {
			@Override
			public String getLabelWithoutBinding() {
				try {
					if (typeObject instanceof Classifier)
						return ((Classifier)typeObject).getName() ;
					if (typeObject instanceof ElementImport) {
						ElementImport eImport = (ElementImport)typeObject ;
						if (eImport.getAlias()!=null )
							return eImport.getAlias() ;
						else
							return ((Classifier)eImport.getImportedElement()).getName() ;
					}
					if (typeObject instanceof Parameter) {
						return ((Parameter)typeObject).getType().getName() ;
					}
					if (typeObject instanceof TypedElement) {
						return ((TypedElement)typeObject).getType().getName() ;
					}
					if (typeObject instanceof SequenceExpansionExpression) {
						TypeFacade t = TypeFacadeFactory.eInstance.createTypeFacade(typeObject) ;
						return t.extractActualType().getName() ;
					}
				}
				catch (NullPointerException e) { // occurs when no type can be derived from typeObject (i.e., typeObject.getType() == null)
					return "any" ;
				}
				return super.getLabel() ;
			}
			
			@Override
			public String getLabel() {
				try {
					if (typeObject instanceof Classifier)
						return ((Classifier)typeObject).getName() + super.getLabel() ;
					if (typeObject instanceof ElementImport) {
						ElementImport eImport = (ElementImport)typeObject ;
						if (eImport.getAlias()!=null )
							return eImport.getAlias() + super.getLabel() ;
						else
							return ((Classifier)eImport.getImportedElement()).getName() + super.getLabel() ;
					}
					if (typeObject instanceof Parameter) {
						return ((Parameter)typeObject).getType().getName() + super.getLabel() ;
					}
					if (typeObject instanceof TypedElement) {
						return ((TypedElement)typeObject).getType().getName() + super.getLabel() ;
					}
					if (typeObject instanceof SequenceExpansionExpression) {
						TypeFacade t = TypeFacadeFactory.eInstance.createTypeFacade(typeObject) ;
						return t.extractActualType().getName() + super.getLabel() ;
					}
					if (typeObject == null)
						return "any" ;
				}
				catch (NullPointerException e) { // occurs when no type can be derived from typeObject (i.e., typeObject.getType() == null)
					return "any" ;
				}
				return super.getLabel() ;
			}
		};
		if (typeObject instanceof Classifier)
			result.setTypeObject(typeObject) ;
		else if (typeObject instanceof ElementImport)
			result.setTypeObject(typeObject) ;
		else if (typeObject instanceof Parameter)
			result.setTypeObject(typeObject) ;
		else if (typeObject instanceof LocalNameDeclarationStatement) {
			LocalNameDeclarationStatement statement = (LocalNameDeclarationStatement)typeObject ;
			if (statement.getType() != null) {
				result.setTypeObject(createVoidFacade(statement.getType()).typeObject);
			}
		}
		else if (typeObject instanceof LoopVariableDefinition) {
			LoopVariableDefinition loopVariable = (LoopVariableDefinition)typeObject ;
			if (loopVariable.getType() != null) {
				result.setTypeObject(createVoidFacade(loopVariable.getType()).typeObject) ;
			}
			else if (loopVariable.getExpression1() != null) {
				TypeExpression typeOfExpression1 = new TypeUtils().getTypeOfExpression(loopVariable.getExpression1()) ;
				if (loopVariable.getExpression2() != null) {
					TypeExpression typeOfExpression2 = new TypeUtils().getTypeOfExpression(loopVariable.getExpression2()) ;
					int _1_2_compatibility = typeOfExpression1.isCompatibleWithMe(typeOfExpression2) ;
					int _2_1_compatibility = typeOfExpression2.isCompatibleWithMe(typeOfExpression1) ;
					if (_1_2_compatibility == _2_1_compatibility) {
						if (_1_2_compatibility != 0) {
							result.setTypeObject(typeOfExpression1.getTypeFacade().typeObject) ;
						}
					}
					else {
						if (_1_2_compatibility > _2_1_compatibility)
							result.setTypeObject(typeOfExpression1.getTypeFacade().typeObject) ;
						else
							result.setTypeObject(typeOfExpression2.getTypeFacade().typeObject) ;
					}
				}
				else {
					result.setTypeObject(typeOfExpression1.getTypeFacade().typeObject) ;
				}
			}
		}
		else if (typeObject instanceof Property) {
			result.setTypeObject(typeObject) ;
		}
		else if (typeObject instanceof SequenceExpansionExpression) {
			result.setTypeObject(typeObject) ;
		}
		else if (typeObject instanceof AcceptStatement) {
			// first extract the accept clause
			AcceptClause acceptClause = (AcceptClause)((AcceptStatement)typeObject).getClause() ;
			if (acceptClause.getQualifiedNameList() != null && !(acceptClause.getQualifiedNameList().getQualifiedName().isEmpty())) {
				// TODO : getQualifiedName is a collection. Should compute the least common ancestor.
				TypeFacade f = TypeFacadeFactory.eInstance.createVoidFacade(acceptClause.getQualifiedNameList().getQualifiedName().get(0)) ;
				result.setTypeObject(f.extractActualType()) ;
			}
			else {
				result.setTypeObject(typeObject) ;
			}
		}
		return result ;
	}
	
	public ErrorTypeFacade createErrorTypeFacade(String message, EObject source, EStructuralFeature structuralFeature) {
		ErrorTypeFacade result = new ErrorTypeFacade() ;
		result.setMessage(message) ;
		result.setErrorSource(source) ;
		result.setStructuralFeature(structuralFeature) ;
		return result ;
	}
	
	public TypeFacade createVoidFacade(Expression exp) {
		NameExpression actualNameExpression = null ;
		for (Iterator<EObject> i = exp.eAllContents() ; i.hasNext() && actualNameExpression == null ; ) {
			EObject o = i.next() ; 
			if (o instanceof NameExpression)
				actualNameExpression = (NameExpression)o ;
		}
		if (actualNameExpression == null)
			return createErrorTypeFacade("A type expression is expected", exp, AlfPackage.eINSTANCE.getConditionalTestExpression_Exp()) ;
		else
			return createVoidFacade(actualNameExpression) ;
	}
	
	public TypeFacade createVoidFacade(NameExpression exp) {
		//if (! (exp.eContainer() instanceof ClassificationExpression ||
		//		exp.eContainer() instanceof SuperInvocationExpression ||
		//		exp.eContainer() instanceof InvocationOrAssignementOrDeclarationStatement)) {
		//	return createErrorTypeFacade("A type expression is expected", exp, AlfPackage.eINSTANCE.getNameExpression_Id()) ;
		//}
		EObject previousPackage = null ;
		if (exp.getPath() != null) {
			List<UnqualifiedName> path = exp.getPath().getNamespace() ;
			// first resolves the first element of the path
			List<EObject> visiblePackages = AlfScopeProvider.scopingTool.getVisiblePackages(exp).resolveByName(path.get(0).getName()) ;
			if (visiblePackages.isEmpty()) {
				return createErrorTypeFacade("Could not resolve package " + path.get(0).getName(), path.get(0), AlfPackage.eINSTANCE.getUnqualifiedName_Name()) ;
			}
			else if (visiblePackages.size() > 1) {
				return createErrorTypeFacade(path.get(0).getName() + " resolves to multiple packages", exp.getPath(), AlfPackage.eINSTANCE.getQualifiedNamePath_Namespace()) ;
			}
			else {
				List<EObject> nestedVisiblePackages ;
				previousPackage = visiblePackages.get(0) ;
				for (int i = 1 ; i<path.size() ; i++) {
					nestedVisiblePackages = AlfScopeProvider.scopingTool.getVisiblePackages(previousPackage).resolveByName(path.get(i).getName()) ;
					if (nestedVisiblePackages.isEmpty()) {
						return createErrorTypeFacade("Could not resolve package " + path.get(i).getName(), path.get(i), AlfPackage.eINSTANCE.getUnqualifiedName_Name()) ;
					}
					else if (nestedVisiblePackages.size() > 1) {
						return createErrorTypeFacade(path.get(i).getName() + " resolves to multiple packages", exp.getPath(), AlfPackage.eINSTANCE.getQualifiedNamePath_Namespace()) ;
					}
					previousPackage = nestedVisiblePackages.get(0) ;
				}
			}
		}
		// At this point, the path has been validated, can check the final id.
		EObject container = exp.eContainer() ;
		if (container instanceof InvocationOrAssignementOrDeclarationStatement) {
			InvocationOrAssignementOrDeclarationStatement cddDclStatement = (InvocationOrAssignementOrDeclarationStatement)container ;
			if (cddDclStatement.getVariableDeclarationCompletion() != null) {
				if (cddDclStatement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() != null) {
					return createErrorTypeFacade("A type expression is expected", cddDclStatement, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ;
				}
				if (exp.getInvocationCompletion() != null ||
						exp.getPostfixOp() != null ||
						exp.getPrefixOp() != null ||
						exp.getSequenceConstructionCompletion() != null ) {// TODO: handle sequence constructions
					return createErrorTypeFacade("A type expression is expected", cddDclStatement, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ;
				}
				List<EObject> visibleClassifiers = null ;
				
				if (previousPackage == null)
					visibleClassifiers = AlfScopeProvider.scopingTool.getVisibleClassifiers(exp).resolveByName(exp.getId()) ;
				else
					visibleClassifiers = AlfScopeProvider.scopingTool.getVisibleClassifiers(previousPackage).resolveByName(exp.getId()) ;
				
				if (visibleClassifiers.isEmpty()) {
					return createErrorTypeFacade("Could not resolve classifier " + exp.getId(), exp, AlfPackage.eINSTANCE.getNameExpression_Id()) ;
				}
				else if (visibleClassifiers.size() > 1) {
					return createErrorTypeFacade(exp.getId() + " resolves to multiple classifiers", 
							cddDclStatement, AlfPackage.eINSTANCE.getNameExpression_Id()) ;
				}
				return new VoidFacade(createTypeFacade(visibleClassifiers.get(0))) ;
			}
		}
		else if (container instanceof ClassificationExpression) {
			// TODO
		}
		else if (container instanceof SuperInvocationExpression) {
			// TODO: Not to be handled here => Should not resolve to a type
		}
		List<EObject> visibleClassifiers = null ;
		
		if (previousPackage == null)
			visibleClassifiers = AlfScopeProvider.scopingTool.getVisibleClassifiers(exp).resolveByName(exp.getId()) ;
		else
			visibleClassifiers = AlfScopeProvider.scopingTool.getVisibleClassifiers(previousPackage).resolveByName(exp.getId()) ;
		
		if (visibleClassifiers.isEmpty()) {
			return createErrorTypeFacade("Could not resolve classifier " + exp.getId(), exp, AlfPackage.eINSTANCE.getNameExpression_Id()) ;
		}
		else if (visibleClassifiers.size() > 1) {
			return createErrorTypeFacade(exp.getId() + " resolves to multiple classifiers", 
					exp, AlfPackage.eINSTANCE.getNameExpression_Id()) ;
		}
		return new VoidFacade(createTypeFacade(visibleClassifiers.get(0))) ;
	}
	

	public TypeFacade createVoidFacade(QualifiedNameWithBinding exp) {
		QualifiedNameWithBinding remaining = exp ;
		EObject previousPackage = null ;
		if (exp.getRemaining()!=null) { // A path is specified
			List<EObject> visiblePackages = AlfScopeProvider.scopingTool.getVisiblePackages(exp).resolveByName(exp.getId()) ;
			if (visiblePackages.isEmpty()) {
				return createErrorTypeFacade("Could not resolve package " + exp.getId(), exp, AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Id()) ;
			}
			else if (visiblePackages.size() > 1) {
				return createErrorTypeFacade(exp.getId() + " resolves to multiple packages", exp, AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Id()) ;
			}
			else {
				List<EObject> nestedVisiblePackages ;
				previousPackage = visiblePackages.get(0) ;
				remaining = exp.getRemaining() ;
				while (remaining.getRemaining() != null) {
					nestedVisiblePackages = AlfScopeProvider.scopingTool.getVisiblePackages(previousPackage).resolveByName(remaining.getId()) ;
					if (nestedVisiblePackages.isEmpty()) {
						return createErrorTypeFacade("Could not resolve package " + remaining.getId(), remaining, AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Id()) ;
					}
					else if (nestedVisiblePackages.size() > 1) {
						return createErrorTypeFacade(remaining.getId() + " resolves to multiple packages", remaining, AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Id()) ;
					}
					previousPackage = nestedVisiblePackages.get(0) ;
					remaining = remaining.getRemaining() ;
				}
			}
		}
		// At this point, the (potential) path has been validated, can check the final id.
		// The last remaining.id should resolve to a classifier
		List<EObject> visibleClassifiers = null ;
		if (previousPackage != null) 
			visibleClassifiers = AlfScopeProvider.scopingTool.getVisibleClassifiers(previousPackage).resolveByName(remaining.getId()) ;
		else
			visibleClassifiers = AlfScopeProvider.scopingTool.getVisibleClassifiers(exp).resolveByName(remaining.getId()) ;
		if (visibleClassifiers.isEmpty()) {
			return createErrorTypeFacade("Could not resolve classifier " + remaining.getId(),remaining,  
					AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Id()) ;
		}
		else if (visibleClassifiers.size() > 1) {
			return createErrorTypeFacade(remaining.getId() + " resolves to multiple classifiers.", remaining,
					AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Id()) ;
		}
		
		Classifier resolvedClassifier ;
		// Need to check that potential binding is valid
		if (visibleClassifiers.get(0) instanceof ElementImport) {
			resolvedClassifier = (Classifier)((ElementImport)visibleClassifiers.get(0)).getImportedElement() ;
		}
		else {
			resolvedClassifier = (Classifier)visibleClassifiers.get(0) ;
		}
		if (!resolvedClassifier.isTemplate()) {
			if (remaining.getBinding()!= null) { 
				return createErrorTypeFacade(remaining.getId() + " is not a template", remaining,
						AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Binding()) ;
			}
			else {
				return new VoidFacade(createTypeFacade(visibleClassifiers.get(0))) ;
			}
		}
		else {
			if (remaining.getBinding()!= null) { 
				// Needs to check that the binding is correct:
				List<ParameterableElement> orderedListOfParameteredElements = new ArrayList<ParameterableElement>() ;
				Map<String, ParameterableElement> mapOfParameteredElements = new HashMap<String, ParameterableElement>() ;
				for (TemplateParameter tp : resolvedClassifier.getOwnedTemplateSignature().getOwnedParameters()) {
					ParameterableElement p = tp.getParameteredElement() ;
					if (p != null) {
						orderedListOfParameteredElements.add(p) ;
						mapOfParameteredElements.put(((NamedElement)p).getName(), p) ;
					}
				}
				// Builds the substitutions map
				Map<TemplateParameter, ParameterableElement> substitutionsMap = new HashMap<TemplateParameter, ParameterableElement>() ;
				for (NamedTemplateBinding ntp : remaining.getBinding().getBindings()) {
					ParameterableElement formal = mapOfParameteredElements.get(ntp.getFormal()) ;
					if (formal == null) {
						return createErrorTypeFacade("Template parameter " + ntp.getFormal() + " is undefined for classifier " + remaining.getId() , ntp,
								AlfPackage.eINSTANCE.getNamedTemplateBinding_Formal()) ;
					}
					TypeFacade actual = createVoidFacade(ntp.getActual()) ;
					if (actual instanceof ErrorTypeFacade)
						return actual ;
					substitutionsMap.put(formal.getTemplateParameter(), actual.extractActualType()) ;
				}
				// Checks the number of specified substitution
				if (remaining.getBinding().getBindings().size() != orderedListOfParameteredElements.size()) {
					String errorMessage = "" ;
					if (remaining.getBinding().getBindings().size() > orderedListOfParameteredElements.size())
						errorMessage = "Too many template bindings specified for " + remaining.getId()  ;
					else {
						errorMessage = "Template bindings are missing for " + remaining.getId()  ;
					}
					return createErrorTypeFacade(errorMessage, remaining,
							AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Binding()) ;
				}
				// Now, can create the void facade, and bind it with appropriate substitutions
				VoidFacade boundResolvedClassifier = new VoidFacade(createTypeFacade(visibleClassifiers.get(0))) ;
//				HashMap<Object, EObject> actualSubsitutionsMap = new HashMap<Object, EObject>() ;
//				for (ParameterableElement p : orderedListOfParameteredElements) {
//					actualSubsitutionsMap.put(TemplateBindingUtils.getParameteredElementName(p), 
//											  subsitutionsMap.get(p) ) ;
//				}
				//boundResolvedClassifier.bindTemplate(substitutionsMap) ;
				
				return boundResolvedClassifier;
			}
			else {
				// Binding is not specified. It is up to the caller to perform implicit bindings.
				return new VoidFacade(createTypeFacade(visibleClassifiers.get(0))) ;
			}
		}
	}
	
}
