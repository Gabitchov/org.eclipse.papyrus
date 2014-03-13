/*
 * 
 */
package org.eclipse.papyrus.uml.modelexplorer.factory;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;


public class ModelElementItemFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
			EObject eobject = EMFHelper.getEObject(adaptableObject);
				return eobject;
	}

	public Class<?>[] getAdapterList() {
		// TODO Auto-generated method stub
		return null;
	}

}
