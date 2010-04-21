/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.modelexplorer.dialog.NavigatorSearchDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * this handler is used to look for element
 * 
 */
public class SearchElementHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();

		NavigatorSearchDialog dialog = new NavigatorSearchDialog(shell,
				getCommonNavigator());
		dialog.open();
		return null;
	}

	protected CommonNavigator getCommonNavigator() {
		IViewPart part = org.eclipse.papyrus.modelexplorer.NavigatorUtils
				.findViewPart("org.eclipse.papyrus.modelexplorer.modelexplorer");
		if (part instanceof CommonNavigator) {
			return ((CommonNavigator) part);
		}
		return null;
	}
}
