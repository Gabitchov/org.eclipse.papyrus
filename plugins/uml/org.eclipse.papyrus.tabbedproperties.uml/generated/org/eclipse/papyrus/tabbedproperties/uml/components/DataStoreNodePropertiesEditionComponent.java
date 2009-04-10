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
import org.eclipse.uml2.uml.DataStoreNode;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DataStoreNodePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param dataStoreNode
	 *            the EObject to edit
	 */
	public DataStoreNodePropertiesEditionComponent(EObject dataStoreNode, String mode) {
		super(mode);
		if (dataStoreNode instanceof DataStoreNode) {
			addSubComponent(new DataStoreNodeBasePropertiesEditionComponent(dataStoreNode, mode));
			addSubComponent(new ElementPropertiesEditionComponent(dataStoreNode, mode));
		}
	}
}

