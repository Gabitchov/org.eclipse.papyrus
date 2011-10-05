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
 *  E.D.Willink - Initial API and implementation
 *  CEA LIST - Architecture refactoring
 *
 *****************************************************************************/

package org.eclipse.ocl.examples.xtext.papyrus;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationContext;
import org.eclipse.ocl.examples.pivot.uml.UML2Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLPlugin;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
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

public class EssentialOCLPopupEditorConfiguration extends org.eclipse.xtext.gmf.glue.PopupEditorConfiguration
{
	public class Reconciler implements IXtextEMFReconciler2
	{
		public void configureResource(XtextResource resource, EObject umlObject) {
			if (resource instanceof EvaluationContext) {
				TypeManagerResourceAdapter.getAdapter(resource, typeManager);
				org.eclipse.ocl.examples.pivot.Element pivotElement = getPivotModel(umlObject);
				if (pivotElement instanceof org.eclipse.ocl.examples.pivot.NamedElement) {
					((EvaluationContext)resource).setContext((org.eclipse.ocl.examples.pivot.NamedElement)pivotElement, null);
				}
			}
		}

		public void reconcile(EObject modelObject, EObject xtextObject) {
			if (!(modelObject instanceof org.eclipse.uml2.uml.Constraint)) {
				return;
			}
			String newTextualRepresentation = editorHelper.getSourceViewerHandle().getDocument().get() ;
			//			
			// Creates and executes the update command
			//
			UpdateConstraintCommand updateCommand = new UpdateConstraintCommand((org.eclipse.uml2.uml.Constraint)modelObject, newTextualRepresentation);
			try {
				OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				/* [AC] TODO AC => check why LogHelper is not visible
				 * org.eclipse.papyrus.properties.runtime.Activator.log.error(e);
				 */
				e.printStackTrace() ;
			}
			//
		}
	}

	protected class UpdateConstraintCommand extends AbstractTransactionalCommand
	{
		protected final org.eclipse.uml2.uml.Constraint constraint;
		protected final String newTextualRepresentation;

		public UpdateConstraintCommand(org.eclipse.uml2.uml.Constraint constraint, String newTextualRepresentation) {
			super(EditorUtils.getTransactionalEditingDomain(), "Constraint Update", getWorkspaceFiles(constraint));
			this.constraint = constraint;
			this.newTextualRepresentation = newTextualRepresentation;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = null ;
			int indexOfOCLBody = -1 ;
			if (constraint.getSpecification() == null || !(constraint.getSpecification() instanceof org.eclipse.uml2.uml.OpaqueExpression))
				opaqueExpression = UMLFactory.eINSTANCE.createOpaqueExpression() ;
			else {
				opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)constraint.getSpecification() ;
				for (int i = 0 ; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1 ; i++) {
					if (opaqueExpression.getLanguages().get(i).equals("OCL"))
						indexOfOCLBody = i ;
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
	private TypeManager typeManager = null;
	
	public EssentialOCLPopupEditorConfiguration() {}

	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
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
		getPivotModel(constraint);
		Injector xtextInjector = EssentialOCLPopupPlugin.getInstance().getInjector(EssentialOCLPlugin.LANGUAGE_ID);
		IXtextEMFReconciler modelReconciler = new Reconciler();
		String textToEdit = getTextToEdit(element);
		String fileExtension = "essentialocl";
		IXTextSemanticValidator semanticValidator = new DefaultXtextSemanticValidator();
		SourceViewerHandle.bindPartialModelEditorClass(EssentialOCLPartialModelEditor.class) ;
		editorHelper = (PopupXtextEditorHelper)super.createPopupEditorHelper(graphicalEditPart, xtextInjector, modelReconciler, textToEdit, fileExtension, semanticValidator);
		return editorHelper ;
	}

	protected org.eclipse.ocl.examples.pivot.Element getPivotModel(EObject umlObject) {
		if (!(umlObject instanceof org.eclipse.uml2.uml.Constraint)) {
			return null;
		}
		Resource umlResource = umlObject.eResource();
		if (umlResource == null) {
			return null;
		}
		if (typeManager == null) {
			typeManager = new TypeManager();
		}
		UML2Ecore2Pivot adapter = UML2Ecore2Pivot.getAdapter(umlResource, typeManager);
		adapter.getPivotRoot();
		org.eclipse.uml2.uml.Namespace umlContainer = ((org.eclipse.uml2.uml.Constraint)umlObject).getContext();
		if (umlContainer instanceof org.eclipse.uml2.uml.Operation) {
			umlContainer = ((org.eclipse.uml2.uml.Operation)umlObject).getNamespace();
		}
		return adapter.getCreated(org.eclipse.ocl.examples.pivot.Element.class, umlContainer);
	}

	@Override
	public String getTextToEdit(Object editedObject) {
		Constraint umlConstraint = (Constraint)editedObject ;
		String value = "" ;
		if (umlConstraint.getSpecification() != null) {
			if (umlConstraint.getSpecification() instanceof LiteralString) {
				if (((LiteralString)umlConstraint.getSpecification()).getValue() != null)
					value += ((LiteralString)umlConstraint.getSpecification()).getValue() ;
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
