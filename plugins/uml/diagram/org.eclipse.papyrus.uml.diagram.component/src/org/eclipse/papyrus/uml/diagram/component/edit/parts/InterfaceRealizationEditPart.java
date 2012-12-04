package org.eclipse.papyrus.uml.diagram.component.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.policies.InterfaceRealizationItemSemanticEditPolicy;

/**
 * @generated
 */
public class InterfaceRealizationEditPart extends ConnectionEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4006;

	/**
	 * @generated
	 */
	public InterfaceRealizationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InterfaceRealizationItemSemanticEditPolicy());
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
		return new SimpleDependency();
	}

	/**
	 * @generated
	 */
	public SimpleDependency getPrimaryShape() {
		return (SimpleDependency)getFigure();
	}

	/**
	 * @generated
	 */
	public class SimpleDependency extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public SimpleDependency() {
			this.setForegroundColor(ColorConstants.black);
		}
	}
}
