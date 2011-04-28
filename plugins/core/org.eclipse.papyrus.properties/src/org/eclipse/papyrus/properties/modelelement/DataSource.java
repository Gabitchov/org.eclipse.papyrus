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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

/**
 * A DataSource is an object encapsulating one or more {@link ModelElement}s.
 * It contains methods to resolve property paths, and forward the methods to
 * the right ModelElement.
 * 
 * For example, a UML class stereotyped with the SysML::Blocks::Block will have
 * two ModelElements : one for UML, and one for the Block stereotype.
 * 
 * It will be able to resolve paths such as UML:Class:name or
 * SysML:Blocks:Block:isEncapsulated
 * 
 * The methods such as isUnique, isEditable or getContentProvider will be
 * delegated to the resolved ModelElement, with a truncated property path.
 * 
 * For example, a call to DataSource#isEditable("UML:Class:name") will be
 * forwarded to UMLModelElement#isEditable("name")
 * 
 * @author Camille Letavernier
 */
public class DataSource implements IChangeListener {

	private Set<IChangeListener> changeListeners = new HashSet<IChangeListener>();

	private List<IObservable> observed = new LinkedList<IObservable>();

	private View view;

	private IStructuredSelection selection;

	private Map<String, ModelElement> elements = new HashMap<String, ModelElement>();

	/**
	 * Constructs a new DataSource from the given view and selection
	 * 
	 * @param view
	 * @param selection
	 * 
	 * @see DataSourceFactory#createDataSourceFromSelection(IStructuredSelection, View)
	 */
	protected DataSource(View view, IStructuredSelection selection) {
		this.view = view;
		this.selection = selection;
	}

	public ModelElement getModelElement(String propertyPath) {
		//ConfigurationManager.instance.getProperty(propertyPath)
		String key = propertyPath.substring(0, propertyPath.lastIndexOf(":")); //$NON-NLS-1$
		ModelElement element = elements.get(key);
		if(element == null) { //Try to resolve the modelElements on-the-fly
			element = DataSourceFactory.instance.getModelElementFromPropertyPath(this, propertyPath);
			if(element == null) {
				Activator.log.warn("Unable to find a ModelElement for " + propertyPath + ". Elements : " + elements); //$NON-NLS-1$ //$NON-NLS-2$
				return null;
			}
		}
		return element;
	}

	private String getLocalPropertyPath(String propertyPath) {
		return propertyPath.substring(propertyPath.lastIndexOf(":") + 1); //$NON-NLS-1$
	}

	/**
	 * Returns an IObservable corresponding to the given property path
	 * The observable may be either an IObservableValue or an IObservableList
	 * The call to this method is delegated to the corresponding ModelElement
	 * 
	 * @param propertyPath
	 *        The property path for which we want to retrieve an ObservableValue
	 * @return
	 *         The IObservable corresponding to the given propertyPath
	 */
	public IObservable getObservable(String propertyPath) {
		String localPropertyPath = getLocalPropertyPath(propertyPath);
		ModelElement element = getModelElement(propertyPath);

		if(element == null)
			return null;

		IObservable observable = element.getObservable(localPropertyPath);
		if(observable != null) {
			observable.addChangeListener(this);
			observed.add(observable);
		}

		return observable;
	}

	@Override
	public String toString() {
		return "[DataSource] " + super.toString(); //$NON-NLS-1$
	}

	/**
	 * Returns an IStaticContentProvider corresponding to the given property path
	 * The call to this method is delegated to the corresponding ModelElement
	 * 
	 * @param propertyPath
	 *        The property path for which we want to retrieve a ContentProvider
	 * @return
	 *         The IStaticContentProvider corresponding to the given propertyPath
	 */
	public IStaticContentProvider getContentProvider(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return EmptyContentProvider.instance;

		String localPropertyPath = getLocalPropertyPath(propertyPath);
		return element.getContentProvider(localPropertyPath);
	}

	/**
	 * Returns an ILabelProvider corresponding to the given property path
	 * The call to this method is delegated to the corresponding ModelElement
	 * 
	 * @param propertyPath
	 *        The property path for which we want to retrieve an ILabelProvider
	 * @return
	 *         The ILabelProvider corresponding to the given propertyPath
	 */
	public ILabelProvider getLabelProvider(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return null;
		String localPropertyPath = getLocalPropertyPath(propertyPath);
		return element.getLabelProvider(localPropertyPath);
	}

	/**
	 * Adds a change listener to this DataSource. The listener will be notified
	 * each time a change occurs on one of the IObservable produced by this DataSource
	 * 
	 * @see DataSource#getObservable(String)
	 * @param listener
	 *        The Change listener
	 */
	public void addChangeListener(IChangeListener listener) {
		changeListeners.add(listener);
	}

	/**
	 * Removes a change listener from this DataSource.
	 * 
	 * @param listener
	 *        The listener to remove
	 * @see DataSource#addChangeListener(IChangeListener)
	 */
	public void removeChangeListener(IChangeListener listener) {
		changeListeners.remove(listener);
	}

	public void handleChange(ChangeEvent event) {
		for(IChangeListener listener : changeListeners) {
			listener.handleChange(event);
		}
	}

	/**
	 * @return The view associated to this DataSource
	 */
	public View getView() {
		return view;
	}

	/**
	 * @return the selection associated to this DataSource
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @param propertyPath
	 * @return
	 *         true if the property represented by this propertyPath is ordered
	 */
	public boolean isOrdered(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.isOrdered(getLocalPropertyPath(propertyPath));
	}

	/**
	 * @param propertyPath
	 * @return
	 *         true if the property represented by this propertyPath is unique
	 */
	public boolean isUnique(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.isUnique(getLocalPropertyPath(propertyPath));
	}

	/**
	 * @param propertyPath
	 * @return
	 *         true if the property represented by this propertyPath is mandatory
	 */
	public boolean isMandatory(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.isMandatory(getLocalPropertyPath(propertyPath));
	}

	/**
	 * @param propertyPath
	 * @return
	 *         true if the property represented by this propertyPath is editable
	 */
	public boolean isEditable(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.isEditable(getLocalPropertyPath(propertyPath));
	}

	public boolean forceRefresh(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return false;
		return element.forceRefresh(getLocalPropertyPath(propertyPath));
	}

	public ReferenceValueFactory getValueFactory(String propertyPath) {
		ModelElement element = getModelElement(propertyPath);
		if(element == null)
			return null;
		return element.getValueFactory(getLocalPropertyPath(propertyPath));
	}
}
