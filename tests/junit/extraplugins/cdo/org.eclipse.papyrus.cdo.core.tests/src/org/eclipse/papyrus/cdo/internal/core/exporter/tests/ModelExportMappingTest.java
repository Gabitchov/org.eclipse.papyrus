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
package org.eclipse.papyrus.cdo.internal.core.exporter.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.cdo.core.exporter.IModelExportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.core.tests.TestProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * This is the ModelExportMappingTest type. Enjoy.
 */
public class ModelExportMappingTest extends AbstractModelExportTest {

	private IModelTransferConfiguration config;

	private IModelExportMapping fixture;

	@Rule
	public TestProject hasDependencies = new TestProject("has_dependencies");

	@Rule
	public TestProject hasDependents = new TestProject("has_dependents");

	public ModelExportMappingTest() {
		super();
	}

	@Test
	public void testValidation_ok() throws Exception {
		URI uri1 = getTestResourceURI(DEPENDENT_MODEL_DI);
		URI uri2 = getTestResourceURI(DEPENDENCY_MODEL_DI);

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		fixture.mapTo(getNode(uri1), new Path("/has_dependencies/exported.di"));
		fixture.mapTo(getNode(uri2), new Path("/has_dependents/exported.di"));

		Diagnostic problems = fixture.validate();

		assertThat(problems.getSeverity(), is(Diagnostic.OK));
		assertThat(problems.getChildren().size(), is(0));
	}

	@Test
	public void testValidation_resourceExists() throws Exception {
		URI uri1 = getTestResourceURI(DEPENDENT_MODEL_DI);
		URI uri2 = getTestResourceURI(DEPENDENCY_MODEL_DI);

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		fixture.mapTo(getNode(uri1), new Path("/has_dependencies/model.di"));
		fixture.mapTo(getNode(uri2), new Path("/has_dependents/exported.di"));

		Diagnostic problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		Diagnostic child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.ERROR));
		assertThat(child.getMessage(), containsString("esource already exists"));
		assertThat(child.getData().get(0), sameInstance((Object)getNode(uri1)));
	}

	@Test
	public void testValidation_nonUniqueMappings() throws Exception {
		URI uri1 = getTestResourceURI(DEPENDENT_MODEL_DI);
		URI uri2 = getTestResourceURI(DEPENDENCY_MODEL_DI);

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		fixture.mapTo(getNode(uri1), new Path("/has_dependencies/exported.di"));
		fixture.mapTo(getNode(uri2), new Path("/has_dependencies/exported.di"));

		Diagnostic problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		Diagnostic child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.ERROR));
		assertThat(child.getMessage(), containsString("Multiple models map"));
		assertThat(child.getData().get(0), either(sameInstance((Object)getNode(uri1))).or(sameInstance((Object)getNode(uri2))));
	}

	@Test
	public void testValidation_mappingAbsent() {
		URI uri1 = getTestResourceURI(DEPENDENT_MODEL_DI);
		URI uri2 = getTestResourceURI(DEPENDENCY_MODEL_DI);

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		fixture.mapTo(getNode(uri1), new Path("/has_dependencies/exported.di"));
		// don't map uri2

		Diagnostic problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		Diagnostic child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.ERROR));
		assertThat(child.getMessage(), containsString("No mapping"));
		assertThat(child.getData().get(0), sameInstance((Object)getNode(uri2)));
	}

	//
	// Test framework
	//

	@Before
	public void createTestFixture() throws Exception {
		ResourceSet rset = getInternalPapyrusRepository().getMasterView().getResourceSet();
		createModels();

		config = IModelTransferConfiguration.Factory.EXPORT.create(new IModelTransferOperation.Context() {

			public Diagnostic run(IModelTransferOperation operation) {
				operation.run(new NullProgressMonitor());
				return Diagnostic.OK_INSTANCE;
			}
		}, rset);

		fixture = IModelExportMapping.Factory.DEFAULT.create(config);
		fixture.setRepository(getPapyrusRepository());
	}

	@After
	public void disposeTestFixture() {
		fixture = null;

		config.dispose();
		config = null;
	}

	IModelTransferNode getNode(URI uri) {
		return getNode(config, uri);
	}
}
