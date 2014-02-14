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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.metaclass;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.emf.facet.util.ui.utils.UIUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * This class provide the composite:</p>
 * 
 * Label : [x] [/TextField/] [...]</p>
 * 
 * The text field is not directly editable by will be edit by the result of the
 * type selection. The {@link GetConformanceMetaclassWidget} composite is used
 * in this composite.</p>
 * 
 * When the checkbox is selected, the button for the conformance type selection
 * is enabled.
 * 
 * @see GetConformanceMetaclassWidget
 */
public class SelectSubTypingTypeWidget extends AbstractWidget {

	private static final int COLUMN_NUMBER = 2;
	private final PropertyElement2<ETypedElement> propertyElement;
	private GetSubTypingTypeWidget conformanceWidget;
	private Button checkbox;
	private final EditingDomain editingDomain;
	private final EClass context;
	private final Facet facet;

	public SelectSubTypingTypeWidget(final Composite parent,
			final PropertyElement2<ETypedElement> propertyElement,
			final EditingDomain editingDomain, final EClass context,
			final Facet facet) {
		super(parent);
		this.setLayout(new GridLayout(COLUMN_NUMBER, false));
		this.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.propertyElement = propertyElement;
		this.editingDomain = editingDomain;
		this.context = context;
		this.facet = facet;
	}

	/**
	 * @return the checkbox
	 */
	public Button getCheckbox() {
		return this.checkbox;
	}

	@Override
	protected void addSubWidgets() {
		boolean enabled = false;
		if (this.propertyElement.getValue() != null) {
			enabled = true;
		}
		createCheckbox(enabled);
		this.conformanceWidget = new GetSubTypingTypeWidget(this,
				this.propertyElement, this.editingDomain, this.context,
				this.facet);
		addSubWidget(this.conformanceWidget);
	}

	/**
	 * Create a checkbox in the composite. When the checkbox is selected, the
	 * button for the conformance type selection is enabled.
	 * 
	 * @param enabled
	 */
	private void createCheckbox(final boolean enabled) {
		final Composite composite = new Composite(this, SWT.NONE);
		final GridLayout gridLayout = new GridLayout(COLUMN_NUMBER, false);
		gridLayout.marginWidth = 0;
		composite.setLayout(gridLayout);

		UIUtils.createLabel(composite,
				Messages.CreateFacetInFacetSetWizardPage_Sub_Typing_Facet);

		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetSelected(final SelectionEvent event) {
				onWidgetSelected();
			}

			public void widgetDefaultSelected(final SelectionEvent event) {
				// NOTHING
			}
		};
		this.checkbox = UIUtils.createCheckbox(composite, true, enabled,
				selectionListener);
	}

	@Override
	public String getError() {
		String error = null;

		if (SelectSubTypingTypeWidget.this.getCheckbox().getSelection()) {
			error = this.conformanceWidget.getError();
		}

		return error;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	/**
	 * Set the value of the checkbox.
	 * 
	 * @param selected
	 *            the value of the selection.
	 */
	public void setSelection(final boolean selected) {
		this.checkbox.setSelection(selected);
		onWidgetSelected();
	}

	public IDialog<IGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object>> pressButton() {
		return this.conformanceWidget.pressButton();
	}

	public String getSubTypingText() {
		return this.conformanceWidget.getText();
	}

	protected void onWidgetSelected() {
		SelectSubTypingTypeWidget.this.conformanceWidget.getButton()
				.setEnabled(
						SelectSubTypingTypeWidget.this.getCheckbox()
								.getSelection());
	}

}
