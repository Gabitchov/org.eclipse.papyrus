package org.eclipse.papyrus.uml.nattable.manager.axis;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.infra.emf.nattable.manager.axis.EStructuralFeatureAxisManager;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.provider.UMLFeatureRestrictedContentProvider;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This UML feature provider allows to ignore the feature EAnnotation
 * 
 */
public class UMLFeatureAxisManager extends EStructuralFeatureAxisManager {

	@Override
	public boolean isAllowedContents(Object object) {
		boolean value = super.isAllowedContents(object);
		if(value) {
			return object != EcorePackage.eINSTANCE.getEModelElement_EAnnotations();
		}
		return value;
	}

	@Override
	public Collection<Object> getAllPossibleAxis() {
		Collection<Object> classes = new HashSet<Object>();
		classes.add(UMLPackage.eINSTANCE);
		return classes;
	}

	@Override
	public IRestrictedContentProvider createDestroyColumnsContentProvider(boolean isRestricted) {
		return new UMLFeatureRestrictedContentProvider(this, isRestricted);
	}
}
