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
package org.eclipse.papyrus.uml.compare.diff.tests.uml.profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.uml2diff.UMLStereotypeApplicationRemoval;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.compare.diff.internal.merger.UMLStereotypeApplicationRemovalMerger;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.AbstractNestedCompareTest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractNestedStereotypeApplicationRemovalTest_1 extends AbstractNestedCompareTest {

	private static final String MODEL_PATH = "stereotypeApplicationRemoval_1/"; //$NON-NLS-1$

	private static final String FOLDER_PATH = "/resources/uml_nested/";

	public static void init(final boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractNestedCompareTest.init(FOLDER_PATH, MODEL_PATH, leftToRight);
		for(NamedElement current : AbstractNestedCompareTest.root.getOwnedMembers()) {
			if(current.getAppliedStereotypes().size() == 0) {
				AbstractCompareTest.leftElement = current;
			} else {
				AbstractCompareTest.rightElement = current;
			}
		}

		Assert.assertNotNull(AbstractCompareTest.leftElement);
		Assert.assertNotNull(AbstractCompareTest.rightElement);
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}


	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 2, diffElements.size() }), diffElements.size() == 2);
		DiffElement firstDiffElement = diffElements.get(0);
		final DiffElement secondDiffElement = diffElements.get(1);
		Assert.assertTrue(NLS.bind("The first DiffElement is not a {0}", ModelElementChangeRightTarget.class), secondDiffElement instanceof ModelElementChangeRightTarget);

		Assert.assertTrue(firstDiffElement instanceof DiffGroup);
		Assert.assertTrue(firstDiffElement.getSubDiffElements().size() == 1);
		firstDiffElement = firstDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(firstDiffElement instanceof DiffGroup);
		Assert.assertTrue(firstDiffElement.getSubDiffElements().size() == 1);
		firstDiffElement = firstDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(NLS.bind("The second DiffElement is not a {0}", UMLStereotypeApplicationRemoval.class), firstDiffElement instanceof UMLStereotypeApplicationRemoval);

		AbstractDiffExtension ext = (AbstractDiffExtension)firstDiffElement;
		Assert.assertTrue(NLS.bind("The {0} doesn't hide only one DiffElement", ext), ext.getHideElements().size() == 1);
		Assert.assertTrue(NLS.bind("The {0} doesn't hide the correct DiffElement", ext), ext.getHideElements().get(0) == secondDiffElement);
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
		final EList<EObject> leftStereotypeApplication = leftElement.getStereotypeApplications();
		final EList<EObject> rightStereotypeApplication = rightElement.getStereotypeApplications();
		if(!leftToRight) {
			Assert.assertTrue("The sterotype application has not been merged", leftStereotypeApplication.size() == 1);
			Assert.assertTrue("The sterotype application has not been merged", rightStereotypeApplication.size() == 1);
		} else {
			Assert.assertTrue("The sterotype application has not been correctly removed", leftStereotypeApplication.size() == 0);
			Assert.assertTrue("The sterotype application has not been correctly removed", rightStereotypeApplication.size() == 0);
		}
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
		if(!leftToRight) {
			final EList<EObject> leftStereotypeApplication = leftElement.getStereotypeApplications();
			final EList<EObject> rightStereotypeApplication = rightElement.getStereotypeApplications();
			final String leftXMI = EMFHelper.getXMIID(leftStereotypeApplication.get(0));
			final String rightXMI = EMFHelper.getXMIID(rightStereotypeApplication.get(0));
			Assert.assertTrue("The XMI_ID has been merge in the same time as the stereotype application", !leftXMI.equals(rightXMI));
		}
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
			if(!(current instanceof UMLStereotypeApplicationRemoval)) {
				differencesToRemove.add(current);
			}
		}
		differences.removeAll(differencesToRemove);
		return differences;
	}

	@Override
	protected java.lang.Class<?> getWantedMergerFor(DiffElement diffElement) {
		if(diffElement instanceof UMLStereotypeApplicationRemoval) {
			return UMLStereotypeApplicationRemovalMerger.class;
		}
		return null;
	}
}