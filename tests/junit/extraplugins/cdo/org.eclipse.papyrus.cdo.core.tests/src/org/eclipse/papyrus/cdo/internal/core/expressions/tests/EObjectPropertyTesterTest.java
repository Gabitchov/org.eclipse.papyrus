/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core.expressions.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.internal.core.expressions.EObjectPropertyTester;
import org.junit.Test;


/**
 * This is the EObjectPropertyTesterTest type. Enjoy.
 */
public class EObjectPropertyTesterTest extends AbstractPapyrusCDOTest {

	private final EObjectPropertyTester fixture = new EObjectPropertyTester();

	@Test
	public void testTest_isCDOObject() {
		CDOResource res = createTransaction().createResource(getResourcePath("foo.uml"));

		assertThat(fixture.test(res, "isCDOObject", null, true), is(true));

		assertThat(fixture.test(EcorePackage.Literals.ECLASS, "isCDOObject", null, true), is(false));
	}

}
