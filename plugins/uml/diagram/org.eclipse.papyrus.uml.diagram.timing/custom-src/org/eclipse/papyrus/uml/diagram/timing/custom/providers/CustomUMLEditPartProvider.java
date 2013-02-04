/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.providers;

import org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts.CustomUMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLEditPartProvider;

public class CustomUMLEditPartProvider extends UMLEditPartProvider {

	public CustomUMLEditPartProvider() {
		setFactory(new CustomUMLEditPartFactory());
		setAllowCaching(true);
	}
}
