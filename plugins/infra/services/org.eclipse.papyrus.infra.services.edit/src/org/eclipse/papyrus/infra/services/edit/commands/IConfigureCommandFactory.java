/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.edit.commands;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * <pre>
 * This kind of factory may be added in an element creation request and used
 * by the configure command to complete the existing configure command.
 * </pre>
 */
public interface IConfigureCommandFactory {

	/** ID to store {@link IConfigureCommandFactory} in request */
	public static final String CONFIGURE_COMMAND_FACTORY_ID = "IConfigureCommandFactory_ID"; //$NON-NLS-1$

	/**
	 * Create a configure element command.
	 * 
	 * @param request
	 *        the configure request.
	 * @return the configure command.
	 */
	public ICommand create(final ConfigureRequest request);
}
