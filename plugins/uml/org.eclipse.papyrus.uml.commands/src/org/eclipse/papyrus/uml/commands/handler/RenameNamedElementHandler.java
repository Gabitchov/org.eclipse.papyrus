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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.commands.handler;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This handler allows to rename {@link NamedElement}
 * 
 * 
 * 
 */
public class RenameNamedElementHandler extends AbstractCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<EObject> selectedElements = getSelectedElements();
		if(selectedElements.size() == 1 && selectedElements.get(0) instanceof NamedElement) {
			final NamedElement namedElement = (NamedElement)selectedElements.get(0);
			final String currentName = namedElement.getName();
			if(currentName != null) {

				AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "RenameCommand", null) { //$NON-NLS-1$

					/**
					 * 
					 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
					 *      org.eclipse.core.runtime.IAdaptable)
					 * 
					 * @param monitor
					 * @param info
					 * @return
					 * @throws ExecutionException
					 */
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Rename...", "New name:", currentName, null);
						if(dialog.open() == Window.OK) {
							final String name = dialog.getValue();
							if(name != null && name.length() > 0) {
								namedElement.setName(name);
							}
							return CommandResult.newOKCommandResult();
						} else {
							return CommandResult.newCancelledCommandResult();
						}
					}
				};
				return new GMFtoEMFCommandWrapper(cmd);
			}
		}

		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected boolean computeEnabled() {
		boolean enabled = super.computeEnabled();
		if(enabled) {
			List<EObject> selectedElements = getSelectedElements();
			EObject selection = selectedElements.get(0);
			enabled = !EMFHelper.isReadOnly(selection);
		}
		return enabled;
	}

}
