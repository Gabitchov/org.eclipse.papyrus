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
 *  Yann Tanguy (CEA LIST) Yann.Tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.creation.element;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/** This class defines all IHintedType of SysML */
public class SysMLElementTypes extends AbstractElementTypeEnumerator {

	/** IHintedType of SysML Block */
	public static final IHintedType BLOCK = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Block");

	/** IHintedType of SysML Block */
	public static final IHintedType FLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowPort");

	/** IHintedType of SysML FlowPort */
	public static final IHintedType INFLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.InFlowPort");

	/** IHintedType of SysML FlowPort */
	public static final IHintedType OUTFLOWPORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.OutFlowPort");

}
