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
package org.eclipse.papyrus.properties.tabbed.customization.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.properties.tabbed.customization.dialog.CustomizePropertyViewDialog;
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

			CustomizePropertyViewDialog dialog = new CustomizePropertyViewDialog(shell);
			if(Window.OK == dialog.open()) {
				// execute action at the end of the dialog
			}
		} else {
			Activator.log.error("impossible to find a shell to open the message dialog", null);
		}

		return null;
	}

}
