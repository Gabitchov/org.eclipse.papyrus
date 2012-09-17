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
package org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.uml2diff.UMLStereotypeApplicationAddition;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;
import org.eclipse.papyrus.uml.compare.diff.internal.merger.UMLStereotypeApplicationAdditionMerger;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.AbstractNestedCompareTest;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractNestedStereotypeApplicationAdditionTest_2 extends AbstractNestedCompareTest {

	private static final String MODEL_PATH = "stereotypeApplicationAddition_2/"; //$NON-NLS-1$

	private static final String FOLDER_PATH = "/resources/uml_nested/";

	public static void init(final boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractNestedCompareTest.init(FOLDER_PATH, MODEL_PATH, leftToRight);
		AbstractCompareTest.rightElement = AbstractNestedCompareTest.root.getOwnedMembers().get(0);
		AbstractCompareTest.leftElement = AbstractNestedCompareTest.root.getOwnedMembers().get(1);
		Assert.assertNotNull(AbstractCompareTest.leftElement);
		Assert.assertNotNull(AbstractCompareTest.rightElement);
	}

	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue("We found differences, instead of zero differences", diffElements.size() == 0);
	}

	@Override
	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	@Test
	public void mergeTestAllExecutability() throws InterruptedException {
		final DiffModel diff = getDiffModel(leftElement, rightElement);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		for(final DiffElement current : differences) {
			Command cmd = TransactionalMergeService.getMergeCommand(domain, current, leftToRight);
			Assert.assertNotNull(NLS.bind("I can't find the merge command for {0}", current), cmd);
			Assert.assertFalse(NLS.bind("The builded command to merge {0} is executable", current), cmd.canExecute());
		}
	}

	@Override
	@Test
	public void testCommandExecution() throws InterruptedException, IOException {
		//nothing to do
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
		super.testModificationOnUMLFile(false);
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
		//nothing to do
	}

	@Override
	@Test
	public void testRedo() throws IOException, InterruptedException {
		//nothing to do
	}

	@Test
	public void testOneDiffCommandExecution() throws IOException, InterruptedException {
		//nothing to do
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
