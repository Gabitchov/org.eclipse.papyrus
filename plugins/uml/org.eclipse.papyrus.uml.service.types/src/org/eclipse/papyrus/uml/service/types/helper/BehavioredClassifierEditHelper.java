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
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * 
 * Edit helper class for {@link BehavioredClassifier}
 * 
 * Expected behavior:
 * - Add new nested behavior as "ownedBehavior"
 * 
 * </pre>
 */
public class BehavioredClassifierEditHelper extends ElementEditHelper {

	{
		getDefaultContainmentFeatures().put(UMLPackage.eINSTANCE.getBehavior(), UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior());
	}
}
