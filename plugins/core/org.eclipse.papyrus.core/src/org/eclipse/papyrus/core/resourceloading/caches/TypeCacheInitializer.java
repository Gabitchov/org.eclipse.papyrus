/**
 * 
 */
package org.eclipse.papyrus.core.resourceloading.caches;

import org.eclipse.papyrus.resource.IModelSetSnippet;
import org.eclipse.papyrus.resource.ModelSet;


/**
 * This snippet take in charge the initialization of the TypeCache.
 * The snippet is attached to the {@link ModelSet} (in the extensions), and called 
 * right after ModelsManager is initialized.
 * 
 * @author cedric dumoulin
 *
 */
public class TypeCacheInitializer implements IModelSetSnippet {

	/**
	 * The type cache adapter used to reference elements from a type
	 */
	private TypeCacheAdapter typeCacheAdapter = new TypeCacheAdapter();

	/**
	 * @see org.eclipse.papyrus.resource.IModelSetSnippet#start(org.eclipse.papyrus.resource.ModelSet)
	 *
	 * @param modelsManager
	 */
	public void start(ModelSet modelsManager) {
		modelsManager.eAdapters().add(typeCacheAdapter);

	}

	/**
	 * @see org.eclipse.papyrus.resource.IModelSetSnippet#dispose(org.eclipse.papyrus.resource.ModelSet)
	 *
	 * @param modelsManager
	 */
	public void dispose(ModelSet modelsManager) {
		modelsManager.eAdapters().remove(typeCacheAdapter);

	}

}
