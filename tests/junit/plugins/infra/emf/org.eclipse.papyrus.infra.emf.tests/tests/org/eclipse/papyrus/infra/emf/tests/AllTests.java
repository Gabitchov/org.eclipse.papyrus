/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.tests;

import org.eclipse.papyrus.infra.emf.advice.ReadOnlyObjectEditAdviceTest;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * The test suite for the {@code org.eclipse.papyrus.infra.emf} plug-in.
 */
@RunWith(Suite.class)
@SuiteClasses({
// oep.infra.emf.advice
ReadOnlyObjectEditAdviceTest.class,
// oep.infra.emf.utils
ServiceUtilsForResourceTest.class })
public class AllTests {

	public AllTests() {
		super();
	}

}
