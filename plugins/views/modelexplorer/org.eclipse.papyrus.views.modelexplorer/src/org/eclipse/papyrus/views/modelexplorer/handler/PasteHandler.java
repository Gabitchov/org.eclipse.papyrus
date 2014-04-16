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
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Use paste strategy 
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.IStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.PasteStrategyManager;

/**
 * Handler for the Paste Action
 * 
 */
public class PasteHandler extends AbstractCommandHandler {

	/**
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * @return
	 */
	@Override
	protected Command getCommand() {
		List<EObject> selection = getSelectedElements();

		List<IStrategy> allStrategies = PasteStrategyManager.getInstance()
				.getAllActiveStrategies();

		if (selection.size() == 1) { //Paste is only available on a simple selection 
			CompoundCommand compoundCommand = new CompoundCommand();
			for (IStrategy iStrategy : allStrategies) {
				Command emfCommand = ((IPasteStrategy) iStrategy)
						.getSemanticCommand(getEditingDomain(), selection.get(0), PapyrusClipboard.getInstance());
				if (emfCommand!=null) {
					compoundCommand.append(emfCommand);
				}
			}
			return compoundCommand;
		}
		return UnexecutableCommand.INSTANCE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#computeEnabled()
	 */
	@Override
	protected boolean computeEnabled() { // paste is only available on a simple selection and wit ha full Clipboard
		if (!PapyrusClipboard.getInstance().isEmpty() && getSelectedElements().size() == 1){
			return true;
		} else {
			return super.computeEnabled();
		}			
	}
}
