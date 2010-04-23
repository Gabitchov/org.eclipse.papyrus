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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Creates an expandable container
 */
public class ExpandableContainerDescriptor extends SubFeatureContainerDescriptor {

	/** label of the bar */
	protected final String label;

	/** main composite described by this descriptor */
	protected Section section;

	/**
	 * Creates a new ExpandableContainerDescriptor.
	 * 
	 */
	public ExpandableContainerDescriptor(String label) {
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContainer(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
		section = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Composite expandableContainer = widgetFactory.createComposite(section);
		section.setText(label);

		widgetFactory.paintBordersFor(expandableContainer);
		section.setClient(expandableContainer);

		return expandableContainer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disposeContainer() {
		if(section != null && !section.isDisposed()) {
			section.dispose();
			section = null;
		}
	}
}
