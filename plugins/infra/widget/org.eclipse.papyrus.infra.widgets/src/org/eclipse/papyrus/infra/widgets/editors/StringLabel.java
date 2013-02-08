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
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

/**
 * A Read only widget to display Strings as a CLabel.
 * May also be used to display an Object with an ILabelProvider
 * 
 * @author Camille Letavernier
 */
public class StringLabel extends AbstractValueEditor implements IChangeListener {

	private final CLabel valueLabel;

	private ILabelProvider labelProvider;

	private Object value;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite widget in which this editor is created
	 * @param style
	 *        The style to be applied to this editor's CLabel
	 */
	public StringLabel(final Composite parent, final int style) {
		super(parent, style);
		this.valueLabel = factory.createCLabel(this, "", style); //$NON-NLS-1$
		this.valueLabel.setLayoutData(getDefaultLayoutData());
		this.labelProvider = new LabelProvider();
	}

	/**
	 * @return
	 *         The CLabel used to display this editor's value
	 */
	public CLabel getValueLabel() {
		return this.valueLabel;
	}

	/**
	 * Sets the label provider for this editor. Useful when the value is not a
	 * String
	 * 
	 * @param labelProvider
	 *        The Label provider used to display the current value
	 */
	public void setLabelProvider(final ILabelProvider labelProvider) {
		if(labelProvider == null) {
			return;
		}

		this.labelProvider = labelProvider;
		if(this.binding != null) {
			this.binding.updateModelToTarget();
		}
	}

	@Override
	public void doBinding() {
		//We don't do a real databinding here
		this.modelProperty.addChangeListener(this);
		valueLabel.addDisposeListener(this);
		updateLabel();
	}

	/**
	 * Updates the CLabel's display
	 */
	protected void updateLabel() {
		if(valueLabel.isDisposed()) {
			Activator.log.warn("Widget is disposed"); //$NON-NLS-1$
			return;
		}

		Object value = getValue();

		String text = this.labelProvider.getText(value);
		Image image = this.labelProvider.getImage(value);

		this.valueLabel.setText(text);
		this.valueLabel.setImage(image);
	}

	@Override
	public Object getValue() {
		if(modelProperty != null) {
			return modelProperty.getValue();
		}
		return value;
	}

	public void setValue(Object value) {
		if(modelProperty != null) {
			modelProperty.setValue(value);
		}
		this.value = value;

		updateLabel();
	}

	@Override
	public Object getEditableType() {
		return String.class;
	}

	@Override
	public void setReadOnly(final boolean readOnly) {
		//Nothing
	}

	@Override
	public boolean isReadOnly() {
		return !this.valueLabel.isEnabled();
	}

	@Override
	public void setToolTipText(final String text) {
		this.valueLabel.setToolTipText(text);
		super.setLabelToolTipText(text);
	}

	public void handleChange(final ChangeEvent event) {
		updateLabel();
	}

	@Override
	public void dispose() {
		if(this.modelProperty != null) {
			this.modelProperty.removeChangeListener(this);
		}
		super.dispose();
	}

	@Override
	public void refreshValue() {
		updateLabel();
	}
}
