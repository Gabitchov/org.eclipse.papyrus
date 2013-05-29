/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/

package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.papyrus.sysml.diagram.requirement.factory.CustomUMLeditPartFactory;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLEditPartProvider;


public class CUMLEditPartProvider extends UMLEditPartProvider {

	public CUMLEditPartProvider() {
		setFactory(new CustomUMLeditPartFactory());
		setAllowCaching(true);
	}
}
