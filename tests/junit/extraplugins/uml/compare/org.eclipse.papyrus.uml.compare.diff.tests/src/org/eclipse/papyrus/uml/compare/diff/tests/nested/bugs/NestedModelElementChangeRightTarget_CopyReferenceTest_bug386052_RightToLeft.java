package org.eclipse.papyrus.uml.compare.diff.tests.nested.bugs;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.AbstractNestedCompareTest;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class NestedModelElementChangeRightTarget_CopyReferenceTest_bug386052_RightToLeft extends AbstractNestedCompareTest {

	private static final String MODEL_PATH = "bug386052/"; //$NON-NLS-1$

	private static final String FOLDER_PATH = "resources/nested_bug/"; //$NON-NLS-1$

	@BeforeClass
	public static void init() throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractNestedCompareTest.init(FOLDER_PATH, MODEL_PATH, false);
		AbstractCompareTest.leftElement = AbstractNestedCompareTest.root.getMember("Class3"); //$NON-NLS-1$
		AbstractCompareTest.rightElement = AbstractNestedCompareTest.root.getMember("Class1"); //$NON-NLS-1$
	}

	@Ignore("no sens for the tested example")
	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 1, diffElements.size() }), diffElements.size() == 1); //$NON-NLS-1$
		final DiffElement diffElement = diffElements.get(0);
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", UpdateAttribute.class), diffElement instanceof UpdateAttribute); //$NON-NLS-1$
	}

	@Ignore("no sens for the tested example")
	@Test
	public void mergeTestAllExecutability() throws InterruptedException {
		super.mergeTestAllExecutability();
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void testCommandExecution() throws InterruptedException, IOException {
		super.testCommandExecution();
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void testModificationOnDiFile() {
		super.testModificationOnDiFile(false);
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void testModificationOnNotationFile() {
		super.testModificationOnNotationFile(false);
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void testModificationOnUMLFile() {
		super.testModificationOnUMLFile(true);
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void saveTest() throws IOException {
		super.saveTest();
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void testResult() throws InterruptedException {
		super.testResult();
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void testXMIID() {
		//nothing to do
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void testUndo() throws IOException, InterruptedException {
		super.testUndo();
	}

	@Ignore("no sens for the tested example")
	@Override
	@Test
	public void testRedo() throws IOException, InterruptedException {
		super.testRedo();
	}

	//we only verify the build of the command and its execution
	@Test
	public void testOneDiffCommandExecution() throws IOException, InterruptedException {
		final DiffModel diff = getDiffModel(leftElement, rightElement);
		final DiffElement diffElement = getDiffElementToMerge(diff).get(0);
		Assert.assertFalse(diffElement instanceof DiffGroup);
		testDiffMerger(diffElement);
		final Command cmd = TransactionalMergeService.getMergeCommand(domain, diffElement, leftToRight);
		Assert.assertNotNull(NLS.bind("I can't find the merge command for {0}", diffElement), cmd); //$NON-NLS-1$
		Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", diffElement), cmd.canExecute()); //$NON-NLS-1$
		//we execute the command and hope that all it is OK
		domain.getCommandStack().execute(cmd);
		saveFiles();
	}


	@Override
	protected List<DiffElement> getDiffElementToMerge(DiffModel diff) {
		final Iterator<EObject> iter = diff.eAllContents();
		List<DiffElement> toMerge = null;
		while(toMerge == null && iter.hasNext()) {
			final EObject el = iter.next();
			if(el instanceof ModelElementChangeRightTarget) {
				final ModelElementChangeRightTarget current = (ModelElementChangeRightTarget)el;
				final EObject currentRight = current.getRightElement();
				final EObject leftParent = current.getLeftParent();
				if(currentRight instanceof RedefinableTemplateSignature && leftParent == AbstractCompareTest.leftElement) {
					toMerge = Collections.singletonList((DiffElement)el);
				}
			}
		}
		return toMerge;
	}


}
