/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.CustomRequirementNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.custom.factory.CustomUMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;

/**
 * this is custom editpart factory to create our own editpart
 */
public class CustomRequirementUMLEditPartFactory extends CustomUMLEditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (UMLVisualIDRegistry.getVisualID(view)) {
			// redefined classes to modify the method createNodePlate
			case ClassNameEditPart.VISUAL_ID:
				return new CustomRequirementNameEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
