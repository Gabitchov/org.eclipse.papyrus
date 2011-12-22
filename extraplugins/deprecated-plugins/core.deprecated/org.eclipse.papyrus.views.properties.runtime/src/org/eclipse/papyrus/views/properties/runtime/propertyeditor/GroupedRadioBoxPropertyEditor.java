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
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;


/**
 * Property editors for enumeration
 */
public class GroupedRadioBoxPropertyEditor extends RadioBoxPropertyEditor {

	/**
	 * Creates a new RadioBoxPropertyEditor
	 */
	public GroupedRadioBoxPropertyEditor() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent) {
		composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);
		composite.setLayoutData(data);

		// creates the group (label is the getLabel() value)
		Group group = getWidgetFactory().createGroup(composite, getDescriptor().getLabel());
		GridLayout layout2 = new GridLayout(getColumnNumber(), true);
		group.setLayout(layout2);

		// layout in the group => number of column derived from the number of line ?

		// create the set of radio-boxes. Does not know the size of the grid used for this editor
		for(String value : values) {
			Button button = getWidgetFactory().createButton(group, (!value.equals("") ? value : "<Unset>"), SWT.RADIO);
			button.addSelectionListener(listener);
			buttons.add(button);
			button.setToolTipText(getTooltipText());
		}

		return composite;
	}

	/**
	 * Returns the number of column for the composite
	 * 
	 * @return the number of column for the composite
	 */
	protected int getColumnNumber() {
		return (values.size() + ((((getDescriptor().getLabelPosition() & SWT.RIGHT | SWT.LEFT)) != 0) ? 1 : 0)) / getLineNumber();
	}

	/**
	 * Returns the number of line required in the group
	 * 
	 * @return the number of line required in the group
	 */
	protected int getLineNumber() {
		return 3;
	}
}
