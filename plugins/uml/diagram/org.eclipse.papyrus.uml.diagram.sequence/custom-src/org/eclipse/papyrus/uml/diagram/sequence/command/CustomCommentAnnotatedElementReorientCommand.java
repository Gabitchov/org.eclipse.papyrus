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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEndEditPart.MessageEndHelper;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCommentAnnotatedElementReorientCommand extends CommentAnnotatedElementReorientCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 */
	public CustomCommentAnnotatedElementReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request);
	}

	/**
	 * @Override
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getAnnotatedElements().remove(getOldTarget());
		getOldSource().getAnnotatedElements().add(getNewTarget());
		if(getOldTarget() instanceof MessageEnd) {
			MessageEndHelper.removeConnectionSourceFromMessageEnd((MessageEnd)getOldTarget(), getOldSource());
		}
		if(getNewTarget() instanceof MessageEnd) {
			MessageEndHelper.addConnectionSourceToMessageEnd((MessageEnd)getNewTarget(), getOldSource());
		}
		return CommandResult.newOKCommandResult(getOldSource());
	}
}
