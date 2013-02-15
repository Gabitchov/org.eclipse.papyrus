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

public class RowReorderCommandHandler extends AbstractLayerCommandHandler<RowReorderCommand> {

	private final RowReorderLayer columnReorderLayer;

	public RowReorderCommandHandler(RowReorderLayer columnReorderLayer) {
		this.columnReorderLayer = columnReorderLayer;
	}

	@Override
	public Class<RowReorderCommand> getCommandClass() {
		return RowReorderCommand.class;
	}

	@Override
	protected boolean doCommand(RowReorderCommand command) {
		int fromColumnPosition = command.getFromRowPosition();
		int toColumnPosition = command.getToRowPosition();
		boolean reorderToLeftEdge = command.isReorderToLeftEdge();

		this.columnReorderLayer.reorderRowPosition(fromColumnPosition, toColumnPosition, reorderToLeftEdge);

		return true;
	}

}
