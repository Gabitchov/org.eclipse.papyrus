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
package org.eclipse.papyrus.uml.profile.externalresource.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Main tests suite for this plugin
 */
@RunWith(Suite.class)
@SuiteClasses({
	org.eclipse.papyrus.uml.profile.externalresource.tests.resourceperprofile.ResourcePerProfileTests.class,
	org.eclipse.papyrus.uml.profile.externalresource.tests.oneresourceforallprofiles.OneResourceForAllProfilesTests.class,
	org.eclipse.papyrus.uml.profile.externalresource.tests.standardstrategy.StandardStrategyTests.class,
})
public class AllTests {
}
