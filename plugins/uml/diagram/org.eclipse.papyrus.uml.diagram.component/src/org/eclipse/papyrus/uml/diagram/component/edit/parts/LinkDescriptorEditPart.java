package org.eclipse.papyrus.uml.diagram.component.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ViewComponentEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;

/**
 * @generated
 */
public class LinkDescriptorEditPart extends ConnectionEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4016;

	/**
	 * @generated
	 */
	public LinkDescriptorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ViewComponentEditPolicy());
		removeEditPolicy(EditPolicyRoles.SEMANTIC_ROLE);
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
		return new LinkDescriptor();
	}

	/**
	 * @generated
	 */
	public LinkDescriptor getPrimaryShape() {
		return (LinkDescriptor)getFigure();
	}

	/**
	 * @generated
	 */
	public class LinkDescriptor extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public LinkDescriptor() {
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DASH);
		}
	}
}
