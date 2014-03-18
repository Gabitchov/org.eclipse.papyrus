/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.css.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSStyleSheetsToThemeHelper;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * 
 * Handler to define a CSS style sheet file as local theme.
 * 
 * @author gpascual
 *
 */
public class CSSFileHandler extends AbstractHandler implements IHandler {

	/** ID of command to edit existing theme. */
	private static final String THEME_EDIT_COMMAND_ID = "org.eclipse.papyrus.infra.gmfdiag.css.theme.edit"; //$NON-NLS-1$

	/** ID of command to define theme. */
	private static final String THEME_DEFINE_COMMAND_ID = "org.eclipse.papyrus.infra.gmfdiag.css.theme.define"; //$NON-NLS-1$

	/** */
	private CSSStyleSheetsToThemeHelper cssHelper = new CSSStyleSheetsToThemeHelper();

	/**
	 * Default constructor.
	 *
	 */
	public CSSFileHandler() {
		super();
	}

	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {


		// Get current selection
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		// Get selected file from selection
		if(selection instanceof IStructuredSelection) {
			Object selectedObject = ((IStructuredSelection)selection).getFirstElement();

			// Handle selected file
			if(selectedObject instanceof IFile) {
				cssHelper.defineCSSStyleSheetFileAsTheme((IFile)selectedObject);

			}
		}


		// Get executed command ID
		String commandID = event.getCommand().getId();

		if(THEME_DEFINE_COMMAND_ID.equals(commandID)) {

			// TODO Open a specific dialog to define theme according to selection

		} else if(THEME_EDIT_COMMAND_ID.equals(commandID)) {
			// TODO Open a specific dialog to edit existing theme  according to selection
		}

		return null;
	}



}
