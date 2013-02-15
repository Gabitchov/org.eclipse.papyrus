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

public class RowReorderStartCommandHandler extends AbstractLayerCommandHandler<RowReorderStartCommand> {

	private final RowReorderLayer columnReorderLayer;

	public RowReorderStartCommandHandler(RowReorderLayer columnReorderLayer) {
		this.columnReorderLayer = columnReorderLayer;
	}

	@Override
	public Class<RowReorderStartCommand> getCommandClass() {
		return RowReorderStartCommand.class;
	}

	@Override
	protected boolean doCommand(RowReorderStartCommand command) {
		int fromColumnPosition = command.getFromRowPosition();

		this.columnReorderLayer.setReorderFromRowPosition(fromColumnPosition);

		return true;
	}

}
