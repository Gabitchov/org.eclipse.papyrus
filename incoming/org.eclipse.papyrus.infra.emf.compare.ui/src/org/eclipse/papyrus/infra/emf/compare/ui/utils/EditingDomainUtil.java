/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.utils;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class EditingDomainUtil {

	private EditingDomainUtil() {
		//nothing to do
	}


	/**
	 * This method use the Papyrus Service Registry to get the EditingDomain. If not, when the
	 * editorPart is an instanceof IEditingDomainProvider, the method returns this editingdomain
	 * 
	 * @return
	 *         the current editing domain or <code>null</code> if not found
	 * 
	 */
	public static TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain domain = null;
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ServicesRegistry servicesRegistry = (ServicesRegistry)editorPart.getAdapter(ServicesRegistry.class);
		if(servicesRegistry != null) {
			try {
				domain = servicesRegistry.getService(TransactionalEditingDomain.class);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		} else if(editorPart instanceof IEditingDomainProvider) {
			domain = (TransactionalEditingDomain)((IEditingDomainProvider)editorPart).getEditingDomain();
		}
		return domain;
	}
}
