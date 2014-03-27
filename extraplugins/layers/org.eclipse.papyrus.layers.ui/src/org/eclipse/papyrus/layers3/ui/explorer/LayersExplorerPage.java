/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers3.ui.explorer;

import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ViewPartPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;


/**
 * A page of the {@link LayerExplorerPageBookView}.
 * This page contains a {@link LayersExplorerView} rendering an Explorer.
 * 
 * @author cedric dumoulin
 *
 */
public class LayersExplorerPage extends ViewPartPage {

	/**
	 * Constructor.
	 *
	 */
	public LayersExplorerPage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the Viewer for the requested part.
	 * Here, create a {@link LayersExplorerView} for a Papyrus main editor.
	 * 
	 * @param part
	 *        The part to associate to the Viewer.
	 * @return
	 */
	@Override
	protected IViewPart createViewer(IWorkbenchPart part) {
		// Part is of the right type because of call  to isImportant()
		return null;
//		return new LayersExplorerView((IMultiDiagramEditor)part);
	}

	/**
	 * Create control of the inner view
	 * 
	 * @see org.eclipse.ui.part.Page#createControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		getViewer().createPartControl(parent);
	}

	/**
	 * Return the control
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ViewPartPage#getControl()
	 * 
	 * @return
	 */
	@Override
	public Control getControl() {
		return ((ModelExplorerView)getViewer()).getControl();
	}

}
