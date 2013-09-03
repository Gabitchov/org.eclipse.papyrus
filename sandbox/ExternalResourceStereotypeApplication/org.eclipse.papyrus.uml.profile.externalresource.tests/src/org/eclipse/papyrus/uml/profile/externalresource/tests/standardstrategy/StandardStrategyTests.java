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

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.profile.externalresource.tests.AbstractChangeStrategyTests;

/**
 * Test class for load/unload
 */
public class StandardStrategyTests extends AbstractChangeStrategyTests {

	
	public static final List<String> FILE_NAMES = Arrays.asList(DI_FILE, UML_FILE, NOTATION_FILE,  
		/* Class3.di */ CLASS3_MODEL_DI_FILE,  CLASS3_MODEL_NOTATION_FILE,  CLASS3_MODEL_UML_FILE, 
		/* Package1_Class1.di */PACKAGE1_MODEL_DI_FILE, PACKAGE1_MODEL_NOTATION_FILE, PACKAGE1_MODEL_UML_FILE); 
	
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
		return FILE_NAMES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected URI getApplyStereotypeOnClassInControlledPackageResourceURI() {
		return getResultFolderURI().appendSegment(PACKAGE1_MODEL_UML_FILE);
	}
	
}
