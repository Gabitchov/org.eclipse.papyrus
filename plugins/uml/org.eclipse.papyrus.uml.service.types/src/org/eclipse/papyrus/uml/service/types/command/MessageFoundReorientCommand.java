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

public class MessageFoundReorientCommand extends MessageAbstractReorientCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 *        the re-orient request
	 */
	public MessageFoundReorientCommand(ReorientRelationshipRequest request) {
		super(request);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.command.MessageAbstractReorientCommand#canReorientSource()
	 * 
	 * @return false (re-orient source not allowed)
	 */
	@Override
	protected boolean canReorientSource() {
		return false;
	}
}
