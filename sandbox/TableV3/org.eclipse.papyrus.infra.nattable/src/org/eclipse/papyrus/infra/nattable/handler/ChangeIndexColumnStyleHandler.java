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

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration;

/**
 * the handler used to change the index style of the column
 * 
 * @author Vincent Lorenzo
 * 
 */
public class ChangeIndexColumnStyleHandler extends AbstractChangeIndexStyleHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractChangeIndexStyleHandler#getAxisConfiguration()
	 * 
	 * @return
	 */
	@Override
	protected AbstractAxisConfiguration getAxisConfiguration() {
		return getCurrentNattableModelManager().getVerticalAxisConfiguration();
	}


}
