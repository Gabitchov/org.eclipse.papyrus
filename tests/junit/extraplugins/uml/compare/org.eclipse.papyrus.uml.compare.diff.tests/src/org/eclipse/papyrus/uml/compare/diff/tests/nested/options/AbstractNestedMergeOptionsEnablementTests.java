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
package org.eclipse.papyrus.uml.compare.diff.tests.nested.options;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.compare.diff.services.UMLDiffService;
import org.eclipse.papyrus.uml.compare.diff.services.nested.NestedMatchService;
import org.eclipse.papyrus.uml.compare.diff.services.nested.NestedMergeUtils;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractSimpleCompareTest;
import org.eclipse.papyrus.uml.compare.diff.tests.Activator;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.options.AbstractMergeOptionsEnablementTests;
import org.eclipse.uml2.uml.Package;


public class AbstractNestedMergeOptionsEnablementTests extends AbstractMergeOptionsEnablementTests {

	/** the root of the model used for the test */
	protected static Package root;

	private static final String FOLDER_PATH = "/resources/nested/"; //$NON-NLS-1$

	/** the name of the model used to do the test */
	private static final String MODEL = "model"; //$NON-NLS-1$

	public static final void init_nested(final String modelPath, boolean leftToRight) throws CoreException, IOException, ServiceException, ModelMultiException {
		AbstractNestedMergeOptionsEnablementTests.init_nested(FOLDER_PATH, modelPath, leftToRight);
	}

	public static final void init_nested(final String folderPath, final String modelPath, boolean leftToRight) throws CoreException, IOException, ServiceException, ModelMultiException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		AbstractSimpleCompareTest.leftToRight = leftToRight;
		project = ProjectUtils.createProject("MyProject"); //$NON-NLS-1$
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), folderPath + modelPath, MODEL);
		final List<IFile> comparedFiles = new ArrayList<IFile>();
		comparedFiles.add(project.getFile(MODEL + "." + "uml")); //$NON-NLS-1$ //$NON-NLS-2$
		AbstractSimpleCompareTest.loadModels(comparedFiles);
		root = (Package)roots.get(0);
	}

	@Override
	protected DiffModel getDiffModel(final EObject leftElement, final EObject rightElement, final Map<String, Object> options) throws InterruptedException {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot(); //TODO it should be interesting to factorize this process between the JUnit tests and the "graphical use"
		// Matching model elements
		final MatchModel match = NestedMatchService.doContentMatch(leftElement, rightElement, options);
		// Computing differences
		final DiffModel diff = UMLDiffService.doDiff(match, false, options);
		snapshot.setMatch(match);
		snapshot.setDiff(diff);
		return diff;
	}
	
	protected Map<String, Object> getMergeOptions(final EObject leftElement, final EObject rightElement) {
		return NestedMergeUtils.getMergeOptions(null, leftElement, rightElement);
	}

}
