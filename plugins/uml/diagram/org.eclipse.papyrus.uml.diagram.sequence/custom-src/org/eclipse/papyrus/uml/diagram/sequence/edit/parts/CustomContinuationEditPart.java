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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomContinuationItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.locator.ContinuationLocator;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomContinuationEditPart extends ContinuationEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomContinuationEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomContinuationItemSemanticEditPolicy());
	}

	/**
	 * Overrides to manage the position of the Continuation
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if(UMLPackage.eINSTANCE.getContinuation_Setting().equals(notification.getFeature())) {
			IBorderItemLocator borderItemLocator = getBorderItemLocator();
			int newValue = (Boolean)notification.getNewValue() ? PositionConstants.SOUTH : PositionConstants.NORTH;
			if(borderItemLocator instanceof ContinuationLocator) {
				((ContinuationLocator)borderItemLocator).setPreferredSideOfParent(newValue);
				// Refresh the position of the figure
				borderItemLocator.relocate(this.getFigure());
			}
		}
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

	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart#createNodeShape()
	 * 
	 * @return
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new CustomContinuationFigure();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart#getPrimaryShape()
	 * 
	 * @return
	 */
	@Override
	public CustomContinuationFigure getPrimaryShape() {
		return (CustomContinuationFigure)primaryShape;
	}

	public class CustomContinuationFigure extends ContinuationFigure {

		protected void fillShape(Graphics graphics) {
			graphics.pushState();
			applyTransparency(graphics);
			graphics.fillRoundRectangle(getBounds(), corner.width, corner.height);
			graphics.popState();
		}

		/**
		 * The transparency of this shape in percent.
		 * Must be in [0, 100] range.
		 */
		private int transparency = 0;

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
}
