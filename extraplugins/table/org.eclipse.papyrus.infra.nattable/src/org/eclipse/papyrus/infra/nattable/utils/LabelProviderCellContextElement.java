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
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;

/**
 * This object can used as context to find the best label provider and get the text to display.
 * Its allows to have the context of the value to use it in the label provider
 * 
 * @author Vincent Lorenzo
 * 
 */
public class LabelProviderCellContextElement extends LabelProviderContextElement implements ILabelProviderCellContextElement {

	/**
	 * the cell
	 */
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
	public LabelProviderCellContextElement(ILayerCell cell, final IConfigRegistry registry) {
		super(cell.getDataValue(), registry);
		this.cell = cell;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement#getCell()
	 * 
	 * @return
	 */
	public ILayerCell getCell() {
		return this.cell;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.utils.LabelProviderContextElement#getObject()
	 * 
	 * @return
	 */
	@Override
	public Object getObject() {
		return this.cell.getDataValue();
	}

}
