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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEndHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CommentAnnotatedElementItemSemanticEditPolicy;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCommentAnnotatedElementItemSemanticEditPolicy extends CommentAnnotatedElementItemSemanticEditPolicy {

	/**
	 * @Override
	 */
	@Override
	protected Command getDestroyReferenceCommand(final DestroyReferenceRequest req) {
		if(req.getReferencedObject() instanceof MessageEnd) {
			return getGEFWrapper(new DestroyReferenceCommand(req) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					CommandResult res = super.doExecuteWithResult(monitor, info);
					if(res.getStatus().isOK()) {
						MessageEndHelper.removeConnectionSourceFromMessageEnd((MessageEnd)req.getReferencedObject(), req.getContainer());
					}
					return res;
				}
			});
		}
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}
}
