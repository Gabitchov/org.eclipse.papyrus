package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.TransactionalEditingDomainManager;
import org.eclipse.papyrus.infra.emf.compare.common.utils.services.PapyrusFileLoader;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.compare.merge.TransactionalMergeService;
import org.eclipse.papyrus.uml.compare.merge.standalone.StandaloneMergeUtils;
import org.eclipse.papyrus.uml.compare.merger.tests.Activator;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

/**
 * 
 * This abstract provides methods to compare 2 Papyrus uml files named "left.uml" and "right.uml"
 * 
 */
public abstract class AbstractStandaloneCompareTest{

	protected IProject project;

	private final String LEFT = "left";

	private final String RIGHT = "right";

	protected Model leftRoot;

	protected Model rightRoot;

	protected Map<String, Object> options;

	protected TransactionalEditingDomain domain;


	private final String modelPath;


	private static final String FOLDER_PATH = "/resources/standalone/";

	public AbstractStandaloneCompareTest(final String modelPath) {
		this.modelPath = modelPath;
	}

	protected void mergeTest(final boolean leftToRight) throws InterruptedException {
		// Matching model elements
		final MatchModel match = MatchService.doMatch(leftRoot, rightRoot, options);
		// Computing differences
		final DiffModel diff = DiffService.doDiff(match, false);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		for(final DiffElement current : differences) {
			Command cmd = TransactionalMergeService.getMergeCommand(domain, current, true);
			Assert.assertNotNull(NLS.bind("I can't find the merge command for {0}", current), cmd);
			Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", current), cmd.canExecute());
		}
	}

	@Before
	public final void init() throws CoreException, IOException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		project = ProjectUtils.createProject("MyProject"); //$NON-NLS-1$
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), FOLDER_PATH + modelPath, LEFT);
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), FOLDER_PATH + modelPath, RIGHT);
		//		openCompareFileEditor();
		final List<IFile> comparedFiles = new ArrayList<IFile>();

		comparedFiles.add(project.getFile(LEFT + "." + "uml"));
		comparedFiles.add(project.getFile(RIGHT + "." + "uml"));

		//TODO associate the EditingDomain!
		final ResourceSet set = new ResourceSetImpl();
		domain = TransactionalEditingDomainManager.createDefaultTransactionalEditingDomain(set);
		EObject[] roots = PapyrusFileLoader.loadPapyrusFiles(set, comparedFiles);
		leftRoot = (Model)roots[0];
		rightRoot = (Model)roots[1];
		options = StandaloneMergeUtils.getMergeOptions();
	}

	public void leftToRightMergeCommand() throws InterruptedException {
		mergeTest(true);
	}

	public void rightToLeftMergeCommand() throws InterruptedException {
		mergeTest(false);
	}

	/**
	 * This tests should tests the contents of the differences found
	 */
	public void testDifferences() throws InterruptedException {
		// Matching model elements
		final MatchModel match = MatchService.doMatch(leftRoot, rightRoot, options);
		// Computing differences
		final DiffModel diff = DiffService.doDiff(match, false);
		// Merges all differences from model1 to model2
		List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		Assert.assertTrue("I don't found only 1 difference,differences.", differences.size() == 1);
		DiffElement current = differences.get(0);
		Assert.assertTrue("The first DiffElement is not a DiffGroupElement", current instanceof DiffGroup);

		differences = current.getSubDiffElements();
		Assert.assertTrue("I don't found only 1 difference,differences.", differences.size() == 1);
		current = differences.get(0);
		Assert.assertTrue("The second DiffElement is not a DiffGroupElement", current instanceof DiffGroup);

		differences = current.getSubDiffElements();
		Assert.assertTrue("I don't found only 1 difference,differences.", differences.size() == 1);
		current = differences.get(0);
		Assert.assertTrue("The third DiffElement is not a DiffGroupElement", current instanceof DiffGroup);

		differences = current.getSubDiffElements();
		Assert.assertTrue("I don't found only 1 difference,differences.", differences.size() == 1);
		current = differences.get(0);
		testLastDiffElement(current);
	}

	public abstract void testLastDiffElement(final DiffElement diffElement);

	@After
	public final void closeAll() {
		GenericUtils.closeAllEditors();
	}
}
