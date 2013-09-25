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
package org.eclipse.papyrus.cdo.internal.core;

import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.cdo.internal.core.controlmode.CDOProxyManager;


/**
 * A specialized {@link ResourceSet} that resolves CDO-style cross-resource proxies in the context of the attached {@linkplain CDOView view}.
 */
public class CDOProxyResolvingResourceSet extends ResourceSetImpl {

	public CDOProxyResolvingResourceSet() {
		super();
	}

	/**
	 * Extends the inherited implementation to handle CDO-style cross-resource proxies.
	 */
	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		EObject result;

		if(CDOProxyManager.isCDOProxyURI(uri)) {
			// force loading (ignore 'loadOnDemand') because export requires a complete model
			Resource res = getResource(uri.trimFragment(), true);
			result = (res == null) ? null : res.getEObject(CDOProxyManager.extractOIDFragment(uri));
		} else {
			result = super.getEObject(uri, loadOnDemand);
		}

		return result;
	}


}
