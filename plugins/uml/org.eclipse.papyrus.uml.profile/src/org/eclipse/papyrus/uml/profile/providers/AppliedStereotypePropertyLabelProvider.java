/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.graphics.Image;


public class AppliedStereotypePropertyLabelProvider extends UMLLabelProvider {

	@Override
	public String getText(Object element) {
		AppliedStereotypeProperty stereotypeProperty = resolveAppliedStereotypeProperty(element);
		if(stereotypeProperty != null) {
			return super.getText(stereotypeProperty.getStereotypeProperty());
		}

		return super.getText(element);
	}


	@Override
	public Image getImage(Object element) {
		AppliedStereotypeProperty stereotypeProperty = resolveAppliedStereotypeProperty(element);
		if(stereotypeProperty != null) {
			return super.getImage(stereotypeProperty.getStereotypeProperty());
		}

		return super.getImage(element);
	}


	/**
	 * Tries to adapt the given element to an AppliedStereotypeProperty, and returns it
	 * 
	 * @param element
	 * @return
	 *         The adapted AppliedStereotypeProperty, or null
	 */
	protected AppliedStereotypeProperty resolveAppliedStereotypeProperty(Object element) {
		if(element instanceof AppliedStereotypeProperty) {
			return (AppliedStereotypeProperty)element;
		}

		if(element instanceof IAdaptable) {
			return (AppliedStereotypeProperty)((IAdaptable)element).getAdapter(AppliedStereotypeProperty.class);
		}

		return null;
	}
}
