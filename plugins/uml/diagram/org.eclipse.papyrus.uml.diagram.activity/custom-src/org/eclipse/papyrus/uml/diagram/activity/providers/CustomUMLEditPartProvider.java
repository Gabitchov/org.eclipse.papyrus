/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy Bug 366026 - [ActivityDiagram] Refactoring in order to try respect Generation Gap Pattern 
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.providers;

import org.eclipse.papyrus.uml.diagram.activity.edit.part.CustomUMLEditPartFactory;

/**
 * This class was introduce to rout the EditPartFactory to our own EditPartFactory {@link CustomUMLEditPartFactory}
 */
public class CustomUMLEditPartProvider extends UMLEditPartProvider {

	public CustomUMLEditPartProvider() {
		super();
		setFactory(new CustomUMLEditPartFactory());
		setAllowCaching(true);
	}
}
