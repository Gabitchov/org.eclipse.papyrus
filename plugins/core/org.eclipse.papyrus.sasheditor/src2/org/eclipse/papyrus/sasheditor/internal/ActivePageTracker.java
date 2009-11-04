/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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
package org.eclipse.papyrus.sasheditor.internal;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.papyrus.sasheditor.editor.IPageChangedListener;

/**
 * Instance of this class track the active Page. When the active Page change, the tracker receive an
 * event, and perform following tasks:
 * <ul>
 * <li>- call editorChange()</li>
 * <li>- fire events to all registered listeners.</li>
 * </ul>
 * 
 * This class allows to kind of listeners:
 * 
 * <ul>
 * <li> {@link IActiveEditorChangedListener} for internal use</li>
 * <li> {@link IPageChangedListener} for public API use.</li>
 * </ul>
 * This class allows to set externally the active editor.
 * 
 * @author dumoulin
 * 
 */
@SuppressWarnings("unchecked")
public class ActivePageTracker {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** List of listeners */
	private final Set<IActiveEditorChangedListener> activeEditorChangedListeners = new HashSet<IActiveEditorChangedListener>();

	/** List of public listeners */
	private final Set<IPageChangedListener> publicPageChangedListeners = new HashSet<IPageChangedListener>();

	/** The currently active editor */
	protected PagePart activeEditor;

	/**
	 * Interface that must be implemented by listeners on activeEditorChange event.
	 * 
	 * @author dumoulin
	 * 
	 */
	interface IActiveEditorChangedListener {

		/**
		 * This method is called whenever the active editor is changed.
		 * 
		 * @param oldEditor
		 * @param newEditor
		 */
		void activeEditorChanged(PagePart oldEditor, PagePart newEditor);
	}

	/**
	 * Get the activeEditor.
	 * 
	 * @return The active editor or null if there is none.
	 */
	public PagePart getActiveEditor() {
		return activeEditor;
	}

	/**
	 * Set the active editor with the specified editor. This will notify all registered listeners
	 * 
	 * @param editor
	 */
	public void setActiveEditor(PagePart editor) {
		// Skip if there is no change
		if (activeEditor == editor) {
			return;
		}

		PagePart oldEditor = activeEditor;
		activeEditor = editor;
		fireEditorChangeEvent(oldEditor, editor);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void addActiveEditorChangedListener(IActiveEditorChangedListener listener) {
		// no duplicate
		if (activeEditorChangedListeners.contains(listener)) {
			return;
		}
		activeEditorChangedListeners.add(listener);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void removeActiveEditorChangedListener(IActiveEditorChangedListener listener) {
		activeEditorChangedListeners.remove(listener);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void addPageChangedListener(IPageChangedListener listener) {
		publicPageChangedListeners.add(listener);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void removePageChangedListener(IPageChangedListener listener) {
		publicPageChangedListeners.remove(listener);
	}

	/**
	 * Notify all listener with event.
	 * 
	 * @param oldEditor
	 * @param newEditor
	 */
	private void fireEditorChangeEvent(PagePart oldEditor, PagePart newEditor) {
		// Fire only if really change
		if (oldEditor == newEditor) {
			return;
		}

		// Fire events to internal listeners
		for (IActiveEditorChangedListener listener : activeEditorChangedListeners) {
			listener.activeEditorChanged(oldEditor, newEditor);
		}

		// Fire event to public listeners
		for (IPageChangedListener listener : publicPageChangedListeners) {
			listener.pageChanged(newEditor);
		}
	}

}
