/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.utils;

import java.util.Collection;

import org.eclipse.nebula.widgets.nattable.coordinate.PositionCoordinate;

/**
 * Wrapper for the selection in the table
 * 
 * @author VL222926
 * 
 */
public class TableSelectionWrapper {

	/**
	 * the list of the coordinate of all selected cells
	 */
	final private Collection<PositionCoordinate> selectedCells;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectionCells
	 */
	public TableSelectionWrapper(final Collection<PositionCoordinate> selectionCells) {
		this.selectedCells = selectionCells;
	}


	/**
	 * 
	 * @return
	 *         the list of the {@link PositionCoordinate} of all selected cells
	 */
	public Collection<PositionCoordinate> getSelectedCells() {
		return selectedCells;
	}


}
