package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.Test;


public class MoveModelElementTest_2 extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "moveModelElement_2/";

	public MoveModelElementTest_2() {
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
	
	@Override
	public void testLastDiffElement(DiffElement diffElement) {
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", MoveModelElement.class), diffElement instanceof MoveModelElement);
	}
}
