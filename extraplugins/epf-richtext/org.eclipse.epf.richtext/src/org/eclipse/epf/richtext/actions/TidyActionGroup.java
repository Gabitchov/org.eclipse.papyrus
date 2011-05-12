/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
//------------------------------------------------------------------------------
// Copyright (c) 2005, 2006 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.epf.richtext.actions;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.RichTextImages;
import org.eclipse.epf.richtext.Messages;
import org.eclipse.jface.action.IAction;

/**
 * Runs JTidy on the HTML
 * 
 * @author Jeff Hardy
 * @since 1.2
 */
public class TidyActionGroup extends RichTextAction {
	
	TidyAction tidyActionDefault;
	TidyAction tidyActionCleanMS;
	TidyAction tidyActionCleanWord2000;

	public TidyActionGroup(IRichText richText) {
		super(richText, IAction.AS_DROP_DOWN_MENU);
		// TODO need image
		setImageDescriptor(RichTextImages.IMG_DESC_TIDY);
		// TODO need image
//		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_PASTE);
		setToolTipText(Messages.tidy_clean_text);
		
		createActions();
		setMenuCreator(menuCreator);
	}
	
	private void createActions() {
		tidyActionDefault = new TidyAction(richText, true, false, false);
		tidyActionDefault.setText(Messages.tidy_clean_text);
		tidyActionDefault.setToolTipText(Messages.tidy_clean_toolTipText);
		tidyActionCleanMS = new TidyAction(richText, true, true, false);
		tidyActionCleanMS.setText(Messages.tidy_cleaner_text);
		tidyActionCleanMS.setToolTipText(Messages.tidy_cleaner_toolTipText);
		tidyActionCleanWord2000 = new TidyAction(richText, true, true, true);
		tidyActionCleanWord2000.setText(Messages.tidy_cleanest_text);
		tidyActionCleanWord2000.setToolTipText(Messages.tidy_cleanest_toolTipText);
		addActionToMenu(tidyActionDefault);
		addActionToMenu(tidyActionCleanMS);
		addActionToMenu(tidyActionCleanWord2000);
	}
	
	@Override
	public void execute(IRichText richText) {
		// TODO Auto-generated method stub
		
		// call normal clean
		tidyActionDefault.execute(richText);

	}
	
	@Override
	public boolean disableInSourceMode() {
		return false;
	}

	
}
