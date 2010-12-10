/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.uml2.uml.Usage;

/**
 * 
 * This helper is used to set the client and the supplier for an {@link Usage}
 * 
 * 
 */
public class UsageEditHelper extends DependencyEditHelper {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.helper.DependencyEditHelper#getConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		return super.getConfigureCommand(req);
	}
}
