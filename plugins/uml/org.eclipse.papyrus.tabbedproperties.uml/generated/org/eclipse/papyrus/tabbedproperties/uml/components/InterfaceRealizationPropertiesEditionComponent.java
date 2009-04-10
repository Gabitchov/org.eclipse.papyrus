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
import org.eclipse.uml2.uml.InterfaceRealization;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InterfaceRealizationPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param interfaceRealization
	 *            the EObject to edit
	 */
	public InterfaceRealizationPropertiesEditionComponent(EObject interfaceRealization, String mode) {
		super(mode);
		if (interfaceRealization instanceof InterfaceRealization) {
			addSubComponent(new InterfaceRealizationBasePropertiesEditionComponent(interfaceRealization, mode));
			addSubComponent(new ElementPropertiesEditionComponent(interfaceRealization, mode));
		}
	}
}

