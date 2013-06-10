/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - manage models by URI, not IFile (CDO)
 *  Christian W. Damus (CEA) - don't rely on IMarker changes to refresh Model Explorer labels (CDO)
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.resourceupdate;

import static org.eclipse.papyrus.uml.diagram.common.Activator.log;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Profile;

/**
 * A listener for resource changes, used to trigger an update of models whose
 * underlying resources have been changed.
 * 
 * @author Ansgar Radermacher (CEA LIST)
 * 
 * @deprecated The equivalent behavior has been implemented in oep.infra.core
 */
@Deprecated
public class ResourceUpdateService implements IService, IResourceChangeListener, IResourceDeltaVisitor {

	public static final String RESOURCE_UPDATE_ID = Activator.ID + ".resourceUpdate";

	// public init (CoreMultiDiagramEditor editor, ISaveAndDirtyService
	// saveAndDirty, ModelSet modelSet) {
	public void init(ServicesRegistry serviceRegistry) throws ServiceException {
		modelSet = serviceRegistry.getService(ModelSet.class);
		editor = serviceRegistry.getService(IMultiDiagramEditor.class);
		ILifeCycleEventsProvider lcEventsProvider = serviceRegistry.getService(ILifeCycleEventsProvider.class);
		saveListener = new SaveListener();
		lcEventsProvider.addDoSaveListener(saveListener.preSaveListener);
		lcEventsProvider.addPostDoSaveListener(saveListener.postSaveListener);

		partActivationListener = new PartActivationListener(editor);
	}

	/**
	 * The listener operation that is called by the workspace
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		switch(event.getType()) {
		case IResourceChangeEvent.PRE_CLOSE:
		case IResourceChangeEvent.PRE_BUILD:
		case IResourceChangeEvent.POST_BUILD:
		case IResourceChangeEvent.PRE_DELETE:
			// do nothing (only handle change)
			break;
		case IResourceChangeEvent.POST_CHANGE:
			try {
				// delegate to visitor (event.getResource is typically null) and
				// there
				// might be a tree of changed resources
				event.getDelta().accept(this);
			} catch (CoreException coreException) {
				log.error(coreException);
			}
			break;
		}

	}

	/**
	 * A visitor for resource changes. Detects, whether a changed resource
	 * belongs to an opened editor
	 */
	public boolean visit(IResourceDelta delta) {
		IResource changedResource = delta.getResource();
		if(delta.getFlags() == IResourceDelta.MARKERS) {
			// only markers have been changed. The marker-listener service takes
			// care of this
			return false;
		}
		// only proceed in case of Files (not projects, folders, ...) for the
		// moment
		if(!(changedResource instanceof IFile)) {
			return true;
		}
		final String changedResourcePath = changedResource.getFullPath().toString();
		URI changedResourceURIWOExt = URI.createPlatformResourceURI(changedResource.getFullPath().toString(), true).trimFileExtension();
		URIConverter uriConverter = modelSet.getURIConverter();

		for(Resource resource : modelSet.getResources()) {
			URI uri = resource.getURI();
			URI normalizedURI = uriConverter.normalize(uri);

			// URI path is prefixed with /resource or /plugin (registered
			// model), therefore compare with
			// endsWith.
			// Comparison is done on path level since resource and
			// changedResource are never
			// identical. The latter is a generic system resource (File, ...),
			// the former a
			// model-aware representation of the resource
			if(normalizedURI.path().endsWith(changedResourcePath)) {
				if(changedResourceURIWOExt.equals(modelSet.getURIWithoutExtension())) {
					// model itself has changed.
					// mark main resource as changed. User will asked later,
					// when he activates the editor.
					if(!saveListener.isSaveActive()) {
						partActivationListener.setModificationData(changedResource.getFullPath(), delta, true, resource.isModified());
					}
				}
				// Changed resource does not belong to the model, it might however belong to a referenced model.
				// Since the referenced model may be editable (case of controlled sub-model with write access),
				// it must not be unloaded without asking the user. User will be asked when activating the editor.

				else if(resource.isLoaded()) {
					EList<EObject> contents = resource.getContents();
					if((contents.size() > 0) && (contents.get(0) instanceof Profile)) {
						// don't touch profiles
					} else if(!saveListener.isSaveActive()) {
						partActivationListener.setModificationData(changedResource.getFullPath(), delta, false, resource.isModified());
					}
				}
			}
		}
		return true;
	}

	private IMultiDiagramEditor editor;

	private ModelSet modelSet;

	// private ILifeCycleEventsProvider lifeCycleEvents;

	/**
	 * Activate the listeners. It will listen to resource changes and to changes
	 * of the active editor
	 */
	private void activate() {
		// ... add service to the workspace
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
		IWorkbenchPage page = editor.getSite().getPage();
		page.addPartListener(partActivationListener);
	}

	/**
	 * DeActivate the listeners.
	 */
	private void deactivate() {
		// remove it from workspace
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		IWorkbenchPage page = editor.getSite().getPage();
		page.removePartListener(partActivationListener);
	}

	public void startService() throws ServiceException {
		activate();
	}

	public void disposeService() throws ServiceException {
		deactivate();
		// lifeCycleEvents.removeDoSaveListener(listener);
	}

	private PartActivationListener partActivationListener;

	private SaveListener saveListener;
}
