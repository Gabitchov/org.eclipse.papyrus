/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.PropertyEditorDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Property editors for properties represented by string (ex. Name for a named element)
 */
public class TextPropertyEditor extends AbstractPropertyEditor {

	/** id of this editor */
	public static final String ID = "org.eclipse.papyrus.views.properties.runtime.textPropertyEditor";

	/** text area */
	private Text text;

	/** main composite created by this property editor */
	private Composite composite;

	/**
	 * Creates a new {@link TextPropertyEditor}
	 */
	public TextPropertyEditor() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleContentChanged() {
		// this should tells the controller that the input has to be applied to the model
		getController().updateModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus init(IPropertyEditorDescriptor descriptor) {
		this.setDescriptor((PropertyEditorDescriptor)descriptor);
		setTooltipText(descriptor.getTooltipText());
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent) {
		composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		int columnNu = getColumnNumber();
		GridLayout layout = new GridLayout(columnNu, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		composite.setLayoutData(data);

		if((getDescriptor().getLabelPosition() & (SWT.LEFT | SWT.TOP)) != 0) {
			createLabel(composite);
		}
		text = getWidgetFactory().createText(composite, "", SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		text.setLayoutData(data);
		text.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				handleContentChanged();
			}

			public void focusGained(FocusEvent e) {
			}
		});
		text.addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				// valid changement on Carriage return typed
				if(SWT.CR == e.keyCode && e.stateMask == SWT.NONE) {
					handleContentChanged();
				}
			}

			public void keyPressed(KeyEvent e) {

			}
		});
		text.setEnabled(!getIsReadOnly());
		if((getDescriptor().getLabelPosition() & (SWT.RIGHT | SWT.BOTTOM)) != 0) {
			createLabel(composite);
		}

		text.setToolTipText(getTooltipText());

		return composite;
	}

	/**
	 * Returns the number of column for the composite
	 * 
	 * @return the number of column for the composite
	 */
	protected int getColumnNumber() {
		if((getDescriptor().getLabelPosition() & (SWT.TOP | SWT.BOTTOM)) != 0) {
			return 1;
		}
		return 2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValue() {
		if(isValid(text)) {
			return text.getText();
		} else {
			Activator.log.error("trying to read the value of the text area whereas the control is disposed", null);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object valueToEdit) {
		if(isValid(text)) {
			String textToEdit = (valueToEdit != null) ? valueToEdit.toString() : "";
			text.setText(textToEdit);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		if(isValid(composite)) {
			composite.dispose();
			composite = null;
			setController(null);
		}
	}

	/**
	 * Returns the configuration for this editor
	 * 
	 * @return the configuration for this editor
	 */
	public PropertyEditorDescriptor getDescriptor() {
		return (PropertyEditorDescriptor)super.getDescriptor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDisposed() {
		if(composite == null) {
			return true;
		}
		return composite.isDisposed();
	}
}
