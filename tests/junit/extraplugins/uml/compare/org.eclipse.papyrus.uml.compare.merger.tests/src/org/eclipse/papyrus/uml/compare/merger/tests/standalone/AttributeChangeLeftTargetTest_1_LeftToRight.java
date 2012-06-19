package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class AttributeChangeLeftTargetTest_1_LeftToRight extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "attributeChangeLeftTarget_1/";

	@BeforeClass
	public static void init() throws CoreException, IOException{
		AbstractStandaloneCompareTest.init(MODEL_PATH);
	}
	
	

	@Test
	@Override
	public void testMergeCommandExecutatibility() throws InterruptedException {
		mergeTest(true);
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{1,diffElements.size()}),diffElements.size()==1);
		final DiffElement diffElement = diffElements.get(0);
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", AttributeChangeLeftTarget.class), diffElement instanceof AttributeChangeLeftTarget);
	}


	
}
