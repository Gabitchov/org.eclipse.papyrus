/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class InternalBlockDiagramElementTypes extends AbstractElementTypeEnumerator {

	/** Internal Block Diagram specific elements */
	public static final IHintedType INTERNAL_BLOCK_DIAGRAM = (IHintedType)getElementType("InternalBlock"); //$NON-NLS-1$

	public static final IHintedType FLOWPORT_IN = (IHintedType)getElementType("org.eclipse.papyrus.sysml.diagram.internalblock.FlowPortIN"); //$NON-NLS-1$

	public static final String FLOWPORT_IN_NAME_LABEL_HINT = "5125";

	/** ********************************************************* */
	/** Block Definition Diagram - Class Diagram related elements */
	/** ********************************************************* */

	/** Class Diagram :: ClassComposite ChildNode */
	public static final IHintedType CLASS_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Class_3085"); //$NON-NLS-1$

	public static final String CLASS_CN_NAME_LABEL_HINT = "5155";

	public static final String CLASS_CN_COMPARTMENT_HINT = "7060";

	/** Class Diagram :: ClassComposite TopLevelNode */
	public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Class_2073"); //$NON-NLS-1$

	public static final String CLASS_NAME_LABEL_HINT = "5156";

	public static final String CLASS_COMPARTMENT_HINT = "7073";

	/** Class Diagram :: PropertyPart ChildNode */
	public static final IHintedType PROPERTY_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Property_3070"); //$NON-NLS-1$

	public static final String PROPERTY_CN_NAME_LABEL_HINT = "5126";

	public static final String PROPERTY_CN_COMPARTMENT_HINT = "7077";

	/** Class Diagram :: Port ChildNode */
	public static final IHintedType PORT_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Port_3069"); //$NON-NLS-1$

	public static final String PORT_CN_NAME_LABEL_HINT = "5125";

	public static final String PORT_CN_STEREOTYPE_LABEL_HINT = "6029";

	/** Class Diagram :: Connector */
	public static final IHintedType CONNECTOR = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Connector_4013"); //$NON-NLS-1$

	public static final String CONNECTOR_STEREOTYPE_LABEL_HINT = "6025";

}
