/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures;

import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Descriptor for containers for subfeatures section
 */
public abstract class SubFeatureContainerDescriptor implements IConfigurableDescriptor {

	/**
	 * Creates the container for the section (sub feature)
	 * 
	 * @param parent
	 *        parent of created composite
	 * @param widgetFactory
	 *        widgetFactory used to create composite
	 * @return the newly create composite
	 */
	public abstract Composite createContainer(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory);

	/**
	 * Dispose the main container managed by this descriptor
	 */
	public abstract void disposeContainer();

	/**
	 * {@inheritDoc}
	 */
	public abstract SubFeatureContainerDescriptorState createState(boolean readOnly);

}
