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
package org.eclipse.papyrus.infra.nattable.manager.cell;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * The abstract class for the cell manager
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractCellManager implements ICellManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#setValue(org.eclipse.emf.edit.domain.EditingDomain, java.lang.Object,
	 *      java.lang.Object, java.lang.Object)
	 * 
	 * @param domain
	 * @param obj1
	 * @param obj2
	 * @param newValue
	 */
	public void setValue(EditingDomain domain, Object obj1, Object obj2, Object newValue) {
		final Command cmd = getSetValueCommand(domain, obj1, obj2, newValue);
		assert cmd != null;
		domain.getCommandStack().execute(cmd);
	}


}
