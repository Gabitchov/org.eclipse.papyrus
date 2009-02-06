/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 * 
 * $Id$
 **********************************************************************/
package org.eclipse.papyrus.outline.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandActionDelegate;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * This action creates a new sibling for a given domain element. <br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class CreateSiblingAction extends Action {

	private Object descriptor;

	private EMFCommandOperation command;

	private TransactionalEditingDomain editingDomain;

	/**
	 * Constructor
	 * 
	 * @param domain
	 *            The editor AdapterFactoryEditingDomain
	 * @param selectedObject
	 *            The parent EObject
	 * @param desc
	 *            the sibling description
	 */
	public CreateSiblingAction(TransactionalEditingDomain domain, EObject selectedObject, Object desc) {
		super();

		this.descriptor = desc;
		this.editingDomain = domain;
		this.command = createActionCommand(selectedObject);

		updateAction();
	}

	/**
	 * Update the action with the current command settings
	 */
	private void updateAction() {
		if (command != null) {
			setEnabled(command.canExecute());

			if (command.getCommand() instanceof CommandActionDelegate) {
				CommandActionDelegate commandActionDelegate = (CommandActionDelegate) command.getCommand();

				ImageDescriptor imageDescriptor = ExtendedImageRegistry.getInstance().getImageDescriptor(commandActionDelegate.getImage());
				if (imageDescriptor != null) {
					setImageDescriptor(imageDescriptor);
				}
				if (commandActionDelegate.getText() != null) {
					setText(commandActionDelegate.getText());
				}
				if (commandActionDelegate.getDescription() != null) {
					setDescription(commandActionDelegate.getDescription());
				}
				if (commandActionDelegate.getToolTipText() != null) {
					setToolTipText(commandActionDelegate.getToolTipText());
				}
			}
		}
	}

	/**
	 * Creates the EMF command that creates the sibling
	 * 
	 * @param object
	 *            the parent EObject
	 * @return the creation command
	 */
	protected EMFCommandOperation createActionCommand(EObject object) {
		Command cmd = UnexecutableCommand.INSTANCE;

		Collection<EObject> collec = new ArrayList<EObject>();
		collec.add(object);

		if (object != null) {
			if (editingDomain != null) {
				cmd = CreateChildCommand.create(editingDomain, ((EObject) object).eContainer(), descriptor, collec);
			}
		}
		return new EMFCommandOperation(editingDomain, cmd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		if (editingDomain != null) {
			editingDomain.getCommandStack().execute(command.getCommand());
		}
	}
}
