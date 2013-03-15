/*****************************************************************************
 * Copyright (c) 2012 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;

@SuppressWarnings("rawtypes")
public class ReadOnlyAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(IReadOnlyHandler.class == adapterType && adaptableObject instanceof PapyrusROTransactionalEditingDomain) {
			return ReadOnlyManager.getInstance();
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[]{ EditingDomain.class };
	}
}
