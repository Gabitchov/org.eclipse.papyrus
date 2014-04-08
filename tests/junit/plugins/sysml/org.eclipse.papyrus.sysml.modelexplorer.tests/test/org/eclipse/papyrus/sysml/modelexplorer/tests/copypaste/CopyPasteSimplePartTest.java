/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *  from SimplePart - Model
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste;

import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for Copy / Paste of a Part
 */
public class CopyPasteSimplePartTest extends AbstractCopyPastePartTest {

	/**
	 * prepare the copy
	 *
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Before
	public void testPrepare() throws Exception {
		// check editor state (should be non dirty)
		//FIXME: In Papyrus, the editor may be dirty at initialization. This should not be tested here. We simply save the editor as soon as it is opened.
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().doSave(new NullProgressMonitor());
			}
		});
		// retrieve elements in the model explorer
		selectAndReveal(pB2_B1_EObject);

		// copy Paste
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		commandService.refreshElements(IWorkbenchCommandConstants.EDIT_COPY, null);
		org.eclipse.core.commands.Command copyCommand = commandService.getCommand(IWorkbenchCommandConstants.EDIT_COPY);
		Assert.assertNotNull("Impossible to find copy command", copyCommand);
		Assert.assertTrue("command in not enabled", copyCommand.isEnabled());
		Assert.assertTrue("command in not defined", copyCommand.isDefined());
		copyCommand.executeWithChecks(new ExecutionEvent());

		// check editor state (should be non dirty)
		Assert.assertFalse("Editor should not be dirty after copy", isEditorDirty());
	}

	@Override
	protected void initializeTest(Map<Object, Object> additionalChecks, EObject targetContainer, EObject copiedEObject) {
		super.initializeTest(additionalChecks, targetContainer, copiedEObject);

		/* pre-copy initialization */

		/* END OF pre-copy initialization */
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void postCopyAdditionalChecks(Map<?, ?> originalModel, List<EObject> newValues, List<EObject> delta) throws Exception {
		super.postCopyAdditionalChecks(originalModel, newValues, delta);

		/* post copy checks */

		/* END OF post copy checks */
	}


	/**
	 * Test the copy /paste on B1
	 *
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testCopyPasteInB1() throws Exception {
		testExecutableCopyPaste(b1_EObject, pB2_B1_EObject, "attribute", 1);
	}

	/**
	 * Test the copy /paste on B2
	 *
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testCopyPasteInB2() throws Exception {
		testExecutableCopyPaste(b2_EObject, pB2_B1_EObject, "attribute", 1);
	}

	/**
	 * Test the copy /paste on B1P1
	 *
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testCopyPasteInB1P1() throws Exception {
		testExecutableCopyPaste(b1P1_P1_EObject, pB2_B1_EObject, "attribute", 1);
	}

	/**
	 * Test the copy /paste on B2P1
	 *
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testCopyPasteInB2P1() throws Exception {
		testExecutableCopyPaste(b2P1_P1_EObject, pB2_B1_EObject, "attribute", 1);
	}


}
