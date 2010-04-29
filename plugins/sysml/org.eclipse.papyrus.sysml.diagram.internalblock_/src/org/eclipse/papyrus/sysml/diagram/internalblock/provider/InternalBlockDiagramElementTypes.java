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

	/** Block Definition Diagram - Class Diagram related elements */
	public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Class_2073"); //$NON-NLS-1$

	public static final IHintedType PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Property_3070"); //$NON-NLS-1$

	public static final IHintedType PORT = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Port_3069"); //$NON-NLS-1$

	public static final IHintedType CONNECTOR = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Connector_4013"); //$NON-NLS-1$

}
