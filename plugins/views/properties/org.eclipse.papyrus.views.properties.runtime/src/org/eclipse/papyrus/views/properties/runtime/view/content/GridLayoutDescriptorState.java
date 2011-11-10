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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.swt.layout.GridLayout;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * State for {@link LayoutDescriptor}
 */
public class GridLayoutDescriptorState extends LayoutDescriptorState {

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** number of columns in the layout */
	private int numColumns;

	/** indicates if the columns should have the same width */
	private boolean sameWidth;

	/**
	 * Creates a new LayoutDescriptorState.
	 * 
	 * @param layoutDescriptor
	 *        managed descriptor
	 * @param readOnly
	 *        the read only mode of the state
	 */
	public GridLayoutDescriptorState(GridLayoutDescriptor layoutDescriptor, boolean readOnly) {
		super(layoutDescriptor, readOnly);

		sameWidth = layoutDescriptor.isSameWidth();
		numColumns = layoutDescriptor.getNumColumns();

		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public GridLayoutDescriptor getDescriptor() {
		return (GridLayoutDescriptor)super.getDescriptor();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "GridLayoutDescriptorStateDialog";
	}


	/**
	 * Adds a property change listener to this class
	 * 
	 * @param listener
	 *        the listener to add
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a property change listener from this class
	 * 
	 * @param listener
	 *        the listener to remove
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * Sets the number of columns
	 * 
	 * @param numColumns
	 *        the number of columns to set
	 */
	public void setNumColumns(int numColumns) {
		changeSupport.firePropertyChange("numColumns", this.numColumns, this.numColumns = numColumns);
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
	 * Sets if the columns should have the same width
	 * 
	 * @param sameWidth
	 *        <code>true</code> if columns should have the same width
	 */
	public void setSameWidth(boolean sameWidth) {
		changeSupport.firePropertyChange("sameWidth", this.sameWidth, this.sameWidth = sameWidth);
	}

	/**
	 * Returns if the columns should have the same width
	 * 
	 * @return <code>true</code> if columns should have the same width
	 */
	public boolean getSameWidth() {
		return sameWidth;
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		Element node = document.createElement("layout");
		node.setAttribute("kind", LayoutParser.GRID_KIND);
		node.setAttribute("numColumns", "" + getNumColumns());
		node.setAttribute("sameWidth", "" + getSameWidth());
		return node;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("GridLayout (");
		buffer.append(getNumColumns());
		buffer.append(", ");
		buffer.append(getSameWidth());
		buffer.append(")");
		return buffer.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public GridLayout createLayout() {
		return new GridLayout(numColumns, sameWidth);
	}

}
