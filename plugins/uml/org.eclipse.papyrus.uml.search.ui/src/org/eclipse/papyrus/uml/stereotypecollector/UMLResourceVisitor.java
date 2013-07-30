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
package org.eclipse.papyrus.uml.stereotypecollector;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;

/**
 * 
 * Implements a visitor that goes through a hierarchy of Iresource from a root and collect only those that can be processed for search
 * 
 */
public class UMLResourceVisitor implements IResourceProxyVisitor {

	private Collection<IResource> participants;

	public UMLResourceVisitor() {
		super();
		this.participants = new HashSet<IResource>();
	}

	public boolean visit(IResourceProxy proxy) throws CoreException {
		switch(proxy.getType()) {
		case IResource.FILE:
			IResource resource = proxy.requestResource();

			URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);

			if("uml".equals(uri.fileExtension())) { //$NON-NLS-1$
				participants.add(resource);

			}

			break;
		default:
			break;
		}
		return true;
	}

	public Collection<IResource> getParticipants() {
		return participants;
	}

}
