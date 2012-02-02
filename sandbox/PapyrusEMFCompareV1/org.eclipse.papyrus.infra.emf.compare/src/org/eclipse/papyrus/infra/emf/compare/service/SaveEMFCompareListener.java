/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.papyrus.infra.emf.compare.Activator;
import org.eclipse.papyrus.infra.emf.compare.utils.CompareEditorConfiguration;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This listener is used to catch the Save and the SaveAll actions to save the diResource linked to the modified uml Resource
 * 
 */
public class SaveEMFCompareListener implements IExecutionListener {

	/** the id of the save action */
	public static final String SAVE = "org.eclipse.ui.file.save";

	/** the id of the saveAll action */
	public static final String SAVE_ALL = "org.eclipse.ui.file.saveAll";

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param commandId
	 * @param exception
	 */
	public void notHandled(final String commandId, final NotHandledException exception) {
		//nothing to do
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param commandId
	 * @param exception
	 */
	public void postExecuteFailure(final String commandId, final ExecutionException exception) {
		//nothing to do
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param commandId
	 * @param returnValue
	 */
	public void postExecuteSuccess(final String commandId, final Object returnValue) {
		if(commandId.equals(SaveEMFCompareListener.SAVE)) {
			final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			save(Collections.singletonList(editor));
		} else if(commandId.equals(SaveEMFCompareListener.SAVE_ALL)) {
			final IEditorPart editors[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getDirtyEditors();
			save(Arrays.asList(editors));
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @param commandId
	 * @param event
	 */
	public void preExecute(final String commandId, final ExecutionEvent event) {
		//nothing to do!
	}

	/**
	 * Save resources
	 * 
	 * @param dirtyEditor
	 *        the list of the Resource to Save
	 */
	private void save(final List<IEditorPart> dirtyEditor) {
		for(final IEditorPart current : dirtyEditor) {
			final CompareEditorConfiguration config = Activator.getDefault().getConfigurationFor(current);
			if(config != null) {
				config.save();
			}
		}
	}

}
