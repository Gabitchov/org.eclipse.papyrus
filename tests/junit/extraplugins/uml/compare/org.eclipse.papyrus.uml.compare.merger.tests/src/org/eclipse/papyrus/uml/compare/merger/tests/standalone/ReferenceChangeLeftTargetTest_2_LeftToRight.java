package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.compare.merge.services.TransactionalMergeService;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * This Class tests the Merge of an added reference with a created element -> there are 2 differences!
 * 
 */
public class ReferenceChangeLeftTargetTest_2_LeftToRight extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "referenceChangeLeftTarget_2/";

	private static ReferenceChangeLeftTarget diffToMerge;

	@BeforeClass
	public static void init() throws CoreException, IOException {
		AbstractStandaloneCompareTest.init(MODEL_PATH, true);
	}



	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	@Override
	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 2, diffElements.size() }), diffElements.size() == 2);
		DiffElement diffElement = null;
		DiffGroup group = null;
		for(DiffElement current : diffElements) {
			if(current instanceof DiffGroup) {
				group = (DiffGroup)current;
			} else {
				diffElement = current;
			}
		}

		Assert.assertNotNull(diffElement);
		Assert.assertNotNull(group);
		Assert.assertTrue(NLS.bind("The diffElement is not a {0}", ModelElementChangeLeftTarget.class), diffElement instanceof ModelElementChangeLeftTarget);//a Usecase has been added

		EList<DiffElement> subDiff = group.getSubDiffElements();
		Assert.assertTrue(subDiff.size() == 1);
		DiffElement el = subDiff.get(0);
		Assert.assertTrue(NLS.bind("The diffElement is not a {0}", ReferenceChangeLeftTarget.class), el instanceof ReferenceChangeLeftTarget);//a reference to the usecase has been added
		diffToMerge = (ReferenceChangeLeftTarget)el;
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
	@Test
	public void testModificationOnDiFile() {
		super.testModificationOnDiFile(false);
	}


	@Test
	public void testModificationOnNotationFile() {
		super.testModificationOnNotationFile(false);
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
	public void testResult() throws InterruptedException {
		super.testResult();
	}

	@Override
	@Test
	public void testXMIID() {
		Element leftUsecase = ((Package)leftElement).getOwnedMember("UseCase1");
		Element rightUsecase = ((Package)rightElement).getOwnedMember("UseCase1");
		String leftId = EMFHelper.getXMIID(leftUsecase);
		String rightId = EMFHelper.getXMIID(rightUsecase);
		Assert.assertEquals("The XMI id has not been correctly copied", leftId,  rightId);
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

	/**
	 * Merging the referenceChangeLeftTarget should merged the created element too -> so equivalent to merge All in this specific case!
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	@Test
	public void testMergeReferenceChangeLeftTargetOnly() throws InterruptedException, IOException {
		testUndo();
		//we call this method to initialize #diffToMerge
		testDifferences();
		
		Command cmd = TransactionalMergeService.getMergeCommand(domain, diffToMerge, true);
		Assert.assertTrue(NLS.bind("The command for {0} is not executable", diffToMerge),cmd.canExecute());

		//we execute the command and hope that all it is OK
		domain.getCommandStack().execute(cmd);

		//we save the result
		for(Resource current : set.getResources()) {
			try{
			current.save(Collections.EMPTY_MAP);
			}catch(IOException e){
				Assert.fail(NLS.bind("I can't save : {0}", current.getURI()));
			}
		}
		
		//all should be merged!
		testResult();
	}

}
