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
package org.eclipse.papyrus.tabbedproperties.customform;

import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * this a special custom from to see the body of a comment
 */
public class CustomCommentBodyForm extends AbstractCustomForm {

	public CustomCommentBodyForm(String labeltoDisplay, BackboneContext backboneContext) {
		super(labeltoDisplay, backboneContext);
	}

	/**
	 * text swt element
	 */
	private Text body = null;

	/**
	 * Listen to user inputs
	 */
	private DirectEditFocusListener listener = new DirectEditFocusListener();

	protected EditKeyAdapter keyAdapter = new EditKeyAdapter();

	protected PropertyChangeListener<String> propertyChangeListener;

	protected String oldTextValue;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;
		body = getWidgetFactory().createText(composite, "", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);

		body.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(0, 100);
		body.setLayoutData(data);

		CLabel overviewLabel = getWidgetFactory().createCLabel(composite, "Body:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(body, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(body, 0, SWT.TOP);
		overviewLabel.setLayoutData(data);
	}

	/**
	 * Set text to be shown.
	 * 
	 * @param text
	 */
	public void setValue(String text) {
		if (body == null)
			return;
		body.removeFocusListener(listener);
		body.removeKeyListener(keyAdapter);
		if (text == null)
			text = "";
		body.setText(text);
		body.addFocusListener(listener);
		body.addKeyListener(keyAdapter);
	}

	/**
	 * @param listener
	 */
	public void setPropertyChangeListener(PropertyChangeListener<String> listener) {
		propertyChangeListener = listener;
	}

	/**
	 * Read the label value, check if it has change, fireProperty changed if needed.
	 * 
	 * @param newValue
	 */
	protected void checkPropertyChanged() {
		String newValue = body.getText().trim();
		// Skip if no change
		if (newValue.equals(oldTextValue))
			return;

		oldTextValue = newValue;
		firePropertyChanged(newValue);
	}

	/**
	 * @param newValue
	 */
	public void firePropertyChanged(String newValue) {
		if (propertyChangeListener == null)
			return;

		propertyChangeListener.propertyChanged(this, newValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.ui.properties.tabbed.PropertyViewSection#dispose()
	 */
	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		super.dispose();
		if (body != null && !body.isDisposed())
			body.removeFocusListener(listener);
		body.removeKeyListener(keyAdapter);
	}

	/**
	 * Listener for a direct edit manager.
	 * 
	 * @author Remi SCHNEKENBURGER
	 */
	private class DirectEditFocusListener implements org.eclipse.swt.events.FocusListener {

		// check if the name has been changed or not
		/**
		 * {@inheritDoc}
		 */
		public void focusGained(FocusEvent e) {
			oldTextValue = body.getText().trim();
		}

		/**
		 * {@inheritDoc}
		 */
		public void focusLost(FocusEvent e) {
			checkPropertyChanged();

		}
	}

	private class EditKeyAdapter extends KeyAdapter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			// close the text editor and copy the data over
			// when the user hits "ENTER"
			// #249779
			// if (e.character == SWT.CR) {
			// checkPropertyChanged();
			// }

			// close the text editor when the user hits "ESC"
			if (e.character == SWT.ESC) {
				checkPropertyChanged();
			}
		}
	}
}
