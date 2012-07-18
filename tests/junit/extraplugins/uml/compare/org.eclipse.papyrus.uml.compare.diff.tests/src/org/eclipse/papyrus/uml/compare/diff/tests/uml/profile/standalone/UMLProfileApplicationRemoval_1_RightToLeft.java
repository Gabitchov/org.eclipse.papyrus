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
 *  Adapted code from EMF-Compare
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.uml2diff.UMLProfileApplicationRemoval;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.ProfileApplication;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class UMLProfileApplicationRemoval_1_RightToLeft extends AbstractUMLStandaloneCompareTest {

	private static final String MODEL_PATH = "profileApplicationRemoval_1/";

	private static final String FOLDER_PATH = "/resources/uml_standalone/";

	@BeforeClass
	public static void init() throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractUMLStandaloneCompareTest.init(FOLDER_PATH, MODEL_PATH, false);
	}


	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 2, diffElements.size() }), diffElements.size() == 2);
		final DiffElement firstDiffElement = diffElements.get(0);
		final DiffElement secondDiffElement = diffElements.get(1);
		Assert.assertTrue(NLS.bind("The first DiffElement is not a {0}", ModelElementChangeRightTarget.class), firstDiffElement instanceof ModelElementChangeRightTarget);
		Assert.assertTrue(NLS.bind("The second DiffElement is not a {0}", UMLProfileApplicationRemoval.class), secondDiffElement instanceof UMLProfileApplicationRemoval);
		AbstractDiffExtension ext = (AbstractDiffExtension)secondDiffElement;
		Assert.assertTrue(NLS.bind("The {0} doesn't hide only one DiffElement", ext), ext.getHideElements().size() == 1);
		Assert.assertTrue(NLS.bind("The {0} doesn't hide the correct DiffElement", ext), ext.getHideElements().get(0) == firstDiffElement);
	}

	@Test
	public void mergeTestAllExecutability() throws InterruptedException {
		super.mergeTestAllExecutability();
	}

	@Override
	@Test
	public void testCommandExecution() throws InterruptedException, IOException {
		super.testCommandExecution();
	}

	@Test
	public void testModificationOnDiFile() {
		super.testModificationOnDiFile(false);
	}


	@Test
	public void testModificationOnNotationFile() {
		super.testModificationOnNotationFile(false);
	}


	@Test
	public void testModificationOnUMLFile() {
		super.testModificationOnUMLFile(true);
		final Model model = (Model)leftElement;
		Assert.assertTrue("The applied profile has not been correctly merged", model.getAppliedProfile("SysML::Blocks") != null);
	}


	@Override
	@Test
	public void saveTest() throws IOException {
		super.saveTest();
	}

	@Override
	@Test
	public void testResult() throws InterruptedException {
		super.testResult();
	}


	@Override
	@Test
	public void testXMIID() {
		final Model leftModel = (Model)leftElement;
		final Model rightModel = (Model)rightElement;
		final ProfileApplication leftApplication = leftModel.getProfileApplications().get(0);
		final ProfileApplication rightApplication = rightModel.getProfileApplications().get(0);
		Assert.assertNotNull(leftApplication);
		Assert.assertNotNull(rightApplication);
		final EAnnotation leftEAnnotation = leftApplication.getEAnnotation("http://www.eclipse.org/uml2/2.0.0/UML");
		final EAnnotation rightEAnnotation = rightApplication.getEAnnotation("http://www.eclipse.org/uml2/2.0.0/UML");

		Assert.assertNotNull(leftEAnnotation);
		Assert.assertNotNull(rightEAnnotation);


		//the test itself
		Assert.assertEquals("The ID of the ProfileApplication has not been correctly merged", EMFHelper.getXMIID(rightApplication), EMFHelper.getXMIID(leftApplication));
		Assert.assertEquals("The ID of the ProfileApplication has not been correctly merged", EMFHelper.getXMIID(rightEAnnotation), EMFHelper.getXMIID(leftEAnnotation));
	}

	@Override
	@Test
	public void testUndo() throws IOException, InterruptedException {
		super.testUndo();
	}

	@Override
	@Test
	public void testRedo() throws IOException, InterruptedException {
		super.testRedo();
	}
}
