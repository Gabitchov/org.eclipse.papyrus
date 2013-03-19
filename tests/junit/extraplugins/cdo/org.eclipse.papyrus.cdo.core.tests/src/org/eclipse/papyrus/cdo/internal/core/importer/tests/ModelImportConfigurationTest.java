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
package org.eclipse.papyrus.cdo.internal.core.importer.tests;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.core.tests.TestProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * This is the ModelImportConfigurationTest type. Enjoy.
 */
public class ModelImportConfigurationTest {

	private IModelTransferConfiguration fixture;

	@Rule
	public TestProject isolated = new TestProject("isolated");

	@Rule
	public TestProject hasDependencies = new TestProject("has_dependencies");

	@Rule
	public TestProject hasDependents = new TestProject("has_dependents");

	public ModelImportConfigurationTest() {
		super();
	}

	@Test
	public void testIsolatedModel() {
		URI uri = isolated.getResourceURI("model.di");

		fixture.addModelToTransfer(uri);

		assertThat(fixture.getModelsToTransfer().size(), is(1));
		IModelTransferNode node = Iterables.getOnlyElement(fixture.getModelsToTransfer());

		assertThat(node.getPrimaryResourceURI(), is(uri));
		assertThat(node.getDependencies().size(), is(0));
		assertThat(node.getDependents().size(), is(0));

		assertThat(node.getResourceURIs().size(), is(3));
		assertThat(node.getResourceURIs(), hasItem(uri));
		assertThat(node.getResourceURIs(), hasItem(uml(uri)));
		assertThat(node.getResourceURIs(), hasItem(notation(uri)));
	}

	@Test
	public void testModelHavingDependencies() {
		URI uri = hasDependencies.getResourceURI("model.di");

		fixture.addModelToTransfer(uri);

		assertThat(fixture.getModelsToTransfer().size(), is(1));
		IModelTransferNode node = Iterables.getOnlyElement(fixture.getModelsToTransfer());

		assertThat(node.getPrimaryResourceURI(), is(uri));

		assertThat(node.getDependencies().size(), is(1));
		IModelTransferNode dep = Iterables.getOnlyElement(node.getDependencies());
		assertThat(dep.getPrimaryResourceURI(), is(hasDependents.getResourceURI("Datatypes.di")));

		assertThat(node.getDependents().size(), is(0));

		assertThat(node.getResourceURIs().size(), is(3));
		assertThat(node.getResourceURIs(), hasItem(uri));
		assertThat(node.getResourceURIs(), hasItem(uml(uri)));
		assertThat(node.getResourceURIs(), hasItem(notation(uri)));
	}

	@Test
	public void testModelHavingDependents() {
		URI uri = hasDependents.getResourceURI("Datatypes.di");

		fixture.addModelToTransfer(uri);

		assertThat(fixture.getModelsToTransfer().size(), is(1));
		IModelTransferNode node = Iterables.getOnlyElement(fixture.getModelsToTransfer());

		assertThat(node.getPrimaryResourceURI(), is(uri));

		assertThat(node.getDependencies().size(), is(0));

		assertThat(node.getDependents().size(), is(1));
		IModelTransferNode dep = Iterables.getOnlyElement(node.getDependents());
		assertThat(dep.getPrimaryResourceURI(), is(hasDependencies.getResourceURI("model.di")));

		assertThat(node.getResourceURIs().size(), is(3));
		assertThat(node.getResourceURIs(), hasItem(uri));
		assertThat(node.getResourceURIs(), hasItem(uml(uri)));
		assertThat(node.getResourceURIs(), hasItem(notation(uri)));
	}

	@Test
	public void testValidationOfDependents() {
		URI uri = hasDependents.getResourceURI("Datatypes.di");

		fixture.addModelToTransfer(uri);

		assertThat(fixture.getModelsToTransfer().size(), is(1));
		IModelTransferNode node = Iterables.getOnlyElement(fixture.getModelsToTransfer());

		Diagnostic problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		Diagnostic child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.WARNING));
		assertThat(child.getData().get(0), sameInstance((Object)node));
		assertThat(child.getData().get(1), is((Object)node.getDependents()));

		fixture.addModelToTransfer(hasDependencies.getResourceURI("model.di"));

		problems = fixture.validate();

		assertThat(problems.getSeverity(), is(Diagnostic.OK));
		assertThat(problems.getChildren().size(), is(0));
	}

	@Test
	public void testValidationOfDependencies() {
		URI uri = hasDependencies.getResourceURI("model.di");

		fixture.addModelToTransfer(uri);

		assertThat(fixture.getModelsToTransfer().size(), is(1));
		IModelTransferNode node = Iterables.getOnlyElement(fixture.getModelsToTransfer());

		Diagnostic problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		Diagnostic child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.INFO));
		assertThat(child.getData().get(0), sameInstance((Object)node));
		assertThat(child.getData().get(1), is((Object)node.getDependencies()));

		fixture.addModelToTransfer(hasDependents.getResourceURI("Datatypes.di"));

		problems = fixture.validate();

		assertThat(problems.getSeverity(), is(Diagnostic.OK));
		assertThat(problems.getChildren().size(), is(0));
	}

	//
	// Test framework
	//

	@Before
	public void createTestFixture() {
		fixture = IModelTransferConfiguration.Factory.IMPORT.create(new IModelTransferOperation.Context() {

			public Diagnostic run(IModelTransferOperation operation) {
				operation.run(new NullProgressMonitor());
				return Diagnostic.OK_INSTANCE;
			}
		}, null);
	}

	@After
	public void disposeTestFixture() {
		fixture.dispose();
		fixture = null;
	}

	URI uml(URI uri) {
		return uri.trimFileExtension().appendFileExtension("uml");
	}

	URI notation(URI uri) {
		return uri.trimFileExtension().appendFileExtension("notation");
	}
}
