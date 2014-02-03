package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.StateInvariant;

public class CustomStateInvariantLabelEditPart extends StateInvariantLabelEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomStateInvariantLabelEditPart(View view) {
		super(view);
	}

	protected EObject getParserElement() {
		EObject element = resolveSemanticElement();
		if(element instanceof StateInvariant) {
			return ((StateInvariant)element).getInvariant();
		}
		return element;
	}
}
