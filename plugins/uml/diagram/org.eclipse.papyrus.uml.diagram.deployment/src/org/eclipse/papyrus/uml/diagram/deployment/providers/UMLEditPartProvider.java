/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public UMLEditPartProvider() {
		super(new UMLEditPartFactory(), UMLVisualIDRegistry.TYPED_INSTANCE, DeploymentDiagramEditPart.MODEL_ID);
	}
}
