package org.eclipse.papyrus.emf.embeddededitor.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.providers.EMFObjectLabelProvider;


public class ModiscoLabelProvider extends EMFObjectLabelProvider {

	@Override
	public EObject getModel(Object element) {
		EObject eObject = super.getModel(element);
		if(eObject != null) {
			return eObject;
		}

		if(element instanceof IAdaptable) {
			eObject = (EObject)((IAdaptable)element).getAdapter(EObject.class);
		}

		return eObject;
	}
}
