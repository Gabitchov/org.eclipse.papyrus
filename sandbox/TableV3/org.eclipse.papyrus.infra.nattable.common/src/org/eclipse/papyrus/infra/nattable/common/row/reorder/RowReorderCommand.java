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

import org.eclipse.nebula.widgets.nattable.command.ILayerCommand;
import org.eclipse.nebula.widgets.nattable.command.LayerCommandUtil;
import org.eclipse.nebula.widgets.nattable.coordinate.RowPositionCoordinate;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;

public class RowReorderCommand implements ILayerCommand {

	private RowPositionCoordinate fromColumnPositionCoordinate;

	private RowPositionCoordinate toColumnPositionCoordinate;
	private boolean reorderToLeftEdge;

	public RowReorderCommand(ILayer layer, int fromColumnPosition, int toColumnPosition) {
		this.fromColumnPositionCoordinate = new RowPositionCoordinate(layer, fromColumnPosition);

		if (toColumnPosition < layer.getColumnCount()) {
 			this.reorderToLeftEdge = true;
		} else {
			this.reorderToLeftEdge = false;
			toColumnPosition--;
		}

		this.toColumnPositionCoordinate = new RowPositionCoordinate(layer, toColumnPosition);
	}

	protected RowReorderCommand(RowReorderCommand command) {
		this.fromColumnPositionCoordinate = command.fromColumnPositionCoordinate;
		this.toColumnPositionCoordinate = command.toColumnPositionCoordinate;
		this.reorderToLeftEdge = command.reorderToLeftEdge;
	}

	public int getFromRowPosition() {
		return this.fromColumnPositionCoordinate.getRowPosition();
	}

	public int getToRowPosition() {
		return this.toColumnPositionCoordinate.getRowPosition();
	}

	public boolean isReorderToLeftEdge() {
		return this.reorderToLeftEdge;
	}

	@Override
	public boolean convertToTargetLayer(ILayer targetLayer) {
		RowPositionCoordinate targetFromColumnPositionCoordinate = LayerCommandUtil.convertRowPositionToTargetContext(this.fromColumnPositionCoordinate, targetLayer);
		RowPositionCoordinate targetToColumnPositionCoordinate = LayerCommandUtil.convertRowPositionToTargetContext(this.toColumnPositionCoordinate, targetLayer);
		if (targetFromColumnPositionCoordinate != null && targetToColumnPositionCoordinate != null) {
			this.fromColumnPositionCoordinate = targetFromColumnPositionCoordinate;
			this.toColumnPositionCoordinate = targetToColumnPositionCoordinate;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public RowReorderCommand cloneCommand() {
		return new RowReorderCommand(this);
	}

}
