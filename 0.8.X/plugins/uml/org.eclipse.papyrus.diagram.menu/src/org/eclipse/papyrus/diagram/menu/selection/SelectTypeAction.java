/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Barthelemy HABA (Atos Origin) barthelemy.haba@atosorigin.com - 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.menu.selection;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.actions.AbstractAction;
import org.eclipse.papyrus.diagram.menu.messages.Messages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

/**
 * This class represent action to execute when user make a click on selectTypeElement item in pop-up menu
 */
public class SelectTypeAction extends AbstractAction {

	public final static String ID = "papyrus.selectType"; //$NON-NLS-1$

	public SelectTypeAction() {
		this.setId(ID);
		setText(Messages.SelectTypeAction_SelectActionName);
		setToolTipText(Messages.SelectTypeAction_SelectionActionTooltype);
	}

	@Override
	public boolean isEnabled() {
		Diagram currentDiagram = this.getCurrentDiagram();
		if(currentDiagram != null) {
			if(!(this.getSelection().isEmpty())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IHandlerService handlerService = (IHandlerService)window.getService(IHandlerService.class);
		try {
			handlerService.executeCommand(SelectByTypeHandler.ID, null);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}
}
