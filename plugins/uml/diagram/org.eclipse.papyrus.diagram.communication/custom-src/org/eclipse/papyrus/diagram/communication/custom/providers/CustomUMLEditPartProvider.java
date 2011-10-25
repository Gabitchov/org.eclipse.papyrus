/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Adapted code from the class diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.providers;

import org.eclipse.papyrus.diagram.communication.custom.factory.CustomUMLeditPartFactory;

/**
 * Custom EditPartProvider, to use our own UMLEditPartFactory
 */
public class CustomUMLEditPartProvider extends org.eclipse.papyrus.diagram.communication.providers.UMLEditPartProvider {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CustomUMLEditPartProvider() {
		setFactory(new CustomUMLeditPartFactory());
		setAllowCaching(true);
	}
}
