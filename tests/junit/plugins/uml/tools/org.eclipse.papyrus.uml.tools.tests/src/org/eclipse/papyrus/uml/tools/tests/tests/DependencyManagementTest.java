/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.tests.tests;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.resource.DependencyManagementHelper;
import org.eclipse.papyrus.junit.utils.ModelUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.papyrus.uml.tools.tests.Activator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * Test case for DependencyManagementHelper
 * 
 * @author Camille Letavernier
 * 
 */
public class DependencyManagementTest extends AbstractEditorTest {

	public final static String SOURCE_PATH = "resources/dependencyManagement/";

	//Switch from a library to a copy
	@Test
	public void testSimpleSwitch() throws Exception {
		//Create the project will 2 libraries and a client
		IProject project = ProjectUtils.createProject("dependencyManagement.simpleSwitch");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "model");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "library");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "copy-of-library");

		//Retrieve the URIs of each model
		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/model.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/model.uml", true);
		final URI sourceLibraryURI = URI.createPlatformResourceURI(project.getName() + "/library.uml", true);
		final URI targetLibraryURI = URI.createPlatformResourceURI(project.getName() + "/copy-of-library.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);

		//The modelset doesn't have any reference to the target library
		Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetLibraryURI, false));

		domain.getCommandStack().execute(new RecordingCommand(domain, "Edit model dependencies") {

			@Override
			protected void doExecute() {
				DependencyManagementHelper.updateDependencies(sourceLibraryURI, targetLibraryURI, modelSet, domain);
			}
		});


		EcoreUtil.resolveAll(modelSet);
		//The modelset now has some references to the target library
		Assert.assertNotNull("The modelset should have references to the target library", modelSet.getResource(targetLibraryURI, false));


		modelSet.save(new NullProgressMonitor());


		//
		// Reload
		//

		ModelSet reloadedModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

		//The reloaded modelset must have some references to the target library
		Resource clientModelResource = reloadedModelSet.getResource(clientModelURI, false);
		Assert.assertNotNull("The modelset should have references to the target library", clientModelResource);

		//The reloaded modelset doesn't have any reference to the source library
		Assert.assertNull("The modelset should not have references to the source library", reloadedModelSet.getResource(sourceLibraryURI, false));

		domain.dispose();
		modelSet.unload();

		ModelUtils.getEditingDomain(reloadedModelSet).dispose();
		reloadedModelSet.unload();

		project.delete(true, null);
	}

	//Switch from a library to an un-existing resource
	@Ignore("Todo")
	@Test
	public void testSwitchToProxy() throws Exception {
		//TODO
	}

	//Switch from a proxy to a library
	@Ignore("Todo")
	@Test
	public void testSwitchFromProxy() throws Exception {
		//TODO
	}

	//Switch from a library to a modified copy of this library
	@Ignore("Todo")
	@Test
	public void testSwitchToDifferentVersion() throws Exception {
		//TODO
	}

	@Override
	protected String getSourcePath() {
		return SOURCE_PATH;
	}

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}
}
