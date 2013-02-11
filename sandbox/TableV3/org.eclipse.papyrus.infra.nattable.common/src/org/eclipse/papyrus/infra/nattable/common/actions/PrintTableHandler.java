/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.common.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.print.command.PrintCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOffCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOnCommand;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.editor.AbstractEMFNattableEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * Handler for the print table action
 * 
 */
public class PrintTableHandler extends AbstractHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			final IEditorPart editor = ServiceUtilsForHandlers.getInstance().getNestedActiveIEditorPart(event);
			if(editor instanceof AbstractEMFNattableEditor) {
				//FIXME : the print action shold be provided by the widget, no?
				final NatTable natTable = (NatTable)editor.getAdapter(NatTable.class);
				natTable.doCommand(new TurnViewportOffCommand());
				natTable.doCommand(new PrintCommand(natTable.getConfigRegistry(), natTable.getShell()));
				natTable.doCommand(new TurnViewportOnCommand());
			} else {
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Table Print", "Print can't be done");
			}
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

}
