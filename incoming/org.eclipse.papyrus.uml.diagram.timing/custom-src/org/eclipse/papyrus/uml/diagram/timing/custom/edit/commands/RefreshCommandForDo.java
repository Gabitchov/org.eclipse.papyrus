/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.gef.GraphicalEditPart;

/**
 * Refresh the {@link IFigure} of a given {@link GraphicalEditPart} on execute and redo of this command. This command
 * must be placed at the end of a {@link CompoundCommand}, as the execute and redo are done in forward order.
 */
public class RefreshCommandForDo extends AbstractRefreshCommand {

	public RefreshCommandForDo(final GraphicalEditPart editPartToRefresh) {
		super(editPartToRefresh);
	}

	@Override
	public void execute() {
		refresh();
	}

	@Override
	public void redo() {
		refresh();
	}
}
