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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.scope;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.views.search.utils.ModelUtils;

/**
 * 
 * Implements a visitor that goes through a hierarchy of Iresource from a root and collect only those that can be processed for search
 * 
 */
public class ResourceVisitor implements IResourceProxyVisitor {

	private List<IResource> participants;

	public ResourceVisitor() {
		super();
		this.participants = new ArrayList<IResource>();
	}

	public boolean visit(IResourceProxy proxy) throws CoreException {
		switch(proxy.getType()) {
		case IResource.FILE:
			IResource resource = proxy.requestResource();

			URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);

			if("di".equals(uri.fileExtension())) { //$NON-NLS-1$
				//Verify that it is a true papyrus model
				try {
					ModelSet modelSet = ModelUtils.openFile(resource);
					modelSet.unload();
					participants.add(resource);
				} catch (ModelMultiException e) {
				}

			}

			break;
		default:
			break;
		}
		return true;
	}

	public List<IResource> getParticipants() {
		return participants;
	}

}
