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
import org.eclipse.epf.richtext.extension.RichPlugin;
import org.eclipse.epf.richtext.extension.RichTextImages;
import org.eclipse.epf.richtext.extension.RichTextResources;
import org.eclipse.epf.richtext.extension.dialogs.CheckSpellDialog;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Display;


/**
 * @author Nguyen
 * 
 */
public class SpellCheckAction extends RichTextAction {

	protected CheckSpellDialog dialog;

	/**
	 * Creates a new instance.
	 */
	public SpellCheckAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(RichTextImages.IMG_SPELLCHECK);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_SPELLCHECK);
		setToolTipText(RichTextResources.spellCheckAction_toolTipText);
		this.richText = richText;
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *        a rich text control
	 */
	public void execute(IRichText richText) {
		if(richText != null) {
			try {
				dialog = new CheckSpellDialog(Display.getCurrent().getActiveShell(), richText);
				dialog.open();
			} catch (Exception e) {
				RichPlugin.getDefault().getLogger().logError(e);
			}
		}
	}
}
