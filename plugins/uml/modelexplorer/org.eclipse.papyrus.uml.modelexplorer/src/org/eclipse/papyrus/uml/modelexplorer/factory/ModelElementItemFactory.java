/*
 * 
 */
package org.eclipse.papyrus.uml.modelexplorer.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;


public class ModelElementItemFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adaptableObject instanceof IAdaptable) {
			EObject eobject = (EObject)((IAdaptable)adaptableObject).getAdapter(EObject.class);
			if(adapterType.isInstance(eobject)) {
				return eobject;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	public Class<?>[] getAdapterList() {
		// TODO Auto-generated method stub
		return null;
	}

}
