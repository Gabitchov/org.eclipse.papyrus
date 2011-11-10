/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.custom.actions;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.uml.diagram.composite.custom.messages.Messages;
import org.eclipse.papyrus.uml.diagram.composite.custom.ui.InterfaceManagerDialog;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

/**
 * This handler provides the action to manage the provided and required {@link Interface} for a {@link Port}
 * 
 * 
 * 
 */
public class ManageProvidedInterfacesHandler extends GraphicalCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		List<IGraphicalEditPart> selection = getSelectedElements();
		if(selection.size() != 1) {
			return UnexecutableCommand.INSTANCE;
		}
		if(!(selection.get(0) instanceof PortEditPart)) {
			return UnexecutableCommand.INSTANCE;
		}
		ManageProvidedInterfaceAction action = new ManageProvidedInterfaceAction(selection.get(0));
		return action.getCommand();
	}

	/**
	 * 
	 * This class provides the action to manage the provided and required interfaces
	 * 
	 * 
	 */
	public class ManageProvidedInterfaceAction {

		/** the {@link Port} */
		private Port port;

		/** the {@link Type} of the port */
		private Type type;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param editpart
		 *        the editpart of the port
		 */
		public ManageProvidedInterfaceAction(IGraphicalEditPart editpart) {
			Object obj = ((View)editpart.getModel()).getElement();
			Assert.isTrue(obj instanceof Port);
			this.port = (Port)obj;
			this.type = port.getType();
		}

		/**
		 * Returns the command to add/remove provided/required interfaces
		 * 
		 * @return
		 *         the command to add/remove provided/required interfaces
		 */
		public Command getCommand() {
			if(type != null && !(type instanceof Classifier)) {
				return UnexecutableCommand.INSTANCE;
			} else if(type == null) {
				MessageDialog dialog = new MessageDialog(DisplayUtils.getDefaultShell(), Messages.InterfaceManagerDialog_Title, null, Messages.ManageProvidedInterfacesHandler_TheTypeOfThePortIsNotDefined, MessageDialog.WARNING, new String[]{ Messages.ManageProvidedInterfacesHandler_OK }, 0);
				dialog.open();
			} else {
				InterfaceManagerDialog dialog = new InterfaceManagerDialog(DisplayUtils.getDefaultShell(), this.port);
				if(dialog.open() == Dialog.OK) {
					return dialog.getCommand();
				}
			}
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		if(getSelectedElements().size() == 1) {
			Object obj = ((View)getSelectedElements().get(0).getModel()).getElement();
			return obj instanceof Port;
		}
		return false;
	}
}
