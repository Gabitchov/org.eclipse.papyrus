/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.element;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/** Convenient utility class listing IElementType declared in plugin.xml */
public class SysMLElementTypes extends AbstractElementTypeEnumerator {

	/** IHintedType of SysML Block */
	public static final IHintedType BLOCK = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Block"); //$NON-NLS-N$

	/** IHintedType of SysML FlowPort */
	public static final IHintedType FLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowPort"); //$NON-NLS-N$

	/** IHintedType of SysML FlowPort (direction = #INOUT - default) */
	public static final IHintedType INOUT_FLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.InOutFlowPort"); //$NON-NLS-N$

	/** IHintedType of SysML FlowPort (direction = #IN) */
	public static final IHintedType IN_FLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.InFlowPort"); //$NON-NLS-N$

	/** IHintedType of SysML FlowPort (direction = #OUT) */
	public static final IHintedType OUT_FLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.OutFlowPort"); //$NON-NLS-N$

	/** IHintedType of SysML FlowProperty */
	public static final IHintedType FLOW_PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowProperty"); //$NON-NLS-N$

	/** IHintedType of SysML FlowSpecification */
	public static final IHintedType FLOW_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowSpecification"); //$NON-NLS-N$

	/** IHintedType of SysML Requirement */
	public static final IHintedType REQUIREMENT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Requirement"); //$NON-NLS-N$
}
