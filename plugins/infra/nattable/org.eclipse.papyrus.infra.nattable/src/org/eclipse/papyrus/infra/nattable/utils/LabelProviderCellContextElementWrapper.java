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

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.swt.graphics.Rectangle;

/**
 * This object can used as context to find the best label provider and get the text to display.
 * Its allows to have the context of the value to use it in the label provider
 * 
 * This objects can be used to get the label of an object which is not the current value of the cell, using the label provider used by the cell.
 * example to get the value of the enumeration literal in the combo box for uml stereotype properties
 * 
 * @author Vincent Lorenzo
 * 
 */

public class LabelProviderCellContextElementWrapper extends LabelProviderContextElementWrapper implements ILabelProviderCellContextElementWrapper {

	/** the cell. */
	private ILayerCell cell;

	/**
	 * *
	 * Constructor.
	 * 
	 * @param cell
	 *        the cell for which we want the label/icon, ...
	 * @param registry
	 *        the registry used by nattable
	 */
	public LabelProviderCellContextElementWrapper(ILayerCell cell, final IConfigRegistry registry) {
		this(cell, cell.getDataValue(), registry);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param cell
	 *        the cell
	 * @param value
	 *        a value
	 * @param registry
	 *        the registry used by nattable
	 */
	public LabelProviderCellContextElementWrapper(ILayerCell cell, final Object value, final IConfigRegistry registry) {
		super(value, registry);
		this.cell = cell;
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getConfigLabels()
	 * 
	 * @return
	 */

	@Override
	public LabelStack getConfigLabels() {
		return this.cell.getConfigLabels();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getOriginColumnPosition()
	 * 
	 * @return
	 */

	@Override
	public int getOriginColumnPosition() {
		return cell.getOriginColumnPosition();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getOriginRowPosition()
	 * 
	 * @return
	 */

	@Override
	public int getOriginRowPosition() {
		return cell.getOriginRowPosition();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getLayer()
	 * 
	 * @return
	 */

	@Override
	public ILayer getLayer() {
		return cell.getLayer();
	}

	/**
	 * Gets the column position.
	 * 
	 * @return the column position
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getColumnPosition()
	 */

	@Override
	public int getColumnPosition() {
		return cell.getColumnPosition();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getRowPosition()
	 * 
	 * @return
	 */

	@Override
	public int getRowPosition() {
		return cell.getRowPosition();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getColumnIndex()
	 * 
	 * @return
	 */

	@Override
	public int getColumnIndex() {
		return cell.getColumnIndex();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getRowIndex()
	 * 
	 * @return
	 */

	@Override
	public int getRowIndex() {
		return cell.getRowIndex();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getColumnSpan()
	 * 
	 * @return
	 */

	@Override
	public int getColumnSpan() {
		return cell.getColumnSpan();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getRowSpan()
	 * 
	 * @return
	 */

	@Override
	public int getRowSpan() {
		return cell.getRowSpan();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#isSpannedCell()
	 * 
	 * @return
	 */

	@Override
	public boolean isSpannedCell() {
		return cell.isSpannedCell();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getDisplayMode()
	 * 
	 * @return
	 */

	@Override
	public String getDisplayMode() {
		return cell.getDisplayMode();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getDataValue()
	 * 
	 * @return
	 */
	@Override
	public final Object getDataValue() {
		throw new UnsupportedOperationException("You must use ILabelProviderCellContextElement#getObject()"); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell#getBounds()
	 * 
	 * @return
	 */

	@Override
	public Rectangle getBounds() {
		return cell.getBounds();
	}

}
