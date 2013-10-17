/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.diagram.common.edit.policy.BlockPropertyStructureCompartmentSemanticEditPolicy;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

public class CustomBlockPropertyStructureCompartmentSemanticEditPolicy extends
		BlockPropertyStructureCompartmentSemanticEditPolicy {

	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		View dropTargetView = ((IGraphicalEditPart) getHost()).getNotationView();
		EObject eContainer = dropTargetView.eContainer();
		Element parent = null;
		if (eContainer != null && eContainer instanceof View) {
			parent = (Element) ((View) eContainer).getElement();
		}
		if (parent instanceof Property) {
			parent = ((Property) parent).getType();
		}

		if (parent != null) {
			if (UMLUtil.getStereotypeApplication(parent, ConstraintBlock.class) != null) {
				IElementType elementType = req.getElementType();
				if (elementType != UMLElementTypes.CONSTRAINT
						&& elementType != UMLElementTypes.COMMENT) {
					// ConstraintBlock
					if (elementType != SysMLElementTypes.CONSTRAINT_PROPERTY) {
						// only ConstraintProperty can be dropped in structure
						// compartment of a diagram owned by a ConstraintBlock
						// (except common Comment and Constraint)
						return UnexecutableCommand.INSTANCE;
					}
				}
			}
		}

		return super.getCreateCommand(req);
	}
}
