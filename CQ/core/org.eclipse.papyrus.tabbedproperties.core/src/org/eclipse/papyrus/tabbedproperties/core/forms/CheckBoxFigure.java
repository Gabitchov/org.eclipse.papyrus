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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
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
 * A check box property editor.
 * 
 * @author dumoulin
 * 
 */
public class CheckBoxFigure extends AbstractPropertyEditor implements PropertyEditor, ControlWrapper {

	/**
	 * The label with its value to be set.
	 */
	protected Button button;

	protected String buttonLabel = null;

	protected BooleanPropertyChangeListener propertyChangeListener;

	/**
	 * Listen to user inputs
	 */
	private DirectEditFocusListener listener = new DirectEditFocusListener();

	protected boolean oldValue;

	/**
     * 
     */
	public CheckBoxFigure() {
	}

	/**
	 * 
	 * @param buttonLabel
	 *            Label associated to the button. No label shown if null.
	 */
	public CheckBoxFigure(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}

	/**
	 * Create the editor.
	 * 
	 * @param parent
	 * @param aTabbedPropertySheetPage
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		button = getWidgetFactory().createButton(parent, "", SWT.CHECK); //$NON-NLS-1$
		if (buttonLabel != null)
			button.setText(buttonLabel);

		button.addSelectionListener(listener);
	}

	/**
     * 
     */
	public Control getControl() {
		// TODO Auto-generated method stub
		return button;
	}

	/**
	 * Set value to be shown by the figure.
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
     */
	public void checkPropertyChanged() {
		boolean newValue = button.getSelection();
		if (newValue != oldValue) {
			oldValue = newValue;
			firePropertyChanged(newValue);
		}
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
			checkPropertyChanged();
		}
	}

}
