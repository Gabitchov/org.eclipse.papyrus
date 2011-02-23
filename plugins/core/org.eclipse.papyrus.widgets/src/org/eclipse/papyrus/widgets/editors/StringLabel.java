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

import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

/**
 * A Read only widget to display Strings as a CLabel.
 * 
 * @author Camille Letavernier
 */
public class StringLabel extends AbstractValueEditor {

	private CLabel valueLabel;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite widget in which this editor is created
	 * @param style
	 *        The style to be applied to this editor's CLabel
	 */
	public StringLabel(Composite parent, int style) {
		super(parent, style);
		valueLabel = factory.createCLabel(this, "", style);
		valueLabel.setLayoutData(getDefaultLayoutData());
		setWidgetObservable(WidgetProperties.text().observe(valueLabel));
	}

	/**
	 * @return
	 *         The CLabel used to display this editor's value
	 */
	public CLabel getValueLabel() {
		return valueLabel;
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
	public void setReadOnly(boolean readOnly) {
		//Nothing
	}

	@Override
	public boolean isReadOnly() {
		return !valueLabel.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		valueLabel.setToolTipText(text);
		super.setLabelToolTipText(text);
	}

}
