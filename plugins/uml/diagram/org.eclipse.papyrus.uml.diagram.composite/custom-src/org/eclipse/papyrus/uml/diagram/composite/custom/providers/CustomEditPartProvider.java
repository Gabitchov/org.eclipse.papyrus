/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.providers;

import org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts.CustomEditPartFactory;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLEditPartProvider;

/**
 * Replacement EditPart provider.
 */
public class CustomEditPartProvider extends UMLEditPartProvider {

	/**
	 * Constructor.
	 */
	public CustomEditPartProvider() {
		setFactory(new CustomEditPartFactory());
		setAllowCaching(true);
	}
}
