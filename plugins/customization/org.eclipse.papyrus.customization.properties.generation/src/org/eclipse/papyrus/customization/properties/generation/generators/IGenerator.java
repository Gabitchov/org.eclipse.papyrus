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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Strategy improvement of generated files
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.generation.generators;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

/**
 * A Generator is intended to output a partial Context model.
 * This context model should only contain DataContextElements and Properties
 * (i.e. it should not contain any View or Tabs)
 * The Generator should also implement an heuristic, which will determine
 * for each Property if it should be displayed in the Property view or not,
 * for both Single and Multiple selection
 *
 * @author Camille Letavernier
 *
 */
public interface IGenerator {

	/**
	 * Generates the partial context, and persists it to the given target URI
	 *
	 * @param targetURI
	 * @return The generated Context
	 */
	public List<Context> generate(List<URI> targetURI);

	/**
	 * Creates the controls for this Generator. The generator is responsible
	 * for displaying any Control useful for editing its options, and listening
	 * for changes on them.
	 *
	 * @param parent
	 *        The Composite in which the controls will be displayed
	 */
	public void createControls(Composite parent);

	/**
	 * Gets the description for this Generator
	 *
	 * @return The description
	 */
	public String getDescription();

	/**
	 * Tests if this Generator's settings are all set and valid
	 *
	 * @return true if all options are set and valid
	 */
	public boolean isReady();

	/**
	 * Gets the name for this Generator
	 *
	 * @return The name
	 */
	public String getName();

	/**
	 * Tests if a field should be displayed for this Property when
	 * exactly one instance of this property's parent element is selected.
	 *
	 * @param property
	 * @return
	 */
	public boolean isSelectedSingle(Property property);

	/**
	 * Tests if a field should be displayed for this Property when
	 * at least two instances of this property's parent element are selected.
	 *
	 * @param property
	 * @return
	 */
	public boolean isSelectedMultiple(Property property);

	/**
	 * Tests if a field should be displayed for this Property when
	 * exactly one instance of the given element is selected. The difference
	 * with {@link #isSelectedSingle(Property)} is that this method takes the inheritance
	 * into account, i.e. the property belongs to a Superclass of the given DataContextElement
	 *
	 * @param property
	 * @param element
	 * @return
	 */
	public boolean isSelectedSingle(Property property, DataContextElement element);

	/**
	 * Tests if a field should be displayed for this Property when
	 * at least two instances of the given element are selected. The difference
	 * with {@link #isSelectedMultiple(Property)} is that this method takes the inheritance
	 * into account, i.e. the property belongs to a Superclass of the given DataContextElement
	 *
	 * @param property
	 * @param element
	 * @return
	 */
	public boolean isSelectedMultiple(Property property, DataContextElement element);

	/**
	 * Adds a Change Listener to this generator. The Listener should be notified
	 * each time the generator's {@link #isReady()} value changes
	 *
	 * @param listener
	 */
	public void addListener(Listener listener);

	/**
	 * Removes a Change Listener from this generator.
	 *
	 * @param listener
	 */
	public void removeListener(Listener listener);

	public List<Object> getExternalReference();

	public IObservableValue getObservableValue();

	public void setStrategy(int strategy);

	public void addCheckElement(Object obj);

}
