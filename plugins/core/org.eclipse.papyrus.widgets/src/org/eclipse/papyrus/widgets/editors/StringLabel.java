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

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
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
		valueLabel = factory.createCLabel(this, "", style); //$NON-NLS-1$
		valueLabel.setLayoutData(getDefaultLayoutData());
		labelProvider = new LabelProvider();
	}

	/**
	 * @return
	 *         The CLabel used to display this editor's value
	 */
	public CLabel getValueLabel() {
		return valueLabel;
	}

	/**
	 * Sets the label provider for this editor. Useful when the value is not a
	 * String
	 * 
	 * @param labelProvider
	 *        The Label provider used to display the current value
	 */
	public void setLabelProvider(final ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
		if(binding != null) {
			binding.updateModelToTarget();
		}
	}

	@Override
	public void doBinding() {
        //We don't do a real databinding here
		modelProperty.addChangeListener(this);
		updateLabel();
	}

	/**
	 * Updates the CLabel's display
	 */
	protected void updateLabel() {
		if(modelProperty != null) {
			String text = labelProvider.getText(modelProperty.getValue());
			Image image = labelProvider.getImage(modelProperty.getValue());
			valueLabel.setText(text);
			valueLabel.setImage(image);
		}
	}

	@Override
	public Object getValue() {
		return valueLabel.getText();
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
		return !valueLabel.isEnabled();
	}

	@Override
	public void setToolTipText(final String text) {
		valueLabel.setToolTipText(text);
		super.setLabelToolTipText(text);
	}

	public void handleChange(final ChangeEvent event) {
		updateLabel();
	}

	@Override
	public void dispose() {
		if(modelProperty != null) {
			modelProperty.removeChangeListener(this);
		}
		super.dispose();
	}

	@Override
	public void refreshValue() {
		updateLabel();
	}
}
