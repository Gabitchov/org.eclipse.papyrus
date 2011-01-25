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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.properties.databinding.MultipleObservableValue;
import org.eclipse.papyrus.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

public class CompositeModelElement implements ModelElement {

	public IObservableValue getObservable(String propertyPath) {
		MultipleObservableValue observableValue = new MultipleObservableValue();
		for(ModelElement element : elements) {
			observableValue.addObservable((IObservableValue)element.getObservable(propertyPath));
		}
		return observableValue;
	}

	public String getLabel(String propertyPath) {
		return null;
	}

	public void addModelElement(ModelElement element) {
		elements.add(element);
	}

	private List<ModelElement> elements = new LinkedList<ModelElement>();

	public IStaticContentProvider getContentProvider(String propertyPath) {
		if(elements.isEmpty())
			return EmptyContentProvider.instance;

		return elements.get(0).getContentProvider(propertyPath);
	}

	public ILabelProvider getLabelProvider(String propertyPath) {
		if(elements.isEmpty())
			return null;

		return elements.get(0).getLabelProvider(propertyPath);
	}

	public boolean isOrdered(String propertyPath) {
		if(elements.isEmpty())
			return false;

		return elements.get(0).isOrdered(propertyPath);
	}

	public boolean isUnique(String propertyPath) {
		if(elements.isEmpty())
			return false;

		return elements.get(0).isUnique(propertyPath);
	}

	public boolean isMandatory(String propertyPath) {
		if(elements.isEmpty())
			return false;

		return elements.get(0).isMandatory(propertyPath);
	}

	public boolean isEditable(String propertyPath) {
		boolean editable = !elements.isEmpty();
		for(ModelElement element : elements) {
			if(!element.isEditable(propertyPath))
				return false;
		}
		return editable;
	}
}
