package org.eclipse.papyrus.uml.diagram.component.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public UMLEditPartProvider() {
		super(new UMLEditPartFactory(), UMLVisualIDRegistry.TYPED_INSTANCE,
				ComponentDiagramEditPart.MODEL_ID);
	}
}
