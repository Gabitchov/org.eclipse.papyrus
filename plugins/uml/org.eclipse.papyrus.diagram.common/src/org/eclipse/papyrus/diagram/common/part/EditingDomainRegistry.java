/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.PathsUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

// TODO: Auto-generated Javadoc
/**
 * The Class EditingDomainRegistry.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class EditingDomainRegistry extends HashMap<String, TransactionalEditingDomain> implements IPartListener2 {

	/** The instance. */
	private static EditingDomainRegistry instance = null;

	/** The listening. */
	private boolean listening = false;

	/** The changing cached editors. */
	private boolean changingCachedEditors = false;

	/**
	 * Instantiates a new editing domain registry.
	 */
	private EditingDomainRegistry() {
		return;
	}

	/**
	 * Gets the single instance of EditingDomainRegistry.
	 * 
	 * @return single instance of EditingDomainRegistry
	 */
	public static EditingDomainRegistry getInstance() {
		if(instance == null) {
			instance = new EditingDomainRegistry();
		}
		return instance;
	}

	/**
	 * Start listening.
	 */
	private void startListening() {
		if(listening) {
			return;
		}
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(instance);
			listening = true;
		} catch (NullPointerException e) {
			;
		}
	}

	// //

	/**
	 * Calculate key.
	 * 
	 * @param editorID
	 *        the editor id
	 * @param uri
	 *        the uri
	 * 
	 * @return the string
	 */
	protected String calculateKey(String editorID, String uri) {
		uri = PathsUtil.fromAbsoluteFileSystemToAbsoluteWorkspace(uri);
		String key = ((uri != null) ? (editorID + uri) : editorID);
		return key;
	}

	/**
	 * Gets the.
	 * 
	 * @param editorID
	 *        the editor id
	 * @param uri
	 *        the uri
	 * 
	 * @return the transactional editing domain
	 */
	public TransactionalEditingDomain get(String editorID, String uri) {
		// we need to listen to editors closing
		startListening();
		// new get method
		String key = calculateKey(editorID, uri);
		TransactionalEditingDomain oldDomain = null;
		TransactionalEditingDomain newDomain = null;
		if(containsKey(key)) {
			oldDomain = super.get(key);
			oldDomain.getCommandStack().flush();
			return oldDomain;
		}
		newDomain = DiagramEditingDomainFactory.getInstance().createEditingDomain();
		newDomain.setID(editorID);
		final NotificationFilter diagramResourceModifiedFilter = NotificationFilter.createNotifierFilter(
				newDomain.getResourceSet()).and(NotificationFilter.createEventTypeFilter(Notification.ADD)).and(
				NotificationFilter.createFeatureFilter(ResourceSet.class, ResourceSet.RESOURCE_SET__RESOURCES));
		newDomain.getResourceSet().eAdapters().add(new Adapter() {

			private Notifier myTarget;

			public Notifier getTarget() {
				return myTarget;
			}

			public boolean isAdapterForType(Object type) {
				return false;
			}

			public void notifyChanged(Notification notification) {
				if(diagramResourceModifiedFilter.matches(notification)) {
					Object value = notification.getNewValue();
					if(value instanceof Resource) {
						((Resource)value).setTrackingModification(true);
					}
				}
			}

			public void setTarget(Notifier newTarget) {
				myTarget = newTarget;
			}

		});
		put(key, newDomain);
		return newDomain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.HashMap#get(java.lang.Object)
	 */
	@Override
	public TransactionalEditingDomain get(Object okey) {
		if(okey == null || okey instanceof String == false) {
			return null;
		}
		return get((String)okey, null);
	}

	/**
	 * Gets the uri from i editor input.
	 * 
	 * @param input
	 *        the input
	 * 
	 * @return the uri from i editor input
	 */
	private String getUriFromIEditorInput(IEditorInput input) {
		String uri = null;
		if(input instanceof FileEditorInput) {
			uri = ((FileEditorInput)input).getPath().toString();
			uri = MDTUtil.fullFilePathToResourceURI(uri).toString();
		} else if(input instanceof URIEditorInput) {
			uri = ((URIEditorInput)input).getURI().trimFragment().toString();
		}
		return uri;
	}

	/**
	 * Gets the iD from editor.
	 * 
	 * @param editor
	 *        the editor
	 * 
	 * @return the iD from editor
	 */
	private String getIDFromEditor(IEditorPart editor) {
		if(editor instanceof CachedResourcesDiagramEditor) {
			IDocumentProvider documentProvider = ((CachedResourcesDiagramEditor)editor).getDocumentProvider();
			if(documentProvider instanceof CachedResourcesDocumentProvider) {
				return ((CachedResourcesDocumentProvider)documentProvider).getEditingDomainID();
			}
		}
		return null;
	}

	/**
	 * Clean registry.
	 * 
	 * @param partReference
	 *        the part reference
	 */
	private void cleanRegistry(IWorkbenchPartReference partReference) {
		if(isChangingCachedEditors()) {
			return;
		}
		if(partReference instanceof IEditorReference) {
			List<IEditorReference> editors = new ArrayList<IEditorReference>();
			for(IEditorReference editorReference : partReference.getPage().getEditorReferences()) {
				editors.add(editorReference);
			}
			// editors.add((IEditorReference) partReference);
			cleanRegistry(editors);
		}
	}

	/**
	 * Clean registry.
	 * 
	 * @param editors
	 *        the editors
	 */
	private void cleanRegistry(List<IEditorReference> editors) {
		// get keys list from open editors
		List<String> keys = new ArrayList<String>();
		for(IEditorReference editor : editors) {
			IEditorPart editorPart = editor.getEditor(false);
			if(editorPart != null) {
				String uri = getUriFromIEditorInput(editorPart.getEditorInput());
				String id = getIDFromEditor(editorPart);
				String key = calculateKey(id, uri);
				keys.add(key);
			}
		}
		// find keys that are no longer in use
		List<String> keysToRemove = new ArrayList<String>();
		for(String key : keySet()) {
			if(keys.contains(key) == false) {
				keysToRemove.add(key);
			}
		}
		// remove unused keys
		for(Entry<String, TransactionalEditingDomain> entry : entrySet()) {
			if(keysToRemove.contains(entry.getKey())) {
				entry.getValue().dispose();
			}
		}
		for(String key : keysToRemove) {
			remove(key);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPartListener2#partActivated(org.eclipse.ui.IWorkbenchPartReference)
	 */
	public void partActivated(IWorkbenchPartReference partRef) {
		// nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
	 */
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		// nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPartListener2#partClosed(org.eclipse.ui.IWorkbenchPartReference)
	 */
	public void partClosed(IWorkbenchPartReference partRef) {
		cleanRegistry(partRef);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPartListener2#partDeactivated(org.eclipse.ui.IWorkbenchPartReference)
	 */
	public void partDeactivated(IWorkbenchPartReference partRef) {
		// nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPartListener2#partHidden(org.eclipse.ui.IWorkbenchPartReference)
	 */
	public void partHidden(IWorkbenchPartReference partRef) {
		// nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPartListener2#partInputChanged(org.eclipse.ui.IWorkbenchPartReference)
	 */
	public void partInputChanged(IWorkbenchPartReference partRef) {
		cleanRegistry(partRef);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPartListener2#partOpened(org.eclipse.ui.IWorkbenchPartReference)
	 */
	public void partOpened(IWorkbenchPartReference partRef) {
		// nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPartListener2#partVisible(org.eclipse.ui.IWorkbenchPartReference)
	 */
	public void partVisible(IWorkbenchPartReference partRef) {
		// nothing to do
	}

	/**
	 * Checks if is changing cached editors.
	 * 
	 * @return true, if is changing cached editors
	 */
	public boolean isChangingCachedEditors() {
		return changingCachedEditors;
	}

	/**
	 * Sets the changing cached editors.
	 * 
	 * @param changingCachedEditors
	 *        the new changing cached editors
	 */
	public void setChangingCachedEditors(boolean changingCachedEditors) {
		this.changingCachedEditors = changingCachedEditors;
	}
}
