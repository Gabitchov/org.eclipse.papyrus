/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.locator;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart.AcceptEventActionFigure;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActionInputPinInCallBeActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActionInputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActionInputPinInCallOpActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActionInputPinInOpaqueActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActionInputPinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActionInputPinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActionInputPinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActionInputPinInSendSigActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInAddStructuralFeatureValueActionAsObjectEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInAddStructuralFeatureValueActionAsValueEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInAddVariableValueActionAsInsertAtEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInAddVariableValueActionAsValueEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInBroadcastSignalActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInCallBeActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInCallOpActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInDestroyObjectActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInReadStructuralFeatureAsObjectEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInSendSigActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInAcceptEventActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInAddStructuralFeatureValueActionAsResultEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInCallBeActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInCallOpActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInCreateObjectActionAsResultEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInReadStructuralFeatureAsResultEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInReadVariableActionAsResultEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInValSpecActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadSelfActionOutputPinEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInCallBeActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInCallOpActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInOpaqueActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInSendSigActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.helper.ActivityFigureDrawer;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusSendNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.locator.AdvancedBorderItemLocator;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.CallOperationAction;

/**
 * This class is used to constrain the position of Pin
 * 
 * TODO : The pin is not re-sizable
 */
public class PinPositionLocator extends AdvancedBorderItemLocator {

	/**
	 * The offset to add to default position. (to avoid corner of rounded
	 * rectangles)
	 */
	public static final int EXTRA_BORDER_DEFAULT_OFFSET = 8;

	/** The default size of a pin */
	public static final int DEFAULT_PIN_SIZE = 16;

	/**
	 * the maximum authorized x position on the template of a Send Signal Action
	 * figure
	 */
	private static final int SEND_SIGNAL_ACTION_MAX_X = 150;

	/** the width of the template of a Send Signal Action figure */
	private static final int SEND_SIGNAL_ACTION_WIDTH = 200;

	/** Constructor **/
	public PinPositionLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/** Constructor **/
	public PinPositionLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/** Constructor **/
	public PinPositionLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		realLocation.width = Math.max(realLocation.width, realLocation.height);
		realLocation.height = realLocation.width;
		int side = findClosestAuthorizedSideOfParent(proposedLocation, getParentBorder());
		Point newTopLeft = locateOnBorder(realLocation.getTopLeft(), side, 0, borderItem);
		realLocation.setLocation(newTopLeft);
		return realLocation;
	}

	/**
	 * The preferred side takes precedence.
	 * 
	 * @param suggestedLocation
	 * @param suggestedSide
	 * @param circuitCount
	 *        recursion count to avoid an infinite loop
	 * @return point
	 */
	protected Point locateOnBorder(Point suggestedLocation, int suggestedSide, int circuitCount, IFigure borderItem) {
		Point suggestedCenter = borderItem.getBounds().getCopy().setLocation(suggestedLocation).getCenter();
		suggestedSide = redefineSuggestedSide(suggestedCenter, suggestedSide);
		if(isInSendSignalAction()) {
			// prevent a pin too far EAST that would be on the convex sides of
			// the pentagon
			if(suggestedSide == PositionConstants.SOUTH || suggestedSide == PositionConstants.NORTH) {
				int maxLocation = getParentBorder().x + getParentBorder().width * SEND_SIGNAL_ACTION_MAX_X / SEND_SIGNAL_ACTION_WIDTH - getSize(borderItem).width;
				if(suggestedLocation.x > maxLocation) {
					suggestedLocation.x = maxLocation;
				}
			}
		}
		Point recommendedLocation = super.locateOnBorder(suggestedLocation, suggestedSide, circuitCount, borderItem);
		return recommendedLocation;
	}

	/**
	 * Ensure the suggested location actually lies on the parent boundary. The
	 * side takes precedence.
	 * 
	 * @param suggestedLocation
	 *        suggested location
	 * @param suggestedSide
	 *        suggested side
	 * @param borderItem
	 *        the item figure
	 * @return point
	 */
	protected Point locateOnParent(Point suggestedLocation, int suggestedSide, IFigure borderItem) {
		Rectangle bounds = getParentBorder();
		int parentFigureWidth = bounds.width;
		int parentFigureHeight = bounds.height;
		int parentFigureX = bounds.x;
		int parentFigureY = bounds.y;
		Dimension borderItemSize = getSize(borderItem);
		int newX = suggestedLocation.x;
		int newY = suggestedLocation.y;
		int westX = parentFigureX - borderItemSize.width + getBorderItemOffset().width;
		int eastX = parentFigureX + parentFigureWidth - getBorderItemOffset().width;
		int maxX = 0;
		if(isInSendSignalAction()) {
			// prevent a pin too far EAST that would be on the convex sides of
			// the pentagon
			if(suggestedSide == PositionConstants.SOUTH || suggestedSide == PositionConstants.NORTH) {
				maxX = parentFigureX + parentFigureWidth * SEND_SIGNAL_ACTION_MAX_X / SEND_SIGNAL_ACTION_WIDTH - getBorderItemOffset().width;
			}
		}
		int southY = parentFigureY + parentFigureHeight - getBorderItemOffset().height;
		int northY = parentFigureY - borderItemSize.height + getBorderItemOffset().height;
		if(suggestedSide == PositionConstants.WEST) {
			if(suggestedLocation.x != westX) {
				newX = westX;
			}
			if(suggestedLocation.y < bounds.getTopLeft().y) {
				newY = northY + borderItemSize.height;
			} else if(suggestedLocation.y > bounds.getBottomLeft().y - borderItemSize.height) {
				newY = southY - borderItemSize.height;
			}
		} else if(suggestedSide == PositionConstants.EAST) {
			if(suggestedLocation.x != eastX) {
				newX = eastX;
			}
			if(suggestedLocation.y < bounds.getTopLeft().y) {
				newY = northY + borderItemSize.height;
			} else if(suggestedLocation.y > bounds.getBottomLeft().y - borderItemSize.height) {
				newY = southY - borderItemSize.height;
			}
		} else if(suggestedSide == PositionConstants.SOUTH) {
			if(suggestedLocation.y != southY) {
				newY = southY;
			}
			if(suggestedLocation.x < bounds.getBottomLeft().x) {
				newX = westX + borderItemSize.width;
			} else if(suggestedLocation.x > bounds.getBottomRight().x - borderItemSize.width) {
				newX = eastX - borderItemSize.width;
			}
		} else { // NORTH
			if(suggestedLocation.y != northY) {
				newY = northY;
			}
			if(suggestedLocation.x < bounds.getBottomLeft().x) {
				newX = westX + borderItemSize.width;
			} else if(suggestedLocation.x > bounds.getBottomRight().x - borderItemSize.width) {
				newX = eastX - borderItemSize.width;
			}
		}
		if(maxX > 0 && newX > maxX) {
			newX = maxX;
		}
		return new Point(newX, newY);
	}

	/**
	 * Recomputes the suggested side by eliminating unauthorized sides depending
	 * on the action type
	 * 
	 * @param childCenter
	 *        suggested location center
	 * @param suggestedSide
	 *        suggested side
	 * @return correct side
	 */
	private int redefineSuggestedSide(Point childCenter, int suggestedSide) {
		if(isInSendSignalAction()) {
			// EAST side is not authorized
			if(suggestedSide == PositionConstants.EAST) {
				Point parentCenter = getParentBorder().getCenter();
				if(childCenter.y < parentCenter.y) {
					suggestedSide = PositionConstants.NORTH;
				} else {
					suggestedSide = PositionConstants.SOUTH;
				}
			}
		} else if(isInAcceptEventAction()) {
			// WEST side is not authorized
			if(suggestedSide == PositionConstants.WEST) {
				Point parentCenter = getParentBorder().getCenter();
				if(childCenter.y < parentCenter.y) {
					suggestedSide = PositionConstants.NORTH;
				} else {
					suggestedSide = PositionConstants.SOUTH;
				}
			}
			// EAST side is not authorized for AcceptTimeEventAction
			if(suggestedSide == PositionConstants.EAST && isInAcceptTimeEventAction()) {
				Point parentCenter = getParentBorder().getCenter();
				if(childCenter.y < parentCenter.y) {
					suggestedSide = PositionConstants.NORTH;
				} else {
					suggestedSide = PositionConstants.SOUTH;
				}
			}
		}
		return suggestedSide;
	}

	/**
	 * Find the closest side when x,y is inside parent.
	 * 
	 * @param proposedLocation
	 * @param parentBorder
	 * @return draw constant
	 */
	public int findClosestAuthorizedSideOfParent(Rectangle proposedLocation, Rectangle parentBorder) {
		int side = findClosestSideOfParent(proposedLocation, parentBorder);
		side = redefineSuggestedSide(proposedLocation.getCenter(), side);
		return side;
	}

	/**
	 * Know whether containing action is a SendSignalAction
	 * 
	 * @return true is containing action is a SendSignalAction
	 */
	private boolean isInSendSignalAction() {
		IFigure parentFigure = getParentFigure();
		for(Object child : parentFigure.getChildren()) {
			if(child instanceof PapyrusSendNodeFigure) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Know whether containing action is an AcceptEventAction
	 * 
	 * @return true is containing action is an AcceptEventAction
	 */
	private boolean isInAcceptEventAction() {
		IFigure parentFigure = getParentFigure();
		for(Object child : parentFigure.getChildren()) {
			if(child instanceof AcceptEventActionFigure) {
				((AcceptEventActionFigure)child).isTemplateForAcceptTimeEventActionUsed();
				return true;
			}
		}
		return false;
	}

	/**
	 * Know whether containing action is an AcceptTimeEventAction
	 * 
	 * @return true is containing action is an AcceptEventAction with
	 *         AcceptTimeEventAction representation
	 */
	private boolean isInAcceptTimeEventAction() {
		IFigure parentFigure = getParentFigure();
		for(Object child : parentFigure.getChildren()) {
			if(child instanceof AcceptEventActionFigure) {
				return ((AcceptEventActionFigure)child).isTemplateForAcceptTimeEventActionUsed();
			}
		}
		return false;
	}

	/**
	 * Re-arrange the location of the border item, and also the contained arrow.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param borderItem
	 */
	@Override
	public void relocate(IFigure borderItem) {
		// reset bounds of borderItem
		Dimension size = getSize(borderItem);
		Rectangle rectSuggested = getConstraint().getCopy();
		if(rectSuggested.getTopLeft().x == 0 && rectSuggested.getTopLeft().y == 0) {
			rectSuggested.setLocation(getPreferredLocation(borderItem));
		} else {
			// recovered constraint must be translated with the parent location
			// to be absolute
			rectSuggested.setLocation(rectSuggested.getLocation().translate(getParentBorder().getTopLeft()));
		}
		rectSuggested.setSize(size);
		Rectangle validLocation = getValidLocation(rectSuggested, borderItem);
		// the constraint is not reset, but the item bounds are
		borderItem.setBounds(validLocation);
		// ensure the side property is correctly set
		setCurrentSideOfParent(findClosestAuthorizedSideOfParent(borderItem.getBounds(), getParentBorder()));
		// refresh the arrow depending on the Pin type and the side on which it
		// is located
		for(Object subfigure : borderItem.getChildren()) {
			if(subfigure instanceof IFigure) {
				for(Object child : ((IFigure)subfigure).getChildren()) {
					refreshPinDescriptorArrow(child, MapModeUtil.getMapMode(borderItem), size);
				}
			}
		}
	}

	/**
	 * Refresh the arrow in case child is a Pin Descriptor
	 * 
	 * @param child
	 *        the Pin Descriptor (no effect otherwise)
	 * @param mapMode
	 *        the IMapMode
	 * @param size
	 *        the size of the border item
	 */
	private void refreshPinDescriptorArrow(Object child, IMapMode mapMode, Dimension size) {
		boolean arrowIn = false;
		AbstractPointListShape arrow = null;
		if(child instanceof InputPinInOpaqueActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInOpaqueActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInCallBeActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInCallBeActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInCallOpActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInCallOpActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInCallOpActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInCallOpActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInSendObjActAsReqEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInSendObjActAsReqEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInSendObjActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInSendObjActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInSendSigActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInSendSigActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInSendSigActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInSendSigActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ActionInputPinInOpaqueActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ActionInputPinInOpaqueActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ActionInputPinInCallBeActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ActionInputPinInCallBeActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ActionInputPinInCallOpActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ActionInputPinInCallOpActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ActionInputPinInCallOpActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ActionInputPinInCallOpActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ActionInputPinInSendObjActAsReqEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ActionInputPinInSendObjActAsReqEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ActionInputPinInSendObjActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ActionInputPinInSendObjActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ActionInputPinInSendSigActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ActionInputPinInSendSigActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ActionInputPinInSendSigActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ActionInputPinInSendSigActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ValuePinInOpaqueActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ValuePinInOpaqueActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ValuePinInCallBeActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ValuePinInCallBeActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ValuePinInCallOpActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ValuePinInCallOpActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ValuePinInCallOpActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ValuePinInCallOpActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ValuePinInSendObjActAsReqEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ValuePinInSendObjActAsReqEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ValuePinInSendObjActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ValuePinInSendObjActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ValuePinInSendSigActEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ValuePinInSendSigActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ValuePinInSendSigActAsTargetEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((ValuePinInSendSigActAsTargetEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInOpaqueActEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInOpaqueActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInCallBeActEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInCallBeActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInCallOpActEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInCallOpActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInAcceptEventActionEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInAcceptEventActionEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInCreateObjectActionAsResultEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInCreateObjectActionAsResultEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof ReadSelfActionOutputPinEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((ReadSelfActionOutputPinEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInValSpecActEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInValSpecActEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInReadStructuralFeatureAsResultEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInReadStructuralFeatureAsResultEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInReadStructuralFeatureAsObjectEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInReadStructuralFeatureAsObjectEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInAddStructuralFeatureValueActionAsObjectEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInAddStructuralFeatureValueActionAsObjectEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInAddStructuralFeatureValueActionAsValueEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInAddStructuralFeatureValueActionAsValueEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInAddStructuralFeatureValueActionAsResultEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInAddStructuralFeatureValueActionAsResultEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInDestroyObjectActionEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInDestroyObjectActionEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInAddVariableValueActionAsValueEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInAddVariableValueActionAsValueEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInAddVariableValueActionAsInsertAtEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInAddVariableValueActionAsInsertAtEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof OutputPinInReadVariableActionAsResultEditPart.PinDescriptor) {
			arrowIn = false;
			arrow = ((OutputPinInReadVariableActionAsResultEditPart.PinDescriptor)child).getOptionalArrowFigure();
		} else if(child instanceof InputPinInBroadcastSignalActionEditPart.PinDescriptor) {
			arrowIn = true;
			arrow = ((InputPinInBroadcastSignalActionEditPart.PinDescriptor)child).getOptionalArrowFigure();
		}
		if(arrow != null && arrow.getPoints().size() > 0) {
			int arrowDirection;
			int side = getCurrentSideOfParent();
			switch(side) {
			case PositionConstants.NORTH:
				if(arrowIn) {
					arrowDirection = PositionConstants.SOUTH;
				} else {
					arrowDirection = PositionConstants.NORTH;
				}
				break;
			case PositionConstants.EAST:
				if(arrowIn) {
					arrowDirection = PositionConstants.WEST;
				} else {
					arrowDirection = PositionConstants.EAST;
				}
				break;
			case PositionConstants.SOUTH:
				if(arrowIn) {
					arrowDirection = PositionConstants.NORTH;
				} else {
					arrowDirection = PositionConstants.SOUTH;
				}
				break;
			case PositionConstants.WEST:
			default:
				if(arrowIn) {
					arrowDirection = PositionConstants.EAST;
				} else {
					arrowDirection = PositionConstants.WEST;
				}
			}
			ActivityFigureDrawer.redrawPinArrow(arrow, mapMode, size, arrowDirection);
		}
	}

	/**
	 * Get an initial location based on the side. ( appropriate extremity of the
	 * side )
	 * 
	 * @param side
	 *        the preferred side of the parent figure on which to place this
	 *        border item as defined in {@link PositionConstants}
	 * @return point
	 */
	protected Point getPreferredLocation(int side, IFigure borderItem) {
		Rectangle bounds = getParentBorder();
		int parentFigureWidth = bounds.width;
		int parentFigureHeight = bounds.height;
		int parentFigureX = bounds.x;
		int parentFigureY = bounds.y;
		int x = parentFigureX;
		int y = parentFigureY;
		Dimension borderItemSize = getSize(borderItem);
		switch(side) {
		case PositionConstants.NORTH:
			x += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().width;
			y += -borderItemSize.height + getBorderItemOffset().height;
			break;
		case PositionConstants.EAST:
			// take south east extremity to allow following pins placing above
			x += parentFigureWidth - getBorderItemOffset().width;
			y += parentFigureHeight - borderItemSize.height - EXTRA_BORDER_DEFAULT_OFFSET - getBorderItemOffset().height;
			break;
		case PositionConstants.SOUTH:
			x += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().width;
			y += parentFigureHeight - getBorderItemOffset().height;
			break;
		case PositionConstants.WEST:
		default:
			x += -borderItemSize.width + getBorderItemOffset().width;
			y += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().height;
		}
		return new Point(x, y);
	}

	/**
	 * Adapt the bounds constraint to fit to the action's contained pins
	 * 
	 * @param boundsConstraint
	 *        the constraint to adapt
	 * @param domainElement
	 *        the model action
	 * @return
	 * @return boundsConstraint for convenience
	 * 
	 */
	public static Bounds adaptActionHeight(Bounds boundsConstraint, EObject domainElement) {
		if(domainElement instanceof Action) {
			int pinsOnHeight = 0;
			int numberOfInputs = ((Action)domainElement).getInputs().size();
			int numberOfOutputs = ((Action)domainElement).getOutputs().size();
			if(domainElement instanceof CallOperationAction) {
				// target is located on top
				pinsOnHeight = Math.max(numberOfInputs - 1, numberOfOutputs);
			} else {
				pinsOnHeight = Math.max(numberOfInputs, numberOfOutputs);
			}
			if(pinsOnHeight > 0) {
				// each pin is 16 px height, consider extra px for margins
				int heightInPx = 2 * EXTRA_BORDER_DEFAULT_OFFSET + pinsOnHeight * (DEFAULT_PIN_SIZE + 8) - 8;
				boundsConstraint.setHeight(heightInPx);
			}
		}
		return boundsConstraint;
	}
}
