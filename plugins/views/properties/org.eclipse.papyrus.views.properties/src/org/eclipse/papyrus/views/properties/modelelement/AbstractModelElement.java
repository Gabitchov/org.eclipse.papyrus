/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.creation.PropertyEditorFactory;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;

/**
 * Provides a default implementation for ModelElement methods applied on the
 * modelElement's properties.
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractModelElement implements ModelElement {

	/**
	 * The DataSource owning this ModelElement
	 */
	protected DataSource dataSource;

	private final List<IObservable> observables = new LinkedList<IObservable>();

	/**
	 * Constructor.
	 */
	protected AbstractModelElement() {
	}

	public IStaticContentProvider getContentProvider(String propertyPath) {
		return EmptyContentProvider.instance;
	}

	public ILabelProvider getLabelProvider(String propertyPath) {
		return null;
	}

	public boolean isOrdered(String propertyPath) {
		return true;
	}

	public boolean isUnique(String propertyPath) {
		return false;
	}

	public boolean isMandatory(String propertyPath) {
		return false;
	}

	public boolean isEditable(String propertyPath) {
		return true;
	}

	public boolean forceRefresh(String propertyPath) {
		return false;
	}

	public void setDataSource(DataSource source) {
		this.dataSource = source;
	}

	/**
	 * Finds the property associated to the given propertyPath
	 * 
	 * @param propertyPath
	 *        The name of the property to retrieve
	 * @return the property associated to the given propertyPath
	 */
	protected Property getProperty(String propertyPath) {
		return ConfigurationManager.instance.getProperty(propertyPath, dataSource.getView().getContext());
	}

	/**
	 * @see org.eclipse.papyrus.views.properties.modelelement.ModelElement#getValueFactory(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return a default factory based on the property view configuration to
	 *         edit objects, as if they were selected in an editor
	 */
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		return new PropertyEditorFactory();
	}

	public Object getDefaultValue(String propertyPath) {
		return null;
	}

	public boolean getDirectCreation(String propertyPath) {
		return false;
	}

	public final IObservable getObservable(String propertyPath) {
		IObservable observable = doGetObservable(propertyPath);
		if(observable != null) {
			observables.add(observable);
		}
		return observable;
	}

	/**
	 * Creates the IObservable for the given propertyPath
	 * 
	 * @param propertyPath
	 *        The path of the property we want to observe
	 * @return
	 *         The new IObservable
	 */
	protected abstract IObservable doGetObservable(String propertyPath);

	public void dispose() {
		for(IObservable observable : observables) {
			observable.dispose();
		}
		observables.clear();
	}

}
