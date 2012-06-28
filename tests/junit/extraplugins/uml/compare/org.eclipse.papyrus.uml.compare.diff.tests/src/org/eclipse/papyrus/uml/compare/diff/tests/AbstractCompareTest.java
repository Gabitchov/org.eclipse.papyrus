/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.tests;

import static org.eclipse.papyrus.infra.core.Activator.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.uml.compare.file.editor.utils.ServicesRegistryUtils;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractCompareTest {

	protected static IProject project;

	protected static TransactionalEditingDomain domain;

	protected static ModelSet set;

	/** indicates the direction of the merge */
	protected static boolean leftToRight;

	//	protected static List<DiffElement> initialDifferences;
	/** the left element used for the comparison */
	protected static Element leftElement;

	/** the rigth element used for the comparison */
	protected static Element rightElement;

	/** This field is used to store the initial Differences before to do the merge */
	private static List<DiffElement> initialDifferences;

	protected static ServicesRegistry servicesRegistry;

	protected static List<EObject> roots;

	public static void loadModels(final List<IFile> comparedFiles) throws ServiceException, ModelMultiException {
		roots = new ArrayList<EObject>();
		servicesRegistry = ServicesRegistryUtils.createAndInitServiceRegistryForUMLCompareFile();
		set = servicesRegistry.getService(ModelSet.class);
		domain = set.getTransactionalEditingDomain();
		for(final IFile current : comparedFiles) {
			set.loadModels(current);
			final String filePath = current.getFullPath().toString();
			URI uri = URI.createPlatformResourceURI(filePath, false);
			EObject root = UML2Util.load(set, uri, UMLPackage.Literals.PACKAGE);
			set.getResource(uri, false).setTrackingModification(true);
			Assert.assertNotNull("The root of the model is null", root);
			roots.add(root);
		}
	}


	/**
	 * This test tests the contents of the differences found.
	 * 
	 */
	@Test
	public void testDifferences() throws InterruptedException {
		final DiffModel diff = getDiffModel(leftElement, rightElement);
		// Merges all differences from model1 to model2
		List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		initialDifferences = diff.getOwnedElements();
		Assert.assertTrue("I don't found only 1 difference,differences.", differences.size() == 1);
		DiffElement current = differences.get(0);
		Assert.assertTrue("The first DiffElement is not a DiffGroupElement", current instanceof DiffGroup);

		differences = current.getSubDiffElements();
		while(differences.size() == 1 && differences.get(0) instanceof DiffGroup) {
			differences = differences.get(0).getSubDiffElements();
		}

		testLastDiffElements(differences);
	}

	/** allow to verify that the class ahas the correct parameter using its name */
	@Test
	public void testTestConformance() {
		final String name = getClass().getName();
		if(name.endsWith("LeftToRight")) {
			Assert.assertEquals(true, leftToRight);
		} else if(name.endsWith("RightToLeft")) {
			Assert.assertEquals(false, leftToRight);
		} else {
			Assert.fail();
		}
	}

	protected abstract DiffModel getDiffModel(final EObject leftElement, final EObject rightElement) throws InterruptedException;

	/**
	 * This method allows to test the last DiffElement of the DiffModel
	 * The implementation is different for each case
	 * 
	 * @param diffElement
	 * 
	 * 
	 */
	public abstract void testLastDiffElements(final List<DiffElement> diffElement);

	@Test
	protected void mergeTestAllExecutability() throws InterruptedException {
		final DiffModel diff = getDiffModel(leftElement, rightElement);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		for(final DiffElement current : differences) {
			Command cmd = TransactionalMergeService.getMergeCommand(domain, current, leftToRight);
			Assert.assertNotNull(NLS.bind("I can't find the merge command for {0}", current), cmd);
			Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", current), cmd.canExecute());
		}
	}


	@Test
	public void testCommandExecution() throws InterruptedException, IOException {
		final DiffModel diff = getDiffModel(leftElement, rightElement);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		Assert.assertTrue("We should find only one DiffElement", differences.size() == 1);
		DiffElement diffElement = differences.get(0);
		Command cmd = TransactionalMergeService.getMergeCommand(domain, diffElement, leftToRight);

		Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", cmd), cmd.canExecute());
		//we execute the command and hope that all it is OK
		domain.getCommandStack().execute(cmd);
	}

	@Test
	public abstract void testModificationOnDiFile();

	@Test
	public abstract void testModificationOnNotationFile();

	@Test
	public abstract void testModificationOnUMLFile();


	public void testModificationOnDiFile(final boolean shouldBeModified) {
		for(Resource current : getResourceOfTheProject()) {
			if(current.getURI().fileExtension().equals("di")) {
				Assert.assertEquals("The di file has not the correct state : Modified or Unmodified", shouldBeModified, current.isModified());
			}
		}
	}


	public void testModificationOnNotationFile(final boolean shouldBeModified) {
		for(Resource current : getResourceOfTheProject()) {
			if(current.getURI().fileExtension().equals("notation")) {
				Assert.assertEquals("The notation file has not the correct state : Modified or Unmodified", shouldBeModified, current.isModified());
			}
		}
	}


	public void testModificationOnUMLFile(final boolean shouldBeModified) {
		for(Resource current : getResourceOfTheProject()) {
			if(current.getURI().fileExtension().equals("uml")) {
				Assert.assertEquals("The uml file has not the correct state : Modified or Unmodified", shouldBeModified, current.isModified());
			}
		}
	}

	@Test
	public void saveTest() throws IOException {
		//we save the result
		for(Resource current : getResourceOfTheProject()) {
			current.save(Collections.EMPTY_MAP);
			Assert.assertTrue(NLS.bind("The resource {0} has not been correctly saved!", current), !current.isModified());
		}
	}

	@Test
	public void testResult() throws InterruptedException {
		//we compare the left and the right UML Model, they should be equals
		final DiffModel diff = getDiffModel(leftElement, rightElement);
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());

		Assert.assertTrue("After merging all differences, we still found differences between the models...", differences.size() == 1);

		DiffElement diffElement = differences.get(0);
		Assert.assertTrue(diffElement instanceof DiffGroup);
		DiffGroup group = (DiffGroup)diffElement;

		//the best way to be sure that there is no differences between the elements is the label...  :-(
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(org.eclipse.emf.compare.util.AdapterUtils.getAdapterFactory());
		String label = provider.getText(group);
		Assert.assertTrue(NLS.bind("The message for 0 differences has changed (or there is a bug : the message {0}", label), label.equals("0 change(s) in model"));

	}

	@Test
	public void testXMIID() {
		Assert.fail();
	}

	protected void saveFiles() throws IOException {
		for(Resource current : getResourceOfTheProject()) {
			current.save(Collections.EMPTY_MAP);
			Assert.assertTrue(NLS.bind("The resource {0} has not been correctly saved!", current), !current.isModified());
		}
	}

	@Test
	public void testUndo() throws IOException, InterruptedException {
		domain.getCommandStack().undo();
		saveFiles();
		final DiffModel diff = getDiffModel(leftElement, rightElement);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		TestMergerUtils.compareDiffList(initialDifferences, differences);
	}

	@Test
	public void testRedo() throws IOException, InterruptedException {
		domain.getCommandStack().redo();
		saveFiles();
		testResult();
	}

	@AfterClass
	public static final void closeAll() {
		//useful ?
		final List<Resource> resources = new ArrayList<Resource>(set.getResources());
		for(Resource current : resources) {
			current.setTrackingModification(false);
			set.getResources().remove(current);
			TransactionUtil.disconnectFromEditingDomain(current);
			current.unload();
		}
		resources.clear();
		if(servicesRegistry != null) {
			try {
				servicesRegistry.disposeRegistry();
			} catch (ServiceMultiException e) {
				log.error(e);
			}
		}
		//we close all the editors
		GenericUtils.closeAllEditors();
	}

	/**
	 * EMF Compare add resources to the resourceSet... So we use this function to find our Resource!
	 * 
	 * @param resource
	 * @return
	 */
	protected boolean isAResourceOFTheTestProject(final Resource resource) {
		return resource.getURI().path().startsWith("/" + project.getName() + "/");
	}

	/**
	 * EMF Compare add resources to the resourceSet... So we use this function to find our Resource!
	 * 
	 * @return
	 *         the list of the resource to save
	 */
	protected List<Resource> getResourceOfTheProject() {
		List<Resource> resources = new ArrayList<Resource>();
		for(Resource current : set.getResources()) {
			if(isAResourceOFTheTestProject(current)) {
				resources.add(current);
			}
		}
		return resources;
	}
}
