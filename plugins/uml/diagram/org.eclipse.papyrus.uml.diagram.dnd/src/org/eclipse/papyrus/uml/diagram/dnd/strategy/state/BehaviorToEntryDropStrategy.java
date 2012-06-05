/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.dnd.strategy.state;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Concrete implementation to edit a State's entry feature
 * 
 * @see {@link AbstractBehaviorToStateDropStrategy}
 * 
 * @author Camille Letavernier
 */
public class BehaviorToEntryDropStrategy extends AbstractBehaviorToStateDropStrategy {

	@Override
	protected EStructuralFeature getFeatureToEdit() {
		return UMLPackage.eINSTANCE.getState_Entry();
	}

}
