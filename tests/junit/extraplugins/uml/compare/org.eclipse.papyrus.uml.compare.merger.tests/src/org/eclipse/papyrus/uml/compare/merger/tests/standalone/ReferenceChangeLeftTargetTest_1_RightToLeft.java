package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ReferenceChangeLeftTargetTest_1_RightToLeft extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "referenceChangeLeftTarget_1/";
	
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
	
	@Override
	public void testLastDiffElements(DiffElement diffElement) {
		//There are 2 differences, because it is cross-reference
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", ReferenceChangeLeftTarget.class), diffElement instanceof ReferenceChangeLeftTarget);
	}

}
