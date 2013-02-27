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
package org.eclipse.papyrus.infra.nattable.celleditor.configs;

import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;



public abstract class AbstractCellEditorConfiguration implements IAxisCellEditorConfiguration {

	public static final String CELL_LABEL = "cell_label"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration#getConfigCellId()
	 * 
	 * @return
	 */
	public final String getConfigCellId() {
		return getEditorId() + CELL_LABEL;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration#getDataValidator()
	 * 
	 * @return
	 *         <code>null</code>
	 */
	public IDataValidator getDataValidator() {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration#getEditorDescription()
	 * 
	 * @return
	 */
	@Override
	public String getEditorDescription() {
		return "No Existing Description";
	}
}
