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
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentAnnotatedElementItemSemanticEditPolicy.
 * 
 * @generated
 */
public class CommentAnnotatedElementItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * Instantiates a new comment annotated element item semantic edit policy.
	 * 
	 * @generated
	 */
	public CommentAnnotatedElementItemSemanticEditPolicy() {
		super(UMLElementTypes.CommentAnnotatedElement_4015);
	}

	/**
	 * Gets the destroy reference command.
	 * 
	 * @param req
	 *        the req
	 * @return the destroy reference command
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}
}
