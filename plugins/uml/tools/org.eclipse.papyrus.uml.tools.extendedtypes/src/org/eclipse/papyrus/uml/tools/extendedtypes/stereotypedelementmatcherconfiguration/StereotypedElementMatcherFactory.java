/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration;

import org.eclipse.papyrus.infra.extendedtypes.IConfigurableElementMatcherFactory;
import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration;


/**
 * Factory to create matcher based on stereotypes applied on the element
 */
public class StereotypedElementMatcherFactory implements IConfigurableElementMatcherFactory<StereotypedElementMatcherConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	public StereotypedElementMatcher createElementMatcher(StereotypedElementMatcherConfiguration configuration) {
		return new StereotypedElementMatcher();
	}
}
