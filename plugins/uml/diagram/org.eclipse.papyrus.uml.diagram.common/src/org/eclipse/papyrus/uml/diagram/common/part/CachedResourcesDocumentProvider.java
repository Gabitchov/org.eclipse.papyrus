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
package org.eclipse.papyrus.uml.diagram.common.part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.EditorStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.util.MDTUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

// TODO: Auto-generated Javadoc
/**
 * Provides support to keep the <ResourceSet> unloaded when changing the <IEditorInput> or contents
 * of the <Document>. Will be shared among several <IEditorPart>s using the same <EditingDomain> and
 * the same <Resource>.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class CachedResourcesDocumentProvider extends AbstractDocumentProvider implements IDiagramDocumentProvider {

	// //
	// XXX: keep resource in dispose
	/** The unload on dispose. */
	private boolean unloadOnDispose = true;

	/**
	 * The editing domain identifier.
	 */
	private String editingDomainID = null;

	/**
	 * Resource changes because of a save
	 */
	private boolean changingResourceBySave = true;

	@Deprecated
	public CachedResourcesDocumentProvider() {
		editingDomainID = "";
		return;
	}

	public CachedResourcesDocumentProvider(String editingDomainID) {
		this.editingDomainID = editingDomainID;
	}

	/**
	 * Checks if is unload on dispose.
	 * 
	 * @return true, if is unload on dispose
	 */
	// @unused
	public boolean isUnloadOnDispose() {
		return unloadOnDispose;
	}

	/**
	 * Sets the unload on dispose.
	 * 
	 * @param unloadOnDispose
	 *        the new unload on dispose
	 */
	public void setUnloadOnDispose(boolean unloadOnDispose) {
		this.unloadOnDispose = unloadOnDispose;
	}

	synchronized public void setChangingResourceBySave(boolean changingResourceBySave) {
		this.changingResourceBySave = changingResourceBySave;
	}

	public boolean isChangingResourceBySave() {
		return changingResourceBySave;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.diagram.ui.resources.editor.document.
	 * AbstractDocumentProvider#disposeElementInfo(java.lang.Object,
	 * org.eclipse.
	 * gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider
	 * .ElementInfo)
	 */
	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		if(info instanceof CachedResourceSetInfo) {
			CachedResourceSetInfo resourceSetInfo = (CachedResourceSetInfo)info;
			resourceSetInfo.disposeButUnload();
		}
		super.disposeElementInfo(element, info);
	}

	/**
	 * Creates the editing domain.
	 * 
	 * @param editorInput
	 *        the editor input
	 * 
	 * @return the transactional editing domain
	 */
	protected TransactionalEditingDomain createEditingDomain(IEditorInput editorInput) {
		String id = getEditingDomainID();
		String uri = null;

		if(editorInput instanceof FileEditorInput) {
			uri = ((FileEditorInput)editorInput).getPath().toString();
			uri = MDTUtil.fullFilePathToResourceURI(uri).toString();
		} else if(editorInput instanceof URIEditorInput) {
			uri = ((URIEditorInput)editorInput).getURI().trimFragment().toString();
		}
		TransactionalEditingDomain editingDomain = EditingDomainRegistry.getInstance().get(id, uri);
		return editingDomain;
	}

	/**
	 * Compute modification stamp.
	 * 
	 * @param info
	 *        the info
	 * 
	 * @return the long
	 */
	protected long computeModificationStamp(CachedResourceSetInfo info) {
		int result = 0;
		for(Object element : info.getResourceSet().getResources()) {
			Resource nextResource = (Resource)element;
			IFile file = WorkspaceSynchronizer.getFile(nextResource);
			if(file != null) {
				if(file.getLocation() != null) {
					result += file.getLocation().toFile().lastModified();
				} else {
					result += file.getModificationStamp();
				}
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.diagram.ui.resources.editor.document.
	 * AbstractDocumentProvider#createEmptyDocument()
	 */
	@Override
	protected IDocument createEmptyDocument() {
		DiagramDocument document = new DiagramDocument();
		document.setEditingDomain(createEditingDomain(null));
		return document;
	}

	/**
	 * Creates the empty document.
	 * 
	 * @param editorInput
	 *        the editor input
	 * 
	 * @return the i document
	 */
	protected IDocument createEmptyDocument(IEditorInput editorInput) {
		DiagramDocument document = new DiagramDocument();
		document.setEditingDomain(createEditingDomain(editorInput));
		return document;
	}

	// //
	// XXX:
	/**
	 * The Class CachedResourceSetInfo.
	 */
	protected class CachedResourceSetInfo extends AbstractDocumentProvider.ElementInfo {

		/** The my modification stamp. */
		private long myModificationStamp = IResource.NULL_STAMP;

		/** The my synchronizer. */
		private WorkspaceSynchronizer mySynchronizer;

		/** The my un synchronized resources. */
		private final Collection myUnSynchronizedResources = new ArrayList();

		/** The my document. */
		private final IDiagramDocument myDocument;

		/** The my editor input. */
		private final IEditorInput myEditorInput;

		/** The my update cache. */
		private boolean myUpdateCache = true;

		/** The my modifiable. */
		private boolean myModifiable = false;

		/** The my read only. */
		private boolean myReadOnly = true;

		/** The my resource set listener. */
		private final ResourceSetModificationListener myResourceSetListener;

		/**
		 * Instantiates a new cached resource set info.
		 * 
		 * @param document
		 *        the document
		 * @param editorInput
		 *        the editor input
		 */
		public CachedResourceSetInfo(IDiagramDocument document, IEditorInput editorInput) {
			super(document);
			myDocument = document;
			myEditorInput = editorInput;
			startResourceListening();
			myResourceSetListener = new ResourceSetModificationListener(this);
			getResourceSet().eAdapters().add(myResourceSetListener);
		}

		/**
		 * Gets the modification stamp.
		 * 
		 * @return the modification stamp
		 */
		// @unused
		public long getModificationStamp() {
			return myModificationStamp;
		}

		/**
		 * Sets the modification stamp.
		 * 
		 * @param modificationStamp
		 *        the modification stamp
		 */
		public void setModificationStamp(long modificationStamp) {
			myModificationStamp = modificationStamp;
		}

		/**
		 * Gets the editing domain.
		 * 
		 * @return the editing domain
		 */
		public TransactionalEditingDomain getEditingDomain() {
			return myDocument.getEditingDomain();
		}

		/**
		 * Gets the resource set.
		 * 
		 * @return the resource set
		 */
		public ResourceSet getResourceSet() {
			return getEditingDomain().getResourceSet();
		}

		/**
		 * Gets the editor input.
		 * 
		 * @return the editor input
		 */
		public IEditorInput getEditorInput() {
			return myEditorInput;
		}

		/**
		 * Dispose.
		 */
		public void disposeButUnload() {
			stopResourceListening();
			getResourceSet().eAdapters().remove(myResourceSetListener);
		}

		/**
		 * Dispose.
		 */
		// @unused
		public void dispose() {
			stopResourceListening();
			getResourceSet().eAdapters().remove(myResourceSetListener);
			for(Object element : getResourceSet().getResources()) {
				Resource resource = (Resource)element;
				resource.unload();
			}
		}

		/**
		 * Checks if is synchronized.
		 * 
		 * @return true, if checks if is synchronized
		 */
		public boolean isSynchronized() {
			return myUnSynchronizedResources.size() == 0;
		}

		/**
		 * Sets the un synchronized.
		 * 
		 * @param resource
		 *        the resource
		 */
		public void setUnSynchronized(Resource resource) {
			myUnSynchronizedResources.add(resource);
		}

		/**
		 * Sets the synchronized.
		 * 
		 * @param resource
		 *        the resource
		 */
		public void setSynchronized(Resource resource) {
			myUnSynchronizedResources.remove(resource);
		}

		/**
		 * Stop resource listening.
		 */
		public final void stopResourceListening() {
			mySynchronizer.dispose();
			mySynchronizer = null;
		}

		/**
		 * Start resource listening.
		 */
		public final void startResourceListening() {
			mySynchronizer = new WorkspaceSynchronizer(getEditingDomain(), new SynchronizerDelegate());
		}

		/**
		 * Checks if is update cache.
		 * 
		 * @return true, if checks if is update cache
		 */
		public boolean isUpdateCache() {
			return myUpdateCache;
		}

		/**
		 * Sets the update cache.
		 * 
		 * @param update
		 *        the update
		 */
		public void setUpdateCache(boolean update) {
			myUpdateCache = update;
		}

		/**
		 * Checks if is modifiable.
		 * 
		 * @return true, if checks if is modifiable
		 */
		public boolean isModifiable() {
			return myModifiable;
		}

		/**
		 * Sets the modifiable.
		 * 
		 * @param modifiable
		 *        the modifiable
		 */
		public void setModifiable(boolean modifiable) {
			myModifiable = modifiable;
		}

		/**
		 * Checks if is read only.
		 * 
		 * @return true, if checks if is read only
		 */
		public boolean isReadOnly() {
			return myReadOnly;
		}

		/**
		 * Sets the read only.
		 * 
		 * @param readOnly
		 *        the read only
		 */
		public void setReadOnly(boolean readOnly) {
			myReadOnly = readOnly;
		}

		/**
		 * Gets the loaded resources iterator.
		 * 
		 * @return the loaded resources iterator
		 */
		public Iterator getLoadedResourcesIterator() {
			return new ArrayList(getResourceSet().getResources()).iterator();
		}

		/**
		 * The Class SynchronizerDelegate.
		 */
		private class SynchronizerDelegate implements WorkspaceSynchronizer.Delegate {

			/**
			 * Dispose.
			 */
			public void dispose() {
			}

			/**
			 * Handle resource changed.
			 * 
			 * @param resource
			 *        the resource
			 * 
			 * @return true, if handle resource changed
			 */
			public boolean handleResourceChanged(final Resource resource) {
				synchronized(CachedResourceSetInfo.this) {
					// fjcano : if we are changing the resource in an internal
					// save, we need not mark it as unsynchronized or reload the
					// resource.
					if(CachedResourcesDocumentProvider.this.isChangingResourceBySave()) {
						return true;
					}
					// fjcano : if we get here the resource was modified
					// externally.
					if(CachedResourceSetInfo.this.fCanBeSaved) {
						CachedResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						handleElementChanged(CachedResourceSetInfo.this, resource, null);
					}
				});
				return true;
			}

			/**
			 * Handle resource deleted.
			 * 
			 * @param resource
			 *        the resource
			 * 
			 * @return true, if handle resource deleted
			 */
			public boolean handleResourceDeleted(Resource resource) {
				synchronized(CachedResourceSetInfo.this) {
					if(CachedResourceSetInfo.this.fCanBeSaved) {
						CachedResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						fireElementDeleted(CachedResourceSetInfo.this.getEditorInput());
					}
				});
				return true;
			}

			/**
			 * Handle resource moved.
			 * 
			 * @param resource
			 *        the resource
			 * @param newURI
			 *        the new uri
			 * 
			 * @return true, if handle resource moved
			 */
			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				synchronized(CachedResourceSetInfo.this) {
					if(CachedResourceSetInfo.this.fCanBeSaved) {
						CachedResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				if(myDocument.getDiagram().eResource() == resource) {
					Display.getDefault().asyncExec(new Runnable() {

						public void run() {
							handleElementMoved(CachedResourceSetInfo.this.getEditorInput(), newURI);
						}
					});
				} else {
					handleResourceDeleted(resource);
				}
				return true;
			}

		}

	}

	/**
	 * The listener interface for receiving resourceSetModification events. The
	 * class that is interested in processing a resourceSetModification event
	 * implements this interface, and the object created with that class is
	 * registered with a component using the component's <code>addResourceSetModificationListener<code> method. When
	 * the resourceSetModification event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see ResourceSetModificationEvent
	 */
	private class ResourceSetModificationListener extends EContentAdapter {

		/** The my modified filter. */
		private final NotificationFilter myModifiedFilter;

		/** The my info. */
		private final CachedResourceSetInfo myInfo;

		/**
		 * The Constructor.
		 * 
		 * @param info
		 *        the info
		 */
		public ResourceSetModificationListener(CachedResourceSetInfo info) {
			myInfo = info;
			myModifiedFilter = NotificationFilter.createEventTypeFilter(Notification.SET).or(NotificationFilter.createEventTypeFilter(Notification.UNSET)).and(NotificationFilter.createFeatureFilter(Resource.class, Resource.RESOURCE__IS_MODIFIED));
		}

		/**
		 * Notify changed.
		 * 
		 * @param notification
		 *        the notification
		 */
		@Override
		public void notifyChanged(Notification notification) {
			if(notification.getNotifier() instanceof ResourceSet) {
				super.notifyChanged(notification);
			}
			if(!notification.isTouch() && myModifiedFilter.matches(notification)) {
				if(notification.getNotifier() instanceof Resource) {
					Resource resource = (Resource)notification.getNotifier();
					if(resource.isLoaded()) {
						boolean modified = false;
						for(Iterator it = myInfo.getResourceSet().getResources().iterator(); it.hasNext() && !modified;) {
							Resource nextResource = (Resource)it.next();
							if(nextResource.isLoaded()) {
								modified = nextResource.isModified();
							}
						}
						boolean dirtyStateChanged = false;
						synchronized(myInfo) {
							if(modified != myInfo.fCanBeSaved) {
								myInfo.fCanBeSaved = modified;
								dirtyStateChanged = true;
							}
							if(!resource.isModified()) {
								myInfo.setSynchronized(resource);
							}
						}
						if(dirtyStateChanged) {
							fireElementDirtyStateChanged(myInfo.getEditorInput(), modified);

							if(!modified) {
								myInfo.setModificationStamp(computeModificationStamp(myInfo));
							}
						}
					}
				}
			}
		}

	}

	// // General and common DocumentProvider code for GMF diagrams ////

	@Override
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		if(false == element instanceof FileEditorInput && false == element instanceof URIEditorInput) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.ID, 0, NLS.bind("Messages.SqlmodelDocumentProvider_IncorrectInputError", new Object[]{ element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
			null));
		}
		IEditorInput editorInput = (IEditorInput)element;
		IDiagramDocument document = (IDiagramDocument)createDocument(editorInput);

		CachedResourceSetInfo info = new CachedResourceSetInfo(document, editorInput);
		info.setModificationStamp(computeModificationStamp(info));
		info.fStatus = null;
		return info;
	}

	@Override
	protected IDocument createDocument(Object element) throws CoreException {
		if(false == element instanceof FileEditorInput && false == element instanceof URIEditorInput) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.ID, 0, NLS.bind("Messages.SqlmodelDocumentProvider_IncorrectInputError", new Object[]{ element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
			null));
		}
		IDocument document = createEmptyDocument((IEditorInput)element);
		setDocumentContent(document, (IEditorInput)element);
		setupDocument(element, document);
		return document;
	}

	/**
	 * Sets up the given document as it would be provided for the given element.
	 * The content of the document is not changed. This default implementation
	 * is empty. Subclasses may reimplement.
	 */
	protected void setupDocument(Object element, IDocument document) {
		// for subclasses
	}

	protected void setDocumentContent(IDocument document, IEditorInput element) throws CoreException {
		IDiagramDocument diagramDocument = (IDiagramDocument)document;
		TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
		if(element instanceof FileEditorInput) {
			IStorage storage = ((FileEditorInput)element).getStorage();
			Diagram diagram = DiagramIOUtil.load(domain, storage, true, getProgressMonitor());
			document.setContent(diagram);
		} else if(element instanceof URIEditorInput) {
			URI uri = ((URIEditorInput)element).getURI();
			Resource resource = null;
			try {
				resource = domain.getResourceSet().getResource(uri.trimFragment(), false);
				if(resource == null) {
					resource = domain.getResourceSet().createResource(uri.trimFragment());
				}
				if(!resource.isLoaded()) {
					try {
						Map options = new HashMap(GMFResourceFactory.getDefaultLoadOptions());
						resource.load(options);
					} catch (IOException e) {
						resource.unload();
						throw e;
					}
				}
				if(uri.fragment() != null) {
					EObject rootElement = resource.getEObject(uri.fragment());
					if(rootElement instanceof Diagram) {
						document.setContent(rootElement);
						return;
					}
				} else {
					for(Object rootElement : resource.getContents()) {
						if(rootElement instanceof Diagram) {
							document.setContent(rootElement);
							return;
						}
					}
				}
				throw new RuntimeException("Messages.SqlmodelDocumentProvider_NoDiagramInResourceError");
			} catch (Exception e) {
				CoreException thrownExcp = null;
				if(e instanceof CoreException) {
					thrownExcp = (CoreException)e;
				} else {
					String msg = e.getLocalizedMessage();
					thrownExcp = new CoreException(new Status(IStatus.ERROR, Activator.ID, 0, msg != null ? msg : "Messages.SqlmodelDocumentProvider_DiagramLoadingError", e));
				}
				throw thrownExcp;
			}
		} else {
			throw new CoreException(new Status(IStatus.ERROR, Activator.ID, 0, NLS.bind("Messages.SqlmodelDocumentProvider_IncorrectInputError", new Object[]{ element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
			null));
		}
	}

	@Override
	public long getModificationStamp(Object element) {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			return computeModificationStamp(info);
		}
		return super.getModificationStamp(element);
	}

	@Override
	public boolean isDeleted(Object element) {
		IDiagramDocument document = getDiagramDocument(element);
		if(document != null) {
			Resource diagramResource = document.getDiagram().eResource();
			if(diagramResource != null) {
				IFile file = WorkspaceSynchronizer.getFile(diagramResource);
				return file == null || file.getLocation() == null || !file.getLocation().toFile().exists();
			}
		}
		return super.isDeleted(element);
	}

	public CachedResourceSetInfo getResourceSetInfo(Object editorInput) {
		return (CachedResourceSetInfo)super.getElementInfo(editorInput);
	}

	@Override
	protected void doValidateState(Object element, Object computationContext) throws CoreException {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			Collection files2Validate = new ArrayList();
			for(Iterator it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource)it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if(file != null && file.isReadOnly()) {
					files2Validate.add(file);
				}
			}
			ResourcesPlugin.getWorkspace().validateEdit((IFile[])files2Validate.toArray(new IFile[files2Validate.size()]), computationContext);
		}

		super.doValidateState(element, computationContext);
	}

	@Override
	public boolean isReadOnly(Object element) {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			if(info.isUpdateCache()) {
				try {
					updateCache(element);
				} catch (CoreException ex) {
					Activator.getDefault().logError("Messages.SqlmodelDocumentProvider_isModifiable", ex);
				}
			}
			return info.isReadOnly();
		}
		return super.isReadOnly(element);
	}

	@Override
	public boolean isModifiable(Object element) {
		if(!isStateValidated(element)) {
			if(element instanceof FileEditorInput || element instanceof URIEditorInput) {
				return true;
			}
		}
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			if(info.isUpdateCache()) {
				try {
					updateCache(element);
				} catch (CoreException ex) {
					Activator.getDefault().logError("Messages.SqlmodelDocumentProvider_isModifiable", ex);
				}
			}
			return info.isModifiable();
		}
		return super.isModifiable(element);
	}

	protected void updateCache(Object element) throws CoreException {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			for(Iterator it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource)it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if(file != null && file.isReadOnly()) {
					info.setReadOnly(true);
					info.setModifiable(false);
					return;
				}
			}
			info.setReadOnly(false);
			info.setModifiable(true);
			return;
		}
	}

	@Override
	protected void doUpdateStateCache(Object element) throws CoreException {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			info.setUpdateCache(true);
		}
		super.doUpdateStateCache(element);
	}

	@Override
	public boolean isSynchronized(Object element) {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			return info.isSynchronized();
		}
		return super.isSynchronized(element);
	}

	@Override
	protected ISchedulingRule getResetRule(Object element) {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			Collection rules = new ArrayList();
			for(Iterator it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource)it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if(file != null) {
					rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[])rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	@Override
	protected ISchedulingRule getSaveRule(Object element) {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			Collection rules = new ArrayList();
			for(Iterator it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource)it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if(file != null) {
					rules.add(computeSchedulingRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[])rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	@Override
	protected ISchedulingRule getSynchronizeRule(Object element) {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			Collection rules = new ArrayList();
			for(Iterator it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource)it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if(file != null) {
					rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().refreshRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[])rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	@Override
	protected ISchedulingRule getValidateStateRule(Object element) {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			Collection files = new ArrayList();
			for(Iterator it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource)it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if(file != null) {
					files.add(file);
				}
			}
			return ResourcesPlugin.getWorkspace().getRuleFactory().validateEditRule((IFile[])files.toArray(new IFile[files.size()]));
		}
		return null;
	}

	private ISchedulingRule computeSchedulingRule(IResource toCreateOrModify) {
		if(toCreateOrModify.exists()) {
			return ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(toCreateOrModify);
		}

		IResource parent = toCreateOrModify;
		do {
			toCreateOrModify = parent;
			parent = toCreateOrModify.getParent();
		} while(parent != null && !parent.exists());

		return ResourcesPlugin.getWorkspace().getRuleFactory().createRule(toCreateOrModify);
	}

	@Override
	protected void doSynchronize(Object element, IProgressMonitor monitor) throws CoreException {
		CachedResourceSetInfo info = getResourceSetInfo(element);
		if(info != null) {
			for(Iterator it = info.getLoadedResourcesIterator(); it.hasNext();) {
				Resource nextResource = (Resource)it.next();
				handleElementChanged(info, nextResource, monitor);
			}
			return;
		}
		super.doSynchronize(element, monitor);
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		try {
			// fjcano : we are modifying the resource by an internal save.
			setChangingResourceBySave(true);
			CachedResourceSetInfo info = getResourceSetInfo(element);
			if(info != null) {
				if(!overwrite && !info.isSynchronized()) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.ID, IResourceStatus.OUT_OF_SYNC_LOCAL, "Messages.SqlmodelDocumentProvider_UnsynchronizedFileSaveError", null));
				}
				info.stopResourceListening();
				fireElementStateChanging(element);
				try {
					monitor.beginTask("Messages.SqlmodelDocumentProvider_SaveDiagramTask", info.getResourceSet().getResources().size() + 1); // "Saving diagram"
					for(Iterator it = info.getLoadedResourcesIterator(); it.hasNext();) {
						Resource nextResource = (Resource)it.next();
						monitor.setTaskName(NLS.bind("Messages.SqlmodelDocumentProvider_SaveNextResourceTask", nextResource.getURI()));
						if(nextResource.isLoaded() && !info.getEditingDomain().isReadOnly(nextResource)) {
							try {
								nextResource.save(MDTUtil.getSaveOptions());
							} catch (IOException e) {
								fireElementStateChangeFailed(element);
								throw new CoreException(new Status(IStatus.ERROR, Activator.ID, EditorStatusCodes.RESOURCE_FAILURE, e.getLocalizedMessage(), null));
							}
						}
						monitor.worked(1);
					}
					monitor.done();
					info.setModificationStamp(computeModificationStamp(info));
				} catch (RuntimeException x) {
					fireElementStateChangeFailed(element);
					throw x;
				} finally {
					info.startResourceListening();
				}
			} else {
				URI newResoruceURI;
				List affectedFiles = null;
				if(element instanceof FileEditorInput) {
					IFile newFile = ((FileEditorInput)element).getFile();
					affectedFiles = Collections.singletonList(newFile);
					newResoruceURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
				} else if(element instanceof URIEditorInput) {
					newResoruceURI = ((URIEditorInput)element).getURI();
				} else {
					fireElementStateChangeFailed(element);
					throw new CoreException(new Status(IStatus.ERROR, Activator.ID, 0, NLS.bind("Messages.SqlmodelDocumentProvider_IncorrectInputError", new Object[]{ element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
					null));
				}
				if(false == document instanceof IDiagramDocument) {
					fireElementStateChangeFailed(element);
					throw new CoreException(new Status(IStatus.ERROR, Activator.ID, 0, "Incorrect document used: " + document + " instead of org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument", null)); //$NON-NLS-1$ //$NON-NLS-2$
				}
				IDiagramDocument diagramDocument = (IDiagramDocument)document;
				final Resource newResource = diagramDocument.getEditingDomain().getResourceSet().createResource(newResoruceURI);
				final Diagram diagramCopy = (Diagram)EcoreUtil.copy(diagramDocument.getDiagram());
				try {
					new AbstractTransactionalCommand(diagramDocument.getEditingDomain(), NLS.bind("Messages.SqlmodelDocumentProvider_SaveAsOperation", diagramCopy.getName()), affectedFiles) {

						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							newResource.getContents().add(diagramCopy);
							return CommandResult.newOKCommandResult();
						}
					}.execute(monitor, null);
					newResource.save(MDTUtil.getSaveOptions());
				} catch (ExecutionException e) {
					fireElementStateChangeFailed(element);
					throw new CoreException(new Status(IStatus.ERROR, Activator.ID, 0, e.getLocalizedMessage(), null));
				} catch (IOException e) {
					fireElementStateChangeFailed(element);
					throw new CoreException(new Status(IStatus.ERROR, Activator.ID, 0, e.getLocalizedMessage(), null));
				}
				newResource.unload();
			}
		} finally {
			// fjcano : the internal modification ended.
			setChangingResourceBySave(false);
		}
	}

	protected void handleElementChanged(CachedResourceSetInfo info, Resource changedResource, IProgressMonitor monitor) {
		if(isChangingResourceBySave() == false) {
			IFile file = WorkspaceSynchronizer.getFile(changedResource);
			if(file != null) {
				try {
					file.refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} catch (CoreException ex) {
					Activator.getDefault().logError("Messages.SqlmodelDocumentProvider_handleElementContentChanged", ex);
				}
			}
			changedResource.unload();

			fireElementContentAboutToBeReplaced(info.getEditorInput());
			removeUnchangedElementListeners(info.getEditorInput(), info);
			info.fStatus = null;
			try {
				setDocumentContent(info.fDocument, info.getEditorInput());
			} catch (CoreException e) {
				info.fStatus = e.getStatus();
			}
			if(!info.fCanBeSaved) {
				info.setModificationStamp(computeModificationStamp(info));
			}
			addUnchangedElementListeners(info.getEditorInput(), info);
			fireElementContentReplaced(info.getEditorInput());
		}
	}

	protected void handleElementMoved(IEditorInput input, URI uri) {
		if(input instanceof FileEditorInput) {
			IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(URI.decode(uri.path())).removeFirstSegments(1));
			fireElementMoved(input, newFile == null ? null : new FileEditorInput(newFile));
			return;
		}
		// TODO: append suffix to the URI! (use diagram as a parameter)
		fireElementMoved(input, new URIEditorInput(uri));
	}

	public IEditorInput createInputWithEditingDomain(IEditorInput editorInput, TransactionalEditingDomain domain) {
		return editorInput;
	}

	public IDiagramDocument getDiagramDocument(Object element) {
		IDocument doc = getDocument(element);
		if(doc instanceof IDiagramDocument) {
			return (IDiagramDocument)doc;
		}
		return null;
	}

	@Override
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}

	protected String getEditingDomainID() {
		return editingDomainID;
	}

}
