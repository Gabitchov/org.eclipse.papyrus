/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.view.content;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;


/**
 * Descriptor for GridLayout
 */
public class GridLayoutDescriptor extends LayoutDescriptor {

	/** number of columns for the layout */
	private final int numColumns;

	/** equal columns width */
	private final boolean sameWidth;

	/**
	 * Creates a new GridLayoutDescriptor.
	 * 
	 * @param numColumns
	 *        the number of columns for the grid layout
	 * @param sameWidth
	 *        boolean <code>true</code> when columns in the layout should have the same width
	 */
	public GridLayoutDescriptor(int numColumns, boolean sameWidth) {
		this.numColumns = numColumns;
		this.sameWidth = sameWidth;
	}

	/**
	 * Creates a new GridLayoutDescriptor with default values
	 */
	public GridLayoutDescriptor() {
		this.numColumns = 2;
		this.sameWidth = true;
	}


	/**
	 * Returns the number of columns
	 * 
	 * @return the number of columns
	 */
	public int getNumColumns() {
		return numColumns;
	}


	/**
	 * Returns <code>true</code> if the columns in the layout should have the same size
	 * 
	 * @return <code>true</code> if the columns in the layout should have the same size
	 */
	public boolean isSameWidth() {
		return sameWidth;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "GridLayout (" + numColumns + ", " + sameWidth + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/GridLayout.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GridLayout createLayout() {
		return new GridLayout(numColumns, sameWidth);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GridLayoutDescriptorState createState(boolean readOnly) {
		return new GridLayoutDescriptorState(this, readOnly);
	}

}
