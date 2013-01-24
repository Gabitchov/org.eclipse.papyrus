/*****************************************************************************
 * Copyright (c) 2011,2012 CEA LIST and others
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  E.D.Willink - Initial API and implementation
 *  CEA LIST - Architecture refactoring
 *  E.D.Willink - Bug 388529
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLPlugin;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.xtext.gmf.glue.edit.part.DefaultXtextSemanticValidator;
import org.eclipse.xtext.gmf.glue.edit.part.IXTextSemanticValidator;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.xtext.gmf.glue.edit.part.PopupXtextEditorHelper;
import org.eclipse.xtext.gmf.glue.partialEditing.SourceViewerHandle;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Injector;


/**
 * this plugin is the configuration of the essential editor
 *
 */
public class EssentialOCLPopupEditorConfiguration extends org.eclipse.xtext.gmf.glue.PopupEditorConfiguration
{
	
	/**
	 * this is a specific reconcilers to manipulate  OCL constraint
	 *
	 */
	public class Reconciler implements IXtextEMFReconcilerWithContext
	{
		public void configureResource(XtextResource resource, EObject umlObject) {

			//to launch the editor, it is important to set the context. if not there is no completion and the constraint can not be validated
			//thanks to  E.D.Willink
			System.out.println("configureResource : " + resource + " for " + umlObject);
			if (resource instanceof BaseResource){
				try {
					if (!PivotUtil.setParserContext((BaseResource)resource, umlObject)) {
						Activator.log.error("Unknown context type", new ExecutionException("Unknown context type for " + umlObject));
					}
				} catch (ParserException e) {
					Activator.log.error("Failed to create context", new ExecutionException("Failed to create context for " + umlObject, e));
				}
			}
		}
		
		/**
		 * 
		 * @see org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler#reconcile(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
		 *
		 * @param modelObject the uml element to modify
		 * @param xtextObject the xtext structure
		 */
		public void reconcile(EObject modelObject, EObject xtextObject) {
			if (!(modelObject instanceof org.eclipse.uml2.uml.Constraint)) {
				return;
			}
			String newTextualRepresentation = editorHelper.getSourceViewerHandle().getDocument().get() ;
			//
			// Creates and executes the update command
			//
			TransactionalEditingDomain editingDomain =org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain((org.eclipse.uml2.uml.Constraint)modelObject);

			UpdateConstraintCommand updateCommand = new UpdateConstraintCommand(editingDomain,(org.eclipse.uml2.uml.Constraint)modelObject, newTextualRepresentation);
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(updateCommand));

		}
	}


	/**
	 * the command to save the content of the OCL constraint into the body of the UML constraint element
	 *
	 */
	protected class UpdateConstraintCommand extends AbstractTransactionalCommand
	{
		protected final org.eclipse.uml2.uml.Constraint constraint;
		protected final String newTextualRepresentation;

		public UpdateConstraintCommand(TransactionalEditingDomain editingDomain,org.eclipse.uml2.uml.Constraint constraint, String newTextualRepresentation) {
			super(editingDomain, "Constraint Update", getWorkspaceFiles(constraint));
			this.constraint = constraint;
			this.newTextualRepresentation = newTextualRepresentation;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = null ;
			int indexOfOCLBody = -1 ;
			if (constraint.getSpecification() == null || !(constraint.getSpecification() instanceof org.eclipse.uml2.uml.OpaqueExpression)) {
				opaqueExpression = UMLFactory.eINSTANCE.createOpaqueExpression() ;
			} else {
				opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)constraint.getSpecification() ;
				for (int i = 0 ; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1 ; i++) {
					if (opaqueExpression.getLanguages().get(i).equals("OCL")) {
						indexOfOCLBody = i ;
					}
				}
			}
			if (indexOfOCLBody == -1) {
				opaqueExpression.getLanguages().add("OCL") ;
				opaqueExpression.getBodies().add(newTextualRepresentation) ;
			}
			else {
				opaqueExpression.getBodies().remove(indexOfOCLBody) ;
				opaqueExpression.getBodies().add(indexOfOCLBody, newTextualRepresentation) ;
			}
			constraint.setSpecification(opaqueExpression) ;
			return CommandResult.newOKCommandResult(constraint);
		}
	}

	protected PopupXtextEditorHelper editorHelper = null ;

	/**
	 * 
	 * Constructor.
	 *
	 */
	public EssentialOCLPopupEditorConfiguration() {
		
	}

	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		editorHelper=null;
		
		if (!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart)editPart;
		Object model = graphicalEditPart.getModel();
		if (model == null) {
			return null;
		}
		if (!(model instanceof View)) {
			return null;
		}
		View view = (View) model;
		EObject element = view.getElement();
		if (element == null) {
			return null;
		}
		if (!(element instanceof org.eclipse.uml2.uml.Constraint)) {
			return null;
		}
		org.eclipse.uml2.uml.Constraint constraint = (org.eclipse.uml2.uml.Constraint) element;
		org.eclipse.uml2.uml.ValueSpecification specification = constraint.getSpecification();
		if (specification == null) {
			return null;
		}
		if (!(specification instanceof org.eclipse.uml2.uml.LiteralString || specification instanceof org.eclipse.uml2.uml.OpaqueExpression)) {
			return null;
		}
		Injector xtextInjector = EssentialOCLPopupPlugin.getInstance().getInjector(EssentialOCLPlugin.LANGUAGE_ID);
		IXtextEMFReconciler modelReconciler = new Reconciler();
		String textToEdit = getTextToEdit(element);
		String fileExtension = "essentialocl";
		IXTextSemanticValidator semanticValidator = new DefaultXtextSemanticValidator();
		SourceViewerHandle.bindPartialModelEditorClass(EssentialOCLPartialModelEditor.class) ;
		editorHelper = (PopupXtextEditorHelper)super.createPopupEditorHelper(graphicalEditPart, xtextInjector, modelReconciler, textToEdit, fileExtension, semanticValidator);
		return editorHelper ;
	}

	@Override
	public String getTextToEdit(Object editedObject) {
		Constraint umlConstraint = (Constraint)editedObject ;
		String value = "" ;
		if (umlConstraint.getSpecification() != null) {
			if (umlConstraint.getSpecification() instanceof LiteralString) {
				if (((LiteralString)umlConstraint.getSpecification()).getValue() != null) {
					value += ((LiteralString)umlConstraint.getSpecification()).getValue() ;
				}
			}
			else if (umlConstraint.getSpecification() instanceof org.eclipse.uml2.uml.OpaqueExpression) {
				int indexOfOCLBody = -1 ;
				org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)umlConstraint.getSpecification() ;
				for (int i = 0 ;
					i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1 ;
					i ++) {
					if (opaqueExpression.getLanguages().get(i).equals("OCL")) {
						value += opaqueExpression.getBodies().get(i) ;
						indexOfOCLBody = i ;
					}
				}
			}
		}
		return value;
	}
}
