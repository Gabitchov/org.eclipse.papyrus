package org.eclipse.papyrus.infra.core.modelsetquery.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.papyrus.infra.core.modelsetquery.IModelSetQueryAdapter;

/**
 * This implementation uses ItemPropertyDescriptor class to resolve objects
 * from type
 * 
 * @author tfaure
 */
public class ModelSetQueryAdapterSimple implements IModelSetQueryAdapter {
	/**
	 * This cache adapter is only used if the caller don't use correctly
	 * TypeCacheAdapter. With the simple cache adapter performance are not good
	 * but a result is still returned
	 */
	private static ModelSetQueryAdapterSimple simpleCacheAdapter = new ModelSetQueryAdapterSimple();	
	
	public static IModelSetQueryAdapter getSimpleTypeCacheAdapter() {
		return simpleCacheAdapter;
	}

	public Collection<EObject> getReachableObjectsOfType(EObject object, EClassifier type) {
		return ItemPropertyDescriptor.getReachableObjectsOfType(object, type);
	}
}
