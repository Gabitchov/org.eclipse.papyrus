package org.eclipse.papyrus.core.resourceloading.strategy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.core.resourceloading.ILoadingStrategy;


public class LoadAllResources implements ILoadingStrategy {

	public boolean loadResource(URI uri) {
		// whatever is the uri, the resource is loaded
		return true;
	}

}
