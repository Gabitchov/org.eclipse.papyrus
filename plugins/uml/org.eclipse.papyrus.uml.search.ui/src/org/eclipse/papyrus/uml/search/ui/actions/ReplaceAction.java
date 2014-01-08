/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.uml.search.ui.dialogs.ReplaceDialog;
import org.eclipse.papyrus.uml.search.ui.pages.PapyrusSearchResultPage;
import org.eclipse.swt.widgets.Shell;

public class ReplaceAction extends Action {

	private final PapyrusSearchResultPage fResultPage;

	private final Object[] fSelection;

	private final Shell fShell;

	/**
	 * Creates the replace action to be
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resultPage
	 *            .getInput()
	 *            the file search page to
	 * @param selection
	 *            the selected entries or <code>null</code> to replace all
	 */
	public ReplaceAction(Shell shell, PapyrusSearchResultPage resultPage, Object[] selection) {
		fShell = shell;
		fResultPage = resultPage;
		fSelection = selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		ReplaceDialog replaceDialog = new ReplaceDialog(fShell, fResultPage, fSelection);
		replaceDialog.open();

	}

}
