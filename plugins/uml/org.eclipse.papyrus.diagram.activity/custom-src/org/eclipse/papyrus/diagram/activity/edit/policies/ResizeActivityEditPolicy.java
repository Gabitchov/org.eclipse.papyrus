/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

/**
 * This editPolicy prevent from moving the activity and preserve the -1,-1 size for the activity. This way, the activity is automatically resized to
 * the optimal size, being enlarged when an element is drag out of it and taking the default large size otherwise.
 */
public class ResizeActivityEditPolicy extends ResizableShapeEditPolicy {

	/**
	 * Disable moving the activity.
	 * 
	 * @param request
	 *        request to change location
	 * @return UnexecutableCommand.INSTANCE
	 */
	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * Disable resizing manually the activity.
	 * 
	 * @param request
	 *        request to change size
	 * @return UnexecutableCommand.INSTANCE
	 */
	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		return UnexecutableCommand.INSTANCE;
	}
}
