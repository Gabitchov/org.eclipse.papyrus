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
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

public class BlockDefinitionDiagramElementTypes extends InheritedElementTypes {

	/** ********************************************************* */
	/** Block Definition Diagram specific elements ************** */
	/** ********************************************************* */

	/** Block Definition Diagram :: Diagram */
	public static final IHintedType BLOCK_DEFINITION_DIAGRAM = (IHintedType)getElementType("BlockDefinition"); //$NON-NLS-1$

	/** Block Definition Diagram :: Block */
	public static final IHintedType BLOCK = SysMLElementTypes.BLOCK; //$NON-NLS-1$

	public static final String BLOCK_NAME_LABEL_HINT = CLASS_LABEL_NAME_HINT;

	public static final String BLOCK_PROPERTY_COMPARTMENT_HINT = CLASS_COMPARTMENT_ATTRIBUTE_HINT;

	public static final String BLOCK_OPERATION_COMPARTMENT_HINT = CLASS_COMPARTMENT_OPERATION_HINT;

	public static final String BLOCK_NESTEDCLASSIFIER_COMPARTMENT_HINT = CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT;

	public static final String BLOCK_CONSTRAINT_COMPARTMENT_HINT = "Block_Constraint_Compartment";

	public static final String BLOCK_PART_COMPARTMENT_HINT = "Block_Part_Compartment";

	public static final String BLOCK_VALUE_COMPARTMENT_HINT = "Block_Value_Compartment";

	public static final String BLOCK_REFERENCE_COMPARTMENT_HINT = "Block_Reference_Compartment";

	public static final IHintedType BLOCK_CONSTRAINT_CLN = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.blockdefinition.Constraint"); //$NON-NLS-1$	

	public static final IHintedType BLOCK_PART_CLN = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.blockdefinition.Part"); //$NON-NLS-1$	

}
