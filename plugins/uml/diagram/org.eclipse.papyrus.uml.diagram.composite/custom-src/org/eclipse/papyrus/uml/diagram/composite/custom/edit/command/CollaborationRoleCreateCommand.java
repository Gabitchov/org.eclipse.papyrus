/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.custom.messages.Messages;
import org.eclipse.papyrus.uml.diagram.composite.custom.ui.CollaborationRoleValidator;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CollaborationRoleCreateCommandCN;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.ConnectableElement;

/**
 * <pre>
 * This class provides a custom creation command for CollaborationRole.
 * CollaborationRole are references toward any {@link ConnectableElement} in the model
 * (not necessarily owned by the {@link Collaboration}) graphically represented in 
 * {@link Collaboration}.
 * </pre>
 */
public class CollaborationRoleCreateCommand extends CollaborationRoleCreateCommandCN {

	/**
	 * Constructor
	 * 
	 * @param req
	 *        the creation request
	 */
	public CollaborationRoleCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
	}

	/**
	 * Constructor
	 * 
	 * @param req
	 *        the creation request
	 * @param eObject
	 *        the element to edit
	 */
	public CollaborationRoleCreateCommand(CreateElementRequest req, EObject eObject, Diagram diagram) {
		super(req, eObject, diagram);
	}

	/**
	 * Creates an new {@link CollaborationRoleCreateCommand}
	 * 
	 * @param req
	 *        the creation request
	 * @param eObject
	 *        the element to edit
	 * @return the new creation command for CollaborationRole
	 */
	public static CollaborationRoleCreateCommand create(CreateElementRequest req, EObject eObject, Diagram diagram) {
		return new CollaborationRoleCreateCommand(req, eObject, diagram);
	}

	/**
	 * <pre>
	 * The method executes the creation :
	 *  - opens a selection dialog to choose a {@link ConnectableElement} to reference as a role
	 *  - add the selection in CollaborationRole eReference of the edited {@link Collaboration}.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

		// Retrieve the edited Collaboration
		Collaboration owner = (Collaboration)getElementToEdit();

		// Create and open the selection dialog
		AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		Shell currentShell = new Shell(Display.getCurrent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(currentShell, new AdapterFactoryLabelProvider(adapterFactory), new AdapterFactoryContentProvider(adapterFactory));

		// Set dialog parameters
		dialog.setTitle(Messages.CollaborationRoleSelectionDialog_Title);
		dialog.setMessage(Messages.CollaborationRoleSelectionDialog_Message);
		dialog.setAllowMultiple(false);
		dialog.setHelpAvailable(false);
		// ConnectableElement from the whole model can be selected as role.
		dialog.setInput(owner.getModel());
		// CollaborationRoleValidator ensures that an the selected element is a ConnectableElement.
		dialog.setValidator(new CollaborationRoleValidator());

		dialog.open();

		// If a ConnectableElement has been selected, complete command execution
		// using selection as the "newly created" element and make the edited
		// Collaboration reference it in the CollaborationRoles eReference.
		if(dialog.getReturnCode() == ElementTreeSelectionDialog.OK) {
			ConnectableElement role = (ConnectableElement)dialog.getFirstResult();

			owner.getCollaborationRoles().add((ConnectableElement)role);

			try {
				doConfigure((ConnectableElement)role, monitor, info);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			((CreateElementRequest)getRequest()).setNewElement((ConnectableElement)role);

			return CommandResult.newOKCommandResult(role);
		}

		// No role selected: abort element creation
		return CommandResult.newCancelledCommandResult();
	}
}
