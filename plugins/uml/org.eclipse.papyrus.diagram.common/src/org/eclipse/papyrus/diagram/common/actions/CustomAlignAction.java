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
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.requests.AlignmentRequest;
import org.eclipse.gef.tools.ToolUtilities;
import org.eclipse.gmf.runtime.diagram.ui.actions.AlignAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.diagram.common.helper.AlignmentLinkHelper;
import org.eclipse.papyrus.diagram.common.layout.AlignmentTree;
import org.eclipse.papyrus.diagram.common.layout.EditPartTree;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.ui.IWorkbenchPage;



/**
 * The Class provides actions for the objects alignment.
 * These actions work correctly only if the figure to align is owned by :
 * <ul>
 * <li>the diagram</li>
 * <li>by a {@link CompartmentEditPart}. This {@link CompartmentEditPart} is owned by a figure composed by :
 * <ul>
 * <li>a compartment for the name (name + stereotype)</li>
 * <li>a compartment for object, located under the name's compartment, with {@link EditPolicy#LAYOUT_ROLE }</li>
 * </ul>
 * </li>
 * </ul>
 * If the containing figure is different, a correct alignment is not guaranteed.
 * 
 * With this class, we can align nodes, by selecting them, or by selecting the link between them, thanks to {@link AlignmentLinkHelper}
 */
public class CustomAlignAction extends AlignAction {

	/**
	 * the Tree used to sort editparts
	 * It contains all the selected editpart AND the intermediate editparts which can exist between two selected editparts
	 * 
	 */
	private AlignmentTree rootTree;

	/** The alignment. */
	private int alignment;

	/** the request type */
	private Object requestType = null;

	/**
	 * Constructs a CustomAlignAction with the given part and alignment ID. The alignment ID
	 * must by one of:
	 * <UL>
	 * <LI>GEFActionConstants.ALIGN_LEFT
	 * <LI>GEFActionConstants.ALIGN_RIGHT
	 * <LI>GEFActionConstants.ALIGN_CENTER
	 * <LI>GEFActionConstants.ALIGN_TOP
	 * <LI>GEFActionConstants.ALIGN_BOTTOM
	 * <LI>GEFActionConstants.ALIGN_MIDDLE
	 * </UL>
	 * 
	 * @param part
	 *        the workbench part used to obtain context
	 * @param id
	 *        the action ID.
	 * @param align
	 *        the aligment ID.
	 */
	public CustomAlignAction(IWorkbenchPage workbenchPage, String id, int align) {
		super(workbenchPage, id, align);
		this.alignment = align;
	}

	/**
	 * Instantiates a new custom align action.
	 * 
	 * @param workbenchPage
	 *        the workbench page
	 * @param id
	 *        the id
	 * @param align
	 *        the alignment
	 * @param isToolbarItem
	 *        indicates if this action is an item of a toolbar
	 */
	public CustomAlignAction(IWorkbenchPage workbenchPage, String id, int align, boolean isToolbarItem) {
		super(workbenchPage, id, align, isToolbarItem);
		this.alignment = align;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.AlignAction#createOperationSet()
	 * 
	 * @return
	 *         all the edit part to align
	 */
	@Override
	protected List createOperationSet() {

		List selection = getSelectedObjects();
		if(selection.isEmpty() || !(selection.get(0) instanceof IGraphicalEditPart))
			return Collections.EMPTY_LIST;
		Iterator selectedEPs = selection.iterator();
		List editparts = new ArrayList();
		while(selectedEPs.hasNext()) {
			EditPart selectedEP = (EditPart)selectedEPs.next();
			List targetEP = getTargetEditParts(selectedEP);
			editparts.addAll(targetEP);
		}
		return editparts;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#getTargetEditParts(org.eclipse.gef.EditPart)
	 * 
	 * @param editpart
	 * @return
	 */
	@Override
	protected List getTargetEditParts(EditPart editpart) {
		EditPart targetEP = editpart.getTargetEditPart(getTargetRequest());
		if(targetEP == null) {//the selected editpart doesn't support the request 
			if(editpart instanceof AbstractConnectionEditPart) {
				targetEP = editpart;
			}
		}
		return (targetEP == null) ? Collections.EMPTY_LIST : Collections.singletonList(targetEP);

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
		this.requestType = request.getType();
		List editparts = getOperationSet();

		if(!isMixedSelection(editparts)) {//if selection contains links and nodes, we do nothing
			if(isLinkSelection(editparts)) {
				AlignmentLinkHelper helper = new AlignmentLinkHelper(editparts, alignment);
				return helper.createCommand();
			}


			if(editparts.size() >= 2) {
				rootTree = new AlignmentTree(editparts);

				createRequests(editparts, (AlignmentRequest)request);

				CompoundCommand command = new CompoundCommand(getCommandLabel());
				Enumeration eptEnum = rootTree.breadthFirstEnumeration();
				while(eptEnum.hasMoreElements()) {
					EditPartTree ept = (EditPartTree)eptEnum.nextElement();
					if(ept.getEditPart() != null) {
						AlignmentRequest currentReq = (AlignmentRequest)ept.getRequest();
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
		return UnexecutableCommand.INSTANCE;
	}



	/**
	 * <ul>
	 * <li>Calculates the initial conditions to align each nodes owned by {@link #rootTree}</li>
	 * <li>Call {@link #createConstrainedRequest(PrecisionRectangle, PrecisionRectangle, PrecisionRectangle, EditPartTree)} for each node to create
	 * the request</li>
	 * </ul>
	 * 
	 * @param editparts
	 *        the editparts to align (the last editpart is the reference for the alignment)
	 * @param request
	 *        the initial request
	 */
	protected void createRequests(List editparts, AlignmentRequest request) {

		EditPart refEP = (EditPart)editparts.get(editparts.size() - 1);
		PrecisionRectangle boundsRef = LayoutUtils.getAbsolutePosition(refEP);

		int depth = this.rootTree.getDepth();
		for(int i = 1; i <= depth; i++) {//we iterate by level in the rootTree
			List<EditPartTree> epTrees = rootTree.getChildLevel(i);


			for(EditPartTree ept : epTrees) {//we create the request for each children
				List<EditPart> nodeChild = new ArrayList<EditPart>();

				//used to calculate the shift between each element!
				Enumeration vectorisedChildren = ((EditPartTree)ept.getPath()[1]).breadthFirstEnumeration();
				while(vectorisedChildren.hasMoreElements()) {
					nodeChild.add(((EditPartTree)vectorisedChildren.nextElement()).getEditPart());
				}

				if(ept.isSelected()) {//the edit part is selected
					if(ept.getEditPart() != refEP && (!ept.existsUnselectedChild())) {
						/*
						 * calculus of the shift
						 * 
						 * the shift is the first selected element when the reference is not a child of the editpart
						 * the shift is the number of levels between the current editpart and the reference if this reference is a child
						 */
						int level = ept.getLevelForFirstSelectedElement();
						if(ToolUtilities.isAncestorContainedIn(nodeChild, refEP)) {
							level = rootTree.getTree(refEP).getLevel();
							int currentLevel = ept.getLevel();
							level = level - currentLevel + 1;
						}

						/* collection used to test if the ept.getEditPart() contains the refEP */
						List<EditPart> coll = new ArrayList<EditPart>(1);
						coll.add(ept.getEditPart());

						/* the reference used for the alignment */
						PrecisionRectangle alignRef = new PrecisionRectangle(boundsRef);

						PrecisionRectangle containerBounds = ((AlignmentTree)ept).getNewContainerBounds();


						if(!containerBounds.equals(LayoutUtils.getAbsolutePosition(ept.getEditPart().getRoot()))) {
							containerBounds.setX(containerBounds.preciseX + LayoutUtils.scrollBarSize);
							containerBounds.setY(containerBounds.preciseY + LayoutUtils.scrollBarSize);
							containerBounds.setWidth(containerBounds.preciseWidth - 2 * LayoutUtils.scrollBarSize);
							containerBounds.setHeight(containerBounds.preciseHeight - 2 * LayoutUtils.scrollBarSize);
						}

						switch(this.alignment) {
						case PositionConstants.LEFT:
							alignRef.setX(boundsRef.preciseX - ((level - 1) * LayoutUtils.scrollBarSize));
							alignRef.setWidth(boundsRef.preciseWidth + 2 * ((level - 1) * LayoutUtils.scrollBarSize));

							break;
						case PositionConstants.CENTER://Useful?
							//							alignRef.setX(boundsRef.preciseX - ((level - 1) * LayoutUtils.scrollBarSize));
							//							alignRef.setWidth(boundsRef.preciseWidth + 2 * ((level - 1) * LayoutUtils.scrollBarSize));
							break;
						case PositionConstants.RIGHT:

							alignRef.setX(boundsRef.preciseX + ((-level + 1) * LayoutUtils.scrollBarSize));
							alignRef.setWidth(boundsRef.preciseWidth - 2 * ((-level + 1) * LayoutUtils.scrollBarSize));
							break;

						case PositionConstants.BOTTOM:
							alignRef.setY(boundsRef.preciseY + ((-level + 1) * LayoutUtils.scrollBarSize));
							alignRef.setHeight(boundsRef.preciseHeight - 2 * ((-level + 1) * LayoutUtils.scrollBarSize));
							break;
						case PositionConstants.MIDDLE://here we can have a problem with the label for the element inheriting from Package

							//useful?
							//							alignRef.setY(boundsRef.preciseY - ((level - 1) * LayoutUtils.scrollBarSize));
							//							alignRef.setHeight(boundsRef.preciseHeight + 2 * ((level - 1) * LayoutUtils.scrollBarSize));

							/*
							 * we don't want that the scrollbar appears
							 * with the top alignment, we need to consider the label of the container element
							 */


							/* obtain the size of the highest child */
							double heightMax = 0;
							Enumeration children = ept.children();
							while(children.hasMoreElements()) {
								EditPartTree currentChild = (EditPartTree)children.nextElement();
								double height = LayoutUtils.getAbsolutePosition(currentChild.getEditPart()).preciseHeight();
								heightMax = (height > heightMax) ? height : heightMax;
							}


							/* obtain the size of the compartment for this figure! */
							List childrenEP = ept.getEditPart().getChildren();
							double compartmentHeight = 0;
							for(int iter = 0; iter < childrenEP.size(); iter++) {
								if(childrenEP.get(iter) instanceof CompartmentEditPart) {
									CompartmentEditPart child = (CompartmentEditPart)childrenEP.get(iter);
									EditPolicy policy = child.getEditPolicy(EditPolicy.LAYOUT_ROLE);
									if(policy != null) {
										compartmentHeight = LayoutUtils.getAbsolutePosition(child).preciseHeight();
										break;
									}
								}
							}

							double heightToRemove = getLabelHeightToRemove(ept);
							//test to know if the initial alignment is possible without seeing the scrollbar
							if(compartmentHeight < (heightMax + LayoutUtils.scrollBarSize + heightToRemove)) {
								alignRef.setY(alignRef.preciseY - heightToRemove);
								alignRef.setHeight(alignRef.preciseHeight + heightToRemove);
							}

							break;
						case PositionConstants.TOP: //here we can have a problem with the label for the element inheriting from Package
							alignRef.setY(boundsRef.preciseY - ((level - 1) * LayoutUtils.scrollBarSize));
							alignRef.setHeight(boundsRef.preciseHeight + 2 * ((level - 1) * LayoutUtils.scrollBarSize));
							/*
							 * we don't want that the scrollbar appears
							 * with the top alignment, we need to consider the label of the container element
							 */
							if(ept.children().hasMoreElements()) {
								double dist = getLabelHeightToRemove(ept);
								alignRef.setY(alignRef.preciseY() - dist);
							}
							break;
						default:
							break;
						}

						createConstrainedRequest(alignRef, containerBounds, null, (AlignmentTree)ept);


					} else if(ept.getEditPart() != refEP && (ept.existsUnselectedChild())) {
						List<EditPart> parent = new ArrayList<EditPart>(1);
						parent.add(ept.getEditPart());

						int distance = ept.getDistanceWithTheFirstUnselectedChild();
						EditPartTree unselectedTree = ept.getFirstUnselectedChild();

						PrecisionRectangle boundsLimit = null;
						//we needn't correct unselected element location when the reference is not inside them
						if(ToolUtilities.isAncestorContainedIn(parent, refEP)) {
							boundsLimit = new PrecisionRectangle(LayoutUtils.getAbsolutePosition(unselectedTree.getEditPart()));
							//we increase the size of the child, to avoid scrollbar in its parent
							boundsLimit.setX(boundsLimit.preciseX - (distance * LayoutUtils.scrollBarSize));
							boundsLimit.setY(boundsLimit.preciseY - (distance * LayoutUtils.scrollBarSize));
							boundsLimit.setWidth(boundsLimit.width + (2 * distance * LayoutUtils.scrollBarSize));
							boundsLimit.setHeight(boundsLimit.height + (2 * distance * LayoutUtils.scrollBarSize));
							if(this.alignment == PositionConstants.TOP) {
								double dist = getLabelHeightToRemove(ept);
								boundsLimit.setY(boundsLimit.preciseY() - dist);
							}
						}

						PrecisionRectangle containerBounds = ((AlignmentTree)ept).getNewContainerBounds();

						if(!containerBounds.equals(LayoutUtils.getAbsolutePosition(ept.getEditPart().getRoot()))) {
							//we reduce the container bounds used to avoid scrollbar
							containerBounds.setX(containerBounds.preciseX + LayoutUtils.scrollBarSize);
							containerBounds.setY(containerBounds.preciseY + LayoutUtils.scrollBarSize);
							containerBounds.setWidth(containerBounds.width - 2 * LayoutUtils.scrollBarSize);
							containerBounds.setHeight(containerBounds.height - 2 * LayoutUtils.scrollBarSize);
						}

						createConstrainedRequest(boundsRef, containerBounds, boundsLimit, (AlignmentTree)ept);

					} else if(ept.getEditPart() == refEP && ToolUtilities.isAncestorContainedIn(nodeChild, refEP)) {
						if(!((EditPartTree)ept.getParent()).isSelected()) {
							//nothing to do
						} else {

							/*
							 * we need to create a command for the reference, only if
							 * its direct parent is selected.
							 * If the reference has ancestor in the selection and if this ancestor is not selected, itn's not necessary to move the
							 * reference, because it's the ancestor which must move.
							 */
							PrecisionRectangle containerBounds = ((AlignmentTree)ept).getNewContainerBounds();
							containerBounds.setX(containerBounds.preciseX + LayoutUtils.scrollBarSize);
							containerBounds.setY(containerBounds.preciseY + LayoutUtils.scrollBarSize);
							containerBounds.setWidth(containerBounds.width - 2 * LayoutUtils.scrollBarSize);
							containerBounds.setHeight(containerBounds.height - 2 * LayoutUtils.scrollBarSize);
							createConstrainedRequest(LayoutUtils.getAbsolutePosition(refEP), containerBounds, null, (AlignmentTree)ept);
						}
					} else if(ept.getEditPart() == refEP && (!ToolUtilities.isAncestorContainedIn(nodeChild, refEP))) {
						//nothing to do
					}
				} else {//the editpart is not selected! We need to maintain its location 

					PrecisionRectangle containerBounds = ((AlignmentTree)ept).getNewContainerBounds();
					containerBounds.setX(containerBounds.preciseX + LayoutUtils.scrollBarSize);
					containerBounds.setY(containerBounds.preciseY + LayoutUtils.scrollBarSize);
					containerBounds.setWidth(containerBounds.width - 2 * LayoutUtils.scrollBarSize);
					containerBounds.setHeight(containerBounds.height - 2 * LayoutUtils.scrollBarSize);

					createConstrainedRequest(LayoutUtils.getAbsolutePosition(ept.getEditPart()), containerBounds, null, (AlignmentTree)ept);

				}
			}
		}



	}

	/**
	 * 
	 * <ul>
	 * <li>Completes the {@link EditPartTree} with the correct new position for the object</li>
	 * <li>Adds the created request to the {@link EditPartTree}</li>
	 * </ul>
	 * 
	 * @param ref
	 *        the reference used for the alignment
	 * @param containerBounds
	 *        the size of the editpart container
	 * @param dontCross
	 *        the shift must be done, without the figure bounds are drawn in this rectangle
	 * @param tree
	 *        the tree for which we create the request
	 */


	protected void createConstrainedRequest(PrecisionRectangle ref, PrecisionRectangle containerBounds, PrecisionRectangle dontCross, AlignmentTree tree) {

		//variables used to write the request
		double xMinForObject = 0;
		double xMaxForObject = 0;
		double yMinForObject = 0;
		double yMaxForObject = 0;

		PrecisionRectangle editpartBounds = LayoutUtils.getAbsolutePosition(tree.getEditPart());


		PrecisionRectangle newPosition = new PrecisionRectangle(editpartBounds);

		//1-we determine the bounds!
		if(dontCross == null && containerBounds.equals(LayoutUtils.getAbsolutePosition(tree.getEditPart().getRoot()))) {
			AlignmentRequest newRequest = new AlignmentRequest(requestType);
			PrecisionRectangle newPrecisionRectangle = new PrecisionRectangle(ref);
			newRequest.setAlignment(this.alignment);
			newRequest.setAlignmentRectangle(newPrecisionRectangle);
			double pos = 0;
			switch(this.alignment) {
			case PositionConstants.LEFT:
				newPosition.setX(ref.preciseX());
				break;
			case PositionConstants.CENTER:
				pos = ref.getTop().preciseX() - (editpartBounds.preciseWidth() / 2.0);
				newPosition.setX(pos);
				break;
			case PositionConstants.RIGHT:
				pos = ref.getRight().preciseX() - editpartBounds.preciseWidth();
				newPosition.setX(pos);
				break;
			case PositionConstants.TOP:
				pos = ref.getTop().preciseY();
				newPosition.setY(pos);
				break;
			case PositionConstants.MIDDLE:
				pos = ref.getLeft().preciseY() - (editpartBounds.preciseHeight / 2.0);
				newPosition.setY(pos);
				break;
			case PositionConstants.BOTTOM:
				pos = ref.getBottom().preciseY() - editpartBounds.preciseHeight();
				newPosition.setY(pos);
				break;
			default:
				break;
			}


			tree.setNewPosition(newPosition);
			tree.setRequest(newRequest);
			return;
		} else if(dontCross == null && (!containerBounds.equals(LayoutUtils.getAbsolutePosition(tree.getEditPart().getRoot())))) {
			xMinForObject = containerBounds.preciseX;
			xMaxForObject = containerBounds.getRight().preciseX() - editpartBounds.preciseWidth();
			yMinForObject = containerBounds.preciseY;
			yMaxForObject = containerBounds.getBottom().preciseY() - editpartBounds.preciseHeight();


		} else if(dontCross != null) {
			xMinForObject = dontCross.getRight().preciseX() - editpartBounds.preciseWidth;
			xMaxForObject = dontCross.preciseX;
			yMinForObject = dontCross.getBottom().preciseY() - editpartBounds.preciseHeight;
			yMaxForObject = dontCross.preciseY;

			if(!containerBounds.equals(LayoutUtils.getAbsolutePosition(tree.getEditPart().getRoot()))) {
				//container's limits
				double xMinContainerLimit = containerBounds.preciseX;
				double xMaxContainerLimit = containerBounds.getRight().preciseX() - editpartBounds.preciseWidth();
				double yMinContainerLimit = containerBounds.preciseY;
				double yMaxContainerLimit = containerBounds.getBottom().preciseY() - editpartBounds.preciseHeight();


				xMinForObject = (xMinForObject > xMinContainerLimit) ? xMinForObject : xMinContainerLimit;
				xMaxForObject = (xMaxForObject > xMaxContainerLimit) ? xMaxContainerLimit : xMaxForObject;
				yMinForObject = (yMinForObject > yMinContainerLimit) ? yMinForObject : yMinContainerLimit;
				yMaxForObject = (yMaxForObject > yMaxContainerLimit) ? yMaxContainerLimit : yMaxForObject;
			}
		}


		/* rectangle used to do the alignment */
		PrecisionRectangle myAlignRectangle = new PrecisionRectangle(editpartBounds);

		/* the editpart's position in its container, after the shift of the container */
		PrecisionRectangle newTmpPosition = tree.getAbsolutePositionInTheNewContainerPosition();

		/* the distance between the editpart in the new container position and its alignment reference */
		double distance = 0;

		/* the point use to translate the editpart */
		Point translationPoint = null;

		/* the new request */
		AlignmentRequest newRequest = new AlignmentRequest(requestType);
		newRequest.setAlignment(this.alignment);
		switch(alignment) {
		case PositionConstants.LEFT:

			if((ref.preciseX >= xMinForObject) && (ref.preciseX <= xMaxForObject)) {
				distance = ref.preciseX - newTmpPosition.preciseX;
			} else if(ref.preciseX < xMinForObject) {
				distance = xMinForObject - newTmpPosition.preciseX;
			} else if(ref.preciseX > xMaxForObject) {
				distance = xMaxForObject - newTmpPosition.preciseX;
			}
			myAlignRectangle.setX(LayoutUtils.getAbsolutePosition(tree.getEditPart()).preciseX + distance);
			translationPoint = new Point(distance, 0);

			break;
		case PositionConstants.CENTER:// un alignement central  fait de cette faÃ§on : tous les packages alignÃ© sur un Ã©lÃ©ment extÃ©rieur ne marche pas du tout!

			double minCenter = xMinForObject + (editpartBounds.preciseWidth / 2.0);
			double maxCenter = xMaxForObject + (editpartBounds.preciseWidth / 2.0);
			if((ref.getTop().preciseX() >= minCenter) && (ref.getTop().preciseX() <= maxCenter)) {
				distance = (ref.preciseX + (ref.preciseWidth / 2.0) - (newTmpPosition.preciseX + (newTmpPosition.preciseWidth / 2.0)));
			} else if(ref.getTop().preciseX() < minCenter) {
				distance = minCenter - (newTmpPosition.preciseX + (newTmpPosition.preciseWidth / 2.0));
			} else if(ref.getTop().preciseX() > maxCenter) {

				distance = maxCenter - (newTmpPosition.preciseX + ((newTmpPosition.preciseWidth) / 2.0));

			}
			myAlignRectangle.setX(LayoutUtils.getAbsolutePosition(tree.getEditPart()).preciseX + distance);
			translationPoint = new Point(distance, 0);

			break;
		case PositionConstants.RIGHT:
			double minRight = xMinForObject + editpartBounds.preciseWidth;
			double maxRight = xMaxForObject + editpartBounds.preciseWidth;
			if((ref.getRight().preciseX() >= minRight) && (ref.getRight().preciseX() <= maxRight)) {
				distance = (ref.preciseX + ref.preciseWidth) - (newTmpPosition.preciseX + newTmpPosition.preciseWidth);
			} else if(ref.getRight().preciseX() < minRight) {
				distance = minRight - (newTmpPosition.preciseX + newTmpPosition.preciseWidth);
			} else if(ref.getRight().preciseX() > maxRight) {
				distance = maxRight - (newTmpPosition.preciseX + newTmpPosition.preciseWidth);
			}
			myAlignRectangle.setX(LayoutUtils.getAbsolutePosition(tree.getEditPart()).preciseX + distance);
			translationPoint = new Point(distance, 0);

			break;
		case PositionConstants.BOTTOM:
			double minBottom = yMinForObject + editpartBounds.preciseHeight;
			double maxBottom = yMaxForObject + editpartBounds.preciseHeight;
			if(((ref.getBottom().preciseY()) >= minBottom) && ((ref.getBottom().preciseY()) <= maxBottom)) {
				distance = (ref.preciseY + ref.preciseHeight) - (newTmpPosition.preciseY + newTmpPosition.preciseHeight);
			} else if((ref.getBottom().preciseY()) < minBottom) {
				distance = minBottom - (newTmpPosition.preciseY + newTmpPosition.preciseHeight);
			} else if((ref.getBottom().preciseY()) > maxBottom) {
				distance = maxBottom - (newTmpPosition.preciseY + newTmpPosition.preciseHeight);
			}
			translationPoint = new Point(0, distance);
			myAlignRectangle.setY(LayoutUtils.getAbsolutePosition(tree.getEditPart()).preciseY + distance);
			break;

		case PositionConstants.MIDDLE:
			double minMiddle = yMinForObject + (editpartBounds.preciseHeight / 2.0);
			double maxMiddle = yMaxForObject + (editpartBounds.preciseHeight / 2.0);
			if(((ref.preciseY + (ref.preciseHeight / 2.0)) >= minMiddle) && ((ref.preciseY + (ref.preciseHeight / 2.0)) <= maxMiddle)) {
				distance = (ref.preciseY + (ref.preciseHeight / 2.0) - (newTmpPosition.preciseY + (newTmpPosition.preciseHeight / 2.0)));;
			} else if((ref.preciseY + (ref.height / 2.0)) < minMiddle) {
				distance = minMiddle - (newTmpPosition.preciseY + (newTmpPosition.preciseHeight / 2.0));
			} else if((ref.preciseY + (ref.height / 2.0)) > maxMiddle) {
				distance = maxMiddle - (newTmpPosition.preciseY + (newTmpPosition.preciseHeight / 2.0));
			}
			translationPoint = new Point(0, distance);
			myAlignRectangle.setY(LayoutUtils.getAbsolutePosition(tree.getEditPart()).preciseY + distance);
			break;
		case PositionConstants.TOP:
			if((ref.preciseY >= yMinForObject) && (ref.preciseY <= yMaxForObject)) {
				distance = ref.preciseY - newTmpPosition.preciseY;
			} else if(ref.preciseY < yMinForObject) {
				distance = yMinForObject - newTmpPosition.preciseY;
			} else if(ref.preciseY > yMaxForObject) {
				distance = yMaxForObject - newTmpPosition.preciseY;
			}
			translationPoint = new Point(0, distance);
			myAlignRectangle.setY(LayoutUtils.getAbsolutePosition(tree.getEditPart()).preciseY + distance);
			break;
		default:
			break;
		}


		newRequest.setAlignmentRectangle(myAlignRectangle);
		newPosition = (PrecisionRectangle)tree.getAbsolutePositionInTheNewContainerPosition().translate(translationPoint);
		tree.setNewPosition(newPosition);
		tree.setRequest(newRequest);
		return;
	}

	/**
	 * Returns the height of the label for the current editpart contained in {@code ept}, more the height of the children's label
	 * 
	 * @param ept
	 *        The {@link EditPartTree} containing the {@link EditPart} used to calculate height
	 * @return
	 *         The height of the label for the current editpart, more the height of the children's label
	 * 
	 */
	protected double getLabelHeightToRemove(EditPartTree ept) {
		double dist = 0;
		List children = ept.getEditPart().getChildren();
		//we search the correct compartment
		for(int iter = 0; iter < children.size(); iter++) {
			if(children.get(iter) instanceof CompartmentEditPart) {
				CompartmentEditPart child = (CompartmentEditPart)children.get(iter);
				EditPolicy policy = child.getEditPolicy(EditPolicy.LAYOUT_ROLE);
				if(policy != null) {
					PrecisionRectangle cptSize = LayoutUtils.getAbsolutePosition(child);
					dist += cptSize.preciseY() - LayoutUtils.getAbsolutePosition(ept.getEditPart()).preciseY();
					break;
				}
			}
		}
		Enumeration eptChildren = ept.children();
		double max = 0;
		while(eptChildren.hasMoreElements()) {
			EditPartTree currentElement = (EditPartTree)eptChildren.nextElement();
			if(currentElement.isSelected() && (!currentElement.isReference())) {
				double tmp = getLabelHeightToRemove(currentElement);
				max = (tmp > max) ? tmp : max;
			}
		}
		dist += max;
		return dist;
	}

	/**
	 * Tests the selection (nodes and links)
	 * 
	 * @param editparts
	 * 
	 * @return
	 *         <ul>
	 *         <li> {@code true}</li> if the selection contains links and nodes
	 *         <li> {@code false}</li> if not
	 *         </ul>
	 * 
	 */
	protected boolean isMixedSelection(List<EditPart> editparts) {
		boolean node = false;
		boolean link = false;
		for(Object editPart : editparts) {
			if(editPart instanceof AbstractConnectionEditPart) {
				link = true;
			} else {
				node = true;
			}
		}
		return !(((node == true) && (link == true))) ? false : true;
	}

	/**
	 * Tests if all the selected elements are instance of {@linkplain AbstractConnectionEditPart}
	 * 
	 * @param editparts
	 *        the editparts list to test
	 * @return
	 *         <ul>
	 *         <li> {@code true}</li> if all the editparts represents a link
	 *         <li>{@code false}</li> if not
	 *         </ul>
	 */
	protected boolean isLinkSelection(List<EditPart> editparts) {
		if(editparts.size() == 0) {
			return false;
		}
		for(Object object : editparts) {
			if(!(object instanceof AbstractConnectionEditPart)) {
				return false;
			}
		}
		return true;
	}
}
