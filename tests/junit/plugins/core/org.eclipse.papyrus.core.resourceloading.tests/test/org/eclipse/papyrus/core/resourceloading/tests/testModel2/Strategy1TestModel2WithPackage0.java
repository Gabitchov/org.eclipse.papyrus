/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.tests.testModel2;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

/**
 * Test strategy 1 = Load the additional resources (profile and pathmap). Controlled resources are not loaded
 * The model opened is Package0 (controlled resource)
 * 
 * @author eperico
 * 
 */
public class Strategy1TestModel2WithPackage0 extends AbstractResourceLoadingTestModel2 {

	@Override
	public int getStrategy() {
		// Load the additional resources (profile and pathmap). Controlled resources are not loaded
		return 1;
	}

	@Override
	public IFile getResourceToLoad(IProject project) {
		return project.getFile(INITIAL_PATH + "Package0.di");
	}

}
