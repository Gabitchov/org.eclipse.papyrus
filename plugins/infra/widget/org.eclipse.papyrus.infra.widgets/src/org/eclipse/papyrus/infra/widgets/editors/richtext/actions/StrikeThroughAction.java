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
import org.eclipse.epf.richtext.actions.RichTextAction;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextCommand;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextImages;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextResources;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * @author Nguyen Viet Hoa
 * 
 */
public class StrikeThroughAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public StrikeThroughAction(final IRichText richText) {
		super(richText, IAction.AS_CHECK_BOX);
		setImageDescriptor(RichTextImages.IMG_DESC_STRIKE_THROUGH);
		setToolTipText(RichTextResources.strikeThroughAction_toolTipText);
		// add listener
		richText.addListener(SWT.SELECTED, new Listener() {

			public void handleEvent(Event event) {
				// check style of selected text
				//		setChecked(richText.getSelected().isStrikeThrough());
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
			richText.executeCommand(RichTextCommand.STRIKE_THROUGH);
		}
	}
}
