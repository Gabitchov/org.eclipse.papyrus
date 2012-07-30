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
package org.eclipse.papyrus.uml.compare.diff.tests.nested.options;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractSimpleCompareTest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;


public class AbstractNestedAttributeChangeLeftTarget extends AbstractNestedMergeOptionsEnablementTests {

	private static final String MODEL_PATH = "attributeChangeLeftTarget_1/"; //$NON-NLS-1$

	public static void init(final boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractNestedMergeOptionsEnablementTests.init_nested(MODEL_PATH, leftToRight);
		AbstractSimpleCompareTest.leftElement = (Class)AbstractNestedMergeOptionsEnablementTests.root.getOwnedMember("OpaqueBehavior1"); //$NON-NLS-1$
		AbstractSimpleCompareTest.rightElement = (Class)((Package)root.getPackagedElement("Package1")).getOwnedMember("OpaqueBehavior1"); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
