/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.tests.standalone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.StandaloneMergeUtils;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.UMLStandaloneDiffService;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.UMLStandaloneMatchEngine;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.papyrus.uml.compare.diff.tests.Activator;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * This abstract provides methods to compare 2 Papyrus uml files named "left.uml" and "right.uml"
 * 
 */
public abstract class AbstractStandaloneCompareTest extends AbstractCompareTest {

	//	protected static IProject project;

	private final static String LEFT = "left";

	private final static String RIGHT = "right";

	//	protected static Model leftElement;

	//	protected static Model rightElement;

	//	protected static Map<String, Object> options;

	//	protected static TransactionalEditingDomain domain;

	protected static ResourceSet set;

	//	private  static String modelPath;


	private static final String FOLDER_PATH = "/resources/standalone/";

	//	private static boolean leftToRight = true;

	//	protected static List<DiffElement> initialDifferences;

	@Override
	protected DiffModel getDiffModel(EObject leftElement, EObject rightElement) throws InterruptedException {
		// Matching model elements
		//TODO use standalone version
		//TODO use the future Papyrus MatchService
		//		final MatchModel match = MatchService.doMatch(null, leftElement, rightElement, StandaloneMergeUtils.getMergeOptions(null, leftElement, rightElement));
		IMatchEngine engine = new UMLStandaloneMatchEngine();
		final MatchModel match = engine.resourceMatch(leftElement.eResource(), rightElement.eResource(), StandaloneMergeUtils.getMergeOptions(null, leftElement, rightElement));

		//TODO use standalone version
		// Computing differences
		//	final DiffModel diff = DiffService.doDiff(match, false);
		final DiffModel diff = UMLStandaloneDiffService.doDiff(match, false);
		return diff;
	}

	public static final void init(final String modelPath, boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		init(FOLDER_PATH, modelPath, leftToRight);
	}

	public static final void init(final String folderPath, final String modelPath, boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		final List<IFile> comparedFiles = new ArrayList<IFile>();
		project = ProjectUtils.createProject("MyProject"); //$NON-NLS-1$

		if(modelPath != null) {//useful when the test is not yet implemented
			PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), folderPath + modelPath, LEFT);
			PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), folderPath + modelPath, RIGHT);

			comparedFiles.add(project.getFile(LEFT + "." + "uml"));
			comparedFiles.add(project.getFile(RIGHT + "." + "uml"));
			AbstractCompareTest.loadModels(comparedFiles);


			leftElement = (Model)roots.get(0);
			rightElement = (Model)roots.get(1);
		}
		AbstractCompareTest.leftToRight = leftToRight;
	}

	//	/**
	//	 * This tests tests the contents of the differences found.
	//	 * 
	//	 */
	//	@Test
	//	public void testDifferences() throws InterruptedException {
	//		final DiffModel diff = getDiffModel(leftElement, rightElement);
	//		
	//		// Merges all differences from model1 to model2
	//		List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
	//		Assert.assertTrue("I don't found only 1 difference,differences.", differences.size() == 1);
	//		DiffElement current = differences.get(0);
	//		Assert.assertTrue("The first DiffElement is not a DiffGroupElement", current instanceof DiffGroup);
	//
	//		differences = current.getSubDiffElements();
	//		while(differences.size() == 1 && differences.get(0) instanceof DiffGroup) {
	//			differences = differences.get(0).getSubDiffElements();
	//		}
	//
	//		testLastDiffElements(differences);
	//	}

	//	/**
	//	 * The first differences are always DiffGroup.
	//	 * 
	//	 * @param diffElement
	//	 * 
	//	 * 
	//	 */
	//	public abstract void testLastDiffElements(final List<DiffElement> diffElement);

	//	@Test
	//	protected void mergeTestAllExecutability() throws InterruptedException {
	//		// Matching model elements
	//		final MatchModel match = MatchService.doMatch(leftElement, rightElement, options);
	//		// Computing differences
	//		final DiffModel diff = DiffService.doDiff(match, false);
	//		// Merges all differences from model1 to model2
	//		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
	//		initialDifferences = differences;
	//		for(final DiffElement current : differences) {
	//			Command cmd = TransactionalMergeService.getMergeCommand(domain, current, leftToRight);
	//			Assert.assertNotNull(NLS.bind("I can't find the merge command for {0}", current), cmd);
	//			Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", current), cmd.canExecute());
	//		}
	//	}


	//	@Test
	//	public void testCommandExecution() throws InterruptedException, IOException {
	//		// Matching model elements
	//		final MatchModel match = MatchService.doMatch(leftElement, rightElement, options);
	//		// Computing differences
	//		final DiffModel diff = DiffService.doDiff(match, false);
	//		// Merges all differences from model1 to model2
	//		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
	//		Assert.assertTrue("We should find only one DiffElement", differences.size() == 1);
	//		DiffElement diffElement = differences.get(0);
	//		Command cmd = TransactionalMergeService.getMergeCommand(domain, diffElement, leftToRight);
	//
	//		Assert.assertTrue(NLS.bind("The builded command to merge {0} is not executable", cmd), cmd.canExecute());
	//		//we execute the command and hope that all it is OK
	//		domain.getCommandStack().execute(cmd);
	//
	//		//we save the result
	//		for(Resource current : set.getResources()) {
	//			current.save(Collections.EMPTY_MAP);
	//			Assert.assertTrue(NLS.bind("The resource {0} has not been correctly saved!", current), !current.isModified());
	//		}
	//	}

	//TODO try to use the super implementation!
	@Test
	public void testResult() throws InterruptedException {
		//we compare the left and the right UML Model, they should be equals

		final DiffModel diff = getDiffModel(leftElement, rightElement);
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());

		Assert.assertTrue("After merging all differences, we still find differences between the models...", differences.size() == 1);


		DiffElement diffElement = differences.get(0);
		Assert.assertTrue(diffElement instanceof DiffGroup);
		DiffGroup group = (DiffGroup)diffElement;
		//FIXME : there is a difference

		Assert.assertTrue("After merging all differences, we still find differences between the models...", group.getSubDiffElements().size() == 0);

		//for the fun!
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(org.eclipse.emf.compare.util.AdapterUtils.getAdapterFactory());
		String label = provider.getText(group);
		Assert.assertTrue(NLS.bind("The message for 0 differences has changed (or there is a bug : the message {0}", label), label.equals("0 change(s) in model"));
	}

	//	@Test
	//	public void testXMIID() {
	//		Assert.fail();
	//	}

	//	@Test
	//	public void testUndo() throws IOException, InterruptedException {
	//		domain.getCommandStack().undo();
	//		for(Resource current : set.getResources()) {
	//			current.save(Collections.EMPTY_MAP);
	//			Assert.assertTrue(NLS.bind("The resource {0} has not been correctly saved!", current), !current.isModified());
	//		}
	//		// Matching model elements
	//		final MatchModel match = MatchService.doMatch(leftElement, rightElement, options);
	//		// Computing differences
	//		final DiffModel diff = DiffService.doDiff(match, false);
	//		// Merges all differences from model1 to model2
	//		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
	//		compareList(initialDifferences, differences);
	//	}

	//	@Test
	//	public void testRedo() throws IOException, InterruptedException {
	//		domain.getCommandStack().redo();
	//		for(Resource current : set.getResources()) {
	//			current.save(Collections.EMPTY_MAP);
	//			Assert.assertTrue(NLS.bind("The resource {0} has not been correctly saved!", current), !current.isModified());
	//		}
	//		testResult();
	//	}

	//	@AfterClass
	//	public static final void closeAll() {
	//		//TODO : disconnect from EditingDomain
	//		//		TransactionUtil.disconnectFromEditingDomain(eobject)
	//		//we close all the editors
	//		GenericUtils.closeAllEditors();
	//	}

	//	protected void compareList(final List<DiffElement> diff1, final List<DiffElement> diff2) {
	//		Assert.assertEquals("The compared lists don't have the same size.", diff1.size(), diff2.size());
	//		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(org.eclipse.emf.compare.util.AdapterUtils.getAdapterFactory());
	//		int size = diff1.size();
	//		for(int i = 0; i < size; i++) {
	//			DiffElement element1 = diff1.get(i);
	//			DiffElement element2 = diff2.get(i);
	//			//we verify that we get the same label for the 2 elements
	//			Assert.assertTrue(provider.getText(element1).equals(provider.getText(element2)));
	//			//we verify that the 2 elements are instance of the same class
	//			Assert.assertTrue("I'm comparing 2 elements which are not instance of the same class", element1.getClass() == element2.getClass());
	//
	//			if(element1 instanceof DiffGroup) {
	//				DiffGroup grp1 = (DiffGroup)element1;
	//				DiffGroup grp2 = (DiffGroup)element2;
	//				compareList(grp1.getSubDiffElements(), grp2.getSubDiffElements());
	//				compareList(grp1.getRequires(), grp2.getRequires());
	//				//				compareList(grp1.getRequiredBy(), grp2.getRequiredBy());
	//			}
	//		}
	//	}
}
