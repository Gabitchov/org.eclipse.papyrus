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
package org.eclipse.papyrus.infra.emf.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.IElementWithSemantic;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * This class is used to obtain the semantic element for element of the model explorer
 */
//FIXME: Remove the dependency to gmf
public class SemanticFromModelExplorer implements IElementWithSemantic {

	/**
	 * {@inheritDoc}
	 */
	public Object getSemanticElement(Object wrapper) {
		EObject semantic = EMFHelper.getEObject(wrapper);
		if(semantic != null) {
			return semantic;
		}

		if(wrapper instanceof Diagram) {
			return wrapper;
		}

		return null;
	}

}
