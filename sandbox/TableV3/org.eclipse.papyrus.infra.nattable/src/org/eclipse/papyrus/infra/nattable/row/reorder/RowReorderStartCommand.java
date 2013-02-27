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
package org.eclipse.papyrus.infra.nattable.row.reorder;

import org.eclipse.nebula.widgets.nattable.command.ILayerCommand;
import org.eclipse.nebula.widgets.nattable.command.LayerCommandUtil;
import org.eclipse.nebula.widgets.nattable.coordinate.RowPositionCoordinate;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;

public class RowReorderStartCommand implements ILayerCommand {

	private RowPositionCoordinate fromRowPositionCoordinate;

	public RowReorderStartCommand(ILayer layer, int fromColumnPosition) {
		this.fromRowPositionCoordinate = new RowPositionCoordinate(layer, fromColumnPosition);
	}

	protected RowReorderStartCommand(RowReorderStartCommand command) {
		this.fromRowPositionCoordinate = command.fromRowPositionCoordinate;
	}

	public int getFromRowPosition() {
		return this.fromRowPositionCoordinate.getRowPosition();
	}

	@Override
	public boolean convertToTargetLayer(ILayer targetLayer) {
		RowPositionCoordinate targetFromRowPositionCoordinate = LayerCommandUtil.convertRowPositionToTargetContext(this.fromRowPositionCoordinate, targetLayer);
		if(targetFromRowPositionCoordinate != null) {
			this.fromRowPositionCoordinate = targetFromRowPositionCoordinate;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public RowReorderStartCommand cloneCommand() {
		return new RowReorderStartCommand(this);
	}

}
