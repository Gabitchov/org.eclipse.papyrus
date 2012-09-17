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
package org.eclipse.papyrus.infra.onefile.model.adapters;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.infra.onefile.model.ISubResourceFile;
import org.eclipse.papyrus.infra.onefile.model.mapping.SubResourceMapping;
import org.eclipse.ui.IContributorResourceAdapter;

/**
 * Adapter Factory for {@link SubResourceFile}
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class SubResourceAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(ResourceMapping.class.equals(adapterType)) {
			if(adaptableObject instanceof ISubResourceFile) {
				return new SubResourceMapping((ISubResourceFile)adaptableObject);
			}
		} else if(IFile.class.equals(adapterType)) {
			if(adaptableObject instanceof ISubResourceFile) {
				return ((ISubResourceFile)adaptableObject).getFile();
			}
		} else if(IContributorResourceAdapter.class.equals(adapterType)) {
			if(adaptableObject instanceof ISubResourceFile) {
				return new PapyrusModelContributorResourceAdapter();
			}
		} else if(IResource.class.equals(adapterType)) {
			if(adaptableObject instanceof ISubResourceFile) {
				return ((ISubResourceFile)adaptableObject).getFile();
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[]{};
	}

}
