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
 *  Ansgar Radermacherr (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
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
import org.eclipse.papyrus.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.core.lifecycleevents.ISaveEventListener;
import org.eclipse.papyrus.resource.ModelMultiException;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.swt.widgets.Shell;

/**
 * A listener for resource changes, used to trigger an update of
 * models whose underlying resources have been changed.
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
public class ModelResourceListener implements IResourceChangeListener, IResourceDeltaVisitor {

	public static final String RESOURCE_UPDATE_ID = Activator.PLUGIN_ID + ".resourceUpdate";

	public ModelResourceListener (ISaveAndDirtyService saveAndDirty, ModelSet modelSet) {
		isActive = true;
		this.modelSet = modelSet;
		this.saveAndDirty = saveAndDirty;
		// register lifecycle events around save: a reload should not be
		// proposed if the resource change was caused by a save of *this* editor,
		// hence the listener is temporary deactivated.
		if (saveAndDirty instanceof ILifeCycleEventsProvider) {
			ILifeCycleEventsProvider lifeCycleEvents =
				(ILifeCycleEventsProvider) saveAndDirty;
			lifeCycleEvents.addDoSaveListener (new ISaveEventListener () {
				@Override
				public void doSave(DoSaveEvent event) {
					isActive = false;
				}

				@Override
				public void doSaveAs(DoSaveEvent event) {
				}
			});
			lifeCycleEvents.addPostDoSaveListener (new ISaveEventListener () {
				@Override
				public void doSave(DoSaveEvent event) {
					isActive = true;
				}

				@Override
				public void doSaveAs(DoSaveEvent event) {
				}
			});
		}
	}
	
	/**
	 * The listener operation that is called by the workspace
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		if (isActive) {
			switch (event.getType()) {
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
					event.getDelta().accept (this);
				}
				catch (CoreException coreException) {
					log.error (coreException);
				}
	            break;
			}
		}
	}
	
	/**
	 * A visitor for resource changes. Detects, whether a changed resource belongs to an opened editor
	 */
	public boolean visit(IResourceDelta delta) {
		IResource changedResource = delta.getResource();
		boolean changeInMainModelDetected = false;
		// only proceed in case of Files (not projects, folders, ...) for the moment
		if (!(changedResource instanceof IFile)) {
			return true;
		}
		String changedResourcePath = changedResource.getFullPath().toString();
		IPath changedResourcePathWOExt = changedResource.getFullPath().removeFileExtension();
		URIConverter uriConverter = modelSet.getURIConverter();

		for (Resource resource : modelSet.getResources()) {
			URI uri = resource.getURI();
			URI normalizedURI = uriConverter.normalize(uri);

			// URI path is prefixed with /resource or /plugin (registered model), therefore compare with
			// endsWith.
			// Comparison is done on path level since resource and changedResource are never
			// identical. The latter is a generic system resource (File, ...), the former a
			// model-aware representation of the resource
			if (normalizedURI.path().endsWith(changedResourcePath)) {
				if (changedResourcePathWOExt.equals (modelSet.getFilenameWithoutExtension ())) {
					// model itself has changed. Ask user
					changeInMainModelDetected = true;
					break;
				}
				// changed resource does not belong to the model, it might however belong to a referenced
				// model. Since the referenced model is not editable, it can be unloaded without asking
				// the user (it will be reloaded on demand)
				if (resource.isLoaded ()) {
					resource.unload ();
				}
			}
		}
		if (!changeInMainModelDetected) {
			return true;
		}
		switch (delta.getKind()) {
		case IResourceDelta.ADDED:
			break;
		case IResourceDelta.REMOVED:
			Shell shellR = new Shell();
			MessageDialog.openInformation (shellR,
					"Resource removal",
					"The resource " + changedResourcePath + " that is in use by a Papyrus editor has been removed. Use save/save as, if you want to keep the model");
			break;
		case IResourceDelta.CHANGED:
			Shell shellC = new Shell();
			boolean ok;
			if (saveAndDirty.isDirty ()) {
				ok = MessageDialog.openQuestion (
					shellC, "Resource change",
					"The resource " + changedResource.getFullPath() +
					" that is in use by a Papyrus editor has changed. However, local changes have been made and would be lost during the reload. Do you want to reload this resource?");
			}
			else {
				ok = MessageDialog.openConfirm (
					shellC, "Resource change",
					"The resource " + changedResource.getFullPath() +
					" that is in use by a Papyrus editor has changed. Do you want to reload this resource?");
			}
			if (ok) {
				try {
					modelSet.unload();
					modelSet.loadModels();
				} catch (ModelMultiException me) {
					log.error (me);
				}
			}
			break;
		}
		return true; // visit the children
	}
		
	private boolean isActive;
	
	private ISaveAndDirtyService saveAndDirty;
	private ModelSet modelSet;
}
