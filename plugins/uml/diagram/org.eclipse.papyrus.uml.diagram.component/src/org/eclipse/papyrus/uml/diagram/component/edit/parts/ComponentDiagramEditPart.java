package org.eclipse.papyrus.uml.diagram.component.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.component.edit.policies.ComponentDiagramItemSemanticEditPolicy;

/**
 * @generated
 */
public class ComponentDiagramEditPart extends PapyrusDiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "PapyrusUMLComponentDiagram"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public ComponentDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new PapyrusCreationEditPolicy());
		installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE,
				new DuplicatePasteEditPolicy());

		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ComponentDiagramItemSemanticEditPolicy());

		// in Papyrus diagrams are not strongly synchronised
		// installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE,
		// new
		// org.eclipse.papyrus.uml.diagram.component.edit.policies.ModelCanonicalEditPolicy());

		installEditPolicy("REMOVE_ORPHAN_VIEW", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new CustomDiagramDragDropEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}
}
