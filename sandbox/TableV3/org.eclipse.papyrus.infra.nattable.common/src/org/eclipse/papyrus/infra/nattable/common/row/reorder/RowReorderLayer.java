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
package org.eclipse.papyrus.infra.nattable.common.row.reorder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.eclipse.nebula.widgets.nattable.coordinate.PositionUtil;
import org.eclipse.nebula.widgets.nattable.coordinate.Range;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.IUniqueIndexLayer;
import org.eclipse.nebula.widgets.nattable.layer.LayerUtil;
import org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent;
import org.eclipse.nebula.widgets.nattable.layer.event.IStructuralChangeEvent;
import org.eclipse.nebula.widgets.nattable.layer.event.RowStructuralRefreshEvent;
import org.eclipse.nebula.widgets.nattable.layer.event.StructuralDiff;


public class RowReorderLayer extends AbstractLayerTransform implements IUniqueIndexLayer {

	public static final String PERSISTENCE_KEY_COLUMN_INDEX_ORDER = ".rowIndexOrder"; //$NON-NLS-1$

	private final IUniqueIndexLayer underlyingLayer;

	// Position X in the List contains the index of column at position X
	private final List<Integer> rowIndexOrder = new ArrayList<Integer>();

	private final Map<Integer, Integer> startYCache = new HashMap<Integer, Integer>();

	private int reorderFromRowPosition;

	public RowReorderLayer(IUniqueIndexLayer underlyingLayer) {
		this(underlyingLayer, true);
	}

	public RowReorderLayer(IUniqueIndexLayer underlyingLayer, boolean useDefaultConfiguration) {
		super(underlyingLayer);
		this.underlyingLayer = underlyingLayer;

		populateIndexOrder();

		registerCommandHandlers();

		if(useDefaultConfiguration) {
			addConfiguration(new DefaultRowReorderLayerConfiguration());
		}
	}

	@Override
	public void handleLayerEvent(ILayerEvent event) {
		if(event instanceof IStructuralChangeEvent) {
			IStructuralChangeEvent structuralChangeEvent = (IStructuralChangeEvent)event;
			if(structuralChangeEvent.isHorizontalStructureChanged()) {
				Collection<StructuralDiff> structuralDiffs = structuralChangeEvent.getColumnDiffs();
				if(structuralDiffs == null) {
					// Assume everything changed
					this.rowIndexOrder.clear();
					populateIndexOrder();
				} else {
					for(StructuralDiff structuralDiff : structuralDiffs) {
						switch(structuralDiff.getDiffType()) {
						case ADD:
							this.rowIndexOrder.clear();
							populateIndexOrder();
							break;
						case DELETE:
							this.rowIndexOrder.clear();
							populateIndexOrder();
							break;
						}
					}
				}
				invalidateCache();
			}
		}
		super.handleLayerEvent(event);
	}

	// Configuration

	@Override
	protected void registerCommandHandlers() {
		registerCommandHandler(new RowReorderCommandHandler(this));
		registerCommandHandler(new RowReorderStartCommandHandler(this));
		registerCommandHandler(new RowReorderEndCommandHandler(this));
		registerCommandHandler(new MultiRowReorderCommandHandler(this));
	}

	// Persistence

	@Override
	public void saveState(String prefix, Properties properties) {
		super.saveState(prefix, properties);
		if(this.rowIndexOrder.size() > 0) {
			StringBuilder strBuilder = new StringBuilder();
			for(Integer index : this.rowIndexOrder) {
				strBuilder.append(index);
				strBuilder.append(',');
			}
			properties.setProperty(prefix + PERSISTENCE_KEY_COLUMN_INDEX_ORDER, strBuilder.toString());
		}
	}

	@Override
	public void loadState(String prefix, Properties properties) {
		super.loadState(prefix, properties);
		String property = properties.getProperty(prefix + PERSISTENCE_KEY_COLUMN_INDEX_ORDER);

		if(property != null) {
			List<Integer> newRowIndexOrder = new ArrayList<Integer>();
			StringTokenizer tok = new StringTokenizer(property, ","); //$NON-NLS-1$
			while(tok.hasMoreTokens()) {
				String index = tok.nextToken();
				newRowIndexOrder.add(Integer.valueOf(index));
			}

			if(isRestoredStateValid(newRowIndexOrder)) {
				this.rowIndexOrder.clear();
				this.rowIndexOrder.addAll(newRowIndexOrder);
			}
		}
		fireLayerEvent(new RowStructuralRefreshEvent(this));
	}

	/**
	 * Ensure that columns haven't changed in the underlying data source
	 *
	 * @param newRowIndexOrder
	 *        restored from the properties file.
	 */
	protected boolean isRestoredStateValid(List<Integer> newRowIndexOrder) {
		if(newRowIndexOrder.size() != getColumnCount()) {
			System.err.println("Number of persisted row (" + newRowIndexOrder.size() + ") " + //$NON-NLS-1$ //$NON-NLS-2$
			"is not the same as the number of rows in the data source (" + getColumnCount() + ").\n" + //$NON-NLS-1$ //$NON-NLS-2$
			"Skipping restore of row ordering"); //$NON-NLS-1$
			return false;
		}

		for(Integer index : newRowIndexOrder) {
			if(!this.rowIndexOrder.contains(index)) {
				System.err.println("Row index: " + index + " being restored, is not a available in the data soure.\n" + //$NON-NLS-1$ //$NON-NLS-2$
				"Skipping restore of row ordering"); //$NON-NLS-1$
				return false;
			}
		}
		return true;
	}

	// Columns

	public List<Integer> getRowIndexOrder() {
		return this.rowIndexOrder;
	}


	//DONE
	@Override
	public int getRowIndexByPosition(int rowPosition) {
		if(rowPosition >= 0 && rowPosition < this.rowIndexOrder.size()) {
			return this.rowIndexOrder.get(rowPosition).intValue();
		} else {
			return -1;
		}
	}

	//DONE
	@Override
	public int getColumnPositionByIndex(int columnIndex) {
		return this.underlyingLayer.getColumnPositionByIndex(columnIndex);
	}

	@Override
	public int localToUnderlyingRowPosition(int localRowPosition) {
		int rowIndex = getColumnIndexByPosition(localRowPosition);
		return this.underlyingLayer.getColumnPositionByIndex(rowIndex);
	}

	//	@Override
	//	public int localToUnderlyingColumnPosition(int localColumnPosition) {
	//		int columnIndex = getColumnIndexByPosition(localColumnPosition);
	//		return this.underlyingLayer.getColumnPositionByIndex(columnIndex);
	//	}

	@Override
	public int underlyingToLocalRowPosition(ILayer sourceUnderlyingLayer, int underlyingRowPosition) {
		int rowIndex = this.underlyingLayer.getColumnIndexByPosition(underlyingRowPosition);
		return getColumnPositionByIndex(rowIndex);
	}

	//	@Override
	//	public int underlyingToLocalColumnPosition(ILayer sourceUnderlyingLayer, int underlyingColumnPosition) {
	//		int columnIndex = this.underlyingLayer.getColumnIndexByPosition(underlyingColumnPosition);
	//		return getColumnPositionByIndex(columnIndex);
	//	}

	@Override
	public Collection<Range> underlyingToLocalRowPositions(ILayer sourceUnderlyingLayer, Collection<Range> underlyingRowPositionRanges) {
		List<Integer> reorderedRowPositions = new ArrayList<Integer>();
		for(Range underlyingRowPositionRange : underlyingRowPositionRanges) {
			for(int underlyingRowPosition = underlyingRowPositionRange.start; underlyingRowPosition < underlyingRowPositionRange.end; underlyingRowPosition++) {
				int localColumnPosition = underlyingToLocalColumnPosition(sourceUnderlyingLayer, underlyingRowPositionRange.start);
				reorderedRowPositions.add(Integer.valueOf(localColumnPosition));
			}
		}
		Collections.sort(reorderedRowPositions);

		return PositionUtil.getRanges(reorderedRowPositions);
	}

	//	@Override
	//	public Collection<Range> underlyingToLocalColumnPositions(ILayer sourceUnderlyingLayer, Collection<Range> underlyingColumnPositionRanges) {
	//		List<Integer> reorderedColumnPositions = new ArrayList<Integer>();
	//		for(Range underlyingColumnPositionRange : underlyingColumnPositionRanges) {
	//			for(int underlyingColumnPosition = underlyingColumnPositionRange.start; underlyingColumnPosition < underlyingColumnPositionRange.end; underlyingColumnPosition++) {
	//				int localColumnPosition = underlyingToLocalColumnPosition(sourceUnderlyingLayer, underlyingColumnPositionRange.start);
	//				reorderedColumnPositions.add(Integer.valueOf(localColumnPosition));
	//			}
	//		}
	//		Collections.sort(reorderedColumnPositions);
	//
	//		return PositionUtil.getRanges(reorderedColumnPositions);
	//	}

	// X
	@Override
	public int getRowPositionByY(int y) {
		return LayerUtil.getRowPositionByY(this, y);
	}

	//	@Override
	//	public int getColumnPositionByX(int x) {
	//		return LayerUtil.getColumnPositionByX(this, x);
	//	}


	@Override
	public int getStartYOfRowPosition(int targetRowPosition) {
		Integer cachedStartX = this.startYCache.get(Integer.valueOf(targetRowPosition));
		if(cachedStartX != null) {
			return cachedStartX.intValue();
		}

		int aggregateWidth = 0;
		for(int rowPosition = 0; rowPosition < targetRowPosition; rowPosition++) {
			aggregateWidth += this.underlyingLayer.getRowHeightByPosition(localToUnderlyingRowPosition(rowPosition));
		}

		this.startYCache.put(Integer.valueOf(targetRowPosition), Integer.valueOf(aggregateWidth));
		return aggregateWidth;
	}

	//	@Override
	//	public int getStartXOfColumnPosition(int targetColumnPosition) {
	//		Integer cachedStartX = this.startXCache.get(Integer.valueOf(targetColumnPosition));
	//		if(cachedStartX != null) {
	//			return cachedStartX.intValue();
	//		}
	//
	//		int aggregateWidth = 0;
	//		for(int columnPosition = 0; columnPosition < targetColumnPosition; columnPosition++) {
	//			aggregateWidth += this.underlyingLayer.getColumnWidthByPosition(localToUnderlyingColumnPosition(columnPosition));
	//		}
	//
	//		this.startXCache.put(Integer.valueOf(targetColumnPosition), Integer.valueOf(aggregateWidth));
	//		return aggregateWidth;
	//	}

	private void populateIndexOrder() {
		ILayer underlyingLayer = getUnderlyingLayer();
		for(int rowPosition = 0; rowPosition < underlyingLayer.getRowCount(); rowPosition++) {
			this.rowIndexOrder.add(Integer.valueOf(underlyingLayer.getRowIndexByPosition(rowPosition)));
		}
	}


	// Vertical features

	// Rows

	//DONE
	@Override
	public int getRowPositionByIndex(int rowIndex) {
		return this.rowIndexOrder.indexOf(Integer.valueOf(rowIndex));
	}

	/**
	 * Moves the column to the <i>LEFT</i> of the toColumnPosition
	 *
	 * @param fromRowPosition
	 *        column position to move
	 * @param toRowPosition
	 *        position to move the column to
	 */
	private void moveRow(int fromRowPosition, int toRowPosition, boolean reorderToLeftEdge) {//FIXME : must rename the last arg
		if(!reorderToLeftEdge) {
			toRowPosition++;
		}

		Integer fromRowIndex = this.rowIndexOrder.get(fromRowPosition);
		this.rowIndexOrder.add(toRowPosition, fromRowIndex);

		this.rowIndexOrder.remove(fromRowPosition + (fromRowPosition > toRowPosition ? 1 : 0));
		invalidateCache();
	}

	public void reorderRowPosition(int fromRowPosition, int toRowPositionPosition) {
		boolean reorderToLeftEdge; //FIXME : rename it
		if(toRowPositionPosition < getColumnCount()) {
			reorderToLeftEdge = true;
		} else {
			reorderToLeftEdge = false;
			toRowPositionPosition--;
		}
		reorderRowPosition(fromRowPosition, toRowPositionPosition, reorderToLeftEdge);
	}

	public void reorderRowPosition(int fromRowPosition, int toRowPosition, boolean reorderToLeftEdge) {
		moveRow(fromRowPosition, toRowPosition, reorderToLeftEdge);
		fireLayerEvent(new RowReorderEvent(this, fromRowPosition, toRowPosition, reorderToLeftEdge));
	}

	public void reorderMultipleRowPositions(List<Integer> fromRowPositions, int toRowPosition) {
		boolean reorderToLeftEdge;
		if(toRowPosition < getColumnCount()) {
			reorderToLeftEdge = true;
		} else {
			reorderToLeftEdge = false;
			toRowPosition--;
		}
		reorderMultipleRowPositions(fromRowPositions, toRowPosition, reorderToLeftEdge);
	}

	public void reorderMultipleRowPositions(List<Integer> fromRowPositions, int toRowPosition, boolean reorderToLeftEdge) {
		// Moving from left to right
		final int fromColumnPositionsCount = fromRowPositions.size();

		if(toRowPosition > fromRowPositions.get(fromColumnPositionsCount - 1).intValue()) {
			int firstColumnPosition = fromRowPositions.get(0).intValue();

			for(int columnCount = 0; columnCount < fromColumnPositionsCount; columnCount++) {
				final int fromColumnPosition = fromRowPositions.get(0).intValue();
				moveRow(fromColumnPosition, toRowPosition, reorderToLeftEdge);
				if(fromColumnPosition < firstColumnPosition) {
					firstColumnPosition = fromColumnPosition;
				}
			}
		} else if(toRowPosition < fromRowPositions.get(fromColumnPositionsCount - 1).intValue()) {
			// Moving from right to left
			int targetColumnPosition = toRowPosition;
			for(Integer fromColumnPosition : fromRowPositions) {
				final int fromColumnPositionInt = fromColumnPosition.intValue();
				moveRow(fromColumnPositionInt, targetColumnPosition++, reorderToLeftEdge);
			}
		}

		fireLayerEvent(new RowReorderEvent(this, fromRowPositions, toRowPosition, reorderToLeftEdge));
	}

	private void invalidateCache() {
		this.startYCache.clear();
	}

	public int getReorderFromRowPosition() {
		return this.reorderFromRowPosition;
	}

	public void setReorderFromRowPosition(int fromRowPosition) {
		this.reorderFromRowPosition = fromRowPosition;
	}

}
