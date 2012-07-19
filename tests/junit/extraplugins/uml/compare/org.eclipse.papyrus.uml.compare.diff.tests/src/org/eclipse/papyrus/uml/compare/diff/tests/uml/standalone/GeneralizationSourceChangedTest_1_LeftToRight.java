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
package org.eclipse.papyrus.uml.compare.diff.tests.uml.standalone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipe.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationSourceChangedExtension;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.compare.diff.internal.merger.GeneralizationSourceMerger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class GeneralizationSourceChangedTest_1_LeftToRight extends AbstractUMLStandaloneCompareTest {

	private static final String MODEL_PATH = "generalizationSourceChanged/";

	@BeforeClass
	public static void init() throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractUMLStandaloneCompareTest.init(MODEL_PATH, true);
	}

	@Test
	@Override
	public void mergeTestAllExecutability() throws InterruptedException {
		super.mergeTestAllExecutability();
	}


	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	@Override
	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 2, diffElements.size() }), diffElements.size() == 2);
		final DiffElement firstDiffElement = diffElements.get(0);
		final DiffElement secondDiffElement = diffElements.get(1);
		Assert.assertTrue(NLS.bind("The first DiffElement is not a {0}", MoveModelElement.class), firstDiffElement instanceof MoveModelElement);
		Assert.assertTrue(NLS.bind("The second DiffElement is not a {0}", GeneralizationSourceChangedExtension.class), secondDiffElement instanceof GeneralizationSourceChangedExtension);
		AbstractDiffExtension ext = (AbstractDiffExtension)secondDiffElement;
		Assert.assertTrue(NLS.bind("The {0} doesn't hide only one DiffElement", ext), ext.getHideElements().size() == 1);
		Assert.assertTrue(NLS.bind("The {0} doesn't hide the correct DiffElement", ext), ext.getHideElements().get(0) == firstDiffElement);
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

	@Test
	public void testOneDiffCommandExecution() throws IOException, InterruptedException {
		super.testOneDiffCommandExecution();
	}

	@Override
	protected List<DiffElement> getDiffElementToMerge(DiffModel diff) {
		final List<DiffElement> differences = super.getDiffElementToMerge(diff);
		final List<DiffElement> differencesToRemove = new ArrayList<DiffElement>();
		for(final DiffElement current : differences) {
			if(!(current instanceof GeneralizationSourceChangedExtension)) {
				differencesToRemove.add(current);
			}
		}
		differences.removeAll(differencesToRemove);
		return differences;
	}

	@Override
	protected java.lang.Class<?> getWantedMergerFor(DiffElement diffElement) {
		if(diffElement instanceof GeneralizationSourceChangedExtension) {
			return GeneralizationSourceMerger.class;
		}
		return null;
	}

}
