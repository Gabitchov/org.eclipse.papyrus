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
package org.eclipse.papyrus.diagram.common.actions;

import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.diagram.common.layout.LinkRepresentationForRouteAction;

/**
 * 
 * This class provides actions to set links vertical or horizontal
 * 
 * This action is cloned from the GMF AlignAction
 * 
 * @see org.eclipse.gmf.runtime.diagram.ui.actions.AlignAction
 */
public class RouteAction {

	/** the routing type */
	private int routing = PositionConstants.NONE;

	/** the selected elements */
	private List<IGraphicalEditPart> selectedElements;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        the routing parameter
	 * @param selectedElements
	 *        the selected elements for this action
	 */
	public RouteAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		this.selectedElements = selectedElements;
		this.routing = getRoutingValue(parameter);
	}

	/**
	 * Return an int representing the wanted routing for this action
	 * 
	 * @param param
	 *        the routing parameter
	 * @return
	 *         an int representing the wanted routing for this action
	 */
	protected int getRoutingValue(String param) {
		if(param.equals(LayoutUtils.LEFT)) {
			return PositionConstants.LEFT;
		} else if(param.equals(LayoutUtils.RIGHT)) {
			return PositionConstants.RIGHT;
		} else if(param.equals(LayoutUtils.TOP)) {
			return PositionConstants.TOP;
		} else if(param.equals(LayoutUtils.BOTTOM)) {
			return PositionConstants.BOTTOM;
		}
		return PositionConstants.NONE;
	}

	/**
	 * Return the command for this action
	 * 
	 * @return
	 *         The command for this action
	 */
	public Command getCommand() {
		CompoundCommand command = new CompoundCommand();
		if(onlyConnectionEditPart(selectedElements) && this.routing != PositionConstants.NONE) {
			for(IGraphicalEditPart obj : selectedElements) {
				LinkRepresentationForRouteAction link = new LinkRepresentationForRouteAction((ConnectionEditPart)obj, routing);
				Command cmd = link.getCommand();
				if(cmd != UnexecutableCommand.INSTANCE) {
					command.add(cmd);
				}
			}
		}
		return command.canExecute() ? command : UnexecutableCommand.INSTANCE;
	}

	/**
	 * Test if the list is composed by {@link #onlyConnectionEditPart(List)}
	 * 
	 * @param elementsToTest
	 *        the elementsToTest
	 * @return
	 *         <ul>
	 *         <li> <code>true</code> if the list contains only {@link ConnectionEditPart}</li>
	 *         <li> <code>false</code> if not</li>
	 *         </ul>
	 */
	private boolean onlyConnectionEditPart(List<IGraphicalEditPart> elementsToTest) {
		for(IGraphicalEditPart current : elementsToTest) {
			if(!(current instanceof ConnectionEditPart)) {
				return false;
			}
		}
		return true;
	}

	public void getSelectedElement(List<IGraphicalEditPart> selectedElements) {
		this.selectedElements = selectedElements;
	}
}
