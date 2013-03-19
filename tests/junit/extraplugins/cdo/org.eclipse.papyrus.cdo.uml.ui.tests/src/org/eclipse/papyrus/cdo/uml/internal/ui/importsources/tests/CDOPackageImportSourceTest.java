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
package org.eclipse.papyrus.cdo.uml.internal.ui.importsources.tests;

import static java.util.Collections.singleton;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.papyrus.cdo.ui.tests.AbstractPapyrusCDOUITest;
import org.eclipse.papyrus.cdo.uml.internal.ui.importsources.CDOPackageImportSource;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is the CDOPackageImportSourceTest type. Enjoy.
 */
public class CDOPackageImportSourceTest extends AbstractPapyrusCDOUITest {

	private TestFixture fixture;

	private Model model;

	private SashWindowsMngr diModel;

	@Test
	public void testCanImportInto() {
		assertThat(fixture.canImportInto(singleton(model)), is(true));
		assertThat(fixture.canImportInto(singleton(model.getOwnedTypes().get(0))), is(false));
	}

	@Test
	public void testCreateModelHierarchyLabelProvider() {
		ILabelProvider provider = fixture.getModelHierarchyLabelProvider();

		assertThat(provider, notNullValue());

		DIModel model = getDIModel();

		assertThat(provider.getText(model), containsString("model"));
		assertThat(provider.getImage(model), notNullValue());
	}

	@Test
	public void testCreateModelHierarchyContentProvider() {
		IStaticContentProvider provider = fixture.getModelHierarchyContentProvider();

		assertThat(provider, instanceOf(ITreeContentProvider.class));

		DIModel model = getDIModel();
		CDOResourceFolder folder = model.getResource().getFolder();

		ITreeContentProvider treeContent = (ITreeContentProvider)provider;

		Object[] children = treeContent.getChildren(folder);
		assertThat(Arrays.asList(children), hasItem((Object)model));
		assertThat(treeContent.getParent(model), sameInstance((Object)model.getResource().getFolder()));
		assertThat(treeContent.hasChildren(model.getResource().getFolder()), is(true));
	}

	@Test
	public void testGetPackages() throws Exception {
		DIModel diModel = getDIModel();

		List<Package> packages = fixture.getPackages(diModel.getResource().getResourceSet(), diModel);

		// get the copy of our model in the master view
		Package modelInMasterView = getMasterViewObject(model);
		assertThat(packages, hasItem(modelInMasterView));
	}

	@Test
	public void testValidateSelection() {
		DIModel diModel = getDIModel();

		try {
			fixture.validateSelection(diModel);
		} catch (CoreException e) {
			e.printStackTrace();
			fail("Should not have thrown validation exception: " + e.getLocalizedMessage());
		}

		try {
			fixture.validateSelection(diModel.getResource().getFolder());
			fail("Should have thrown validation exception.");
		} catch (CoreException e) {
			// test passes
		}
	}

	@Test
	public void testGetCDOResource() {
		DIModel diModel = getDIModel();

		assertThat(fixture.getCDOResource(diModel), sameInstance(diModel.getResource()));
	}

	//
	// Test framework
	//

	@Before
	public void createTestFixture() throws Exception {
		openEditor();
		model = (Model)getUMLModel();

		fixture = new TestFixture();
		fixture.initialize(singleton(model));

		ModelSet modelSet = (ModelSet)model.eResource().getResourceSet();
		diModel = (SashWindowsMngr)EcoreUtil.getObjectByType(((AbstractBaseModel)modelSet.getModel(SashModel.MODEL_ID)).getResource().getContents(), DiPackage.Literals.SASH_WINDOWS_MNGR);
	}

	@After
	public void disposeTestFixture() {
		fixture.dispose();
	}

	protected DIModel getDIModel() {
		// get the resource in the read-only view that corresponds to our DI model
		CDOResource resource = getMasterViewObject((CDOResource)diModel.eResource());

		return DIModel.getInstance(resource, true);
	}

	static class TestFixture extends CDOPackageImportSource {

		TestFixture() {
			super();
		}

		@Override
		protected CDOResource getCDOResource(Object model) {
			return super.getCDOResource(model);
		}

		@Override
		protected void validateSelection(Object model) throws CoreException {
			super.validateSelection(model);
		}
	}
}
