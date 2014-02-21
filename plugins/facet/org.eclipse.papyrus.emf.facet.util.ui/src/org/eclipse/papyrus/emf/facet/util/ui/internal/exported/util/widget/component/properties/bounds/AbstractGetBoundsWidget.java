/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.bounds;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.util.ui.utils.UIUtils;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;

/**
 * This abstract class provide a simple way to create a composite for the
 * edition of bounds. The {@link Spinner} composite is used for the edition of
 * number.</p>
 * 
 * No error is return because the default value is 0.
 * 
 * @see Spinner
 * @see GetUpperBoundWidget
 * @see GetLowerBoundWidget
 * @since 0.3
 */
public abstract class AbstractGetBoundsWidget extends AbstractWidget {

	private static final int COLUMN_NUMBER = 3;
	private static final int MAX_VALUE = Integer.MAX_VALUE;
	private static final int MIN_VALUE = Integer.MIN_VALUE;
	private static final int INCREMENT = 1;

	private final PropertyElement2<Integer> propertyElement;
	private Spinner spinner;

	/**
	 * Constructor. Initialize the composite with a layout of
	 * {@value #COLUMN_NUMBER} columns.
	 * 
	 * @param parent
	 *            the parent containing this composite.
	 * @param style
	 *            the style of the composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param propertyElement
	 *            the property element that this composite will edit.
	 */
	protected AbstractGetBoundsWidget(final Composite parent,
			final PropertyElement2<Integer> propertyElement) {
		super(parent);
		this.propertyElement = propertyElement;
		this.setLayout(new GridLayout(COLUMN_NUMBER, false));
	}

	/**
	 * @return the propertyElement
	 */
	public PropertyElement getPropertyElement() {
		return this.propertyElement;
	}

	@Override
	protected void addSubWidgets() {
		if ((getLabel() != null) && !"".equals(getLabel())) { //$NON-NLS-1$
			UIUtils.createLabel(this, getLabel());
		}
		createSpinner();
	}

	/**
	 * Creation of a spinner.
	 */
	private void createSpinner() {
		// SPINNER
		final ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(final ModifyEvent event) {
				textModified();
			}
		};
		this.spinner = UIUtils.createSpinner(this, MAX_VALUE, MIN_VALUE,
				INCREMENT, this.propertyElement.isChangeable(), modifyListener);
		final Integer value = this.propertyElement.getValue2();
		if (value != null) {
			setBoundValue(value.intValue());
		}
	}

	/**
	 * Method called when the text is modified.
	 */
	protected void textModified() {
		getPropertyElement().setValue(Integer.valueOf(this.spinner.getText()));
	}

	/**
	 * @return the label. If no label has to be displayed, null or void must be
	 *         returned.
	 */
	protected abstract String getLabel();

	/**
	 * Set the bound value.
	 * 
	 * @param value
	 *            the value to set.
	 */
	public void setBoundValue(final int value) {
		this.spinner.setSelection(value);
	}

	public int getBoundValue() {
		final String text = this.spinner.getText();
		return Integer.parseInt(text);
	}
}
