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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A widget to represent boolean values as a Toggle Button.
 * The Button may have either an Icon or a Text
 * 
 * @author Camille Letavernier
 * 
 */
public class BooleanToggle extends AbstractValueEditor {

	private Button toggleButton;
	private ControlDecoration controlDecoration;

	private BooleanToggle(Composite parent, int style, String label, Image image, String text) {
		super(parent, SWT.NONE, label);

		toggleButton = factory.createButton(this, null, style | SWT.TOGGLE);
		setWidgetObservable(WidgetProperties.selection().observe(toggleButton));
		setCommitOnFocusLost(toggleButton);
		GridData gridData = new GridData();
		toggleButton.setLayoutData(gridData);

		toggleButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				commit();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing
			}
		});

		setText(text);
		setImage(image);
		gridData.horizontalIndent = FieldDecorationRegistry.getDefault().getMaximumDecorationWidth();
		
		controlDecoration = new ControlDecoration(toggleButton, SWT.TOP | SWT.LEFT );
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

	/**
	 * Sets this button's text
	 * 
	 * @param text
	 *        The text to set to this button
	 */
	public void setText(String text) {
		if(text != null) {
			toggleButton.setText(text);
		}
	}

	/**
	 * Sets this button's image
	 * 
	 * @param image
	 *        The image to set to this button
	 */
	public void setImage(Image image) {
		if(image != null) {
			toggleButton.setImage(image);
		}
	}

	@Override
	public Boolean getValue() {
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

	/**
	 * Indicates whether this button should be selected or not
	 * 
	 * @param isActive
	 *        If true, the button will be selected
	 */
	public void setValue(boolean isActive) {
		toggleButton.setSelection(isActive);
	}

	@Override
	public void updateStatus(IStatus status) {
		// nothing
		switch (status.getSeverity()) {
		case IStatus.OK:
			controlDecoration.hide();
			break;
		case IStatus.WARNING:
			FieldDecoration warning = FieldDecorationRegistry.getDefault()
					.getFieldDecoration(FieldDecorationRegistry.DEC_WARNING);
			controlDecoration.setImage(warning.getImage());
			controlDecoration.showHoverText(status.getMessage());
			controlDecoration.setDescriptionText(status.getMessage());
			controlDecoration.show();
			break;
		case IStatus.ERROR:
			FieldDecoration error = FieldDecorationRegistry.getDefault()
					.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
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

	@Override
	public void changeColorField() {
		// TODO Auto-generated method stub
		
	}

}
