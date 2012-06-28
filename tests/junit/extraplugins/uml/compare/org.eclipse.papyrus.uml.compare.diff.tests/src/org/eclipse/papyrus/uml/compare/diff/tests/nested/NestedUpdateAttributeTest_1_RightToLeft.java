package org.eclipse.papyrus.uml.compare.diff.tests.nested;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class NestedUpdateAttributeTest_1_RightToLeft extends AbstractNestedCompareTest {

	private static final String MODEL_PATH = "updateAttribute_1/";

	@BeforeClass
	public static void init() throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractNestedCompareTest.init(MODEL_PATH, false);
		AbstractCompareTest.leftElement = (Class)root.getOwnedMember("Class1");
		AbstractCompareTest.rightElement = (Class)root.getOwnedMember("Class2");
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

	@Test
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
	public void testModificationOnDiFile() {
		super.testModificationOnDiFile(false);
	}

	@Override
	@Test
	public void testModificationOnNotationFile() {
		super.testModificationOnNotationFile(false);
	}

	@Override
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
		final String leftName = ((NamedElement)leftElement).getName();
		final String rightName = ((NamedElement)rightElement).getName();
		Assert.assertEquals("The name of the class has not been correctly merged", rightName, leftName);
		Assert.assertEquals("The left name has not changed", "Class2", leftName);
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

}
