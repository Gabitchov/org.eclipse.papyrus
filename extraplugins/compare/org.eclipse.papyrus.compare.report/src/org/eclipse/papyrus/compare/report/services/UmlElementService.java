package org.eclipse.papyrus.compare.report.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

public class UmlElementService {
	private static  AdapterFactoryLabelProvider oursAdapterLabelProvider = new AdapterFactoryLabelProvider(
            new UMLItemProviderAdapterFactory());

	public String getText(EObject eobject) {
		return oursAdapterLabelProvider.getText(eobject);
	}

}
