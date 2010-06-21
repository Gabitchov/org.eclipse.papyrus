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
package org.eclipse.papyrus.diagram.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.diagram.common.actions.RouteAction;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.diagram.common.layout.RoutingConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;


/**
 * 
 * This class provides keybinding for the alignment actions. The allowed parameters are :
 * <ul>
 * <li> {@link RoutingHandler#LEFT}</li>
 * <li> {@link RoutingHandler#CENTER}</li>
 * <li> {@link RoutingHandler#RIGHT}</li>
 * <li> {@link RoutingHandler#TOP}</li>
 * 
 * </ul>
 * 
 */
public class RoutingHandler extends AbstractHandler {


	/** the alignment */
	private int route = PositionConstants.NONE;

	/** the id for this routing action */
	private String id = null;

	/** the workbenchpage */
	private IWorkbenchPage workbenchPage = null;

	/** the selected elements */
	private ISelection selection = null;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * 
	 */
	public Object execute(ExecutionEvent event) {
		init(event);
		if(this.route != PositionConstants.NONE && workbenchPage != null && ((StructuredSelection)this.selection).size() >= 1) {
			RouteAction action = new RouteAction(workbenchPage, id, route, false);
			action.init();
			if(action.isEnabled()) {
				action.run();
			}
		}
		return null;
	}

	/**
	 * This function initializes the following fields :
	 * <ul>
	 * <li>{@link #route}</li>
	 * <li> {@link #id}</li>
	 * <li> {@link #selection}</li>
	 * <li> {@link #workbenchPage}</li>
	 * </ul>
	 * 
	 * @param evt
	 *        the received event
	 */
	protected void init(ExecutionEvent evt) {
		workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		this.selection = workbenchPage.getSelection();
		String param = evt.getParameter("org.eclipse.papyrus.diagram.common.commandRoutingParameter"); //$NON-NLS-1$
		if(LayoutUtils.LEFT.equals(param)) {
			this.route = PositionConstants.LEFT;
			this.id = RoutingConstants.ROUTING_HORIZONTALLY_BY_LEFT;
		} else if(LayoutUtils.RIGHT.equals(param)) {
			this.route = PositionConstants.RIGHT;
			this.id = RoutingConstants.ROUTING_HORIZONTALLY_BY_RIGHT;
		} else if(LayoutUtils.TOP.equals(param)) {
			this.route = PositionConstants.TOP;
			this.id = RoutingConstants.ROUTING_VERTICALLY_BY_TOP;
		} else if(LayoutUtils.BOTTOM.equals(param)) {
			this.route = PositionConstants.BOTTOM;
			this.id = RoutingConstants.ROUTING_VERTICALLY_BY_BOTTOM;
		}

	}
}
