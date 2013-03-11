/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.resource;

import org.eclipse.emf.cdo.dawn.resources.impl.DawnWrapperResourceImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;


/**
 * This is the PapyrusDawnResourceImpl type.  Enjoy.
 */
public class PapyrusDawnResourceImpl
		extends DawnWrapperResourceImpl {

	private URI uri;
	
	public PapyrusDawnResourceImpl(URI uri) {
		super(uri);
		
		this.uri = uri;
	}

	@Override
	public URI getURI() {
		// cache the URI locally to read it without synchronization, to prevent
		// deadlocks on the URI thread with the ReadOnlyManager
		return (uri != null) ? uri : super.getURI();
	}
	
	@Override
	public void setURI(URI newURI) {
		super.setURI(newURI);
		
		this.uri = super.getURI();
	}
	
	@Override
	public String toString() {
		return String.format("%s{uri: %s}", super.toString(), getURI()); //$NON-NLS-1$
	}
	
	@Override
	public void setID(EObject eObject, String id) {
		// profile migration expects to be able to do this, but it has
		// no meaning. Just don't throw as the super implementation does
	}
}
