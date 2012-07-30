/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;

/**
 * Edit Part provider for the stereotype display
 */
public class StereotypePropertiesEditPartProvider extends org.eclipse.papyrus.uml.diagram.clazz.custom.providers.StereotypePropertiesEditPartProvider {

	/** Default constructor */
	public StereotypePropertiesEditPartProvider() {
		super();

		diagramType = RequirementDiagramEditPart.DIAGRAM_ID;

	}
}
