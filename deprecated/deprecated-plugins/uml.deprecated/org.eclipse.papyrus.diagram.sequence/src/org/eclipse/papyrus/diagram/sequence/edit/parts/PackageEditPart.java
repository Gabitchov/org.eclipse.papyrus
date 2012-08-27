/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.ViewAndFeatureResolver;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.ids.UMLDiagramEditorIDs;
import org.eclipse.papyrus.diagram.sequence.edit.policies.PackageCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.PackageItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.SequenceDiagramDragAndDropEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class PackageEditPart extends DiagramEditPart {

	/**
	 * @generated NOT
	 */
	// public final static String MODEL_ID = "UMLSequence"; //$NON-NLS-1$
	// all model IDs are grouped in org.eclipse.papyrus.diagram.common.ids
	public final static String MODEL_ID = UMLDiagramEditorIDs.SequenceModelID;

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 79;

	/**
	 * Modified to perform correct Drag&Drop of an <Interaction>.
	 * 
	 * @generated NOT
	 */
	private final ViewAndFeatureResolver resolver = new ViewAndFeatureResolver() {
		/**
		 * generated NOT
		 */
		public boolean isEObjectNode(EObject element) {
			if (element instanceof Interaction) {
				// an Interaction's View can now be correctly initialized.
				// Check if is children
				if (resolveSemanticElement().eContents().contains(element)) {
					// check if there is no existing view of the children
					if (DiagramEditPartsUtil.getEObjectViews(element).size() == 0)
						return true;
				}
			}
			if (element instanceof Comment) {
				return true;
			}
			return false;
		}

		public boolean isEObjectLink(EObject element) {
			return false;
		}

		public int getEObjectSemanticHint(EObject element) {
			// we will only allow Interaction Drag and Drop
			if (element instanceof Interaction) {
				return UMLVisualIDRegistry.getNodeVisualID(getNotationView(),
						element);
			}
			return -1;
		}

		public EStructuralFeature getEStructuralFeatureForEClass(EClass class1) {
			if (UMLPackage.eINSTANCE.getComment().equals(class1)) {
				return UMLPackage.eINSTANCE.getElement_OwnedComment();
			}
			return null;
		}
	};

	/**
	 * @generated
	 */
	public PackageEditPart(View view) {
		super(view);
	}

	/**
	 * Modified to install custom Drag&Drop policy.
	 * 
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PackageItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new PackageCanonicalEditPolicy());
		// fjcano: modified to install custom Drag&Drop policy.
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new SequenceDiagramDragAndDropEditPolicy(resolver));

		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.
		// EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {

		super.handleNotificationEvent(event);
		if (event.getNotifier() instanceof EAnnotation) {
			EAnnotation eAnnotation = (EAnnotation) event.getNotifier();
			if (eAnnotation.getSource() != null
					&& eAnnotation.getSource().equals(
							MDTUtil.FilterViewAndLabelsSource)) {
				DiagramEditPartsUtil.updateDiagram(this);
			}
		}
	}

	/**
	 * @generated
	 */
	@Override
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
