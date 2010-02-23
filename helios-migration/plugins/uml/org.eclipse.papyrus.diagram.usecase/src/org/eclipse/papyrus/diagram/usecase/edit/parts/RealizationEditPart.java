package org.eclipse.papyrus.diagram.usecase.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.edge.InterfaceRealizationFigure;
import org.eclipse.papyrus.diagram.usecase.edit.policies.RealizationItemSemanticEditPolicy;

/**
 * @generated
 */
public class RealizationEditPart extends ConnectionNodeEditPart

implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4017;

	/**
	 * @generated
	 */
	public RealizationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new RealizationItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof RealizationNameEditPart) {
			((RealizationNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof AppliedStereotypeRealizationEditPart) {
			((AppliedStereotypeRealizationEditPart)childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
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
		if(childEditPart instanceof RealizationNameEditPart) {
			return true;
		}
		if(childEditPart instanceof AppliedStereotypeRealizationEditPart) {
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
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new InterfaceRealizationFigure();
	}

	/**
	 * @generated
	 */
	public InterfaceRealizationFigure getPrimaryShape() {
		return (InterfaceRealizationFigure)getFigure();
	}

}
