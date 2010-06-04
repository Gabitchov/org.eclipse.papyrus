/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.factory.CustomUMLeditPartFactory;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.requirement.Messages;


/**
 * Creation of the SysML Requirement Diagram Edit Part
 * 
 */
public class InheritedElementEditPartFactory extends CustomUMLeditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {

		if(model instanceof View) {
			View view = (View)model;
			String viewType = view.getType();
			return createEditPart(context, UMLVisualIDRegistry.getVisualID(viewType));
		}

		System.err.println(Messages.SysMLEditPartFactory_CreateEditPart_Null_Result);
		return null;
	}
}
