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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.cdo.core.importer.IModelImportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.core.importer.ModelTransferMappingListenerAdapter;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.core.tests.TestProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * This is the ManyToOneModelImportMappingTest type. Enjoy.
 */
public class ManyToOneModelImportMappingTest extends AbstractPapyrusCDOTest {

	private IModelTransferConfiguration config;

	private IModelImportMapping fixture;

	@Rule
	public TestProject hasDependencies = new TestProject("has_dependencies");

	@Rule
	public TestProject hasDependents = new TestProject("has_dependents");

	public ManyToOneModelImportMappingTest() {
		super();
	}

	@Test
	public void testDefaultMappings() {
		URI uri1 = hasDependencies.getResourceURI("model.di");
		URI uri2 = hasDependents.getResourceURI("Datatypes.di");

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		assertThat(fixture.getMapping(getNode(uri1)), is((IPath)new Path("/has_dependencies/model.di")));
		assertThat(fixture.getMapping(getNode(uri2)), is((IPath)new Path("/has_dependencies/model.di")));
	}

	@Test
	public void testMappings() {
		URI uri1 = hasDependencies.getResourceURI("model.di");
		URI uri2 = hasDependents.getResourceURI("Datatypes.di");

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		class Test extends ModelTransferMappingListenerAdapter {

			Set<IModelTransferNode> notified = Sets.newHashSet();

			@Override
			public void modelTransferMappingChanged(IModelTransferNode node) {
				notified.add(node);
			}
		}
		Test test = new Test();
		fixture.addModelTransferMappingListener(test);

		IPath path = new Path("/myfolder/MyModel.di");
		fixture.mapTo(getNode(uri1), path);

		assertThat(test.notified, is((Set<IModelTransferNode>)ImmutableSet.of(getNode(uri1), getNode(uri2))));

		assertThat(fixture.getMapping(getNode(uri1)), is(path));
		assertThat(fixture.getMapping(getNode(uri2)), is(path));
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

		fixture = IModelImportMapping.Factory.MANY_TO_ONE.create(config);
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
