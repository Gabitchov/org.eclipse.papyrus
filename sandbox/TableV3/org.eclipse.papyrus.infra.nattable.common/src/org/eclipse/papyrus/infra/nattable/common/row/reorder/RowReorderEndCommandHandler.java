/*******************************************************************************
 * Copyright (c) 2012 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.row.reorder;

import org.eclipse.nebula.widgets.nattable.command.AbstractLayerCommandHandler;

public class RowReorderEndCommandHandler extends AbstractLayerCommandHandler<RowReorderEndCommand> {

	private final RowReorderLayer columnReorderLayer;

	public RowReorderEndCommandHandler(RowReorderLayer columnReorderLayer) {
		this.columnReorderLayer = columnReorderLayer;
	}

	@Override
	public Class<RowReorderEndCommand> getCommandClass() {
		return RowReorderEndCommand.class;
	}

	@Override
	protected boolean doCommand(RowReorderEndCommand command) {
		int toColumnPosition = command.getToRowPosition();
		boolean reorderToLeftEdge = command.isReorderToLeftEdge();

		this.columnReorderLayer.reorderRowPosition(this.columnReorderLayer.getReorderFromRowPosition(), toColumnPosition, reorderToLeftEdge);

		return true;
	}

}
