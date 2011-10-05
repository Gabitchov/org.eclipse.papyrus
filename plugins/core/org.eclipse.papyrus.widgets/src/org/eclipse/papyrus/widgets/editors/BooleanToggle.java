/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class BooleanToggle extends AbstractValueEditor {

	private Button toggleButton;

	private BooleanToggle(Composite parent, int style, String label, Image image, String text) {
		super(parent, SWT.NONE, label);

		toggleButton = factory.createButton(this, null, style | SWT.TOGGLE);
		setWidgetObservable(WidgetProperties.selection().observe(toggleButton));
		setCommitOnFocusLost(toggleButton);

		setText(text);
		setImage(image);
	}

	public BooleanToggle(Composite parent, int style, String label, String text) {
		this(parent, style, label, null, text);
	}

	public BooleanToggle(Composite parent, int style, String label, Image image) {
		this(parent, style, label, image, null);
	}

	public BooleanToggle(Composite parent) {
		this(parent, SWT.NONE, null, null, null);
	}

	public BooleanToggle(Composite parent, int style) {
		this(parent, style, null, null, null);
	}

	public void setText(String text) {
		if(text != null)
			toggleButton.setText(text);
	}

	public void setImage(Image image) {
		if(image != null)
			toggleButton.setImage(image);
	}

	@Override
	public Object getValue() {
		return toggleButton.getSelection();
	}

	@Override
	public Object getEditableType() {
		return Boolean.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		toggleButton.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !toggleButton.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		toggleButton.setToolTipText(text);
		setLabelToolTipText(text);
	}

}
