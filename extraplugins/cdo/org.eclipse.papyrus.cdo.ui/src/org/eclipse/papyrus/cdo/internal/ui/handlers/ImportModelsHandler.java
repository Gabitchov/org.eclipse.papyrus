/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.ui.wizards.ModelImportWizard;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This is the ImportModelsHandler type. Enjoy.
 */
public class ImportModelsHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(selection instanceof IStructuredSelection) {
			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

			if(window != null) {
				importModels(window, (IStructuredSelection)selection, null);
			}
		}

		return null;
	}

	public static void importModels(IWorkbenchWindow window, IStructuredSelection selection, IPapyrusRepository repository) {
		ModelImportWizard wizard = new ModelImportWizard();
		wizard.init(window.getWorkbench(), selection);

		if(repository != null) {
			wizard.setRepository(repository);
		}

		new WizardDialog(window.getShell(), wizard).open();
	}
}
