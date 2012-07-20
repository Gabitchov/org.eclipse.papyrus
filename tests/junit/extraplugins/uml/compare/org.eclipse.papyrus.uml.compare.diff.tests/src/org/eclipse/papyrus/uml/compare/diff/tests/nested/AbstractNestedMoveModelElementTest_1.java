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
package org.eclipse.papyrus.uml.compare.diff.tests.nested;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * FIXME : I didn't find an example for this kind of differences in a nested editor
 * 
 */
public class AbstractNestedMoveModelElementTest_1 extends AbstractNestedCompareTest {


	private static final String MODEL_PATH = "moveModelElement_1/"; //$NON-NLS-1$

	public static void init(final boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractNestedCompareTest.init(MODEL_PATH, leftToRight);
		AbstractCompareTest.leftElement = AbstractNestedCompareTest.root.getOwnedMembers().get(0); //$NON-NLS-1$
		AbstractCompareTest.rightElement = AbstractNestedCompareTest.root.getOwnedMembers().get(1); //$NON-NLS-1$
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
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 1, diffElements.size() }), diffElements.size() == 1);
		final DiffElement diffElement = diffElements.get(0);
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", MoveModelElement.class), diffElement instanceof MoveModelElement);
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
		if(leftToRight) {
			final EList<PackageableElement> leftPackagedElement = ((Package)leftElement).getPackagedElements();
			final EList<PackageableElement> rightPackagedElement = ((Package)rightElement).getPackagedElements();
			Assert.assertEquals(leftPackagedElement.size(), 1);
			Assert.assertEquals(rightPackagedElement.size(), 1);
			final EList<Element> leftOwnedElements = leftPackagedElement.get(0).getOwnedElements();
			final EList<Element> rightOwnedElements = leftPackagedElement.get(0).getOwnedElements();
			//the 2 subpackage contains the classes
			Assert.assertEquals(leftOwnedElements.size(), 1);
			Assert.assertEquals(rightOwnedElements.size(), 1);
		} else {
			final EList<PackageableElement> leftPackagedElement = ((Package)leftElement).getPackagedElements();
			final EList<PackageableElement> rightPackagedElement = ((Package)rightElement).getPackagedElements();
			Assert.assertEquals(leftPackagedElement.size(), 2);
			Assert.assertEquals(rightPackagedElement.size(), 2);
			final EList<Element> leftOwnedElements = leftPackagedElement.get(0).getOwnedElements();
			final EList<Element> rightOwnedElements = leftPackagedElement.get(0).getOwnedElements();
			//the 2 subpackage contains the classes
			Assert.assertEquals(leftOwnedElements.size(), 0);
			Assert.assertEquals(rightOwnedElements.size(), 0);
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

}
