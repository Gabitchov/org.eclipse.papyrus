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

	/** Block Definition Diagram - Class Diagram related elements */
	public static final IHintedType Package_2007 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_2007"); //$NON-NLS-1$

	public static final IHintedType Dependency_2014 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_2014"); //$NON-NLS-1$

	public static final IHintedType Property_3012 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Property_3012"); //$NON-NLS-1$

	public static final IHintedType Usage_4007 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Usage_4007"); //$NON-NLS-1$

}
