/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.services.nested;

import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.UMLStandaloneDiffEngine;

/**
 * 
 * A specific DiffEngine for the Nested UML Compare Editor
 * see bug 377154
 */
//TODO verify the upper class for UML models
public class UMLDiffEngine extends UMLStandaloneDiffEngine {

	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.engine.GenericDiffEngine#checkContainmentUpdate(org.eclipse.emf.compare.diff.metamodel.DiffGroup,
	 *      org.eclipse.emf.compare.match.metamodel.Match2Elements)
	 * 
	 * @param current
	 * @param matchElement
	 */
	protected void checkContainmentUpdate(DiffGroup current, Match2Elements matchElement) {
		//when we compare 2 elements owned by the same file, we don't verify their container
		//see bug 377154 
	}

}
