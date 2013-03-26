/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Use URIs to support non-URL-compatible storage (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.modelelement.DataSource;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;

/**
 * An interface representing a Display Engine.
 * A Display Engine is responsible for displaying {@link Section}s in a given Composite.
 * It is also responsible for retrieving the {@link ITabDescriptor}s for a given set of {@link View}s
 * 
 * @author Camille Letavernier
 */
public interface DisplayEngine {

	/**
	 * Returns a list of ITabDescriptors for the given set of Views.
	 * The list of tabs is retrieved by navigating the views' sections
	 * 
	 * @param views
	 *        The views from which to retrieve the tab descriptors
	 * @return
	 *         The tab descriptors corresponding to the given views
	 */
	public List<ITabDescriptor> getTabDescriptors(Set<View> views);

	/**
	 * Displays the section in the given parent Composite, and binds the widgets
	 * to the given DataSource.
	 * 
	 * @param parent
	 *        The Composite widget in which the section is displayed
	 * @param section
	 *        The section to display
	 * @param source
	 *        The DataSource to bind to the section's widgets.
	 * @return
	 *         The generated Control
	 */
	public Control createSection(Composite parent, Section section, DataSource source);

	/**
	 * Displays the section in the given parent Composite. The section is loaded from
	 * the given URL instead of the section's sectionFile.
	 * 
	 * @param parent
	 *        The Composite widget in which the section is displayed. Should not be null
	 * @param section
	 *        The section to display. Should not be null
	 * @param sectionFile
	 *        The URI replacing the section's sectionFile. If null, the section's sectionFile will
	 *        be used
	 * @param source
	 *        The DataSource to bind to the section's widgets. May be null.
	 * @return
	 *         The generated Control
	 */
	public Control createSection(Composite parent, Section section, URI sectionFile, DataSource source);

	/**
	 * Refresh the given section.
	 * 
	 * @param parent
	 *        The Composite in which the section should be displayed.
	 * @param section
	 *        The section to display.
	 * @param source
	 *        The DataSource to bind to the section's widgets.
	 */
	public void refreshSection(Composite parent, Section section, DataSource source);

	/**
	 * Dispose the section's contents.
	 * 
	 * @param self
	 *        The Composite containing the section's Control.
	 */
	public void removeSection(Composite self);

	/**
	 * Disposes this display engine
	 */
	public void dispose();
}
