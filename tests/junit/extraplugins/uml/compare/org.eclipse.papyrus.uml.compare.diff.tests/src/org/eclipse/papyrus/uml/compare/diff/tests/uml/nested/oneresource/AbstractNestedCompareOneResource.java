/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.tests.uml.nested.oneresource;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.AbstractNestedCompareTest;
import org.eclipse.uml2.uml.Package;

/**
 * 
 * This class is used for tests which test the comparison between an element of the model
 * and an element in memory
 * 
 */
public abstract class AbstractNestedCompareOneResource extends AbstractNestedCompareTest {

	/** the root of the model used for the test */
	protected static Package root;

	private static final String FOLDER_PATH = "/resources/nested_one_resource/";

	public static final void init_(final String modelPath, boolean leftToRight) throws CoreException, IOException, ServiceException, ModelMultiException {
		AbstractNestedCompareTest.init(FOLDER_PATH, modelPath, leftToRight);
	}

}
