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
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.List;

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.notation.Routing;

/**
 * The Line Style Action
 * 
 * Adapted from {@link RouterAction}
 * 
 */
public class LineStyleAction extends AbstractGraphicalParametricAction {

	/** possible parameters for this action */
	public static final String RECTILINEAR = "rectilinear"; //$NON-NLS-1$

	public static final String OBLIQUE = "oblique"; //$NON-NLS-1$

	public static final String TREE = "tree"; //$NON-NLS-1$

	public static final String REMOVE_BENDPOINTS = "remove_benpoints"; //$NON-NLS-1$

	/** property ID */
	public static final String PROPERTY_ID = "notation.RoutingStyle.routing"; //$NON-NLS-1$

	/** property name */
	public static final String PROPERTY_NAME = "Routing"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 * @param selectedEditPart
	 */
	public LineStyleAction(String parameter, List<IGraphicalEditPart> selectedEditPart) {
		super(parameter, selectedEditPart);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.menu.actions.AbstractGraphicalParametricAction#getBuildedCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getBuildedCommand() {
		CompoundCommand command = new CompoundCommand("Routing command"); //$NON-NLS-1$

		ChangePropertyValueRequest request = new ChangePropertyValueRequest(PROPERTY_NAME, PROPERTY_ID);
		request.setValue(getValue());
		//if we want removes the bendpoints, we change the style of routing too!
		for(IGraphicalEditPart current : getSelection()) {
			if(getParameter().equals(REMOVE_BENDPOINTS)) {
				Command cmd = current.getCommand(new SetAllBendpointRequest(RequestConstants.REQ_SET_ALL_BENDPOINT, new PointList(), null, null));
				if(cmd != null && cmd.canExecute()) {
					command.add(cmd);
				}
			}


			Command cmd = current.getCommand(request);
			if(cmd != null && cmd.canExecute()) {
				command.add(cmd);
			}
		}

		return (command != null && !command.isEmpty()) ? command : UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the routing value for the action
	 * 
	 * @return
	 *         the routing value
	 */
	private Routing getValue() {
		if(getParameter().equals(LineStyleAction.RECTILINEAR)) {
			return Routing.RECTILINEAR_LITERAL;
		} else if(getParameter().equals(LineStyleAction.OBLIQUE)) {
			return Routing.MANUAL_LITERAL;
		} else if(getParameter().equals(LineStyleAction.TREE)) {
			return Routing.TREE_LITERAL;
		} else if(getParameter().equals(LineStyleAction.REMOVE_BENDPOINTS)) {
			return Routing.MANUAL_LITERAL;
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.menu.actions.AbstractParametricAction#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		for(IGraphicalEditPart current : getSelection()) {
			if(!(current instanceof ConnectionEditPart)) {
				return false;
			}

			//specific behavior when the routing style is TREE
			if(this.getParameter().equals(LineStyleAction.TREE)) {
				if(!(current instanceof ITreeBranchEditPart)) {
					return false;
				}
			}
		}

		/*
		 * The initial GMF Action forbids to play the action when only 1 connection is selected, but the Papyrus Property View allow
		 * that. I comment this code to be coherent with Papyrus.
		 */
		//specific behavior when the routing style is TREE
		//		if(this.getParameter().equals(LineStyleAction.TREE) && getSelection().size() < 2) {
		//			return false;
		//		}
		return true;
	}
}
