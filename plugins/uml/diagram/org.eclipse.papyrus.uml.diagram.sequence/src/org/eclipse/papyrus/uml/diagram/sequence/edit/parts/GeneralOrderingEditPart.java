package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.ArrowLocator;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.GeneralOrderingItemSemanticEditPolicy;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class GeneralOrderingEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4012;

	/**
	 * @generated
	 */
	public GeneralOrderingEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GeneralOrderingItemSemanticEditPolicy());
		installEditPolicy(AppliedStereotypeLinkLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeLinkLabelDisplayEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof GeneralOrderingAppliedStereotypeEditPart) {
			((GeneralOrderingAppliedStereotypeEditPart)childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof GeneralOrderingAppliedStereotypeEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new GeneralOrderingDescriptor();
	}

	/**
	 * @generated
	 */
	public GeneralOrderingDescriptor getPrimaryShape() {
		return (GeneralOrderingDescriptor)getFigure();
	}

	/**
	 * @generated NOT inherits from UMLEdgeFigure to manage stereotype label
	 */
	public class GeneralOrderingDescriptor extends UMLEdgeFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fAppliedStereotypeLabel;

		/**
		 * Decoration to place in the middle of the connection
		 * 
		 * @generated NOT
		 */
		private RotatableDecoration middleDecoration;

		/**
		 * @generated NOT call the super constructor, create super contents, set the middle decoration
		 */
		public GeneralOrderingDescriptor() {
			// call the super constructor
			super();
			// create super contents
			createContents();
			this.setLineStyle(Graphics.LINE_DASH);
			this.setForegroundColor(ColorConstants.black);
			// set the middle decoration
			setMiddleDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolygonDecoration df = new PolygonDecoration();
			df.setFill(true);
			df.setForegroundColor(getForegroundColor());
			df.setBackgroundColor(getForegroundColor());
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(2));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(-2));
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(2));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
		}

		/**
		 * @generated NOT get the stereotype label of super class
		 */
		public WrappingLabel getAppliedStereotypeLabel() {
			return super.getAppliedStereotypeLabel();
		}

		/**
		 * Get the decoration of the middle
		 * 
		 * @return the middle decoration - possibly null
		 * @generated NOT
		 */
		protected RotatableDecoration getMiddleDecoration() {
			return middleDecoration;
		}

		/**
		 * Set the foreground background
		 * 
		 * @see org.eclipse.draw2d.IFigure#setForegroundColor(org.eclipse.swt.graphics.Color)
		 * @generated NOT
		 */
		public void setForegroundColor(Color fg) {
			super.setForegroundColor(fg);
			if(getMiddleDecoration() != null) {
				getMiddleDecoration().setForegroundColor(fg);
				getMiddleDecoration().setBackgroundColor(fg);
			}
		}

		@Override
		public void setLineWidth(int w) {
			super.setLineWidth(w);
			if(getMiddleDecoration() instanceof Shape) {
				((Shape)getMiddleDecoration()).setLineWidth(w);
			}
		}

		/**
		 * Set the middle decoration
		 * 
		 * @see org.eclipse.draw2d.PolylineConnection#setTargetDecoration(org.eclipse.draw2d.RotatableDecoration)
		 * @generated NOT
		 */
		public void setMiddleDecoration(RotatableDecoration dec) {
			if(getMiddleDecoration() != null) {
				remove(getMiddleDecoration());
			}
			middleDecoration = dec;
			if(dec != null) {
				add(dec, new ArrowLocator(this, ConnectionLocator.MIDDLE) {

					/**
					 * Relocates the passed in figure (which must be a {@link RotatableDecoration}) at the middle of the connection.
					 * 
					 * @param target
					 *        The RotatableDecoration to relocate
					 */
					public void relocate(IFigure target) {
						PointList points = getConnection().getPoints();
						RotatableDecoration arrow = (RotatableDecoration)target;
						arrow.setLocation(getLocation(points));
						Point refPoint;
						if(points.size() % 2 == 0) {
							int i = points.size() / 2;
							refPoint = points.getPoint(i - 1);
						} else {
							int i = (points.size() - 1) / 2;
							refPoint = points.getPoint(i - 1);
						}
						arrow.setReferencePoint(refPoint);
					}
				});
			}
		}
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
			refreshLineWidth();
		}
	}

	protected void setLineWidth(int width) {
		getPrimaryShape().setLineWidth(width);
	}
}
