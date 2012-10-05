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
import org.eclipse.uml2.uml.Message;

/**
 * Basic re-orient command for Asynchronous {@link Message}.
 * 
 */
public class MessageAsyncReorientCommand extends MessageAbstractReorientCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 *        the re-orient request
	 */
	public MessageAsyncReorientCommand(ReorientRelationshipRequest request) {
		super(request);
	}
}
