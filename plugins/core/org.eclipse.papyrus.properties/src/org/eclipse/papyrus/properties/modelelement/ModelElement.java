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

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

/**
 * An interface representing Model Elements. A ModelElement is associated to a
 * DataContextElement, and should provide access to all properties for a given
 * object, though the mean of {@link IObservable}s. It should also be able to
 * provide informations about each property, such as a ContentProvider for
 * references.
 * 
 * @author Camille Letavernier
 */
public interface ModelElement {

	/**
	 * Returns an IObservable for the given propertyPath. The IObservable
	 * may be either an IObservableValue or an IObservableList.
	 * 
	 * @param propertyPath
	 *        The property for which we need an IObservable
	 * @return
	 *         The IObservable corresponding to the given propertyPath
	 */
	public IObservable getObservable(String propertyPath);

	/**
	 * Returns an IStaticContentProvider for the given propertyPath. The
	 * returned value should not be null. If there is no content provider,
	 * used {@link EmptyContentProvider#instance}
	 * 
	 * @param propertyPath
	 *        The name of the property for which we want a Content provider
	 * @return
	 *         The IStaticContentProvider containing the available values for
	 *         the given property
	 */
	public IStaticContentProvider getContentProvider(String propertyPath);

	/**
	 * Returns an ILabelProvider for the given propertypath, or null if
	 * a default LabelProvider should be used.
	 * 
	 * @param propertyPath
	 * @return
	 */
	public ILabelProvider getLabelProvider(String propertyPath);

	/**
	 * Returns true if the given property should be ordered. Only relevant
	 * for Collection properties.
	 * 
	 * @param propertyPath
	 * @return
	 */
	public boolean isOrdered(String propertyPath);

	/**
	 * Returns true if the elements from the given property should be unique.
	 * Only relevant for Colleciton properties.
	 * 
	 * @param propertyPath
	 * @return
	 */
	public boolean isUnique(String propertyPath);

	/**
	 * Returns true if the given property is Mandatory.
	 * 
	 * @param propertyPath
	 * @return
	 */
	public boolean isMandatory(String propertyPath);

	/**
	 * Returns true if the given property is editable.
	 * 
	 * @param propertyPath
	 * @return
	 */
	public boolean isEditable(String propertyPath);

	/**
	 * Returns true if the given property should be refresh each time a change
	 * occurs in the property view. May help when the IObservable doesn't
	 * catch some change events (For example, for some Ecore derived
	 * properties).
	 * 
	 * @param localPropertyPath
	 * @return
	 */
	public boolean forceRefresh(String localPropertyPath);

	public void setDataSource(DataSource source);
}
