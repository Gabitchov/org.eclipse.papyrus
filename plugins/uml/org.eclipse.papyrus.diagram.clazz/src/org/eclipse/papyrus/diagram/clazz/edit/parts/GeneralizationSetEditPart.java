package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.GeneralizationSetItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.edge.DashedEdgeFigure;

/**
 * @generated
 */
public class GeneralizationSetEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4020;

	/**
	 * @generated
	 */
	public GeneralizationSetEditPart(View view) {
		super(view);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new DashedEdgeFigure(false);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new GeneralizationSetItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	public DashedEdgeFigure getPrimaryShape() {
		return (DashedEdgeFigure) getFigure();
	}

}
