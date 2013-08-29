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
package org.eclipse.papyrus.uml.profile.externalresource.tests.resourceperprofile;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.uml.profile.externalresource.tests.AbstractChangeStrategyTests;

/**
 * Test class for load/unload
 */
public class ResourcePerProfileTests extends AbstractChangeStrategyTests {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTestProjectName() {
		return ONE_RESOURCE_PER_PROFILE_FOLDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<String> getModelFileNames() {
		return Arrays.asList(DI_FILE, NOTATION_FILE, UML_FILE, EXTERNAL_RESOURCES_TEST_PROFILE_EXTENSION_FILE);
	}
	

}
