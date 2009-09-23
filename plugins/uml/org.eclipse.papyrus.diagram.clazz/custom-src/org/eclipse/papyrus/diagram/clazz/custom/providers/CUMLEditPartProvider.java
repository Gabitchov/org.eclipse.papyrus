package org.eclipse.papyrus.diagram.clazz.custom.providers;

import org.eclipse.papyrus.diagram.clazz.custom.factory.CustomUMLeditPartFactory;

public class CUMLEditPartProvider extends org.eclipse.papyrus.diagram.clazz.providers.UMLEditPartProvider {

	/**
	 * @generated
	 */
	public CUMLEditPartProvider() {
		setFactory(new CustomUMLeditPartFactory());
		setAllowCaching(true);
	}
}
