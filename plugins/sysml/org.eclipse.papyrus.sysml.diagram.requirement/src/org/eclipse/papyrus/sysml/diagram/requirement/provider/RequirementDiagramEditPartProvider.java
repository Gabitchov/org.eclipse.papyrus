/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;

/**
 * SysML Requirement Diagram Edit Part provider from generic Edit Part provider
 * 
 */
public class RequirementDiagramEditPartProvider extends AbstractEditPartProvider {

	@Override
	protected Class getDiagramEditPartClass(View view) {
		if(RequirementDiagramEditPart.DIAGRAM_ID.equals(view.getType())) {
			return RequirementDiagramEditPart.class;
		}
		return null;
	}

}
