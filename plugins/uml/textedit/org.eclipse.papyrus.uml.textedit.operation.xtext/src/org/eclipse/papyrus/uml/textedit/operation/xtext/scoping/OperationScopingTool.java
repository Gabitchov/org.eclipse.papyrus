/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.operation.xtext.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.alf.AcceptBlock;
import org.eclipse.papyrus.uml.alf.alf.AcceptStatement;
import org.eclipse.papyrus.uml.alf.alf.CompoundAcceptStatementCompletion;
import org.eclipse.papyrus.uml.alf.alf.DocumentedStatement;
import org.eclipse.papyrus.uml.alf.alf.Expression;
import org.eclipse.papyrus.uml.alf.alf.ForStatement;
import org.eclipse.papyrus.uml.alf.alf.NonEmptyStatementSequence;
import org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression;
import org.eclipse.papyrus.uml.alf.alf.PropertyCallExpression;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression;
import org.eclipse.papyrus.uml.alf.alf.Statement;
import org.eclipse.papyrus.uml.alf.alf.StatementSequence;
import org.eclipse.papyrus.uml.alf.alf.TupleElement;
import org.eclipse.papyrus.uml.alf.scoping.AlfPartialScope;
import org.eclipse.papyrus.uml.alf.scoping.AlfScopeProvider;
import org.eclipse.papyrus.uml.alf.scoping.AlfScopingTool;
import org.eclipse.papyrus.uml.alf.validation.AlfJavaValidator;
import org.eclipse.papyrus.uml.alf.validation.typing.MultiplicityFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.MultiplicityFacadeFactory;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeExpression;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeExpressionFactory;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacadeFactory;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.VisibilityKind;

public class OperationScopingTool extends AlfScopingTool {

	@Override
	public TypeExpression getExpectedReturnType(EObject context) {
		EObject cddOperationDefinitionOrStub = context ;
		while (! (cddOperationDefinitionOrStub instanceof OperationDefinitionOrStub)) {
			cddOperationDefinitionOrStub = cddOperationDefinitionOrStub.eContainer() ;
		}
		OperationDefinitionOrStub op = (OperationDefinitionOrStub)cddOperationDefinitionOrStub ;
		if (op.getDeclaration() != null && op.getDeclaration().getReturnType() != null) {
			QualifiedNameWithBinding expectedReturnType = op.getDeclaration().getReturnType().getTypeName().getQualifiedName() ;
			TypeFacade type = TypeFacadeFactory.eInstance.createVoidFacade(expectedReturnType) ;
			Multiplicity expectedReturnMultiplicity = op.getDeclaration().getReturnType().getMultiplicity() ;
			int lower = 1 ;
			int upper = 1 ;
			boolean isUnique = true ;
			boolean isOrdered = false ;
			if (expectedReturnMultiplicity != null) {
				MultiplicityFacade multiplicity = MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(expectedReturnMultiplicity) ;
				lower = multiplicity.getLowerBound() ;
				upper = multiplicity.getUpperBound() ;
				isUnique = multiplicity.isUnique() ;
				isOrdered = multiplicity.isOrdered() ;
			}
			TypeExpression typeExp = TypeExpressionFactory.eInstance.createTypeExpression(type, lower, upper, isUnique, isOrdered) ;
			return typeExp ;
		}
		return null ;
	}

	@Override
	public boolean isAReturnStatementExpected(EObject context) {
		EObject cddOperationDefinitionOrStub = context ;
		while (cddOperationDefinitionOrStub != null && 
				! (cddOperationDefinitionOrStub instanceof OperationDefinitionOrStub)) {
			cddOperationDefinitionOrStub = cddOperationDefinitionOrStub.eContainer() ;
		}
		if (cddOperationDefinitionOrStub == null)
			return false;
		OperationDefinitionOrStub op = (OperationDefinitionOrStub)cddOperationDefinitionOrStub ;
		if (op.getDeclaration() != null && op.getDeclaration().getReturnType() != null) {
			return true ;
		}
		return false ;
	}



	@Override
	public AlfPartialScope getVisibleOperationsOrBehaviors(EObject context) {
		AlfPartialScope.IGetNameStrategy nameStrategy = new OperationAndBehaviorNameStrategy() ;
		AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new OperationAndBehaviorBuildScopeStrategy() ;
		return new AlfPartialScope(nameStrategy, buildScopeStrategy, context) ;
	}

	protected class OperationAndBehaviorNameStrategy extends AlfScopingTool.OperationAndBehaviorNameStrategy {
		@Override
		public String getName(EObject element) {
			if (element instanceof OperationDeclaration)
				return ((OperationDeclaration)element).getName() ;
			else
				return super.getName(element) ;
		}
	};
	protected class OperationAndBehaviorBuildScopeStrategy extends AlfScopingTool.OperationAndBehaviorBuildScopeStrategy {
		@Override
		public List<List<EObject>> buildScope(EObject contextElement) {
			List<List<EObject>> nestedScopes = new ArrayList<List<EObject>>() ;
			List<EObject> nestedList = new ArrayList<EObject>() ;

			// in the case where the context element is a Package or an ElementImport for a package, the scope can only contain behaviors
			Package potentialContextPackage = null ;
			if (contextElement instanceof Package) {
				potentialContextPackage = (Package)contextElement ;
			}
			else if (contextElement instanceof ElementImport) {
				ElementImport eImport = (ElementImport)contextElement ;
				if (eImport.getImportedElement() instanceof Package)
					potentialContextPackage = (Package)eImport.getImportedElement() ;
			}
			if (potentialContextPackage != null) {
				AlfPartialScope behaviorScope = AlfScopeProvider.scopingTool.getVisibleBehaviors(contextElement) ;
				for (List<EObject> scope : behaviorScope.getScopeDetails()) {
					nestedScopes.add(scope) ;
				}
				return nestedScopes ;
			}

			// At this point, we have identified that the context element is not a package.

			// First scoping levels concern operations
			// retrieves the contextOperation (i.e., the operation edited by the current editor)
			Operation contextOperation = (Operation)AlfJavaValidator.getContextElement() ;
			// retrieves the contextClassier (i.e. the owner of the contextOperation, or contextElement)
			Classifier contextClassifier ;
			if (contextElement instanceof Classifier) {
				contextClassifier = (Classifier)contextElement ;
				// Test
				//TemplateBindingUtils tUtils = new TemplateBindingUtils() ;
				//contextClassifier = (Classifier)tUtils.getEquivalentBoundElement(contextClassifier) ;
			}
			else if (contextElement instanceof ElementImport && ((ElementImport)contextElement).getImportedElement() instanceof Classifier) {
				contextClassifier = (Classifier) ((ElementImport)contextElement).getImportedElement() ;
			}
			else {
				contextClassifier = (Classifier)contextOperation.getNamespace() ;
			}

			// add all the operations owned by the context classifier at the first scoping level
			nestedList.addAll(contextClassifier.getOperations()) ;
			// adds also receptions
			if (contextClassifier instanceof org.eclipse.uml2.uml.Class) {
				nestedList.addAll(((Class)contextClassifier).getOwnedReceptions()) ;
			}

			// if the contextElement is not a class
			// removes the potential contextOperation, in order to replace it by the OperationDeclaration of the current editor
			if (! ((contextElement instanceof Classifier) || 
					((contextElement instanceof ElementImport && 
							((ElementImport)contextElement).getImportedElement() instanceof Classifier)))) {
				nestedList.remove(contextOperation) ;
				EObject cddOperationDefinitionOrStub = contextElement ;
				while (cddOperationDefinitionOrStub != null && !(cddOperationDefinitionOrStub instanceof OperationDefinitionOrStub)) {
					cddOperationDefinitionOrStub = cddOperationDefinitionOrStub.eContainer() ;
				}
				if (cddOperationDefinitionOrStub != null) {
					OperationDeclaration declaration = ((OperationDefinitionOrStub)cddOperationDefinitionOrStub).getDeclaration();
					nestedList.add(declaration) ;
				}
				else
					nestedList.add(contextOperation) ;
			}
			nestedScopes.add(nestedList) ;
			// then builds other scoping levels based on context classifier inheritance hierarchy 
			List<Classifier> currentGenerals = new ArrayList<Classifier>() ;
			currentGenerals.addAll(contextClassifier.getGenerals()) ;
			List<Classifier> nextGenerals ;
			while (!currentGenerals.isEmpty()) {
				nextGenerals = new ArrayList<Classifier>() ;
				nestedList = new ArrayList<EObject>() ;
				for (Classifier general : currentGenerals) {
					nextGenerals.addAll(general.getGenerals()) ;
					for (Operation o : general.getOperations())
						nestedList.add(o) ;
							if (general instanceof Class) {
								for (Reception r : ((Class)general).getOwnedReceptions()) {
									nestedList.add(r) ;
								}
							}
				}
				nestedScopes.add(nestedList) ;
				currentGenerals = nextGenerals ;
			}

			// finally feeds last scoping levels with behaviors (only if contextElement is not a Class)
			if (! ((contextElement instanceof Classifier) || 
					((contextElement instanceof ElementImport && 
							((ElementImport)contextElement).getImportedElement() instanceof Classifier)))) {

				AlfPartialScope behaviorScope = AlfScopeProvider.scopingTool.getVisibleBehaviors(contextElement) ;

				for (List<EObject> scope : behaviorScope.getScopeDetails()) {
					nestedScopes.add(scope) ;
				}
			}

			return nestedScopes ;
		}
	}

	@Override
	public AlfPartialScope getVisibleVariablesOrParametersOrProperties(EObject context) {
		AlfPartialScope.IGetNameStrategy nameStrategy = new VariableOrParameterOrPropertyNameStrategy() ;
		AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new VariableOrPropertyOrParameterBuildScopeStrategy() ;
		AlfPartialScope variableOrParametersOrPropertiesScope = new AlfPartialScope(nameStrategy, buildScopeStrategy, context) ;
		return variableOrParametersOrPropertiesScope ;
	}

	protected class VariableOrPropertyOrParameterBuildScopeStrategy extends AlfScopingTool.VariableOrPropertyOrParameterBuildScopeStrategy {
		@Override
		public List<List<EObject>> buildScope(EObject contextElement) {
			List<List<EObject>> nestedScopes = new ArrayList<List<EObject>>() ;
			List<EObject> nestedList = new ArrayList<EObject>() ;
			// first checks if the context element is a Classifier
			if (contextElement instanceof Classifier) {
				// then builds a nested scope containing properties visible from this classifier (i.e., owned or inherited)
				// following levels of scoping concern Properties visible from the context operation (i.e. those who belong to the context classifier or its parents)
				Classifier contextClassifier = (Classifier)contextElement ;
				nestedList = new ArrayList<EObject>() ;
				nestedList.addAll(contextClassifier.getAttributes()) ;
				// Retrieve the binary associations where this classifier is involved, and add the corresponding ends
				for (Association a : contextClassifier.getAssociations()) {
					if (a.isBinary()) {
						for (Property p : a.getNavigableOwnedEnds()) {
							if (p.getOpposite() != null && !nestedList.contains(p.getOpposite()) && p.getType().equals(contextClassifier)) {
								nestedList.add(p.getOpposite()) ;
							}
						}
					}
				}
				nestedScopes.add(nestedList) ;
				List<Classifier> currentGenerals = new ArrayList<Classifier>() ;
				currentGenerals.addAll(contextClassifier.getGenerals()) ;
				List<Classifier> nextGenerals ;
				while (!currentGenerals.isEmpty()) {
					nextGenerals = new ArrayList<Classifier>() ;
					nestedList = new ArrayList<EObject>() ;
					for (Classifier general : currentGenerals) {
						nextGenerals.addAll(general.getGenerals()) ;
						for (Property p : general.getAttributes())
							if (p.getVisibility() != VisibilityKind.PRIVATE_LITERAL)
								nestedList.add(p) ;
					}
					nestedScopes.add(nestedList) ;
								currentGenerals = nextGenerals ;
				}

				return nestedScopes ;
			}

			// the first level of scoping contains SequenceExpansionExpression local variables, LocalVariableDefinitions and FormalParameters of the operation
			// checks if the expression is nested inside a SequenceExpansionExpression
			EObject cddContextExpression = contextElement ;
			boolean goOn = true ;
			do {
				while (cddContextExpression != null && !(cddContextExpression instanceof Expression))
					cddContextExpression = cddContextExpression.eContainer() ;
				if (cddContextExpression != null) { 
					if (cddContextExpression.eContainer() instanceof SequenceExpansionExpression) {
						nestedList.add(cddContextExpression.eContainer()) ;
						goOn = false ;
					}
					else if (cddContextExpression.eContainer() instanceof TupleElement ||
							cddContextExpression.eContainer() instanceof PropertyCallExpression ||
							cddContextExpression.eContainer() instanceof ParenthesizedExpression) {
						cddContextExpression = cddContextExpression.eContainer() ;
					}
					else {
						goOn = false ;
					}
				}
				else {
					goOn = false ;
				}
			} while (goOn == true) ;

			// Following statement address LocalVariableDefinitions
			// First retrieve the inner most statement encapsulating the context eObject
			EObject cddInnerMostStatement = contextElement ;
			Statement innerMostStatement ;
			while (cddInnerMostStatement != null && !(cddInnerMostStatement instanceof Statement)) {
				cddInnerMostStatement = cddInnerMostStatement.eContainer() ;
			}
			if (cddInnerMostStatement != null) {
				innerMostStatement = (Statement)cddInnerMostStatement ;
				DocumentedStatement owningDocumentedStatement = (DocumentedStatement)innerMostStatement.eContainer() ;
				List<DocumentedStatement> containingListOfDocumentedStatement = new ArrayList<DocumentedStatement>();
				if (owningDocumentedStatement.eContainer() instanceof NonEmptyStatementSequence) {
					containingListOfDocumentedStatement.addAll(((NonEmptyStatementSequence)owningDocumentedStatement.eContainer()).getStatement()) ;
				}
				else {
					containingListOfDocumentedStatement.addAll(((StatementSequence)owningDocumentedStatement.eContainer()).getStatements()) ;
				}
				for (int i = containingListOfDocumentedStatement.indexOf(owningDocumentedStatement)-1 ; i>=0 ; i--) {
					DocumentedStatement previousDocumentStatement = containingListOfDocumentedStatement.get(i) ;
					if (containsALocalNameDeclaration(previousDocumentStatement))
						nestedList.add(previousDocumentStatement.getStatement()) ;
				}
				// hierarchically navigates over the innermost statement to retrieve all local variable definitions
				cddInnerMostStatement = innerMostStatement.eContainer().eContainer() ;
				while (!(cddInnerMostStatement instanceof OperationDefinitionOrStub)) {
					if (cddInnerMostStatement instanceof ForStatement) {
						nestedList.addAll(((ForStatement)cddInnerMostStatement).getControl().getLoopVariableDefinition()) ;
						innerMostStatement = (Statement)cddInnerMostStatement ;
						owningDocumentedStatement = (DocumentedStatement)innerMostStatement.eContainer() ;
						containingListOfDocumentedStatement = new ArrayList<DocumentedStatement>();
						if (owningDocumentedStatement.eContainer() instanceof NonEmptyStatementSequence) {
							containingListOfDocumentedStatement.addAll(((NonEmptyStatementSequence)owningDocumentedStatement.eContainer()).getStatement()) ;
						}
						else {
							containingListOfDocumentedStatement.addAll(((StatementSequence)owningDocumentedStatement.eContainer()).getStatements()) ;
						}
						for (int i = containingListOfDocumentedStatement.indexOf(owningDocumentedStatement) ; i>=0 ; i--) {
							DocumentedStatement previousDocumentStatement = containingListOfDocumentedStatement.get(i) ;
							if (containsALocalNameDeclaration(previousDocumentStatement))
								nestedList.add(previousDocumentStatement.getStatement()) ;
						}
						cddInnerMostStatement = innerMostStatement.eContainer() ;
					}
					else if (cddInnerMostStatement instanceof AcceptBlock) {
						AcceptBlock acceptBlock = (AcceptBlock) cddInnerMostStatement ;
						if (acceptBlock.getClause().getName() != null) {
							nestedList.add(acceptBlock.getClause()) ;
						}
					}
					else if (cddInnerMostStatement instanceof CompoundAcceptStatementCompletion) {
						CompoundAcceptStatementCompletion completion = (CompoundAcceptStatementCompletion)cddInnerMostStatement ;
						AcceptStatement container = (AcceptStatement)completion.eContainer() ;
						if (container.getClause().getName() != null)
							nestedList.add(container.getClause()) ;
					}
					else if (cddInnerMostStatement instanceof Statement) {
						innerMostStatement = (Statement)cddInnerMostStatement ;
						owningDocumentedStatement = (DocumentedStatement)innerMostStatement.eContainer() ;
						containingListOfDocumentedStatement = new ArrayList<DocumentedStatement>();
						if (owningDocumentedStatement.eContainer() instanceof NonEmptyStatementSequence) {
							containingListOfDocumentedStatement.addAll(((NonEmptyStatementSequence)owningDocumentedStatement.eContainer()).getStatement()) ;
						}
						else {
							containingListOfDocumentedStatement.addAll(((StatementSequence)owningDocumentedStatement.eContainer()).getStatements()) ;
						}
						for (int i = containingListOfDocumentedStatement.indexOf(owningDocumentedStatement) ; i>=0 ; i--) {
							DocumentedStatement previousDocumentStatement = containingListOfDocumentedStatement.get(i) ;
							if (containsALocalNameDeclaration(previousDocumentStatement))
								nestedList.add(previousDocumentStatement.getStatement()) ;
						}
						cddInnerMostStatement = innerMostStatement.eContainer() ;
					}
					cddInnerMostStatement = cddInnerMostStatement.eContainer();
				}
			}

			// Following statement address FormalParameters

			// first retrieve the context OperationDeclaration from the edited text
			OperationDeclaration declaration = ((OperationDefinitionOrStub)cddInnerMostStatement).getDeclaration();
			if (declaration.getFormalParameters().getFormalParameterList() != null) {
				for (FormalParameter p : declaration.getFormalParameters().getFormalParameterList().getFormalParameter()) {
					nestedList.add(p) ;
				}
			}
			nestedScopes.add(nestedList) ;

			// following levels of scoping concern Properties visible from the context (i.e. those who belong to the context classifier or its parents)
			Classifier contextClassifier = AlfJavaValidator.getContextClassifier() ;
			nestedList = new ArrayList<EObject>() ;
			nestedList.addAll(contextClassifier.getAttributes()) ;
			// Retrieve the binary associations where this classifier is involved, and add the corresponding ends
			for (Association a : contextClassifier.getAssociations()) {
				if (a.isBinary()) {
					for (Property p : a.getNavigableOwnedEnds()) {
						if (p.getOpposite() != null && !nestedList.contains(p.getOpposite()) && p.getType().equals(contextClassifier)) {
							nestedList.add(p.getOpposite()) ;
						}
					}
				}
			}
			nestedScopes.add(nestedList) ;
			List<Classifier> currentGenerals = new ArrayList<Classifier>() ;
			currentGenerals.addAll(contextClassifier.getGenerals()) ;
			List<Classifier> nextGenerals ;
			while (!currentGenerals.isEmpty()) {
				nextGenerals = new ArrayList<Classifier>() ;
				nestedList = new ArrayList<EObject>() ;
				for (Classifier general : currentGenerals) {
					nextGenerals.addAll(general.getGenerals()) ;
					for (Property p : general.getAttributes())
						if (p.getVisibility() != VisibilityKind.PRIVATE_LITERAL)
							nestedList.add(p) ;
				}
				nestedScopes.add(nestedList) ;
							currentGenerals = nextGenerals ;
			}

			return nestedScopes ;
		}

	}
	protected class VariableOrParameterOrPropertyNameStrategy extends AlfScopingTool.VariableOrParameterOrPropertyNameStrategy {
		@Override
		public String getName(EObject element) {
			if (element instanceof FormalParameter) {
				String formalParameterName = ((FormalParameter)element).getName() ;
				if (formalParameterName.startsWith("\'"))
					formalParameterName = formalParameterName.substring(1, formalParameterName.length()-1) ;
				return formalParameterName ;
			}
			else 
				return super.getName(element) ;
		}
	}
}


