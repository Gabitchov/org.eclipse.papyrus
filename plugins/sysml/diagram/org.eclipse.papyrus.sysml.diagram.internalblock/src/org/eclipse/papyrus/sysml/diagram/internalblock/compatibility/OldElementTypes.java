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
package org.eclipse.papyrus.sysml.diagram.internalblock.compatibility;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/**
 * This class list element hints previously used by the Internal Block Diagram.
 */
public class OldElementTypes extends AbstractElementTypeEnumerator {

	/** CompositeDiagram :: CLASS */
	public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Class_2073"); //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_STRUCTURE_HINT = "7073"; //$NON-NLS-1$

	public static final String CLASS_LABEL_COMPOSITE_NAME_HINT = "5156"; //$NON-NLS-1$

	/** CompositeDiagram :: PORT_CN */
	public static final IHintedType PORT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Port_3069"); //$NON-NLS-1$

	public static final String PORT_CN_LABEL_NAME_HINT = "5125"; //$NON-NLS-1$

	public static final String PORT_CN_LABEL_APPLIED_STEREOTYPE_HINT = "6029"; //$NON-NLS-1$

	/** CompositeDiagram :: PROPERTY_CN */
	public static final IHintedType PROPERTY_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Property_3070"); //$NON-NLS-1$

	public static final String PROPERTY_CN_COMPARTMENT_STRUCTURE_HINT = "7077"; //$NON-NLS-1$

	public static final String PROPERTY_CN_LABEL_PART_NAME_HINT = "5126"; //$NON-NLS-1$

	/** CompositeDiagram :: CONNECTOR */
	public static final IHintedType CONNECTOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Connector_4013"); //$NON-NLS-1$

	public static final String CONNECTOR_LABEL_APPLIED_STEREOTYPE_HINT = "6025"; //$NON-NLS-1$

	public static final String CONNECTOR_LABEL_NAME_HINT = "6050"; //$NON-NLS-1$

	public static final String CONNECTOR_LABEL_MULTIPLICITY_SOURCE_HINT = "6051"; //$NON-NLS-1$

	public static final String CONNECTOR_LABEL_MULTIPLICITY_TARGET_HINT = "6052"; //$NON-NLS-1$
	
	
	// 0.8.1 --> 0.9.1
	public static final String SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID = "shape_sysml_nestedblockproperty_as_composite";//$NON-NLS-1$ 

}
