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
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message6ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.MessageConnectionHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessage6ReorientCommand extends Message6ReorientCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 */
	public CustomMessage6ReorientCommand(ReorientRelationshipRequest request) {
		super(request);
	}

	/**
	 * @Override
	 */
	@Override
	protected boolean canReorientSource() {
		if(!(getOldSource() instanceof Element && getNewSource() instanceof Element)) {
			return false;
		}
		if(getLink().getOwnedElements().size() != 1) {
			return false;
		}
		Element target = getLink().getOwnedElements().get(0);
		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}
		Interaction container = (Interaction)getLink().eContainer();
		if(!UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4008(container, getLink(), getNewSource(), target)) {
			return false;
		}
		return MessageConnectionHelper.canReorientSource(getLink(), getNewSource());
	}

	@Override
	protected boolean canReorientTarget() {
		return false;
	}
}
