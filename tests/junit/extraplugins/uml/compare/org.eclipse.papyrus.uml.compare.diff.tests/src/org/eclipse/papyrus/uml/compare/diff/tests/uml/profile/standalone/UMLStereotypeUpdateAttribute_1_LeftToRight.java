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
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.uml2diff.UMLStereotypeUpdateAttribute;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DefaultExtensionTransactionalMerger;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class UMLStereotypeUpdateAttribute_1_LeftToRight extends AbstractUMLStandaloneCompareTest {

	private static final String MODEL_PATH = "stereotypeUpdateAttribute_1/";

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
		DiffElement firstDiffElement = diffElements.get(0);
		DiffElement secondDiffElement = diffElements.get(1);
		Assert.assertTrue(firstDiffElement instanceof DiffGroup);
		Assert.assertTrue(firstDiffElement.getSubDiffElements().size() == 1);
		firstDiffElement = firstDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(NLS.bind("The first DiffElement is not a {0}", UpdateAttribute.class), firstDiffElement instanceof UpdateAttribute);

		Assert.assertTrue(secondDiffElement instanceof DiffGroup);
		Assert.assertTrue(secondDiffElement.getSubDiffElements().size() == 1);
		secondDiffElement = secondDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(secondDiffElement instanceof DiffGroup);
		Assert.assertTrue(secondDiffElement.getSubDiffElements().size() == 1);
		secondDiffElement = secondDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(NLS.bind("The second DiffElement is not a {0}", UMLStereotypeUpdateAttribute.class), secondDiffElement instanceof UMLStereotypeUpdateAttribute);
		Assert.assertTrue(firstDiffElement.getIsHiddenBy().size() == 1);
		Assert.assertTrue(firstDiffElement.getIsHiddenBy().get(0) == secondDiffElement);
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
		final Class myClass;

		final String blockStereotypeName = "SysML::Blocks::Block";
		final Stereotype blockSte;
		final Model model = (Model)rightElement;
		myClass = (Class)model.getOwnedMember("Class1");
		Assert.assertNotNull(myClass);
		blockSte = myClass.getAppliedStereotype(blockStereotypeName);
		Assert.assertNotNull(blockSte);

		//the test itself
		boolean value = (Boolean)myClass.getValue(blockSte, "isEncapsulated");
		Assert.assertTrue("The stererotype property has not been correctly merged", value == false);
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
		//nothing to do
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
			if(!(current instanceof UMLStereotypeUpdateAttribute)) {
				differencesToRemove.add(current);
			}
		}
		differences.removeAll(differencesToRemove);
		return differences;
	}

	@Override
	protected java.lang.Class<?> getWantedMergerFor(DiffElement diffElement) {
		if(diffElement instanceof UMLStereotypeUpdateAttribute) {
			return DefaultExtensionTransactionalMerger.class;
		}
		return null;
	}
}
