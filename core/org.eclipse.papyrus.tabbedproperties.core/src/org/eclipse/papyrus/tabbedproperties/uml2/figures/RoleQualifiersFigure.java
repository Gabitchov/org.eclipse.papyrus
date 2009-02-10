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
import org.eclipse.papyrus.tabbedproperties.core.forms.CheckBoxFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * A figure with the two qualifiers of a role.
 * 
 * @author dumoulin
 * 
 */
public class RoleQualifiersFigure extends AbstractControlsGroup {

	private CheckBoxFigure navigable;

	private CheckBoxFigure derived;

	/**
     * 
     */
	@Override
	public void createDirectChildren() {
		navigable = new CheckBoxFigure("isNavigable");
		add(navigable);
		derived = new CheckBoxFigure("isDerived");
		add(derived);

	}

	/**
	 * Create the composite used to lay children.
	 */
	@Override
	public Composite createLocalControls(Composite parent) {
		Composite composite = getWidgetFactory().createComposite(parent);
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.spacing = ITabbedPropertyConstants.HSPACE;
		composite.setLayout(layout);

		return composite;
	}

	/**
	 * @return the navigable
	 */
	public CheckBoxFigure getNavigable() {
		return navigable;
	}

	/**
	 * @return the derived
	 */
	public CheckBoxFigure getDerived() {
		return derived;
	}

}
