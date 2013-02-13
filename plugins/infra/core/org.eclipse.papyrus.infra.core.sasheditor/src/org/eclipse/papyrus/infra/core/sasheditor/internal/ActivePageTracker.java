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
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageChangedListener;


/**
 * Instance of this class track the active Page.
 * When the active Page change, the tracker receive an event on {@link #setActiveEditor(PagePart)}, and perform following tasks:
 * <ul>
 * <li>- call {@link #fireEditorChangeEvent(PagePart, PagePart)}</li>
 * <li>- fire events to all registered listeners.</li>
 * </ul>
 * 
 * This class allows two kind of listeners:
 * 
 * <ul>
 * <li> {@link IActiveEditorChangedListener} for internal use (ex: {@link ActiveEditorServicesSwitcher})</li>
 * <li> {@link IPageChangedListener} for public API use.</li>
 * </ul>
 * This class allows to set externally the active editor.
 * 
 * @author dumoulin
 * 
 */
public class ActivePageTracker {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** List of listeners */
	private List<IActiveEditorChangedListener> activeEditorChangedListeners = new ArrayList<IActiveEditorChangedListener>();

	/** List of public listeners */
	private List<IPageChangedListener> publicPageChangedListeners;

	/** The currently active editor */
	protected PagePart activeEditor;

	/**
	 * Interface that must be implemented by listeners on activeEditorChange event.
	 * 
	 * @author dumoulin
	 * 
	 */
	public interface IActiveEditorChangedListener {

		/**
		 * This method is called whenever the active editor is changed.
		 * 
		 * @param oldEditor
		 * @param newEditor
		 */
		public void activeEditorChanged(PagePart oldEditor, PagePart newEditor);
	}


	/**
	 * Constructor.
	 * The activeEditor will be set by the first TabFolder that will call TabFolderPart.setPage().
	 * 
	 * @param multiPartEditor
	 */
	public ActivePageTracker() {
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
	 * Set the active editor with the specified editor.
	 * This will notify all registered listeners
	 * 
	 * @param editor
	 */
	public void setActiveEditor(PagePart editor) {
		// Skip if there is no change
		if(activeEditor == editor)
			return;

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
		if(activeEditorChangedListeners.contains(listener))
			return;
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
		// no duplicate
		if(publicPageChangedListeners == null)
			publicPageChangedListeners = new ArrayList<IPageChangedListener>();

		if(publicPageChangedListeners.contains(listener))
			return;
		publicPageChangedListeners.add(listener);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void removePageChangedListener(IPageChangedListener listener) {
		if(publicPageChangedListeners == null)
			return;

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
//		if(oldEditor == newEditor)
//			return;

		// Fire events to internal listeners
		for(IActiveEditorChangedListener listener : activeEditorChangedListeners) {
			listener.activeEditorChanged(oldEditor, newEditor);
		}

		// Fire event to public listeners
		if(publicPageChangedListeners != null) {
			for(IPageChangedListener listener : publicPageChangedListeners) {
				listener.pageChanged(newEditor);
			}
		}

	}

}
