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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.uml.Interaction;

public class MessageDeleteReorientCommand extends MessageAbstractReorientCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 *        the re-orient request
	 */
	public MessageDeleteReorientCommand(ReorientRelationshipRequest request) {
		super(request);
	}

	/**
	 * <pre>
	 * Ensure the target is either a {@link Lifeline} or a {@link DestructionEvent}.
	 * </pre>
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.command.MessageAbstractReorientCommand#canReorientTarget()
	 * 
	 * @return true if the link end can be re-oriented to a new target
	 */
	@Override
	protected boolean canReorientTarget() {
//FIXME : change for UML 2.4
//		// Verify possible type of new target
//		if(!((getNewTarget() instanceof DestructionEvent) || (getNewTarget() instanceof Lifeline))) {
//			return false;
//		}

		// Ensure the message owner is an interaction
		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}

		return true;
	}
}
