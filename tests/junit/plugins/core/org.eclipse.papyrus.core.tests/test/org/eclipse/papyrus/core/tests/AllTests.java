/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.core.tests;

import org.eclipse.papyrus.core.lifecycleevents.LifeCycleEventsProviderTest;
import org.eclipse.papyrus.core.services.ComposedServiceTest;
import org.eclipse.papyrus.core.services.ServicesRegistryTest;
import org.eclipse.papyrus.core.wizard.TestCreateModelWizard;
import org.eclipse.papyrus.core.wizard.TestCreateSysMLModelWizard;
import org.eclipse.papyrus.core.wizard.TestInitModelWizard;
import org.eclipse.papyrus.core.wizard.TestNewProjectWizard;
import org.eclipse.papyrus.core.wizard.TestNewSysMLProjectWizard;
import org.eclipse.papyrus.resource.AbstractModelWithSharedResourceTest;
import org.eclipse.papyrus.resource.ModelSetTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({
// {oep.resource}
ModelSetTest.class, AbstractModelWithSharedResourceTest.class,
// {oep}.core.services
ComposedServiceTest.class, ServicesRegistryTest.class,
// {oep}.core.lifecycleevents
/* SaveAndDirtyServiceTest.class, */LifeCycleEventsProviderTest.class, 
//{oep.wizard}
TestCreateModelWizard.class, TestCreateSysMLModelWizard.class, TestInitModelWizard.class, TestNewProjectWizard.class, TestNewSysMLProjectWizard.class

})
/**
 * Suite Class for all tests in the plugin
 */
public class AllTests {

}
