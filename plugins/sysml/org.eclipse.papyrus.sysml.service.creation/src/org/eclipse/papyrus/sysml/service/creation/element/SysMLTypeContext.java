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
 *  Yann Tanguy (CEA LIST) Yann.Tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.creation.element;

import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;

/**
 * This is a SysML context in order to call helper for SysML
 * 
 */
public class SysMLTypeContext {

	/**
	 * the ID if SysML Type Context
	 */
	public static final String ID = "org.eclipse.papyrus.sysml.service.creation.TypeContext"; //$NON-NLS-1$

	/**
	 * Used to obtain the SysML context
	 * 
	 * @return the SysML context
	 * @throws Exception
	 *         if the context is not found
	 */
	public static IClientContext getContext() throws Exception {
		IClientContext context = ClientContextManager.getInstance().getClientContext(ID);
		if(context == null) {
			throw new Exception("Could not retrieve context : " + ID + ".");
		}

		return context;
	}

}
