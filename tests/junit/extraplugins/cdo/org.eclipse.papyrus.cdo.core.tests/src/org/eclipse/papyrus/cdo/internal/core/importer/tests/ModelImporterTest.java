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
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.core.importer.IModelImportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelImporter;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.core.tests.TestProject;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.io.CharStreams;

/**
 * This is the ModelImporterTest type. Enjoy.
 */
public class ModelImporterTest extends AbstractPapyrusCDOTest {

	private IModelTransferConfiguration config;

	private IModelImporter fixture;

	@Rule
	public TestProject hasDependencies = new TestProject("has_dependencies");

	@Rule
	public TestProject hasDependents = new TestProject("has_dependents");

	public ModelImporterTest() {
		super();
	}

	@Test
	@Ignore("CDO fails to commit transaction on EMF Facet query on Linux platform")
	public void testOneToOneImport() {
		URI uri1 = hasDependencies.getResourceURI("model.di");
		URI uri2 = hasDependents.getResourceURI("Datatypes.di");

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		IModelImportMapping mapping = IModelImportMapping.Factory.ONE_TO_ONE.create(config);
		mapping.setRepository(getPapyrusRepository());

		long commitTime = System.currentTimeMillis();

		Diagnostic problems = fixture.importModels(mapping);
		assertThat(problems.getSeverity(), is(Diagnostic.OK));
		assertThat(problems.getChildren().size(), is(0));

		CDOView view = getInternalPapyrusRepository().getMasterView();
		view.waitForUpdate(commitTime, 10000L);

		assertResource(view.getResource("has_dependencies/model.di"));
		assertResource(view.getResource("has_dependencies/model.uml"));
		assertResource(view.getResource("has_dependencies/model.notation"));

		assertResource(view.getResource("has_dependents/Datatypes.di"));
		assertResource(view.getResource("has_dependents/Datatypes.uml"));
		assertResource(view.getResource("has_dependents/Datatypes.notation"));
	}

	@Test
	@Ignore("CDO fails to commit transaction on EMF Facet query on Linux platform")
	public void testManyToOneImport() {
		URI uri1 = hasDependencies.getResourceURI("model.di");
		URI uri2 = hasDependents.getResourceURI("Datatypes.di");

		config.addModelToTransfer(uri1);
		config.addModelToTransfer(uri2);

		IModelImportMapping mapping = IModelImportMapping.Factory.MANY_TO_ONE.create(config);
		mapping.setRepository(getPapyrusRepository());
		mapping.mapTo(Iterables.get(config.getModelsToTransfer(), 0), new Path("my_import/combined.di"));

		long commitTime = System.currentTimeMillis();

		Diagnostic problems = fixture.importModels(mapping);
		assertThat(problems.getSeverity(), is(Diagnostic.OK));
		assertThat(problems.getChildren().size(), is(0));

		CDOView view = getInternalPapyrusRepository().getMasterView();
		view.waitForUpdate(commitTime, 10000L);

		assertResource(view.getResource("my_import/combined.di"), "di", 1);
		assertResource(view.getResource("my_import/combined.uml"), "uml", 2);
		assertResource(view.getResource("my_import/combined.notation"), "notation", 2);

		SashWindowsMngr mngr = (SashWindowsMngr)EcoreUtil.getObjectByType(view.getResource("my_import/combined.di").getContents(), DiPackage.Literals.SASH_WINDOWS_MNGR);
		assertThat(mngr.getSashModel().getWindows().size(), is(2));
		assertThat(mngr.getPageList().getAvailablePage().size(), is(3));
	}

	/**
	 * Tests that, following an import, any workspace resources that reference
	 * resources that have now been imported but that were not, themselves,
	 * imported, now reference the imported resources.
	 */
	@Test
	public void testWorkspaceResourcesURIsUpdated() throws Exception {

		config.addModelToTransfer(hasDependents.getResourceURI("Datatypes.di"));

		IModelImportMapping mapping = IModelImportMapping.Factory.ONE_TO_ONE.create(config);
		mapping.setRepository(getPapyrusRepository());

		fixture.importModels(mapping);

		IFile notImported = hasDependencies.getFile("model.uml");
		Reader reader = new InputStreamReader(notImported.getContents(), notImported.getCharset());
		String text = CharStreams.toString(reader);
		reader.close();

		assertThat(text, not(containsString("href=\"../has_dependents/Datatypes.uml")));
		assertThat(text, containsString("href=\"cdo://MEM/has_dependents/Datatypes.uml"));
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

		fixture = IModelImporter.Factory.DEFAULT.create();
	}

	@After
	public void disposeTestFixture() {
		fixture = null;

		config.dispose();
		config = null;
	}

	void assertResource(Resource resource) {
		assertThat(resource, notNullValue());
		assertThat(resource.getContents().size(), not(0));
	}

	void assertResource(Resource resource, final String metamodel, int count) {
		assertResource(resource);

		assertThat(Iterables.size(Iterables.filter(resource.getContents(), new Predicate<EObject>() {

			public boolean apply(EObject input) {
				boolean result = false;

				if(input != null) {
					EPackage epackage = input.eClass().getEPackage();
					result = epackage.getName().equalsIgnoreCase(metamodel);
				}

				return result;
			}
		})), is(count));
	}
}
