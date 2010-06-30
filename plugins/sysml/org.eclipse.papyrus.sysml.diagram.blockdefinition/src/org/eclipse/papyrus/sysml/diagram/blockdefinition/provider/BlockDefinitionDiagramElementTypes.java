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

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class BlockDefinitionDiagramElementTypes extends AbstractElementTypeEnumerator {

	/** Block Definition Diagram specific elements */
	public static final IHintedType BLOCK_DEFINITION_DIAGRAM = (IHintedType)getElementType("BlockDefinition"); //$NON-NLS-1$

	public static final IHintedType BLOCK = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.blockdefinition.Block"); //$NON-NLS-1$

	public static final String BLOCK_NAME_LABEL_HINT = "5029"; // ClassNameEditPart.VISUAL_ID

	public static final String BLOCK_PROPERTY_COMPARTMENT_HINT = "7017"; //ClassAttributeCompartment2EditPart.VISUAL_ID

	public static final String BLOCK_OPERATION_COMPARTMENT_HINT = "7018"; //ClassOperationCompartment2EditPart.VISUAL_ID

	public static final String BLOCK_NESTEDCLASSIFIER_COMPARTMENT_HINT = "7019"; //ClassNestedClassifierCompartment2EditPart.VISUAL_ID

	public static final String BLOCK_CONSTRAINT_COMPARTMENT_HINT = "Block_Constraint_Compartment";
	
	public static final String BLOCK_PART_COMPARTMENT_HINT = "Block_Part_Compartment";
	
	public static final String BLOCK_VALUE_COMPARTMENT_HINT = "Block_Value_Compartment";
	
	public static final String BLOCK_REFERENCE_COMPARTMENT_HINT = "Block_Reference_Compartment";
	
	public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.blockdefinition.Constraint"); //$NON-NLS-1$
	
	public static final IHintedType PORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.blockdefinition.Port"); //$NON-NLS-1$

	public static final String PORT_NAME_LABEL_HINT = "Port_Name_Label";
	
	public static final IHintedType FLOW_PORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.blockdefinition.FlowPort"); //$NON-NLS-1$

	public static final IHintedType CONNECTOR = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.blockdefinition.Connector"); //$NON-NLS-1$
}
