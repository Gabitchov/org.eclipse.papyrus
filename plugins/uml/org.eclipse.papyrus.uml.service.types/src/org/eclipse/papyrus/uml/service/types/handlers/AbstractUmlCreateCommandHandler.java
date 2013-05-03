/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.handlers;

import org.eclipse.papyrus.uml.service.types.filter.UmlElementCommandFilter;


/**
 * Abstract handler for every creation command for UML elements
 * used in the ModelExplorer contextual ("Create new child") menu
 * 
 */
public abstract class AbstractUmlCreateCommandHandler extends AbstractCreateCommandHandler {

	@Override
	protected void initFilter() {
		filter = new UmlElementCommandFilter();
	}

}
