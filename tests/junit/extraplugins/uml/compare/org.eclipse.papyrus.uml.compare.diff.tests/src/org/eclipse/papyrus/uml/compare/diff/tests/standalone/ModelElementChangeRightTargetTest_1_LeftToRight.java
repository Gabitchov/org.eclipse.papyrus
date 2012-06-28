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
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ModelElementChangeRightTargetTest_1_LeftToRight extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "modelElementChangeRightTarget_1/";

	final String CLASS_NAME = "Class1";

	final String PROPERTY_NAME = "Property1";

	@BeforeClass
	public static void init() throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractStandaloneCompareTest.init(MODEL_PATH, true);
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	@Override
	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 1, diffElements.size() }), diffElements.size() == 1);
		final DiffElement diffElement = diffElements.get(0);
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", ModelElementChangeRightTarget.class), diffElement instanceof ModelElementChangeRightTarget);
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

	@Override
	@Test
	public void testResult() throws InterruptedException {
		// TODO Auto-generated method stub
		super.testResult();
	}

	@Test
	public void testModificationOnDiFile() {
		super.testModificationOnDiFile(false);
	}


	@Test
	public void testModificationOnNotationFile() {
		super.testModificationOnNotationFile(true);
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
	public void testXMIID() {
		Class leftClass = (Class)((Package)leftElement).getOwnedMember(CLASS_NAME);
		Class rightClass = (Class)((Package)rightElement).getOwnedMember(CLASS_NAME);
		Property leftProperty = leftClass.getAttribute(PROPERTY_NAME, null);
		Property rightProperty = rightClass.getAttribute(PROPERTY_NAME, null);
		String leftId = EMFHelper.getXMIID(leftProperty);
		String rightId = EMFHelper.getXMIID(rightProperty);
		Assert.assertEquals("The merged element hasn't the same Id as the initial element", leftId, rightId);
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
