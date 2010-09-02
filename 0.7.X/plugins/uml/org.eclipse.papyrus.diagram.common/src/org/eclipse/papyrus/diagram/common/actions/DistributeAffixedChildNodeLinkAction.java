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
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.papyrus.diagram.common.editparts.BorderNamedElementEditPart;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.diagram.common.layout.LinkRepresentationForLayoutAction;
import org.eclipse.papyrus.wizards.Activator;

/**
 * This class provides the action to distribute links and ports on a side of a node
 * Two modes are available for this action :
 * <ul>
 * <li>DISTRIBUTE_ON_ONE_END : the user selects links(and affixed child nodes) and nodes to do the distribution the distribution is done only on this
 * node</li>
 * <li>DISTRIBUTE_ON_TWO_END: the user selects only links (and affixed child nodes) ,the distribution is done on the source node and one the target
 * node</li>
 * </ul>
 * The behavior for Affixed child nodes is the same in the 2 modes, they are distributed in the same time that links.
 */
public class DistributeAffixedChildNodeLinkAction extends AbstractDistributeAction {

	/** This list is used to regroup the selected elements by their common parent. */
	private List<NodeRepresentation> commonParentRepresentations;

	/** mode used for this action. */
	private int mode;

	/** constant for the link selection mode. */
	public final static int DISTRIBUTE_ON_ONE_END = 1;

	/** constant for the link/node selection. */
	public final static int DISTRIBUTE_ON_TWO_END = DISTRIBUTE_ON_ONE_END + 1;

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
	 * Builds the action.
	 * 
	 * @param list
	 *        the list
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractDistributeAction#buildAction(java.util.List)
	 */
	@Override
	protected void buildAction(List<?> list) {
		this.commonParentRepresentations = new ArrayList<DistributeAffixedChildNodeLinkAction.NodeRepresentation>();
		// we sort the list to get this order: 
		// 1: possible parents EditPart
		// 2: Affixed Child Node
		// 3: ConnectionEditPart
		Collections.sort(list, new TypeComparator());

		this.mode = getMode(list);

		for(Object current : list) {
			if((current instanceof ConnectionEditPart)) {
				switch(this.mode) {
				case DISTRIBUTE_ON_ONE_END: //the link representation is owned by only one NodeRepresentation
					NodeRepresentation representation = getCorrespondingRepresentation((EditPart)current);
					if(representation != null) {
						LinkRepresentationForLayoutAction link = new LinkRepresentationForLayoutAction((ConnectionEditPart)current);
						representation.addElements(link);
					} else {//no source and no target are in the selection, this link will no be managed
					}
					break;
				case DISTRIBUTE_ON_TWO_END://the link representation is owned by two NodeRepresentation
					NodeRepresentation representationSource = getCorrespondingRepresentation(((ConnectionEditPart)current).getSource());
					NodeRepresentation representationTarget = getCorrespondingRepresentation(((ConnectionEditPart)current).getTarget());
					LinkRepresentationForLayoutAction linkRep = new LinkRepresentationForLayoutAction((ConnectionEditPart)current);

					//we add the source and the target of the link in the commonParentRepresentations
					if(representationSource == null) {
						representationSource = new NodeRepresentation(((ConnectionEditPart)current).getSource());
						this.commonParentRepresentations.add(representationSource);
					}
					if(representationTarget == null) {
						representationTarget = new NodeRepresentation(((ConnectionEditPart)current).getTarget());
						this.commonParentRepresentations.add(representationTarget);
					}
					representationSource.addElements(linkRep);
					representationTarget.addElements(linkRep);
					break;
				default:
					break;
				}
			} else if(isAffixedChildNode((EditPart)current)) {
				NodeRepresentation representation = getCorrespondingRepresentation((EditPart)current);
				if(representation != null) {
					representation.addElements(new AffixedChildNodeRepresentation((EditPart)current));
				} else {
					representation = new NodeRepresentation(((EditPart)current).getParent());
					this.commonParentRepresentations.add(representation);
					representation.addElements(new AffixedChildNodeRepresentation((EditPart)current));;
				}
			} else {
				this.commonParentRepresentations.add(new NodeRepresentation((EditPart)current));
			}
		}
	}

	/**
	 * Return the mode for this selection.
	 * 
	 * @param list
	 *        the list of the elements to distribute
	 * @return the mode
	 *         the mode for this selection
	 */
	protected int getMode(List<?> list) {
		for(Object current : list) {
			if(current instanceof ConnectionEditPart) {
				EditPart source = ((ConnectionEditPart)current).getSource();
				EditPart target = ((ConnectionEditPart)current).getTarget();
				if(list.contains(source) || list.contains(target)) {
					return DISTRIBUTE_ON_ONE_END;
				}
			}
		}
		return DISTRIBUTE_ON_TWO_END;
	}

	/**
	 * Gets the command.
	 * 
	 * @return the command
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractDistributeAction#getCommand()
	 */
	@Override
	public Command getCommand() {
		CompoundCommand command = new CompoundCommand("Distribute Affixed Child Nodes and Links"); //$NON-NLS-1$
		if(canExistCommand(this.selectedElements) && onOppositeSide()) {
			for(NodeRepresentation current : this.commonParentRepresentations) {
				Command cmd = current.getCommand();
				if(cmd != null && cmd.canExecute()) {
					command.add(cmd);
				}
			}
		}
		return command.isEmpty() ? UnexecutableCommand.INSTANCE : (Command)command;
	}


	/**
	 * On opposite side.
	 * 
	 * @return true, if successful
	 */
	protected boolean onOppositeSide() {
		for(NodeRepresentation current : this.commonParentRepresentations) {
			if(!current.onCorrectSide()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return The {@link NodeRepresentation} owning the editpart or <code>null</code> if not found.
	 * 
	 * @param ep
	 *        an editpart
	 * @return the corresponding representation
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
		} else {// we look for a represented node
			for(NodeRepresentation current : commonParentRepresentations) {
				EditPart node = current.getRepresentedNode();
				if(node == ep) {
					return current;
				}
			}
		}
		return null;
	}

	/**
	 * Test if the EditPart is an Affixed Child Node.
	 * 
	 * @param ep
	 *        an EditPart
	 * @return true, if is affixed child node <code>true</code> if the {@link EditPart} is an affixed child node and <code>false</code> if not
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
	 * This class provides facilities to represent a parent with its children that we want to distribute.
	 * The element to distribute should be {@link LinkRepresentationForLayoutAction} of {@link AffixedChildNodeRepresentation}
	 * 
	 */
	protected class NodeRepresentation {

		/** the node represented by this class. */
		private EditPart representedNode;

		/** the elements to distribute. */
		private List<Object> elementsToDistribute;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param representedNode
		 *        the represented EditPart
		 */
		public NodeRepresentation(EditPart representedNode) {
			this.representedNode = representedNode;
			elementsToDistribute = new ArrayList<Object>();
		}

		/**
		 * Test if the elements to distribute are on a correct side.
		 * 
		 * @return <code>true</code>, if successful, <code>false</code> if not
		 */
		public boolean onCorrectSide() {
			for(Object current : elementsToDistribute) {
				if(current instanceof AffixedChildNodeRepresentation) {
					int side = ((AffixedChildNodeRepresentation)current).getSideOnParent();
					if(distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
						if(!DistributionConstants.horizontalValuesList.contains(side)) {
							return false;
						}
					} else {//vertical distribution
						if(!DistributionConstants.verticalValuesList.contains(side)) {
							return false;
						}
					}
				} else if(current instanceof LinkRepresentationForLayoutAction) {
					int sourceSide = ((LinkRepresentationForLayoutAction)current).getSideOnSource();
					int targetSide = ((LinkRepresentationForLayoutAction)current).getSideOnTarget();
					if(distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
						if(!DistributionConstants.horizontalValuesList.contains(sourceSide) && !DistributionConstants.horizontalValuesList.contains(targetSide)) {
							return false;
						}
					} else {//vertical distribution
						if(!DistributionConstants.verticalValuesList.contains(sourceSide) && !DistributionConstants.verticalValuesList.contains(targetSide)) {
							return false;
						}
					}
				}
			}
			return true;
		}

		/**
		 * This method calculates the new position for the elements
		 */
		public void calculateNewLocations() {
			//we sort the element by coordinates
			Collections.sort(this.elementsToDistribute, new CoordinatesComparator(representedNode));

			PrecisionRectangle boundsArea = calcultateArea(this.representedNode);
			double[] hSpaceAndvSpace = calculatesSpaceBetweenNodes(boundsArea, this.elementsToDistribute, representedNode);


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
				if(current instanceof LinkRepresentationForLayoutAction) {
					side = ((LinkRepresentationForLayoutAction)current).getCurrentSideOn(representedNode);
					absolutePosition = ((LinkRepresentationForLayoutAction)current).getAbsolutePositionOn(representedNode);
				} else if(current instanceof AffixedChildNodeRepresentation) {
					side = ((AffixedChildNodeRepresentation)current).getSideOnParent();
					absolutePosition = ((AffixedChildNodeRepresentation)current).getAbsolutePosition();
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

				if(current instanceof LinkRepresentationForLayoutAction) {
					((LinkRepresentationForLayoutAction)current).setNewLocationFor(representedNode, ptLocation);
				} else if(current instanceof AffixedChildNodeRepresentation) {
					((AffixedChildNodeRepresentation)current).setNewLocation(ptLocation);
				}
			}
		}

		/**
		 * Return the command for this aciton
		 * 
		 * @return
		 *         the command for this action
		 */
		public Command getCommand() {
			calculateNewLocations();
			CompoundCommand command = new CompoundCommand("Distribute Command"); //$NON-NLS-1$
			for(Object obj : elementsToDistribute) {
				Command cmd = null;
				if(obj instanceof AffixedChildNodeRepresentation) {
					cmd = ((AffixedChildNodeRepresentation)obj).getCommand();
				} else if(obj instanceof LinkRepresentationForLayoutAction) {
					cmd = new CompoundCommand("Move Link and remove bendpoints"); //$NON-NLS-1$
					((CompoundCommand)cmd).add(((LinkRepresentationForLayoutAction)obj).getCommand());
					//we remove the bendpoints
					Request noBendpoints = new SetAllBendpointRequest(RequestConstants.REQ_SET_ALL_BENDPOINT, new PointList(), null, null);
					((CompoundCommand)cmd).add(((LinkRepresentationForLayoutAction)obj).getRepresentedLink().getCommand(noBendpoints));
				}
				if(cmd != null && cmd.canExecute()) {
					command.add(cmd);
				}
			}

			return command;
		}

		/**
		 * Calculate the area to do the distribution.
		 * 
		 * @param node
		 *        the EditPart owning the elements to distribute
		 * @return the precision rectangle
		 *         the area used to do the distribution
		 */
		protected PrecisionRectangle calcultateArea(EditPart node) {
			PrecisionRectangle bounds = new PrecisionRectangle();
			Object first = elementsToDistribute.get(0);
			Object last = elementsToDistribute.get(elementsToDistribute.size() - 1);
			Point locStart = new Point();
			PrecisionRectangle locEnd = new PrecisionRectangle();
			switch(distribution) {
			case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
			case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
				bounds = LayoutUtils.getAbsolutePosition(node);
				break;
			case DistributionConstants.DISTRIBUTE_H_NODES_INT:
				if(first instanceof LinkRepresentationForLayoutAction) {
					locStart = ((LinkRepresentationForLayoutAction)first).getAbsoluteLocationOn(representedNode);
				} else if(first instanceof AffixedChildNodeRepresentation) {
					locStart = ((AffixedChildNodeRepresentation)first).getAbsoluteLocation();
				}

				if(last instanceof LinkRepresentationForLayoutAction) {
					locEnd = ((LinkRepresentationForLayoutAction)last).getAbsolutePositionOn(representedNode);
				} else if(last instanceof AffixedChildNodeRepresentation) {
					locEnd = ((AffixedChildNodeRepresentation)last).getAbsolutePosition();
				}
				bounds.setLocation(locStart);
				bounds.setHeight(0);
				bounds.setWidth(locEnd.getRight().preciseX() - locStart.preciseX());
				break;
			case DistributionConstants.DISTRIBUTE_V_NODES_INT:
				if(first instanceof LinkRepresentationForLayoutAction) {
					locStart = ((LinkRepresentationForLayoutAction)first).getAbsoluteLocationOn(representedNode);
				} else if(first instanceof AffixedChildNodeRepresentation) {
					locStart = ((AffixedChildNodeRepresentation)first).getAbsoluteLocation();
				}

				if(last instanceof LinkRepresentationForLayoutAction) {
					locEnd = ((LinkRepresentationForLayoutAction)last).getAbsolutePositionOn(representedNode);
				} else if(last instanceof AffixedChildNodeRepresentation) {
					locEnd = ((AffixedChildNodeRepresentation)last).getAbsolutePosition();
				}
				bounds.setLocation(locStart);
				bounds.setHeight(locEnd.getBottom().preciseY() - locStart.preciseY());
				bounds.setWidth(0);
				break;
			default:
				break;
			}


			return bounds;
		}

		/**
		 * Add an element to {@link #elementsToDistribute}.
		 * 
		 * @param obj
		 *        the obj
		 */
		public void addElements(Object obj) {
			if(!(obj instanceof AffixedChildNodeRepresentation)) {
				if(!(obj instanceof LinkRepresentationForLayoutAction)) {
					Activator.log.debug("The added element has not a correct type"); //$NON-NLS-1$
				}
			}
			this.elementsToDistribute.add(obj);
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
		 * Set the fields {@link #horizontalDegradedMode} and {@link #verticalDegradedMode} to {@code true} or {@code false}.
		 * 
		 * @param boundsArea
		 *        the Rectangle used to do the distribution
		 * @param nodeChild
		 *        the node to distribute in the Rectangle
		 * @param node
		 *        the node
		 * @return {@code double[2]} with :
		 * 
		 */
		protected double[] calculatesSpaceBetweenNodes(PrecisionRectangle boundsArea, List<Object> nodeChild, EditPart node) {

			//reset these 2 fields
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
			for(Object current : nodeChild) {
				PrecisionRectangle rect = new PrecisionRectangle();
				int side = 0;
				if(current instanceof LinkRepresentationForLayoutAction) {
					rect = ((LinkRepresentationForLayoutAction)current).getAbsolutePositionOn(node);
					side = ((LinkRepresentationForLayoutAction)current).getCurrentSideOn(node);

				} else if(current instanceof AffixedChildNodeRepresentation) {
					rect = ((AffixedChildNodeRepresentation)current).getAbsolutePosition();
					side = ((AffixedChildNodeRepresentation)current).getSideOnParent();

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



	/**
	 * The Class CoordinatesComparator.
	 */
	protected class CoordinatesComparator implements Comparator<Object> {

		/** The reference. */
		private EditPart reference;

		/**
		 * Instantiates a new coordinates comparator.
		 * 
		 * @param ep
		 *        the ep
		 */
		public CoordinatesComparator(EditPart ep) {
			this.reference = ep;
		}

		/**
		 * Compare.
		 * 
		 * @param o1
		 *        the o1
		 * @param o2
		 *        the o2
		 * @return the int
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(Object o1, Object o2) {
			Point location1 = new Point();
			Point location2 = new Point();
			if(o1 instanceof LinkRepresentationForLayoutAction) {
				location1 = ((LinkRepresentationForLayoutAction)o1).getAbsoluteLocationOn(reference);
			} else if(o1 instanceof AffixedChildNodeRepresentation) {
				location1 = ((AffixedChildNodeRepresentation)o1).getAbsoluteLocation();
			}
			if(o2 instanceof LinkRepresentationForLayoutAction) {
				location2 = ((LinkRepresentationForLayoutAction)o2).getAbsoluteLocationOn(reference);
			} else if(o2 instanceof AffixedChildNodeRepresentation) {
				location2 = ((AffixedChildNodeRepresentation)o2).getAbsoluteLocation();
			}

			if(distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
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
	 * This comparator sorts an EditPart list, the sorted elements are in this order :
	 * <ul>
	 * <li>1/ The EditPart which are not included in the following criterias</li>
	 * <li>2/ The Affixed Child Node</li>
	 * <li>3/ The ConnectionEditPart</li>
	 * </ul>
	 * .
	 */
	protected class TypeComparator implements Comparator<Object> {

		/**
		 * Compare.
		 * 
		 * @param o1
		 *        the o1
		 * @param o2
		 *        the o2
		 * @return the int
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
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
		 * Return a int representing the type of EditPart.
		 * 
		 * @param ep
		 *        an EditPart
		 * @return the index
		 *         <ul>
		 *         <li>3 : if the EditPart is an Affixed ChildNode EditPart</li>
		 *         <li>2 : if the EditPart is a {@link ConnectionEditPart}</li>
		 *         <li>1 : in other cases</li>
		 *         </ul>
		 */
		protected int getIndex(EditPart ep) {
			if(ep instanceof ConnectionEditPart) {
				return 2;
			} else if(isAffixedChildNode(ep)) {
				return 3;
			} else {
				return 1;
			}
		}
	}

	/**
	 * The Class AffixedChildNodeRepresentation.
	 */
	protected class AffixedChildNodeRepresentation {

		/** the represented affixed child node. */
		private EditPart affixedChildNode;

		/** the new location for the affixed child node. */
		private Point newLocation;

		/**
		 * Instantiates a new affixed child node representation.
		 * 
		 * @param affixedChildNode
		 *        the affixed child node
		 */
		public AffixedChildNodeRepresentation(EditPart affixedChildNode) {
			this.affixedChildNode = affixedChildNode;
		}

		/**
		 * Gets the absolute location.
		 * 
		 * @return the absolute location
		 */
		public Point getAbsoluteLocation() {
			return getAbsolutePosition().getTopLeft();
		}

		/**
		 * Gets the side on parent.
		 * 
		 * @return the side on parent
		 */
		public int getSideOnParent() {
			IBorderItemLocator loc = ((BorderNamedElementEditPart)this.affixedChildNode).getBorderItemLocator();
			return loc.getCurrentSideOfParent();

		}

		/**
		 * Gets the absolute position.
		 * 
		 * @return the absolute position
		 */
		public PrecisionRectangle getAbsolutePosition() {
			return LayoutUtils.getAbsolutePosition(this.affixedChildNode);
		}

		/**
		 * Gets the command.
		 * 
		 * @return the command
		 */
		public Command getCommand() {
			Request req = getRequest();
			if(req == null) {
				return UnexecutableCommand.INSTANCE;
			} else {
				return this.affixedChildNode.getCommand(req);
			}
		}

		/**
		 * Gets the request.
		 * 
		 * @return the request
		 */
		public Request getRequest() {
			if(newLocation != null) {
				ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
				req.setEditParts(this.affixedChildNode);
				PrecisionRectangle absolutePosition = LayoutUtils.getAbsolutePosition(this.affixedChildNode);
				PrecisionPoint oldLocation = new PrecisionPoint(absolutePosition.preciseX, absolutePosition.preciseY);

				Dimension delta = newLocation.getDifference(oldLocation);
				req.setMoveDelta(new Point(delta.width, delta.height));
				req.setSizeDelta(absolutePosition.getSize().getDifference(absolutePosition.getSize()));
				return req;
			}
			return null;
		}

		/**
		 * Sets the new location.
		 * 
		 * @param pt
		 *        the new new location
		 */
		public void setNewLocation(Point pt) {
			this.newLocation = pt;
		}

	}
}
