/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.BehaviorPortEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;

/**
 * Replacement EditPart factory.
 */
public class CustomEditPartFactory extends UMLEditPartFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {

			case ConnectorMultiplicitySourceEditPart.VISUAL_ID:
				return new ConnectorMultiplicitySourceEditPart(view);

			case ConnectorMultiplicityTargetEditPart.VISUAL_ID:
				return new ConnectorMultiplicityTargetEditPart(view);
			

			}
		}
		return super.createEditPart(context, model);
	}
}
