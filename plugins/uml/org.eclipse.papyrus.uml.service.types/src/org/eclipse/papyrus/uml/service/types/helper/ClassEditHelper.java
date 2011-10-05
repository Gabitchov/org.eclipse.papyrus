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
 * Edit helper class for {@link org.eclipse.uml2.uml.Class}
 * 
 * Expected behavior:
 * - Add new nested behavior as "ownedBehavior"
 * 
 * Also see: 
 * - {@link BehavioredClassifierEditHelper} default containment duplicated here as, due to multiple inheritance
 *   (Class is also an EncapsulatedClassifier), the ElementType framework may recover an incorrect EditHelper.
 * 
 * </pre>
 */
public class ClassEditHelper extends ElementEditHelper {

	{
		getDefaultContainmentFeatures().put(UMLPackage.eINSTANCE.getBehavior(), UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior());
		getDefaultContainmentFeatures().put(UMLPackage.eINSTANCE.getClassifier(), UMLPackage.eINSTANCE.getClass_NestedClassifier());
	}

}
