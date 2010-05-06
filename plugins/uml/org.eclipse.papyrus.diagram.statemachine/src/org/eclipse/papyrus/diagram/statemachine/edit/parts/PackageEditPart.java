package org.eclipse.papyrus.diagram.statemachine.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.statemachine.custom.policies.CustomPackageCreationEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.custom.policies.CustomPackageXYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.custom.policies.CustomStateMachineDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.custom.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.PackageItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class PackageEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "PapyrusUMLStateMachineDiagram"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public PackageEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE,
				new DuplicatePasteEditPolicy());

		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PackageItemSemanticEditPolicy());

		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.statemachine.edit.policies.PackageCanonicalEditPolicy());

		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CustomPackageCreationEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new CustomPackageXYLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new CustomStateMachineDiagramDragDropEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {

		super.handleNotificationEvent(event);
		if (event.getNotifier() instanceof EAnnotation) {
			EAnnotation eAnnotation = (EAnnotation) event.getNotifier();
			if (eAnnotation.getSource() != null
					&& eAnnotation.getSource().equals(
							MDTUtil.FilterViewAndLabelsSource)) {
				//modification form MOSKitt approach, canonical policies are not called
				MDTUtil.filterDiagramViews(this.getDiagramView());
			}
		}
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class adapter) {

		if (adapter != null && adapter.equals(ViewInfo.class)) {
			return UMLVisualIDRegistry.getDiagramViewInfo();
		}
		return super.getAdapter(adapter);
	}

}
