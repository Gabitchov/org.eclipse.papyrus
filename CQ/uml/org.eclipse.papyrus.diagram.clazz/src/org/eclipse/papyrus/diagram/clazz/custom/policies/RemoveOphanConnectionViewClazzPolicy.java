/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * this class is used to supress orphan connection into ClassDiagram
 * 
 */
public class RemoveOphanConnectionViewClazzPolicy extends RemoveOrphanConnectionViewPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected String getPrefixofElementTypes() {
		return "org.eclipse.papyrus.diagram.clazz";
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void initMapEdgewithoutElement() {
		edgeWithoutElement.put(((IHintedType) UMLElementTypes.Link_4016).getSemanticHint(), ((IHintedType) UMLElementTypes.Link_4016).getSemanticHint());
	}

}
