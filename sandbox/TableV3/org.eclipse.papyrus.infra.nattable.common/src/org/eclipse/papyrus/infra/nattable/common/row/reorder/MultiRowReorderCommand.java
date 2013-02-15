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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.nebula.widgets.nattable.command.ILayerCommand;
import org.eclipse.nebula.widgets.nattable.command.LayerCommandUtil;
import org.eclipse.nebula.widgets.nattable.coordinate.RowPositionCoordinate;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;


public class MultiRowReorderCommand implements ILayerCommand {

	private List<RowPositionCoordinate> fromColumnPositionCoordinates;

	private RowPositionCoordinate toColumnPositionCoordinate;
	private boolean reorderToLeftEdge;

	public MultiRowReorderCommand(ILayer layer, List<Integer> fromColumnPositions, int toColumnPosition) {
		this(layer, fromColumnPositions, toColumnPosition < layer.getColumnCount() ? toColumnPosition : toColumnPosition - 1, toColumnPosition < layer.getColumnCount());
	}

	public MultiRowReorderCommand(ILayer layer, List<Integer> fromColumnPositions, int toColumnPosition, boolean reorderToLeftEdge) {
		this.fromColumnPositionCoordinates = new ArrayList<RowPositionCoordinate>();
		for (Integer fromColumnPosition : fromColumnPositions) {
			this.fromColumnPositionCoordinates.add(new RowPositionCoordinate(layer, fromColumnPosition.intValue()));
		}

		this.toColumnPositionCoordinate = new RowPositionCoordinate(layer, toColumnPosition);

		this.reorderToLeftEdge = reorderToLeftEdge;
	}

	protected MultiRowReorderCommand(MultiRowReorderCommand command) {
		this.fromColumnPositionCoordinates = new ArrayList<RowPositionCoordinate>(command.fromColumnPositionCoordinates);
		this.toColumnPositionCoordinate = command.toColumnPositionCoordinate;
		this.reorderToLeftEdge = command.reorderToLeftEdge;
	}

	public List<Integer> getFromColumnPositions() {
		List<Integer> fromColumnPositions = new ArrayList<Integer>();
		for(RowPositionCoordinate fromColumnPositionCoordinate : this.fromColumnPositionCoordinates) {
			fromColumnPositions.add(Integer.valueOf(fromColumnPositionCoordinate.getRowPosition()));
		}
		return fromColumnPositions;
	}

	public int getToRowPosition() {
		return this.toColumnPositionCoordinate.getRowPosition();
	}

	public boolean isReorderToLeftEdge() {
		return this.reorderToLeftEdge;
	}

	@Override
	public boolean convertToTargetLayer(ILayer targetLayer) {
		List<RowPositionCoordinate> convertedFromColumnPositionCoordinates = new ArrayList<RowPositionCoordinate>();

		for(RowPositionCoordinate fromColumnPositionCoordinate : this.fromColumnPositionCoordinates) {
			RowPositionCoordinate convertedFromColumnPositionCoordinate = LayerCommandUtil.convertRowPositionToTargetContext(fromColumnPositionCoordinate, targetLayer);
			if (convertedFromColumnPositionCoordinate != null) {
				convertedFromColumnPositionCoordinates.add(convertedFromColumnPositionCoordinate);
			}
		}

		RowPositionCoordinate targetToColumnPositionCoordinate = LayerCommandUtil.convertRowPositionToTargetContext(this.toColumnPositionCoordinate, targetLayer);

		if (convertedFromColumnPositionCoordinates.size() > 0 && targetToColumnPositionCoordinate != null) {
			this.fromColumnPositionCoordinates = convertedFromColumnPositionCoordinates;
			this.toColumnPositionCoordinate = targetToColumnPositionCoordinate;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public MultiRowReorderCommand cloneCommand() {
		return new MultiRowReorderCommand(this);
	}

}
