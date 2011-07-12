package org.eclipse.papyrus.emf.embeddededitor.providers;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelContentProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;


public class CustomizableContentProvider extends CustomizableModelContentProvider {

	public CustomizableContentProvider(CustomizationManager customizationManager) {
		super(customizationManager);
	}

	@Override
	public Object[] getRootElements(final Object inputElement) {
		if(inputElement instanceof IFile) {
			return super.getRootElements(inputElement);
		}

		if(inputElement instanceof ResourceSet) {
			return ((ResourceSet)inputElement).getResources().get(0).getContents().toArray();
		}

		return new Object[0];
	}

}
