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
import org.eclipse.epf.richtext.extension.RichTextCommand;
import org.eclipse.epf.richtext.extension.RichTextResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * the backgroundColor action in the toolbar
 * 
 * @author Nguyen Viet Hoa
 * 
 */
public class BackgroundColorAction extends RichTextButtonAction {

	/**
	 * Creates a new instance.
	 */
	public BackgroundColorAction(final IRichText richText) {
		super(richText);

		this.toolTipText = RichTextResources.backGroundColorAction_toolTipText;
		richText.addListener(SWT.SELECTED, new Listener() {

			@Override
			public void handleEvent(Event event) {

			}
		});
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *        a rich text control
	 * @param index
	 *        the index of the selected item
	 */
	@Override
	public void execute(IRichText richText) {
		if(richText != null) {
			richText.executeCommand(RichTextCommand.BACKGROUND_COLOR, this.color);

		}
	}


}
