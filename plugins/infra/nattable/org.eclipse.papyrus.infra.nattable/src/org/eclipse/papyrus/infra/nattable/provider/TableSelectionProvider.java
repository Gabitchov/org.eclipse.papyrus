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
package org.eclipse.papyrus.infra.nattable.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.widgets.nattable.coordinate.PositionCoordinate;
import org.eclipse.nebula.widgets.nattable.layer.ILayerListener;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.event.CellSelectionEvent;
import org.eclipse.nebula.widgets.nattable.selection.event.ColumnSelectionEvent;
import org.eclipse.nebula.widgets.nattable.selection.event.ISelectionEvent;
import org.eclipse.nebula.widgets.nattable.selection.event.RowSelectionEvent;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;
import org.eclipse.ui.services.IDisposable;

/**
 * 
 * The selection provider used by the table. The returned selection is used to display property views or to do the synchronization in the
 * ModelExplorer
 * 
 */
public class TableSelectionProvider implements ISelectionProvider, IDisposable {

	/**
	 * the selection layer used in the table
	 */
	private SelectionLayer selectionLayer;

	/**
	 * the selection listener
	 */
	private final ILayerListener selectionListener;

	/**
	 * the current selection in the table
	 */
	private ISelection currentSelection;

	/**
	 * the list of listener on the selections
	 */
	private final List<ISelectionChangedListener> listeners;

	/**
	 * the table model manager to use to find selected elements
	 */
	private INattableModelManager manager;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 *        the table model manager to use to find selected elements
	 * @param selectionLayer
	 */
	public TableSelectionProvider(final INattableModelManager manager, final SelectionLayer selectionLayer) {
		this.selectionLayer = selectionLayer;
		this.selectionListener = new ILayerListener() {

			public void handleLayerEvent(final ILayerEvent event) {
				calculateAndStoreNewSelection(event);
			}
		};
		this.selectionLayer.addLayerListener(this.selectionListener);
		this.currentSelection = new StructuredSelection();
		this.listeners = new ArrayList<ISelectionChangedListener>();
		this.manager = manager;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 * 
	 * @param listener
	 */
	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 * 
	 * @return
	 */
	public synchronized ISelection getSelection() {
		return this.currentSelection;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 * 
	 * @param listener
	 */
	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param selection
	 */
	public synchronized void setSelection(final ISelection selection) {
		if(this.currentSelection.equals(selection)) {
			return;
		}
		this.currentSelection = selection;
		final SelectionChangedEvent event = new SelectionChangedEvent(this, this.currentSelection);
		for(final ISelectionChangedListener current : this.listeners) {
			current.selectionChanged(event);
		}
	}

	protected/* synchronized */void calculateAndStoreNewSelection(final ILayerEvent event) {
		//the list of the selected elements
		final List<Object> selection = new ArrayList<Object>();
		final ISelection newSelection;
		if(event instanceof ISelectionEvent) {
			//add the cell selection
			final Collection<PositionCoordinate> selectedCells = Arrays.asList(this.selectionLayer.getSelectedCellPositions());
			final TableSelectionWrapper wrapper = new TableSelectionWrapper(selectedCells);

			//we returns the contents of the last selected cell
			//we could returns the contents of all selected cells if its required
			if(event instanceof CellSelectionEvent) {
				for(final PositionCoordinate current1 : this.selectionLayer.getSelectedCellPositions()) {
					final int colPos = current1.getColumnPosition();
					final int rowPos = current1.getRowPosition();
					final ILayerCell cell = this.selectionLayer.getCellByPosition(colPos, rowPos);
					if(cell != null) {
						final Object value = cell.getDataValue();
						if(value != null) {
							if(value instanceof Collection<?>) {
								final Iterator<?> iter = ((Collection<?>)value).iterator();
								while(iter.hasNext()) {
									final Object current = iter.next();
									selection.add(current);
								}
							} else {
								selection.add(value);
							}
						}
					}
				}

			} else if(event instanceof RowSelectionEvent) {
				this.selectionLayer.getFullySelectedRowPositions();
				int[] rows = this.selectionLayer.getFullySelectedRowPositions();
				for(int i : rows) {
					Object el = this.manager.getRowElement(i);
					if(el != null) {
						el = AxisUtils.getRepresentedElement(el);
						selection.add(el);
					}
				}

			} else if(event instanceof ColumnSelectionEvent) {
				int[] selectedColumn = this.selectionLayer.getFullySelectedColumnPositions();
				for(int i : selectedColumn) {
					Object el = this.manager.getColumnElement(i);
					if(el != null) {
						el = AxisUtils.getRepresentedElement(el);
						selection.add(el);
					}
				}
			}
			newSelection = new TableStructuredSelection(selection, wrapper);
		} else {
			newSelection = new StructuredSelection();
		}
		setSelection(newSelection);
	}



	/**
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 * 
	 */
	public void dispose() {
		this.selectionLayer.removeLayerListener(this.selectionListener);
		this.selectionLayer = null;
	}
}
