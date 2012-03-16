/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.onefile.model.adapters;

import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.onefile.model.mapping.PapyrusResourceMapping;

/**
 * Adapter factory to adapt {@link IPapyrusFile}
 * 
 * @author tristan.faure@atosorigin.com
 */
@SuppressWarnings("rawtypes")
public class ModelAdapterFactory implements IAdapterFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 * java.lang.Class)
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (ResourceMapping.class.equals(adapterType)) {
			if (adaptableObject instanceof IPapyrusFile) {
				return new PapyrusResourceMapping(
						(IPapyrusFile) adaptableObject);
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] {};
	}

}