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
package org.eclipse.papyrus.views.properties.modelelement;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.tools.databinding.MultipleObservableValue;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * A ModelElement to handle MultiSelection property views.
 * It is composed of standard ModelElement. The result of method
 * calls are an aggregation of the results of the same method calls
 * on each sub-element, when this makes sense (i.e. for booleans)
 * When an aggregation is not possible, the result of the same method
 * call on the first element is returned (e.g. for Content and Label providers)
 * 
 * @author Camille Letavernier
 */
public class CompositeModelElement extends AbstractModelElement {

	@Override
	public IObservable doGetObservable(String propertyPath) {

		AggregatedObservable observableComposite = null;

		for(ModelElement element : elements) {
			IObservable observable = element.getObservable(propertyPath);

			//Otherwise, we use a standard AggregatedComposite
			if(observableComposite == null) {
				if(observable instanceof AggregatedObservable) {
					observableComposite = (AggregatedObservable)observable;
				} else {
					if(observable instanceof IObservableValue) {
						observableComposite = new MultipleObservableValue().aggregate(observable);
						if(observableComposite == null) {
							return null;
						}
					} else {
						return null; //The support for CompositeObservableList is too complicated.
						//There are too many non-trivial choices (Union or Intersection display,
						//unadapted behavior of MultipleValueEditors, ...)
						//observableComposite = new MultipleObservableList();
					}
				}
			} else {
				if((observableComposite = observableComposite.aggregate(observable)) == null) {
					return null;
				}
			}
		}

		return observableComposite;
	}

	/**
	 * Adds a sub-model element to this CompositeModelElement
	 * 
	 * @param element
	 *        The sub-model element to be added
	 */
	public void addModelElement(ModelElement element) {
		elements.add(element);
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if(elements.isEmpty()) {
			return EmptyContentProvider.instance;
		}

		return elements.get(0).getContentProvider(propertyPath);
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		if(elements.isEmpty()) {
			return null;
		}

		return elements.get(0).getLabelProvider(propertyPath);
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		if(elements.isEmpty()) {
			return false;
		}

		for(ModelElement element : elements) {
			if(element.isOrdered(propertyPath)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean isUnique(String propertyPath) {
		if(elements.isEmpty()) {
			return false;
		}

		for(ModelElement element : elements) {
			if(!element.isUnique(propertyPath)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		if(elements.isEmpty()) {
			return false;
		}

		for(ModelElement element : elements) {
			if(!element.isMandatory(propertyPath)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isEditable(String propertyPath) {
		if(elements.isEmpty()) {
			return false;
		}

		for(ModelElement element : elements) {
			if(!element.isEditable(propertyPath)) {
				return false;
			}
		}

		return true;
	}

	private List<ModelElement> elements = new LinkedList<ModelElement>();

	@Override
	public boolean forceRefresh(String propertyPath) {
		if(elements.isEmpty()) {
			return false;
		}

		for(ModelElement element : elements) {
			if(element.forceRefresh(propertyPath)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Object getDefaultValue(String propertyPath) {
		if(elements.isEmpty()) {
			return null;
		}
		return elements.get(0).getDefaultValue(propertyPath);
	}

	public List<ModelElement> getSubElements() {
		return elements;
	}
}
