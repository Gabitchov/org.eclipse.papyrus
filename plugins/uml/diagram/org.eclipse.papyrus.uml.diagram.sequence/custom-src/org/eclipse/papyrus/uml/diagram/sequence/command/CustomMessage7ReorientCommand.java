/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message7ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessage7ReorientCommand extends Message7ReorientCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 */
	public CustomMessage7ReorientCommand(ReorientRelationshipRequest request) {
		super(request);
	}

	/**
	 * @Override
	 */
	@Override
	protected boolean canReorientSource() {
		//		if(!(getOldSource() instanceof Element && getNewSource() instanceof Element)) {
		//			return false;
		//		}
		//		if(getLink().getOwnedElements().size() != 1) {
		//			return false;
		//		}
		//		Element target = getLink().getOwnedElements().get(0);
		//		if(!(getLink().eContainer() instanceof Interaction)) {
		//			return false;
		//		}
		//		Interaction container = (Interaction)getLink().eContainer();
		//		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4009(container, getLink(), getNewSource(), target);
		return false;
	}

	/**
	 * @Override
	 */
	@Override
	protected boolean canReorientTarget() {
		if(!(getOldTarget() instanceof Element && getNewTarget() instanceof Element)) {
			return false;
		}
		Element source = getLink().getOwner();
		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}
		Interaction container = (Interaction)getLink().eContainer();
		//Fixed bug about message reconnection.
		if(!UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4009(container, getLink(), source, getNewTarget())) {
			return false;
		}
		//FIXME: Please complete reorientTarget() firstly.
		return false;
		//		return MessageConnectionHelper.canReorientTarget(getLink(), getNewTarget());
	}
}
