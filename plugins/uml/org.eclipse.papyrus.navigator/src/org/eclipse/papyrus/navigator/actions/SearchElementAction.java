/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.navigator.ModelNavigator;
import org.eclipse.papyrus.navigator.dialog.NavigatorSearchDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * An {@link Action} that allows searching elements in the
 * {@link ModelNavigator} by their name.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es>Francisco Javier Cano Muñoz</a>
 * 
 */
public class SearchElementAction extends Action {

	private final CommonNavigator navigator;

	public SearchElementAction(CommonNavigator commonNavigator) {
		super("Search elements");
		this.navigator = commonNavigator;
		this.setToolTipText("Search elements");
		init();
	}

	private void init() {
	}

	@Override
	public void run() {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		NavigatorSearchDialog dialog = new NavigatorSearchDialog(shell,
				navigator);
		dialog.open();

	}

}
