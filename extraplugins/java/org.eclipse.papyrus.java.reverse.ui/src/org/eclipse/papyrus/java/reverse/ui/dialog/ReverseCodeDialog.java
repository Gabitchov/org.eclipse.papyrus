/**
 * 
 */
package org.eclipse.papyrus.java.reverse.ui.dialog;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.papyrus.java.reverse.ui.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author dumoulin
 * 
 */
public class ReverseCodeDialog extends InputDialog {

	/** Internal dialog to show list of searchpaths */
	private InputListDialog listDialog;

	/** Returned searchpaths */
	private String[] searchPath;

	private static String textMsg = "Name of the package where reversed classes will be generated (ex: p1/p2)";

	private static String dialogTitle = "Reverse Code";

	private static String listMsg = "search paths  - list of model packages used to search for already existing classes (ex: p1/p2)";


	/**
	 * @param parentShell
	 * @param dialogTitle
	 * @param dialogMessage
	 * @param initialValue
	 * @param validator
	 */
	public ReverseCodeDialog(Shell parentShell, String initialValue, List<String> searchPathsInitialValues) {
		super(parentShell, dialogTitle, textMsg, getInitialValue(initialValue), null);
		// TODO Auto-generated constructor stub
		IDialogSettings settings = Activator.getDefault().getDialogSettings();

		// Look for generationPackageName if none is provided.
		//		if(initialValue == null)
		//		{
		//			String generationPackageName = settings.get("generationPackageName");
		//			getText().setText(generationPackageName);
		//			
		//		}
		// Look for saved searchpaths if none is provided.
		if(searchPathsInitialValues == null) {
			String[] savedSearchPath = settings.getArray("searchpaths");
			if(savedSearchPath != null)
				searchPathsInitialValues = Arrays.asList(savedSearchPath);
		}

		listDialog = new InputListDialog(listMsg, searchPathsInitialValues);

	}

	private static String getInitialValue(String initialValue) {
		IDialogSettings settings = Activator.getDefault().getDialogSettings();

		// Look for generationPackageName if none is provided.
		if(initialValue == null) {
			String generationPackageName = settings.get("generationPackageName");
			return generationPackageName;

		}
		return initialValue;
	}

	/**
	 * Allows resizing.
	 */
	@Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Get the returned searchpaths.
	 * 
	 * @return
	 */
	public String[] getSearchPath() {
		return searchPath;
	}

	/**
	 * Create additional list of searchpaths.
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// create composite
		Composite composite = (Composite)super.createDialogArea(parent);

		listDialog.createDialogArea(composite);
		return composite;
	}

	/**
	 * Save the searchpath after the button is pressed.
	 */
	@Override
	protected void okPressed() {
		// Save the list before the control is disposed
		searchPath = listDialog.getList();
		// save values
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		settings.put("searchpaths", searchPath);
		settings.put("generationPackageName", getValue());

		super.okPressed();
	}
}
