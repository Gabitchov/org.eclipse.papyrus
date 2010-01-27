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


import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.example.sashwindows.fulleditor.texteditor.TextEditorPartModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
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
 * This editor use the EMF Di implementation of the ContentProvider.
 * To use one or the other, change the extended class.
 */
public class DiMultiTextEditor extends /* MultiPageEditor */AbstractMultiPageSashEditor {

	/** SashModelMngr to add pages */
	protected DiSashModelMngr sashModelMngr;

	/** Resource mngr to load and save model */
	protected ResourceMngr resourceMngr;

	/**
	 * A listener on model change events.
	 */
	IContentChangedListener contentChangedListener = new IContentChangedListener() {

		/**
		 * Called when the content is changed. RefreshTabs.
		 */
		public void contentChanged(ContentEvent event) {
			System.out.println("contentChanged()");
			markDirty();
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
	public DiMultiTextEditor() {
		super();
		//		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		// Listen on dirty event.
		addPropertyListener(dirtyPropertyListener);
	}

	/**
	 * Mark the editor as dirty, and fire appropriate event.
	 */
	protected void markDirty() {
		isDirty = true;
		firePropertyChange(PROP_DIRTY);
	}

	/**
	 * Create and initialize the pageProvider.
	 */
	protected ISashWindowsContentProvider createPageProvider() {
		IPageModelFactory pageFactory = new SimplePageModelFactory();

		//		sashModelMngr = new DiSashModelMngr(pageFactory, resourceMngr.getDiResource() );
		sashModelMngr = new DiSashModelMngr(pageFactory);

		ISashWindowsContentProvider pageProvider = sashModelMngr.getISashWindowsContentProvider();

		// Adding requested pages
		pageProvider.addPage(new TextEditorPartModel());
		// Listen on contentProvider changes
		sashModelMngr.getSashModelContentChangedProvider().addContentChangedListener(contentChangedListener);

		return pageProvider;
	}

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		//		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		sashModelMngr.getSashModelContentChangedProvider().removeContentChangedListener(contentChangedListener);
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

		//		try {
		//			resourceMngr.saveResource(monitor);
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
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

		// Load model
		//		IFile file = ((IFileEditorInput) editorInput).getFile();
		//		resourceMngr = new ResourceMngr();
		//		resourceMngr.loadResource(file);
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

	/**
	 * Simple implementation of the factory.
	 * This factory return the object as is.
	 * 
	 * @author dumoulin
	 */
	public class SimplePageModelFactory implements IPageModelFactory {

		public IPageModel createIPageModel(Object pageIdentifier) {
			return (IPageModel)pageIdentifier;
		}

	}

	/**
	 * A class managing a Resource.
	 * 
	 * @author cedric dumoulin
	 */
	public class ResourceMngr {

		private static final String DI_FILE_EXTENSION = "di";

		private ResourceSet resourceSet;

		private Resource diResource;


		/**
		 * Constructor.
		 */
		public ResourceMngr() {
			createResourceSet();
		}

		/**
		 * Return the resource used for DI model.
		 * 
		 * @return
		 */
		public Resource getDiResource() {
			return diResource;
		}

		/**
		 * Create the resourceSet.
		 */
		protected void createResourceSet() {

			if(resourceSet != null)
				return;

			// Create di resource
			resourceSet = new ResourceSetImpl();

			// Register the default resource factory -- only needed for stand-alone!
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
					Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		}

		/**
		 * Load resource using name provided in file.
		 * 
		 * @param file
		 */
		public void loadResource(IFile file) {
			// Extract file name, without extension
			IPath fullPath = file.getFullPath().removeFileExtension();

			IPath filePath;
			filePath = fullPath.addFileExtension(DI_FILE_EXTENSION);

			URI uri = URI.createPlatformResourceURI(filePath.toString(), true);
			try {
				diResource = resourceSet.getResource(uri, true);
			} catch (Exception e) {
				//				diResource = resourceSet.createResource(uri);
				e.printStackTrace();
			}

		}

		/**
		 * Load resource using name provided in file.
		 * 
		 * @param file
		 */
		public void createResource(IFile file) {
			// Extract file name, without extension
			IPath fullPath = file.getFullPath().removeFileExtension();

			IPath filePath;
			filePath = fullPath.addFileExtension(DI_FILE_EXTENSION);

			URI uri = URI.createPlatformResourceURI(filePath.toString(), true);
			diResource = resourceSet.createResource(uri);

		}

		/**
		 * Save Resource associated to this manager.
		 * 
		 * @throws IOException
		 */
		public void saveResource() throws IOException {
			diResource.save(null);
		}

		public void saveResource(IProgressMonitor monitor) throws IOException {
			monitor.beginTask("Saving resources", 3);
			monitor.worked(1);
			saveResource();
			monitor.worked(1);
			monitor.done();
		}


	}
}
