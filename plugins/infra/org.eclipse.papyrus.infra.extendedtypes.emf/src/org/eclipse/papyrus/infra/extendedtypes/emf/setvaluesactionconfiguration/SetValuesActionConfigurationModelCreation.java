package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration;
import org.eclipse.papyrus.infra.extendedtypes.IActionConfigurationModelCreation;


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
/**
 * {@link IActionConfigurationModelCreation} for {@link SetValuesActionConfiguration}
 */
public class SetValuesActionConfigurationModelCreation implements IActionConfigurationModelCreation<SetValuesActionConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	public SetValuesActionConfiguration createConfigurationModel() {
		return SetValuesActionConfigurationFactory.eINSTANCE.createSetValuesActionConfiguration();
	}
}
