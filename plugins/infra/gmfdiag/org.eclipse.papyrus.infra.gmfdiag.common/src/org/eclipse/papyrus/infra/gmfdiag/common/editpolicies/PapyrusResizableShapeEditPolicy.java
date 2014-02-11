/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

/**
 *
 * See Bug 424943 ResizableEditPolicy#getResizeCommand duplicates request ignoring some request values
 * TODO : remove this class when the bug will be fixed
 */
public class PapyrusResizableShapeEditPolicy extends ResizableShapeEditPolicy {

	/**
	 * Returns the command contribution for the given resize request. By
	 * default, the request is re-dispatched to the host's parent as a {@link org.eclipse.gef.RequestConstants#REQ_RESIZE_CHILDREN}. The
	 * parent's edit policies determine how to perform the resize based on the
	 * layout manager in use.
	 *
	 * @param request
	 *        the resize request
	 * @return the command contribution obtained from the parent
	 */
	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_RESIZE_CHILDREN);
		req.setCenteredResize(request.isCenteredResize());
		req.setConstrainedMove(request.isConstrainedMove());
		req.setConstrainedResize(request.isConstrainedResize());
		req.setSnapToEnabled(request.isSnapToEnabled());
		req.setEditParts(getHost());

		req.setMoveDelta(request.getMoveDelta());
		req.setSizeDelta(request.getSizeDelta());
		req.setLocation(request.getLocation());
		req.setExtendedData(request.getExtendedData());
		req.setResizeDirection(request.getResizeDirection());

		if(getHost().getParent() == null) {
			return null;
		}

		return getHost().getParent().getCommand(req);
	}

}
