/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Devernay (Atos) laurent.devernay@atos.net
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.resourceloading.preferences;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.resourceloading.ILoadingStrategyExtension;

public class PreferenceLoadingStrategyExtension implements ILoadingStrategyExtension {

	public boolean loadResource(ModelSet modelSet, URI uri) {
		Set<URI> loadedAuthorizedResourcesSet = LoadedAuthorizedResourceManager.getInstance().getLoadedAuthorizedResourcesSet(modelSet);

		if(loadedAuthorizedResourcesSet.contains(uri.trimFileExtension())) {
			return true;
		}
		return false;
	}

}
