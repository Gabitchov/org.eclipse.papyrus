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
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.emf.readonly.tests.PapyrusModelSetFixture;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.papyrus.junit.utils.rules.ProjectFixture;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


/**
 * Test suite for the {@link ReadOnlyManager} class.
 */
@JavaResource("Bug323802.uml")
public class ReadOnlyManagerTest extends AbstractPapyrusTest {

	@Rule
	public final PapyrusModelSetFixture domain = new PapyrusModelSetFixture();

	private final ProjectFixture project = domain.getProject();

	private ReadOnlyManager fixture;

	public ReadOnlyManagerTest() {
		super();
	}

	@Test
	public void testIsReadOnlyEObject() {
		project.setReadOnly(domain.getModelResource());
		assertThat(fixture.isReadOnly(ReadOnlyAxis.anyAxis(), domain.getModel()).or(false), is(true));
	}

	@Test
	public void testCanMakeWritableEObject() {
		project.setReadOnly(domain.getModelResource());
		assertThat(fixture.canMakeWritable(ReadOnlyAxis.anyAxis(), domain.getModel()).or(false), is(true));
	}

	@Test
	public void testAnyReadOnlyURIs() {
		URI uri = domain.getModelResourceURI();
		project.setReadOnly(domain.getModelResource());
		assertThat(fixture.anyReadOnly(ReadOnlyAxis.anyAxis(), new URI[]{ uri }).or(false), is(true));
	}

	@Test
	public void testCanMakeWritableURIs() {
		URI uri = domain.getModelResourceURI();
		project.setReadOnly(domain.getModelResource());
		assertThat(fixture.canMakeWritable(ReadOnlyAxis.anyAxis(), new URI[]{ uri }).or(false), is(true));
	}

	@Test
	public void testSashModelReadOnlyIfPermissionReadOnly() {
		URI sashModelURI = URI.createPlatformPluginURI("org.eclipse.papyrus.foo/models/bogus.di", true);
		assertThat(fixture.anyReadOnly(ReadOnlyAxis.anyAxis(), new URI[]{ sashModelURI }).or(false), is(true));
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() throws Exception {
		fixture = new ReadOnlyManager(domain.getEditingDomain());
	}

	@After
	public void destroyFixture() {
		fixture = null;
	}
}
