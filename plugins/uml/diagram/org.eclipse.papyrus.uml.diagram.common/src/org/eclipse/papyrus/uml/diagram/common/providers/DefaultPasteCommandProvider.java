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
package org.eclipse.papyrus.uml.diagram.common.providers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.PasteRequest;
import org.eclipse.papyrus.uml.diagram.common.commands.CommentDropCreation;
import org.eclipse.papyrus.uml.diagram.common.commands.PapyrusDuplicateWrapperCommand;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.gef.commands.Command;

/**
 * this provider has the following behavior
 * when the System clipboard contains a string the papyrus clipboard has no information
 * (a copy has be done on the system). In this case, a comment is created and displayed in the diagram
 * the body contains the string from the clipboard.
 * In other case, a paste request {@link org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.PasteRequest} in send to the target editpart in order to obtain
 * the paste command ( graphically or the paste with model command
 * 
 */

public class DefaultPasteCommandProvider implements IPasteCommandProvider {

	private static final String LINUX = "Linux"; //$NON-NLS-1$
	private static final String OS_NAME = "os.name"; //$NON-NLS-1$

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

	public ICommand getPasteViewCommand(GraphicalEditPart targetEditPart, Clipboard systemClipboard, Collection<Object> papyrusClipboard) {

		if(!System.getProperty(OS_NAME).equals(LINUX)) {
			// examine system clipboard
			String bufferSystem = null;
			// long millisBefore = System.currentTimeMillis ();
			DataFlavor[] dataFlavors = Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
			// System.out.println (">>> TEST: time spend in getAvailableDataFlavorsCall: " + (System.currentTimeMillis () - millisBefore));
			for(int i = 0; i < dataFlavors.length; i++) {
				try {
					if(dataFlavors[i].isFlavorTextType() && dataFlavors[i].isMimeTypeEqual(DataFlavor.stringFlavor)) {
						bufferSystem = Toolkit.getDefaultToolkit().getSystemClipboard().getData(dataFlavors[i]).toString();
					}
				} catch (Exception e) {
					// TODO: Add logger
				}
			}
			// detection of a paste command from the system
			if(bufferSystem != null) {
				// here, the choice is to create a comment from a string
				// if the you want to modify it overload the method paste from System
				return pasteFromSystem(targetEditPart, bufferSystem);
			}
			//else
		}

		/* Send the request to the target edit part of the paste command for the currently selected part */
		PasteRequest pasteRequest = new PasteRequest(targetEditPart.getEditingDomain().getClipboard());
		Command pasteCommand = targetEditPart.getCommand(pasteRequest);
		if(pasteCommand != null) {
			return new CommandProxy(pasteCommand);
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * This method is in charge of pasting a string from the system.
	 * If you want to add a new behavior, overload this method
	 * 
	 * @param targetEditPart
	 * @param comment
	 *        the string that comes from the system
	 * @return the command in charge to do the modification in the system
	 */
	public ICommand pasteFromSystem(GraphicalEditPart targetEditPart, String comment) {
		return new CommentDropCreation("Paste from system", comment, targetEditPart.getNotationView().getElement(), targetEditPart); //$NON-NLS-1$
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * @inheritedDoc
	 */
	public ICommand getPasteWithModelCommand(GraphicalEditPart targetEditPart, Clipboard systemClipboard, Collection<Object> papyrusCliboard) {
		//look in the clipboard of the system
		String bufferSystem = null;
		if(!System.getProperty(OS_NAME).equals(LINUX)) {
			DataFlavor[] dataFlavors = Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
			for(int i = 0; i < dataFlavors.length; i++) {
				try {
					if(dataFlavors[i].isFlavorTextType() && dataFlavors[i].isMimeTypeEqual(DataFlavor.stringFlavor)) {

						bufferSystem = Toolkit.getDefaultToolkit().getSystemClipboard().getData(dataFlavors[i]).toString();
					}
				} catch (Exception e) {
					Activator.log.error(e);
				}
			}
			//detection of a paste command from the system
			if(bufferSystem != null) {
				// here, the choice is to create a comment from a string
				// if the you want to modify it overload the method paste from System
				return pasteFromSystem(targetEditPart, bufferSystem);
			}
			//else
		}
		/* Send the request to the target edit part of the paste command for the currently selected part */
		ArrayList objectToPaste = new ArrayList();
		if(papyrusCliboard != null && papyrusCliboard.size() >= 1) {
			objectToPaste.addAll(papyrusCliboard);
			
			
			Iterator iterator = papyrusCliboard.iterator();
			//in order to paste with model, semantic element has to be put in the list
			while(iterator.hasNext()) {
				Object object = (Object)iterator.next();
				if(object instanceof View) {
					objectToPaste.add(((View)object).getElement());
					
					ArrayList<EObject> stereotypedSelection = new ArrayList<EObject>();
					EObject semantic =((View)object).getElement();
					if( semantic instanceof Element){
						stereotypedSelection.addAll(((Element)semantic).getStereotypeApplications());
					}
					//copy stereotype contained into
					Iterator<EObject> iter=semantic.eAllContents();
					while (iter.hasNext()) {
						EObject subeObject = (EObject) iter.next();
						if( subeObject instanceof Element){
							stereotypedSelection.addAll(((Element)subeObject).getStereotypeApplications());
						}
						
					}
					objectToPaste.addAll(stereotypedSelection);
				}

			}
			//creation of duplicate request to obtain the functionnality of GMF
			DuplicateElementsRequest duplicateElementRequest = new DuplicateElementsRequest(targetEditPart.getEditingDomain(), objectToPaste);

			//add the wrapper
			RootEditPart topEditPart = targetEditPart.getRoot();
			if(topEditPart.getChildren().get(0) instanceof DiagramEditPart) {

				org.eclipse.gef.commands.Command gefCommand = ((DiagramEditPart)topEditPart.getChildren().get(0)).getCommand(new EditCommandRequestWrapper(duplicateElementRequest));
				ICommand command = new PapyrusDuplicateWrapperCommand(targetEditPart.getEditingDomain(), "Papyrus duplicate wrapper command", objectToPaste, (ICommandProxy)gefCommand, (View)targetEditPart.getModel()); //$NON-NLS-1$
				return command;
			}
		}

		return UnexecutableCommand.INSTANCE;
	}


}
