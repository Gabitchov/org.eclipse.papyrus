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

import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class RequirementDiagramElementTypes extends InheritedElementTypes {

	/** ********************************************************* */
	/** Requirement Diagram specific elements ******************* */
	/** ********************************************************* */

	/** Internal Block Diagram :: Diagram */
	public static final IHintedType REQUIREMENT_DIAGRAM = (IHintedType)getElementType("RequirementDiagram"); //$NON-NLS-1$

}
