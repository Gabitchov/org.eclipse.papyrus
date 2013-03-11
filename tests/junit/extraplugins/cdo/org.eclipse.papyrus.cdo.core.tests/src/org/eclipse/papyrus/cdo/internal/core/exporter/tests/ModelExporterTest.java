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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.cdo.core.exporter.IModelExportMapping;
import org.eclipse.papyrus.cdo.core.exporter.IModelExporter;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.core.tests.TestProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * This is the ModelImporterTest type. Enjoy.
 */
public class ModelExporterTest extends AbstractModelExportTest {

	private IModelTransferConfiguration config;

	private IModelExporter fixture;

	@Rule
	public TestProject hasDependencies = new TestProject("has_dependencies");

	@Rule
	public TestProject hasDependents = new TestProject("has_dependents");

	public ModelExporterTest() {
		super();
	}

	@Test
	public void testExportWithDependencies() {
		URI uri1 = getTestResourceURI(DEPENDENT_MODEL_DI);
		URI uri2 = getTestResourceURI(DEPENDENCY_MODEL_DI);

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		IModelExportMapping mapping = IModelExportMapping.Factory.DEFAULT.create(config);
		mapping.setRepository(getPapyrusRepository());
		mapping.mapTo(getNode(uri1), new Path("/has_dependencies/exported.di"));
		mapping.mapTo(getNode(uri2), new Path("/has_dependents/exported.di"));

		Diagnostic problems = fixture.exportModels(mapping);
		assertThat(problems.getSeverity(), is(Diagnostic.OK));
		assertThat(problems.getChildren().size(), is(0));

		assertResource(new Path("/has_dependencies/exported.di"), "di");
		assertResource(new Path("/has_dependencies/exported.uml"), "uml");
		assertResource(new Path("/has_dependencies/exported.notation"), "notation");

		assertResource(new Path("/has_dependents/exported.di"), "di");
		assertResource(new Path("/has_dependents/exported.uml"), "uml");
		assertResource(new Path("/has_dependents/exported.notation"), "notation");
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

		fixture = IModelExporter.Factory.DEFAULT.create();
	}

	@After
	public void disposeTestFixture() {
		fixture = null;

		config.dispose();
		config = null;
	}

	void assertResource(IPath path, final String metamodel) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		assertThat(file.exists(), is(true));

		File osFile = new File(file.getLocationURI());
		assertThat(osFile.length() > 0L, is(true));

		ResourceSet rset = new ResourceSetImpl();
		try {
			Resource resource = rset.getResource(URI.createPlatformResourceURI(path.toString(), true), true);

			assertThat(Iterables.size(Iterables.filter(resource.getContents(), new Predicate<EObject>() {

				public boolean apply(EObject input) {
					boolean result = false;

					if(input != null) {
						EPackage epackage = input.eClass().getEPackage();
						result = epackage.getName().equalsIgnoreCase(metamodel);
					}

					return result;
				}
			})), is(1));

		} finally {
			cleanUp(rset);
		}
	}

	protected void cleanUp(ResourceSet rset) {
		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
	}

	IModelTransferNode getNode(URI uri) {
		return getNode(config, uri);
	}
}
