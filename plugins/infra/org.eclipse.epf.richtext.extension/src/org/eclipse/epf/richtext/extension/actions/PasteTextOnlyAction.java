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

import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;
import org.eclipse.epf.common.serviceability.Logger;
import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.actions.RichTextAction;
import org.eclipse.epf.richtext.extension.RichPlugin;
import org.eclipse.epf.richtext.extension.RichTextCommand;
import org.eclipse.epf.richtext.extension.RichTextEditor;
import org.eclipse.epf.richtext.extension.RichTextImages;
import org.eclipse.epf.richtext.extension.RichTextResources;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.widgets.Display;


/**
 * The Paste merge formatting
 * 
 * @author Nguyen
 * 
 */
public class PasteTextOnlyAction extends RichTextAction {

	protected static final Pattern p_image_ref = Pattern.compile("(<(img|iframe).*?src\\s*=\\s*\")(.*?)(\")", Pattern.CASE_INSENSITIVE | Pattern.DOTALL); //$NON-NLS-1$

	protected static String sourceURLStr = ""; //$NON-NLS-1$

	private Logger logger;

	/**
	 * Creates a new instance.
	 */
	public PasteTextOnlyAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(RichTextImages.IMG_DESC_PASTE);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_PASTE);
		setToolTipText(RichTextResources.pasteMergeFormattingAction_toolTipText);
		logger = RichPlugin.getDefault().getLogger();
	}

	/**
	 * Returns <code>true</code> if this action should be disabled when the
	 * rich text editor is in source edit mode.
	 */
	public boolean disableInSourceMode() {
		return false;
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *        a rich text control
	 */
	public void execute(IRichText richText) {
		if(richText != null) {
			if(richText instanceof RichTextEditor && ((RichTextEditor)richText).isHTMLTabSelected()) {
				StyledText styledText = ((RichTextEditor)richText).getSourceEdit();
				styledText.paste();
			} else {
				if(Platform.getOS().equals("win32")) {
					Clipboard clipboard = new Clipboard(Display.getCurrent());
					String html = (String)clipboard.getContents(HTMLTransfer.getInstance());
					richText.executeCommand(RichTextCommand.ADD_HTML, html);
				} else if(Platform.getOS().equals("linux") || Platform.getOS().equals("macosx")) {
					Clipboard clipboard = new Clipboard(Display.getCurrent());
					String html = (String)clipboard.getContents(HTMLTransfer.getInstance());
					richText.executeCommand(RichTextCommand.ADD_HTML, html);
				}

			}

		}
	}


}
