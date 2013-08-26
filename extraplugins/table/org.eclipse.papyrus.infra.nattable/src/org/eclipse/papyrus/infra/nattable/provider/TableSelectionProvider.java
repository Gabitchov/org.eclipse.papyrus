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
import org.eclipse.nebula.widgets.nattable.selection.event.ISelectionEvent;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;
import org.eclipse.ui.services.IDisposable;


public class TableSelectionProvider implements ISelectionProvider, IDisposable {

	private SelectionLayer selectionLayer;

	private final ILayerListener selectionListener;

	private ISelection currentSelection;

	private final List<ISelectionChangedListener> listeners;

	public TableSelectionProvider(final SelectionLayer selectionLayer) {
		this.selectionLayer = selectionLayer;
		this.selectionListener = new ILayerListener() {

			public void handleLayerEvent(final ILayerEvent event) {
				calculateAndStoreNewSelection(event);
			}
		};
		this.selectionLayer.addLayerListener(this.selectionListener);
		this.currentSelection = new StructuredSelection();
		this.listeners = new ArrayList<ISelectionChangedListener>();
	}


	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		this.listeners.add(listener);

	}

	public synchronized ISelection getSelection() {
		return this.currentSelection;
	}

	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		this.listeners.remove(listener);
	}

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

		if(event instanceof ISelectionEvent) {
			//add the cell selection
			final Collection<PositionCoordinate> selectedCells = Arrays.asList(this.selectionLayer.getSelectedCellPositions());
			final TableSelectionWrapper wrapper = new TableSelectionWrapper(selectedCells);
			selection.add(0, wrapper);

			//we returns the contents of the last selected cell
			//we could returns the contents of all selected cells if its required
			if(event instanceof CellSelectionEvent) {
				final CellSelectionEvent e = (CellSelectionEvent)event;
				final int colPos = e.getColumnPosition();
				final int rowPos = e.getRowPosition();
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
		}
		setSelection(new StructuredSelection(selection));
	}

	public void dispose() {
		this.selectionLayer.removeLayerListener(this.selectionListener);
		this.selectionLayer = null;
	}
}
