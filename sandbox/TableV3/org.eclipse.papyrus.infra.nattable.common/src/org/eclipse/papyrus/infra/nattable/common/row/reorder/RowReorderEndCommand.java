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

public class RowReorderEndCommand implements ILayerCommand {

	private RowPositionCoordinate toRowPositionCoordinate;
	private boolean reorderToLeftEdge;

	public RowReorderEndCommand(ILayer layer, int toColumnPosition) {
		if (toColumnPosition < layer.getColumnCount()) {
 			this.reorderToLeftEdge = true;
		} else {
			this.reorderToLeftEdge = false;
			toColumnPosition--;
		}

		this.toRowPositionCoordinate = new RowPositionCoordinate(layer, toColumnPosition);
	}

	protected RowReorderEndCommand(RowReorderEndCommand command) {
		this.toRowPositionCoordinate = command.toRowPositionCoordinate;
		this.reorderToLeftEdge = command.reorderToLeftEdge;
	}

	public int getToRowPosition() {
		return this.toRowPositionCoordinate.getRowPosition();
	}

	public boolean isReorderToLeftEdge() {
		return this.reorderToLeftEdge;
	}

	@Override
	public boolean convertToTargetLayer(ILayer targetLayer) {
		RowPositionCoordinate targetToRowPositionCoordinate = LayerCommandUtil.convertRowPositionToTargetContext(this.toRowPositionCoordinate, targetLayer);
		if(targetToRowPositionCoordinate != null) {
			this.toRowPositionCoordinate = targetToRowPositionCoordinate;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public RowReorderEndCommand cloneCommand() {
		return new RowReorderEndCommand(this);
	}

}
