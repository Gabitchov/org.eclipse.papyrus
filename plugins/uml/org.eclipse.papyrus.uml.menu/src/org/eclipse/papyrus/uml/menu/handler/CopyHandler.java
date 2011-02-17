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
package org.eclipse.papyrus.uml.menu.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.uml2.uml.Element;

/**
 * Handler for the Copy Action
 * 
 * 
 * 
 */
public class CopyHandler extends AbstractEMFCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.AbstractEMFCommandHandler.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		List<EObject> selection = getSelectedElements();
		ArrayList<EObject> stereotypedSelection = new ArrayList<EObject>();
		stereotypedSelection.addAll(getSelectedElements());
		Iterator<EObject> selecIterator= selection.iterator();
		while (selecIterator.hasNext()) {
			EObject eObject = (EObject) selecIterator.next();
			
			if( eObject instanceof Element){
				stereotypedSelection.addAll(((Element)eObject).getStereotypeApplications());
			}
			//copy stereotype contained into
			Iterator<EObject> iter=eObject.eAllContents();
			while (iter.hasNext()) {
				EObject subeObject = (EObject) iter.next();
				if( subeObject instanceof Element){
					stereotypedSelection.addAll(((Element)subeObject).getStereotypeApplications());
				}
				
			}
			
		}
		return  CopyToClipboardCommand.create(getEditingDomain(), stereotypedSelection);
	}

}
