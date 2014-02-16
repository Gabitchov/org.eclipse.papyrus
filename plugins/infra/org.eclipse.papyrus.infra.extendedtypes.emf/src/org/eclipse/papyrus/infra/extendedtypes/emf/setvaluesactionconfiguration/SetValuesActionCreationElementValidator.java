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
package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.IActionCreationElementValidator;
import org.eclipse.papyrus.infra.extendedtypes.ICreationElementValidator;

/**
 * {@link ICreationElementValidator} for {@link SetValuesActionConfiguration}
 */
public class SetValuesActionCreationElementValidator implements IActionCreationElementValidator<SetValuesActionConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreate(CreateElementRequest request) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(SetValuesActionConfiguration configuration) {
	}
}
