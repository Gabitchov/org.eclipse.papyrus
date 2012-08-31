package org.eclipse.papyrus.dev.project.management.dialog;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * This input dialog provides a field to edit and a checkbox
 * 
 */
//TODO move this class in an upper project
public class InputDialogWithCheckBox extends InputDialog {

	/**
	 * the checkbox
	 */
	private Button checkbox;

	/**
	 * the message for the checkbox
	 */
	final private String checkboxMessage;

	/**
	 * the initial state of the checkbox
	 */
	final private boolean checkboxStatus;

	/**
	 * the state of the checkbox when the dialog is closed
	 */
	private boolean finalState;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param dialogTitle
	 * @param dialogMessage
	 * @param initialValue
	 * @param checkboxMessage
	 * @param checkboxStatus
	 * @param validator
	 */
	public InputDialogWithCheckBox(Shell parentShell, String dialogTitle, String dialogMessage, String initialValue, final String checkboxMessage, final boolean checkboxStatus, final IInputValidator validator) {
		super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
		this.checkboxMessage = checkboxMessage;
		this.checkboxStatus = checkboxStatus;
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createContents(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control ctrl = super.createContents(parent);
		checkbox = new Button((Composite)((Composite)ctrl).getChildren()[0], SWT.CHECK);
		checkbox.setText(checkboxMessage);
		checkbox.setSelection(checkboxStatus);
		return ctrl;
	}


	/**
	 * 
	 * @return
	 *         <code>true</code> if the checkbox is checked
	 */
	public boolean isChecked() {
		return this.finalState;
	}

	/**
	 * save the state of the checkbox
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {
		finalState = this.checkbox.getSelection();
		super.okPressed();
	}
}
