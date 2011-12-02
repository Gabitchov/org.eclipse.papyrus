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

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

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
	 * The IObservable objects returned by this method may be shared by
	 * many instances, which means they should not be disposed directly.
	 * They will be disposed when this ModelElement is disposed.
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
	 * use {@link EmptyContentProvider#instance}
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
	 *         the LabelProvider for the given path
	 */
	public ILabelProvider getLabelProvider(String propertyPath);

	/**
	 * Returns true if the given property should be ordered. Only relevant
	 * for Collection properties.
	 * 
	 * @param propertyPath
	 * @return
	 *         true is the property should be ordered
	 */
	public boolean isOrdered(String propertyPath);

	/**
	 * Returns true if the elements from the given property should be unique.
	 * Only relevant for Colleciton properties.
	 * 
	 * @param propertyPath
	 * @return
	 *         true if the elements should be unique
	 */
	public boolean isUnique(String propertyPath);

	/**
	 * Returns true if the given property is Mandatory.
	 * 
	 * @param propertyPath
	 * @return true if the property is mandatory
	 */
	public boolean isMandatory(String propertyPath);

	/**
	 * Returns true if the given property is editable.
	 * 
	 * @param propertyPath
	 * @return true if the given property is editable.
	 */
	public boolean isEditable(String propertyPath);

	/**
	 * Returns true if the given property should be refreshed each time a
	 * change occurs in the property view. This may help when the IObservable
	 * doesn't catch some change events (For example, for some Ecore derived
	 * properties).
	 * 
	 * @param propertyPath
	 * @return true if the refresh should be forced
	 */
	public boolean forceRefresh(String propertyPath);

	/**
	 * Sets the DataSource associated to this model element
	 * 
	 * @param source
	 *        The DataSource to associate to this model element
	 */
	public void setDataSource(DataSource source);

	/**
	 * @param propertyPath
	 *        the propertyPath to lookup
	 * @return the default factory used to handle operations such as object
	 *         creation or edition, or null if these operations are not supported.
	 *         This factory will typically be used by Multiple value editors, to
	 *         create or edit a single entry.
	 */
	public ReferenceValueFactory getValueFactory(String propertyPath);

	/**
	 * @param propertyPath
	 * @return The default value for the property
	 */
	public Object getDefaultValue(String propertyPath);

	/**
	 * Indicates if the widget should be use the direct creation.
	 * The direct edition will disable the possibility to browse
	 * existing elements when the "add" button is pressed.
	 * 
	 * This is essentially relevant for containment references : this method
	 * should return false if the widget should only allow creation of new
	 * elements.
	 * 
	 * @param propertyPath
	 * @return True if the widget should use the direct edition option for the given property
	 * 
	 */
	public boolean getDirectCreation(String propertyPath);

	/**
	 * Disposes this ModelElement
	 * All created IObservable will be disposed
	 */
	public void dispose();
}
