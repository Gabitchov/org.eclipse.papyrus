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

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.cdo.core.importer.IModelImportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.core.tests.TestProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * This is the OneToOneModelImportMappingTest type. Enjoy.
 */
public class OneToOneModelImportMappingTest extends AbstractPapyrusCDOTest {

	private IModelTransferConfiguration config;

	private IModelImportMapping fixture;

	@Rule
	public TestProject hasDependencies = new TestProject("has_dependencies");

	@Rule
	public TestProject hasDependents = new TestProject("has_dependents");

	public OneToOneModelImportMappingTest() {
		super();
	}

	@Test
	public void testDefaultMappings() {
		URI uri1 = hasDependencies.getResourceURI("model.di");
		URI uri2 = hasDependents.getResourceURI("Datatypes.di");

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		assertThat(fixture.getMapping(getNode(uri1)), is((IPath)new Path("/has_dependencies/model.di")));
		assertThat(fixture.getMapping(getNode(uri2)), is((IPath)new Path("/has_dependents/Datatypes.di")));
	}

	@Test
	public void testValidation_ok() throws Exception {

		URI uri1 = hasDependencies.getResourceURI("model.di");
		URI uri2 = hasDependents.getResourceURI("Datatypes.di");

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		Diagnostic problems = fixture.validate();

		assertThat(problems.getSeverity(), is(Diagnostic.OK));
		assertThat(problems.getChildren().size(), is(0));
	}

	@Test
	public void testValidation_resourceExists() throws Exception {

		CDOTransaction transaction = createTransaction();
		transaction.getOrCreateResource("has_dependencies/model.di");
		transaction.commit();
		transaction.close();

		URI uri = hasDependencies.getResourceURI("model.di");
		config.addModelToTransfer(uri);

		Diagnostic problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		Diagnostic child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.ERROR));
		assertThat(child.getMessage(), containsString("Resource already exists"));
		assertThat(child.getData().get(0), sameInstance((Object)getNode(uri)));
	}

	@Test
	public void testValidation_mappingAbsent() {
		URI uri = hasDependencies.getResourceURI("model.di");
		config.addModelToTransfer(uri);

		fixture.mapTo(getNode(uri), null);

		Diagnostic problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		Diagnostic child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.ERROR));
		assertThat(child.getMessage(), containsString("No mapping"));
		assertThat(child.getData().get(0), sameInstance((Object)getNode(uri)));
	}

	@Test
	public void testValidation_repository() throws Exception {

		getPapyrusRepository().disconnect();

		Diagnostic problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		Diagnostic child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.ERROR));
		assertThat(child.getMessage(), containsString("is not connected"));
		assertThat(child.getData().get(0), sameInstance((Object)getPapyrusRepository()));

		fixture.setRepository(null);

		problems = fixture.validate();

		assertThat(problems.getChildren().size(), is(1));
		child = problems.getChildren().get(0);
		assertThat(child.getSeverity(), is(Diagnostic.ERROR));
		assertThat(child.getMessage(), containsString("No repository"));
	}

	//
	// Test framework
	//

	@Before
	public void createTestFixture() {
		config = IModelTransferConfiguration.Factory.IMPORT.create(new IModelTransferOperation.Context() {

			public Diagnostic run(IModelTransferOperation operation) {
				operation.run(new NullProgressMonitor());
				return Diagnostic.OK_INSTANCE;
			}
		}, null);

		fixture = IModelImportMapping.Factory.ONE_TO_ONE.create(config);
		fixture.setRepository(getPapyrusRepository());
	}

	@After
	public void disposeTestFixture() {
		fixture = null;

		config.dispose();
		config = null;
	}

	IModelTransferNode getNode(URI uri) {
		IModelTransferNode result = null;

		for(IModelTransferNode next : config.getModelsToTransfer()) {
			if(next.getPrimaryResourceURI().equals(uri)) {
				result = next;
				break;
			}
		}

		return result;
	}
}
