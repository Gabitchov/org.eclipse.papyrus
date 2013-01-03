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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;

/**
 * Refresh the {@link IFigure} of a given {@link GraphicalEditPart} on undo of this command. <br/>
 * <strong>This command must be created before the other ones in a CompoundCommand</strong> since the commands are
 * executed in reverse when undoing.
 */
public class RefreshCommandForUndo extends AbstractRefreshCommand {

	public RefreshCommandForUndo(final GraphicalEditPart editPartToRefresh) {
		super(editPartToRefresh);
	}

	@Override
	public void undo() {
		refresh();
	}
}
