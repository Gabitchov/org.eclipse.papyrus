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
package org.eclipse.papyrus.uml.compare.diff.tests.uml.nested.oneresource;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.AbstractNestedCompareTest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * This class allow to test only the correct construction of the DiffModel
 * 
 */
//TODO try to merge this test with NestedUpdateAttributeResource
public abstract class AbstractNestedUpdateAttributeResourceLeftTest_1 extends AbstractNestedCompareOneResource {

	private static final String MODEL_PATH = "updateAttributeOneResource_1/"; //$NON-NLS-1$

	public static void init_(boolean leftToRight) throws ModelMultiException, CoreException, IOException, ServiceException {
		AbstractNestedCompareOneResource.init_(MODEL_PATH, leftToRight);
		Class myClass = UMLFactory.eINSTANCE.createClass();
		AbstractCompareTest.leftElement = AbstractNestedCompareTest.root.getOwnedMembers().get(0); //$NON-NLS-1$
		AbstractCompareTest.rightElement = myClass;
		Assert.assertNotNull(leftElement.eResource());
		Assert.assertNull(rightElement.eResource());
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 1, diffElements.size() }), diffElements.size() == 1);
		final DiffElement diffElement = diffElements.get(0);
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", UpdateAttribute.class), diffElement instanceof UpdateAttribute);
	}

	@Ignore("not yet implemented")
	@Test
	public void mergeTestAllExecutability() throws InterruptedException {
		super.mergeTestAllExecutability();
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void testCommandExecution() throws InterruptedException, IOException {
		super.testCommandExecution();
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void testModificationOnDiFile() {
		super.testModificationOnDiFile(false);
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void testModificationOnNotationFile() {
		super.testModificationOnNotationFile(false);
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void testModificationOnUMLFile() {
		super.testModificationOnUMLFile(true);
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void saveTest() throws IOException {
		super.saveTest();
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void testResult() throws InterruptedException {
		super.testResult();
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void testXMIID() {
		//nothing to do
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void testUndo() throws IOException, InterruptedException {
		super.testUndo();
	}

	@Ignore("not yet implemented")
	@Override
	@Test
	public void testRedo() throws IOException, InterruptedException {
		super.testRedo();
	}

	@Ignore("not yet implemented")
	@Test
	public void testOneDiffCommandExecution() throws IOException, InterruptedException {
		super.testOneDiffCommandExecution();
	}

}
