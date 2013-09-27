//------------------------------------------------------------------------------
// Copyright (c) 2009 Anyware Technologies and others
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
//      Anyware Technologies - initial API and implementation
//------------------------------------------------------------------------------
package org.eclipse.papyrus.views.documentation.view.actions;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.actions.RichTextAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.views.documentation.view.DocViewPlugin;
import org.eclipse.papyrus.views.documentation.view.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Delete a column from the selected table in the rich text control.
 * 
 * @author Jose Alfredo Serrano (Anyware Technologies)
 * @author Jacques LESCOT (Anyware Technologies)
 */
public class DeleteTableColumnAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public DeleteTableColumnAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
        setImageDescriptor(DocViewPlugin.getDefault().getImageRegistry().getDescriptor("DELETE_COLUMN")); //$NON-NLS-1$
        setToolTipText(Messages.DeleteTableColumnAction_title);
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *            a rich text control
	 */
	public void execute(IRichText richText) {
		if (richText != null) {
			Shell parent = Display.getCurrent().getActiveShell();
            InputDialog dialog = new InputDialog(parent, "Delete Column", Messages.DeleteTableColumnAction_text, "0", new NumberValidator()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if (dialog.open() == Window.OK) {
				richText.executeCommand(CommandConstants.DELETE_TABLE_COL, dialog.getValue());
			}
		}
	}

}