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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * This action is used to delete a selected domain element
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class DeleteAction extends Action {

	private EMFCommandOperation deleteCommand;

	private TransactionalEditingDomain editingDomain;

	/**
	 * Constructor
	 * 
	 * @param domain
	 *            The editor AdapterFactoryEditingDomain
	 * @param selectedObject
	 *            The parent EObject
	 */
	public DeleteAction(AdapterFactoryEditingDomain domain,
			EObject selectedObject) {
		super();

		// Retrieve the editingDomain from the given model element
		editingDomain = TransactionUtil.getEditingDomain(selectedObject);

		this.deleteCommand = createActionCommand(selectedObject);
		updateAction();
	}

	private void updateAction() {
		if (deleteCommand != null) {
			setEnabled(deleteCommand.canExecute());
			ISharedImages sharedImages = PlatformUI.getWorkbench()
					.getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
			setText("Delete");
		}
	}

	protected EMFCommandOperation createActionCommand(EObject object) {
		Command cmd = UnexecutableCommand.INSTANCE;
		if (object != null && editingDomain != null) {
			cmd = RemoveCommand.create(editingDomain, object);
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
			editingDomain.getCommandStack().execute(deleteCommand.getCommand());
		}
	}

}
