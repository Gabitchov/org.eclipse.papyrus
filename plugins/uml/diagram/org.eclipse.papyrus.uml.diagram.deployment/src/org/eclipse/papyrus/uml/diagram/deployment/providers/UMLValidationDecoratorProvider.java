/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.deployment.providers;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.providers.ValidationDecoratorProvider;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditor;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLValidationDecoratorProvider extends ValidationDecoratorProvider implements IDecoratorProvider {

	/**
	 * @generated
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart)decoratorTarget.getAdapter(EditPart.class);
		if(editPart instanceof GraphicalEditPart || editPart instanceof AbstractConnectionEditPart) {
			Object model = editPart.getModel();
			if((model instanceof View)) {
				View view = (View)model;
				if(!(view instanceof Edge) && !view.isSetElement()) {
					return;
				}
			}
			EditDomain ed = editPart.getViewer().getEditDomain();
			if(!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if(((DiagramEditDomain)ed).getEditorPart() instanceof UMLDiagramEditor) {
				decoratorTarget.installDecorator(KEY, new StatusDecorator(decoratorTarget));
			}
		}
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if(!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation)operation).getDecoratorTarget();
		View view = (View)decoratorTarget.getAdapter(View.class);
		return view != null && DeploymentDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}
}
