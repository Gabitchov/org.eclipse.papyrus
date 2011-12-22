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

import org.eclipse.papyrus.views.properties.tabbed.core.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Simple container descriptor
 */
public class SimpleContainerDescriptor extends SubFeatureContainerDescriptor {

	/** composite created by this descriptor */
	private Composite composite;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContainer(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
		composite = widgetFactory.createComposite(parent);
		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disposeContainer() {
		if(composite != null && !composite.isDisposed()) {
			composite.dispose();
			composite = null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Simple container";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/SubFeatureContainer.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public SubFeatureContainerDescriptorState createState(boolean readOnly) {
		return new SubFeatureContainerDescriptorState(this, readOnly);
	}
}
