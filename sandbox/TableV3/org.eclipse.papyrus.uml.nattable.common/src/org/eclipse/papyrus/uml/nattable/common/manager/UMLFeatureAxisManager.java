package org.eclipse.papyrus.uml.nattable.common.manager;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.infra.nattable.common.manager.FeatureManager;

/**
 *
 * This UML feature provider allows to ignore the feature EAnnotation
 *
 */
public class UMLFeatureAxisManager extends FeatureManager {

	@Override
	public boolean isAllowedContents(Object object) {
		boolean value = super.isAllowedContents(object);
		if(value) {
			return object != EcorePackage.eINSTANCE.getEModelElement_EAnnotations();
		}
		return value;
	}

}
