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
package org.eclipse.papyrus.uml.compare.diff.tests.standalone.options;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusCompareOptions;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.compare.diff.services.UMLDiffService;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.StandaloneMergeUtils;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.UMLStandaloneMatchEngine;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractSimpleCompareTest;
import org.eclipse.papyrus.uml.compare.diff.tests.Activator;
import org.eclipse.uml2.uml.Model;
import org.junit.Test;

/**
 * 
 * This class tests the options PapyrusCompareOptions.KEY_ALLOW_MERGE_LEFT_TO_RIGHT and PapyrusCompareOptions.KEY_ALLOW_MERGE_RIGHT_TO_LEFT
 *
 */
public class AbstractMergeOptionsEnablementTests extends AbstractSimpleCompareTest {

	private final static String LEFT = "left"; //$NON-NLS-1$

	private final static String RIGHT = "right"; //$NON-NLS-1$

	private static final String FOLDER_PATH = "/resources/standalone/"; //$NON-NLS-1$


	public static final void init_standalone(final String modelPath, boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		init_standalone(FOLDER_PATH, modelPath, leftToRight);
	}

	public static final void init_standalone(final String folderPath, final String modelPath, boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		final List<IFile> comparedFiles = new ArrayList<IFile>();
		project = ProjectUtils.createProject("MyProject"); //$NON-NLS-1$

		if(modelPath != null) {//useful when the test is not yet implemented
			PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), folderPath + modelPath, LEFT);
			PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), folderPath + modelPath, RIGHT);

			comparedFiles.add(project.getFile(LEFT + "." + "uml")); //$NON-NLS-1$ //$NON-NLS-2$
			comparedFiles.add(project.getFile(RIGHT + "." + "uml")); //$NON-NLS-1$ //$NON-NLS-2$
			AbstractSimpleCompareTest.loadModels(comparedFiles);


			leftElement = (Model)roots.get(0);
			rightElement = (Model)roots.get(1);
		}
		AbstractSimpleCompareTest.leftToRight = leftToRight;
	}

	protected DiffModel getDiffModel(final EObject leftElement, final EObject rightElement, final Map<String, Object> options) throws InterruptedException {
		IMatchEngine engine = new UMLStandaloneMatchEngine();
		final MatchModel match = engine.resourceMatch(leftElement.eResource(), rightElement.eResource(), options);
		final DiffModel diff = UMLDiffService.doDiff(match, false, options);
		return diff;
	}

	protected Map<String, Object> getMergeOptions(final EObject leftElement, final EObject rightElement) {
		return StandaloneMergeUtils.getMergeOptions(null, leftElement, rightElement);
	}

	@Test
	public void testMergeToLeftToRightForbidden() throws InterruptedException {
		final Map<String, Object> options = getMergeOptions(leftElement, rightElement);
		options.put(PapyrusCompareOptions.KEY_ALLOW_MERGE_LEFT_TO_RIGHT, Boolean.FALSE);
		final DiffModel model = getDiffModel(leftElement, rightElement, options);
		final Iterator<EObject> iter = model.eAllContents();
		while(iter.hasNext()) {
			final EObject current = iter.next();
			if(current instanceof DiffElement) {
				final DiffElement diff = (DiffElement)current;
				Command cmd = TransactionalMergeService.getMergeCommand(domain, diff, leftToRight);
				if(leftToRight) {
					Assert.assertEquals(false, cmd.canExecute());
				} else {
					Assert.assertEquals(true, cmd.canExecute());
				}
			}
		}
	}

	@Test
	public void testMergeToRightToLeftForbidden() throws InterruptedException {
		final Map<String, Object> options = getMergeOptions(leftElement, rightElement);
		options.put(PapyrusCompareOptions.KEY_ALLOW_MERGE_RIGHT_TO_LEFT, Boolean.FALSE);
		final DiffModel model = getDiffModel(leftElement, rightElement, options);
		final Iterator<EObject> iter = model.eAllContents();
		while(iter.hasNext()) {
			final EObject current = iter.next();
			if(current instanceof DiffElement) {
				final DiffElement diff = (DiffElement)current;
				Command cmd = TransactionalMergeService.getMergeCommand(domain, diff, leftToRight);
				if(leftToRight) {
					Assert.assertEquals(true, cmd.canExecute());
				} else {
					Assert.assertEquals(false, cmd.canExecute());
				}
			}
		}
	}

	@Test
	public void testAllMergeForbidden() throws InterruptedException {
		final Map<String, Object> options = getMergeOptions(leftElement, rightElement);
		options.put(PapyrusCompareOptions.KEY_ALLOW_MERGE_RIGHT_TO_LEFT, Boolean.FALSE);
		options.put(PapyrusCompareOptions.KEY_ALLOW_MERGE_LEFT_TO_RIGHT, Boolean.FALSE);
		final DiffModel model = getDiffModel(leftElement, rightElement, options);
		final Iterator<EObject> iter = model.eAllContents();
		while(iter.hasNext()) {
			final EObject current = iter.next();
			if(current instanceof DiffElement) {
				final DiffElement diff = (DiffElement)current;
				Command cmd = TransactionalMergeService.getMergeCommand(domain, diff, leftToRight);
				Assert.assertEquals(false, cmd.canExecute());
			}
		}
	}
}
