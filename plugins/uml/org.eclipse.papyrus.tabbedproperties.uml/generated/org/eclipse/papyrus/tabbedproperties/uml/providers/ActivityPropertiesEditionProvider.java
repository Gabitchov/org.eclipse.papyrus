/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.papyrus.tabbedproperties.uml.components.ActivityBasePropertiesEditionComponent;
import org.eclipse.papyrus.tabbedproperties.uml.components.ActivityPropertiesEditionComponent;
import org.eclipse.papyrus.tabbedproperties.uml.components.ElementPropertiesEditionComponent;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ActivityPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof Activity) && (UMLPackage.eINSTANCE.getActivity() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if(eObject instanceof Activity) {
			return new ActivityPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if(eObject instanceof Activity) {
			if(ActivityBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new ActivityBasePropertiesEditionComponent(eObject, editing_mode);
			if(ElementPropertiesEditionComponent.COMMENTS_PART.equals(part))
				return new ElementPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
