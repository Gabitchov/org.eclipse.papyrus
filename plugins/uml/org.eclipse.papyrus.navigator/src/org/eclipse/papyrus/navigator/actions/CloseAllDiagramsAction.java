/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Action used to close all open diagrams.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=287948">Bug #287948</a>
 */
public class CloseAllDiagramsAction extends Action {

	IPageMngr pageMngr;

	protected IPageMngr getPageMngr() {
		return pageMngr;
	}

	public CloseAllDiagramsAction(IPageMngr pageMngr) {
		if (pageMngr == null) {
			throw new IllegalArgumentException("An IPageMngr must be specified");
		}
		this.pageMngr = pageMngr;
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setText("Close all diagrams");
		// this action is enabled when there is at least one diagram open.
		boolean aDiagramIsOpen = false;
		for (Object identifier : pageMngr.allPages()) {
			if (pageMngr.isOpen(identifier)) {
				aDiagramIsOpen = true;
			}
		}
		setEnabled(aDiagramIsOpen);
	}

	/**
	 * Delete the given diagram
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		// close all open diagrams
		for (Object identifier : pageMngr.allPages()) {
			if (getPageMngr().isOpen(identifier)) {
				getPageMngr().closePage(identifier);
			}
		}
	}

}
