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

import java.util.List;

import org.eclipse.nebula.widgets.nattable.command.AbstractLayerCommandHandler;


public class MultiRowReorderCommandHandler extends AbstractLayerCommandHandler<MultiRowReorderCommand> {

	private final RowReorderLayer columnReorderLayer;

	public MultiRowReorderCommandHandler(RowReorderLayer columnReorderLayer) {
		this.columnReorderLayer = columnReorderLayer;
	}

	@Override
	public Class<MultiRowReorderCommand> getCommandClass() {
		return MultiRowReorderCommand.class;
	}

	@Override
	protected boolean doCommand(MultiRowReorderCommand command) {
		List<Integer> fromColumnPositions = command.getFromColumnPositions();
		int toColumnPosition = command.getToRowPosition();
		boolean reorderToLeftEdge = command.isReorderToLeftEdge();

		this.columnReorderLayer.reorderMultipleRowPositions(fromColumnPositions, toColumnPosition, reorderToLeftEdge);

		return true;
	}

}
