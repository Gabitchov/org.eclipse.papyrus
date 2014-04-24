/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.epf.richtext.extension.actions;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.actions.RichTextAction;
import org.eclipse.epf.richtext.extension.RichTextCommand;
import org.eclipse.epf.richtext.extension.RichTextImages;
import org.eclipse.epf.richtext.extension.RichTextResources;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * @author Nguyen Viet Hoa
 * 
 */
public class RemoveFormatAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public RemoveFormatAction(final IRichText richText) {
		super(richText, IAction.AS_CHECK_BOX);
		this.setEnabled(false);
		setImageDescriptor(RichTextImages.IMG_DESC_CLEAR_FORMATTING);
		setToolTipText(RichTextResources.removeFormatAction_toolTipText);
		richText.addListener(SWT.SELECTED, new Listener() {

			public void handleEvent(Event event) {
				if(richText.getSelected().getText().length() >= 1)
					setEnabled(true);
				else
					setEnabled(false);
			}
		});
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *        a rich text control
	 */
	public void execute(IRichText richText) {
		if(richText != null) {
			richText.executeCommand(RichTextCommand.REMOVE_FORMAT, "2");

		}
	}
}
