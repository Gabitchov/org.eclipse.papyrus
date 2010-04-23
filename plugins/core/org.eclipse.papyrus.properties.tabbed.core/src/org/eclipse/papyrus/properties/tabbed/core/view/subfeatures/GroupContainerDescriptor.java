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
package org.eclipse.papyrus.properties.tabbed.core.view.subfeatures;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Creates a group container
 */
public class GroupContainerDescriptor extends SubFeatureContainerDescriptor {

	/** label of the group */
	protected final String label;

	/** composite managed by this descripor */
	private Group composite;

	/**
	 * Creates a new GroupContainerDescriptor.
	 * 
	 * @param label
	 *        label of the group
	 */
	public GroupContainerDescriptor(String label) {
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContainer(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
		composite = widgetFactory.createGroup(parent, label);
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
}
