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

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelConfiguration;

/**
 * The abstract handler used to change the column header label configuration
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractColumnChangeLabelConfigurationValueHandler extends AbstractChangeLabelConfigurationValueHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractChangeLabelConfigurationValueHandler#getEditedLabelConfiguration()
	 * 
	 * @return
	 */
	@Override
	protected ILabelConfiguration getEditedLabelConfiguration() {
		return getCurrentNattableModelManager().getColumnAxisConfiguration().getLabelConfiguration();
	}

}
