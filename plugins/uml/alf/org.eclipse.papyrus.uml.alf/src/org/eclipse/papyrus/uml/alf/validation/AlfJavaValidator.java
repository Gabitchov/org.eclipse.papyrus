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
package org.eclipse.papyrus.uml.alf.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.alf.alf.AcceptBlock;
import org.eclipse.papyrus.uml.alf.alf.AcceptStatement;
import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.AssignmentOperator;
import org.eclipse.papyrus.uml.alf.alf.ClassificationClause;
import org.eclipse.papyrus.uml.alf.alf.ClassificationFromClause;
import org.eclipse.papyrus.uml.alf.alf.ClassificationToClause;
import org.eclipse.papyrus.uml.alf.alf.ClassifyStatement;
import org.eclipse.papyrus.uml.alf.alf.ConcurrentClauses;
import org.eclipse.papyrus.uml.alf.alf.DoStatement;
import org.eclipse.papyrus.uml.alf.alf.DocumentedStatement;
import org.eclipse.papyrus.uml.alf.alf.ForStatement;
import org.eclipse.papyrus.uml.alf.alf.IfStatement;
import org.eclipse.papyrus.uml.alf.alf.InstanceCreationInvocationStatement;
import org.eclipse.papyrus.uml.alf.alf.InvocationOrAssignementOrDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.uml.alf.alf.LoopVariableDefinition;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.alf.NonEmptyStatementSequence;
import org.eclipse.papyrus.uml.alf.alf.NonFinalClause;
import org.eclipse.papyrus.uml.alf.alf.PropertyCallExpression;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameList;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.uml.alf.alf.ReturnStatement;
import org.eclipse.papyrus.uml.alf.alf.StatementSequence;
import org.eclipse.papyrus.uml.alf.alf.SuffixExpression;
import org.eclipse.papyrus.uml.alf.alf.SuperInvocationStatement;
import org.eclipse.papyrus.uml.alf.alf.ThisInvocationStatement;
import org.eclipse.papyrus.uml.alf.alf.TupleElement;
import org.eclipse.papyrus.uml.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion;
import org.eclipse.papyrus.uml.alf.alf.WhileStatement;
import org.eclipse.papyrus.uml.alf.scoping.AlfPartialScope;
import org.eclipse.papyrus.uml.alf.scoping.AlfScopeProvider;
import org.eclipse.papyrus.uml.alf.validation.typing.AssignmentPolicy;
import org.eclipse.papyrus.uml.alf.validation.typing.ErrorTypeFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.SignatureFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeExpression;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeExpressionFactory;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacadeFactory;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeUtils;
import org.eclipse.papyrus.uml.alf.validation.typing.VoidFacade;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
 

public class AlfJavaValidator extends AbstractAlfJavaValidator {
	
	private static Element contextElement ;
	private static Classifier contextClassifier ;
	private static Namespace model ;
	
	private static Package alfStandardLibrary ; // TODO: include the library as part of the plug-in
	public static PredefinedBehaviorsAndTypesUtils predefinedBehaviorsAndTypes ;
	
	public static Package getAlfStandardLibrary() {
		return alfStandardLibrary; 
	}

	public static boolean validate() {
		return true ;
	}
	
	public static Namespace getModel() {
		return model;
	}

	public static void setModel(Namespace model) {
		AlfJavaValidator.model = model;
	}
	
	public static void setContextElement(Element _contextElement) {
		contextElement = _contextElement ;
	}
	
	public static Element getContextElement() {
		return contextElement ;
	}
	
	public static Classifier getContextClassifier() {
		return contextClassifier ;
	}
	
	public static void setContextClassifier(Classifier contextClassifier) {
		AlfJavaValidator.contextClassifier = contextClassifier ;
		alfStandardLibrary = null ;
		//if (alfStandardLibrary == null) {
			for (PackageImport pImport : contextClassifier.getModel().getPackageImports()) {
				Package p = pImport.getImportedPackage() ;
				if (p.getQualifiedName().equals("Alf")) {
					//alfStandardLibrary = (Package)p.getOwnedMembers().get(0) ;
					alfStandardLibrary = (Package)p ;
				}
			}
		//}
		if (alfStandardLibrary != null) {
			predefinedBehaviorsAndTypes = new PredefinedBehaviorsAndTypesUtils() ;
			predefinedBehaviorsAndTypes.init(alfStandardLibrary) ;
		}
		else {
			
			String question = "The context model " +
								contextClassifier.getModel().getName() + 
								" does not import the standard Alf library. This import is required for static validation of Alf expressions and statements. \n\n Do you want to generate this import?" ;
			boolean doGenerateImport = MessageDialog.openQuestion(
					new Shell(),
					"Alf editor",
					question);
			if (doGenerateImport) {
				RegisteredLibrary[] libraries = RegisteredLibrary.getRegisteredLibraries() ;
				RegisteredLibrary alfLibrary = null ;
				for (RegisteredLibrary l : libraries) {
					if (l.getName().equals("AlfLibrary"))
						alfLibrary = l ;
				}
				if (alfLibrary != null) {
					// Creates and executes the update command
					UpdateImportCommand updateCommand = new UpdateImportCommand(contextClassifier.getModel(), alfLibrary);
					try {
						OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null);
						setContextClassifier(contextClassifier) ;
					} catch (ExecutionException e) {
						System.err.println(e);
					}
				}
				else {
					MessageDialog.openError(
							new Shell(), 
							"Alf editor", 
							"Could not find standard Alf library") ;
				}
			}
		}
	}
	
	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected static class UpdateImportCommand extends AbstractTransactionalCommand {

		private Model model;
		private RegisteredLibrary library ;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			URI libraryUri = library.uri;
			ResourceSet resourceSet = Util.getResourceSet(contextClassifier) ;
			Resource libraryResource = resourceSet.getResource(libraryUri, true) ;
			Package libraryObject = (Package)libraryResource.getContents().get(0) ;
			model.createPackageImport(libraryObject) ;
			return CommandResult.newOKCommandResult(model);
		}

		public UpdateImportCommand(Model model, RegisteredLibrary library) {
			super(EditorUtils.getTransactionalEditingDomain(), "Model Update", getWorkspaceFiles(model));
			this.model = model ;
			this.library = library ;
			//this.operation = operation;
		}
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// alf validator is not registered for a specific language
		super.register(registrar) ;
	}
	
	/**
	 * @param tupleElement
	 * 
	 *  Checks the following rule:
	 * 	1. the expression associated with the tuple must not encapsulate any error
	 */
	@Check
	public void checkTupleElement(TupleElement tupleElement) {
		TypeExpression exp = new TypeUtils().getTypeOfExpression(tupleElement.getArgument()) ;
		if (exp.getTypeFacade() instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)exp.getTypeFacade() ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
		}
	}
	
	/**
	 * @param statement LocalNameDeclarationStatement
	 *
	 *	Checks the following rules:
	 *	1. the local variable name must be available
	 *  2. the type must be resolved
	 *  3. the init expression must be type/multiplicity compatible with the variable type
	 */
	@Check
	public void checkLocalNameDeclarationStatement(LocalNameDeclarationStatement statement) {
		// 1. checks that the local variable name is available
		if (statement.getVarName() != null) {
			AlfPartialScope variablesScope = AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(statement) ;
			List<EObject> resolved = variablesScope.resolveByName(statement.getVarName()) ;
			if (! resolved.isEmpty()) {// name is already used
				// needs to determine if the scoping level where it is used is conflicting (i.e., it is in the first scoping level)
				if (variablesScope.getScopingLevel(resolved.get(0)) == 0 && resolved.get(0) != statement) {
					// There is a name conflict
					error("Local name " + statement.getVarName() + " is not available" , AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_VarName()) ;
				}
			}
		}
		
		// 2. checks that type can be resolved, and that potentially required template bindings are specified
		TypeFacade variableType = null ;
		if (statement.getType() != null) {
			variableType = TypeFacadeFactory.eInstance.createVoidFacade(statement.getType()) ;
			if (variableType instanceof ErrorTypeFacade) { // Type could not be resolved
				ErrorTypeFacade error = (ErrorTypeFacade)variableType ;
				error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				variableType = null ;
			}
			else if (variableType.isATemplate()){
				if (statement.getType().getBinding() == null) {
					String errorMessage = variableType.getLabel() + " is a template. All its parameters shall be bound." ;
					error(errorMessage, statement, AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_Type(), INSIGNIFICANT_INDEX) ;
				}
			}
		}
		
		// 3. checks the init expression
		if (statement.getInit() != null) {
			TypeExpression typeOfInit = new TypeUtils().getTypeOfSequenceElement(statement.getInit()) ;
			// first checks that init expression is valid
			if (typeOfInit.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)typeOfInit.getTypeFacade() ;
				error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
			}
			else { 
				// Type expression is valid
				// In the case where type has been validated at step 2., checks if the type of init expression is compatible with variable type
				if (variableType != null) {
					int lowerBound = statement.isMultiplicityIndicator() ? 0 : 1 ;
					int upperBound = statement.isMultiplicityIndicator() ? -1 : 1 ;
					boolean isUnique = statement.isMultiplicityIndicator() ? false : true ;
					boolean isOrdered = statement.isMultiplicityIndicator() ? true : false ;
					TypeExpression expectedType = TypeExpressionFactory.eInstance.createTypeExpression(variableType, lowerBound, upperBound, isUnique, isOrdered) ;
					if (expectedType.isCompatibleWithMe(typeOfInit) == 0) {
						error("Found an expression of type " + typeOfInit.getLabel() + ". Expecting an expression of type " + expectedType.getLabel(), AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_Init()) ;
					}
				}
			}
		}
	}
	
	/**
	 * @param statement IfStatement
	 * 
	 *  Checks the following rule:
	 *  1. The condition associated with each clause must be a boolean expression 
	 */
	@Check
	public void checkIfStatement(IfStatement statement) {
		for (ConcurrentClauses concurrentClause : statement.getSequentialClausses().getConccurentClauses()) {
			for (NonFinalClause nonFinalClause : concurrentClause.getNonFinalClause()) {
				TypeExpression typeOfCondition = new TypeUtils().getTypeOfExpression(nonFinalClause.getCondition()) ;
				if (typeOfCondition.getTypeFacade() instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)typeOfCondition.getTypeFacade() ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				}
				else {
					if (TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._boolean).isCompatibleWithMe(typeOfCondition) == 0) {
						String errorMessage = "Expecting an expression of type Boolean. Found an expression of type " + typeOfCondition.getLabel() ;
						error(errorMessage, nonFinalClause, AlfPackage.eINSTANCE.getNonFinalClause_Condition(), INSIGNIFICANT_INDEX) ;
					}
				}
			}
		}
	}
	
	/**
	 * @param statement WhileStatement
	 * 
	 *  Checks the following rule:
	 *  1. The condition associated with the while must be a boolean expression 
	 */
	@Check
	public void checkWhileStatement(WhileStatement statement) {
		TypeExpression typeOfCondition = new TypeUtils().getTypeOfExpression(statement.getCondition()) ;
		if (typeOfCondition.getTypeFacade() instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)typeOfCondition.getTypeFacade() ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
		}
		else {
			if (TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._boolean).isCompatibleWithMe(typeOfCondition) == 0) {
				String errorMessage = "Expecting an expression of type Boolean. Found an expression of type " + typeOfCondition.getLabel() ;
				error(errorMessage, AlfPackage.eINSTANCE.getWhileStatement_Condition()) ;
			}
		}
	}
	
	/**
	 * @param statement DoStatement
	 * 
	 *  Checks the following rule:
	 *  1. The condition associated with the DoStatement must be a boolean expression 
	 */
	@Check
	public void checkDoStatement(DoStatement statement) {
		TypeExpression typeOfCondition = new TypeUtils().getTypeOfExpression(statement.getCondition()) ;
		if (typeOfCondition.getTypeFacade() instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)typeOfCondition.getTypeFacade() ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
		}
		else {
			if (TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._boolean).isCompatibleWithMe(typeOfCondition) == 0) {
				String errorMessage = "Expecting an expression of type Boolean. Found an expression of type " + typeOfCondition.getLabel() ;
				error(errorMessage, AlfPackage.eINSTANCE.getDoStatement_Condition()) ;
			}
		}
	}
	
	/**
	 * @param statement ForStatement
	 * 
	 *  Checks the following rule:
	 *  1. Loop variable names must not be available (i.e., not used in the scope of the statement)
	 *  2. Loop variable names must not duplicate (i.e., two loop variables for this statement must not have the same name)
	 *  3. if the loop variable definition uses the syntax option with keyword "in", following rules must be checked:
	 *  	3.a. if only expression1 is specified, the upper bound of expression 1 must be greater than 1
	 *  	3.b. if both expression1 and expression2 are specified, they must be type compatible and represent number values (TODO: check other constraints in the spec)
	 *  4. if the loop variable definition uses the syntax option with keyword ":", following rules must be checked:
	 *  	4.a. type must be resolved
	 *  	4.b. the domain value "expression" must be type-compatible with the variable and must be a collection
	 */
	@Check
	public void checkForStatement(ForStatement statement) {
		// 1. Loop variable names must not be available (i.e., not used in the scope of the statement)
		AlfPartialScope variablesScope = AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(statement) ;
		Map<String, Integer> declaredVariables = new HashMap<String, Integer>() ;
		for (LoopVariableDefinition loopVariable : statement.getControl().getLoopVariableDefinition()) {
			Integer variableDefinitionCounter = declaredVariables.get(loopVariable.getName()) ;
			if (variableDefinitionCounter == null) {
				declaredVariables.put(loopVariable.getName(), new Integer(1)) ;
			}
			else {
				declaredVariables.put(loopVariable.getName(), variableDefinitionCounter.intValue() + 1) ;
			}
			List<EObject> visibleVariables = variablesScope.resolveByName(loopVariable.getName()) ;
			if (! visibleVariables.isEmpty()) { // potentially conflicting name
				if (variablesScope.getScopingLevel(visibleVariables.get(0)) == 0) {
					// There is actually a conflict
					error("Local name " + loopVariable.getName() + " is not available" ,
							loopVariable,
							AlfPackage.eINSTANCE.getLocalNameDeclarationStatement_VarName(),
							statement.getControl().getLoopVariableDefinition().indexOf(loopVariable)) ;
				}
			}
		}
		
		// 2. Loop variable names must not duplicate (i.e., two loop variables for this statement must not have the same name)
		boolean duplicationFound = false ;
		for (Integer i : declaredVariables.values()) {
			if (i.intValue() > 1)
				duplicationFound = true ;
		}
		if (duplicationFound) {
			error("Duplicate loop variable definitions" , AlfPackage.eINSTANCE.getForStatement_Control()) ;
		}
		
		for (LoopVariableDefinition loopVariable : statement.getControl().getLoopVariableDefinition()) {
			// 3. if the loop variable definition uses the syntax option with keyword "in", following rules must be checked:
			//		3.a. if only expression1 is specified, the upper bound of expression 1 must be greater than 1
			if (loopVariable.getExpression1() != null && loopVariable.getExpression2() == null) {
				TypeExpression typeOfExpression1 = new TypeUtils().getTypeOfExpression(loopVariable.getExpression1()) ;
				if (typeOfExpression1.getTypeFacade() instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)typeOfExpression1.getTypeFacade() ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				}
				else {
					int upperBound = typeOfExpression1.getMultiplicity().getUpperBound() ;
					if (! (upperBound > 1  || upperBound == -1)) {
						String errorMessage = "Invalid upper bound multiplicity (" + upperBound + "). A collection is expected." ; 
						error(errorMessage, loopVariable, AlfPackage.eINSTANCE.getLoopVariableDefinition_Expression1(), INSIGNIFICANT_INDEX) ;
					}
				}
			}
			//		3.b. if both expression1 and expression2 are specified, they must be type compatible and represent number values (TODO: check other constraints in the spec)
			else if (loopVariable.getExpression1() != null && loopVariable.getExpression2() != null) {
				TypeExpression typeOfExpression1 = new TypeUtils().getTypeOfExpression(loopVariable.getExpression1()) ;
				boolean errorInExpressions = false ;
				if (typeOfExpression1.getTypeFacade() instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)typeOfExpression1.getTypeFacade() ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
					errorInExpressions = true ;
				}
				TypeExpression typeOfExpression2 = new TypeUtils().getTypeOfExpression(loopVariable.getExpression2()) ;
				if (typeOfExpression2.getTypeFacade() instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)typeOfExpression2.getTypeFacade() ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
					errorInExpressions = true ;
				}
				if (! errorInExpressions) { // both Expression must be type compatible and resolve to a scalar number value
					TypeFacade typeFacadeOfExpression1 = typeOfExpression1.getTypeFacade() ;
					int upperBoundExpression1 = typeOfExpression1.getMultiplicityFacade().getUpperBound() ;
					String errorMessageForExpression1 = "" ;
					if (!isANumberType(typeFacadeOfExpression1)) {
						if (upperBoundExpression1 > 1 || upperBoundExpression1 == -1)
							errorMessageForExpression1 += "A scalar number value is expected" ;
						else
							errorMessageForExpression1 += "A number value is expected" ;
					}
					else {
						if (upperBoundExpression1 > 1 || upperBoundExpression1 == -1)
							errorMessageForExpression1 += "A scalar value is expected" ;
					}
					if (!(errorMessageForExpression1.length() == 0)) {
						error(errorMessageForExpression1, loopVariable, AlfPackage.eINSTANCE.getLoopVariableDefinition_Expression1(), INSIGNIFICANT_INDEX) ;
					}
					TypeFacade typeFacadeOfExpression2 = typeOfExpression2.getTypeFacade() ;
					int upperBoundExpression2 = typeOfExpression2.getMultiplicityFacade().getUpperBound() ;
					String errorMessageForExpression2 = "" ;
					if (!isANumberType(typeFacadeOfExpression2)) {
						if (upperBoundExpression2 > 1 || upperBoundExpression2 == -1)
							errorMessageForExpression2 += "A scalar number value is expected" ;
						else 
							errorMessageForExpression2 += "A number value is expected" ;
					}
					else {
						if (upperBoundExpression2 > 1 || upperBoundExpression2 == -1)
							errorMessageForExpression2 += "A scalar value is expected" ;
					}
					if (!(errorMessageForExpression2.length() == 0)) {
						error(errorMessageForExpression2, loopVariable, AlfPackage.eINSTANCE.getLoopVariableDefinition_Expression2(), INSIGNIFICANT_INDEX) ;
					}
				}
			}
			//4. if the loop variable definition uses the syntax option with keyword ":", following rules must be checked:
			else if (loopVariable.getType() != null) {
			//		4.a. type must be resolved
				TypeFacade typeOfVariable = TypeFacadeFactory.eInstance.createVoidFacade(loopVariable.getType()) ;
				if (typeOfVariable instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)typeOfVariable ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				}
				else { // 4.b. the domain value "expression" must be type-compatible with the variable and must be a collection
					TypeExpression typeOfDomain = new TypeUtils().getTypeOfExpression(loopVariable.getExpression()) ;
					if (typeOfDomain.getTypeFacade() instanceof ErrorTypeFacade) {
						ErrorTypeFacade error = (ErrorTypeFacade)typeOfDomain.getTypeFacade() ;
						error (error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
					}
					else {
						int upperBound = typeOfDomain.getMultiplicity().getUpperBound() ;
						if (! (upperBound > 1  || upperBound == -1)) {
							String errorMessage = "Invalid upper bound multiplicity (" + upperBound + "). A collection is expected." ; 
							error(errorMessage, loopVariable, AlfPackage.eINSTANCE.getLoopVariableDefinition_Expression(), INSIGNIFICANT_INDEX) ;
						}
						if (typeOfVariable.isCompatibleWithMe(typeOfDomain.getTypeFacade()) == 0) {
							String errorMessage = "Cannot convert from " + typeOfDomain.getTypeFacade().getLabel() + " to " + typeOfVariable.getLabel() ; 
							error(errorMessage, loopVariable, AlfPackage.eINSTANCE.getLoopVariableDefinition_Type(), INSIGNIFICANT_INDEX) ;
						}
					}
				}
			}
		}
	}
	
	/**
	 * @param statement
	 * 
	 *  Checks the following rule:
	 *  1. That a return value is actually expected from the context of the ALF specification
	 *  2. If a return value is expected, the returned value must be type/multiplicity compatible
	 *  3. There must be no statement in the containing statement sequence after the return statement.
	 */
	@Check
	public void checkReturnStatement(ReturnStatement statement) {
		// 1. Checks that a return value is actually expected from the context of the ALF specification
		boolean returnStatementExpected = AlfScopeProvider.scopingTool.isAReturnStatementExpected(statement) ;
		if (returnStatementExpected == false) {
			String errorMessage = "No return statement expected" ;
			error (errorMessage, AlfPackage.eINSTANCE.getReturnStatement_Expression()) ;
		}
		else {
			// 2. If a return value is expected, the returned value must be type/multiplicity compatible
			TypeExpression expectedReturnType = AlfScopeProvider.scopingTool.getExpectedReturnType(statement) ;
			TypeExpression actualReturnType = new TypeUtils().getTypeOfExpression(statement.getExpression()) ;
			if (actualReturnType.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)actualReturnType.getTypeFacade() ;
				error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
			}
			else {
				if (expectedReturnType.isCompatibleWithMe(actualReturnType) == 0) {
					String errorMessage = "An expression of type " + expectedReturnType.getLabel() + " is expected. Found an expression of type " + actualReturnType.getLabel() ;
					error (errorMessage, AlfPackage.eINSTANCE.getReturnStatement_Expression()) ;
				}
			}
		}
		// 3. There must be no statement (in the containing statement sequence) after the return statement.
		EObject cddStatementSequence = statement.eContainer() ;
		DocumentedStatement contextDocumentedStatement = null ;
		while (cddStatementSequence != null && 
				! ((cddStatementSequence instanceof StatementSequence) || (cddStatementSequence instanceof NonEmptyStatementSequence))) {
			if (contextDocumentedStatement == null && cddStatementSequence instanceof DocumentedStatement)
				contextDocumentedStatement = (DocumentedStatement)cddStatementSequence ;
			cddStatementSequence = cddStatementSequence.eContainer() ;
		}
		if (cddStatementSequence != null && contextDocumentedStatement != null) {
			int statementIndex = 0 ;
			int numberOfStatements = 0 ;
			if (cddStatementSequence instanceof StatementSequence) {
				statementIndex = ((StatementSequence)cddStatementSequence).getStatements().indexOf(contextDocumentedStatement) ;
				numberOfStatements = ((StatementSequence)cddStatementSequence).getStatements().size() ;
			}
			else {
				statementIndex = ((NonEmptyStatementSequence)cddStatementSequence).getStatement().indexOf(contextDocumentedStatement) ;
				numberOfStatements = ((NonEmptyStatementSequence)cddStatementSequence).getStatement().size() ;
			}			
			String errorMessage = "The statement cannot be reached" ;
			for (int i = statementIndex + 1 ; i < numberOfStatements ; i++) {
				DocumentedStatement current = null ;
				if (cddStatementSequence instanceof StatementSequence)
					current = ((StatementSequence)cddStatementSequence).getStatements().get(i) ;
				else
					current = ((NonEmptyStatementSequence)cddStatementSequence).getStatement().get(i) ;
				error(errorMessage, current, AlfPackage.eINSTANCE.getDocumentedStatement_Statement(), INSIGNIFICANT_INDEX) ;
			}
		}
	}
	
	
	/**
	 * @param statement
	 * 
	 *  Checks the following rules:
	 *  1. Checks that the context classifier is active
	 *  2. Each AcceptClause.name (if specified) must be available.
	 *  3. There must be a Reception for each Signal identified in each AcceptClause.qualifiedNameList
	 *  4. Each Signal must be used only once
	 */
	@Check
	public void checkAcceptStatement(AcceptStatement statement) {
		//1. Checks that the context classifier is active
		if (! (contextClassifier instanceof Class) || !((Class)contextClassifier).isActive()) {
			error("The context classifier must be an active class", AlfPackage.eINSTANCE.getAcceptStatement_Clause()) ;
		}
		
		//2. Each AcceptClause.name (if specified) must be available.
		AlfPartialScope vppScope = AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(statement) ;
		if (statement.getClause().getName() != null ) {
			List<EObject> visibleElements = vppScope.resolveByName(statement.getClause().getName()) ;
			if (! visibleElements.isEmpty() && vppScope.getScopingLevel(visibleElements.get(0)) == 0) {
				String errorMessage = "Local name " + statement.getClause().getName() + " is not available" ;
				error(errorMessage, statement.getClause(), AlfPackage.eINSTANCE.getAcceptClause_Name(), INSIGNIFICANT_INDEX) ;
			}
		}
		if (statement.getCompoundAccept() != null) {
			for (AcceptBlock block : statement.getCompoundAccept().getAcceptBlock()) {
				if (block.getClause() != null && block.getClause().getName() != null) {
					List<EObject> visibleElements = vppScope.resolveByName(block.getClause().getName()) ;
					if (! visibleElements.isEmpty() && vppScope.getScopingLevel(visibleElements.get(0)) == 0) {
						String errorMessage = "Local name " + block.getClause().getName() + " is not available" ;
						error(errorMessage, block.getClause(), AlfPackage.eINSTANCE.getAcceptClause_Name(), INSIGNIFICANT_INDEX) ;
					}
				}
			}
		}
		
		//3. There must be a Reception for each Signal identified in each AcceptClause.qualifiedNameList
		AlfPartialScope signalReceptionScope = AlfScopeProvider.scopingTool.getVisibleSignalReceptions(statement) ;
		List<TypeFacade> signalReceptionTypeFacade = new ArrayList<TypeFacade>() ;
		for (List<EObject> l : signalReceptionScope.getScopeDetails()) {
			for (EObject m : l) {
				signalReceptionTypeFacade.add(TypeFacadeFactory.eInstance.createTypeFacade(m)) ;
			}
		}
		Map<Classifier, List<QualifiedNameWithBinding>> allReferencedSignals= new HashMap<Classifier, List<QualifiedNameWithBinding>>() ;
		if (statement.getClause().getQualifiedNameList() != null) {
			QualifiedNameList list = statement.getClause().getQualifiedNameList() ;
			int index = 0 ;
			for (QualifiedNameWithBinding qualifiedName : list.getQualifiedName()) {
				TypeFacade type = TypeFacadeFactory.eInstance.createVoidFacade(qualifiedName) ;
				if (type instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)type ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				}
				else {
					Classifier actualReferencedClassifier = type.extractActualType() ;
					List<QualifiedNameWithBinding> existingReferences = allReferencedSignals.get(actualReferencedClassifier) ;
					if (existingReferences == null) {
						existingReferences = new ArrayList<QualifiedNameWithBinding>() ;
						
					}
					existingReferences.add(qualifiedName) ;
					allReferencedSignals.put(actualReferencedClassifier, existingReferences) ;
					boolean found = false ;
					Iterator<TypeFacade> i = signalReceptionTypeFacade.iterator() ;
					while (i.hasNext() && !found) {
						TypeFacade current = i.next() ;
						if (current.isCompatibleWithMe(type)!=0)
							found = true ;
					}
					if (!found) {
						String errorMessage = "The context classifier does not define any reception for " + type.getLabel() ;
						error(errorMessage, list, AlfPackage.eINSTANCE.getQualifiedNameList_QualifiedName(), index) ;
					}
				}
				index ++ ;
			}
		}
		
		//4. Each Signal must be used only once
		for (Classifier key : allReferencedSignals.keySet()) {
			List<QualifiedNameWithBinding> referencesToKey = allReferencedSignals.get(key) ;
			if (referencesToKey.size()>1) {
				for (QualifiedNameWithBinding qualifiedName : referencesToKey) {
					String errorMessage = "No signal may be named in more than one accept clause" ;
					QualifiedNameList containingList = (QualifiedNameList)qualifiedName.eContainer() ;
					int index = containingList.getQualifiedName().indexOf(qualifiedName) ;
					error(errorMessage, containingList, AlfPackage.eINSTANCE.getQualifiedNameList_QualifiedName(), index - 1 ) ;
				}
			}
		}
	}
	
	
	/**
	 * @param statement
	 * 
	 *  Checks the following rules:
	 *  1. The static type of the target expression must be a Class 
	 *     and it must evaluate to a single object
	 *  2. All qualified names in from or to lists must resolve to classes
	 *  3. All the classes in the from and to lists must be subclasses of the static type of the target expression
	 *  4. None of them may have a common superclass of the static type of the target expression (i.e., disjoint subclasses)
	 *  	 
	 */
	@Check
	public void checkClassifyStatement(ClassifyStatement statement) {
		// 1. The static type of the target expression must be a Class...
		Classifier actualStaticType = null ;
		TypeExpression staticType = new TypeUtils().getTypeOfExpression(statement.getExpression()) ;
		boolean errorFound = false ;
		if (staticType.getTypeFacade() instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)staticType.getTypeFacade() ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
			errorFound = true  ;
		}
		else {
			actualStaticType = staticType.getTypeFacade().extractActualType() ;
		}
		if (actualStaticType == null || !(actualStaticType instanceof Class)) {
			String errorMessage = "The type of the target expression must be a class" ;
			error(errorMessage, AlfPackage.eINSTANCE.getClassifyStatement_Expression()) ;
			errorFound = true ;
		}
		else {
			//... and it must evaluate to a single object
			int upperBound = staticType.getMultiplicityFacade().getUpperBound() ;
			if (upperBound > 1 || upperBound == -1) {
				String errorMessage = "The target expression must evaluate to a single object" ;
				error(errorMessage, AlfPackage.eINSTANCE.getClassifyStatement_Expression()) ;
				errorFound = true ;
			}
		}
		
		// 2. All qualified names in from or to lists must resolve to classes
		ClassificationClause classificationClause = statement.getClause() ;
		List<Class> fromClasses = new ArrayList<Class>() ;
		List<Class> toClasses = new ArrayList<Class>() ;
		if (classificationClause == null) 
			return ;
		boolean isAReclassifyFromAll = false ;
		if (classificationClause.getClassifyFromClause() == null &&
			classificationClause.getClassifyToClause() == null &&
			classificationClause.getReclassyAllClause() == null)
			return ;
		if (classificationClause.getReclassyAllClause() != null)
			// nothing to do with the from list
			isAReclassifyFromAll = true ;
		if (classificationClause.getClassifyFromClause() != null) {
			ClassificationFromClause fromClause = classificationClause.getClassifyFromClause() ;
			for (QualifiedNameWithBinding name : fromClause.getQualifiedNameList().getQualifiedName()) {
				TypeFacade type = TypeFacadeFactory.eInstance.createVoidFacade(name) ;
				if (type instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)type ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
					errorFound = true ;
				}
				else {
					Classifier actualType = type.extractActualType(type) ;
					if (actualType == null || !(actualType instanceof Class)) {
						String errorMessage = "All types in the 'from' list must be Classes" ;
						int index = fromClause.getQualifiedNameList().getQualifiedName().indexOf(name) ;
						error(errorMessage, 
							  fromClause.getQualifiedNameList(), 
							  AlfPackage.eINSTANCE.getQualifiedNameList_QualifiedName(),
							  index) ;
					}
					else {
						fromClasses.add((Class)actualType) ;
					}
				}
			}
		}
		if (classificationClause.getClassifyToClause() != null) {
			ClassificationToClause toClause = classificationClause.getClassifyToClause() ;
			for (QualifiedNameWithBinding name : toClause.getQualifiedNameList().getQualifiedName()) {
				TypeFacade type = TypeFacadeFactory.eInstance.createVoidFacade(name) ;
				if (type instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)type ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
					errorFound = true ;
				}
				else {
					Classifier actualType = type.extractActualType(type) ;
					if (actualType == null || !(actualType instanceof Class)) {
						String errorMessage = "All types in the 'from' list must be Classes" ;
						int index = toClause.getQualifiedNameList().getQualifiedName().indexOf(name) ;
						error(errorMessage, 
							  toClause.getQualifiedNameList(), 
							  AlfPackage.eINSTANCE.getQualifiedNameList_QualifiedName(),
							  index) ;
					}
					else {
						toClasses.add((Class)actualType) ;
					}
				}
			}
		}
		
		
		// 3. All the classes in the from and to lists must be subclasses of the static type of the target expression
		if (errorFound)
			return ; // not necessary to check the remaining
		List<Classifier> fromGenerals = new ArrayList<Classifier>() ;
		List<Classifier> toGenerals = new ArrayList<Classifier>() ;
		if (actualStaticType != null && !errorFound) {
			String errorMessage = "All classes in the 'from' list must be subclasses of the target expression type" ;
			int index = 0 ;
			for (Class c : fromClasses) {
				if (! c.allParents().contains(actualStaticType)) {
					error(errorMessage, 
						  classificationClause.getClassifyFromClause(),
						  AlfPackage.eINSTANCE.getClassificationFromClause_QualifiedNameList(),
						  index) ;
					errorFound = true ;
				}
				fromGenerals.addAll(c.allParents()) ;
				index++ ;
			}
			errorMessage = "All classes in the 'to' list must be subclasses of the target expression type" ;
			index = 0 ;
			for (Class c : toClasses) {
				if (! c.allParents().contains(actualStaticType)) {
					error(errorMessage, 
						  classificationClause.getClassifyToClause(),
						  AlfPackage.eINSTANCE.getClassificationToClause_QualifiedNameList(),
						  index) ;
					errorFound = true ;
				}
				index++ ;
				toGenerals.addAll(c.allParents()) ;
			}
		}
		
		// 4. None of them may have a common superclass of the static type of the target expression (i.e., disjoint subclasses)
		if (errorFound)
			return ; // not necessary to go further
		fromGenerals.retainAll(toGenerals) ;
		for (Classifier c : fromGenerals) {
			if (c.allParents().contains(actualStaticType)) {
				String errorMessage = "Superclasses of classes in 'to' and 'from' lists must be disjoint subclasses of the target expression type" ;
				error(errorMessage, AlfPackage.eINSTANCE.getClassifyStatement_Clause()) ;
				return ;
			}
		}
		
	}
	
	/**
	 * @param statement
	 *  Checks the following rules: 
	 *  1. The statement must respect construction rules of:
	 *  	1.a Invocation, or
	 *  	1.b Variable declaration, or
	 *  	1.c Assignment expression
	 *  2. According to the construction rule, delegate to the appropriate check method
	 */
	@Check
	public void checkInvocationOrAssignmentOrDeclarationStatement(InvocationOrAssignementOrDeclarationStatement statement) {
		//1. The statement must respect construction rules of:
		//		1.b Variable declaration
		if (statement.getVariableDeclarationCompletion() != null) {
			checkVariableDeclarationStatement(statement) ;
		}
		//		1.c Assignment expression
		else if (statement.getAssignmentCompletion() != null) {
			checkAssignmentExpression(statement) ;
		}
		//		1.a Invocation or prefix or suffix
		else {
			checkInvocationOrPrefixOrSuffixStatement(statement) ;
		}
	}
	
	/**
	 * @param statement
	 *   Checks the following rules:
	 *   1. typePart_OR_assignedPart_OR_invocationPart must have an invocation completion, or a postfixOp, or a prefixOp
	 *   2. if it is an invocation:
	 *   	2.a The name must resolve to a Behavior or an Operation
	 *   	2.b Arguments must be type compatibles with the parameters of referenced behavior or operation
	 *   3. if it is a prefixOp:
	 *   	3.a the name must resolve to an assignable property, parameter or local variable
	 *   	3.b the operator must be available for the type of the nameExpression 
	 *   4. if it is a postfixOp:
	 *   	4.a the name must resolve to an assignable property, parameter or local variable
	 *   	4.b the operator must be available for the type of the nameExpression
	 */
	private void checkInvocationOrPrefixOrSuffixStatement(InvocationOrAssignementOrDeclarationStatement statement) {
		// 1. typePart_OR_assignedPart_OR_invocationPart must have an invocation completion, or a postfixOp, or a prefixOp
		boolean isAnInvocation = statement.getTypePart_OR_assignedPart_OR_invocationPart().getInvocationCompletion() != null ;
		boolean isAPrefixExpression = statement.getTypePart_OR_assignedPart_OR_invocationPart().getPrefixOp() != null ;
		boolean isAPostfixExpression = statement.getTypePart_OR_assignedPart_OR_invocationPart().getPostfixOp() != null ;
		boolean hasASuffix = statement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() != null ;
		int resolvedKindOfExpression = 0 ;
		resolvedKindOfExpression += isAnInvocation ? 1 : 0 ;
		resolvedKindOfExpression += isAPrefixExpression ? 1 : 0 ;
		resolvedKindOfExpression += isAPostfixExpression ? 1 : 0 ;
		resolvedKindOfExpression += hasASuffix ? 1 : 0 ;
		if ((resolvedKindOfExpression > 1 && !hasASuffix) || resolvedKindOfExpression==0) {
			String errorMessage = "An invocation expression, OR a prefix expression, OR a postfix expression is expected." ;
			error(errorMessage, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ;
			return ;
		}
		
		//2. if it is an invocation:
		if (isAnInvocation || hasASuffix) {
			// 2.a The name must resolve to a Variable, a Parameter, a Property, a Behavior or an Operation (TODO: can also be an association)
			NameExpression varOrParamOrPropOrOpOrBehav = statement.getTypePart_OR_assignedPart_OR_invocationPart() ;
			TypeExpression typeOfPrefix = new TypeUtils().getTypeOfNameExpression(varOrParamOrPropOrOpOrBehav) ;
			if (typeOfPrefix.getTypeFacade() != null && typeOfPrefix.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)typeOfPrefix.getTypeFacade() ;
				error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				return ;
			}
			if (hasASuffix) {
				// The last suffix must be an invocation
				SuffixExpression suffix = statement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() ;
				SuffixExpression lastSuffix = suffix ;
				boolean suffixHasASuffix = false ;
				do {
					suffixHasASuffix = false ;
					for (Iterator<EObject> content = suffix.eContents().iterator() ; content.hasNext() && !suffixHasASuffix ; ) {
						EObject cddSuffix = content.next() ;
						if (cddSuffix instanceof SuffixExpression) {
							lastSuffix = (SuffixExpression)cddSuffix ;
							suffixHasASuffix = true ;
						}
					}
					if (suffixHasASuffix)
						suffix = lastSuffix ;
				} while (suffixHasASuffix) ;
				if (lastSuffix instanceof PropertyCallExpression) {
					error("An invocation is expected", 
							AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ;
					return ;
				}
			}
			//}
		}
		
		// 3. if it is a prefixOp: or // 4. if it is a postfixOp:
		else if (isAPrefixExpression || isAPostfixExpression) {
			TypeExpression typeOfAssignedElement = new TypeUtils().getTypeOfNameExpression(statement.getTypePart_OR_assignedPart_OR_invocationPart()) ;
			if (typeOfAssignedElement.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)typeOfAssignedElement.getTypeFacade() ;
				error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				return ;
			}
			//1. The assigned part must be assignable, i.e.:
			if (statement.getTypePart_OR_assignedPart_OR_invocationPart().getPath() != null ||
					(statement.getTypePart_OR_assignedPart_OR_invocationPart().getInvocationCompletion() != null 
					 && statement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() == null) ||
					(statement.getTypePart_OR_assignedPart_OR_invocationPart().getSequenceConstructionCompletion() != null) ||
					(statement.getTypePart_OR_assignedPart_OR_invocationPart().getId()==null) ||
					(statement.getTypePart_OR_assignedPart_OR_invocationPart().getId().length() == 0)) {
				error("The assigned part must resolve to an assignable property, parameter or local variable", 
						AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ; 
				return ;
			}
			//1.a It must resolve to a property, or
			//1.b It must resolve to a local variable, or
			//1.c It must resolve to an out or inout parameter
			if (statement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() == null) {
				AlfPartialScope varParamPropScope = AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(statement) ;
				EObject resolved = varParamPropScope.resolveByName(statement.getTypePart_OR_assignedPart_OR_invocationPart().getId()).get(0) ;
				String potentialAssignmentError = AssignmentPolicy.eInstance.isAssignable(resolved) ;
				if (!(potentialAssignmentError.length() == 0)) {
					error(potentialAssignmentError, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ;
					return ;
				}
			}
			else {// a suffix is specified
				// The last suffix must be a property call expression
				SuffixExpression suffix = statement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() ;
				SuffixExpression lastSuffix = suffix ;
				boolean suffixHasASuffix = false ;
				do {
					suffixHasASuffix = false ;
					for (Iterator<EObject> content = suffix.eContents().iterator() ; content.hasNext() && !suffixHasASuffix ; ) {
						EObject cddSuffix = content.next() ;
						if (cddSuffix instanceof SuffixExpression) {
							lastSuffix = (SuffixExpression)cddSuffix ;
							suffixHasASuffix = true ;
						}
					}
					if (suffixHasASuffix)
						suffix = lastSuffix ;
				} while (suffixHasASuffix) ;
				if (! (lastSuffix instanceof PropertyCallExpression)) {
					error("The assigned part must resolve to an assignable property, parameter or local variable", 
							AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ;
					return ;
				}
			}
			
			TypeExpression integerExpression = TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._integer) ;
			TypeExpression naturalExpression = TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._natural) ;
			TypeExpression unlimitedExpression = TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._unlimited) ;
			String operator = isAPrefixExpression ? statement.getTypePart_OR_assignedPart_OR_invocationPart().getPrefixOp() : statement.getTypePart_OR_assignedPart_OR_invocationPart().getPostfixOp() ;
			EStructuralFeature feature = isAPrefixExpression ? AlfPackage.eINSTANCE.getNameExpression_PrefixOp() : AlfPackage.eINSTANCE.getNameExpression_PostfixOp() ; 
			if (! (integerExpression.isCompatibleWithMe(typeOfAssignedElement)!= 0 ||
				   naturalExpression.isCompatibleWithMe(typeOfAssignedElement)!= 0 ||
				   unlimitedExpression.isCompatibleWithMe(typeOfAssignedElement)!= 0)) {
				error("Operator " + operator + " does not apply to " + typeOfAssignedElement.getLabel() , 
					  statement.getTypePart_OR_assignedPart_OR_invocationPart(),
					  feature,
					  INSIGNIFICANT_INDEX) ;
			}
		}
	}
	
	
	/**
	 * @param statement
	 * 
	 *  Checks the following rule:
	 *  1. typePart_OR_assignedPart_OR_invocationPart must resolve to a type
	 *  2. the variable name must be available
	 *  3. initValue must respect the following sub-rules:
	 *  	3.a the type of the expression must be compatible with the type of the variable
	 *  	3.b the assignment operator must be '='
	 */
	private void checkVariableDeclarationStatement(InvocationOrAssignementOrDeclarationStatement statement) {
		// 1. typePart_OR_assignedPart_OR_invocationPart must resolve to a type
		VoidFacade actualVariableType = null ;
		TypeFacade cddVariableType = TypeFacadeFactory.eInstance.createVoidFacade(statement.getTypePart_OR_assignedPart_OR_invocationPart()) ;
		if (cddVariableType instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)cddVariableType ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
		}
		else {
			actualVariableType = (VoidFacade)cddVariableType ;
		}
		VariableDeclarationCompletion declaration = statement.getVariableDeclarationCompletion() ;
		TypeExpression variableTypeExpression = null ;
		if (actualVariableType != null) {
			if (declaration.isMultiplicityIndicator())
				variableTypeExpression = TypeExpressionFactory.eInstance.createTypeExpression(actualVariableType, 0, -1, false, true) ;
			else
				variableTypeExpression = TypeExpressionFactory.eInstance.createTypeExpression(actualVariableType, 1, 1, true, false) ;
		}
		
		// 2. the variable name must be available
		AlfPartialScope vppScope = AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(statement) ;
		if (declaration.getVariableName() != null ) {
			List<EObject> visibleElements = vppScope.resolveByName(declaration.getVariableName()) ;
			if (! visibleElements.isEmpty() && vppScope.getScopingLevel(visibleElements.get(0)) == 0) {
				String errorMessage = "Local name " + declaration.getVariableName() + " is not available" ;
				error(errorMessage, declaration, AlfPackage.eINSTANCE.getVariableDeclarationCompletion_VariableName(), INSIGNIFICANT_INDEX) ;
			}
		}
		
		//3. initValue must respect the following sub-rules:
		if (declaration.getInitValue() != null && declaration.getInitValue().getRightHandSide() != null) {
			TypeExpression typeOfInit = new TypeUtils().getTypeOfSequenceElement(declaration.getInitValue().getRightHandSide()) ;
			if (typeOfInit == null) {
				String errorMessage = "Init value is missing" ;
				error(errorMessage, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_VariableDeclarationCompletion()) ;
				return ;
			}
			if (typeOfInit.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)typeOfInit.getTypeFacade() ;
				error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				return ;
			}
			if (variableTypeExpression != null) {
				// 3.a the type of the expression must be compatible with the type of the variable
				if (variableTypeExpression.isCompatibleWithMe(typeOfInit) == 0) {
					String errorMessage = "Expecting an expression of type " + variableTypeExpression.getLabel() +
										  ". Found an expression of type " + typeOfInit.getLabel() + "." ;
					error(errorMessage,
						  declaration.getInitValue(),
						  AlfPackage.eINSTANCE.getAssignmentCompletion_RightHandSide(),
						  INSIGNIFICANT_INDEX) ;
				}
				// 3.b the assignment operator must be '='
				else if (declaration.getInitValue().getOp() != AssignmentOperator.ASSIGN) {
					String errorMessage = "Expecting assignment operator '='" ;
					error(errorMessage,
						  declaration.getInitValue(), 
						  AlfPackage.eINSTANCE.getAssignmentCompletion_Op(), 
						  INSIGNIFICANT_INDEX) ;
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @param statement
	 * 
	 *  Checks the following rules:
	 *  1. The left part must be assignable, i.e.:
	 *  	1.a It must resolve to a property, or
	 *  	1.b It must resolve to a local variable, or
	 *  	1.c It must resolve to an out or inout parameter
	 *  	1.d It resolves to an association end TODO: Not supported yet
	 *  2. If the assignment operator is "=", the right part must be type compatible with the left part
	 *  3. If the assignment operator is not "=" (e.g. +=, -=, etc.), there must be a matching signature for this operator
	 */
	private void checkAssignmentExpression(InvocationOrAssignementOrDeclarationStatement statement) {
		boolean errorInExpressions = false ;
		// first infer type of the left part
		TypeExpression typeOfLeft = new TypeUtils().getTypeOfNameExpression(statement.getTypePart_OR_assignedPart_OR_invocationPart()) ;
		if (typeOfLeft.getTypeFacade() == null || typeOfLeft.getTypeFacade() instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)typeOfLeft.getTypeFacade() ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
			errorInExpressions = true ;
		}
		// then infer type of the right part
		TypeExpression typeOfRight = null ;
		if (statement.getAssignmentCompletion().getRightHandSide() != null) {
			typeOfRight = new TypeUtils().getTypeOfSequenceElement(statement.getAssignmentCompletion().getRightHandSide()) ;
			if (typeOfRight == null || typeOfRight.getTypeFacade() instanceof ErrorTypeFacade) {
				ErrorTypeFacade error = (ErrorTypeFacade)typeOfRight.getTypeFacade() ;
				error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
				errorInExpressions = true ;
			}
		}
		if (errorInExpressions) // not necessary to validate further
			return ;
		
		//1. The left part must be assignable, i.e.:
		if (statement.getTypePart_OR_assignedPart_OR_invocationPart().getPath() != null ||
				(statement.getTypePart_OR_assignedPart_OR_invocationPart().getInvocationCompletion() != null 
				 && statement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() == null) ||
				(statement.getTypePart_OR_assignedPart_OR_invocationPart().getPrefixOp()!=null) ||
				(statement.getTypePart_OR_assignedPart_OR_invocationPart().getPostfixOp()!=null) ||
				(statement.getTypePart_OR_assignedPart_OR_invocationPart().getSequenceConstructionCompletion() != null)) {
			if (statement.getTypePart_OR_assignedPart_OR_invocationPart().getSequenceConstructionCompletion() != null) {
				if (statement.getTypePart_OR_assignedPart_OR_invocationPart().getSequenceConstructionCompletion().getAccessCompletion() != null)
					return ;
			}
			error("The left part of the assignment must resolve to an assignable property, parameter or local variable", 
					AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ; 
			// NOTE: this an approximation. Cf. => rule 1.d It resolves to an association end TODO: Not supported yet
			return ;
		}
		//1.a It must resolve to a property, or
		//1.b It must resolve to a local variable, or
		//1.c It must resolve to an out or inout parameter
		if (statement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() == null) {
			AlfPartialScope varParamPropScope = AlfScopeProvider.scopingTool.getVisibleVariablesOrParametersOrProperties(statement) ;
			EObject resolved = varParamPropScope.resolveByName(statement.getTypePart_OR_assignedPart_OR_invocationPart().getId()).get(0) ;
			String potentialAssignmentError = AssignmentPolicy.eInstance.isAssignable(resolved) ;
			if (!(potentialAssignmentError.length() == 0)) {
				error(potentialAssignmentError, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ;
			}
		}
		else {// a suffix is specified
			// The last suffix must be a property call expression
			SuffixExpression suffix = statement.getTypePart_OR_assignedPart_OR_invocationPart().getSuffix() ;
			SuffixExpression lastSuffix = suffix ;
			boolean suffixHasASuffix = false ;
			do {
				suffixHasASuffix = false ;
				for (Iterator<EObject> content = suffix.eContents().iterator() ; content.hasNext() && !suffixHasASuffix ; ) {
					EObject cddSuffix = content.next() ;
					if (cddSuffix instanceof SuffixExpression) {
						lastSuffix = (SuffixExpression)cddSuffix ;
						suffixHasASuffix = true ;
					}
				}
				if (suffixHasASuffix)
					suffix = lastSuffix ;
			} while (suffixHasASuffix) ;
			if (! (lastSuffix instanceof PropertyCallExpression)) {
				error("The left part of the assignment must resolve to an assignable property, parameter or local variable", 
						AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPart()) ;
				return ;
			}
		}
		
		// 2. If the assignment operator is "=", the right part must be type compatible with the left part
		if (statement.getAssignmentCompletion().getOp() == AssignmentOperator.ASSIGN) {
			if (typeOfRight.getTypeFacade() == TypeUtils._undefined) {
				String errorMessage = "Right part is untyped" ;
				error(errorMessage, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_AssignmentCompletion()) ;
			}
			else if (typeOfLeft.isCompatibleWithMe(typeOfRight) == 0) {
				String errorMessage = "Cannot assign " + typeOfRight.getLabel() + " to " + typeOfLeft.getLabel() ;
				error(errorMessage, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_AssignmentCompletion()) ;
			}
		}
		else { // 3. If the assignment operator is not "=" (e.g. +=, -=, etc.), there must be a matching signature for this operator
			String assignmentOp = assignmentOpToString(statement.getAssignmentCompletion().getOp()) ;
			List<SignatureFacade> candidates = AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures(assignmentOp) ;
			List<TypeExpression> arguments = new ArrayList<TypeExpression>() ;
			arguments.add(typeOfLeft) ;
			arguments.add(typeOfRight) ;
			List<SignatureFacade> matchingSignatures = SignatureFacade.findNearestSignature(arguments, candidates) ;
			if (matchingSignatures.isEmpty()) {
				String errorMessage = "Operator " + assignmentOp + " does not apply to arguments (" ;
				boolean first = true ;
				for (TypeExpression argType : arguments) {
					if (!first)
						errorMessage += ", " ;
					else
						first = false ;
					errorMessage += argType.getLabel() ;
				}
				errorMessage += ")" ;
				error(errorMessage, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_AssignmentCompletion()) ;
			}
		}
	}
	
	/**
	 * @param statement
	 * 
	 * Checks the following rule:
	 * 1. The associated SuperInvocationExpression must be valid
	 */
	@Check
	public void checkSuperInvocationStatement(SuperInvocationStatement statement) {
		TypeExpression typeOfSuperInvocationExp = new TypeUtils().getTypeOfSuperInvocationExpression(statement.get_super()) ;
		if (typeOfSuperInvocationExp.getTypeFacade() instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)typeOfSuperInvocationExp.getTypeFacade() ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
			return ;
		}
	}
	
	/**
	 * @param statement
	 * 
	 * Checks the following rules:
	 * 1. The associated ThisExpression must be valid
	 * 2. If an assignment is specified:
	 * 		2.a The left part must resolve to a property call expression
	 *  	2.b If the assignment operator is "=", the right part must be type compatible with the left part
	 *  	2.c If the assignment operator is not "=" (e.g. +=, -=, etc.), there must be a matching signature for this operator
	 * 3. If no assignment is specified, the suffix must resolve to an invocation
	 */
	@Check
	public void checkThisInvocationStatement(ThisInvocationStatement statement) {
		// 1. The associated ThisExpression must be valid
		TypeExpression typeOfThisExpression = new TypeUtils().getTypeOfThisExpression(statement.get_this()) ;
		if (typeOfThisExpression.getTypeFacade() instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)typeOfThisExpression.getTypeFacade() ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
			// return ;
		}
		
		// 2. If an assignment is specified
		if (statement.getAssignmentCompletion() != null ) {
			// 2.a The left part must resolve to a property call expression
			if (statement.get_this().getSuffix() == null) {
				error("A Property call expression is missing", 
						AlfPackage.eINSTANCE.getThisInvocationStatement__this()) ;
				//return ;
			}
			else {
				// The last suffix must be an invocation
				SuffixExpression suffix = statement.get_this().getSuffix() ;
				SuffixExpression lastSuffix = suffix ;
				boolean suffixHasASuffix = false ;
				do {
					suffixHasASuffix = false ;
					for (Iterator<EObject> content = suffix.eContents().iterator() ; content.hasNext() && !suffixHasASuffix ; ) {
						EObject cddSuffix = content.next() ;
						if (cddSuffix instanceof SuffixExpression) {
							lastSuffix = (SuffixExpression)cddSuffix ;
							suffixHasASuffix = true ;
						}
					}
					if (suffixHasASuffix)
						suffix = lastSuffix ;
				} while (suffixHasASuffix) ;
				if (!(lastSuffix instanceof PropertyCallExpression)) {
					error("The expression should resolve to a Property", 
							AlfPackage.eINSTANCE.getThisInvocationStatement__this()) ;
					//return ;
				}
			}
			
			TypeExpression typeOfAssignment = null ;
			
			if (statement.getAssignmentCompletion().getRightHandSide() == null)
				return ;
			else {
				typeOfAssignment = new TypeUtils().getTypeOfSequenceElement(statement.getAssignmentCompletion().getRightHandSide()) ;
				if (typeOfAssignment.getTypeFacade() instanceof ErrorTypeFacade) {
					ErrorTypeFacade error = (ErrorTypeFacade)typeOfAssignment.getTypeFacade() ;
					error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
					return ;
				}
				if (typeOfThisExpression.getTypeFacade() instanceof ErrorTypeFacade)
					return ;
			}
			
			// 2.b If the assignment operator is "=", the right part must be type compatible with the left part
			if (statement.getAssignmentCompletion().getOp() == AssignmentOperator.ASSIGN) {
				if (typeOfAssignment.getTypeFacade() == TypeUtils._undefined) {
					String errorMessage = "Right part is untyped" ;
					error(errorMessage, AlfPackage.eINSTANCE.getInvocationOrAssignementOrDeclarationStatement_AssignmentCompletion()) ;
				}
				else if (typeOfThisExpression.isCompatibleWithMe(typeOfAssignment) == 0) {
					String errorMessage = "Cannot assign " + typeOfAssignment.getLabel() + " to " + typeOfThisExpression.getLabel() ;
					error(errorMessage, AlfPackage.eINSTANCE.getThisInvocationStatement_AssignmentCompletion()) ;
				}
			}
			else { // 2.c If the assignment operator is not "=" (e.g. +=, -=, etc.), there must be a matching signature for this operator
				String assignmentOp = assignmentOpToString(statement.getAssignmentCompletion().getOp()) ;
				List<SignatureFacade> candidates = AlfJavaValidator.predefinedBehaviorsAndTypes.getSignatures(assignmentOp) ;
				List<TypeExpression> arguments = new ArrayList<TypeExpression>() ;
				arguments.add(typeOfThisExpression) ;
				arguments.add(typeOfAssignment) ;
				List<SignatureFacade> matchingSignatures = SignatureFacade.findNearestSignature(arguments, candidates) ;
				if (matchingSignatures.isEmpty()) {
					String errorMessage = "Operator " + assignmentOp + " does not apply to arguments (" ;
					boolean first = true ;
					for (TypeExpression argType : arguments) {
						if (!first)
							errorMessage += ", " ;
						else
							first = false ;
						errorMessage += argType.getLabel() ;
					}
					errorMessage += ")" ;
					error(errorMessage, AlfPackage.eINSTANCE.getThisInvocationStatement_AssignmentCompletion()) ;
				}
			}
		}
		else { // 3. If no assignment is specified, the suffix must resolve to an invocation
			if (statement.get_this().getSuffix() == null) {
				error("An invocation expression is expected", 
						AlfPackage.eINSTANCE.getThisInvocationStatement__this()) ;
				return ;
			}
			else {
				// The last suffix must be an invocation
				SuffixExpression suffix = statement.get_this().getSuffix() ;
				SuffixExpression lastSuffix = suffix ;
				boolean suffixHasASuffix = false ;
				do {
					suffixHasASuffix = false ;
					for (Iterator<EObject> content = suffix.eContents().iterator() ; content.hasNext() && !suffixHasASuffix ; ) {
						EObject cddSuffix = content.next() ;
						if (cddSuffix instanceof SuffixExpression) {
							lastSuffix = (SuffixExpression)cddSuffix ;
							suffixHasASuffix = true ;
						}
					}
					if (suffixHasASuffix)
						suffix = lastSuffix ;
				} while (suffixHasASuffix) ;
				if (lastSuffix instanceof PropertyCallExpression) {
					error("An assignment is expected", 
							AlfPackage.eINSTANCE.getThisInvocationStatement__this()) ;
					return ;
				}
			}
		}
	}
	
	/**
	 * @param statement
	 * 
	 * Checks the following rule:
	 * 1. The InstanceCreationExpression must be valid
	 * 2. If a suffix is specified, it must resolve to an invocation
	 */
	@Check
	public void checkInstanceCreationInvocationStatement(InstanceCreationInvocationStatement statement) {
		// 1. The InstanceCreationExpression must be valid
		TypeExpression typeOfInstanceCreationExpression = new TypeUtils().getTypeOfInstanceCreationExpression(statement.get_new()) ;
		if (typeOfInstanceCreationExpression.getTypeFacade() instanceof ErrorTypeFacade) {
			ErrorTypeFacade error = (ErrorTypeFacade)typeOfInstanceCreationExpression.getTypeFacade() ;
			error(error.getLabel(), error.getErrorSource(), error.getStructuralFeature(), INSIGNIFICANT_INDEX) ;
			return ;
		}
		
		// 2. If a suffix is specified, it must resolve to an invocation
		// The last suffix must be an invocation
		SuffixExpression suffix = statement.get_new().getSuffix() ;
		SuffixExpression lastSuffix = suffix ;
		boolean suffixHasASuffix = false ;
		do {
			suffixHasASuffix = false ;
			for (Iterator<EObject> content = suffix.eContents().iterator() ; content.hasNext() && !suffixHasASuffix ; ) {
				EObject cddSuffix = content.next() ;
				if (cddSuffix instanceof SuffixExpression) {
					lastSuffix = (SuffixExpression)cddSuffix ;
					suffixHasASuffix = true ;
				}
			}
			if (suffixHasASuffix)
				suffix = lastSuffix ;
		} while (suffixHasASuffix) ;
		if (lastSuffix instanceof PropertyCallExpression) {
			error("An invocation is expected", 
					AlfPackage.eINSTANCE.getInstanceCreationInvocationStatement__new()) ;
			return ;
		}
	}
	
	private String assignmentOpToString(AssignmentOperator operator) {
		switch (operator) {
		case ANDASSIGN:
			return "&" ;
		case DIVASSIGN:
			return "/" ;
		case LSHIFTASSIGN:
			return "<<" ;
		case MINUSASSIGN:
			return "-" ;
		case MODASSIGN:
			return "%" ;
		case MULTASSIGN:
			return "*" ;
		case ORASSIGN:
			return "|" ;
		case PLUSASSIGN:
			return "+" ;
		case RSHIFTASSIGN:
			return ">>" ;
		case URSHIFTASSIGN:
			return ">>>" ;
		case XORASSIGN:
			return "^" ;
		case ASSIGN:
			return "=" ;
		}
		return "" ; // not reachable
	}
	
	private boolean isANumberType(TypeFacade typeFacade) {
		return 	TypeUtils._integer.isCompatibleWithMe(typeFacade) == 3 ||
				TypeUtils._natural.isCompatibleWithMe(typeFacade) == 3 ||
				TypeUtils._unlimited.isCompatibleWithMe(typeFacade) == 3 ;
	}
	
	@Check
	public void checkTemplateBindingInNameExpression(UnqualifiedName expression) {
		if (expression.getTemplateBinding() != null) {
			String errorMessage = "Template bindings are not supported in name expressions." ; // TODO
			warning(errorMessage, AlfPackage.eINSTANCE.getUnqualifiedName_TemplateBinding()) ;
		}
	}
	
	@Check
	public void checkTemplateBindingInQualifiedNameWithBinding(QualifiedNameWithBinding expression) {
		//if (expression.getBinding() != null) {
		//	String errorMessage = "Template bindings are not supported in this version of the Alf editor." ; // TODO
		//	warning(errorMessage, AlfPackage.eINSTANCE.getQualifiedNameWithBinding_Binding()) ;
		//}
	}
}