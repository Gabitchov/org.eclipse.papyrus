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
package org.eclipse.papyrus.uml.textedit.operation.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart;
import org.eclipse.papyrus.uml.textedit.operation.xtext.validation.OperationJavaValidator;
import org.eclipse.papyrus.uml.textedit.operation.xtext.validation.OperationSemanticValidator;
import org.eclipse.papyrus.uml.alf.validation.NamingUtils;
import org.eclipse.papyrus.uml.alf.validation.typing.MultiplicityFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.MultiplicityFacadeFactory;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeExpression;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeExpressionFactory;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacade;
import org.eclipse.papyrus.uml.alf.validation.typing.TypeFacadeFactory;
import org.eclipse.papyrus.uml.textedit.operation.xtext.ui.internal.OperationActivator;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.xtext.gmf.glue.edit.part.PopupXtextEditorHelper;

import com.google.inject.Injector;

public class OperationPopupEditorConfigurationContribution extends
		PopupEditorConfiguration {

	private Operation operation = null ;
	private PopupXtextEditorHelper editorHelper = null ;
	private String newName = "" ;
	private boolean newIsAbstract = false ;
	private boolean newIsConstructor = false ;
	private boolean newIsDestructor = false ;
	private String newTextualRepresentation = "" ;
	private VisibilityKind newVisibility = VisibilityKind.PUBLIC_LITERAL ;
	private List<FormalParameter> newFormalParameters = new ArrayList<FormalParameter>() ;
	private TypePart newReturnType = null ;
	protected IGraphicalEditPart graphicalEditPart = null;
	
	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		// resolves the edit part, and the associated semantic element
		if(!(editPart instanceof IGraphicalEditPart))
			return null;
		graphicalEditPart = (IGraphicalEditPart)editPart;

		if(!(graphicalEditPart.resolveSemanticElement() instanceof Operation))
			return null;
		operation = (Operation)graphicalEditPart.resolveSemanticElement();
		
		OperationJavaValidator.init(operation) ;
		
		// retrieves the XText injector
		Injector injector = OperationActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.operation.xtext.Operation");

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement());
		String fileExtension = "" + ".operation";
		
		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				OperationDefinitionOrStub xtextOperation = (OperationDefinitionOrStub)xtextObject ;
				
				newName = xtextOperation.getDeclaration().getName() ;
				if (newName.startsWith("\'")) {
					newName = newName.substring(1, newName.length() - 1) ;
				}
				newIsAbstract = xtextOperation.getDeclaration().isAbstract() ;
				if (xtextOperation.getDeclaration().getVisibilityIndicator() != null) {
					switch (xtextOperation.getDeclaration().getVisibilityIndicator()) {
					case PUBLIC:
						newVisibility = VisibilityKind.PUBLIC_LITERAL ;
						break;
					case PRIVATE:
						newVisibility = VisibilityKind.PRIVATE_LITERAL ;
						break;
					case PROTECTED:
						newVisibility = VisibilityKind.PROTECTED_LITERAL ;
						break;
					default:
						break;
					}
				}
				newFormalParameters = new ArrayList<FormalParameter>() ;
				if (xtextOperation.getDeclaration().getFormalParameters() != null
					&& xtextOperation.getDeclaration().getFormalParameters().getFormalParameterList() != null)
					newFormalParameters.addAll(xtextOperation.getDeclaration().getFormalParameters().getFormalParameterList().getFormalParameter()) ;
				newReturnType = xtextOperation.getDeclaration().getReturnType() ;
				newIsConstructor = xtextOperation.getDeclaration().isIsConstructor() ;
				newIsDestructor = xtextOperation.getDeclaration().isIsDestructor() ;
				newTextualRepresentation = editorHelper.getSourceViewerHandle().getDocument().get() ;

				UpdateOperationCommand updateCommand = new UpdateOperationCommand(operation);
				//try {
				//	OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null);
				//} catch (ExecutionException e) {
				//	//TODO org.eclipse.papyrus.properties.runtime.Activator.log.error(e);
				//}
				TransactionalEditingDomain domain = graphicalEditPart.getEditingDomain() ;
				domain.getCommandStack().execute(updateCommand) ;
			}
		};
		editorHelper = (PopupXtextEditorHelper)super.createPopupEditorHelper(graphicalEditPart, 
																		injector, 
																		reconciler, 
																		textToEdit, 
																		fileExtension,
																		new OperationSemanticValidator());
		return editorHelper ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Operation) {
			Operation editedOperation = (Operation)editedObject;
			String textToEdit = "" + getOperationLabel(editedOperation);
			return textToEdit;
		}
		return "not an operation";
	}
	
	private String getOperationLabel(Operation operation) {
		String label = "" ;
		// TODO: Rely on stereotype <<TextualRepresentation>>
		for (Comment comment : operation.getOwnedComments()) {
			if (comment.getBody() != null && comment.getBody().startsWith("<<TextualRepresentation>>")) {
				String actualBody = comment.getBody() ;
				actualBody = actualBody.substring("<<TextualRepresentation>>".length()) ;
				label += actualBody ;
				break ;
			}
		}
		if (label.length() == 0) {
			label += generateLabel(operation) ;
		}
		return label ;
	}
	
	private String generateLabel(Operation operation) {
		
		String label = "" ;
		
		if (! operation.getOwnedParameters().isEmpty()) {
			label = "// This textual representation has been automatically generated \n" ;
			label += "// Qualified names, imports and aliases have not been taken into account. \n" ;
			label += "// It may be necessary to manually correct types of parameters. \n \n" ;
		}
		
		switch (operation.getVisibility()) {
		case PUBLIC_LITERAL:
			label += "public " ;
			break;
		case PRIVATE_LITERAL:
			label += "private " ;
			break;
		case PROTECTED_LITERAL:
			label += "protected " ;
			break;
		default:
			break;
		}
		
		if (operation.isAbstract()) {
			label += "abstract " ;
		}
		
		if (NamingUtils.isJavaCompliant(operation.getName()))
			label += operation.getName();
		else
			label += "\'" + operation.getName() + "\'" ;
		label += " (" ;
		boolean first = true ;
		Parameter returnParam = null ;
		for (Parameter p : operation.getOwnedParameters()) {
			if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
				if (first == true)
					first = false ;
				else
					label += ", "  ;
				switch (p.getDirection()) {
				case IN_LITERAL:
					label += "in " ;
					break;
				case OUT_LITERAL:
					label += "out " ;
					break;
				case INOUT_LITERAL:
					label += "inout " ;
					break;
				default:
					break;
				}
				String parameterName = "" ;
				if (NamingUtils.isJavaCompliant(p.getName()))
					parameterName += p.getName() ;
				else
					parameterName += "\'" + p.getName() + "\'" ;
				label += parameterName + " : " ;
				if (p.getType()==null)
					label += "any " ;
				else if (NamingUtils.isJavaCompliant(p.getType().getName()))
					label += p.getType().getName() + " " ;
				else
					label += "\'" + p.getType().getName() + "\' ";
				label += MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(p.getLower(), p.getUpper(), p.isUnique(), p.isOrdered()).getLabel();
				if (p.isOrdered() && ! p.isUnique())
					label += " sequence" ;
				else {
					if (p.isOrdered())
						label += " ordered" ;
					if (! p.isUnique())
						label += " nonunique" ;
				}
			}
			else {
				returnParam = p ;
			}
		}
		label += ")" ;
		if (returnParam != null) {
			if (operation.getType() == null)
				label += " any" ;
			else if (NamingUtils.isJavaCompliant(operation.getType().getName()))
				label += " " + operation.getType().getName() ;
			else
				label += " \'" + operation.getType().getName() + "\'" ;
			label += MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(operation.getLower(), operation.getUpper(), operation.isUnique(), operation.isOrdered()) ;
		}
		if (operation.isAbstract())
			label += " ;" ;
		else
			label += " { }" ;
		return label ;
	}
	
	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected class UpdateOperationCommand extends RecordingCommand {

		private Operation operation;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected void doExecute() {
			operation.setName(newName) ;
			operation.setIsAbstract(newIsAbstract) ;
			operation.setVisibility(newVisibility) ;
			operation.getOwnedParameters().clear() ;
			
			if (newIsConstructor || newIsDestructor) {
				Stereotype stereotypeCreate = operation.getApplicableStereotype("Standard::Create") ;
				Stereotype stereotypeDestroy = operation.getApplicableStereotype("Standard::Destroy") ;
				if (stereotypeCreate == null || stereotypeDestroy == null) {
					// Can't do anything. The Standard UML profile is not applied.
				}
				else {
					if (newIsConstructor) {
						// Applies stereotype Create if necessary, unapplies stereotype Destroy if necessary
						if (operation.getAppliedStereotype("Standard::Create") == null)
							operation.applyStereotype(stereotypeCreate) ;
						if (operation.getAppliedStereotype("Standard::Destroy") != null)
							operation.unapplyStereotype(stereotypeDestroy) ;
					}
					else if (newIsDestructor) {
						// Applies stereotype Destroy if necessary, unapplies stereotype Create if necessary
						if (operation.getAppliedStereotype("Standard::Destroy") == null)
							operation.applyStereotype(stereotypeDestroy) ;
						if (operation.getAppliedStereotype("Standard::Create") != null)
							operation.unapplyStereotype(stereotypeCreate) ;
					}
				}
			}
			
			for (FormalParameter p : newFormalParameters) {
				TypeExpression typeExpression = TypeExpressionFactory.eInstance.createTypeExpression(p) ;
				String newParamName = p.getName() ;
				if (p.getName().startsWith("\'")) {
					newParamName = newParamName.substring(1, newParamName.length() - 1 ) ;
				}
				Parameter newParam = operation.createOwnedParameter(newParamName, typeExpression.getTypeFacade() != null ? typeExpression.getTypeFacade().extractActualType() : null) ;
				switch (p.getDirection()) {
				case IN:
					newParam.setDirection(ParameterDirectionKind.IN_LITERAL) ;
					break;
				case OUT:
					newParam.setDirection(ParameterDirectionKind.OUT_LITERAL) ;
					break;
				case INOUT:
					newParam.setDirection(ParameterDirectionKind.INOUT_LITERAL) ;
					break;
				}
				newParam.setLower(typeExpression.getMultiplicity().getLowerBound()) ;
				newParam.setUpper(typeExpression.getMultiplicity().getUpperBound()) ;
				operation.getOwnedParameters().add(newParam) ;
				if (p.getType().getMultiplicity() != null) {
					if (p.getType().getMultiplicity().isSequence()) {
						newParam.setIsOrdered(true) ;
						newParam.setIsUnique(false) ;
					}
					else {
						if (p.getType().getMultiplicity().isOrdered())
							newParam.setIsOrdered(true) ;
						else
							newParam.setIsOrdered(false) ;
						if (p.getType().getMultiplicity().isNonUnique())
							newParam.setIsUnique(false) ;
						else
							newParam.setIsUnique(true) ;
					}
				}
			}
			if (newReturnType != null) {
				TypeFacade returnType = null ;
				if (newReturnType.getTypeName().getQualifiedName() != null)
					returnType = TypeFacadeFactory.eInstance.createVoidFacade(newReturnType.getTypeName().getQualifiedName()) ;
				MultiplicityFacade returnMultiplicity = null ;
				if (newReturnType.getMultiplicity() != null)
					returnMultiplicity = MultiplicityFacadeFactory.eInstance.createMultiplicityFacade(newReturnType.getMultiplicity()) ;
				else
					returnMultiplicity = MultiplicityFacadeFactory.eInstance.createMultiplicityFacade() ;
				operation.setType(returnType != null ? returnType.extractActualType() : null) ;
				operation.setLower(returnMultiplicity.getLowerBound()) ;
				operation.setUpper(returnMultiplicity.getUpperBound()) ;
			}
			Comment textualRepresentation = null ;
			for (Comment comment : operation.getOwnedComments()) {
				if (comment.getBody() != null && comment.getBody().startsWith("<<TextualRepresentation>>")) {
					textualRepresentation = comment ;
					break ;
				}
			}
			if (textualRepresentation == null)
				textualRepresentation = operation.createOwnedComment() ;
			String commentBody = "<<TextualRepresentation>>" ;
			commentBody += newTextualRepresentation ;
			textualRepresentation.setBody(commentBody) ;
			//return CommandResult.newOKCommandResult(operation);
		}

		public UpdateOperationCommand(Operation operation) {
			//super(EditorUtils.getTransactionalEditingDomain(), "Operation Update", getWorkspaceFiles(operation));
			super(graphicalEditPart.getEditingDomain()) ;
			this.operation = operation;
		}
	}

}
