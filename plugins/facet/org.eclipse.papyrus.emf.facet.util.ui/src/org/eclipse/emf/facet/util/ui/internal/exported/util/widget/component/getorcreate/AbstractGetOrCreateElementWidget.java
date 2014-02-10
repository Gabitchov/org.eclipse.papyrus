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

import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractGetElementNameWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.emf.facet.util.ui.utils.UIUtils;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Abstract class for the creation of a composite that allows the selection or
 * creation of an element. Classes implementing this class must overrides
 * {@link #getSubWidgets()} method. This class prepare the composite for
 * {@link #COLUMN_NUMBER} subComposites and provide the method
 * {@link #createTextField(boolean)} for the creation of a textField area.
 * 
 * @see AbstractGetOrCreateElementWithButtonWidget
 * @see AbstractGetElementNameWidget
 * @since 0.3
 */
public abstract class AbstractGetOrCreateElementWidget<T extends Object>
		extends AbstractWidget
		implements IAbstractGetOrCreateElementWidget {

	/**
	 * The number of columns of this composite.
	 */
	public static final int COLUMN_NUMBER = 3;
	private PropertyElement2<T> propertyElement;
	private Text text;

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
	protected AbstractGetOrCreateElementWidget(final Composite parent,
			final PropertyElement2<T> propertyElement) {
		super(parent);
		this.propertyElement = propertyElement;
		this.setLayout(new GridLayout(COLUMN_NUMBER, false));
	}

	/**
	 * @return the property element.
	 */
	public final PropertyElement2<T> getPropertyElement() {
		return this.propertyElement;
	}

	public Text getTextField() {
		return this.text;
	}

	/**
	 * Create the text field in the composite.</p> If the property
	 * {@link #propertyElement} has a value, the field is not editable.
	 * 
	 * @param enabled
	 *            set if the field must be editable or not.
	 */
	protected void createTextField(final boolean enabled) {
		ModifyListener modifyListener = null;
		if (enabled) {
			modifyListener = new ModifyListener() {

				public void modifyText(final ModifyEvent event) {
					onTextModfified();
				}
			};
		}
		String initialText = ""; //$NON-NLS-1$
		if ((this.propertyElement.getValue() != null)
				&& (getTextFieldInitialText() != null)) {
			initialText = getTextFieldInitialText();
		}
		this.text = UIUtils.createTextField(this, initialText, enabled,
				modifyListener);
		fireChanged();
	}

	protected void onTextModfified() {
		this.propertyElement.setValue(this.text.getText().toString());
		onFieldEdited();
	}

	/**
	 * Execute an action when the text field is edited. If not override, nothing
	 * appends. Can be override if needed.
	 */
	protected void onFieldEdited() {
		fireChanged();
	}

	/**
	 * @return the initial text of the textField of this composite. Null or void
	 *         if no text has to be displayed.
	 */
	protected String getTextFieldInitialText() {
		String result = ""; //$NON-NLS-1$
		final Object value = this.getPropertyElement().getValue();
		if (value != null) {
			result = value.toString();
		}
		return result;
	}

	@Override
	public String getError() {
		String error = null;
		final Object value = this.propertyElement.getValue();
		if (value == null && !this.propertyElement.isCanBeNull()) {
			error = getErrorMessage();
		}
		return error;
	}

	/**
	 * @return the error message if the {@link #propertyElement} is not edited.
	 *         Return 'null' if no error can be returned.
	 */
	protected abstract String getErrorMessage();

	/**
	 * @param propertyElement
	 *            the propertyElement to set
	 */
	public void setPropertyElement(final PropertyElement2<T> propertyElement) {
		this.propertyElement = propertyElement;
	}

	public T getElement() {
		return getPropertyElement().getValue2();
	}

	public String getText() {
		return this.text.getText();
	}

	public void setText(final String text) {
		this.text.setText(text);
	}

}
