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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.core.IElementWithSemantic;

/**
 * this class is used to obtain the semantic element for element of a gmf diagram
 *
 */
public class SemanticFromGMFElement implements IElementWithSemantic {
	/**
	 * 
	 * @see org.eclipse.papyrus.core.IElementWithSemantic#getSemanticElement(java.lang.Object)
	 *
	 * @param wrapper can be for examplean editpart of gmf
	 * @return the semantic element linked to this or null element
	 */
	public Object getSemanticElement(Object wrapper) {
		if(wrapper instanceof IGraphicalEditPart){
			return ((IGraphicalEditPart)wrapper).resolveSemanticElement();
		}
		if( wrapper instanceof IAdaptable){
			return ((IAdaptable)wrapper).getAdapter(EObject.class);
		}
		return null;
	}

}
