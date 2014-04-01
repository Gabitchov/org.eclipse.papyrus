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
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.gmfdiag.css.dialog.CSSThemeCreationDialog;
import org.eclipse.papyrus.infra.gmfdiag.css.dialog.CSSThemeEditionDialog;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.WorkspaceThemesHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.WorkspaceThemes;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.ThemeManager;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
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
	private WorkspaceThemesHelper cssHelper = new WorkspaceThemesHelper();

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

		Theme theme = null;
		int dialogResult = -1;


		// Get current selection
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		// Get selected file from selection
		if(selection instanceof IStructuredSelection) {

			// Get executed command ID
			String commandID = event.getCommand().getId();
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

			if(THEME_DEFINE_COMMAND_ID.equals(commandID)) {

				// Get theme initialise with slected elements
				theme = cssHelper.defineCSSStyleSheetFilesAsTheme((IStructuredSelection)selection);
				// Open a specific dialog to define theme according to selection
				Dialog dialog = new CSSThemeCreationDialog(shell, theme);
				dialogResult = dialog.open();


			} else if(THEME_EDIT_COMMAND_ID.equals(commandID)) {
				IPath workspaceThemesFilePath = cssHelper.getThemeWorkspacePreferenceFilePath();

				WorkspaceThemes workspaceThemes = null;
				if(workspaceThemesFilePath.toFile().exists()) {
					ResourceSet resourceSet = new ResourceSetImpl();
					Resource resource = resourceSet.getResource(URI.createFileURI(workspaceThemesFilePath.toOSString()), true);
					workspaceThemes = (WorkspaceThemes)EcoreUtil.getObjectByType(resource.getContents(), StylesheetsPackage.Literals.WORKSPACE_THEMES);
				}

				// Open a specific dialog to edit existing theme  according to selection
				CSSThemeEditionDialog dialog = new CSSThemeEditionDialog(shell, workspaceThemes, (IStructuredSelection)selection);
				dialogResult = dialog.open();

				theme = dialog.getEditedTheme();



			}

			// Save and reload themes list only if user has validated
			if(dialogResult == Dialog.OK) {

				if(THEME_DEFINE_COMMAND_ID.equals(commandID)) {
					cssHelper.saveNewThemeWorkspacePreference(theme);
				} else if(THEME_EDIT_COMMAND_ID.equals(commandID)) {
					cssHelper.saveWorkspaceThemesPreferenceResource(theme);
				}

				ThemeManager.instance.reloadThemes();
			}

		}


		return null;
	}
}
