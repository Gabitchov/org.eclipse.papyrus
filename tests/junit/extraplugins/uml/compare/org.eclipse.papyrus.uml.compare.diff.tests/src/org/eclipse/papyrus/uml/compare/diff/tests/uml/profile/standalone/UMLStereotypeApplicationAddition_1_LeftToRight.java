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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.uml2diff.UMLStereotypeApplicationAddition;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.compare.diff.internal.merger.UMLStereotypeApplicationAdditionMerger;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class UMLStereotypeApplicationAddition_1_LeftToRight extends AbstractUMLStandaloneCompareTest {

	private static final String MODEL_PATH = "stereotypeApplicationAddition_1/";

	private static final String FOLDER_PATH = "/resources/uml_standalone/";

	@BeforeClass
	public static void init() throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractUMLStandaloneCompareTest.init(FOLDER_PATH, MODEL_PATH, true);
	}


	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 2, diffElements.size() }), diffElements.size() == 2);
		final DiffElement firstDiffElement = diffElements.get(0);
		DiffElement secondDiffElement = diffElements.get(1);
		Assert.assertTrue(NLS.bind("The first DiffElement is not a {0}", ModelElementChangeLeftTarget.class), firstDiffElement instanceof ModelElementChangeLeftTarget);

		Assert.assertTrue(secondDiffElement instanceof DiffGroup);
		Assert.assertTrue(secondDiffElement.getSubDiffElements().size() == 1);
		secondDiffElement = secondDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(secondDiffElement instanceof DiffGroup);
		Assert.assertTrue(secondDiffElement.getSubDiffElements().size() == 1);
		secondDiffElement = secondDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(NLS.bind("The second DiffElement is not a {0}", UMLStereotypeApplicationAddition.class), secondDiffElement instanceof UMLStereotypeApplicationAddition);

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
		final Model model = (Model)rightElement;
		Class myClass = (Class)model.getOwnedMember("Class1");
		Stereotype ste = myClass.getAppliedStereotype("SysML::Blocks::Block");
		Assert.assertNotNull("The stereotype application has not been correctly merged", ste);
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
		final Class leftClass = (Class)leftModel.getOwnedMember("Class1");
		final Class rightClass = (Class)rightModel.getOwnedMember("Class1");
		final EObject leftStereotypeApplication = leftClass.getStereotypeApplications().get(0);
		final EObject rightStereotypeApplication = rightClass.getStereotypeApplications().get(0);

		Assert.assertNotNull(leftStereotypeApplication);
		Assert.assertNotNull(rightStereotypeApplication);

		//the test itself
		Assert.assertEquals("The ID of the ProfileApplication has not been correctly merged", EMFHelper.getXMIID(leftStereotypeApplication), EMFHelper.getXMIID(rightStereotypeApplication));
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

	@Test
	public void testOneDiffCommandExecution() throws IOException, InterruptedException {
		super.testOneDiffCommandExecution();
	}

	@Override
	protected List<DiffElement> getDiffElementToMerge(DiffModel diff) {
		final List<DiffElement> differences = super.getDiffElementToMerge(diff);
		final List<DiffElement> differencesToRemove = new ArrayList<DiffElement>();
		for(final DiffElement current : differences) {
			if(!(current instanceof UMLStereotypeApplicationAddition)) {
				differencesToRemove.add(current);
			}
		}
		differences.removeAll(differencesToRemove);
		return differences;
	}

	@Override
	protected java.lang.Class<?> getWantedMergerFor(DiffElement diffElement) {
		if(diffElement instanceof UMLStereotypeApplicationAddition) {
			return UMLStereotypeApplicationAdditionMerger.class;
		}
		return null;
	}
}
