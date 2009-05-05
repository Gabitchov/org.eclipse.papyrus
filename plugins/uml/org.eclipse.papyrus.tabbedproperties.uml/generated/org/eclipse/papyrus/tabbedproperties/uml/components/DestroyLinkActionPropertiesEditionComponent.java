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
import org.eclipse.uml2.uml.DestroyLinkAction;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DestroyLinkActionPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param destroyLinkAction
	 *            the EObject to edit
	 */
	public DestroyLinkActionPropertiesEditionComponent(EObject destroyLinkAction, String editing_mode) {
		super(editing_mode);
		if (destroyLinkAction instanceof DestroyLinkAction) {
			addSubComponent(new DestroyLinkActionBasePropertiesEditionComponent(destroyLinkAction, editing_mode));
			addSubComponent(new ElementPropertiesEditionComponent(destroyLinkAction, editing_mode));
		}
	}
}
