/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.CustomizePropertyViewWizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
 * Handler for the command of customization of the content of the properties view
 */
public class CustomizePropertyViewCommandHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Display current = Display.getCurrent();
		if(current == null) {
			current = Display.getDefault();
		}
		Shell shell = current.getActiveShell();
		if(shell != null) {

			CustomizePropertyViewWizard wizard = new CustomizePropertyViewWizard();
			WizardDialog wd = new WizardDialog(shell, wizard) {

				/**
				 * {@inheritDoc}
				 */
				@Override
				protected void configureShell(Shell newShell) {
					super.configureShell(newShell);
					newShell.setText("Customize Property View");
				}
			};
			wd.create();
			// wd.getShell().setSize(640, 600);
			wd.open();
		} else {
			Activator.log.error("impossible to find a shell to open the message dialog", null);
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		if(EditorUtils.getMultiDiagramEditor() == null) {
			return false;
		}
		return super.isEnabled();
	}
}
