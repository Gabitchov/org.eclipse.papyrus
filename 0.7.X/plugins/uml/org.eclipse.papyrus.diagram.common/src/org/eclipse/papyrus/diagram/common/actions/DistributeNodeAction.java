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
package org.eclipse.papyrus.diagram.common.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;
import org.eclipse.papyrus.diagram.common.layout.DistributionTree;
import org.eclipse.papyrus.diagram.common.layout.EditPartTree;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;

/**
 * 
 * This action allows to distribute element in the diagram or in their container
 * 
 */
public class DistributeNodeAction extends AbstractDistributeAction {

	/** the tree used to organize the editpart */
	private EditPartTree rootTree;

	/** indicates if the bounds used for the distribution are the parent bounds */
	private boolean parentContainer;

	/** a margin used between the editpart and its container */
	private double margin = 10;

	public DistributeNodeAction(int distribution, List<IGraphicalEditPart> selectedElements) {
		super(distribution, selectedElements);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractDistributeAction#buildAction(java.util.List)
	 * 
	 * @param elementsForAction
	 */
	@Override
	protected void buildAction(List<?> elementsForAction) {
		switch(distribution) {
		case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
		case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
			this.parentContainer = true;
			break;
		case DistributionConstants.DISTRIBUTE_H_NODES_INT:
		case DistributionConstants.DISTRIBUTE_V_NODES_INT:
			this.parentContainer = false;
			break;
		default:
			break;
		}
		List<EditPart> elements = new ArrayList<EditPart>();
		for(int i = 0; i < elementsForAction.size(); i++) {
			elements.add(i, (EditPart)elementsForAction.get(i));
		}

		rootTree = new DistributionTree(elements);
		//we create the requests and store them in rootTree
		createRequests(elements);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractDistributeAction#getCommand()
	 * 
	 * @return
	 */
	@Override
	public Command getCommand() {
		CompoundCommand command = new CompoundCommand("Command to Distribute Nodes"); //$NON-NLS-1$
		Enumeration eptEnum = rootTree.breadthFirstEnumeration();
		while(eptEnum.hasMoreElements()) {
			EditPartTree ept = (EditPartTree)eptEnum.nextElement();
			if(ept.getEditPart() != null) {
				ChangeBoundsRequest currentReq = (ChangeBoundsRequest)ept.getRequest();
				if(currentReq != null) {
					Command curCommand = null;
					curCommand = ept.getEditPart().getCommand(currentReq);
					if(curCommand != null) {
						command.add(curCommand);
					}
				}
			}
		}

		return command.isEmpty() ? UnexecutableCommand.INSTANCE : (Command)command;
	}



	/**
	 * 
	 * Create the request for each editpart. Each request is stored in the node of the LayoutTree corresponding to this editpart
	 * 
	 * @param editparts
	 *        the editparts to distribute
	 * 
	 */
	protected void createRequests(List<EditPart> editparts) {
		int depth = this.rootTree.getDepth();
		for(int i = depth; i >= 0; i--) {//we iterate by level in the rootTree, beginning by the deepest level
			List<EditPartTree> epTrees = rootTree.getChildLevel(i);//get all the node of the same level
			if(i == 0) {//we work on the children of the children of epTree, but we have a problem when we want distribute element for the level 1!
				epTrees.add(rootTree);
			}
			for(int iter = 0; iter < epTrees.size(); iter++) {//we iterate on the same level nodes
				//get all the children for this node
				List<EditPartTree> children = epTrees.get(iter).getChildLevel(1);
				removeUnselectedTree(children);
				if((children.size() >= 2 && parentContainer) || (children.size() >= 3 && !parentContainer)) {

					//get the corresponding editparts
					List<EditPart> childrenEP = new ArrayList<EditPart>();
					for(EditPartTree editPartTree : children) {
						childrenEP.add(editPartTree.getEditPart());
					}

					//obtain the container area for these elements
					PrecisionRectangle boundsArea = calcultateArea(childrenEP);

					//we put a small space between the container and the node
					if(parentContainer/* && !isPortSelection */) {
						if(!(children.get(0).getEditPart().getParent() instanceof RootEditPart)) {//when the parent is the diagram, we doesn't add a margin!
							double usedMargin = margin > LayoutUtils.scrollBarSize ? margin : LayoutUtils.scrollBarSize;
							boundsArea.setX(boundsArea.preciseX() + usedMargin);
							boundsArea.setY(boundsArea.preciseY() + usedMargin);
							boundsArea.setWidth(boundsArea.preciseWidth() - 2 * usedMargin);
							boundsArea.setHeight(boundsArea.preciseHeight() - 2 * usedMargin);
						}
					}

					double[] hSpaceAndvSpace = calculatesSpaceBetweenNodes(boundsArea, childrenEP);
					//we sort the EditpartTree following x or y value (it depends on the action)
					Collections.sort(children, new CoordinatesComparator());

					//variable containing the new position for the editpart (x or y following the distribution) 
					double newPosition = 0;
					//we determine the location for the first editpart
					switch(this.distribution) {
					case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
						newPosition = (horizontalDegradedMode == false) ? (boundsArea.preciseX + hSpaceAndvSpace[0]) : boundsArea.preciseX();
						break;
					case DistributionConstants.DISTRIBUTE_H_NODES_INT:
						newPosition = boundsArea.preciseX;
						break;
					case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
						newPosition = (verticalDegradedMode == false) ? (boundsArea.preciseY + hSpaceAndvSpace[1]) : boundsArea.preciseY();
						break;
					case DistributionConstants.DISTRIBUTE_V_NODES_INT:
						newPosition = boundsArea.preciseY;
						break;
					default:
						break;
					}


					//request creation for all editparts
					for(EditPartTree editPartTree : children) {
						if(editPartTree.isSelected()) {
							//the new location for the editpart
							PrecisionPoint ptLocation = null;
							PrecisionRectangle absolutePosition = LayoutUtils.getAbsolutePosition(editPartTree.getEditPart());

							//							if(!isPortSelection) {
							if(this.distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || this.distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
								ptLocation = new PrecisionPoint(newPosition, absolutePosition.preciseY);
								newPosition += absolutePosition.preciseWidth() + hSpaceAndvSpace[0];
							} else {//vertical distribution
								ptLocation = new PrecisionPoint(absolutePosition.preciseX, newPosition);
								newPosition += absolutePosition.preciseHeight() + hSpaceAndvSpace[1];
							}


							//we create the request
							if(ptLocation != null) {
								ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
								req.setEditParts(editPartTree.getEditPart());
								PrecisionPoint oldLocation = new PrecisionPoint(absolutePosition.preciseX, absolutePosition.preciseY);
								Dimension delta = ptLocation.getDifference(oldLocation);
								req.setMoveDelta(new Point(delta.width, delta.height));
								req.setSizeDelta(absolutePosition.getSize().getDifference(absolutePosition.getSize()));
								editPartTree.setRequest(req);
							}

						}
					}


				}
			}
		}
	}


	/**
	 * Removes the unselected {@link EditPartTree} from the list
	 * 
	 * @param epTrees
	 *        the {@link EditPartTree} list
	 */
	protected void removeUnselectedTree(List<EditPartTree> epTrees) {
		List<EditPartTree> removedChildren = new ArrayList<EditPartTree>();
		for(EditPartTree editPartTree : epTrees) {
			if(!editPartTree.isSelected()) {
				removedChildren.add(editPartTree);
			}
		}
		epTrees.removeAll(removedChildren);
	}

	/**
	 * Calculates the area used to do the distribution
	 * 
	 * @param nodeChild
	 *        the editpart to distribute
	 * @return
	 *         an area in which we can move the editpart
	 */
	protected PrecisionRectangle calcultateArea(List<EditPart> nodeChild) {
		//the returned area
		PrecisionRectangle area = new PrecisionRectangle();

		if(parentContainer) {
			area = LayoutUtils.getAbsolutePosition(nodeChild.get(0).getParent());
		} else {
			PrecisionRectangle tmpArea;
			tmpArea = LayoutUtils.getAbsolutePosition(nodeChild.get(0));
			double minX = tmpArea.preciseX();
			double maxX = tmpArea.preciseX() + tmpArea.preciseWidth();
			double minY = tmpArea.preciseY();
			double maxY = tmpArea.preciseY() + tmpArea.preciseHeight();

			for(EditPart currentEP : nodeChild) {//we search the rectangle containing all the selected editpart
				if(currentEP.getSelected() != EditPart.SELECTED_NONE) {
					tmpArea = LayoutUtils.getAbsolutePosition(currentEP);
					minX = tmpArea.preciseX < minX ? tmpArea.preciseX : minX;
					minY = tmpArea.preciseY < minY ? tmpArea.preciseY : minY;
					maxX = tmpArea.getTopRight().preciseX() > maxX ? tmpArea.getTopRight().preciseX() : maxX;
					maxY = tmpArea.getBottomRight().preciseY() > maxY ? tmpArea.getBottomRight().preciseY() : maxY;
				}
			}
			area.setX(minX);
			area.setY(minY);
			area.setHeight(java.lang.Math.abs(maxY - minY));
			area.setWidth(java.lang.Math.abs(maxX - minX));

		}
		return area;
	}

	/**
	 * Calculates the horizontal space and the vertical space to distribute the nodes
	 * Set the fields {@link #horizontalDegradedMode} and {@link #verticalDegradedMode} to {@code true} or {@code false}
	 * 
	 * @param boundsArea
	 *        the Rectangle used to do the distribution
	 * @param nodeChild
	 *        the node to distribute in the Rectangle
	 * @return {@code double[2]} with :
	 *         <ul>
	 *         <li>{@code double[0]} : the horizontal space between the nodes</li>
	 *         <li>{@code double[1]} : the vertical space between the nodes</li>
	 *         </ul>
	 */
	protected double[] calculatesSpaceBetweenNodes(PrecisionRectangle boundsArea, List<EditPart> nodeChild) {

		//reset of these 2 fields
		this.horizontalDegradedMode = false;
		this.verticalDegradedMode = false;

		//variables used to calculate the spacing
		double vertical = 0;
		double horizontal = 0;
		double vSpace = 0;
		double hSpace = 0;
		double[] hSpaceAndvSpace = new double[]{ 0, 0 };

		//we calculate the length take by the element
		for(EditPart currentEP : nodeChild) {
			if(currentEP.getSelected() != EditPart.SELECTED_NONE) {//if the node is not selected, we ignore it
				PrecisionRectangle rect = LayoutUtils.getAbsolutePosition(currentEP);
				vertical += rect.preciseHeight();
				horizontal += rect.preciseWidth();
			}
		}

		//we determine the divisor 
		double divisor = 1;
		if(parentContainer) {
			divisor = nodeChild.size() + 1;
		} else if(!parentContainer) {
			divisor = nodeChild.size() - 1;
		}

		hSpace = ((boundsArea.preciseWidth() - horizontal) / divisor);
		vSpace = ((boundsArea.preciseHeight() - vertical) / divisor);


		if(hSpace < 0 && parentContainer) {
			this.horizontalDegradedMode = true;
			double diff = boundsArea.preciseWidth() - horizontal;
			hSpace = diff / (divisor - 2);

		}

		if(vSpace < 0 && parentContainer) {
			this.verticalDegradedMode = true;
			double diff = boundsArea.preciseHeight() - vertical;
			vSpace = diff / (divisor - 2);

		}

		hSpaceAndvSpace[0] = hSpace;
		hSpaceAndvSpace[1] = vSpace;
		return hSpaceAndvSpace;
	}


	/**
	 * 
	 * This class provides a comparator for the {@link EditPartTree}, using the coordinates of the representing {@link EditPart}
	 */
	protected class CoordinatesComparator implements Comparator<Object> {

		/**
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * 
		 * @param o1
		 * @param o2
		 * @return
		 */
		public int compare(Object o1, Object o2) {
			PrecisionRectangle rect1 = LayoutUtils.getAbsolutePosition(((EditPartTree)o1).getEditPart());
			PrecisionRectangle rect2 = LayoutUtils.getAbsolutePosition(((EditPartTree)o2).getEditPart());
			if(distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
				if(rect1.preciseX() < rect2.preciseX()) {
					return -1;
				} else if(rect1.preciseX() == rect2.preciseX()) {
					return 0;
				} else {
					return 1;
				}
			} else //vertical distribution 
			if(rect1.preciseY() < rect2.preciseY()) {
				return -1;
			} else if(rect1.preciseY() == rect2.preciseY()) {
				return 0;
			} else {
				return 1;
			}
		}
	}



}
