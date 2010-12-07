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
package org.eclipse.papyrus.modelexplorer;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.papyrus.core.IElementWithSemantic;

/**
 * this class is used to obtain the semantic element for element of the model explorer 
 *
 */
public class SemanticFromModelExplorer implements IElementWithSemantic {

	/**
	 * 
	 * @see org.eclipse.papyrus.core.IElementWithSemantic#getSemanticElement(java.lang.Object)
	 *
	 * @param wrapper can be for example ModelElementItem of LinkItem
	 * @return the semantic element linked to this.
	 */
	public Object getSemanticElement(Object wrapper) {
		if( wrapper instanceof IAdaptable){
			return ((IAdaptable)wrapper).getAdapter(EObject.class);
		}
		
		//In the next version of modisco LinkItem will become a IAdaptable
		if( wrapper instanceof LinkItem){
			return ((LinkItem)wrapper).getReference();
		}
		if( wrapper instanceof Diagram){
			return wrapper;
		}
		return null;
	}

}
