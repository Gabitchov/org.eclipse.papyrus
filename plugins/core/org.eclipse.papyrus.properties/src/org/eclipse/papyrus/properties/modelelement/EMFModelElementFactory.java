/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.modelelement;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.runtime.DataSource;
import org.eclipse.papyrus.properties.util.EMFHelper;

public class EMFModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		EObject source = EMFHelper.getEObject(sourceElement);
		if(source == null) {
			Activator.log.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);
		return new EMFModelElement(source, domain);
	}

	public List<ModelElement> createFromDataSource(ModelElement currentElement, DataSource source, String propertyPath, DataContextElement context) {
		List<ModelElement> result = new LinkedList<ModelElement>();
		EMFModelElement element = (EMFModelElement)currentElement;
		EStructuralFeature feature = element.getFeature(propertyPath);

		if(feature instanceof EReference) {
			Object newSource = element.getSource().eGet(feature);
			if(newSource instanceof EList<?>) {
				for(Object sourceElement : (EList<?>)newSource) {
					result.add(createFromSource(sourceElement, context));
				}
			} else {
				result.add(createFromSource(newSource, context));
			}
		}

		return result;
	}
}
