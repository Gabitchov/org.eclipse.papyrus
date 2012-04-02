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
package org.eclipse.papyrus.infra.widgets.editors;


import java.util.Collections;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * A Dialog used to input a String. The dialog uses a IInputValidator
 * to check the string, and can display an error message.
 * 
 * @author Camille Letavernier
 */
public class InputDialog extends SelectionDialog {

	/**
	 * The initial value for the string
	 */
	protected String initialValue;

	/**
	 * The string validator
	 */
	protected IInputValidator validator;

	/**
	 * The label used to display the error message
	 */
	protected Label errorLabel;

	/**
	 * The label used to display the error icon
	 */
	protected Label errorImage;

	/**
	 * The text widget used to input a new string
	 */
	protected AbstractValueEditor editor;

	/**
	 * The dialog's title
	 */
	protected String title;

	/**
	 * The label describing the kind of text to input
	 */
	protected String labelText;

	/**
	 * The content provider used to suggest predefined values to the user
	 */
	protected IStaticContentProvider contentProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        The shell in which the dialog will be opened
	 * @param title
	 *        The dialog's title
	 * @param initialValue
	 *        The dialog's initial value
	 * @param validator
	 *        The validator used to check the input string
	 */
	public InputDialog(Shell parentShell, String title, String label, String initialValue, IInputValidator validator) {
		super(parentShell);
		this.initialValue = initialValue;
		this.validator = validator;
		this.title = title;
		this.labelText = label;
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	@Override
	public void create() {
		super.create();

		((GridLayout)getDialogArea().getLayout()).numColumns = 2;

		errorImage = new Label(getDialogArea(), SWT.NONE);
		errorImage.setImage(Activator.getDefault().getImage("/icons/error.gif")); //$NON-NLS-1$

		errorLabel = new Label(getDialogArea(), SWT.NONE);
		errorLabel.setVisible(false);

		Label label = new Label(getDialogArea(), SWT.None);
		if(labelText != null) {
			label.setText(labelText);
		}
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		if(contentProvider != null) {
			editor = new StringCombo(getDialogArea(), SWT.BORDER);
			((StringCombo)editor).setValue(initialValue);
			((StringCombo)editor).setContentProvider(contentProvider);
		} else {
			editor = new StringEditor(getDialogArea(), SWT.BORDER) {

				//FIXME: The StringEditor (Or one of its superclasses) should be responsible for forwarding this call
				@Override
				public void addKeyListener(KeyListener keyListener) {
					super.text.addKeyListener(keyListener);
				}
			};

			((StringEditor)editor).setValue(initialValue);
		}
		//		input = new Text(getDialogArea(), SWT.BORDER);
		//		input.setText(initialValue);
		editor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		editor.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				//Nothing
			}

			public void keyReleased(KeyEvent e) {
				validate();
			}

		});

		getShell().setImage(Activator.getDefault().getImage("/icons/papyrus.png")); //$NON-NLS-1$

		if(title != null) {
			getShell().setText(title);
		}

		validate();
		getShell().pack();
	}

	/**
	 * Validates the current string. If the string isn't valid,
	 * and error message will be displayed.
	 */
	protected void validate() {
		if(validator == null) {
			errorLabel.setVisible(false);
			errorImage.setVisible(false);
			getOkButton().setEnabled(true);
			return;
		}

		String errorMessage = validator.isValid((String)editor.getValue());
		if(errorMessage == null) {
			errorLabel.setVisible(false);
			errorImage.setVisible(false);
			getOkButton().setEnabled(true);
		} else {
			errorLabel.setText(errorMessage);
			errorLabel.setVisible(true);
			errorImage.setVisible(true);
			getOkButton().setEnabled(false);
		}

		getDialogArea().layout(true);
	}

	@Override
	protected void okPressed() {
		setResult(Collections.singletonList((String)editor.getValue()));
		super.okPressed();
	}

	/**
	 * @return the input text from this dialog, or null
	 *         if the dialog has been canceled
	 */
	public String getText() {
		Object[] result = getResult();
		if(result == null || result.length == 0) {
			return null;
		}
		return (String)result[0];
	}

	/**
	 * Sets a content provider to suggest predefined values to the user
	 * 
	 * @param contentProvider
	 */
	public void setContentProvider(IStaticContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

}
