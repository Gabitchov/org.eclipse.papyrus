/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.widgets.messages.Messages;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * An editor representing an Enumeration as a list of Radio Buttons
 * If there are many possible values, it is probably more judicious to use an
 * EnumCombo.
 * This Editor needs a ContentProvider describing the Enumerated values,
 * and an optional label provider.
 * 
 * @author Camille Letavernier
 * 
 * @see EnumCombo
 */
public class EnumRadio extends AbstractValueEditor {

	protected IStaticContentProvider contentProvider;

	protected Composite buttonsArea;

	protected ILabelProvider labelProvider = new LabelProvider();

	protected Map<Button, Object> values = new HashMap<Button, Object>();

	protected int numColumns = -1;

	public EnumRadio(Composite parent, int style) {
		super(parent, SWT.NONE);

		buttonsArea = factory.createComposite(this);
		buttonsArea.setLayoutData(getDefaultLayoutData());
		GridLayout layout = new GridLayout(1, true);

		layout.marginWidth = 0;
		layout.marginHeight = 0;

		buttonsArea.setLayout(layout);
		factory.createCLabel(buttonsArea, Messages.EnumRadio_NoValue);
	}

	/**
	 * Sets the content provider for this editor. The Content provider should
	 * specify the values that can be set for this property
	 * 
	 * @param contentProvider
	 *        The Content provider returning the available values for this editor
	 * @param labelProvider
	 *        The label provider returning a label for each value of the
	 *        content provider. If null, a default label provider will be used
	 */
	public void setProviders(IStaticContentProvider contentProvider, ILabelProvider labelProvider) {
		this.contentProvider = contentProvider;
		if(labelProvider != null) {
			this.labelProvider = labelProvider;
		}
		doBinding();
	}

	protected void disposeButtons() {
		for(Control control : buttonsArea.getChildren()) {
			control.dispose();
		}
		if(binding != null) {
			binding.dispose();
		}
		values.clear();
	}

	@Override
	protected void doBinding() {
		disposeButtons();

		if(modelProperty != null && contentProvider != null) {
			SelectObservableValue observable = new SelectObservableValue();
			for(Object value : contentProvider.getElements()) {
				Button button = factory.createButton(buttonsArea, labelProvider.getText(value), SWT.RADIO);
				button.setBackground(buttonsArea.getBackground()); //For Radio buttons, we need to force the color
				button.setData(value);
				button.setToolTipText(toolTipText);
				IObservableValue buttonObservable = WidgetProperties.selection().observe(button);
				observable.addOption(value, buttonObservable);

				values.put(button, value);
			}

			setWidgetObservable(observable);

			super.doBinding();
		}

		updateLayout();
	}

	/**
	 * Sets the max number of elements per line for this editor
	 * 
	 * @param numColumns
	 *        The max number of elements per line. May be -1 if there should
	 *        be a single line of elements
	 */
	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
		updateLayout();
	}

	private void updateLayout() {
		GridLayout gridLayout = (GridLayout)buttonsArea.getLayout();
		gridLayout.numColumns = numColumns > 0 ? numColumns : values.size();
		gridLayout.makeColumnsEqualWidth = numColumns > 0;

		updateLabelLayout();
	}

	private void updateLabelLayout() {
		if(label == null || label.isDisposed()) {
			return;
		}

		if(numColumns == -1) {
			((GridData)label.getLayoutData()).verticalAlignment = SWT.CENTER;
		} else {
			((GridData)label.getLayoutData()).verticalAlignment = SWT.BEGINNING;
		}
	}

	@Override
	protected void createLabel(String label) {
		super.createLabel(label);
		updateLabelLayout();
	}

	@Override
	public Object getValue() {
		for(Button button : values.keySet()) {
			if(button.getSelection()) {
				return values.get(button);
			}
		}
		return null;
	}

	@Override
	public Object getEditableType() {
		return Object.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		for(Button button : values.keySet()) {
			button.setEnabled(!readOnly);
		}
		buttonsArea.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !buttonsArea.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		for(Button button : values.keySet()) {
			button.setToolTipText(text);
		}
		super.setLabelToolTipText(text);
	}
}
