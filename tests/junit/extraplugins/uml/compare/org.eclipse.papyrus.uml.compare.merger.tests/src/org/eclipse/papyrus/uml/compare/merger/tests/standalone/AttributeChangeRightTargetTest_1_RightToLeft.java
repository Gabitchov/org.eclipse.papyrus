package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class AttributeChangeRightTargetTest_1_RightToLeft extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "attributeChangeRightTarget_1/";

	@BeforeClass
	public static void init() throws CoreException, IOException{
		AbstractStandaloneCompareTest.init(MODEL_PATH);
	}
	

	@Test
	@Override
	public void testMergeCommandExecutatibility() throws InterruptedException {
		mergeTest(false);
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	
	public void testLastDiffElements(DiffElement diffElement) {
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", AttributeChangeRightTarget.class), diffElement instanceof AttributeChangeRightTarget);
	}
}
