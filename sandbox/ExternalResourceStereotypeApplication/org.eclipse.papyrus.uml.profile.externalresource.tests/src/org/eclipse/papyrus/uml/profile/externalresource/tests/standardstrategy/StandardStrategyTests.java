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
package org.eclipse.papyrus.uml.profile.externalresource.tests.standardstrategy;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.profile.externalresource.helper.ExternalResourceProfileUtils;
import org.eclipse.papyrus.uml.profile.externalresource.tests.AbstractChangeStrategyTests;
import org.junit.Test;

/**
 * Test class for load/unload
 */
public class StandardStrategyTests extends AbstractChangeStrategyTests {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTestProjectName() {
		return STANDARD_STRATEGY_FOLDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<String> getModelFileNames() {
		return STANDARD_STRATEGY_FILE_NAMES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected URI getApplyStereotypeOnClassInControlledPackageResourceURI() {
		return  URI.createPlatformResourceURI(getTestProjectName() + "/" + PACKAGE1_MODEL_UML_FILE, true);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected URI getApplyStereotypeOnClassInControlledResourceURI() {
		return  URI.createPlatformResourceURI(getTestProjectName() + "/" + CLASS3_MODEL_UML_FILE, true);
	}
	
	
	@Test
	public void testFindStereotypeApplicationsByDefinition() {
		
		
		// ExternalResourceProfileUtils.findStereotypeApplicationsByDefinition(profileApplication, oldStrategy)
		
		
	}
}
