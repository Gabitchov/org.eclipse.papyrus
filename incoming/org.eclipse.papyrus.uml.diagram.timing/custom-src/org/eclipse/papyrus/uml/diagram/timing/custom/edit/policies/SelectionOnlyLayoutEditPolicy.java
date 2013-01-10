/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy;

public class SelectionOnlyLayoutEditPolicy extends LayoutEditPolicy {

	@Override
	protected Command getMoveChildrenCommand(final Request request) {
		return null;
	}

	@Override
	protected Command getCreateCommand(final CreateRequest request) {
		return null;
	}

	@Override
	protected EditPolicy createChildEditPolicy(final EditPart child) {
		final NonResizableEditPolicy nonResizableEditPolicy = new NonResizableEditPolicy();
		nonResizableEditPolicy.setDragAllowed(false);
		return nonResizableEditPolicy;
	}
}
