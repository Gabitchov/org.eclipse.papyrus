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
package org.eclipse.papyrus.uml.profile.properties.modelelement;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.profile.properties.Activator;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;

public class AppliedStereotypePropertyModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		AppliedStereotypeProperty stereotypeProperty = null;
		if(sourceElement instanceof AppliedStereotypeProperty) {
			stereotypeProperty = (AppliedStereotypeProperty)sourceElement;
		} else if(sourceElement instanceof IAdaptable) {
			stereotypeProperty = (AppliedStereotypeProperty)((IAdaptable)sourceElement).getAdapter(AppliedStereotypeProperty.class);
		}

		if(stereotypeProperty == null) {
			Activator.log.warn("The source element cannot be resolved to an AppliedStereotypeProperty");
			return null;
		}

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(stereotypeProperty.getStereotypeApplication());

		return new AppliedStereotypePropertyModelElement(stereotypeProperty, domain);
	}

}
