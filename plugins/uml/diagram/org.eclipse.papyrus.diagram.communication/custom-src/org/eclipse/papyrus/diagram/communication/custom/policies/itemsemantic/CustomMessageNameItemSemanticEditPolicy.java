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
 *  Saadia Dhouib saadia.dhouib@cea.fr  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.policies.itemsemantic;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.communication.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Message;


// TODO: Auto-generated Javadoc
/**
 * The Class CustomMessageNameItemSemanticEditPolicy is intended to manage the deletion of a message when it is a label of a connector.
 */
public class CustomMessageNameItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * Instantiates a new custom message name item semantic edit policy.
	 */
	public CustomMessageNameItemSemanticEditPolicy() {
		super(UMLElementTypes.Message_8009);


	}

	/**
	 * @see org.eclipse.papyrus.diagram.communication.edit.policies.UMLBaseItemSemanticEditPolicy#getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest)
	 * 
	 * @param req
	 * @return
	 */

	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);

		EObject elementToDestroy = req.getElementToDestroy();
		List<EObject> elementsToDestroy = new ArrayList<EObject>();

		//A. Find the elements to destroy
		if(elementToDestroy instanceof Message) {
			Message message = (Message)elementToDestroy;
			//Add the message to the list of elements to destroy
			elementsToDestroy.add(message);
		}

		//B. Build the command to destroy all the semantic elements
		for(EObject selectedEObject : elementsToDestroy) {

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
			if(provider == null) {
				continue;
			}

			// Retrieve delete command from the Element Edit service
			DestroyElementRequest request = new DestroyElementRequest(selectedEObject, false);
			ICommand deleteCommand = provider.getEditCommand(request);

			// Add current EObject destroy command to the global command
			cmd.add(deleteCommand);
		}


		//C. Build the command to destroy all the views associated to the message
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToDestroy);
		if(provider == null) {
			return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
		}

		ICommand destroyViewsCommand = provider.getEditCommand(req);

		if(destroyViewsCommand == null) {
			return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
		}
		cmd.add(destroyViewsCommand);


		return getGEFWrapper(cmd.reduce());
	}
}
