package org.eclipse.papyrus.compare.ui.viewer.content.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLReflectiveItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLResourceItemProviderAdapterFactory;


public class UMLAdapterFactory extends ComposedAdapterFactory {

	private final static List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
	static {
		factories.add(new UMLResourceItemProviderAdapterFactory());
		factories.add(new UMLItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new UMLReflectiveItemProviderAdapterFactory());
	}

	public UMLAdapterFactory() {
		super(factories);
	}

}
