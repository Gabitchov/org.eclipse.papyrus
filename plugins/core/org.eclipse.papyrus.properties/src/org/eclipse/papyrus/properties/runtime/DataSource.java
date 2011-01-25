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
package org.eclipse.papyrus.properties.runtime;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.util.Util;
import org.eclipse.papyrus.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

/**
 * In case of Multi-selection, do we need to use several data sources?
 */
public class DataSource implements IChangeListener {

	private Set<IChangeListener> changeListeners = new HashSet<IChangeListener>();

	private List<IObservable> observed = new LinkedList<IObservable>();

	private View view;


	private Map<String, List<ModelElement>> elements = new HashMap<String, List<ModelElement>>();

	//UML:Class -> [EMFModelElement]
	//SysML:Blocks:Block -> [StereotypeModelElement]
	//Profile:MyStereotype -> [StereotypeModelElement, StereotypeModelElement, StereotypeModelElement] //Unsupported in Papyrus yet ; a Stereotype can only be applied once on a given element

	//Multiselection : UML:Class -> [EMFModelElement, EMFModelElement, EMFModelElement]
	public DataSource(View view) {
		this.view = view;
	}

	public boolean hasModelElement(String key) {
		return elements.containsKey(key);
	}

	public ModelElement getModelElement(String propertyPath) {
		//Known modelElement : UML:Class
		//Key : UML:Class:isAbstract (Unknown property)
		//Key : UML:Classifier:isAbstract (Unknown modelElement)
		String key = propertyPath.substring(0, propertyPath.lastIndexOf(":")); //$NON-NLS-1$
		List<ModelElement> allElements = elements.get(key);
		if(allElements == null) { //Search super elements
			Activator.log.warn("Unable to find a ModelElement for " + propertyPath + ". Elements : " + elements); //$NON-NLS-1$ //$NON-NLS-2$
			return null;
		}
		return allElements.get(0);
	}

	public String getLabel(String propertyPath) {
		String localPropertyPath = getLocalPropertyPath(propertyPath);
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return ""; //$NON-NLS-1$

		String label = element.getLabel(localPropertyPath);
		if(label == null || label.trim().equals("")) { //$NON-NLS-1$
			return getDefaultLabel(propertyPath);
		}
		return label;
	}

	private String getDefaultLabel(String propertyPath) {
		return Util.getLabel(getLocalPropertyPath(propertyPath));
	}

	private String getLocalPropertyPath(String propertyPath) {
		return propertyPath.substring(propertyPath.lastIndexOf(":") + 1); //$NON-NLS-1$
	}

	public IObservable getObservable(String propertyPath) {
		String localPropertyPath = getLocalPropertyPath(propertyPath);
		ModelElement element = getModelElement(propertyPath);

		if(element == null)
			return null;

		IObservable observable = element.getObservable(localPropertyPath);
		observable.addChangeListener(this);
		observed.add(observable);

		return observable;
	}

	public void addModelElement(String key, ModelElement element) {
		if(elements.get(key) == null) {
			elements.put(key, new LinkedList<ModelElement>());
		}
		elements.get(key).add(element);
	}

	public void addModelElements(String key, Collection<ModelElement> modelElements) {
		if(elements.get(key) == null) {
			elements.put(key, new LinkedList<ModelElement>());
		}

		elements.get(key).addAll(modelElements);
	}

	@Override
	public String toString() {
		return "[DataSource] " + elements.toString(); //$NON-NLS-1$
	}

	public IStaticContentProvider getContentProvider(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return EmptyContentProvider.instance;

		String localPropertyPath = getLocalPropertyPath(propertyPath);
		return element.getContentProvider(localPropertyPath);
	}

	public ILabelProvider getLabelProvider(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return null;
		String localPropertyPath = getLocalPropertyPath(propertyPath);
		return element.getLabelProvider(localPropertyPath);
	}

	public void addChangeListener(IChangeListener listener) {
		changeListeners.add(listener);
	}

	public void removeChangeListener(IChangeListener listener) {
		changeListeners.remove(listener);
	}

	public void dispose() {
		for(IObservable observable : observed) {
			observable.removeChangeListener(this);
		}
		observed.clear();
	}

	public void handleChange(ChangeEvent event) {
		for(IChangeListener listener : changeListeners) {
			listener.handleChange(event);
		}
	}

	public void setView(View view) {
		this.view = view;
	}

	public View getView() {
		return view;
	}

	public List<ModelElement> getModelElements() {
		List<ModelElement> result = new LinkedList<ModelElement>();
		for(List<ModelElement> elementsList : this.elements.values()) {
			result.addAll(elementsList);
		}
		return result;
	}

	public Map<String, List<ModelElement>> getModelElementsMapping() {
		return elements;
	}

	public boolean isOrdered(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.isOrdered(getLocalPropertyPath(propertyPath));
	}

	public boolean isUnique(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.isUnique(getLocalPropertyPath(propertyPath));
	}

	public boolean isMandatory(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.isMandatory(getLocalPropertyPath(propertyPath));
	}

	public boolean isEditable(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.isEditable(getLocalPropertyPath(propertyPath));
	}
}
