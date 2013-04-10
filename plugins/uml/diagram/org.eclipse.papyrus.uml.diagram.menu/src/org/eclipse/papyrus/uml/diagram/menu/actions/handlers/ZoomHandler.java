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
import org.eclipse.papyrus.uml.diagram.menu.actions.ZoomAction;

/**
 * Handler for the zoom action
 * 
 * 
 * 
 */
public class ZoomHandler extends AbstractParametricHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ZoomHandler() {
		super("org.eclipse.papyrus.uml.diagram.menu.commandZoomParameter"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ZoomAction action = new ZoomAction(getParameter(), getSelectedElements());
		if(action.isEnabled()) {
			action.doRun(null);
		}
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		ZoomAction action = new ZoomAction(getParameter(), getSelectedElements());
		setBaseEnabled(action.isEnabled());
	}

	/**
	 * 
	 * @return
	 */
	protected String getParameter() {
		return this.parameter == null ? ZoomAction.ZOOM_100_PARAMETER : this.parameter;
	}
}
