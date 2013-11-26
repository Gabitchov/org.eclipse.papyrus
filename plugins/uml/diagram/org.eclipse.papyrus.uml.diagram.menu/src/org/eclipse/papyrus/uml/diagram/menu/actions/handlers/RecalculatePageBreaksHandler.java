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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.WorkspaceViewerProperties;
import org.eclipse.gmf.runtime.diagram.ui.internal.requests.RecalculatePageBreaksRequest;

/**
 * 
 * Handler for the Recalculate Page Breaks Action
 * 
 * 
 */
@SuppressWarnings("restriction")
public class RecalculatePageBreaksHandler extends AbstractViewHandler {


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public RecalculatePageBreaksHandler() {
		super(WorkspaceViewerProperties.VIEWPAGEBREAKS);
	}

	/**
	 * 
	 * Execute the request via the preformRequest() call. This action does
	 * not modify the model and does not use the request/command infrastructure.
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.menu.actions.handlers.AbstractViewHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		RecalculatePageBreaksRequest request = new RecalculatePageBreaksRequest();
		//not done in a CommandStack! (like the original!)
		((DiagramRootEditPart)getDiagramEditPart().getRoot()).performRequest(request);
		return null;
	}

}
