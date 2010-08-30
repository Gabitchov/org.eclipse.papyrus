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
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.papyrus.diagram.common.editparts.AbstractBorderEditPart;
import org.eclipse.papyrus.diagram.common.editparts.BorderNamedElementEditPart;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.diagram.common.layout.LinkRepresentationForDistributeAction;


public class DistributeAffixedChildNodeLinkAction extends AbstractDistributeAction {

	/** This list is used to regroup the selected elements by their common parent */
	private List<NodeRepresentation> commonParentRepresentations;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param distribution
	 *        the distribution
	 * @param selectedElements
	 *        the selected elements to do the distribution
	 */
	public DistributeAffixedChildNodeLinkAction(int distribution, List<IGraphicalEditPart> selectedElements) {
		super(distribution, selectedElements);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractDistributeAction#buildAction(java.util.List)
	 * 
	 * @param list
	 */
	@Override
	protected void buildAction(List<?> list) {
		this.commonParentRepresentations = new ArrayList<DistributeAffixedChildNodeLinkAction.NodeRepresentation>();
		// we sort the list to get this order: 
		// 1: possible parents EditPart
		// 2: Affixed Child Node
		// 3: ConnectionEditPart
		Collections.sort(list, new TypeComparator());
		for(Object current : list) {
			NodeRepresentation representation;
			if((current instanceof ConnectionEditPart)) {
				representation = getCorrespondingRepresentation((EditPart)current);
				if(representation != null) {
					representation.addElements((EditPart)current);
				} else {
					//not possible with the preceding algorithms
				}
			} else if(isAffixedChildNode((EditPart)current)) {
				representation = getCorrespondingRepresentation((EditPart)current);
				if(representation != null) {
					representation.addElements((EditPart)current);
				} else {
					this.commonParentRepresentations.add(new NodeRepresentation(((EditPart)current).getParent()));
					representation = getCorrespondingRepresentation((EditPart)current);
					representation.addElements((EditPart)current);
				}
			} else {
				this.commonParentRepresentations.add(new NodeRepresentation((EditPart)current));
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractDistributeAction#getCommand()
	 * 
	 * @return
	 */
	@Override
	public Command getCommand() {
		CompoundCommand command = new CompoundCommand("Distribute Affixed Child Nodes and Links"); //$NON-NLS-1$
		for(NodeRepresentation current : this.commonParentRepresentations) {
			CompoundCommand cmd = current.getCommand();
			if(cmd != null && cmd.canExecute()) {
				command.add(cmd);
			}
		}
		return command.isEmpty() ? UnexecutableCommand.INSTANCE : (Command)command;
	}

	/**
	 * Return The {@link NodeRepresentation} owning the editpart or <code>null</code> if not found
	 * 
	 * @param ep
	 *        an editpart
	 * @return
	 *         The {@link NodeRepresentation} owning the editpart or <code>null</code> if not found
	 */
	protected NodeRepresentation getCorrespondingRepresentation(EditPart ep) {
		if(ep instanceof ConnectionEditPart) {
			EditPart source = ((ConnectionEditPart)ep).getSource();
			EditPart target = ((ConnectionEditPart)ep).getTarget();
			for(NodeRepresentation current : commonParentRepresentations) {
				EditPart node = current.getRepresentedNode();
				if(node == source || node == target) {
					return current;
				}
			}
		} else if(isAffixedChildNode(ep)) {
			EditPart parent = ep.getParent();
			for(NodeRepresentation current : commonParentRepresentations) {
				if(current.getRepresentedNode() == parent) {
					return current;
				}
			}
		}
		return null;
	}

	/**
	 * Test if the EditPart is an Affixed Child Node
	 * 
	 * @param ep
	 *        an EditPart
	 * @return
	 *         <code>true</code> if the {@link EditPart} is an affixed child node and <code>false</code> if not
	 */
	protected boolean isAffixedChildNode(EditPart ep) {
		if(ep.getParent() instanceof CompartmentEditPart) {
			return false;
		} else if(ep.getParent() instanceof DiagramEditPart) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * This class provides facilities to represent a parent with its children that we want to distribute
	 * 
	 */
	protected class NodeRepresentation {

		/** the node represented by this class */
		private EditPart representedNode;

		/** the elements to distribute */
		private List<Object> elementsToDistribute = new ArrayList<Object>();

		/**
		 * 
		 * Constructor.
		 * 
		 * @param representedNode
		 *        the represented EditPart
		 */
		public NodeRepresentation(EditPart representedNode) {
			this.representedNode = representedNode;
		}

		/**
		 * Return the command to distribute the children owned by the {@link #representedNode}
		 * 
		 * @return
		 *         the command to distribute the children owned by the {@link #representedNode}
		 */
		public CompoundCommand getCommand() {
			CompoundCommand command = new CompoundCommand("Distribution Command"); //$NON-NLS-1$
			if(!canExistCommand(elementsToDistribute)) {
				command.add(UnexecutableCommand.INSTANCE);
			} else {

				Collections.sort(this.elementsToDistribute, new CoordinatesComparator());
				//PrecisionRectangle bounds = 
				PrecisionRectangle boundsArea = calcultateArea(this.representedNode);//LayoutUtils.getAbsolutePosition(this.representedNode);
				double[] hSpaceAndvSpace = calculatesSpaceBetweenNodes(boundsArea, this.elementsToDistribute);


				//variable containing the new position for the editpart (x or y following the distribution) 
				double newPosition = 0;
				//we determine the location for the first editpart
				switch(distribution) {
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
				//these 4 booleans indicates if we have already consider a port located on a bad side for the chosen action
				boolean eastPort = false;
				boolean westPort = false;
				boolean northPort = false;
				boolean southPort = false;

				for(Object current : elementsToDistribute) {
					int side = PositionConstants.NONE;
					PrecisionRectangle absolutePosition = null;
					//the new location for the editpart
					PrecisionPoint ptLocation = null;
					if(current instanceof LinkRepresentationForDistributeAction) {
						side = ((LinkRepresentationForDistributeAction)current).getCurrentSideOnMovingNode();
						absolutePosition = ((LinkRepresentationForDistributeAction)current).getAbsolutePosition();
					} else {//it's an affixed child node
						side = ((AbstractBorderEditPart)current).getBorderItemLocator().getCurrentSideOfParent();
						absolutePosition = LayoutUtils.getAbsolutePosition((EditPart)current);
					}

					switch(distribution) {
					case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
						if(DistributionConstants.horizontalValuesList.contains(side)) {
							ptLocation = new PrecisionPoint(newPosition, absolutePosition.preciseY);
							newPosition += absolutePosition.preciseWidth() + hSpaceAndvSpace[0];
						}
						break;
					case DistributionConstants.DISTRIBUTE_H_NODES_INT:
						if(DistributionConstants.horizontalValuesList.contains(side)) {
							ptLocation = new PrecisionPoint(newPosition, absolutePosition.preciseY);
							newPosition += absolutePosition.preciseWidth() + hSpaceAndvSpace[0];
						} else if(eastPort == false && side == PositionConstants.EAST) {
							eastPort = true;
							ptLocation = new PrecisionPoint(absolutePosition.preciseX, absolutePosition.preciseY);
							newPosition += absolutePosition.preciseWidth() + hSpaceAndvSpace[0];
						} else if(westPort == false && side == PositionConstants.WEST) {
							westPort = true;
							ptLocation = new PrecisionPoint(absolutePosition.preciseX, absolutePosition.preciseY);
							newPosition += absolutePosition.preciseWidth() + hSpaceAndvSpace[0];
						}
						break;
					case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
						if(DistributionConstants.verticalValuesList.contains(side)) {
							ptLocation = new PrecisionPoint(absolutePosition.preciseX, newPosition);
							newPosition += absolutePosition.preciseHeight() + hSpaceAndvSpace[1];
						}
						break;
					case DistributionConstants.DISTRIBUTE_V_NODES_INT:
						if(DistributionConstants.verticalValuesList.contains(side)) {
							ptLocation = new PrecisionPoint(absolutePosition.preciseX, newPosition);
							newPosition += absolutePosition.preciseHeight() + hSpaceAndvSpace[1];
						} else if(northPort == false && side == PositionConstants.NORTH) {
							northPort = true;
							ptLocation = new PrecisionPoint(absolutePosition.preciseX, absolutePosition.preciseY);
							newPosition += absolutePosition.preciseHeight() + hSpaceAndvSpace[1];
						} else if(southPort == false && side == PositionConstants.SOUTH) {
							southPort = true;
							ptLocation = new PrecisionPoint(absolutePosition.preciseX, absolutePosition.preciseY);
							newPosition += absolutePosition.preciseHeight() + hSpaceAndvSpace[1];
						}

						break;
					default:
						break;
					}

					Command cmd = null;
					if(current instanceof LinkRepresentationForDistributeAction) {
						((LinkRepresentationForDistributeAction)current).setNewPosition(ptLocation);
						cmd = ((LinkRepresentationForDistributeAction)current).getCommand();
					} else {//we are with port
						ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
						req.setEditParts((EditPart)current);
						PrecisionPoint oldLocation = new PrecisionPoint(absolutePosition.preciseX, absolutePosition.preciseY);
						Dimension delta = ptLocation.getDifference(oldLocation);
						req.setMoveDelta(new Point(delta.width, delta.height));
						req.setSizeDelta(absolutePosition.getSize().getDifference(absolutePosition.getSize()));
						cmd = ((EditPart)current).getCommand(req);
					}
					if(cmd != null && cmd.canExecute()) {
						command.add(cmd);
					}
				}
			}
			return command;
		}

		/**
		 * Calculate the area to do the distribution
		 * 
		 * @param node
		 *        the EditPart owning the elements to distribute
		 * @return
		 *         the area used to do the distribution
		 */
		protected PrecisionRectangle calcultateArea(EditPart node) {
			PrecisionRectangle bounds = new PrecisionRectangle();
			Object first = elementsToDistribute.get(0);
			Object last = elementsToDistribute.get(elementsToDistribute.size() - 1);
			Point locStart;
			Point locEnd;
			switch(distribution) {
			case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
			case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
				bounds = LayoutUtils.getAbsolutePosition(node);
				break;
			case DistributionConstants.DISTRIBUTE_H_NODES_INT:
				if(first instanceof LinkRepresentationForDistributeAction) {
					locStart = ((LinkRepresentationForDistributeAction)first).getMovingAnchorLocation();
				} else {
					locStart = LayoutUtils.getAbsolutePosition((EditPart)first).getTopLeft();
				}

				if(last instanceof LinkRepresentationForDistributeAction) {
					locEnd = ((LinkRepresentationForDistributeAction)last).getMovingAnchorLocation();
				} else {
					locEnd = LayoutUtils.getAbsolutePosition((EditPart)last).getTopRight();
				}
				bounds.setLocation(locStart);
				bounds.setHeight(0);
				bounds.setWidth(locEnd.preciseX() - locStart.preciseX());
				break;
			case DistributionConstants.DISTRIBUTE_V_NODES_INT:
				if(first instanceof LinkRepresentationForDistributeAction) {
					locStart = ((LinkRepresentationForDistributeAction)first).getMovingAnchorLocation();
				} else {
					locStart = LayoutUtils.getAbsolutePosition((EditPart)first).getTopLeft();
				}

				if(last instanceof LinkRepresentationForDistributeAction) {
					locEnd = ((LinkRepresentationForDistributeAction)last).getMovingAnchorLocation();
				} else {
					locEnd = LayoutUtils.getAbsolutePosition((EditPart)last).getBottomLeft();
				}
				bounds.setLocation(locStart);
				bounds.setHeight(locEnd.preciseY() - locStart.preciseY());
				bounds.setWidth(0);
				break;
			default:
				break;
			}


			return bounds;
		}

		/**
		 * Add the EditPart to {@link #elementsToDistribute}
		 * 
		 * @param element
		 *        an EditPart to add to {@link #elementsToDistribute}
		 */
		public void addElements(EditPart element) {
			if(element instanceof ConnectionEditPart) {
				this.elementsToDistribute.add(new LinkRepresentationForDistributeAction((ConnectionEditPart)element, this.representedNode, distribution));
			} else {
				this.elementsToDistribute.add(element);
			}
		}

		/**
		 * Gets the represented node.
		 * 
		 * @return the represented node
		 */
		public EditPart getRepresentedNode() {
			return representedNode;
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
		protected double[] calculatesSpaceBetweenNodes(PrecisionRectangle boundsArea, List<Object> nodeChild) {

			//reset of these 2 fields
			setHorizontalDegradedMode(false);
			setVerticalDegradedMode(false);

			//variables used to calculate the spacing
			double vertical = 0;
			double horizontal = 0;
			double vSpace = 0;
			double hSpace = 0;
			double[] hSpaceAndvSpace = new double[]{ 0, 0 };

			//-------variables used when it's a port selection
			double nbPort = 0;//used to know the number of necessary spaces

			//if a port is on a bad side for the current alignment, we need to count it only one time!
			boolean eastPort = false;
			boolean westPort = false;
			boolean northPort = false;
			boolean southPort = false;

			//we calculate the length take by the element
			for(Object currentEP : nodeChild) {
				//				if(((EditPart)currentEP).getSelected() != EditPart.SELECTED_NONE) {//if the node is not selected, we ignore it
				PrecisionRectangle rect;
				int side;
				if(currentEP instanceof LinkRepresentationForDistributeAction) {
					rect = ((LinkRepresentationForDistributeAction)currentEP).getAbsolutePosition();
					side = ((LinkRepresentationForDistributeAction)currentEP).getCurrentSideOnMovingNode();

				} else {
					rect = LayoutUtils.getAbsolutePosition((EditPart)currentEP);
					IBorderItemLocator loc = ((BorderNamedElementEditPart)currentEP).getBorderItemLocator();
					side = loc.getCurrentSideOfParent();
				}

				switch(distribution) {
				case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
					if(DistributionConstants.horizontalValuesList.contains(side)) {
						vertical += rect.preciseHeight();
						horizontal += rect.preciseWidth();
						nbPort++;
					}
					break;
				case DistributionConstants.DISTRIBUTE_H_NODES_INT:
					if(DistributionConstants.horizontalValuesList.contains(side)) {
						vertical += rect.preciseHeight();
						horizontal += rect.preciseWidth();
						nbPort++;
					} else if(side == PositionConstants.EAST && eastPort == false) {
						/*
						 * the port located on this side are a limit for the action,
						 * so we consider only one port located on the east side
						 */
						eastPort = true;
						vertical += rect.preciseHeight();
						horizontal += rect.preciseWidth();
						nbPort++;

					} else if(side == PositionConstants.WEST && westPort == false) {
						/*
						 * the port located on this side are a limit for the action,
						 * so we consider only one port located on the west side
						 */
						westPort = true;
						vertical += rect.preciseHeight();
						horizontal += rect.preciseWidth();
						nbPort++;
					}
					break;
				case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
					if(DistributionConstants.verticalValuesList.contains(side)) {
						vertical += rect.preciseHeight();
						horizontal += rect.preciseWidth();
						nbPort++;
					}
					break;
				case DistributionConstants.DISTRIBUTE_V_NODES_INT:
					if(DistributionConstants.verticalValuesList.contains(side)) {
						vertical += rect.preciseHeight();
						horizontal += rect.preciseWidth();
						nbPort++;
					} else if(side == PositionConstants.NORTH && northPort == false) {
						/*
						 * the port located on this side are a limit for the action,
						 * so we consider only one port located on the north side
						 */
						northPort = true;
						vertical += rect.preciseHeight();
						horizontal += rect.preciseWidth();
						nbPort++;
					} else if(side == PositionConstants.SOUTH && southPort == false) {
						/*
						 * the port located on this side are a limit for the action,
						 * so we consider only one port located on the south side
						 */
						southPort = true;
						vertical += rect.preciseHeight();
						horizontal += rect.preciseWidth();
						nbPort++;
					}
					break;
				default:
					break;
				}
			}


			//we determine the divisor 
			double divisor;
			if(distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || distribution == DistributionConstants.DISTRIBUTE_V_CONTAINER_INT) {
				divisor = nbPort + 1;
			} else {
				divisor = nbPort - 1;
			}

			hSpace = ((boundsArea.preciseWidth() - horizontal) / divisor);
			vSpace = ((boundsArea.preciseHeight() - vertical) / divisor);


			if(hSpace < 0/* && parentContainer */) {
				setHorizontalDegradedMode(true);
				double diff = boundsArea.preciseWidth() - horizontal;
				hSpace = diff / (divisor - 2);

			}

			if(vSpace < 0 /* && parentContainer */) {
				setVerticalDegradedMode(true);
				double diff = boundsArea.preciseHeight() - vertical;
				vSpace = diff / (divisor - 2);

			}

			hSpaceAndvSpace[0] = hSpace;
			hSpaceAndvSpace[1] = vSpace;
			return hSpaceAndvSpace;
		}
	}



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
			Point location1;
			Point location2;
			if(o1 instanceof LinkRepresentationForDistributeAction) {
				location1 = ((LinkRepresentationForDistributeAction)o1).getMovingAnchorLocation();
			} else {
				location1 = LayoutUtils.getAbsolutePosition((EditPart)o1).getTopLeft();
			}

			if(o2 instanceof LinkRepresentationForDistributeAction) {
				location2 = ((LinkRepresentationForDistributeAction)o2).getMovingAnchorLocation();
			} else {
				location2 = LayoutUtils.getAbsolutePosition((EditPart)o2).getTopLeft();
			}


			if(distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
				//if(param.equals("parameter_horizontally") || param.equals("parameter_horizontally_between_nodes")) {
				if(location1.x < location2.x) {
					return -1;
				} else if(location1.x == location2.x) {
					return 0;
				} else {
					return 1;
				}
			} else { //vertical distribution 
				if(location1.y < location2.y) {
					return -1;
				} else if(location1.y == location2.y) {
					return 0;
				} else {
					return 1;
				}
			}
		}

	}


	/**
	 * 
	 * This comparator sort an EditPart list, ordoning the element in this order :
	 * <ul>
	 * <li>1/ The EditPart which are not included in the following criterias</li>
	 * <li>2/ The Affixed Child Node</li>
	 * <li>3/ The ConnectionEditPart</li>
	 * </ul>
	 * 
	 */
	protected class TypeComparator implements Comparator<Object> {

		/**
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * 
		 * @param o1
		 * @param o2
		 * @return
		 */
		public int compare(Object o1, Object o2) {
			int index1 = getIndex((EditPart)o1);
			int index2 = getIndex((EditPart)o2);

			if(index1 == index2) {
				return 0;
			} else if(index1 < index2) {
				return -1;
			} else {
				return 1;
			}

		}

		/**
		 * Return a int representing the type of EditPart
		 * 
		 * @param ep
		 *        an EditPart
		 * @return
		 *         <ul>
		 *         <li>3 : if the EditPart is a {@link ConnectionEditPart}</li>
		 *         <li>2 : if the EditPart is an Affixed ChildNode EditPart</li>
		 *         <li>1 : in other cases</li>
		 *         </ul>
		 */
		protected int getIndex(EditPart ep) {
			if(ep instanceof ConnectionEditPart) {
				return 3;
			} else if(isAffixedChildNode(ep)) {
				return 2;
			} else {
				return 1;
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractDistributeAction#canExistCommand(java.util.List)
	 * 
	 * @param selectedElements
	 * @return
	 */
	@Override
	protected boolean canExistCommand(List<?> selectedElements) {
		if(canDistributeElement(selectedElements)) {
			List<EditPart> portsAndLinks = new ArrayList<EditPart>();
			for(Object current : selectedElements) {
				if(current instanceof LinkRepresentationForDistributeAction) {
					portsAndLinks.add(((LinkRepresentationForDistributeAction)current).getRepresentedLink());
				} else if(isAffixedChildNode((EditPart)current)) {
					portsAndLinks.add((EditPart)current);
				}
			}
			return super.canExistCommand(portsAndLinks);
		}
		return false;
	}

	private boolean canDistributeElement(List<?> portsAndLinks) {
		int side = -1;
		for(Object current : portsAndLinks) {
			if(current instanceof BorderNamedElementEditPart) {
				IBorderItemLocator loc = ((BorderNamedElementEditPart)current).getBorderItemLocator();
				side = loc.getCurrentSideOfParent();
			} else if(current instanceof LinkRepresentationForDistributeAction) {
				side = ((LinkRepresentationForDistributeAction)current).getCurrentSideOnMovingNode();
			} else {
				break;
			}


			if(this.distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || this.distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
				if(!DistributionConstants.horizontalValuesList.contains(side)) {
					return false;
				}
			} else {//vertical distribution
				if(!DistributionConstants.verticalValuesList.contains(side)) {
					return false;
				}
			}
		}
		return true;
	}

}
