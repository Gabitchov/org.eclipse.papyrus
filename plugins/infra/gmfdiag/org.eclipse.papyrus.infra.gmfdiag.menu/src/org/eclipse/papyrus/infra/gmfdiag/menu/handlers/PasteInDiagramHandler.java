/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.menu.handlers;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.IStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.PasteStrategyManager;


/**
 * The handler for the paste with model in Diagram 
 * 
 */
public class PasteInDiagramHandler extends AbstractGraphicalCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		
		PapyrusClipboard.getInstance().resetTarget();
		
		List<IGraphicalEditPart> selectedElements = getSelectedElements();
		if (selectedElements.size() == 1){ // Paste is only enabled on a simple selection
			//if (PapyrusClipboard.getInstance().size() > 0) { // TODO : Paste is only enabled if there is something inside the clipboard
			GraphicalEditPart targetOwnerEditPart = (GraphicalEditPart) selectedElements.get(0);
			org.eclipse.gef.commands.CompoundCommand compoundCommand = new org.eclipse.gef.commands.CompoundCommand("Paste all elements"); //$NON-NLS-1$
			
			List<IStrategy> allStrategies = PasteStrategyManager.getInstance()
					.getAllActiveStrategies();			
			for (IStrategy iStrategy : allStrategies) {
				IPasteStrategy iPasteStrategy = (IPasteStrategy) iStrategy;
				Command graphicalCommand = iPasteStrategy.getGraphicalCommand(getEditingDomain(), targetOwnerEditPart, PapyrusClipboard.getInstance());
				if (graphicalCommand!=null) {
					compoundCommand.add(graphicalCommand);
				}
			}
			return compoundCommand;	
		//	}
		}
		return UnexecutableCommand.INSTANCE;
	}

	// TODO : setEnable if selection.size == 1 and Papyrus Clipboard  or other is not empty
	
}
