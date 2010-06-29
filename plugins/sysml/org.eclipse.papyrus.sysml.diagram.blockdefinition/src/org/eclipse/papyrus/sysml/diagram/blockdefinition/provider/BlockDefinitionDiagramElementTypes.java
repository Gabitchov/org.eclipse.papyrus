/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class BlockDefinitionDiagramElementTypes extends InheritedElementTypes {

	/** ********************************************************* */
	/** Block Definition Diagram specific elements ************** */
	/** ********************************************************* */

	/** Block Definition Diagram :: Diagram */
	public static final IHintedType BLOCK_DEFINITION_DIAGRAM = (IHintedType)getElementType("BlockDefinition"); //$NON-NLS-1$

	/** Block Definition Diagram :: Block */
	public static final IHintedType BLOCK = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.blockdefinition.Block"); //$NON-NLS-1$

	public static final String BLOCK_CONSTRAINT_COMPARTMENT_HINT = "Block_Constraint_Compartment";

}
