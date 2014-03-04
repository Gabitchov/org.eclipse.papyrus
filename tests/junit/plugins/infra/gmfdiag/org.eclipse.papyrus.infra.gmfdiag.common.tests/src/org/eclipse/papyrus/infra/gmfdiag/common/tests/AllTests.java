/*
 * Copyright (c) 2014 CEA LIST and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus (CEA) - initial API and implementation
 */
package org.eclipse.papyrus.infra.gmfdiag.common.tests;

import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Master test suite for this test fragment.
 */
@RunWith(Suite.class)
@SuiteClasses({
// {oep.commands}
GMFUnsafeTest.class })
public class AllTests {

}
