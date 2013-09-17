/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.diagram.ui.handlers;

import org.eclipse.core.commands.IHandler;
import org.eclipse.papyrus.layers.runtime.NotationDiagramHelper;


/**
 * Add a layer stack to a diagram.
 * This is performed on the current LayerStack Viewer.
 * 
 * @author cedric dumoulin
 * 
 */
public class ShowCreateChildCommand extends AbstractLayerCommand implements IHandler {


	/**
	 * @see org.eclipse.papyrus.layers2.ui.view.commands.AbstractLayerCommand#getCommandName()
	 *
	 * @return
	 */
	@Override
	public String getCommandName() {
		return "Attach Layer Stack";
	}
	
	/**
	 * @see org.eclipse.papyrus.layers2.ui.view.commands.AbstractLayerCommand#doExecute(org.eclipse.papyrus.layers.application.NotationDiagramMngr)
	 *
	 * @param notationDiagramHelper
	 */
	@Override
	protected void doExecute(NotationDiagramHelper notationDiagramHelper) {
		System.out.println( this.getClass().getSimpleName() + ".doExecute()");
		notationDiagramHelper.attachLayersStack();
	}


	/**
	 * Return true if it is possible to attach aLyerStack.
	 */
	@Override
	public boolean isEnabled(NotationDiagramHelper notationDiagramHelper) {
		return ! notationDiagramHelper.isLayersStackAttached();
	}

}
