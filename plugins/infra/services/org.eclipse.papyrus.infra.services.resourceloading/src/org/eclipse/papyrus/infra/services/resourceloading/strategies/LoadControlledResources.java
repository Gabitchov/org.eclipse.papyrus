/*****************************************************************************
 * Copyright (c) 2010, 2013 Atos Origin, CEA LIST, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - support control mode in CDO resources
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.resourceloading.strategies;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.services.controlmode.history.HistoryModel;
import org.eclipse.papyrus.infra.services.controlmode.history.utils.HistoryUtils;
import org.eclipse.papyrus.infra.services.resourceloading.HistoryRoutingUtils;
import org.eclipse.papyrus.infra.services.resourceloading.ILoadingStrategy;


public class LoadControlledResources implements ILoadingStrategy {

	/**
	 * {@inheritDoc} Loads additional resources (types, profiles, etc)
	 * The controlled resources from the current one are loaded
	 * Other resources used from references are not loaded
	 */
	public boolean loadResource(ModelSet modelSet, URI uri) {
		boolean result = !modelSet.isUserModelResource(uri);
		if(!result) {
			URI initialURI = SashModelUtils.getInitialURI(modelSet).trimFileExtension().appendFileExtension(uri.fileExtension());
			URI uriInitialTrimFragment = initialURI.trimFragment();
			URI uritrimFragment = uri.trimFragment();
			result = uritrimFragment.equals(uriInitialTrimFragment);
			// if !result it is necessary to navigate into the history to find if the uri searched is a controlled
			if(!result) {
				HistoryModel model = HistoryUtils.getHistoryModel(modelSet);
				URI path = HistoryUtils.getURIFullPath(uriInitialTrimFragment);
				URI resolve = URI.createURI(HistoryUtils.resolve(path, uriInitialTrimFragment));
				Set<String> allControled = HistoryRoutingUtils.getAllControledURIs(modelSet, model, resolve, true);
				result = allControled.contains(HistoryUtils.resolve(path, uritrimFragment).toString());
			}
		}
		return result;
	}
}
