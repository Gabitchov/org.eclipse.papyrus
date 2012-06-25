package org.eclipse.papyrus.uml.compare.merger.tests.nested;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.compare.merger.tests.AbstractCompareTest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class NestedModelElementChangeLeftTargetTest_1_RightToLeft extends AbstractNestedCompareTest {

	private static final String MODEL_PATH = "modelElementChangeLeftTarget_1/";

	@BeforeClass
	public static void init() throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractNestedCompareTest.init(MODEL_PATH, false);
		AbstractCompareTest.leftElement = (Class)AbstractNestedCompareTest.root.getOwnedMember("Class1");
		AbstractCompareTest.rightElement = (Class)((Package)root.getPackagedElement("Package1")).getOwnedMember("Class1");
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 1, diffElements.size() }), diffElements.size() == 1);
		final DiffElement diffElement = diffElements.get(0);
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", ModelElementChangeLeftTarget.class), diffElement instanceof ModelElementChangeLeftTarget);
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
		super.testModificationOnNotationFile(true);
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
		Property leftAttribute = ((Class)AbstractCompareTest.leftElement).getAttribute("Property1", null);
		Assert.assertNull("The right element has not been deleted by the merge action", leftAttribute);
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

}
