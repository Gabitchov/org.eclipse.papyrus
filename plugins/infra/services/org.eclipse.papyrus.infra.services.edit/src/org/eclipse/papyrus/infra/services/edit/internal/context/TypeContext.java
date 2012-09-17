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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 * 		Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.edit.internal.context;

import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.messages.Messages;

/**
 * <pre>
 * The centralized model type edit service relies on GMF Runtime extensible
 * type framework, used via a single common {@link IClientContext} on which 
 * the various {@link IElementType} used by Papyrus are registered.  
 * 
 * This class stores this context ID and provides a convenient API to 
 * get the {@link IClientContext} from the {@link ClientContextManager}.
 * </pre>
 */
public class TypeContext {

	/** The ID of Papyrus {@link IClientContext} (declared in plugin.xml, shall not be modified) */
	private static final String ID = "org.eclipse.papyrus.infra.services.edit.TypeContext"; //$NON-NLS-1$

	/**
	 * Retrieve Papyrus {@link IClientContext} from its ID.
	 * 
	 * @return the tool context
	 * @throws Exception
	 *         if the context is not found
	 */
	public static IClientContext getContext() throws ServiceException {

		IClientContext context = ClientContextManager.getInstance().getClientContext(ID);
		if(context == null) {
			throw new ServiceException(NLS.bind(Messages.TypeContext_ContextNotFound, ID));
		}

		return context;
	}

}
