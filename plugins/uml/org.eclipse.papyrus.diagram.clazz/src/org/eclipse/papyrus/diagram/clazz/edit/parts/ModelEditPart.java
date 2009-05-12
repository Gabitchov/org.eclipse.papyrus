package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ModelItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.edit.policies.DiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.edit.policies.ViewAndFeatureResolver;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ModelEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "PapyrusUMLClassDiagram"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	private ViewAndFeatureResolver resolver = new ViewAndFeatureResolver() {

		public boolean isEObjectNode(EObject element) {
			if (UMLVisualIDRegistry.getNodeVisualID(getNotationView(), element) > -1) {
				return true;
			}
			return false;
		}

		public boolean isEObjectLink(EObject element) {
			if (UMLVisualIDRegistry.getLinkWithClassVisualID(element) > -1) {
				return true;
			}
			return false;
		}

		public int getEObjectSemanticHint(EObject element) {
			if (element != null) {
				return UMLVisualIDRegistry.getNodeVisualID(getNotationView(),
						element);
			}
			return -1;
		}

		public EStructuralFeature getEStructuralFeatureForEClass(EClass class1) {
			if (UMLPackage.eINSTANCE.getDependency().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getAssociationClass().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getAssociation().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getComponent().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getSignal().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getInterface().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getModel().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getEnumeration().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getPackage().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getClass_().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getDataType().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getConstraint().equals(class1)) {
				return UMLPackage.eINSTANCE.getPackage_PackagedElement();
			}
			if (UMLPackage.eINSTANCE.getComment().equals(class1)) {
				return UMLPackage.eINSTANCE.getElement_OwnedComment();
			}
			return null;
		}
	};

	/**
	 * @generated
	 */
	public ModelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ModelItemSemanticEditPolicy());

		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.clazz.edit.policies.ModelCanonicalEditPolicy());

		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DiagramDragDropEditPolicy(resolver));

		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
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
		if (adapter != null && adapter.equals(ViewAndFeatureResolver.class)) {
			return this.resolver;
		}

		if (adapter != null && adapter.equals(ViewInfo.class)) {
			return UMLVisualIDRegistry.getDiagramViewInfo();
		}
		return super.getAdapter(adapter);
	}

}
