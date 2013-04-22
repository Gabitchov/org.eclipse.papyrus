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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomStateInvariantItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.locator.CenterLocator;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomStateInvariantEditPart extends StateInvariantEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomStateInvariantEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomStateInvariantItemSemanticEditPolicy());
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
		refreshTransparency();
	}

	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	@Override
	protected void refreshBounds() {
		if(getBorderItemLocator() != null) {
			int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
			int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
			Point loc = new Point(x, y);
			int width = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
			int height = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
			Dimension size = new Dimension(width, height);
			// fix size
			getFigure().setBounds(new Rectangle(loc, size));
			getBorderItemLocator().setConstraint(new Rectangle(loc, size));
		} else {
			super.refreshBounds();
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart#getPrimaryShape()
	 * 
	 * @return
	 */
	@Override
	public StateInvariantFigure getPrimaryShape() {
		return (StateInvariantFigure)primaryShape;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart#createNodeShape()
	 * 
	 * @return
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new StateInvariantFigure();
	}

	public class StateInvariantFigure extends ContinuationFigure {

		/**
		 * The transparency of this shape in percent.
		 * Must be in [0, 100] range.
		 */
		private int transparency = 0;

		protected void fillShape(Graphics graphics) {
			graphics.pushState();
			applyTransparency(graphics);
			graphics.fillRoundRectangle(getBounds(), corner.width, corner.height);
			graphics.popState();
		}

		/**
		 * Returns transparency value (belongs to [0, 100] interval)
		 * 
		 * @return transparency
		 * @since 1.2
		 */
		public int getTransparency() {
			return transparency;
		}

		/**
		 * Sets the transparency if the given parameter is in [0, 100] range
		 * 
		 * @param transparency
		 *        The transparency to set
		 * @since 1.2
		 */
		public void setTransparency(int transparency) {
			if(transparency != this.transparency && transparency >= 0 && transparency <= 100) {
				this.transparency = transparency;
				repaint();
			}
		}

		/**
		 * Converts transparency value from percent range [0, 100] to alpha range
		 * [0, 255] and applies converted value. 0% corresponds to alpha 255 and
		 * 100% corresponds to alpha 0.
		 * 
		 * @param g
		 *        The Graphics used to paint
		 * @since 1.2
		 */
		protected void applyTransparency(Graphics g) {
			g.setAlpha(255 - transparency * 255 / 100);
		}
	}

	static class StateInvariantLocator extends CenterLocator {

		public StateInvariantLocator(IFigure parentFigure, int location) {
			super(parentFigure, location);
		}

		public void relocate(IFigure borderItem) {
			Point constraintLocation = getConstraint().getLocation();
			Dimension size = getSize(borderItem);
			Point ptNewLocation = new Point(getParentBorder().getCenter().x - size.width / 2, constraintLocation.y);
			borderItem.setBounds(new Rectangle(ptNewLocation, size));
		}

		public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
			Rectangle realLocation = new Rectangle(proposedLocation);
			Point point = new Point(getParentBorder().getCenter().x - realLocation.getSize().width / 2, realLocation.y);
			realLocation.setLocation(point);
			return realLocation;
		}
	};

	public static class StateInvariantResizableEditPolicy extends BorderItemResizableEditPolicy {

		protected Command getResizeCommand(ChangeBoundsRequest request) {
			IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
			IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();
			if(borderItemLocator != null) {
				PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
				getHostFigure().translateToAbsolute(rect);
				rect.translate(request.getMoveDelta());
				rect.resize(request.getSizeDelta());
				getHostFigure().translateToRelative(rect);
				Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());
				if(borderItemEP.getParent() instanceof LifelineEditPart && !restrictInParentBounds((LifelineEditPart)borderItemEP.getParent(), borderItemEP, realLocation.getCopy()))
					return null;
				ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)getHost().getModel()), realLocation);
				return new ICommandProxy(moveCommand);
			}
			return null;
		}

		protected Command getMoveCommand(ChangeBoundsRequest request) {
			IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
			IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();
			if(borderItemLocator != null) {
				PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
				getHostFigure().translateToAbsolute(rect);
				rect.translate(request.getMoveDelta());
				rect.resize(request.getSizeDelta());
				getHostFigure().translateToRelative(rect);
				Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());
				if(borderItemEP.getParent() instanceof LifelineEditPart && !restrictInParentBounds((LifelineEditPart)borderItemEP.getParent(), borderItemEP, realLocation.getCopy()))
					return null;
				Point location = realLocation.getTopLeft();
				ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)getHost().getModel()), location);
				return new ICommandProxy(moveCommand);
			}
			return null;
		}

		private boolean restrictInParentBounds(LifelineEditPart ep, IBorderItemEditPart borderItemEP, Rectangle realLocation) {
			borderItemEP.getFigure().translateToAbsolute(realLocation);
			Rectangle bounds = ep.getPrimaryShape().getBounds().getCopy();
			ep.getPrimaryShape().translateToAbsolute(bounds);
			int nameHeight = ep.getPrimaryShape().getFigureLifelineNameContainerFigure().getBounds().height;
			if(realLocation.y - nameHeight < bounds.y)
				return false;
			if(realLocation.getBottom().y > bounds.getBottom().y)
				return false;
			return true;
		}
	}
}
