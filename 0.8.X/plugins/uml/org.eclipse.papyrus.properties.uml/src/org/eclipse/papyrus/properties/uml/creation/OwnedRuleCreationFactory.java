/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.creation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.properties.creation.EcorePropertyEditorFactory;

/**
 * A Factory for creating objects in references that are subsets of {@link Namespace#getOwnedRules()}.
 * 
 * The elements are actually contained in the ownedRule containment reference,
 * and referenced from the subset feature.
 * 
 * @author Camille Letavernier
 * 
 */
public class OwnedRuleCreationFactory extends EcorePropertyEditorFactory {

	//The base implementation is sufficient, as objects added to subsets of ownedRule are
	//already added to the right ownedRule by the UML framework.
	public OwnedRuleCreationFactory(EClass type) {
		super(type);
	}
}
