/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.element;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/**
 * Convenient utility class listing IElementType (from UML Standard profile) declared in plugin.xml.
 * TODO : to be completed.
 */
public class UMLStdElementTypes extends AbstractElementTypeEnumerator {

	/** IElementType for Standard Trace */
	public static final IHintedType TRACE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Trace"); //$NON-NLS-1$

}
