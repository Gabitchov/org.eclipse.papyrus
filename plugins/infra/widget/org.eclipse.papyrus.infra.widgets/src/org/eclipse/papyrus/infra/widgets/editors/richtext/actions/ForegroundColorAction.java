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
package org.eclipse.papyrus.infra.widgets.editors.richtext.actions;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextCommand;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextResources;
import org.eclipse.papyrus.infra.widgets.editors.richtext.actions.RichTextButtonAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


/**
 * The ForegroundColor button in the toolbar
 * 
 * @author Nguyen Viet Hoa
 * 
 */
public class ForegroundColorAction extends RichTextButtonAction {

	/**
	 * Creates a new instance.
	 */
	public ForegroundColorAction(final IRichText richText) {
		super(richText);
		this.setToolTipText(RichTextResources.foreGroundColorAction_toolTipText);

		richText.addListener(SWT.SELECTED, new Listener() {

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
	public void execute(IRichText richText) {
		if(richText != null) {

			richText.executeCommand(RichTextCommand.FOREGROUND_COLOR, this.color);
		}
	}


}
