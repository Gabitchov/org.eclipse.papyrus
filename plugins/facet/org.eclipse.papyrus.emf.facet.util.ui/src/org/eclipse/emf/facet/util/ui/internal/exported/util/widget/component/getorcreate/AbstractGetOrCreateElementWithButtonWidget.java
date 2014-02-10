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
package org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate;

import org.eclipse.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWithButtonWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.emf.facet.util.ui.utils.UIUtils;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Provide all the necessary for the creation of a composite that have: </p>
 * 
 * Label : [ textField ][...] </p>
 * 
 * The button will execute {@link #openDialog()} method when pressed. </p>
 * 
 * The {@link #getLabel()} method have to be override and provide the label of
 * the 'Label'.
 * 
 * @see GetOrCreateFacetSetWidget
 * @see GetOrCreateFacetWidget
 * @see GetOrCreateOperationWidget
 * @since 0.3
 */
public abstract class AbstractGetOrCreateElementWithButtonWidget<T extends Object, D extends Object>
		extends AbstractGetOrCreateElementWidget<T> implements
		IAbstractGetOrCreateElementWithButtonWidget<D> {

	private Button button;
	private boolean buttonEnabled;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param propertyElement
	 *            the property element that be edited with this composite.
	 */
	protected AbstractGetOrCreateElementWithButtonWidget(
			final Composite parent,
			final PropertyElement2<T> propertyElement) {
		super(parent, propertyElement);
		this.setPropertyElement(propertyElement);
		this.setLayout(new GridLayout(COLUMN_NUMBER, false));
		this.buttonEnabled = propertyElement.isChangeable();
	}

	@Override
	protected void addSubWidgets() {
		if ((getLabel() != null) && !"".equals(getLabel())) { //$NON-NLS-1$
			UIUtils.createLabel(this, getLabel());
		}
		createTextField(false);
		createButton();
	}

	public void setButtonEnabled(final boolean buttonEnabled) {
		this.buttonEnabled = buttonEnabled;
		this.button.setEnabled(this.buttonEnabled);
	}

	/**
	 * Create a button [...]. When pressed, the {@link #openDialog()} method is
	 * called.
	 */
	private void createButton() {
		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetSelected(final SelectionEvent selectionEvent) {
				onButtonPressed();
			}

			public void widgetDefaultSelected(
					final SelectionEvent selectionEvent) {
				// Nothing.
			}
		};
		this.button = UIUtils.createButton(this, "...", this.buttonEnabled, //$NON-NLS-1$
				selectionListener);
	}

	/**
	 * The method will be called when the button "..." is pressed.
	 */
	public abstract D onButtonPressed();

	/**
	 * @return the label for this composite. If no label has to be displayed,
	 *         null or void must be returned.
	 */
	protected abstract String getLabel();

	/**
	 * @return the button
	 */
	public Button getButton() {
		return this.button;
	}

	public D pressButton() {
		return onButtonPressed();
	}
}
