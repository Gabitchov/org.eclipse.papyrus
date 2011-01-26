/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.diagram.menu.actions.LineStyleAction;

/**
 * Handler for the Line Style Action
 * 
 * 
 * 
 */
public class LineStyleHandler extends AbstractGraphicalCommandHandler {

	/** id of the parameter for the LineStyleAction */
	public static final String parameterID = "line_style_parameter"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameterID
	 */
	public LineStyleHandler(String parameter) {
		super(parameterID, parameter);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public LineStyleHandler() {
		super(parameterID);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.handlers.AbstractGraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		LineStyleAction action = new LineStyleAction(parameter, getSelectedElements());
		return action.getCommand();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.handlers.AbstractGraphicalCommandHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);

		IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();
		ISelection tmp = viewer.getSelection();

		//trick to force easily the change the toggle status of the line style handler
		viewer.setSelection(new StructuredSelection());
		viewer.setSelection(tmp);
		return null;
	}
}
