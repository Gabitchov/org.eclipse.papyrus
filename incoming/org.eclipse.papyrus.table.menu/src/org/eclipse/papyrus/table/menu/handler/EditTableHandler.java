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
package org.eclipse.papyrus.table.menu.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.facet.widgets.celleditors.CommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.nattable.api.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.papyrus.table.menu.messages.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This handler allows to edit the table description
 * 
 * 
 * 
 */
public class EditTableHandler extends AbstractHandler {

	/**
	 * Title for the dialog
	 */
	public static final String title = Messages.EditTableHandler_EditDescription_Title;

	/**
	 * Message for the dialog
	 */
	public static final String message = Messages.EditTableHandler_EditDescription_Message;


	/**
	 * Core provided by Mia-Software
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if(activePart != null) {
			INatTableWidgetProvider natTableWidgetPart = (INatTableWidgetProvider)activePart.getAdapter(INatTableWidgetProvider.class);
			if(natTableWidgetPart != null) {

				if(activePart instanceof IEditingDomainProvider) {
					IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider)activePart;
					EditingDomain editingDomain = editingDomainProvider.getEditingDomain();
					TableInstance tableInstance = natTableWidgetPart.getNatTableWidget().getTableInstance();
					String currentDescription = tableInstance.getDescription();
					InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), title, message, currentDescription, null);
					if(dialog.open() == InputDialog.OK) {
						String newDescription = dialog.getValue();
						ICommandFactory commandFactory = CommandFactoriesRegistry.getInstance().getCommandFactoryFor(editingDomain);
						Command cmd = commandFactory.createSetCommand(editingDomain, natTableWidgetPart.getNatTableWidget().getTableInstance(), TableinstancePackage.eINSTANCE.getTableInstance_Description(), newDescription);
						editingDomain.getCommandStack().execute(cmd);
					}
				}
			}
		}
		return null;
	}

}
