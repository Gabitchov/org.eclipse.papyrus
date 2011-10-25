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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.IElementWithSemantic;

/**
 * This class is used to obtain the semantic element for element of the model explorer 
 */
public class SemanticFromModelExplorer implements IElementWithSemantic {

	/**
	 * {@inheritDoc}
	 */
	public Object getSemanticElement(Object wrapper) {
		if( wrapper instanceof IAdaptable){
			Object obj= ((IAdaptable)wrapper).getAdapter(EObject.class);
			if(obj==null){
				obj= ((IAdaptable)wrapper).getAdapter(EReference.class);
			}
			if(obj!=null){
				return obj;
			}
		}
		
		if( wrapper instanceof Diagram){
			return wrapper;
		}
		return null;
	}

}
