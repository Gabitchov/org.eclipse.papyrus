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
 */
package org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties;

import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.emf.facet.util.ui.utils.UIUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * This Abstract class provides all the elements to create:</p>
 * 
 * Label : [x]</p>
 * 
 * The label is set by {@link #getLabel()}. The checkbox is initialized with the
 * {@link PropertyElement} attributes
 * <nl>
 * <li>{@link PropertyElement#getValue()} (the value of the property must be a
 * boolean)</li>
 * <li>{@link PropertyElement#isChangeable()}</li>
 * </nl>
 * 
 * The {@link #getError()} method return 'null' because no error can be returned
 * (the value of the checkbox is 'true' or 'false').
 * 
 * @see GetChangeableWidget
 * @see GetOrderedWidget
 * @see GetDerivedWidget
 * @see GetTransientWidget
 * @see GetUniqueWidget
 * @see GetVolatileWidget
 * @since 0.3
 */
public abstract class AbstractGetPropertyWidget extends AbstractWidget {

	private static final int COLUMN_NUMBER = 2;
	private static final int WIDTH_HINT_DEF = 65;
	private int labelWidthHint;
	private final PropertyElement propertyElement;
	private Button propertyButton;

	/**
	 * Constructor. Initialize the composite with a layout of
	 * {@value #COLUMN_NUMBER} columns and the layoutData with the
	 * 'fillGridData' attribute of {@link AbstractWidget}.
	 * 
	 * @param parent
	 *            the parent containing this composite.
	 * @param style
	 *            the style of the composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param propertyElement
	 *            the property element that this composite will edit.
	 * 
	 * @see AbstractWidget
	 */
	protected AbstractGetPropertyWidget(final Composite parent,
			final PropertyElement propertyElement) {
		super(parent);
		this.propertyElement = propertyElement;
		this.labelWidthHint = WIDTH_HINT_DEF;
		this.setLayout(new GridLayout(COLUMN_NUMBER, false));
		this.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	@Override
	protected void addSubWidgets() {
		if ((getLabel() != null) && !"".equals(getLabel())) { //$NON-NLS-1$
			final Label label = UIUtils.createLabel(this, getLabel());
			final GridData layoutData = new GridData(SWT.FILL);
			layoutData.widthHint = this.labelWidthHint;
			label.setLayoutData(layoutData);
			label.setEnabled(this.propertyElement.isChangeable());
		}
		createCheckbox();
	}

	public void setPropertyEnabled(final boolean enabled) {
		this.propertyButton.setSelection(enabled);
	}

	/**
	 * Create a checkbox initialized with the {@link PropertyElement} attributes
	 * <nl>
	 * <li>Default value : {@link PropertyElement#getValue()} (the value of the
	 * property must be a boolean)</li>
	 * <li>Enabled : {@link PropertyElement#isChangeable()}</li>
	 * </nl>
	 */
	private void createCheckbox() {
		if (this.propertyElement.getValue() == null) {
			this.propertyElement.setValue(Boolean.TRUE);
		}
		SelectionListener selectionListener = null;
		if (this.propertyElement.isChangeable()) {
			selectionListener = new SelectionListener() {

				public void widgetSelected(final SelectionEvent event) {
					onSelection((Button) event.getSource());
				}

				public void widgetDefaultSelected(final SelectionEvent event) {
					// Nothing.
				}
			};
		}
		this.propertyButton = UIUtils.createCheckbox(this,
				this.propertyElement.isChangeable(),
				((Boolean) this.propertyElement.getValue()).booleanValue(),
				selectionListener);
	}

	/**
	 * @param source
	 */
	protected void onSelection(final Button source) {
		this.propertyElement.setValue(Boolean.valueOf(source.getSelection()));
	}

	/**
	 * @return the label of the label field. If no label has to be displayed,
	 *         null or void must be returned.
	 */
	protected abstract String getLabel();

	/**
	 * Method to change the distance between the label and the checkbox.
	 * 
	 * @param lABEL_WIDTH_HINT
	 *            the lABEL_WIDTH_HINT to set
	 */
	public void setLabelWidthHint(final int labelWidthHint) {
		this.labelWidthHint = labelWidthHint;
	}

	/**
	 * @return the value of the property.
	 */
	public boolean isSelected() {
		return this.propertyButton.getSelection();
	}
}
