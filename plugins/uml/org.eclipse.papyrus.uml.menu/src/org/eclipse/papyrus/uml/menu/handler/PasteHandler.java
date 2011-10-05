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
package org.eclipse.papyrus.uml.menu.handler;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.papyrus.uml.menu.command.PasteElementCommand;

/**
 * Handler for the Paste Action
 * 
 */
public class PasteHandler extends AbstractEMFCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.AbstractEMFCommandHandler.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<EObject> selection = getSelectedElements();
		if(editingDomain != null && selection.size() == 1) {
			//return PasteFromClipboardCommand.create(getEditingDomain(), selection.get(0), null);
			//select UML Element and copy
			return new PasteElementCommand(editingDomain, selection.get(0));
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		boolean enabled = super.isEnabled();
		if(enabled) {
			List<EObject> selectedElements = getSelectedElements();
			EObject selection = selectedElements.get(0);
			enabled = !EMFHelper.isReadOnly(selection);
		}
		return enabled;
	}

}
