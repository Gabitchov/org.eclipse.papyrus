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
package org.eclipse.papyrus.uml.compare.diff.tests.standalone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;
import org.eclipse.papyrus.uml.compare.diff.tests.TestMergerUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class MoveModelElementTest_2_RightToLeft extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "moveModelElement_2/";

	@BeforeClass
	public static void init() throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractStandaloneCompareTest.init(MODEL_PATH, false);
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	@Override
	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue("The DiffElement is not a DiffGroup", diffElements.size() == 5);
		for(DiffElement current : diffElements) {
			Assert.assertTrue(current instanceof DiffGroup);
			DiffGroup group = (DiffGroup)current;
			Assert.assertTrue("The DiffGroup should contains only 1 DiffElement", group.getSubDiffElements().size() == 1);
			DiffElement element = group.getSubDiffElements().get(0);
			Assert.assertTrue(element instanceof MoveModelElement);
		}
	}

	@Test
	@Override
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
		super.testModificationOnNotationFile(false);//currently false, because this modification doesn't use the service edit, should be set to true later
	}


	@Test
	public void testModificationOnUMLFile() {
		super.testModificationOnUMLFile(true);
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
	public void testXMIID() {
		//nothing to do here!
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

	@Ignore("not yet implemented")
	@Test
	public void testMergeOrder() {
		Assert.fail("not yet implemented");
	}

	@Test
	public void testOneDiffCommandExecution() throws IOException, InterruptedException {
		testUndo();
		final DiffModel diff = getDiffModel(leftElement, rightElement);
		final List<DiffElement> diffsToMerge = getDiffElementToMerge(diff);
		int nb = diffsToMerge.size();
		for(final DiffElement diffElement : diffsToMerge) {
			Assert.assertFalse(diffElement instanceof DiffGroup);
			testDiffMerger(diffElement);
			final Command cmd = TransactionalMergeService.getMergeCommand(domain, diffElement, leftToRight);
			Assert.assertNotNull(NLS.bind("I can't find the merge command for {0}", diffElement), cmd);
			Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", diffElement), cmd.canExecute());
			//we execute the command and hope that all it is OK
			domain.getCommandStack().execute(cmd);
		}
		saveFiles();
		testModificationOnDiFile();
		testModificationOnNotationFile();
		testModificationOnUMLFile();
		testResult();
		testXMIID();

		//we test the Undo
		for(int i = 0; i < nb; i++) {
			domain.getCommandStack().undo();
		}
		saveFiles();
		final DiffModel diff2 = getDiffModel(leftElement, rightElement);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff2.getOwnedElements());
		TestMergerUtils.compareDiffList(initialDifferences, differences);


		//we test the Undo
		for(int i = 0; i < nb; i++) {
			domain.getCommandStack().redo();
		}

		saveFiles();
		testResult();
	}
}
