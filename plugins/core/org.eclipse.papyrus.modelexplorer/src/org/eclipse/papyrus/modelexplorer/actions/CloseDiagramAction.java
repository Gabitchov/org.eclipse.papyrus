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
 *  Vincent Lorenzo (vincent.lorenzo@cea.fr) - @deprecated
 *****************************************************************************/

package org.eclipse.papyrus.modelexplorer.actions;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.modelexplorer.handler.CloseHandler;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Action used to open the given diagram
 * 
 * @author cedric dumoulin
 * @deprecated you should use {@link CloseHandler}
 */
@Deprecated
public class CloseDiagramAction extends Action {

	Diagram diagram;

	IPageMngr pageMngr;

	public CloseDiagramAction(IPageMngr pageMngr, Diagram diagram) {
		this.diagram = diagram;
		this.pageMngr = pageMngr;

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setText("Close");
		setEnabled(pageMngr.isOpen(diagram));
	}

	/**
	 * Delete the given diagram
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		pageMngr.closePage(diagram);
	}
}
