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
package org.eclipse.papyrus.infra.nattable.properties.constraints;


/**
 * 
 * @author VL222926
 * 
 */
public class CantCreateColumnElementContraint extends CanCreateColumnElementContraint {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.constraints.CanCreateColumnElementContraint#match(java.lang.Object)
	 * 
	 * @param selection
	 * @return
	 */
	@Override
	public boolean match(Object selection) {
		return !super.match(selection);
	}

}
