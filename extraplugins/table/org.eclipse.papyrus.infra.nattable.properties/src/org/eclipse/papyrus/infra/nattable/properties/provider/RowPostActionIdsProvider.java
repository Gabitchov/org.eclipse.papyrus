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
package org.eclipse.papyrus.infra.nattable.properties.provider;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;

/**
 * 
 * @author vl222926
 * 
 */
public class RowPostActionIdsProvider extends AbstractPostActionIdsProvider {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tableManager
	 *        the table manager
	 */
	public RowPostActionIdsProvider(final INattableModelManager tableManager) {
		super(tableManager, false);
	}



}
