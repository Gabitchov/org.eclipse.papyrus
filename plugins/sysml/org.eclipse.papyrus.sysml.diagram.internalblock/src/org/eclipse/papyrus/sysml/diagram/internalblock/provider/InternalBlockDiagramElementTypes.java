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

import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class InternalBlockDiagramElementTypes extends InheritedElementTypes {

	/** ********************************************************* */
	/** Internal Block Diagram specific elements **************** */
	/** ********************************************************* */

	/** Internal Block Diagram :: Diagram */
	public static final IHintedType INTERNAL_BLOCK_DIAGRAM = (IHintedType) getElementType("InternalBlock"); //$NON-NLS-1$

	/** Internal Block Diagram :: FlowPort IN */
	public static final IHintedType FLOWPORT_IN = (IHintedType) getElementType("org.eclipse.papyrus.sysml.diagram.internalblock.FlowPortIN"); //$NON-NLS-1$
	public static final String FLOWPORT_IN_NAME_LABEL_HINT = PORT_CN_NAME_LABEL_HINT;
}
