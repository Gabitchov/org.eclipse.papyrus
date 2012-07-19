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
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.uml2diff.UMLStereotypeUpdateAttribute;
import org.eclipse.emf.compare.uml2diff.UMLStereotypeUpdateReference;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DefaultExtensionTransactionalMerger;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class UMLStereotypeUpdateReference_1_RightToLeft extends AbstractUMLStandaloneCompareTest {

	private static final String MODEL_PATH = "stereotypeUpdateReference_1/";

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
		DiffElement firstDiffElement = diffElements.get(0);
		DiffElement secondDiffElement = diffElements.get(1);
		Assert.assertTrue(firstDiffElement instanceof DiffGroup);
		Assert.assertTrue(firstDiffElement.getSubDiffElements().size() == 1);
		firstDiffElement = firstDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(NLS.bind("The first DiffElement is not a {0}", UpdateReference.class), firstDiffElement instanceof UpdateReference);

		Assert.assertTrue(secondDiffElement instanceof DiffGroup);
		Assert.assertTrue(secondDiffElement.getSubDiffElements().size() == 1);
		secondDiffElement = secondDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(secondDiffElement instanceof DiffGroup);
		Assert.assertTrue(secondDiffElement.getSubDiffElements().size() == 1);
		secondDiffElement = secondDiffElement.getSubDiffElements().get(0);
		Assert.assertTrue(NLS.bind("The second DiffElement is not a {0}", UMLStereotypeUpdateAttribute.class), secondDiffElement instanceof UMLStereotypeUpdateReference);
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
		super.testModificationOnDiFile(false);
	}

	@Test
	public void testModificationOnUMLFile() {
		super.testModificationOnUMLFile(true);
		final InstanceSpecification unit;
		final InstanceSpecification dimension;

		final String unitStereotypeName = "SysML::Blocks::Unit";
		final String dimentsionStereotypeName = "SysML::Blocks::Dimension";
		final String unitName = "myUnit";
		final String dimensionName = "myDimension";
		final Stereotype unitSte;
		final Stereotype dimSte;
		final Model model = (Model)leftElement;
		unit = (InstanceSpecification)model.getOwnedMember(unitName);
		dimension = (InstanceSpecification)model.getOwnedMember(dimensionName);

		Assert.assertNotNull(unit);
		Assert.assertNotNull(dimension);
		unitSte = unit.getAppliedStereotype(unitStereotypeName);
		dimSte = dimension.getAppliedStereotype(dimentsionStereotypeName);
		Assert.assertNotNull(unitSte);
		Assert.assertNotNull(dimSte);

		//the test itself
		Object value = unit.getValue(unitSte, "dimension");
		Assert.assertTrue("The stererotype property has not been correctly merged", value == dimension.getStereotypeApplication(dimSte));

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
			if(!(current instanceof UMLStereotypeUpdateReference)) {
				differencesToRemove.add(current);
			}
		}
		differences.removeAll(differencesToRemove);
		return differences;
	}

	@Override
	protected Class<?> getWantedMergerFor(DiffElement diffElement) {
		if(diffElement instanceof UMLStereotypeUpdateReference) {
			return DefaultExtensionTransactionalMerger.class;
		}
		return null;
	}
}
