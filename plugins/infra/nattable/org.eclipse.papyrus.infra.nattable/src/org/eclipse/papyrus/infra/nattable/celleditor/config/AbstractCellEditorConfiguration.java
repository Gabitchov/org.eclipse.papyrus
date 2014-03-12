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
package org.eclipse.papyrus.infra.nattable.celleditor.config;

import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;



public abstract class AbstractCellEditorConfiguration implements IAxisCellEditorConfiguration {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.IAxisCellEditorConfiguration#getDataValidator(Table, Object)
	 * 
	 * @return
	 *         <code>null</code>
	 */
	public IDataValidator getDataValidator(Table table, Object axisElement) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.IAxisCellEditorConfiguration#getEditorDescription()
	 * 
	 * @return
	 */
	public String getEditorDescription() {
		return "No Existing Description"; //$NON-NLS-1$
	}
}
