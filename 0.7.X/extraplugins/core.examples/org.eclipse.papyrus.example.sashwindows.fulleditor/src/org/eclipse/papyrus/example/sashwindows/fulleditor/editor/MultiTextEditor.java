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
package org.eclipse.papyrus.example.sashwindows.fulleditor.editor;


import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.example.sashwindows.fulleditor.texteditor.TextEditorPartModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;


/**
 * An example showing how to create a multi-page editor using sash windows.
 * This example start with one page, and provide actions to create new pages.
 * It can be used with the full sashWindow system (extends AbstractMultiPageSashEditor) or
 * with the original Eclipse MultiPageEditor (extends MultiPageEditor).
 * To use one or the other, change the extended class.
 */
public class MultiTextEditor extends /* MultiPageEditor */AbstractMultiPageSashEditor {

	/**
	 * A listener on model change events.
	 */
	IContentChangedListener contentChangedListener = new IContentChangedListener() {

		/**
		 * Called when the content is changed. RefreshTabs.
		 */
		public void contentChanged(ContentEvent event) {
			System.out.println("contentChanged()");
			refreshTabs();
		}
	};

	/**
	 * The dirty flag.
	 */
	protected boolean isDirty = false;

	/**
	 * Listener on PROP_DIRTY event. Register the change.
	 */
	private IPropertyListener dirtyPropertyListener = new IPropertyListener() {

		public void propertyChanged(Object source, int propId) {
			if(propId == PROP_DIRTY)
				isDirty = true;
		}
	};

	/**
	 * Creates a multi-page editor example.
	 */
	public MultiTextEditor() {
		super();
		//		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		// Listen on dirty event.
		addPropertyListener(dirtyPropertyListener);
	}

	/**
	 * Create and initialize the pageProvider.
	 */
	protected ISashWindowsContentProvider createPageProvider() {
		SimpleSashWindowsContentProvider pageProvider = new SimpleSashWindowsContentProvider();
		// Adding requested pages
		pageProvider.addPage(new TextEditorPartModel());
		// Listen on contentProvider changes
		pageProvider.addListener(contentChangedListener);
		return pageProvider;
	}


	/**
	 * Get the ContentProvider casted to appropriate type. {@inheritDoc}
	 */
	@Override
	protected SimpleSashWindowsContentProvider getContentProvider() {
		return (SimpleSashWindowsContentProvider)super.getContentProvider();
	}

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		//		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		getContentProvider().removeListener(contentChangedListener);
		super.dispose();
	}

	/**
	 * Saves the multi-page editor's document.
	 */
	public void doSave(IProgressMonitor monitor) {

		IEditorPart editor = getActiveEditor();
		if(editor != null) {
			editor.doSave(monitor);
			// Reset dirty flag.
			isDirty = false;
		}
	}

	/**
	 * Saves the multi-page editor's document as another file.
	 * Also updates the text for page 0's tab, and updates this multi-page editor's input
	 * to correspond to the nested editor's.
	 */
	public void doSaveAs() {
		IEditorPart editor = getActiveEditor();
		if(editor != null) {
			editor.doSaveAs();
			//			setPageText(0, editor.getTitle());
			setInput(editor.getEditorInput());

			// Reset dirty flag.
			isDirty = false;
		}
	}

	/*
	 * (non-Javadoc)
	 * Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		//		setActivePage(0);
		IDE.gotoMarker(getActiveEditor(), marker);
	}

	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
			throws PartInitException {
		if(!(editorInput instanceof IFileEditorInput))
			throw new PartInitException("Invalid Input: Must be IFileEditorInput");
		super.init(site, editorInput);
	}

	/*
	 * (non-Javadoc)
	 * Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public boolean isDirty() {
		return isDirty;
	}

}
