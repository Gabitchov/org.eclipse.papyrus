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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.papyrus.diagram.common.editparts.BorderNamedElementEditPart;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;
import org.eclipse.papyrus.diagram.common.layout.DistributionTree;
import org.eclipse.papyrus.diagram.common.layout.EditPartTree;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Port;

/**
 * 
 * This class provides actions for the objects distribution.
 * 
 */
public class DistributeAction extends DiagramAction {

	/**
	 * iIndicates if we are in a degraded mode for the vertical distribution
	 * this value is changed by {@link #calculatesSpaceBetweenNodes(PrecisionRectangle, List)}
	 */
	private boolean verticalDegradedMode = false;

	/**
	 * Indicates if we are in a degraded mode for the horizontal distribution
	 * this value is changed by {@link #calculatesSpaceBetweenNodes(PrecisionRectangle, List)}
	 */
	private boolean horizontalDegradedMode = false;

	/**
	 * Indicates if the distribution action is applied on {@link Port} or on other element
	 * This value is calculated by {@link #isMixedSelection(List)}
	 */
	private boolean isPortSelection = false;

	/** the id for this action */
	private String id;

	/** the distribution type */
	private int distribution;

	/** indicates if this action is an item of a toolbars */
	private boolean isToolbarItem;

	/** the tree used to organize the editpart */
	private EditPartTree rootTree;

	/** indicates if the bounds used for the distribution are the parent bounds */
	private boolean parentContainer = true;

	/** a margin used between the editpart and its container */
	private double margin = 10;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param workbenchPage
	 *        the workbenchPage
	 * @param id
	 *        the id for this action
	 * @param distrib
	 *        the distribution type
	 *        Possible values for distrib are :
	 *        <ul>
	 *        <li> {@linkplain DistributionConstants#DISTRIBUTE_H_CONTAINER_INT}</li>
	 *        <li>{@linkplain DistributionConstants#DISTRIBUTE_V_NODES_INT}</li>
	 *        <li>{@linkplain DistributionConstants#DISTRIBUTE_V_CONTAINER_INT}</li>
	 *        <li>{@linkplain DistributionConstants#DISTRIBUTE_V_NODES_INT}</li>
	 *        </ul>
	 */
	public DistributeAction(IWorkbenchPage workbenchPage, String id, int distrib) {
		this(workbenchPage, id, distrib, true);
	}


	/**
	 * 
	 * Constructor.
	 * 
	 * @param workbenchPage
	 *        the workbenchPage
	 * @param id
	 *        the id for this action
	 * @param distrib
	 *        the distribution type
	 *        Possible values for distrib are :
	 *        <ul>
	 *        <li> {@linkplain DistributionConstants#DISTRIBUTE_H_CONTAINER_INT}</li>
	 *        <li>{@linkplain DistributionConstants#DISTRIBUTE_V_NODES_INT}</li>
	 *        <li>{@linkplain DistributionConstants#DISTRIBUTE_V_CONTAINER_INT}</li>
	 *        <li>{@linkplain DistributionConstants#DISTRIBUTE_V_NODES_INT}</li>
	 *        </ul>
	 * @param isToolbarItem
	 *        indicates if this action is an item of a toolbar
	 */
	public DistributeAction(IWorkbenchPage workbenchPage, String id, int distrib, boolean isToolbarItem) {
		super(workbenchPage);
		this.id = id;
		this.distribution = distrib;
		this.isToolbarItem = isToolbarItem;
		if(distrib == DistributionConstants.DISTRIBUTE_H_NODES_INT || distrib == DistributionConstants.DISTRIBUTE_V_NODES_INT) {
			parentContainer = false;
		}
		initUI();
	}

	/**
	 * Initializes the actions UI presentation.
	 * Two sets of each align action are required. One for the toolbar,
	 * and one for other menus. The toolbar action has explicit text,
	 * the other menus do not. For example: Align Left and Left.
	 * 
	 */
	protected void initUI() {

		setId(this.id);
		String text = null;
		String toolTipText = null;

		DistributionAction papyrusDistributionAction = new DistributionAction(getWorkbenchPart(), distribution);
		setHoverImageDescriptor(papyrusDistributionAction.getHoverImageDescriptor());
		setImageDescriptor(papyrusDistributionAction.getImageDescriptor());
		setDisabledImageDescriptor(papyrusDistributionAction.getDisabledImageDescriptor());
		papyrusDistributionAction.dispose();

		switch(distribution) {
		case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
		{

			if(isToolbarItem) {
				text = DistributionConstants.DistributeHorizontally;
				toolTipText = DistributionConstants.DistributeHorizontally;
			} else {
				text = DistributionConstants.DistributeHorizontally;
				toolTipText = DistributionConstants.DistributeHorizontally;
			}
			break;
		}
		case DistributionConstants.DISTRIBUTE_H_NODES_INT:
		{
			if(isToolbarItem) {
				text = DistributionConstants.DistributeHorizontallyBetweenNodes;
				toolTipText = DistributionConstants.DistributeHorizontallyBetweenNodes;
			} else {
				text = DistributionConstants.DistributeHorizontallyBetweenNodes;
				toolTipText = DistributionConstants.DistributeHorizontallyBetweenNodes;
			}
			break;
		}
		case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
		{
			if(isToolbarItem) {
				text = DistributionConstants.DistributeVertically;
				toolTipText = DistributionConstants.DistributeVertically;
			} else {
				text = DistributionConstants.DistributeVertically;
				toolTipText = DistributionConstants.DistributeVertically;
			}
			break;
		}
		case DistributionConstants.DISTRIBUTE_V_NODES_INT:
		{
			if(isToolbarItem) {
				text = DistributionConstants.DistributeVerticallyBetweenNodes;
				toolTipText = DistributionConstants.DistributeVerticallyBetweenNodes;
			} else {
				text = DistributionConstants.DistributeVerticallyBetweenNodes;
				toolTipText = DistributionConstants.DistributeVerticallyBetweenNodes;
			}
			break;
		}

		}
		setText(text);
		setToolTipText(toolTipText);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 * 
	 * @return
	 */
	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#isOperationHistoryListener()
	 * 
	 * @return
	 */
	@Override
	protected boolean isOperationHistoryListener() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 * 
	 * @return
	 */
	@Override
	protected Request createTargetRequest() {
		return new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
	}


	/**
	 * Gets a command to execute on the operation set based on a given request
	 * 
	 * @param request
	 *        request to use to get the command
	 * @return a command
	 */
	@Override
	protected Command getCommand(Request request) {
		List editparts = getOperationSet();
		if(!isMixedSelection(editparts)) {
			if(((editparts.size() >= 2) && (this.distribution == DistributionConstants.DISTRIBUTE_V_CONTAINER_INT || this.distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT))

			|| ((editparts.size() >= 3) && (this.distribution == DistributionConstants.DISTRIBUTE_V_NODES_INT || this.distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT))) {

				//Does the selection allow to make a distribution?
				if(canDistributeElements(editparts)) {
					//we fill the tree
					rootTree = new DistributionTree(editparts);
					//we create the requests and store them in rootTree
					createRequests(editparts);
					CompoundCommand command = new CompoundCommand(getCommandLabel());
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
			}
		}
		return UnexecutableCommand.INSTANCE;

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
					if(parentContainer && !isPortSelection) {
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
					Collections.sort(children, new CustomComparator());

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
					//these 4 booleans indicates if we have already consider a port located on a bad side for the chosen action
					boolean eastPort = false;
					boolean westPort = false;
					boolean northPort = false;
					boolean southPort = false;

					//request creation for all editparts
					for(EditPartTree editPartTree : children) {
						if(editPartTree.isSelected()) {
							//the new location for the editpart
							PrecisionPoint ptLocation = null;
							PrecisionRectangle absolutePosition = LayoutUtils.getAbsolutePosition(editPartTree.getEditPart());

							if(!isPortSelection) {
								if(this.distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || this.distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
									ptLocation = new PrecisionPoint(newPosition, absolutePosition.preciseY);
									newPosition += absolutePosition.preciseWidth() + hSpaceAndvSpace[0];
								} else {//vertical distribution
									ptLocation = new PrecisionPoint(absolutePosition.preciseX, newPosition);
									newPosition += absolutePosition.preciseHeight() + hSpaceAndvSpace[1];
								}
							} else {//we are working with ports
								int side = ((BorderNamedElementEditPart)editPartTree.getEditPart()).getBorderItemLocator().getCurrentSideOfParent();
								switch(this.distribution) {
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
	 * Tests if the list is a mix between {@link Port} and other UML element
	 * Determines the {@link #isPortSelection} value
	 * 
	 * @param editparts
	 *        the editparts to test
	 * @return
	 *         <ul>
	 *         <li> {@code true} if the list is a mix between {@link Port} and other UML element</li>
	 *         <li> {@code false} if not</li>
	 *         </ul>
	 */
	protected boolean isMixedSelection(List<EditPart> editparts) {
		isPortSelection = false;
		boolean containsOtherEditPart = false;
		for(Object object : editparts) {
			EditPart currentEditPart = (EditPart)object;
			EObject sem = MDTUtil.resolveSemantic(currentEditPart);
			if(sem instanceof Port && !(currentEditPart instanceof LabelEditPart)) {
				isPortSelection = true;
				currentEditPart.getParent();
			} else {
				containsOtherEditPart = true;
			}
			if(containsOtherEditPart == true && isPortSelection == true) {
				return true;
			}
		}
		return false;
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

		//-------variables used when it's a port selection
		double nbPort = 0;//used to know the number of necessary spaces

		//if a port is on a bad side for the current alignment, we need to count it only one time!
		boolean eastPort = false;
		boolean westPort = false;
		boolean northPort = false;
		boolean southPort = false;

		//we calculate the length take by the element
		for(EditPart currentEP : nodeChild) {
			if(currentEP.getSelected() != EditPart.SELECTED_NONE) {//if the node is not selected, we ignore it
				PrecisionRectangle rect = LayoutUtils.getAbsolutePosition(currentEP);
				if(!isPortSelection) {
					vertical += rect.preciseHeight();
					horizontal += rect.preciseWidth();
				} else {//it's a port selection
					IBorderItemLocator loc = ((BorderNamedElementEditPart)currentEP).getBorderItemLocator();
					int side = loc.getCurrentSideOfParent();
					switch(this.distribution) {
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
			}
		}

		//we determine the divisor 
		double divisor = 1;
		if(parentContainer && !isPortSelection) {
			divisor = nodeChild.size() + 1;
		} else if(!parentContainer && !isPortSelection) {
			divisor = nodeChild.size() - 1;
		} else if(parentContainer && isPortSelection) {
			divisor = nbPort + 1;
		} else if(!parentContainer && isPortSelection) {
			divisor = nbPort - 1;
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
	 * Returns if the editparts can be distributed
	 * 
	 * @param editpart
	 *        the selected editparts
	 * @return
	 *         <ul>
	 *         <li> {@code true}</li>if the editpart can be distributed
	 *         <li> {@code false}</li> if not
	 *         </ul>
	 */
	protected boolean canDistributeElements(List<EditPart> editparts) {
		boolean answer = false;
		if(isPortSelection) {//it must exist port located on a correct to do something!
			for(EditPart editPart : editparts) {


				IBorderItemLocator loc = ((BorderNamedElementEditPart)editPart).getBorderItemLocator();
				int side = loc.getCurrentSideOfParent();
				if(this.distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || this.distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {
					if(DistributionConstants.horizontalValuesList.contains(side)) {
						answer = true;
					}
				} else {//vertical distribution
					if(DistributionConstants.verticalValuesList.contains(side)) {
						answer = true;
					}

				}
			}
		} else {
			//nothing to do for other selections
			answer = true;
		}
		return answer;
	}


	/**
	 * 
	 * This class provides a comparator for the {@link EditPartTree}, using the coordinates of the representing {@link EditPart}
	 */
	protected class CustomComparator implements Comparator<Object> {

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
