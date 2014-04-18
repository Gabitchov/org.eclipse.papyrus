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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.modelelement;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.creation.PropertyEditorFactory;

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

	private final Map<String, IObservable> observables = new HashMap<String, IObservable>();

	
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
		if(!observables.containsKey(propertyPath)) {
			IObservable observable = doGetObservable(propertyPath);
			if(observable != null) {
				observables.put(propertyPath, observable);
			}
		}
		return observables.get(propertyPath);
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
		for(IObservable observable : observables.values()) {
			observable.dispose();
		}
		observables.clear();
	}
	
	public IValidator getValidator(String propertyPath){
		return null;
	}

	
	
}
