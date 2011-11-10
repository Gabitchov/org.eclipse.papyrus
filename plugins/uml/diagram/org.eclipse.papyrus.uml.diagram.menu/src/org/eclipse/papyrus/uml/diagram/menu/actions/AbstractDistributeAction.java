package org.eclipse.papyrus.uml.diagram.menu.actions;

/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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


import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.common.layout.DistributionConstants;



/**
 * The Class AbstractDistributeAction.
 */
abstract public class AbstractDistributeAction {

	/**
	 * Indicates if we are in a degraded mode for the vertical distribution
	 * this value is changed by {@link #calculatesSpaceBetweenNodes(PrecisionRectangle, List)}
	 */
	protected boolean verticalDegradedMode = false;


	/**
	 * Indicates if we are in a degraded mode for the horizontal distribution
	 * this value is changed by {@link #calculatesSpaceBetweenNodes(PrecisionRectangle, List)}
	 */
	protected boolean horizontalDegradedMode = false;

	/** the selected elements for this action */
	protected List<IGraphicalEditPart> selectedElements;

	/** the distribution type */
	protected int distribution;

	/**
	 * Checks if is horizontal degraded mode.
	 * 
	 * @return true, if is horizontal degraded mode
	 */
	public boolean isHorizontalDegradedMode() {
		return horizontalDegradedMode;
	}

	/**
	 * Checks if is vertical degraded mode.
	 * 
	 * @return true, if is vertical degraded mode
	 */
	public boolean isVerticalDegradedMode() {
		return verticalDegradedMode;
	}


	/**
	 * Sets the vertical degraded mode.
	 * 
	 * @param verticalDegradedMode
	 *        the new vertical degraded mode
	 */
	public void setVerticalDegradedMode(boolean verticalDegradedMode) {
		this.verticalDegradedMode = verticalDegradedMode;
	}

	/**
	 * Sets the horizontal degraded mode.
	 * 
	 * @param horizontalDegradedMode
	 *        the new horizontal degraded mode
	 */
	public void setHorizontalDegradedMode(boolean horizontalDegradedMode) {
		this.horizontalDegradedMode = horizontalDegradedMode;
	}

	/**
	 * Gets the distribution.
	 * 
	 * @return the distribution
	 */
	public int getDistribution() {
		return this.distribution;
	}


	/**
	 * 
	 * Constructor.
	 * 
	 * @param distribution
	 *        the distribution
	 * @param selectedElements
	 *        the selected elements for the action
	 */
	public AbstractDistributeAction(int distribution, List<IGraphicalEditPart> selectedElements) {
		this.distribution = distribution;
		this.selectedElements = selectedElements;
		buildAction(selectedElements);
	}

	/**
	 * We build the different elements used to do the action
	 * 
	 * @param elementsForAction
	 *        the elements on which this action is applied
	 */
	abstract protected void buildAction(List<?> elementsForAction);

	/**
	 * Return the command to do this action
	 * 
	 * @return
	 *         the command to do this action
	 */
	abstract public Command getCommand();

	/**
	 * 
	 * @param selectedElements
	 *        the element on which the command is applied
	 * @return
	 *         <ul>
	 *         <li> <code>true</code> if the command can be build</li>
	 *         <li> <code>false</code> if not</li>
	 *         </ul>
	 */
	protected boolean canExistCommand(List<?> selectedElements) {
		switch(this.distribution) {
		case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
			if(selectedElements.size() >= 1) {
				return true;
			}
			break;
		case DistributionConstants.DISTRIBUTE_H_NODES_INT:
			if(selectedElements.size() > 2) {
				return true;
			}
			break;
		case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
			if(selectedElements.size() >= 1) {
				return true;
			}
			break;
		case DistributionConstants.DISTRIBUTE_V_NODES_INT:
			if(selectedElements.size() > 2) {
				return true;
			}
			break;
		default:
			break;
		}
		return false;
	}
}
