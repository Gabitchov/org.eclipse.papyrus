/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.manager.axis;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EStructuralFeature;
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

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.EStructuralFeatureAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAllowedContents(Object object) {
		boolean value = super.isAllowedContents(object);
		if(value) {
			final EStructuralFeature feature = (EStructuralFeature)object;
			value = feature.eContainer().eContainer() == UMLPackage.eINSTANCE;
		}
		return value;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.EStructuralFeatureAxisManager#getAllPossibleAxis()
	 * 
	 * @return
	 */
	@Override
	public Collection<Object> getAllPossibleAxis() {
		Collection<Object> classes = new HashSet<Object>();
		classes.add(UMLPackage.eINSTANCE);
		return classes;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#createPossibleAxisContentProvider(boolean)
	 * 
	 * @param isRestricted
	 * @return
	 */
	@Override
	public IRestrictedContentProvider createPossibleAxisContentProvider(boolean isRestricted) {
		return new UMLFeatureRestrictedContentProvider(this, isRestricted);
	}
}
