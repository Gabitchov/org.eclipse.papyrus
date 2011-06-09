/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.di.tests;

import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngrTest;
import org.eclipse.papyrus.sasheditor.contentprovider.di.internal.DiContentProviderTest;
import org.eclipse.papyrus.sasheditor.contentprovider.di.internal.PageMngrImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for this fragment
 */
@RunWith(Suite.class)
@SuiteClasses({
	// package org.eclipse.papyrus.sasheditor.contentprovider.di
	DiSashModelMngrTest.class,
	// package org.eclipse.papyrus.sasheditor.contentprovider.di.internal
	DiContentProviderTest.class,
	PageMngrImplTest.class
})
public class AllTests {

}
