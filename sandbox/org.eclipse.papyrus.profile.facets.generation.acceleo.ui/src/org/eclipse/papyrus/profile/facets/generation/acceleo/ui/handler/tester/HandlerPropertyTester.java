/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.facets.generation.acceleo.ui.handler.tester;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.papyrus.profile.facets.generation.acceleo.ui.handler.GenerateFacetsHandler;

/**
 * 
 * property tester for actions in the popup menu
 *
 */
public class HandlerPropertyTester extends PropertyTester{

	/**property to test for the Facets generation*/
	public static final String PROFILE_TO_FACETS_CONFIGURATION_FILE = "isProfileToFacetsConfigurationFile"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 *
	 *  {@inheritDoc}
	 */
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		if(PROFILE_TO_FACETS_CONFIGURATION_FILE.equals(property)){
			if(expectedValue instanceof Boolean){
				AbstractHandler handler = new GenerateFacetsHandler();
				return handler.isEnabled()==((Boolean)expectedValue).booleanValue();
			}
		}
		return false;
	}
}
