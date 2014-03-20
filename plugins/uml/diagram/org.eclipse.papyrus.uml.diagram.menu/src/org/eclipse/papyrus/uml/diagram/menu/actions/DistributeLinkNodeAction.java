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
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.common.layout.DistributionConstants;
import org.eclipse.papyrus.uml.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.uml.diagram.common.util.Util;

/**
 * 
 * This class provides actions for the objects distribution.
 * 
 */
public class DistributeLinkNodeAction {

	/** the distribution type */
	private int distribution;

	/** the selected elements */
	private List<IGraphicalEditPart> selectedElements;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        the distribution parameter
	 * @param selectedElements
	 *        the selected elements for this action
	 */
	public DistributeLinkNodeAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		this.selectedElements = selectedElements;
		this.distribution = getDistributionValue(parameter);
	}

	/**
	 * Return the distribution type
	 * 
	 * @param param
	 *        the parameter of this action
	 * @return
	 *         the distribution type
	 */
	protected int getDistributionValue(String param) {
		if(param.equals(LayoutUtils.HORIZONTALLY)) {
			return DistributionConstants.DISTRIBUTE_H_CONTAINER_INT;
		} else if(param.equals(LayoutUtils.HORIZONTALLY_BETWEEN_NODES)) {
			return DistributionConstants.DISTRIBUTE_H_NODES_INT;
		} else if(param.equals(LayoutUtils.VERTICALLY)) {
			return DistributionConstants.DISTRIBUTE_V_CONTAINER_INT;
		} else if(param.equals(LayoutUtils.VERTICALLY_BETWEEN_NODES)) {
			return DistributionConstants.DISTRIBUTE_V_NODES_INT;
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
		Command command = null;
		AbstractDistributeAction action;
		int selectionType = getSelectionType(selectedElements);
		switch(selectionType) {
		case 1: //affixed child nodes and links selection
			action = new DistributeAffixedChildNodeLinkAction(distribution, selectedElements);
			//action = new DistributeAffixedChildNodeLinkActionV2(distribution, selectedElements);
			command = action.getCommand();
			break;
		case 2: //others nodes selection
			action = new DistributeNodeAction(distribution, selectedElements);
			command = action.getCommand();
			break;
		case 3: //bad selection (nodes and links)
			command = UnexecutableCommand.INSTANCE;
			break;
		default:
			break;
		}
		return command != null ? command : UnexecutableCommand.INSTANCE;
	}


	/**
	 * 
	 * @param selectedElements
	 *        a list of element
	 * @return
	 *         <ul>
	 *         <li>1</li> the list contains links and affixed Child Nodes and editparts
	 *         <li>2</li> the contains others elements
	 *         <li>3</li> the list is a mised between affixed Child Node/Link and others elements
	 *         </ul>
	 */
	private int getSelectionType(List<IGraphicalEditPart> selectedElements) {
		boolean affixedChildNodeAndLink = false;
		boolean otherElement = false;
		boolean badSelection = false;
		for(IGraphicalEditPart current : selectedElements) {
			if(current instanceof DiagramEditPart) {
				badSelection = true;
			} else if(current instanceof ConnectionEditPart) {
				affixedChildNodeAndLink = true;
			} else if(Util.isAffixedChildNode(current)) {
				affixedChildNodeAndLink = true;
			} else {
				otherElement = true;
			}
		}
		if(badSelection) {
			return 3;
		} else if(otherElement != affixedChildNodeAndLink) {
			if(affixedChildNodeAndLink) {
				return 1;
			}
			if(otherElement) {
				return 2;
			}

		}
		return 3;
	}

	//Replaced by a new method in util.Util
	//	/**
	//	 * Test if the element is an Affixed Child Node
	//	 * 
	//	 * @param editpart
	//	 * @return
	//	 *         <ul>
	//	 *         <li> <code>true</code> if the editpart is an Affixed Child Node</li>
	//	 *         <li> <code>false</code>if not</li>
	//	 *         </ul>
	//	 */
	//	private boolean isAffixedChildNode(IGraphicalEditPart editpart) {
	//		if(editpart.getParent() instanceof CompartmentEditPart) {
	//			return false;
	//		} else if(editpart.getParent() instanceof DiagramEditPart) {
	//			return false;
	//		}
	//		return true;
	//	}


}
