/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.parts.NoScrollNoBorderDragEditPartsTracker;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantVerticalLineEditPart;

public class CustomFullStateInvariantVerticalLineEditPart extends FullStateInvariantVerticalLineEditPart {

	public CustomFullStateInvariantVerticalLineEditPart(final View view) {
		super(view);
	}

	/**
	 * The drag tracker has been specialized in order to constrain movement inside its container without scroll bar
	 * 
	 * @see http://wiki.eclipse.org/Papyrus_Developer_Guide/NoScrollbar
	 */
	@Override
	public DragTracker getDragTracker(final Request request) {
		return new NoScrollNoBorderDragEditPartsTracker(this);
	}

	@Override
	public Command getCommand(final Request request) {
		if(request.getType() == REQ_DELETE || request.getType() == REQ_RECONNECT_TARGET) {
			// don't let the user remove vertical lines, or reconnect anything to a vertical line
			return UnexecutableCommand.INSTANCE;
		}
		return super.getCommand(request);
	}
}
