/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.core.resourceUpdate;

import static org.eclipse.papyrus.core.Activator.log;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.core.lifecycleevents.ISaveEventListener;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * A listener for resource changes, used to trigger an update of
 * models whose underlying resources have been changed.
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
public class ModelResourceListener implements IResourceChangeListener, IResourceDeltaVisitor {

	public static final String RESOURCE_UPDATE_ID = Activator.PLUGIN_ID + ".resourceUpdate";

	public ModelResourceListener(CoreMultiDiagramEditor editor, ISaveAndDirtyService saveAndDirty, ModelSet modelSet) {
		isActive = true;
		this.modelSet = modelSet;
		this.editor = editor;
		// register lifecycle events related to "save": a reload should not be
		// proposed if the resource change was caused by a save of *this* editor,
		// hence the listener is temporary deactivated.
		if(saveAndDirty instanceof ILifeCycleEventsProvider) {
			ILifeCycleEventsProvider lifeCycleEvents = (ILifeCycleEventsProvider)saveAndDirty;
			lifeCycleEvents.addDoSaveListener(new ISaveEventListener() {

				public void doSave(DoSaveEvent event) {
					isActive = false;
				}

				public void doSaveAs(DoSaveEvent event) {
					isActive = false;
				}
			});
			lifeCycleEvents.addPostDoSaveListener(new ISaveEventListener() {

				public void doSave(DoSaveEvent event) {
					isActive = true;
				}

				public void doSaveAs(DoSaveEvent event) {
					isActive = true;
				}
			});
		}
	}

	/**
	 * The listener operation that is called by the workspace
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		if(isActive) {
			switch(event.getType()) {
			case IResourceChangeEvent.PRE_CLOSE:
			case IResourceChangeEvent.PRE_BUILD:
			case IResourceChangeEvent.POST_BUILD:
			case IResourceChangeEvent.PRE_DELETE:
				// do nothing (only handle change)
				break;
			case IResourceChangeEvent.POST_CHANGE:
				try {
					// delegate to visitor (event.getResource is typically null) and there
					// might be a tree of changed resources
					event.getDelta().accept(this);
				} catch (CoreException coreException) {
					log.error(coreException);
				}
				break;
			}
		}
	}

	/**
	 * A visitor for resource changes. Detects, whether a changed resource belongs to an opened editor
	 */
	public boolean visit(IResourceDelta delta) {
		if(!isActive) {
			// don't follow resource changes, once inactivated (either due to save or due to a pending user dialog) 
			return false;
		}
		IResource changedResource = delta.getResource();
		boolean resourceOfMainModelChanged = false;
		// only proceed in case of Files (not projects, folders, ...) for the moment
		if(!(changedResource instanceof IFile)) {
			return true;
		}
		final String changedResourcePath = changedResource.getFullPath().toString();
		IPath changedResourcePathWOExt = changedResource.getFullPath().removeFileExtension();
		URIConverter uriConverter = modelSet.getURIConverter();

		for(Resource resource : modelSet.getResources()) {
			URI uri = resource.getURI();
			URI normalizedURI = uriConverter.normalize(uri);

			// URI path is prefixed with /resource or /plugin (registered model), therefore compare with
			// endsWith.
			// Comparison is done on path level since resource and changedResource are never
			// identical. The latter is a generic system resource (File, ...), the former a
			// model-aware representation of the resource
			if(normalizedURI.path().endsWith(changedResourcePath)) {
				if(changedResourcePathWOExt.equals(modelSet.getFilenameWithoutExtension())) {
					// model itself has changed. Ask user
					resourceOfMainModelChanged = true;
					break;
				}
				// changed resource does not belong to the model, it might however belong to a referenced
				// model. Since the referenced model is not editable, it can be unloaded without asking
				// the user (it will be reloaded on demand)
				if(resource.isLoaded()) {
					resource.unload();
				}
			}
		}
		if(!resourceOfMainModelChanged) {
			return true;
		}
		switch(delta.getKind()) {
		case IResourceDelta.ADDED:
			break;
		case IResourceDelta.REMOVED:
			// asynchronous notification to avoid that the removal of multiple resource files
			// belonging to the editor (e.g. .uml and .notation) at the same time leads to multiple
			// user feedback.
			isActive = false;
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {

					MessageDialog.openInformation(new Shell(), "Resource removal", "The resource " + changedResourcePath + " that is in use by a Papyrus editor has been removed. Use save/save as, if you want to keep the model");
					isActive = true;
				}
			});
			break;
		case IResourceDelta.CHANGED:
			// reopen the editor asynchronously to avoid that changes of multiple resource files
			// belonging to the editor (e.g. .uml and .notation) lead to multiple reloads.
			// de-activate until user responds to message dialog 
			isActive = false;
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {

					String message = "The resource " + changedResourcePath + " that is in use by a Papyrus editor has changed. Do you want to reopen the editor in order to update its contents?";
					if(editor.isDirty()) {
						message += " CAVEAT: the editor contains unsaved modifications that would be lost.";
					}

					if(MessageDialog.openQuestion(new Shell(), "Resource change", message)) {
						// unloading and reloading all resources of the main causes the following problems
						//  - since resources are removed during the modelSets unload operation, the call eResource().getContents ()
						//    used by the model explorer leads to a null pointer exception
						//  - diagrams in model explorer are not shown
						//  - would need to reset dirty flags
						// => clean & simple option is to close and reopen the editor.

						IWorkbench wb = PlatformUI.getWorkbench();
						IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
						IEditorInput input = editor.getEditorInput();
						page.closeEditor(editor, false);
						try {
							IEditorDescriptor desc = wb.getEditorRegistry().getDefaultEditor(input.getName());
							page.openEditor(input, desc.getId(), false);
						} catch (PartInitException e) {
							log.error(e);
						}
					} else {
						// response "no" => don't reload and reactivate listener
						isActive = true;
					}
				}
			});
			break;
		}
		return true; // visit the children
	}

	private boolean isActive;

	private CoreMultiDiagramEditor editor;

	private ModelSet modelSet;
}
