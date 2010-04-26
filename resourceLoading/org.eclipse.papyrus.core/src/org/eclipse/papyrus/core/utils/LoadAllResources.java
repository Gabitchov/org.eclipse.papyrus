package org.eclipse.papyrus.core.utils;

import org.eclipse.emf.common.util.URI;


public class LoadAllResources implements ILoadingStrategy {

	public boolean loadResource(URI uri) {
		// whatever is the uri, the resource is loaded
		return true;
	}

}
