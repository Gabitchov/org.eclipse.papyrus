/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.forms;

import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * A Property section with a Label and an input text.
 * 
 * @author dumoulin
 * 
 */
public class LabeledCheckBoxFigure extends LabeledPropertyEditor implements PropertyEditor {

	/**
	 * The label with its value to be set.
	 */
	protected Button button;

	protected BooleanPropertyChangeListener propertyChangeListener;

	/**
	 * Listen to user inputs
	 */
	private DirectEditFocusListener listener = new DirectEditFocusListener();

	protected boolean oldValue;

	public LabeledCheckBoxFigure(String label) {
		super(label, "");
	}

	public LabeledCheckBoxFigure(String label, String description) {
		super(label, description);
	}

	/**
	 * Create the editor.
	 * 
	 * @param parent
	 * @param aTabbedPropertySheetPage
	 */
	@Override
	public Control createRightControl(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		button = getWidgetFactory().createButton(parent, "", SWT.CHECK); //$NON-NLS-1$
		button.addSelectionListener(listener);

		return button;
	}

	/**
	 * Set text to be shown.
	 * 
	 * @param text
	 */
	public void setValue(boolean newValue) {
		if (button == null)
			return;

		if (newValue == button.getSelection())
			return;

		oldValue = newValue;
		button.removeSelectionListener(listener);
		button.setSelection(newValue);
		button.addSelectionListener(listener);
	}

	/**
	 * @param listener
	 */
	public void setPropertyChangeListener(BooleanPropertyChangeListener listener) {
		propertyChangeListener = listener;
	}

	/**
	 * @param newValue
	 */
	public void firePropertyChanged(boolean newValue) {
		if (propertyChangeListener == null)
			return;

		propertyChangeListener.propertyChanged(this, newValue);
	}

	/**
	 * Listener for a direct edit manager.
	 * 
	 */
	protected class DirectEditFocusListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {

		}

		public void widgetSelected(SelectionEvent e) {

			boolean newValue = button.getSelection();
			if (newValue != oldValue) {
				oldValue = newValue;
				firePropertyChanged(newValue);
			}

		}
	}

}
