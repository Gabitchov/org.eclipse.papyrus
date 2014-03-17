/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.controlmode.handler;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.team.collaborative.strategy.ui.dialogs.PreviewDialog;
import org.eclipse.papyrus.team.collaborative.strategy.ui.providers.ExtensivePartitionNameLabelProvider;
import org.eclipse.papyrus.team.collaborative.strategy.utils.UIUtils;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractModelExplorerHandler;
import org.eclipse.swt.widgets.Display;


/**
 * The Class ShowModelPartitionHandler.
 * Handler use to display the current partitioning of a model. It will reveal the current selected element
 */
public class ShowModelPartitionHandler extends AbstractModelExplorerHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<EObject> selection = getCurrentSelectionAdaptedToType(event, EObject.class);
		PreviewDialog dialog = new PreviewDialog(Display.getDefault().getActiveShell(), new ExtensivePartitionNameLabelProvider( UIUtils.getModelExplorerLavelProvider()), "Model Partition", "The name of each partition appear between the [] before each element name");
		if(selection != null && !selection.isEmpty()) {
			dialog.setObjectsToReveal(selection);
		}
		dialog.open();
		return null;
	}


}
