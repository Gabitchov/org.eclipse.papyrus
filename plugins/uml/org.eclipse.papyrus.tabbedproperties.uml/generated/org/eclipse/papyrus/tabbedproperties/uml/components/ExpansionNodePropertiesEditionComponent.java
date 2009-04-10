/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.uml2.uml.ExpansionNode;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ExpansionNodePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param expansionNode
	 *            the EObject to edit
	 */
	public ExpansionNodePropertiesEditionComponent(EObject expansionNode, String mode) {
		super(mode);
		if (expansionNode instanceof ExpansionNode) {
			addSubComponent(new ExpansionNodeBasePropertiesEditionComponent(expansionNode, mode));
			addSubComponent(new ElementPropertiesEditionComponent(expansionNode, mode));
		}
	}
}

