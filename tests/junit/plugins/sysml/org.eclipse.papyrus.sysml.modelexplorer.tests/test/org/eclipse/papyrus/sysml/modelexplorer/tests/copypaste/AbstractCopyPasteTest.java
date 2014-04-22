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
 *  from Model 
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.sysml.modelexplorer.tests.common.AbstractModelExplorerTest;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;


/**
 * Abstract class for Copy/paste
 */
public abstract class AbstractCopyPasteTest extends AbstractModelExplorerTest {

	/**
	 * Generic implementation of the test
	 * 
	 * @throws Exception
	 *         exception thrown when the test has problems
	 */
	protected void testExecutableCopyPaste(EObject targetContainer, EObject copiedEObject, String  featureName, int expectedNumberOfAddedElements) throws Exception {
		testExecutableCopyPaste(targetContainer, copiedEObject, targetContainer.eClass().getEStructuralFeature(featureName), expectedNumberOfAddedElements);
	}

	/**
	 * Generic implementation of the test
	 * 
	 * @throws Exception
	 *         exception thrown when the test has problems
	 */
	protected void testExecutableCopyPaste(EObject targetContainer, EObject copiedEObject, EStructuralFeature feature, int expectedNumberOfAddedElements) throws Exception {
		// retrieve elements in the model explorer
		selectAndReveal(targetContainer);

		List<EObject> originalValues = new ArrayList<EObject>((List<EObject>)targetContainer.eGet(feature));

		Map<Object, Object> originalModel = new HashMap<Object, Object>();
		initializeTest(originalModel, targetContainer, copiedEObject);

		// try to paste in several places
		// copy Paste b1EObject
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		commandService.refreshElements(IWorkbenchCommandConstants.EDIT_PASTE, null);
		org.eclipse.core.commands.Command pasteCommand = commandService.getCommand(IWorkbenchCommandConstants.EDIT_PASTE);
		Assert.assertNotNull("Impossible to find paste command", pasteCommand); //$NON-NLS-1$
		Assert.assertTrue("command in not enabled", pasteCommand.isEnabled()); //$NON-NLS-1$
		Assert.assertTrue("command in not defined", pasteCommand.isDefined()); //$NON-NLS-1$

		pasteCommand.executeWithChecks(new ExecutionEvent());

		// check editor state (should be non dirty)
		Assert.assertTrue("Editor should be dirty after paste command execution", isEditorDirty()); //$NON-NLS-1$


		// should retrieve a new Part AND a new association
		List<EObject> newValues = (List<EObject>)targetContainer.eGet(feature);
		// compute delta
		List<EObject> delta = new ArrayList<EObject>();
		for(EObject o : newValues) {
			if(!originalValues.contains(o)) {
				delta.add(o);
			}
		}

		// size = original size +1
		Assert.assertEquals("Wrong number of attributes after paste", expectedNumberOfAddedElements, delta.size()); //$NON-NLS-1$

		// part should be linked to an association 
		postCopyAdditionalChecks(originalModel, newValues, delta);

		// undo
		if(getEditingDomain().getCommandStack().canUndo()) {
			getEditingDomain().getCommandStack().undo();
		} else {
			throw new Exception("Impossible to undo the paste command: " + pasteCommand); //$NON-NLS-1$
		}
		// check editor state (should be non dirty)
		Assert.assertFalse("Editor should not be dirty after undo", isEditorDirty()); //$NON-NLS-1$
		// check old values equals the actual values
		newValues = (List<EObject>)targetContainer.eGet(feature);
		Assert.assertEquals("Initial and current list feature list should be equivalent", newValues, originalValues); //$NON-NLS-1$

		// redo
		if(getEditingDomain().getCommandStack().canRedo()) {
			getEditingDomain().getCommandStack().redo();
		} else {
			throw new Exception("Impossible to redo the paste command: " + pasteCommand); //$NON-NLS-1$
		}
		// check editor state (should be non dirty)
		Assert.assertTrue("Editor should not dirty after redo", isEditorDirty()); //$NON-NLS-1$

		// check as it was the result of the paste command
		newValues = (List<EObject>)targetContainer.eGet(feature);
		delta = new ArrayList<EObject>();
		for(EObject o : newValues) {
			if(!originalValues.contains(o)) {
				delta.add(o);
			}
		}

		// size = original size + delta
		Assert.assertEquals("Wrong number of attributes after paste", expectedNumberOfAddedElements, delta.size()); //$NON-NLS-1$

		// part should be linked to an association 
		postCopyAdditionalChecks(originalModel, newValues, delta);

		// undo again, to restore state
		if(getEditingDomain().getCommandStack().canUndo()) {
			getEditingDomain().getCommandStack().undo();
		} else {
			throw new Exception("Impossible to re-undo the paste command: " + pasteCommand); //$NON-NLS-1$
		}
		// check editor state (should be non dirty)
		Assert.assertFalse("Editor should not be dirty after undo", isEditorDirty()); //$NON-NLS-1$

	}

	/**
	 * executes additional checks on the new value
	 * 
	 * @param originalModel
	 *        the map containing all values stored before launching the test
	 * @param newValue
	 *        the new value, result of the copy
	 * @param delta
	 * 		  differences between original list and the new one 
	 */
	protected void postCopyAdditionalChecks(Map<?, ?> originalModel, List<EObject> newValues, List<EObject> delta) throws Exception {
		// use the values contained in the map to do additional checks
	}

	protected void initializeTest(Map<Object, Object> additionalChecks, EObject targetContainer, EObject copiedEObject) {
		// nothing to do here
	}
}
