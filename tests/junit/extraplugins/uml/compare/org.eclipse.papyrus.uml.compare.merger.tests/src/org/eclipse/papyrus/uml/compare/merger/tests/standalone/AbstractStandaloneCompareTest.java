package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.TransactionalEditingDomainManager;
import org.eclipse.papyrus.infra.emf.compare.common.utils.services.PapyrusFileLoader;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.utils.LabelProviderUtil;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.compare.merge.services.TransactionalMergeService;
import org.eclipse.papyrus.uml.compare.merge.standalone.utils.StandaloneMergeUtils;
import org.eclipse.papyrus.uml.compare.merger.tests.Activator;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.eclipse.emf.compare.util.AdapterUtils;

/**
 * 
 * This abstract provides methods to compare 2 Papyrus uml files named "left.uml" and "right.uml"
 * 
 */
public abstract class AbstractStandaloneCompareTest {

	protected static IProject project;

	private final static String LEFT = "left";

	private final static String RIGHT = "right";

	protected static Model leftRoot;

	protected static Model rightRoot;

	protected static Map<String, Object> options;

	protected static TransactionalEditingDomain domain;

	protected static ResourceSet set;

	//	private  static String modelPath;


	private static final String FOLDER_PATH = "/resources/standalone/";

	private static boolean leftToRight = true;

	protected static List<DiffElement> initialDifferences;

	public static final void init(final String modelPath, boolean leftToRight) throws CoreException, IOException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		project = ProjectUtils.createProject("MyProject"); //$NON-NLS-1$
		System.out.println(modelPath);
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), FOLDER_PATH + modelPath, LEFT);
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), FOLDER_PATH + modelPath, RIGHT);
		//		openCompareFileEditor();
		final List<IFile> comparedFiles = new ArrayList<IFile>();

		comparedFiles.add(project.getFile(LEFT + "." + "uml"));
		comparedFiles.add(project.getFile(RIGHT + "." + "uml"));

		//TODO associate the EditingDomain!
		set = new ResourceSetImpl();
		domain = TransactionalEditingDomainManager.createDefaultTransactionalEditingDomain(set);
		EObject[] roots = PapyrusFileLoader.loadPapyrusFiles(set, comparedFiles);
		leftRoot = (Model)roots[0];
		rightRoot = (Model)roots[1];
		options = StandaloneMergeUtils.getMergeOptions();
		AbstractStandaloneCompareTest.leftToRight = leftToRight;
	}

	/**
	 * This tests tests the contents of the differences found.
	 * 
	 */
	@Test
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
		while(differences.size() == 1 && differences.get(0) instanceof DiffGroup) {
			differences = differences.get(0).getSubDiffElements();
		}

		testLastDiffElements(differences);
	}

	/**
	 * The first differences are always DiffGroup.
	 * 
	 * @param diffElement
	 * 
	 * 
	 */
	public abstract void testLastDiffElements(final List<DiffElement> diffElement);

	@Test
	protected void mergeTestAllExecutability() throws InterruptedException {
		// Matching model elements
		final MatchModel match = MatchService.doMatch(leftRoot, rightRoot, options);
		// Computing differences
		final DiffModel diff = DiffService.doDiff(match, false);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		initialDifferences = differences;
		for(final DiffElement current : differences) {
 			Command cmd = TransactionalMergeService.getMergeCommand(domain, current, true);
			Assert.assertNotNull(NLS.bind("I can't find the merge command for {0}", current), cmd);
			Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", current), cmd.canExecute());
		}
	}


	@Test
	public void testCommandExecution() throws InterruptedException, IOException {
		// Matching model elements
		final MatchModel match = MatchService.doMatch(leftRoot, rightRoot, options);
		// Computing differences
		final DiffModel diff = DiffService.doDiff(match, false);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		Assert.assertTrue("We should find only one DiffElement", differences.size() == 1);
		DiffElement diffElement = differences.get(0);
		Command cmd = TransactionalMergeService.getMergeCommand(domain, diffElement, true);

		Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", cmd), cmd.canExecute());
		//we execute the command and hope that all it is OK
		domain.getCommandStack().execute(cmd);

		//we save the result
		for(Resource current : set.getResources()) {
			current.save(Collections.EMPTY_MAP);
			Assert.assertTrue(NLS.bind("The resource {0} has not been correctly saved!", current), !current.isModified());
		}
	}

	@Test
	public void testResult() throws InterruptedException {
		//we compare the left and the right UML Model, they should be equals
		// Matching model elements
		final MatchModel match = MatchService.doMatch(leftRoot, rightRoot, options);
		// Computing differences
		final DiffModel diff = DiffService.doDiff(match, false);
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());

		Assert.assertTrue("After merging all differences, we still find differences between the models...", differences.size() == 1);


		DiffElement diffElement = differences.get(0);
		Assert.assertTrue(diffElement instanceof DiffGroup);
		DiffGroup group = (DiffGroup)diffElement;
		Assert.assertTrue("After merging all differences, we still find differences between the models...", group.getSubDiffElements().size() == 0);

		//for the fun!
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(org.eclipse.emf.compare.util.AdapterUtils.getAdapterFactory());
		String label = provider.getText(group);
		Assert.assertTrue(NLS.bind("The message for 0 differences has changed (or there is a bug : the message {0}", label), label.equals("0 change(s) in model"));
	}

	@Test
	public void testXMIID() {
		Assert.fail();
	}

	@Test
	public void testUndo() throws IOException, InterruptedException {
		domain.getCommandStack().undo();
		for(Resource current : set.getResources()) {
			current.save(Collections.EMPTY_MAP);
			Assert.assertTrue(NLS.bind("The resource {0} has not been correctly saved!", current), !current.isModified());
		}
		// Matching model elements
		final MatchModel match = MatchService.doMatch(leftRoot, rightRoot, options);
		// Computing differences
		final DiffModel diff = DiffService.doDiff(match, false);
		// Merges all differences from model1 to model2
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
		compareList(initialDifferences, differences);
	}

	@Test
	public void testRedo() throws IOException, InterruptedException {
		domain.getCommandStack().redo();
		for(Resource current : set.getResources()) {
			current.save(Collections.EMPTY_MAP);
			Assert.assertTrue(NLS.bind("The resource {0} has not been correctly saved!", current), !current.isModified());
		}
		testResult();
	}

	@AfterClass
	public static final void closeAll() {
		//TODO : disconnect from EditingDomain
		//		TransactionUtil.disconnectFromEditingDomain(eobject)
		//we close all the editors
		GenericUtils.closeAllEditors();
	}

	protected void compareList(final List<DiffElement> diff1, final List<DiffElement> diff2) {
		Assert.assertEquals("The compared lists don't have the same size.", diff1.size(), diff2.size());
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(org.eclipse.emf.compare.util.AdapterUtils.getAdapterFactory());
		int size = diff1.size();
		for(int i = 0; i < size; i++) {
			DiffElement element1 = diff1.get(i);
			DiffElement element2 = diff2.get(i);
			//we verify that we get the same label for the 2 elements
			Assert.assertTrue(provider.getText(element1).equals(provider.getText(element2)));
			//we verify that the 2 elements are instance of the same class
			Assert.assertTrue("I'm comparing 2 elements which are not instance of the same class", element1.getClass() == element2.getClass());

			if(element1 instanceof DiffGroup) {
				DiffGroup grp1 = (DiffGroup)element1;
				DiffGroup grp2 = (DiffGroup)element2;
				compareList(grp1.getSubDiffElements(), grp2.getSubDiffElements());
				compareList(grp1.getRequires(), grp2.getRequires());
				//				compareList(grp1.getRequiredBy(), grp2.getRequiredBy());
			}
		}
	}
}
