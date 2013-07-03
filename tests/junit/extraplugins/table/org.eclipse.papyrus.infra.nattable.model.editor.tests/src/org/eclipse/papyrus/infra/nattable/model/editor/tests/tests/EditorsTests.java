/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.model.editor.tests.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.papyrus.infra.nattable.model.editor.customeditors.CustomNattableEditor;
import org.eclipse.papyrus.infra.nattable.model.editor.customeditors.CustomNattableaxisEditor;
import org.eclipse.papyrus.infra.nattable.model.editor.customeditors.CustomNattableaxisconfigurationEditor;
import org.eclipse.papyrus.infra.nattable.model.editor.customeditors.CustomNattableaxisproviderEditor;
import org.eclipse.papyrus.infra.nattable.model.editor.customeditors.CustomNattableconfigurationEditor;
import org.eclipse.papyrus.infra.nattable.model.editor.customeditors.CustomNattablelabelproviderEditor;
import org.eclipse.papyrus.infra.nattable.model.editor.customeditors.CustomNattabletesterEditor;
import org.eclipse.papyrus.infra.nattable.model.editor.tests.Activator;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * If some tests of this class doesn't work, the problem comes probably from the plugin.xml of the plugin oep.infra.nattable.model.editor.
 * We replace the initial contributions to org.eclipse.ui.editor by our with our Custom Editor which override the save options
 * 
 * @author vl222926
 * 
 */
public class EditorsTests {

	private IProject project;

	@Before
	public void init() throws CoreException {
		ProjectUtils.removeAllProjectFromTheWorkspace();

	}

	/**
	 * 
	 * @param projectName
	 *        the name of the project
	 * @param modelName
	 *        the name of the file
	 * @param bundle
	 *        the bundle to use
	 * @return
	 * @throws Exception
	 */
	protected IEditorPart openFile(String projectName, String modelName, final Bundle bundle) throws Exception {
		project = ProjectUtils.createProject(projectName);
		final IFile diModelFile = PapyrusProjectUtils.copyIFile(getSourcePath() + modelName, bundle, project, modelName);
		RunnableWithResult<?> runnableWithResult = new RunnableWithResult.Impl<Object>() {

			public void run() {
				setStatus(Status.OK_STATUS);
				try {
					IEditorPart editor = EditorUtils.openEditor(diModelFile);
					setResult(editor);
				} catch (Exception ex) {
					Activator.log.error(ex);
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), ex.getMessage()));
				}

			}
		};

		Display.getDefault().syncExec(runnableWithResult);
		Assert.assertEquals(runnableWithResult.getStatus().getMessage(), IStatus.OK, runnableWithResult.getStatus().getSeverity());

		IEditorPart editor = (IEditorPart)runnableWithResult.getResult();
		Assert.assertNotNull(editor);
		return editor;
	}

	private Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Test
	public void testOpenNattableFileEditor() throws Exception {
		IEditorPart editor = openFile("testTableConfiguration", "My.nattable", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertTrue(editor instanceof CustomNattableEditor);
	}

	@Test
	public void testOpenNattableAxisFileEditor() throws Exception {
		IEditorPart editor = openFile("testTableConfiguration", "My.nattableaxis", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertTrue(editor instanceof CustomNattableaxisEditor);
	}

	@Test
	public void testOpenNattableAxisConfigurationFileEditor() throws Exception {
		IEditorPart editor = openFile("testTableConfiguration", "My.nattableaxisconfiguration", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertTrue(editor instanceof CustomNattableaxisconfigurationEditor);
	}

	@Test
	public void testOpenNattableAxisProviderFileEditor() throws Exception {
		IEditorPart editor = openFile("testTableConfiguration", "My.nattableaxisprovider", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertTrue(editor instanceof CustomNattableaxisproviderEditor);
	}

	@Test
	public void testOpenNattableConfigurationFileEditor() throws Exception {
		IEditorPart editor = openFile("testTableConfiguration", "My.nattableconfiguration", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertTrue(editor instanceof CustomNattableconfigurationEditor);
	}


	@Test
	public void testOpenNattableLabelProviderFileEditor() throws Exception {
		IEditorPart editor = openFile("testTableConfiguration", "My.nattablelabelprovider", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertTrue(editor instanceof CustomNattablelabelproviderEditor);
	}

	@Test
	public void testOpenNattableTesterFileEditor() throws Exception {
		IEditorPart editor = openFile("testTableConfiguration", "My.nattabletester", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertTrue(editor instanceof CustomNattabletesterEditor);
	}

	protected String getSourcePath() {
		return "/resources/"; //$NON-NLS-1$
	}

	@After
	public void after() {
		GenericUtils.closeAllEditors();

	}
}
