/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.editor.gef;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;


/**
 * Provide methods and services needed for Gef Editors.
 * This class is intended to be used as a delegate inside classes providing MultiDiagramEditor.
 * 
 * @author dumoulin
 *
 */
public class MultiDiagramEditorGefDelegate  {

	/** The registry holding actions associated to the main editor */
	protected ActionRegistry actionRegistry;

	/** Synchronizer object */
//	private MultiPageSelectionSynchronizer synchronizer;

	/** List of listeners on SelectionChanged event */
	private List<ISelectionChangedListener> selectionListeners = new ArrayList<ISelectionChangedListener>(1);

	
	/**
	 * This method should be called by the containing class.
	 */
	public void dispose() {
		selectionListeners.clear();
		if (actionRegistry != null) {
			actionRegistry.dispose();
		}
	}


	/**
	 * Adds a listener for selection changes in this selection provider. Has no effect if an identical listener is already registered.
	 * 
	 * @param listener
	 *            a selection changed listener
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionListeners.add(listener);
	}

	/**
	 * Lazily creates and returns the action registry.
	 * 
	 * @return the action registry
	 */
	public ActionRegistry getActionRegistry() {
		if (actionRegistry == null)
			actionRegistry = new ActionRegistry();
		return actionRegistry;
	}

//	/**
//	 * Returns the selection synchronizer object. The synchronizer can be used to sync the selection of 2 or more EditPartViewers.
//	 * 
//	 * @return the syncrhonizer
//	 */
//	public MultiPageSelectionSynchronizer getSelectionSynchronizer() {
//		if (synchronizer == null) {
//			synchronizer = new MultiPageSelectionSynchronizer();
//			// Hook this editor.
////			synchronizer.addViewer(this);
//		}
//		return synchronizer;
//	}

	/**
	 * Removes the given selection change listener from this selection provider. Has no affect if an identical listener is not registered.
	 * 
	 * @param listener
	 *            the selection changed listener to be removed
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionListeners.remove(listener);
	}

	/**
	 * Sets the current selection for this selection provider.
	 * 
	 * @param selection
	 *            the new selection
	 */
	public void setSelection(ISelection selection) {
	}

}
