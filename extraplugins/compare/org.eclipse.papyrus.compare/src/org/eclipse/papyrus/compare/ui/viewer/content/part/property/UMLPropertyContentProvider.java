/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content.part.property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.ui.viewer.content.part.property.PropertyContentProvider;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.papyrus.compare.ui.viewer.content.part.UMLAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLReflectiveItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLResourceItemProviderAdapterFactory;


public class UMLPropertyContentProvider extends PropertyContentProvider {


	@Override
	public Object[] getElements(Object inputElement) {
		// tfesenko - the only change with the super method is here, we use UMLAdapterFactory
		ComposedAdapterFactory factory = new UMLAdapterFactory();

		// init inputObject value
		super.getElements(inputElement);
		Object[] elements = new Object[]{};
		if(getInputEObject() != null) {
			final List<List<Object>> inputElements = new ArrayList<List<Object>>();

			final IItemPropertySource inputPropertySource = (IItemPropertySource)factory.adapt(getInputEObject(), IItemPropertySource.class);
			// Iterates through the property descriptor to display only the "property" features of the input
			// object
			for(final IItemPropertyDescriptor descriptor : inputPropertySource.getPropertyDescriptors(getInputEObject())) {
				/*
				 * Filtering out "advanced" properties can be done by hiding properties on which
				 * Arrays.binarySearch(descriptor.getFilterFlags(input),
				 * "org.eclipse.ui.views.properties.expert") returns an int > 0.
				 */
				final EStructuralFeature feature = (EStructuralFeature)descriptor.getFeature(getInputEObject());
				final List<Object> row = new ArrayList<Object>();
				row.add(feature);
				row.add(getInputEObject().eGet(feature));
				inputElements.add(row);
			}

			elements = inputElements.toArray();
			Arrays.sort(elements, new Comparator<Object>() {

				public int compare(Object first, Object second) {
					final String name1 = ((EStructuralFeature)((List<?>)first).get(0)).getName();
					final String name2 = ((EStructuralFeature)((List<?>)second).get(0)).getName();

					return name1.compareTo(name2);
				}
			});
		}
		return elements;
	}


}
