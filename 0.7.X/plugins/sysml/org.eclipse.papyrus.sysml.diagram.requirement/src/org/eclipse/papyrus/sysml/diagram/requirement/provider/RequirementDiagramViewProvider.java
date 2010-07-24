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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.factory.RequirementDiagramViewFactory;


/**
 * SysML Requirement Diagram View provider from generic view provider
 * 
 */
public class RequirementDiagramViewProvider extends AbstractViewProvider {

	@Override
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		if(RequirementDiagramEditPart.DIAGRAM_ID.equals(diagramKind)) {
			return RequirementDiagramViewFactory.class;
		}
		return null;
	}
}
