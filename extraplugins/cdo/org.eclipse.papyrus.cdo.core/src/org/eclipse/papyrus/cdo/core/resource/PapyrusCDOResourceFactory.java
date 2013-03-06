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

import org.eclipse.emf.cdo.dawn.resources.impl.DawnResourceFactoryImpl;
import org.eclipse.emf.cdo.eresource.impl.CDOResourceImpl;
import org.eclipse.emf.common.util.URI;

/**
 * This is the PapyrusCDOResourceFactory type. Enjoy.
 */
public class PapyrusCDOResourceFactory
		extends DawnResourceFactoryImpl {

	private final CDOAwareModelSet modelSet;

	public PapyrusCDOResourceFactory(CDOAwareModelSet modelSet) {
		super();

		this.modelSet = modelSet;
	}

	protected CDOResourceImpl createCDOResource(URI uri) {
		return new PapyrusDawnResourceImpl(uri);
	}
	
	@Override
	protected boolean isGetResource() {
		return modelSet.isInGetResource() || super.isGetResource();
	}
}
