package org.eclipse.papyrus.sysml.diagram.parametric.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContextLinkAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContextLinkEditPart;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLEditPartProvider;

public class InheritedCompositeDiagramEditPartProvider extends UMLEditPartProvider {

	@Override
	protected IGraphicalEditPart createEditPart(View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		if (visualID == ContextLinkEditPart.VISUAL_ID) {
			return new ContextLinkEditPart(view);
		}
		if (visualID == ContextLinkAppliedStereotypeEditPart.VISUAL_ID) {
			return new ContextLinkAppliedStereotypeEditPart(view);
		}
		return super.createEditPart(view);
	}
	
	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is a Parametric Diagram
			if(!ElementTypes.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test supported inherited types
			EObject eobject = view.getElement();

			/** Nodes (and ChildLabelNodes) *********** */
			if(eobject instanceof org.eclipse.uml2.uml.Constraint) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Comment) {
				return true;
			}

			// Additional test needed here to decide whether to support Feature type links.
			// As feature type link are not related to a MetaClass from the domain model
			// they are not already handled by previous tests.
			// Also concerns NotationType.
			String hint = view.getType();

			/** Edges (Feature) : COMMENT_ANNOTATED_ELEMENT *********** */
			if(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint().equals(hint)) {
				return true;
			}
			/** Edges (Feature) : CONSTRAINT_CONSTRAINED_ELEMENT *********** */
			if(ElementTypes.CONTEXT_LINK.getSemanticHint().equals(hint)) {
				return true;
			}
			if(ElementTypes.CONTEXT_LINK_APPLIED_STEREOTYPE.getSemanticHint().equals(hint)) {
				return true;
			}

		}
		return false;
	}

}
