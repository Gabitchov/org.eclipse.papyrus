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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.handler;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.messages.Messages;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.ui.InterfaceManagerDialog;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <pre>
 * This handler provides the handler to manage the provided and required {@link Interface} 
 * of a {@link Port} without graphically creating {@link InterfaceRealization} and 
 * {@link Usage} relationships.
 * </pre>
 */
public class ManageProvidedInterfacesHandler extends GraphicalCommandHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand() {
		List<IGraphicalEditPart> selection = getSelectedElements();
		if(selection.size() != 1) {
			return UnexecutableCommand.INSTANCE;
		}
		EObject semanticElement = selection.get(0).resolveSemanticElement();

		// Selection should be a Port
		if(!(semanticElement instanceof Port)) {
			return UnexecutableCommand.INSTANCE;
		}

		// Selection should not be a FlowPort
		FlowPort flowPort = UMLUtil.getStereotypeApplication((Port)semanticElement, FlowPort.class);
		if(flowPort != null) {
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
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		List<IGraphicalEditPart> selection = getSelectedElements();
		if(selection.size() != 1) {
			return false;
		}
		EObject semanticElement = selection.get(0).resolveSemanticElement();

		// Selection should be a Port but should not be a FlowPort
		if(!(semanticElement instanceof Port)) {
			return false;
		}

		// Selection should not be a FlowPort
		FlowPort flowPort = UMLUtil.getStereotypeApplication((Port)semanticElement, FlowPort.class);
		if(flowPort != null) {
			return false;
		}

		return true;
	}
}
