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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.pastemanager.service;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.Collection;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.pastemanager.command.CommentDropCreation;
import org.eclipse.papyrus.pastemanager.request.PasteRequest;

/**
 * this provider has the following behavior
 * when the System clipboard contains a string the papyrus clipboard has no information
 * (a copy has be done on the system). In this case, a comment is created and displayed in the diagram
 * the body contains the string from the clipboard.
 * In other case, a paste request {@link org.org.eclipse.papyrus.pastemanager.request.PasteRequest} in send to the target editpart in order to obtain
 * the paste command
 * 
 */

public class DefaultPasteCommandProvider implements IPasteCommandProvider {


	/**
	 * this method provides a command to paste by taking information from the clipboard of the system or gmf clipbaord
	 * 
	 * @param targetEditPart
	 *        the target editpart where we want to paste
	 * @param systemClipboard
	 *        the system clipboard see {@link DataFlavor} to see how to extract information
	 * @param papyrusCliboard
	 *        contains the list of views to paste
	 * @return
	 */

	public ICommand getCommand(GraphicalEditPart targetEditPart, Clipboard systemClipboard, Collection<Object> papyrusCliboard) {

		//look in the clipboard of the system
		String bufferSystem = null;
		DataFlavor[] dataFlavors = Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		for(int i = 0; i < dataFlavors.length; i++) {
			try {
				if(dataFlavors[i].isFlavorTextType() && dataFlavors[i].isMimeTypeEqual(DataFlavor.stringFlavor)) {

					bufferSystem = Toolkit.getDefaultToolkit().getSystemClipboard().getData(dataFlavors[i]).toString();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		//detection of a paste command from the system
		if(bufferSystem != null) {
			// here, the choice is to create a comment from a string
			// if the you want to modify it overload the method paste from System
			return pasteFromSystem(targetEditPart, bufferSystem);
		}
		//else

		/* Send the request to the target edit part of the paste command for the currently selected part */
		PasteRequest pasteRequest = new PasteRequest(targetEditPart.getEditingDomain().getClipboard());
		org.eclipse.gef.commands.Command pasteCommand = targetEditPart.getCommand(pasteRequest);
		if(pasteCommand != null) {
			return new CommandProxy(pasteCommand);
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * this method has in charge to paste from the system a string.
	 * if you want to add a new behavior, overload this method
	 * 
	 * @param targetEditPart
	 * @param comment
	 *        the string that comes from the system
	 * @return the command in charge to do the modification in the system
	 */
	public ICommand pasteFromSystem(GraphicalEditPart targetEditPart, String comment) {
		return new CommentDropCreation("paste", comment, targetEditPart.getNotationView().getElement(), targetEditPart);
	}


}
