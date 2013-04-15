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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;

/**
 * Abstract class to edit the header cofniguration
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractColumnChangeHeaderConfigurationHandler extends AbstractChangeHeaderConfigurationHandler {

	/**
	 * 
	 * @return
	 *         the edited axis configuration or <code>null</code> if it doesn't exists in the table
	 */
	@Override
	protected AbstractHeaderAxisConfiguration getEditedAxisConfiguration() {
		return HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTable(getCurrentNattableModelManager().getTable());
	}
}
