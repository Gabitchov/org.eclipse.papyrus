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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.ui.IPartService;


/**
 * Instance of this class track the active Page.
 * When the active Page change, the tracker receive an event, and perform following tasks:
 * - call editorChange()
 * - fire events to all registered listeners.
 * 
 * This class allows to set externally the active editor.
 * @author dumoulin
 *
 */
@SuppressWarnings("unchecked")
public class ActivePageTracker {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());
	
	/** List of listeners */
	private List<IActiveEditorChangeListener> activeEditorChangeListeners = new ArrayList<IActiveEditorChangeListener>();

	/** The currently active editor */
	protected PagePart activeEditor;
	
	/**
	 * Interface that must be implemented by listeners on activeEditorChange event.
	 * @author dumoulin
	 *
	 */
	public interface IActiveEditorChangeListener {
		
		/**
		 * This method is called whenever the active editor change.
		 * @param oldEditor
		 * @param newEditor
		 */
		public void activeEditorChange(PagePart oldEditor, PagePart newEditor);
	}
	
	
	/**
	 * Constructor.
	 * The activeEditor will be set by the first TabFolder that will  call TabFolderPart.setPage().
	 * @param multiPartEditor
	 */
	public ActivePageTracker() {
	}

	/**
	 * Get the activeEditor.
	 * @return The active editor or null if there is none.
	 */
	public PagePart getActiveEditor() {
		return activeEditor;
	}
	
	/**
	 * Set the active editor with the specified editor.
	 * @param editor
	 */
	public void setActiveEditor(PagePart editor)
	{
		// Skip if there is no change
		if(activeEditor == editor)
			return;
		
		PagePart oldEditor = activeEditor;
		activeEditor = editor;
		editorChange(editor);
		fireEditorChangeEvent(oldEditor, editor);
	}
	
	/**
	 * Notifies that the editor has been activated. This method is called when the 
	 * user selects a different editor.
	 * @param editor
	 */
	protected void editorChange(PagePart editor)
	{
		System.out.println(getClass().getSimpleName()+ ".editorChange('"+ editor.getPartTitle()+"')");

		// TODO: Shouldn't we fire the fireEditorChangeEvent() here rather than in setActiveEditor() ?
		editor.setFocus();
	}
	
	/**
	 * Add a listener on the activeEditorChange event.
	 * @param listener
	 */
	public void addActiveEditorChangeListener(IActiveEditorChangeListener listener)
	{
		// no duplicate
		if(activeEditorChangeListeners.contains(listener))
			return;
		activeEditorChangeListeners.add(listener);
	}
	
	/**
	 * Add a listener on the activeEditorChange event.
	 * @param listener
	 */
	public void removeActiveEditorChangeListener(IActiveEditorChangeListener listener)
	{
		activeEditorChangeListeners.remove(listener);
	}
	
	private void fireEditorChangeEvent(PagePart oldEditor, PagePart newEditor)
	{
		// Fire only if really change
		if(oldEditor == newEditor)
			return;
		
		for(IActiveEditorChangeListener listener : activeEditorChangeListeners)
		{
			listener.activeEditorChange(oldEditor, newEditor);
		}
	}
	
}
