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
package org.eclipse.papyrus.alf.scoping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.alf.alf.AcceptClause;
import org.eclipse.papyrus.alf.alf.AcceptStatement;
import org.eclipse.papyrus.alf.alf.DocumentedStatement;
import org.eclipse.papyrus.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.alf.alf.LoopVariableDefinition;
import org.eclipse.papyrus.alf.alf.SequenceExpansionExpression;
import org.eclipse.papyrus.alf.alf.Statement;
import org.eclipse.papyrus.alf.validation.AlfJavaValidator;
import org.eclipse.papyrus.alf.validation.typing.TypeExpression;
import org.eclipse.papyrus.alf.validation.typing.TypeUtils;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.VisibilityKind;

public abstract class AlfScopingTool {

	protected static List<EObject> removeDuplicateClassifiers(List<EObject> list) {
		List<EObject> intermediateFilteredList = new ArrayList<EObject>() ;

		HashMap<String, Classifier> classifiers = new HashMap<String, Classifier>() ;
		HashMap<String, Classifier> elementImports = new HashMap<String, Classifier>() ;
		for (EObject o : list) {
			if (o instanceof Classifier) {
				Classifier c = (Classifier) o ;
				if (classifiers.get(c.getQualifiedName()) == null) {
					classifiers.put(c.getQualifiedName(), c) ;
					intermediateFilteredList.add(c) ;
				}
				// else => nothing to be done, this is a duplicate
			}
			else if (o instanceof ElementImport) {
				ElementImport e = (ElementImport)o ;
				Classifier c = (Classifier)e.getImportedElement() ;
				if (elementImports.get(e.getAlias()) == null) {
					elementImports.put(e.getAlias(), c) ;
					intermediateFilteredList.add(e) ;
				}
				else {// need to check if element import aliases the same thing.
					Classifier alreadyInTheList = elementImports.get(e.getAlias()) ;
					if (! alreadyInTheList.getQualifiedName().equals(c.getQualifiedName())) {
						// The model is ill-formed, and there's no need to filter
						intermediateFilteredList.add(e) ;
					}
					// else => nothing to be done, this is a duplicate
				}
			}
		}

		// needs to make a second pass on the filtered list, to remove cases where aliases and names are the same, and represent the same element
		List<EObject> filteredList = new ArrayList<EObject>() ;
		for (int i = 0 ; i < intermediateFilteredList.size() ; i++) {
			String classifierName = (intermediateFilteredList.get(i) instanceof Classifier) ? 
					((Classifier)intermediateFilteredList.get(i)).getName() :
						((ElementImport)intermediateFilteredList.get(i)).getAlias()	;
					String classifierQualifiedName = (intermediateFilteredList.get(i) instanceof Classifier) ? 
							((Classifier)intermediateFilteredList.get(i)).getQualifiedName() :
								((Classifier)((ElementImport)intermediateFilteredList.get(i)).getImportedElement()).getQualifiedName() ;
							boolean duplicateFound = false ;
							for (int j = i + 1 ; j < intermediateFilteredList.size() && !duplicateFound ; j++) {
								String cddDuplicateClassifierName = (intermediateFilteredList.get(j) instanceof Classifier) ? 
										((Classifier)intermediateFilteredList.get(j)).getName() :
											((ElementImport)intermediateFilteredList.get(j)).getAlias()	;
										if (cddDuplicateClassifierName.equals(classifierName)) {
											String cddDuplicateClassifierQualifiedName = (intermediateFilteredList.get(j) instanceof Classifier) ? 
													((Classifier)intermediateFilteredList.get(j)).getQualifiedName() :
														((Classifier)((ElementImport)intermediateFilteredList.get(j)).getImportedElement()).getQualifiedName() ;
													if (cddDuplicateClassifierQualifiedName.equals(classifierQualifiedName)) {
														duplicateFound = true ;
													}
										}
							}
							if (!duplicateFound)
								filteredList.add(intermediateFilteredList.get(i)) ;
		}

		return filteredList ;
	}

	public abstract AlfPartialScope getVisibleVariablesOrParametersOrProperties(EObject context) ;


	public AlfPartialScope getVisibleOperationsOrBehaviors(EObject context) {
		AlfPartialScope.IGetNameStrategy nameStrategy = new OperationAndBehaviorNameStrategy() ;
		AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new OperationAndBehaviorBuildScopeStrategy() ;
		return new AlfPartialScope(nameStrategy, buildScopeStrategy, context) ;
	}

	public AlfPartialScope getVisibleBehaviors(EObject context) {
		AlfPartialScope.IGetNameStrategy nameStrategy = new BehaviorsNameStrategy() ;
		AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new BehaviorsBuildScopeStrategy() ;
		return new AlfPartialScope(nameStrategy, buildScopeStrategy, context) ;
	}

	public AlfPartialScope getVisibleClassifiers(EObject context) {
		AlfPartialScope.IGetNameStrategy nameStrategy = new ClassifiersNameStrategy() ;
		AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new ClassifiersBuildScopeStrategy() ;
		return new AlfPartialScope(nameStrategy, buildScopeStrategy, context) ;
	}

	public AlfPartialScope getVisiblePackages(EObject context) {
		if (context instanceof Package) {
			AlfPartialScope.IGetNameStrategy nameStrategy = new PackageNameStrategy() ;
			AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new PackagesBuildScopeStrategy() ;
			return new AlfPartialScope(nameStrategy, buildScopeStrategy, context) ;
		}
		AlfPartialScope.IGetNameStrategy nameStrategy = new PackageNameStrategy() ;
		AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new PackagesBuildScopeStrategy() ;
		return new AlfPartialScope(nameStrategy, buildScopeStrategy, context) ;
	}

	public boolean isAReturnStatementExpected(EObject context) {
		return false ;
	}

	public TypeExpression getExpectedReturnType(EObject context) {
		return null;
	}

	public AlfPartialScope getVisibleSignalReceptions(EObject context) {
		AlfPartialScope.IGetNameStrategy nameStrategy = new ReceptionsNameStrategy() ;
		AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new ReceptionsBuildScopeStrategy() ;
		return new AlfPartialScope(nameStrategy, buildScopeStrategy, context);
	}

	/*
	 * Strategies for operations
	 */
	protected class OperationAndBehaviorNameStrategy implements AlfPartialScope.IGetNameStrategy {
		public String getName(EObject element) {
			if (element instanceof Operation)
				return ((Operation)element).getName();
			else if (element instanceof Behavior)
				return ((Behavior)element).getName() ;
			else if (element instanceof ElementImport) {
				ElementImport eImport = (ElementImport)element ;
				if (eImport.getAlias() != null)
					return eImport.getAlias() ;
				else
					return ((Behavior)eImport.getImportedElement()).getName() ;
			}
			else if (element instanceof Reception) {
				return ((Reception)element).getName() ;
			}
			else
				return "Unexpected element kind..." ;
		}
	};

	protected class OperationAndBehaviorBuildScopeStrategy implements AlfPartialScope.IBuildScopeStrategy {
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
			// retrieves the contextClassier (i.e. the owner of the contextOperation, or contextElement)
			Classifier contextClassifier ;
			if (contextElement instanceof Classifier) {
				contextClassifier = (Classifier)contextElement ;
			}
			else if (contextElement instanceof ElementImport && ((ElementImport)contextElement).getImportedElement() instanceof Classifier) {
				contextClassifier = (Classifier) ((ElementImport)contextElement).getImportedElement() ;
			}
			else {
				contextClassifier = AlfJavaValidator.getContextClassifier() ;
			}

			// add all the operations owned by the context classifier at the first scoping level
			nestedList.addAll(contextClassifier.getOperations()) ;
			// adds also receptions
			if (contextClassifier instanceof org.eclipse.uml2.uml.Class) {
				nestedList.addAll(((Class)contextClassifier).getOwnedReceptions()) ;
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

	/*
	 * Strategies for Receptions
	 */
	protected class ReceptionsNameStrategy implements AlfPartialScope.IGetNameStrategy {
		public String getName(EObject element) {
			if (element instanceof Signal)
				return ((Signal)element).getName();
			else
				return "Unexpected element kind..." ;
		}
	};

	protected class ReceptionsBuildScopeStrategy implements AlfPartialScope.IBuildScopeStrategy {
		public List<List<EObject>> buildScope(EObject contextElement) {
			List<List<EObject>> nestedScopes = new ArrayList<List<EObject>>() ;
			List<EObject> nestedList = new ArrayList<EObject>() ;

			// retrieves the owner of the contextOperation
			Classifier contextClassifier = AlfJavaValidator.getContextClassifier() ;
			if (! (contextClassifier instanceof org.eclipse.uml2.uml.Class)) {
				nestedScopes.add(nestedList) ;
				return nestedScopes ;
			}

			// add all the signals for which a Reception is defined
			for (org.eclipse.uml2.uml.Feature f : contextClassifier.allFeatures()) {
				if (f instanceof Reception)
					if (((Reception)f).getSignal() != null)
						nestedList.add(((Reception)f).getSignal()) ;
			}

			nestedScopes.add(nestedList) ;

			return nestedScopes ;
		}
	}

	/*
	 * Strategies for Variables, Parameters and Properties
	 */
	protected class VariableOrParameterOrPropertyNameStrategy implements AlfPartialScope.IGetNameStrategy {
		public String getName(EObject element) {
			if (element instanceof Property)
				return ((Property)element).getName();
			else if (element instanceof LocalNameDeclarationStatement){
				return ((LocalNameDeclarationStatement)element).getVarName() ;
			}
			else if (element instanceof InvocationOrAssignementOrDeclarationStatement) {
				InvocationOrAssignementOrDeclarationStatement statement = (InvocationOrAssignementOrDeclarationStatement)element ;
				return statement.getVariableDeclarationCompletion() != null ?
						statement.getVariableDeclarationCompletion().getVariableName() :
							"" ;
			}
			else if (element instanceof LoopVariableDefinition) {
				return ((LoopVariableDefinition)element).getName() ;
			}
			else if (element instanceof AcceptClause) {
				return ((AcceptClause)element).getName() ;
			}
			else if (element instanceof AcceptStatement) {
				return ((AcceptStatement)element).getClause().getName() ;
			}
			else if (element instanceof SequenceExpansionExpression) {
				SequenceExpansionExpression expression = (SequenceExpansionExpression)element ;
				return expression.getName() != null ?
						expression.getName() :
							"" ;
			}
			return "unexpected kind ..." ;
		}
	}

	protected abstract class VariableOrPropertyOrParameterBuildScopeStrategy implements AlfPartialScope.IBuildScopeStrategy {
		public abstract List<List<EObject>> buildScope(EObject contextElement) ;

		public boolean containsALocalNameDeclaration(DocumentedStatement previousDocumentStatement) {
			Statement statement = previousDocumentStatement.getStatement() ;
			if (statement instanceof LocalNameDeclarationStatement)
				return true ;
			if (statement instanceof InvocationOrAssignementOrDeclarationStatement) {
				//TODO : handle cases with implicit declarations, e.g., v = 14 ; // v is a variable of type Integer
				InvocationOrAssignementOrDeclarationStatement cddDclStatement = (InvocationOrAssignementOrDeclarationStatement)statement;
				if (cddDclStatement.getVariableDeclarationCompletion() != null) {
					return true ;
				}
			}
			if (statement instanceof AcceptStatement) {
				AcceptStatement cddDclStatement = (AcceptStatement)statement ;
				if (cddDclStatement.getSimpleAccept() != null && cddDclStatement.getClause().getName() != null)
					return true ;
			}
			return false;
		}

	}
	
	/*
	 *  Strategies for Classifiers
	 */
	protected class ClassifiersNameStrategy implements AlfPartialScope.IGetNameStrategy {
		public String getName(EObject element) {
			if (element instanceof Classifier)
				return ((Classifier)element).getName() ;
			else if (element instanceof ElementImport) {
				ElementImport imported = (ElementImport)element ;
				return imported.getAlias() != null ? imported.getAlias() : ((Classifier)imported.getImportedElement()).getName() ;
			}
			else 
				return "Unexpected element kind..." ; 
		}
	};

	protected class ClassifiersBuildScopeStrategy implements AlfPartialScope.IBuildScopeStrategy {
		public List<List<EObject>> buildScope(EObject contextElement) {
			List<List<EObject>> nestedScopes = new ArrayList<List<EObject>>() ;
			List<EObject> nestedList = new ArrayList<EObject>() ;

			// first checks if contextElement represents a Package. In this case, builds a scope containing all classifiers visible from this package
			Package potentialContextPackage = null ;
			if (contextElement instanceof Package)
				potentialContextPackage = (Package)contextElement ;
			else if (contextElement instanceof ElementImport) {
				ElementImport eImport = (ElementImport)contextElement ;
				if (eImport.getImportedElement() instanceof Package)
					potentialContextPackage = (Package)eImport.getImportedElement() ;
			}
			if (potentialContextPackage != null) {
				List<EObject> importedClassifiers = processPublicallyImportedClassifiers(potentialContextPackage) ;
				importedClassifiers = removeDuplicateClassifiers(importedClassifiers) ;
				nestedScopes.add(importedClassifiers) ;
				return nestedScopes ;
			}

			// retrieves the owner of the contextOperation
			Classifier contextClassifier = AlfJavaValidator.getContextClassifier() ;

			// add the context classifier at the first scoping level
			nestedList.add(contextClassifier) ;
			// retrieves all package imports, and add all classifiers available at the root of this package
			for (PackageImport i : contextClassifier.getPackageImports()) {
				Package importedPackage = i.getImportedPackage() ;
				nestedList.addAll(processPublicallyImportedClassifiers(importedPackage)) ;
			}
			// retrieves all element imports. For those which concern a Classifier, either add the classifier if no alias is defined, or the element import if an alias is defined
			for (ElementImport i : contextClassifier.getElementImports()) {
				PackageableElement e = i.getImportedElement() ;
				if (e instanceof Classifier) {
					if (i.getAlias() != null)
						nestedList.add(i) ;
					else
						nestedList.add(e) ;
				}
			}
			nestedList = removeDuplicateClassifiers(nestedList) ;
			nestedScopes.add(nestedList) ;

			// Then process the implicit import of alf library
			nestedList = new ArrayList<EObject>() ;
			if (AlfJavaValidator.getAlfStandardLibrary() != null) {
				List<EObject> importedClassifiers = processPublicallyImportedClassifiers(AlfJavaValidator.getAlfStandardLibrary()) ;

				importedClassifiers.add(TypeUtils._Collection.extractActualType()) ;
				importedClassifiers.add(TypeUtils._Set.extractActualType()) ;
				importedClassifiers.add(TypeUtils._Bag.extractActualType()) ;
				importedClassifiers.add(TypeUtils._Queue.extractActualType()) ;
				importedClassifiers.add(TypeUtils._OrderedSet.extractActualType()) ;
				importedClassifiers.add(TypeUtils._List.extractActualType()) ;
				importedClassifiers.add(TypeUtils._Deque.extractActualType()) ;
				importedClassifiers.add(TypeUtils._Map.extractActualType()) ;
				//importedClassifiers.add(TypeUtils._Entry.extractActualType()) ;

				nestedList.addAll(removeDuplicateClassifiers(importedClassifiers)) ;
				nestedScopes.add(nestedList) ;
			}

			// Then process all classifiers at the same namespace level than the context classifier
			nestedList = new ArrayList<EObject>() ;
			Namespace namespaceOfContextClassifier = contextClassifier.getNamespace() ;
			for (Element e : namespaceOfContextClassifier.getOwnedElements()) {
				if (e instanceof Classifier && e != contextClassifier)
					nestedList.add(e) ;
			}
			nestedScopes.add(nestedList) ;

			return nestedScopes ;
		}

		private List<EObject> processPublicallyImportedClassifiers (Package p){
			List<EObject> importedClassifiers = new ArrayList<EObject>() ;
			for (NamedElement n : p.getOwnedMembers()) {
				if (n instanceof Classifier)
					if (((Classifier)n).getVisibility() != VisibilityKind.PRIVATE_LITERAL) {

						importedClassifiers.add(n) ;
					}
			}
			for (ElementImport eImport : p.getElementImports()) {
				if (eImport.getVisibility()!= VisibilityKind.PRIVATE_LITERAL) {
					PackageableElement element = eImport.getImportedElement() ;
					if (element instanceof Classifier) {

						if (eImport.getAlias() != null) {
							importedClassifiers.add(eImport) ;
						}
						else {
							importedClassifiers.add(element) ;
						}

					}
				}
			}
			for (PackageImport pImport : p.getPackageImports()) {
				if (pImport.getVisibility() != VisibilityKind.PRIVATE_LITERAL) {
					importedClassifiers.addAll(processPublicallyImportedClassifiers(pImport.getImportedPackage())) ;
				}
			}
			return importedClassifiers ;
		}
	}

	/*
	 * Strategies for Packages
	 */
	protected class PackageNameStrategy implements AlfPartialScope.IGetNameStrategy {
		public String getName(EObject element) {
			if (element instanceof Namespace)
				return ((Namespace)element).getName() ;
			else if (element instanceof ElementImport) {
				ElementImport eImport = (ElementImport)element ;
				return eImport.getAlias() != null ? eImport.getAlias() : eImport.getImportedElement().getName() ;
			}
			else
				return "Unexpected element kind..." ;
		}
	}

	protected class PackagesBuildScopeStrategy implements AlfPartialScope.IBuildScopeStrategy {
		public List<List<EObject>> buildScope(EObject contextElement) {

			List<List<EObject>> nestedScopes = new ArrayList<List<EObject>>() ;
			List<EObject> nestedList = new ArrayList<EObject>() ;

			if (contextElement instanceof Package) { // if the context element is a package, returns the scope related to this package.
				nestedScopes.add(processPublicallyImportedPackages((Package)contextElement)) ;
				return nestedScopes ;
			}

			Package root = (Package)AlfJavaValidator.getModel() ;

			// first process packages directly imported by the context classifier (either package import or element import)
			Classifier contextClassifier = AlfJavaValidator.getContextClassifier() ;

			nestedList.addAll(processPublicallyImportedPackages(contextClassifier)) ;
			nestedScopes.add(nestedList) ;

			// Then process the implicit import of alf library
			nestedList = new ArrayList<EObject>() ;
			if (AlfJavaValidator.getAlfStandardLibrary() != null) {
				nestedList.add(AlfJavaValidator.getAlfStandardLibrary()) ;
				nestedList.addAll(processPublicallyImportedPackages(AlfJavaValidator.getAlfStandardLibrary())) ;
				nestedScopes.add(nestedList) ;
			}

			// finally processes the root package
			nestedList = new ArrayList<EObject>() ;
			nestedList.add(root) ;
			nestedScopes.add(nestedList) ;

			return nestedScopes;
		}

		protected List<EObject> processPublicallyImportedPackages (Namespace namespace) {
			List<EObject> importedPackages = new ArrayList<EObject>() ;

			for (NamedElement ownedMember : namespace.getOwnedMembers()) {
				if (ownedMember.getVisibility() != VisibilityKind.PRIVATE_LITERAL && ownedMember instanceof Package)
					importedPackages.add(ownedMember) ;
			}
			for (ElementImport eImport : namespace.getElementImports()) {
				if (eImport.getVisibility() != VisibilityKind.PRIVATE_LITERAL ) {
					PackageableElement importedElement = eImport.getImportedElement() ;
					if (importedElement instanceof Package) {
						if (eImport.getAlias() != null)
							importedPackages.add(eImport) ;
						else
							importedPackages.add(importedElement) ;
					}
				}
			}
			for (PackageImport pImport : namespace.getPackageImports()) {
				if (pImport.getVisibility() != VisibilityKind.PRIVATE_LITERAL) {
					importedPackages.addAll(processPublicallyImportedPackages(pImport.getImportedPackage())) ;
				}
			}

			return importedPackages ;
		}
	}


	/*
	 * Strategies for Behaviors
	 */

	protected class BehaviorsNameStrategy implements AlfPartialScope.IGetNameStrategy {
		public String getName(EObject element) {
			if (element instanceof Behavior)
				return ((Behavior)element).getName() ;
			else if (element instanceof ElementImport) {
				ElementImport imported = (ElementImport)element ;
				return imported.getAlias() != null ? imported.getAlias() : ((Behavior)imported.getImportedElement()).getName() ;
			}
			else 
				return "Unexpected element kind..." ; 
		}
	};

	protected class BehaviorsBuildScopeStrategy implements AlfPartialScope.IBuildScopeStrategy {
		public List<List<EObject>> buildScope(EObject contextElement) {
			List<List<EObject>> nestedScopes = new ArrayList<List<EObject>>() ;
			List<EObject> nestedList = new ArrayList<EObject>() ;

			// first checks if contextElement represents a Package. In this case, builds a scope containing all behaviors visible from this package
			Package potentialContextPackage = null ;
			if (contextElement instanceof Package)
				potentialContextPackage = (Package)contextElement ;
			else if (contextElement instanceof ElementImport) {
				ElementImport eImport = (ElementImport)contextElement ;
				if (eImport.getImportedElement() instanceof Package)
					potentialContextPackage = (Package)eImport.getImportedElement() ;
			}
			if (potentialContextPackage != null) {
				nestedScopes.add(processPublicallyImportedBehaviors(potentialContextPackage)) ;
				return nestedScopes ;
			}

			// retrieves the contextOperation (i.e., the operation edited by the current editor)
			// retrieves the owner of the contextOperation
			Classifier contextClassifier = AlfJavaValidator.getContextClassifier() ;

			// retrieves all package imports, and add all behaviors available at the root of this package
			for (PackageImport i : contextClassifier.getPackageImports()) {
				Package importedPackage = i.getImportedPackage() ;
				nestedList.addAll(processPublicallyImportedBehaviors(importedPackage)) ;
			}
			// retrieves all element imports. For those which concern a Behavior, either add the behavior if no alias is defined, or the element import if an alias is defined
			for (ElementImport i : contextClassifier.getElementImports()) {
				PackageableElement e = i.getImportedElement() ;
				if (e instanceof Classifier) {
					if (i.getAlias() != null)
						nestedList.add(i) ;
					else
						nestedList.add(e) ;
				}
			}
			nestedList = removeDuplicateClassifiers(nestedList) ;
			nestedScopes.add(nestedList) ;

			// Then process the implicit import of alf library
			nestedList = new ArrayList<EObject>() ;
			if (AlfJavaValidator.getAlfStandardLibrary() != null) {
				List<EObject> importedClassifiers = processPublicallyImportedBehaviors(AlfJavaValidator.getAlfStandardLibrary()) ;
				importedClassifiers = removeDuplicateClassifiers(importedClassifiers) ;
				nestedList.addAll(importedClassifiers) ;
				nestedScopes.add(nestedList) ;
			}

			return nestedScopes ;
		}

		private List<EObject> processPublicallyImportedBehaviors (Package p){
			List<EObject> importedBehaviors = new ArrayList<EObject>() ;
			for (NamedElement n : p.getOwnedMembers()) {
				if (n instanceof Behavior) {
					if (((Behavior)n).getVisibility() != VisibilityKind.PRIVATE_LITERAL)
						importedBehaviors.add(n) ;
				}
				else if (n instanceof Package) {
					importedBehaviors.addAll(processPublicallyImportedBehaviors((Package)n)) ;
				}
			}
			for (ElementImport eImport : p.getElementImports()) {
				if (eImport.getVisibility()!= VisibilityKind.PRIVATE_LITERAL) {
					PackageableElement element = eImport.getImportedElement() ;
					if (element instanceof Behavior) {
						if (eImport.getAlias() != null)
							importedBehaviors.add(eImport) ;
						else
							importedBehaviors.add(element) ;
					}
				}
			}
			for (PackageImport pImport : p.getPackageImports()) {
				if (pImport.getVisibility() != VisibilityKind.PRIVATE_LITERAL) {
					importedBehaviors.addAll(processPublicallyImportedBehaviors(pImport.getImportedPackage())) ;
				}
			}
			return importedBehaviors ;
		}
	}



	protected class EnumerationLiteralNameStrategy implements AlfPartialScope.IGetNameStrategy {
		public String getName(EObject element) {
			if (element instanceof EnumerationLiteral) {
				return ((EnumerationLiteral)element).getName() ;
			}
			return "Unexpected element kind..." ;
		}
	}

	protected class EnumerationLiteralBuildScopeStrategy implements AlfPartialScope.IBuildScopeStrategy {
		public List<List<EObject>> buildScope(EObject contextElement) {
			List<List<EObject>> nestedScopes = new ArrayList<List<EObject>>() ;
			List<EObject> nestedList = new ArrayList<EObject>() ;

			if (!(contextElement instanceof Enumeration)) {
				nestedScopes.add(nestedList) ;
				return nestedScopes ;
			}
			Enumeration contextEnumeration = (Enumeration)contextElement ;

			// add all the literals owned by the context enumeration at the first scoping level
			nestedList.addAll(contextEnumeration.getOwnedLiterals()) ;
			nestedScopes.add(nestedList) ;
			// then builds other scoping levels based on context classifier inheritance hierarchy 

			List<Classifier> currentGenerals = new ArrayList<Classifier>() ;
			currentGenerals.addAll(contextEnumeration.getGenerals()) ;
			List<Classifier> nextGenerals ;
			while (!currentGenerals.isEmpty()) {
				nextGenerals = new ArrayList<Classifier>() ;
				nestedList = new ArrayList<EObject>() ;
				for (Classifier general : currentGenerals) {
					nextGenerals.addAll(general.getGenerals()) ;
					if (general instanceof Enumeration) {
						for (EnumerationLiteral enumLiteral : ((Enumeration)general).getOwnedLiterals())
							nestedList.add(enumLiteral) ;
					}
				}
				nestedScopes.add(nestedList) ;
								currentGenerals = nextGenerals ;
			}
			return nestedScopes ;
		}
	}


	public AlfPartialScope getVisibleEnumerationLiterals(EObject context) {
		AlfPartialScope.IGetNameStrategy nameStrategy = new EnumerationLiteralNameStrategy() ;
		AlfPartialScope.IBuildScopeStrategy buildScopeStrategy = new EnumerationLiteralBuildScopeStrategy() ;
		return new AlfPartialScope(nameStrategy, buildScopeStrategy, context) ;
	}

}
