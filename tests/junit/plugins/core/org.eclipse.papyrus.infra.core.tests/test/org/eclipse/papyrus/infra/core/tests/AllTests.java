/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - add test for AdapterUtils
 *  Christian W. Damus (CEA) - bug 402525
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.tests;

import org.eclipse.papyrus.infra.core.contentoutline.NestedEditorDelegatedOutlinePageTest;
import org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProviderTest;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResourceTest;
import org.eclipse.papyrus.infra.core.resource.ModelSetTest;
import org.eclipse.papyrus.infra.core.resource.NestingTransactionalCommandStackTest;
import org.eclipse.papyrus.infra.core.services.ComposedServiceTest;
import org.eclipse.papyrus.infra.core.services.ServicesRegistryTest;
import org.eclipse.papyrus.infra.core.utils.AdapterUtilsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({
// {oep.resource}
ModelSetTest.class, AbstractModelWithSharedResourceTest.class, NestingTransactionalCommandStackTest.class,
// {oep}.core.services
ComposedServiceTest.class, ServicesRegistryTest.class,
// {oep}.core.lifecycleevents
/* SaveAndDirtyServiceTest.class, */LifeCycleEventsProviderTest.class, 
NestedEditorDelegatedOutlinePageTest.class,
//{oep}.core.utils
AdapterUtilsTest.class
})
/**
 * Suite Class for all tests in the plugin
 */
public class AllTests {

}
