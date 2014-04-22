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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.widgets.messages.Messages;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.MapLabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
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

	protected final Map<Button, Object> values = new HashMap<Button, Object>();

	protected int numColumns = -1;

	private ControlDecoration controlDecoration;

	public EnumRadio(Composite parent, int style) {
		this(parent, SWT.NONE, null);
	}

	public EnumRadio(Composite parent, int style, String label) {
		super(parent, style, label);
		buttonsArea = factory.createComposite(this);
		GridData gridData = getDefaultLayoutData();
		buttonsArea.setLayoutData(gridData);
		GridLayout layout = new GridLayout(1, true);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		buttonsArea.setLayout(layout);
		factory.createCLabel(buttonsArea, Messages.EnumRadio_NoValue);
		controlDecoration = new ControlDecoration(buttonsArea, SWT.TOP | SWT.LEFT);
		gridData.horizontalIndent = FieldDecorationRegistry.getDefault().getMaximumDecorationWidth();

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

		disposeButtons();
		if(widgetObservable != null) {
			widgetObservable.dispose();
		}

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

		setWidgetObservable(observable, true);
		updateLayout();

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

	public void setValue(Object value) {
		if(modelProperty != null) {
			modelProperty.setValue(value);
		}
		if(widgetObservable != null) {
			widgetObservable.setValue(value);
		} else {
			for(Button button : values.keySet()) {
				if(values.get(button) == value) {
					button.setSelection(true);
					return;
				}
			}
		}
	}

	/**
	 * Use a Map instead of content providers to define the selectable elements
	 * The keys are the semantic objects (contentProvider), and the values are
	 * the labels (labelProvider)
	 *
	 * @param objectsAndLabels
	 */
	public void setEnumValues(Map<Object, String> objectsAndLabels) {
		StaticContentProvider provider = new StaticContentProvider(objectsAndLabels.keySet().toArray());
		LabelProvider labelProvider = new MapLabelProvider(objectsAndLabels);
		setProviders(provider, labelProvider);
	}

	@Override
	public void updateStatus(IStatus status) {
		switch(status.getSeverity()) {
		case IStatus.OK:
			controlDecoration.hide();
			break;
		case IStatus.WARNING:
			FieldDecoration warning = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_WARNING);
			controlDecoration.setImage(warning.getImage());
			controlDecoration.showHoverText(status.getMessage());
			controlDecoration.setDescriptionText(status.getMessage());
			controlDecoration.show();
			break;
		case IStatus.ERROR:
			FieldDecoration error = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			controlDecoration.setImage(error.getImage());
			controlDecoration.showHoverText(status.getMessage());
			controlDecoration.setDescriptionText(status.getMessage());
			controlDecoration.show();
			break;
		default:
			controlDecoration.hide();
			break;
		}
	}

}
