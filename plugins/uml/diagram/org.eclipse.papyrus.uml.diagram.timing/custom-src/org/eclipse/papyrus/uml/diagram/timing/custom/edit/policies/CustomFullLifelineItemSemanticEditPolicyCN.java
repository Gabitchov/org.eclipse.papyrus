/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.CustomMessageCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.MessageUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.policies.FullLifelineItemSemanticEditPolicyCN;

public class CustomFullLifelineItemSemanticEditPolicyCN extends FullLifelineItemSemanticEditPolicyCN {

	/** Allows creating a a lost Message that targets a Lifeline, or a found Message that originates from a Lifeline */
	@Override
	protected Command getCreateRelationshipCommand(final CreateRelationshipRequest req) {
		final IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return null;
		}
		if(MessageUtils.isMessage(requestElementType)) {
			return getGEFWrapper(new CustomMessageCreateCommand(req));
		}
		return super.getCreateRelationshipCommand(req);
	}
}
