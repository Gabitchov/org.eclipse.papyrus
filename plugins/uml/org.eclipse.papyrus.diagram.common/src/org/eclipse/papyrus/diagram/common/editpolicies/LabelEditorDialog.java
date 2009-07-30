/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.common.editpolicies;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

// equivalent au inputDialog (code recopie) mais donne un sourceviewer a la place du label
/**
 * 
 */
public class LabelEditorDialog extends Dialog {

	/**
	 * The title of the dialog.
	 */
	protected String title;

	/**
	 * The input value; the empty string by default.
	 */
	protected String value = "";//$NON-NLS-1$

	/**
	 * The input validator, or <code>null</code> if none.
	 */
	protected IInputValidator validator;

	/**
	 * Ok button widget.
	 */
	protected Button okButton;

	/**
	 * Error message label widget.
	 */
	protected Text errorMessageText;

	/**
	 * Error message string.
	 */
	protected String errorMessage;

	/**
	 * SourceViewer : area that displays text.
	 */
	protected SourceViewer viewer;

	/**
	 * Creates a dialog with OK and Cancel buttons. Note that the dialog will have no visual
	 * representation (no widgets) until it is told to open.
	 * <p>
	 * Note that the <code>open</code> method blocks for input dialogs.
	 * </p>
	 * 
	 * @param dialogTitle
	 *            the dialog title, or <code>null</code> if none
	 * @param validator
	 *            an input validator, or <code>null</code> if none
	 * @param parentShell
	 *            the parent shell, or <code>null</code> to create a top-level shell
	 * @param initialValue
	 *            the initial input value, or <code>null</code> if none (equivalent to the empty
	 *            string)
	 */
	public LabelEditorDialog(Shell parentShell, String dialogTitle, String initialValue, IInputValidator validator) {
		super(parentShell);
		this.title = dialogTitle;
		if (initialValue == null) {
			value = "";//$NON-NLS-1$
		} else {
			value = initialValue;
		}
		this.validator = validator;
	}

	/*
	 * (non-Javadoc) Method declared on Dialog.
	 */
	/**
	 * 
	 * 
	 * @param buttonId
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			value = viewer.getDocument().get();
		} else {
			value = null;
		}
		super.buttonPressed(buttonId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	/**
	 * 
	 * 
	 * @param shell
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		if (title != null) {
			shell.setText(title);
		}
	}

	/**
	 * Returns the ok button.
	 * 
	 * @return the ok button
	 */
	protected Button getOkButton() {
		return okButton;
	}

	/**
	 * Returns the text area.
	 * 
	 * @return the text area
	 */
	protected SourceViewer getSourceViewer() {
		return viewer;
	}

	/**
	 * Returns the validator.
	 * 
	 * @return the validator
	 */
	protected IInputValidator getValidator() {
		return validator;
	}

	/**
	 * Returns the string typed into this input dialog.
	 * 
	 * @return the input string
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Validates the input.
	 * <p>
	 * The default implementation of this framework method delegates the request to the supplied
	 * input validator object; if it finds the input invalid, the error message is displayed in the
	 * dialog's message line. This hook method is called whenever the text changes in the input
	 * field.
	 * </p>
	 */
	protected void validateInput() {
		String errorMessage = null;
		if (validator != null) {
			errorMessage = validator.isValid(viewer.getDocument().get());
		}
		// Bug 16256: important not to treat "" (blank error) the same as null
		// (no error)
		setErrorMessage(errorMessage);
	}

	/**
	 * Sets or clears the error message. If not <code>null</code>, the OK button is disabled.
	 * 
	 * @param errorMessage
	 *            the error message, or <code>null</code> to clear
	 * 
	 * @since 3.0
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		if ((errorMessageText != null) && !errorMessageText.isDisposed()) {
			errorMessageText.setText(errorMessage == null ? "" : errorMessage); //$NON-NLS-1$
			errorMessageText.getParent().update();
			// Access the ok button by id, in case clients have overridden button creation.
			// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=113643
			Control button = getButton(IDialogConstants.OK_ID);
			if (button != null) {
				button.setEnabled(errorMessage == null);
			}
		}
	}

}
