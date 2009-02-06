/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml2.figures;

import org.eclipse.papyrus.tabbedproperties.core.forms.AbstractControlsGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * UML Role (Property) editor.
 * 
 * @author dumoulin
 * 
 */
public class RolesFigure extends AbstractControlsGroup {

	@Override
	public void createDirectChildren() {
	}

	@Override
	public Composite createLocalControls(Composite parent) {
		// Surrounding parent.
		// Used to have a different left and rigth border.
		Composite topLevel = getWidgetFactory().createComposite(parent);
		topLevel.setLayout(new FormLayout());

		// Nested composite where the roles will be drawn
		Composite composite = getWidgetFactory().createComposite(topLevel);
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		// Following line can be used to have the same margin left and right
		// layout.marginWidth = 12;
		layout.spacing = 10;
		composite.setLayout(layout);

		// Set a different left and right marging
		FormData data = new FormData();
		// FormAttachment(percentagePosition, offset);
		// left : change offset to have a left marging
		data.left = new FormAttachment(0, 20);
		// right : change offset to have a right marging
		data.right = new FormAttachment(100, -40);
		composite.setLayoutData(data);

		// debug : Add a label
		// The label, placed
		//        CLabel labelLabel = getWidgetFactory().createCLabel(composite, "Roles properties"); //$NON-NLS-1$

		return composite;
	}

	@Override
	public void initializeLocalControl() {

	}
}
