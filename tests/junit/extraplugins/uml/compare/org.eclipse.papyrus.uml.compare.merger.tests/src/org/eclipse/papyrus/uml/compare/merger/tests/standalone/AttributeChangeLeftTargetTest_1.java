package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.Test;


public class AttributeChangeLeftTargetTest_1 extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "attributeChangeLeftTarget_1/";

	public AttributeChangeLeftTargetTest_1() {
		super(MODEL_PATH);
	}

	@Test
	@Override
	public void leftToRightMergeCommand() throws InterruptedException {
		super.leftToRightMergeCommand();
	}

	@Test
	@Override
	public void rightToLeftMergeCommand() throws InterruptedException {
		super.rightToLeftMergeCommand();
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	public void testLastDiffElement(DiffElement diffElement) {
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", AttributeChangeLeftTarget.class), diffElement instanceof AttributeChangeLeftTarget);
	}
}
