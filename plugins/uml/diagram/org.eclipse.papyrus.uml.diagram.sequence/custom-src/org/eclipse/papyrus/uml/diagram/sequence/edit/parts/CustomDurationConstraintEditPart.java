/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LinesBorder;
import org.eclipse.papyrus.uml.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ExternalLabelPrimaryDragRoleEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.TimeRelatedSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomDurationConstraintItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDurationConstraintEditPart extends DurationConstraintEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomDurationConstraintEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDurationConstraintItemSemanticEditPolicy());
	}

	@Override
	protected void refreshBounds() {
		if(getBorderItemLocator() != null) {
			int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
			int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			Point loc = new Point(x, y);
			int width = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
			int height = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
			if(width == -1) { // fix resize issue, the height is not able to smaller than prefer height due to width is -1 
				width = getFigure().getPreferredSize(width, height).width;
			}
			Dimension size = new Dimension(width, height);
			getBorderItemLocator().setConstraint(new Rectangle(loc, size));
		} else {
			super.refreshBounds();
		}
		//fix combined fragment move
		this.getFigure().getParent().getLayoutManager().layout(this.getFigure().getParent());
		relocateLabelEditPart();
	}

	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new CustomDurationConstraintFigure();
	}

	/**
	 * This method creates a specific edit policy for time realted elements
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#getPrimaryDragEditPolicy()
	 * 
	 * @return <code>EditPolicy</code>
	 * @Override
	 */
	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new TimeRelatedSelectionEditPolicy();
	}

	/**
	 * @Override use ExternalLabelPrimaryDragRoleEditPolicy
	 */
	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case DurationConstraintLabelEditPart.VISUAL_ID:
				case DurationConstraintAppliedStereotypeEditPart.VISUAL_ID:
					// use ExternalLabelPrimaryDragRoleEditPolicy
					return new ExternalLabelPrimaryDragRoleEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @Override use ExternalLabelPositionLocator
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof DurationConstraintLabelEditPart) {
			DurationConstraintLabelLocator locator = new DurationConstraintLabelLocator(getMainFigure());
			locator.setParentEditPart(this);
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else if(borderItemEditPart instanceof DurationConstraintAppliedStereotypeEditPart) {
			//use ExternalLabelPositionLocator
			IBorderItemLocator locator = new ExternalLabelPositionLocator(getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			return getParent().getCommand(request);
		}
		return super.getCommand(request);
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().showSourceFeedback(request);
		}
		super.showSourceFeedback(request);
	}

	/**
	 * @Override Override for redirecting creation request to the lifeline
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().eraseSourceFeedback(request);
		}
		super.eraseSourceFeedback(request);
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if((getModel() != null) && (getModel() == notification.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			}
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLineWidth();
	}

	private void relocateLabelEditPart() {
		List list = this.getChildren();
		for(Object o : list) {
			if(o instanceof DurationConstraintLabelEditPart) {
				DurationConstraintLabelEditPart label = (DurationConstraintLabelEditPart)o;
				if(label.getBorderItemLocator() != null) {
					IBorderItemLocator loc = label.getBorderItemLocator();
					loc.relocate(label.getFigure());
				}
			}
		}
	}

	public Rectangle updateMoveBounds(Rectangle newBounds) {
		if(getCurrentSideOfParent() == PositionConstants.WEST) {
			Rectangle bounds = this.getFigure().getBounds();
			return newBounds.translate(-bounds.width, 0); // keep bounds in left side
		}
		return newBounds;
	}

	public int getCurrentSideOfParent() {
		IBorderItemLocator locator = this.getBorderItemLocator();
		if(locator != null) {
			return locator.getCurrentSideOfParent();
		}
		return PositionConstants.EAST;
	}

	public class CustomDurationConstraintFigure extends DurationConstraintFigure {

		/**
		 * Height of the arrow end
		 * 
		 */
		private static final int ARROW_HEIGHT = 8;

		/**
		 * Width of the half of the arrow end
		 * 
		 */
		private static final int ARROW_SEMI_WIDTH = 7;

		/**
		 * Sets the bounds of this Figure to the Rectangle <i>rect</i>.
		 * This also updates sub-figures.
		 * 
		 * @see Figure#setBounds(Rectangle)
		 * @param rect
		 *        The new bounds
		 */
		@Override
		public void setBounds(Rectangle rect) {
			updateArrow(rect.width, rect.height);
			super.setBounds(rect);
		}

		/**
		 * Update the arrow polyline taking in account new figure's size
		 * 
		 * @param figureWidth
		 *        the new figure width
		 * @param figureHeight
		 *        the new figure height
		 */
		public void updateArrow(int figureWidth, int figureHeight) {
			// handle insets to avoid figure growing indefinitely
			figureWidth -= getInsets().left + getInsets().right;
			figureHeight -= getInsets().top + getInsets().bottom;
			if(getDurationArrow() != null) {
				PointList points = new PointList(8);
				points.addPoint(figureWidth / 2 - ARROW_SEMI_WIDTH, getLineWidth() / 2 + ARROW_HEIGHT);
				points.addPoint(figureWidth / 2, getLineWidth() / 2);
				points.addPoint(figureWidth / 2 + ARROW_SEMI_WIDTH, getLineWidth() / 2 + ARROW_HEIGHT);
				points.addPoint(figureWidth / 2, getLineWidth() / 2);
				points.addPoint(figureWidth / 2, figureHeight - getLineWidth() / 2);
				points.addPoint(figureWidth / 2 - ARROW_SEMI_WIDTH, figureHeight - getLineWidth() / 2 - ARROW_HEIGHT);
				points.addPoint(figureWidth / 2, figureHeight - getLineWidth() / 2);
				points.addPoint(figureWidth / 2 + ARROW_SEMI_WIDTH, figureHeight - getLineWidth() / 2 - ARROW_HEIGHT);
				getDurationArrow().setPoints(points);
				Point topLeft = getLocation().getTranslated(getInsets().left, getInsets().top);
				getDurationArrow().setBounds(new Rectangle(topLeft, new Dimension(figureWidth, figureHeight)));
			}
		}

		@Override
		public boolean containsPoint(int x, int y) {
			boolean containsPoint = super.containsPoint(x, y);
			if(!containsPoint) {
				return false;
			}
			PolylineShape durationArrow = getDurationArrow();
			if(durationArrow != null) {
				return PointListUtilities.containsPoint(durationArrow.getPoints(), new Point(x, y));
				//				return fDurationArrow.containsPoint(x, y);
			}
			return containsPoint;
		}

		public void paintFigure(Graphics graphics) {
			graphics.setLineWidth(lineWidth);
			super.paintFigure(graphics);
		}

		@Override
		public void setLineWidth(int w) {
			LinesBorder lb = (LinesBorder)getBorder();
			lb.setWidth(w);
			getDurationArrow().setLineWidth(w);
			super.setLineWidth(w);
		}
	}

	public static Rectangle fixMessageBounds(Rectangle newBounds, Request cvr, LifelineEditPart host) {
		Object oc1 = getFirstElement(cvr.getExtendedData().get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION));
		Object oc2 = getFirstElement(cvr.getExtendedData().get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2));
		if(oc1 != null && oc2 != null && (oc1 instanceof MessageOccurrenceSpecification || oc2 instanceof MessageOccurrenceSpecification)) {
			Point start = null, end = null;
			Rectangle bounds = null;
			if(oc1 instanceof InteractionFragment) {
				start = SequenceUtil.findLocationOfEvent(host, (InteractionFragment)oc1, true);
			}
			if(oc2 instanceof InteractionFragment) {
				end = SequenceUtil.findLocationOfEvent(host, (InteractionFragment)oc2, true);
			}
			if(start != null && end != null) {
				bounds = (start.y < end.y) ? new Rectangle(start, end) : new Rectangle(end, start);
			}
			if(bounds != null) {
				IFigure parentFigure = host.getFigure();
				Point parentFigDelta = parentFigure.getBounds().getLocation().getCopy().negate();
				parentFigure.translateToRelative(bounds);
				bounds.translate(parentFigDelta);
				if(bounds.y != newBounds.y || newBounds.height != bounds.height) {
					newBounds.y = bounds.y;
					newBounds.height = bounds.height;
				}
			}
		}
		return newBounds;
	}

	static class DurationConstraintLabelLocator extends ExternalLabelPositionLocator {

		private CustomDurationConstraintEditPart durationConstraintEditPart;

		public DurationConstraintLabelLocator(IFigure mainFigure) {
			super(mainFigure);
		}

		public void setParentEditPart(CustomDurationConstraintEditPart durationConstraintEditPart) {
			this.durationConstraintEditPart = durationConstraintEditPart;
		}

		@Override
		public void relocate(IFigure target) {
			if(constraint.y == 0) {
				if(durationConstraintEditPart.getCurrentSideOfParent() == PositionConstants.WEST) {
					Point r = parentFigure.getBounds().getLeft().translate(-20, -5);
					target.setBounds(new Rectangle(r, target.getPreferredSize()));
				} else {
					Point r = parentFigure.getBounds().getRight().translate(5, -5);
					target.setBounds(new Rectangle(r, target.getPreferredSize()));
				}
			} else
				super.relocate(target);
		}
	}

	static Object getFirstElement(Object obj) {
		if(obj != null && obj instanceof List) {
			List list = (List)obj;
			if(list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}
}
