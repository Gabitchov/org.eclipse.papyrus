/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.internal.UmlCollaborationUseActivator;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.inject.Injector;

/**
 * 
 * Editor for the {@link CollaborationUse}
 * 
 */
public class CollaborationUseEditor extends DefaultXtextDirectEditorConfiguration {

	/** the new name for the {@link CollaborationUse} */
	private String newName;

	/** the new type for the {@link CollaborationUse} */
	private Collaboration newType;

	/** the new visibility for the {@link CollaborationUse} */
	private org.eclipse.uml2.uml.VisibilityKind newVisibility;

	/** the managed {@link CollaborationUse} */
	private CollaborationUse collaborationUse;

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#createPopupEditorHelper(java.lang.Object)
	 * 
	 * @param editPart
	 * @return
	 */
	/*
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {

		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		graphicalEditPart = (IGraphicalEditPart)editPart;

		if(!(graphicalEditPart.resolveSemanticElement() instanceof CollaborationUse)) {
			return null;
		}
		collaborationUse = (CollaborationUse)graphicalEditPart.resolveSemanticElement();

		// retrieves the XText injector
		Injector injector = UmlCollaborationUseActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.UmlCollaborationUse"); //$NON-NLS-1$

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement()); //$NON-NLS-1$
		String fileExtension = "" + ".umlcollaborationuse"; //$NON-NLS-1$ //$NON-NLS-2$

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a CollaborationUseRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof CollaborationUse)) {
					return;
				}
				while(xtextObject != null && !(xtextObject instanceof CollaborationUseRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null) {
					return;
				}
				CollaborationUseRule propertyRuleObject = (CollaborationUseRule)xtextObject;

				// Retrieves the information to be populated in modelObject


				newName = "" + propertyRuleObject.getName(); //$NON-NLS-1$

				TypeRule typeRule = propertyRuleObject.getType();
				if(typeRule == null) {
					newType = null;
				} else {
					newType = (Collaboration)typeRule.getType();
				}

				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;

				switch(propertyRuleObject.getVisibility()) {
				case PUBLIC:
					newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;
					break;
				case PACKAGE:
					newVisibility = org.eclipse.uml2.uml.VisibilityKind.PACKAGE_LITERAL;
					break;
				case PRIVATE:
					newVisibility = org.eclipse.uml2.uml.VisibilityKind.PRIVATE_LITERAL;
					break;
				case PROTECTED:
					newVisibility = org.eclipse.uml2.uml.VisibilityKind.PROTECTED_LITERAL;
					break;
				default:
					break;
				}

				IUndoableOperation updateCommand = getUpdateCommand();

				try {
					CheckedOperationHistory.getInstance().execute(updateCommand, new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					System.err.println(e);
				}
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension, new SemanticValidator());
	}
	*/
	
	/**
	 * Returns the list of requests to update the {@link #collaborationUse}
	 * 
	 * @return
	 *         the list of requests to update the {@link #collaborationUse}
	 */
	protected List<SetRequest> getRequests() {
		List<SetRequest> requests = new ArrayList<SetRequest>();
		requests.add(new SetRequest(collaborationUse, UMLPackage.eINSTANCE.getNamedElement_Name(), newName));
		requests.add(new SetRequest(collaborationUse, UMLPackage.eINSTANCE.getNamedElement_Visibility(), newVisibility));
		requests.add(new SetRequest(collaborationUse, UMLPackage.eINSTANCE.getCollaborationUse_Type(), newType));
		return requests;
	}

	/**
	 * Returns the update command
	 * 
	 * @return
	 *         the update command
	 */
	protected IUndoableOperation getUpdateCommand() {
		CompositeCommand cc = new CompositeCommand("Set values for CollaborationUse"); //$NON-NLS-1$
		org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(collaborationUse);
		if(provider != null) {

			ICommand editCommand = null;
			for(SetRequest current : getRequests()) {
				editCommand = provider.getEditCommand(current);

				if(editCommand != null && editCommand.canExecute()) {
					cc.add(editCommand);
				}
			}
		}
		return cc;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 * 
	 * @param editedObject
	 * @return
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof CollaborationUse) {
			return UMLCollaborationUseEditorUtil.getLabel((CollaborationUse)editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "not a CollaborationUse"; //$NON-NLS-1$
	}

	@Override
	public Injector getInjector() {
		return UmlCollaborationUseActivator.getInstance().getInjector(UmlCollaborationUseActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_COLLABORATIONUSE_XTEXT_UMLCOLLABORATIONUSE);
	}

	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		if(!(umlObject instanceof CollaborationUse)) {
			return null;
		}

		// Creates and executes the update command
		IUndoableOperation updateCommand = getUpdateCommand();
		return (ICommand) updateCommand;
	}
}