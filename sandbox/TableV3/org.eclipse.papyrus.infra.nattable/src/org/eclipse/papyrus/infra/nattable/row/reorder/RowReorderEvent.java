/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.row.reorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.nebula.widgets.nattable.coordinate.PositionUtil;
import org.eclipse.nebula.widgets.nattable.coordinate.Range;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.event.RowStructuralChangeEvent;
import org.eclipse.nebula.widgets.nattable.layer.event.StructuralDiff;
import org.eclipse.nebula.widgets.nattable.layer.event.StructuralDiff.DiffTypeEnum;


public class RowReorderEvent extends RowStructuralChangeEvent {

	private Collection<Range> beforeFromColumnPositionRanges;

	private int beforeToRowPosition;

	private boolean reorderToLeftEdge;

	public RowReorderEvent(ILayer layer, int beforeFromColumnPosition, int beforeToColumnPosition, boolean reorderToLeftEdge) {
		this(layer, Arrays.asList(new Integer[]{ Integer.valueOf(beforeFromColumnPosition) }), beforeToColumnPosition, reorderToLeftEdge);
	}

	public RowReorderEvent(ILayer layer, List<Integer> beforeFromColumnPositions, int beforeToColumnPosition, boolean reorderToLeftEdge) {
		super(layer);
		this.beforeFromColumnPositionRanges = PositionUtil.getRanges(beforeFromColumnPositions);
		this.reorderToLeftEdge = reorderToLeftEdge;
		if(!reorderToLeftEdge) {
			beforeToColumnPosition--;
		}
		this.beforeToRowPosition = beforeToColumnPosition;

		List<Integer> allColumnPositions = new ArrayList<Integer>(beforeFromColumnPositions);
		allColumnPositions.add(Integer.valueOf(beforeToColumnPosition));
		//setColumnPositionRanges(PositionUtil.getRanges(allColumnPositions));
		//FIXME : I change nattable code for that!
		this.rowPositionRanges = PositionUtil.getRanges(allColumnPositions);
	}

	public RowReorderEvent(RowReorderEvent event) {
		super(event);
		this.beforeFromColumnPositionRanges = event.beforeFromColumnPositionRanges;
		this.beforeToRowPosition = event.beforeToRowPosition;
		this.reorderToLeftEdge = event.reorderToLeftEdge;
	}

	public Collection<Range> getBeforeFromRowPositionRanges() {
		return this.beforeFromColumnPositionRanges;
	}

	public int getBeforeToColumnPosition() {
		return this.beforeToRowPosition;
	}

	public boolean isReorderToLeftEdge() {
		return this.reorderToLeftEdge;
	}

	@Override
	public Collection<StructuralDiff> getColumnDiffs() {
		Collection<StructuralDiff> columnDiffs = new ArrayList<StructuralDiff>();

		Collection<Range> beforeFromColumnPositionRanges = getBeforeFromRowPositionRanges();

		int afterAddColumnPosition = this.beforeToRowPosition;
		for(Range beforeFromColumnPositionRange : beforeFromColumnPositionRanges) {
			if(beforeFromColumnPositionRange.start < this.beforeToRowPosition) {
				afterAddColumnPosition -= Math.min(beforeFromColumnPositionRange.end, this.beforeToRowPosition) - beforeFromColumnPositionRange.start;
			} else {
				break;
			}
		}
		int cumulativeAddSize = 0;
		for(Range beforeFromColumnPositionRange : beforeFromColumnPositionRanges) {
			cumulativeAddSize += beforeFromColumnPositionRange.size();
		}

		int offset = 0;
		for(Range beforeFromColumnPositionRange : beforeFromColumnPositionRanges) {
			int afterDeleteColumnPosition = beforeFromColumnPositionRange.start - offset;
			if(afterAddColumnPosition < afterDeleteColumnPosition) {
				afterDeleteColumnPosition += cumulativeAddSize;
			}
			columnDiffs.add(new StructuralDiff(DiffTypeEnum.DELETE, beforeFromColumnPositionRange, new Range(afterDeleteColumnPosition, afterDeleteColumnPosition)));
			offset += beforeFromColumnPositionRange.size();
		}
		Range beforeAddRange = new Range(this.beforeToRowPosition, this.beforeToRowPosition);
		offset = 0;
		for(Range beforeFromColumnPositionRange : beforeFromColumnPositionRanges) {
			int size = beforeFromColumnPositionRange.size();
			columnDiffs.add(new StructuralDiff(DiffTypeEnum.ADD, beforeAddRange, new Range(afterAddColumnPosition + offset, afterAddColumnPosition + offset + size)));
			offset += size;
		}

		return columnDiffs;
	}

	@Override
	public boolean convertToLocal(ILayer targetLayer) {
		this.beforeFromColumnPositionRanges = targetLayer.underlyingToLocalColumnPositions(getLayer(), this.beforeFromColumnPositionRanges);
		this.beforeToRowPosition = targetLayer.underlyingToLocalColumnPosition(getLayer(), this.beforeToRowPosition);

		if(this.beforeToRowPosition >= 0) {
			return super.convertToLocal(targetLayer);
		} else {
			return false;
		}
	}

	@Override
	public RowReorderEvent cloneEvent() {
		return new RowReorderEvent(this);
	}

	@Override
	public Collection<StructuralDiff> getRowDiffs() {
		Collection<StructuralDiff> rowsDiff = new ArrayList<StructuralDiff>();

		Collection<Range> beforeFromRowPositionRanges = getBeforeFromRowPositionRanges();

		int afterAddRowPosition = this.beforeToRowPosition;
		for(Range beforeFromRowPositionRange : beforeFromRowPositionRanges) {
			if(beforeFromRowPositionRange.start < this.beforeToRowPosition) {
				afterAddRowPosition -= Math.min(beforeFromRowPositionRange.end, this.beforeToRowPosition) - beforeFromRowPositionRange.start;
			} else {
				break;
			}
		}
		int cumulativeAddSize = 0;
		for(Range beforeFromRowPositionRange : beforeFromRowPositionRanges) {
			cumulativeAddSize += beforeFromRowPositionRange.size();
		}

		int offset = 0;
		for(Range beforeFromRowPositionRange : beforeFromRowPositionRanges) {
			int afterDeleteRowPosition = beforeFromRowPositionRange.start - offset;
			if(afterAddRowPosition < afterDeleteRowPosition) {
				afterDeleteRowPosition += cumulativeAddSize;
			}
			rowsDiff.add(new StructuralDiff(DiffTypeEnum.DELETE, beforeFromRowPositionRange, new Range(afterDeleteRowPosition, afterDeleteRowPosition)));
			offset += beforeFromRowPositionRange.size();
		}
		Range beforeAddRange = new Range(this.beforeToRowPosition, this.beforeToRowPosition);
		offset = 0;
		for(Range beforeFromRowPositionRange : beforeFromRowPositionRanges) {
			int size = beforeFromRowPositionRange.size();
			rowsDiff.add(new StructuralDiff(DiffTypeEnum.ADD, beforeAddRange, new Range(afterAddRowPosition + offset, afterAddRowPosition + offset + size)));
			offset += size;
		}

		return rowsDiff;
	}
}
