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
package org.eclipse.papyrus.infra.emf.readonly;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.eclipse.papyrus.infra.emf.readonly.tests.PapyrusROEditingDomainFixture;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.papyrus.junit.utils.rules.ProjectFixture;
import org.eclipse.uml2.uml.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Iterators;


/**
 * This is the ReadOnlyTesterTest type. Enjoy.
 */
@JavaResource("Bug323802.uml")
public class ReadOnlyTesterTest {

	@Rule
	public final PapyrusROEditingDomainFixture domain = new PapyrusROEditingDomainFixture();

	private final ProjectFixture project = domain.getProject();

	private ReadOnlyTester fixture;

	@Test
	public void testAsBoolean() {
		assertThat(fixture.asBoolean(true), is(true));
		assertThat(fixture.asBoolean(false), is(false));
		assertThat(fixture.asBoolean("hello"), is(true));
		assertThat(fixture.asBoolean(null), is(true));
	}

	@Test
	public void testIsReadOnly() {
		assertThat(fixture.testIsReadOnly(Iterators.singletonIterator(domain.getModel()), false), is(true));

		Type string = domain.getModel().getImportedPackages().get(0).getOwnedType("String");
		assertThat(fixture.testIsReadOnly(Iterators.singletonIterator(string), true), is(true));

		project.setReadOnly(domain.getModelResource());
		assertThat(fixture.testIsReadOnly(Iterators.singletonIterator(domain.getModel()), true), is(true));
	}

	@Test
	public void testCanMakeWritable() {
		// If it's already writable, well, then it's trivially easy to make it writable
		assertThat(fixture.canMakeWritable(Iterators.singletonIterator(domain.getModel()), true), is(true));

		Type string = domain.getModel().getImportedPackages().get(0).getOwnedType("String");
		assertThat(fixture.canMakeWritable(Iterators.singletonIterator(string), true), is(false));

		project.setReadOnly(domain.getModelResource());
		assertThat(fixture.canMakeWritable(Iterators.singletonIterator(domain.getModel()), true), is(true));
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() throws Exception {
		fixture = new ReadOnlyTester();
	}

	@After
	public void destroyFixture() {
		fixture = null;
	}

}
