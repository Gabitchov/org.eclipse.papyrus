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
import static org.junit.Assert.fail;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.junit.utils.rules.ProjectFixture;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


/**
 * Test suite for the {@link ReadOnlyManager} class.
 */
public class ReadOnlyManagerTest {

	@Rule
	public final ProjectFixture project = new ProjectFixture();

	private ReadOnlyManager fixture;

	private TransactionalEditingDomain domain;

	private Model model;

	public ReadOnlyManagerTest() {
		super();
	}

	@Test
	public void testIsReadOnlyEObject() {
		setReadOnly(project.getFile(model.eResource().getURI()));
		assertThat(fixture.isReadOnly(ReadOnlyAxis.anyAxis(), model).or(false), is(true));
	}

	@Test
	public void testCanMakeWritableEObject() {
		setReadOnly(project.getFile(model.eResource().getURI()));
		assertThat(fixture.canMakeWritable(ReadOnlyAxis.anyAxis(), model).or(false), is(true));
	}

	@Test
	public void testAnyReadOnlyURIs() {
		URI uri = model.eResource().getURI();
		setReadOnly(project.getFile(uri));
		assertThat(fixture.anyReadOnly(ReadOnlyAxis.anyAxis(), new URI[]{ uri }).or(false), is(true));
	}

	@Test
	public void testCanMakeWritableURIs() {
		URI uri = model.eResource().getURI();
		setReadOnly(project.getFile(uri));
		assertThat(fixture.canMakeWritable(ReadOnlyAxis.anyAxis(), new URI[]{ uri }).or(false), is(true));
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() throws Exception {
		domain = (PapyrusROTransactionalEditingDomain)new PapyrusROTransactionalEditingDomainProvider().createTransactionalEditingDomain(new ResourceSetImpl());
		fixture = new ReadOnlyManager(domain);

		Resource res = domain.getResourceSet().createResource(project.getURI("model.uml"));
		InputStream input = ReadOnlyManagerTest.class.getResourceAsStream("Bug323802.uml");
		try {
			res.load(input, null);
		} finally {
			input.close();
		}
		res.save(null); // Make sure it exists
		model = (Model)res.getContents().get(0);
	}

	@After
	public void destroyFixture() {
		ResourceSet rset = domain.getResourceSet();

		model = null;

		domain.dispose();
		domain = null;
		fixture = null;

		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
	}

	void setReadOnly(IFile file) {
		ResourceAttributes attr = file.getResourceAttributes();
		attr.setReadOnly(true);

		try {
			file.setResourceAttributes(attr);
		} catch (CoreException e) {
			e.getLocalizedMessage();
			fail("Failed to make workspace file read-only: " + e.getLocalizedMessage());
		}
	}
}
