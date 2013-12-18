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
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IConfigurationModelCreation;


/**
 * @author RS211865
 */
public class InvariantStereotypeConfigurationModelCreation implements IConfigurationModelCreation<InvariantStereotypeConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	public InvariantStereotypeConfiguration createConfigurationModel() {
		return InvariantStereotypeConfigurationFactory.eINSTANCE.createInvariantStereotypeConfiguration();
	}
}
