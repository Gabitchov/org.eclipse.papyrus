/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.dialogs;

import java.util.Collection;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.activity.part.Messages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.preferences.IActivityPreferenceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This class enables to open a dialog to ask the user to confirm he wants to
 * delete activity parameter node(s) with parameter
 * 
 */
public class ConfirmActivityParameterNodeAndParameterSyncDialog extends MessageDialog {

	/**
	 * Protected constructor. Use {@link #openConfirmFromParameter(Shell)} or {@link #openConfirmFromPin(Shell)}
	 * 
	 * @param parentShell
	 *        the parent shell
	 * @param dialogMessage
	 *        the message
	 */
	protected ConfirmActivityParameterNodeAndParameterSyncDialog(Shell parentShell, String dialogMessage) {
		super(parentShell, CustomMessages.ConfirmActivityParameterAndParameterSync_Title, null, dialogMessage, CONFIRM, new String[]{ IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
	}

	/**
	 * Open a confirmation dialog for the parameter deletion
	 * 
	 * @param parentShell
	 * @param parameterNodes
	 * @param labelprovider
	 * @return the user confirmation
	 */
	public static boolean openConfirmFromParameter(Shell parentShell, Collection<? extends NamedElement> parameterNodes, ILabelProvider labelprovider) {
		// consult preferences before opening the popup
		final IPreferenceStore prefStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		boolean showPopup = prefStore.getBoolean(IActivityPreferenceConstants.PREF_CONFIRM_ACTIVITY_PARAMETER_SYNC_FROM_PARAMETER);
		if(showPopup) {
			StringBuffer parsedList = new StringBuffer();
			for(NamedElement element : parameterNodes) {
				parsedList.append(labelprovider.getText(element));
				parsedList.append(System.getProperty("line.separator"));
			}
			String message = NLS.bind(CustomMessages.ConfirmActivityParameterAndParameterSync_FromParameterMsg, parsedList.toString());
			ConfirmActivityParameterNodeAndParameterSyncDialog dialog = new ConfirmActivityParameterNodeAndParameterSyncDialog(parentShell, message);
			return dialog.open() == 0;
		} else {
			return true;
		}
	}

	/**
	 * Create a checkbox for not displaying the popup again
	 * 
	 * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 *        parent composite
	 * @return checkbox
	 */
	@Override
	protected Control createCustomArea(Composite parent) {
		Button checkBox = new Button(parent, SWT.CHECK | SWT.LEFT);
		checkBox.setText(CustomMessages.DiagramsPreferencePage_disableNotification);
		checkBox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(e.getSource() instanceof Button) {
					boolean doNotShow = ((Button)e.getSource()).getSelection();
					final IPreferenceStore prefStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
					prefStore.putValue(IActivityPreferenceConstants.PREF_CONFIRM_ACTIVITY_PARAMETER_SYNC_FROM_PARAMETER, Boolean.toString(!doNotShow));
				}
			}
		});
		return checkBox;
	}
}
