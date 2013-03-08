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
public class LabelProviderContextElement implements ILabelProviderContextElement {

	private ILayerCell cell;

	private IConfigRegistry registry;

	/**
	 * *
	 * Constructor.
	 * 
	 * @param cell
	 *        the cell for which we want the label/icon, ...
	 * @param registry
	 *        the registry used by nattable
	 */
	public LabelProviderContextElement(ILayerCell cell, final IConfigRegistry registry) {
		this.cell = cell;
		this.registry = registry;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement#getCell()
	 * 
	 * @return
	 */
	public ILayerCell getCell() {
		return cell;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement#getConfigRegistry()
	 * 
	 * @return
	 */
	public IConfigRegistry getConfigRegistry() {
		return this.registry;
	}

}
