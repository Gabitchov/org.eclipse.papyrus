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
	public static final IHintedType BLOCK = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Block");

	/** IHintedType of SysML FlowPort (direction = #INOUT - default) */
	public static final IHintedType FLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowPort");

	/** IHintedType of SysML FlowPort (direction = #IN) */
	public static final IHintedType IN_FLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.InFlowPort");

	/** IHintedType of SysML FlowPort (direction = #OUT) */
	public static final IHintedType OUT_FLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.OutFlowPort");

}
