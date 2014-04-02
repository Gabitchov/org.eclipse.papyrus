/*****************************************************************************
 * Copyright (c) 2009, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 410346
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.composite.custom.messages.Messages;
import org.eclipse.papyrus.uml.diagram.composite.custom.ui.CollaborationRoleTreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * <pre>
 * This class provides a custom creation command for RoleBinding between {@link CollaborationUse} and
 * {@link ConnectableElement}.
 * </pre>
 */
public class RoleBindingCreateCommand extends org.eclipse.papyrus.uml.diagram.composite.edit.commands.RoleBindingCreateCommand {

	/**
	 * Constructor
	 * 
	 * @param request
	 *        the relationship creation request
	 * @param source
	 *        element used as source of the new relationship
	 * @param target
	 *        element used as target of the new relationship
	 */
	public RoleBindingCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	/**
	 * <pre>
	 *  The method executes the creation :
	 *  - opens a selection dialog to choose a {@link ConnectableElement} reference as a role by the {@link CollaborationUse} type
	 *  - created a dependency between the selected role and the {@link ConnectableElement} that will be bind to it
	 *  
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

		if(!canExecute()) {
			throw new ExecutionException(Messages.RoleBindingCreateCommand_INVALID_ARGS_MSG);
		}

		// Retrieve the graphical source of the binding.
		// This differs from the semantic source of the binding which is a role of the
		// CollaborationUse type.
		CollaborationUse graphicalSource = (CollaborationUse)getSource();

		// Create and open the selection dialog
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		Shell currentShell = new Shell(Display.getCurrent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(currentShell, new AdapterFactoryLabelProvider(adapterFactory), new CollaborationRoleTreeContentProvider());

		try {
			// Set dialog parameters
			dialog.setTitle(Messages.RoleBindingRoleSelectionDialog_Title);
			dialog.setMessage(Messages.RoleBindingRoleSelectionDialog_Message);
			dialog.setAllowMultiple(false);
			dialog.setHelpAvailable(false);
			// The source CollaborationUse is set as input for the selection dialog,
			// the CollaborationRoleTreeContentProvider provides the roles that can possibly be
			// selected.
			dialog.setInput(graphicalSource);

			dialog.open();
		} finally {
			adapterFactory.dispose();
		}

		// If a ConnectableElement has been selected, complete command execution
		// using selection as the "newly created" element and make the edited
		// Collaboration reference it in the CollaborationRoles eReference.
		if(dialog.getReturnCode() == ElementTreeSelectionDialog.OK) {

			ConnectableElement roleToBind = (ConnectableElement)dialog.getFirstResult();
			// Create a Dependency (the binding) between selected role and a ConnectableElement
			// (the target)
			Dependency newBinding = UMLFactory.eINSTANCE.createDependency();
			getContainer().getPackagedElements().add(newBinding);
			newBinding.getClients().add(roleToBind);
			newBinding.setName("binding_" + roleToBind.getName() + "_" + getTarget().getName());
			newBinding.getSuppliers().add(getTarget());
			graphicalSource.getRoleBindings().add(newBinding);

			doConfigure(newBinding, monitor, info);

			((CreateElementRequest)getRequest()).setNewElement(newBinding);

			return CommandResult.newOKCommandResult(newBinding);
		}

		// No role selected: abort element creation
		return CommandResult.newCancelledCommandResult();
	}
}
