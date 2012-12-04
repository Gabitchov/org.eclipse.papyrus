package org.eclipse.papyrus.uml.diagram.component.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.policies.ConstraintConstrainedElementItemSemanticEditPolicy;

/**
 * @generated
 */
public class ConstraintConstrainedElementEditPart extends ConnectionEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4009;

	/**
	 * @generated
	 */
	public ConstraintConstrainedElementEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConstraintConstrainedElementItemSemanticEditPolicy());
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
		return new CommentLinkDescriptor();
	}

	/**
	 * @generated
	 */
	public CommentLinkDescriptor getPrimaryShape() {
		return (CommentLinkDescriptor)getFigure();
	}

	/**
	 * @generated
	 */
	public class CommentLinkDescriptor extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public CommentLinkDescriptor() {
			this.setLineStyle(Graphics.LINE_DASH);
		}
	}
}
