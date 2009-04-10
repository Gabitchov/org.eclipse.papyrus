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
import org.eclipse.uml2.uml.ExceptionHandler;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ExceptionHandlerPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param exceptionHandler
	 *            the EObject to edit
	 */
	public ExceptionHandlerPropertiesEditionComponent(EObject exceptionHandler, String mode) {
		super(mode);
		if (exceptionHandler instanceof ExceptionHandler) {
			addSubComponent(new ExceptionHandlerBasePropertiesEditionComponent(exceptionHandler, mode));
			addSubComponent(new ElementPropertiesEditionComponent(exceptionHandler, mode));
		}
	}
}

