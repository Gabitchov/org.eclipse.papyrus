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
package org.eclipse.papyrus.uml.diagram.component.custom.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.diagram.component.custom.messages.Messages;
import org.eclipse.papyrus.uml.diagram.component.custom.ui.DisplayInterfaceMDialog;
import org.eclipse.papyrus.uml.diagram.component.custom.ui.InterfaceManagerDialog;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

/**
 * This handler provides the action to manage the provided and required {@link Interface} for a {@link Port}.
 */
public class ManageProvidedInterfacesHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(selection.isEmpty()) {
			return null;
		}

		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			if(structuredSelection.getFirstElement() instanceof PortEditPart){
			EObject selectedElement = EMFHelper.getEObject(structuredSelection.getFirstElement());
			if(selectedElement instanceof Port) {
				Port port = (Port)selectedElement;
				ManageProvidedInterfaceAction action = new ManageProvidedInterfaceAction(port,(EditPart) structuredSelection.getFirstElement() );
				try {
					ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(port).getCommandStack().execute(new GEFtoEMFCommandWrapper(action.getCommand()));
				} catch (ServiceException ex) {
					throw new ExecutionException("An unexpected exception occurred", ex);
				}
			}
		}
	}
		return null;
	}

	/**
	 * This class provides the action to manage the provided and required interfaces.
	 */
	public class ManageProvidedInterfaceAction {

		/** the {@link Port}. */
		private Port port;

		/** the {@link Type} of the port. */
		private Type type;

		private EditPart portEditPart;

		/**
		 * 
		 * Constructor.
		 * @param port the semantic port
		 * 
		 * @param aportEditpart
		 *        the editpart of the port
		 */
		public ManageProvidedInterfaceAction(Port port, EditPart aportEditpart) {
			this.port = port;
			this.type = port.getType();
			this.portEditPart= aportEditpart;
		}

		/**
		 * Returns the command to add/remove provided/required interfaces.
		 * 
		 * @return the command
		 *         the command to add/remove provided/required interfaces
		 */
		public Command getCommand() {
			if(type != null && !(type instanceof Classifier)) {
				return UnexecutableCommand.INSTANCE;
			} else if(type == null) {
				MessageDialog dialog = new MessageDialog(DisplayUtils.getDefaultShell(), Messages.InterfaceManagerDialog_Title, null, Messages.ManageProvidedInterfacesHandler_TheTypeOfThePortIsNotDefined, MessageDialog.WARNING, new String[]{ Messages.ManageProvidedInterfacesHandler_OK }, 0);
				dialog.open();
			} else {
				InterfaceManagerDialog dialog = new DisplayInterfaceMDialog(DisplayUtils.getDefaultShell(), (PortEditPart)portEditPart);
				if(dialog.open() == Dialog.OK) {
					return dialog.getCommand();
				}
			}
			return UnexecutableCommand.INSTANCE;
		}
	}

}
