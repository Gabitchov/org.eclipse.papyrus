package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.statemachine.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class RegionCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		LinkedList<EObject> result = new LinkedList<EObject>();
		List<UMLNodeDescriptor> childDescriptors = UMLDiagramUpdater
				.getRegionRegionCompartment_3002SemanticChildren(viewObject);
		for (Iterator<UMLNodeDescriptor> it = childDescriptors.iterator(); it
				.hasNext();) {
			UMLNodeDescriptor d = it.next();
			result.add(d.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case PseudoStateNodeEditPart.VISUAL_ID:
		case FinalStateNodeEditPart.VISUAL_ID:
		case StateNodeEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected EStructuralFeature getFeatureToSynchronize() {
		return UMLPackage.eINSTANCE.getRegion_Subvertex();
	}

}
