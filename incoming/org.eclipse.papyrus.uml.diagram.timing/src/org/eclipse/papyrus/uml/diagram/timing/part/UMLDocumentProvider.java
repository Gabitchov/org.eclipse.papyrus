/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
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
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLDocumentProvider extends AbstractDocumentProvider implements IDiagramDocumentProvider {

	/**
	 * @generated
	 */
	@Override
	protected ElementInfo createElementInfo(final Object element) throws CoreException {
		if (false == element instanceof FileEditorInput && false == element instanceof URIEditorInput) {
			throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, NLS.bind(Messages.UMLDocumentProvider_IncorrectInputError,
					new Object[] { element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
					null));
		}
		final IEditorInput editorInput = (IEditorInput) element;
		final IDiagramDocument document = (IDiagramDocument) createDocument(editorInput);

		final ResourceSetInfo info = new ResourceSetInfo(document, editorInput);
		info.setModificationStamp(computeModificationStamp(info));
		info.fStatus = null;
		return info;
	}

	/**
	 * @generated
	 */
	@Override
	protected IDocument createDocument(final Object element) throws CoreException {
		if (false == element instanceof FileEditorInput && false == element instanceof URIEditorInput) {
			throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, NLS.bind(Messages.UMLDocumentProvider_IncorrectInputError,
					new Object[] { element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
					null));
		}
		final IDocument document = createEmptyDocument();
		setDocumentContent(document, (IEditorInput) element);
		setupDocument(element, document);
		return document;
	}

	/**
	 * Sets up the given document as it would be provided for the given element. The content of the document is not
	 * changed. This default implementation is empty. Subclasses may reimplement.
	 * 
	 * @param element
	 *            the blue-print element
	 * @param document
	 *            the document to set up
	 * @generated
	 */
	protected void setupDocument(final Object element, final IDocument document) {
		// for subclasses
	}

	/**
	 * @generated
	 */
	private long computeModificationStamp(final ResourceSetInfo info) {
		int result = 0;
		for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
			final Resource nextResource = it.next();
			final IFile file = WorkspaceSynchronizer.getFile(nextResource);
			if (file != null) {
				if (file.getLocation() != null) {
					result += file.getLocation().toFile().lastModified();
				} else {
					result += file.getModificationStamp();
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	@Override
	protected IDocument createEmptyDocument() {
		final DiagramDocument document = new DiagramDocument();
		document.setEditingDomain(createEditingDomain());
		return document;
	}

	/**
	 * @generated
	 */
	private TransactionalEditingDomain createEditingDomain() {
		final TransactionalEditingDomain editingDomain = DiagramEditingDomainFactory.getInstance().createEditingDomain();
		editingDomain.setID("org.eclipse.papyrus.uml.diagram.timing.EditingDomain"); //$NON-NLS-1$
		final NotificationFilter diagramResourceModifiedFilter = NotificationFilter.createNotifierFilter(editingDomain.getResourceSet())
				.and(NotificationFilter.createEventTypeFilter(Notification.ADD))
				.and(NotificationFilter.createFeatureFilter(ResourceSet.class, ResourceSet.RESOURCE_SET__RESOURCES));
		editingDomain.getResourceSet().eAdapters().add(new Adapter() {

			private Notifier myTarger;

			public Notifier getTarget() {
				return this.myTarger;
			}

			public boolean isAdapterForType(final Object type) {
				return false;
			}

			public void notifyChanged(final Notification notification) {
				if (diagramResourceModifiedFilter.matches(notification)) {
					final Object value = notification.getNewValue();
					if (value instanceof Resource) {
						((Resource) value).setTrackingModification(true);
					}
				}
			}

			public void setTarget(final Notifier newTarget) {
				this.myTarger = newTarget;
			}

		});

		return editingDomain;
	}

	/**
	 * @generated
	 */
	protected void setDocumentContent(final IDocument document, final IEditorInput element) throws CoreException {
		final IDiagramDocument diagramDocument = (IDiagramDocument) document;
		final TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
		if (element instanceof FileEditorInput) {
			final IStorage storage = ((FileEditorInput) element).getStorage();
			final Diagram diagram = DiagramIOUtil.load(domain, storage, true, getProgressMonitor());
			document.setContent(diagram);
		} else if (element instanceof URIEditorInput) {
			final URI uri = ((URIEditorInput) element).getURI();
			Resource resource = null;
			try {
				resource = domain.getResourceSet().getResource(uri.trimFragment(), false);
				if (resource == null) {
					resource = domain.getResourceSet().createResource(uri.trimFragment());
				}
				if (!resource.isLoaded()) {
					try {
						final Map options = new HashMap(GMFResourceFactory.getDefaultLoadOptions());
						// @see 171060
						// options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_RECORD_UNKNOWN_FEATURE,
						// Boolean.TRUE);
						resource.load(options);
					} catch (final IOException e) {
						resource.unload();
						throw e;
					}
				}
				if (uri.fragment() != null) {
					final EObject rootElement = resource.getEObject(uri.fragment());
					if (rootElement instanceof Diagram) {
						document.setContent(rootElement);
						return;
					}
				} else {
					for (final Object rootElement : resource.getContents()) {
						if (rootElement instanceof Diagram) {
							document.setContent(rootElement);
							return;
						}
					}
				}
				throw new RuntimeException(Messages.UMLDocumentProvider_NoDiagramInResourceError);
			} catch (final Exception e) {
				CoreException thrownExcp = null;
				if (e instanceof CoreException) {
					thrownExcp = (CoreException) e;
				} else {
					final String msg = e.getLocalizedMessage();
					thrownExcp = new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, msg != null ? msg
							: Messages.UMLDocumentProvider_DiagramLoadingError, e));
				}
				throw thrownExcp;
			}
		} else {
			throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, NLS.bind(Messages.UMLDocumentProvider_IncorrectInputError,
					new Object[] { element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
					null));
		}
	}

	/**
	 * @generated
	 */
	@Override
	public long getModificationStamp(final Object element) {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			return computeModificationStamp(info);
		}
		return super.getModificationStamp(element);
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isDeleted(final Object element) {
		final IDiagramDocument document = getDiagramDocument(element);
		if (document != null) {
			final Resource diagramResource = document.getDiagram().eResource();
			if (diagramResource != null) {
				final IFile file = WorkspaceSynchronizer.getFile(diagramResource);
				return file == null || file.getLocation() == null || !file.getLocation().toFile().exists();
			}
		}
		return super.isDeleted(element);
	}

	/**
	 * @generated
	 */
	public ResourceSetInfo getResourceSetInfo(final Object editorInput) {
		return (ResourceSetInfo) super.getElementInfo(editorInput);
	}

	/**
	 * @generated
	 */
	@Override
	protected void disposeElementInfo(final Object element, final ElementInfo info) {
		if (info instanceof ResourceSetInfo) {
			final ResourceSetInfo resourceSetInfo = (ResourceSetInfo) info;
			resourceSetInfo.dispose();
		}
		super.disposeElementInfo(element, info);
	}

	/**
	 * @generated
	 */
	@Override
	protected void doValidateState(final Object element, final Object computationContext) throws CoreException {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			final LinkedList<IFile> files2Validate = new LinkedList<IFile>();
			for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				final Resource nextResource = it.next();
				final IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null && file.isReadOnly()) {
					files2Validate.add(file);
				}
			}
			ResourcesPlugin.getWorkspace().validateEdit(files2Validate.toArray(new IFile[files2Validate.size()]), computationContext);
		}

		super.doValidateState(element, computationContext);
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isReadOnly(final Object element) {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (info.isUpdateCache()) {
				try {
					updateCache(element);
				} catch (final CoreException ex) {
					UMLDiagramEditorPlugin.getInstance().logError(Messages.UMLDocumentProvider_isModifiable, ex);
					// Error message to log was initially taken from
					// org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.internal.l10n.EditorMessages.StorageDocumentProvider_isModifiable
				}
			}
			return info.isReadOnly();
		}
		return super.isReadOnly(element);
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isModifiable(final Object element) {
		if (!isStateValidated(element)) {
			if (element instanceof FileEditorInput || element instanceof URIEditorInput) {
				return true;
			}
		}
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (info.isUpdateCache()) {
				try {
					updateCache(element);
				} catch (final CoreException ex) {
					UMLDiagramEditorPlugin.getInstance().logError(Messages.UMLDocumentProvider_isModifiable, ex);
					// Error message to log was initially taken from
					// org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.internal.l10n.EditorMessages.StorageDocumentProvider_isModifiable
				}
			}
			return info.isModifiable();
		}
		return super.isModifiable(element);
	}

	/**
	 * @generated
	 */
	protected void updateCache(final Object element) throws CoreException {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				final Resource nextResource = it.next();
				final IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null && file.isReadOnly()) {
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

	/**
	 * @generated
	 */
	@Override
	protected void doUpdateStateCache(final Object element) throws CoreException {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			info.setUpdateCache(true);
		}
		super.doUpdateStateCache(element);
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isSynchronized(final Object element) {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			return info.isSynchronized();
		}
		return super.isSynchronized(element);
	}

	/**
	 * @generated
	 */
	@Override
	protected ISchedulingRule getResetRule(final Object element) {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			final LinkedList<ISchedulingRule> rules = new LinkedList<ISchedulingRule>();
			for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				final Resource nextResource = it.next();
				final IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(file));
				}
			}
			return new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected ISchedulingRule getSaveRule(final Object element) {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			final LinkedList<ISchedulingRule> rules = new LinkedList<ISchedulingRule>();
			for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				final Resource nextResource = it.next();
				final IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(computeSchedulingRule(file));
				}
			}
			return new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected ISchedulingRule getSynchronizeRule(final Object element) {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			final LinkedList<ISchedulingRule> rules = new LinkedList<ISchedulingRule>();
			for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				final Resource nextResource = it.next();
				final IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(ResourcesPlugin.getWorkspace().getRuleFactory().refreshRule(file));
				}
			}
			return new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected ISchedulingRule getValidateStateRule(final Object element) {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			final LinkedList<ISchedulingRule> files = new LinkedList<ISchedulingRule>();
			for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				final Resource nextResource = it.next();
				final IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					files.add(file);
				}
			}
			return ResourcesPlugin.getWorkspace().getRuleFactory().validateEditRule(files.toArray(new IFile[files.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	private ISchedulingRule computeSchedulingRule(IResource toCreateOrModify) {
		if (toCreateOrModify.exists()) {
			return ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(toCreateOrModify);
		}

		IResource parent = toCreateOrModify;
		do {
			/*
			 * XXX This is a workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=67601
			 * IResourceRuleFactory.createRule should iterate the hierarchy itself.
			 */
			toCreateOrModify = parent;
			parent = toCreateOrModify.getParent();
		} while (parent != null && !parent.exists());

		return ResourcesPlugin.getWorkspace().getRuleFactory().createRule(toCreateOrModify);
	}

	/**
	 * @generated
	 */
	@Override
	protected void doSynchronize(final Object element, final IProgressMonitor monitor) throws CoreException {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
				final Resource nextResource = it.next();
				handleElementChanged(info, nextResource, monitor);
			}
			return;
		}
		super.doSynchronize(element, monitor);
	}

	/**
	 * @generated
	 */
	@Override
	protected void doSaveDocument(final IProgressMonitor monitor, final Object element, final IDocument document, final boolean overwrite) throws CoreException {
		final ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (!overwrite && !info.isSynchronized()) {
				throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, IResourceStatus.OUT_OF_SYNC_LOCAL,
						Messages.UMLDocumentProvider_UnsynchronizedFileSaveError, null));
			}
			info.stopResourceListening();
			fireElementStateChanging(element);
			try {
				monitor.beginTask(Messages.UMLDocumentProvider_SaveDiagramTask, info.getResourceSet().getResources().size() + 1); // "Saving diagram"
				for (final Iterator<Resource> it = info.getLoadedResourcesIterator(); it.hasNext();) {
					final Resource nextResource = it.next();
					monitor.setTaskName(NLS.bind(Messages.UMLDocumentProvider_SaveNextResourceTask, nextResource.getURI()));
					if (nextResource.isLoaded() && !info.getEditingDomain().isReadOnly(nextResource)) {
						try {
							nextResource.save(UMLDiagramEditorUtil.getSaveOptions());
						} catch (final IOException e) {
							fireElementStateChangeFailed(element);
							throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, EditorStatusCodes.RESOURCE_FAILURE,
									e.getLocalizedMessage(), null));
						}
					}
					monitor.worked(1);
				}
				monitor.done();
				info.setModificationStamp(computeModificationStamp(info));
			} catch (final RuntimeException x) {
				fireElementStateChangeFailed(element);
				throw x;
			} finally {
				info.startResourceListening();
			}
		} else {
			URI newResoruceURI;
			List<IFile> affectedFiles = null;
			if (element instanceof FileEditorInput) {
				final IFile newFile = ((FileEditorInput) element).getFile();
				affectedFiles = Collections.singletonList(newFile);
				newResoruceURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
			} else if (element instanceof URIEditorInput) {
				newResoruceURI = ((URIEditorInput) element).getURI();
			} else {
				fireElementStateChangeFailed(element);
				throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, NLS.bind(Messages.UMLDocumentProvider_IncorrectInputError,
						new Object[] { element, "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
						null));
			}
			if (false == document instanceof IDiagramDocument) {
				fireElementStateChangeFailed(element);
				throw new CoreException(
						new Status(
								IStatus.ERROR,
								UMLDiagramEditorPlugin.ID,
								0,
								"Incorrect document used: " + document + " instead of org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument", null)); //$NON-NLS-1$ //$NON-NLS-2$
			}
			final IDiagramDocument diagramDocument = (IDiagramDocument) document;
			final Resource newResource = diagramDocument.getEditingDomain().getResourceSet().createResource(newResoruceURI);
			final Diagram diagramCopy = EcoreUtil.copy(diagramDocument.getDiagram());
			try {
				new AbstractTransactionalCommand(diagramDocument.getEditingDomain(), NLS.bind(Messages.UMLDocumentProvider_SaveAsOperation,
						diagramCopy.getName()), affectedFiles) {
					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						newResource.getContents().add(diagramCopy);
						return CommandResult.newOKCommandResult();
					}
				}.execute(monitor, null);
				newResource.save(UMLDiagramEditorUtil.getSaveOptions());
			} catch (final ExecutionException e) {
				fireElementStateChangeFailed(element);
				throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, e.getLocalizedMessage(), null));
			} catch (final IOException e) {
				fireElementStateChangeFailed(element);
				throw new CoreException(new Status(IStatus.ERROR, UMLDiagramEditorPlugin.ID, 0, e.getLocalizedMessage(), null));
			}
			newResource.unload();
		}
	}

	/**
	 * @generated
	 */
	protected void handleElementChanged(final ResourceSetInfo info, final Resource changedResource, final IProgressMonitor monitor) {
		final IFile file = WorkspaceSynchronizer.getFile(changedResource);
		if (file != null) {
			try {
				file.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			} catch (final CoreException ex) {
				UMLDiagramEditorPlugin.getInstance().logError(Messages.UMLDocumentProvider_handleElementContentChanged, ex);
				// Error message to log was initially taken from
				// org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.internal.l10n.EditorMessages.FileDocumentProvider_handleElementContentChanged
			}
		}
		changedResource.unload();

		fireElementContentAboutToBeReplaced(info.getEditorInput());
		removeUnchangedElementListeners(info.getEditorInput(), info);
		info.fStatus = null;
		try {
			setDocumentContent(info.fDocument, info.getEditorInput());
		} catch (final CoreException e) {
			info.fStatus = e.getStatus();
		}
		if (!info.fCanBeSaved) {
			info.setModificationStamp(computeModificationStamp(info));
		}
		addUnchangedElementListeners(info.getEditorInput(), info);
		fireElementContentReplaced(info.getEditorInput());
	}

	/**
	 * @generated
	 */
	protected void handleElementMoved(final IEditorInput input, final URI uri) {
		if (input instanceof FileEditorInput) {
			final IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(URI.decode(uri.path())).removeFirstSegments(1));
			fireElementMoved(input, newFile == null ? null : new FileEditorInput(newFile));
			return;
		}
		// TODO: append suffix to the URI! (use diagram as a parameter)
		fireElementMoved(input, new URIEditorInput(uri));
	}

	/**
	 * @generated
	 */
	public IEditorInput createInputWithEditingDomain(final IEditorInput editorInput, final TransactionalEditingDomain domain) {
		return editorInput;
	}

	/**
	 * @generated
	 */
	public IDiagramDocument getDiagramDocument(final Object element) {
		final IDocument doc = getDocument(element);
		if (doc instanceof IDiagramDocument) {
			return (IDiagramDocument) doc;
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected IRunnableContext getOperationRunner(final IProgressMonitor monitor) {
		return null;
	}

	/**
	 * @generated
	 */
	protected class ResourceSetInfo extends ElementInfo {

		/**
		 * @generated
		 */
		private long myModificationStamp = IResource.NULL_STAMP;

		/**
		 * @generated
		 */
		private WorkspaceSynchronizer mySynchronizer;

		/**
		 * @generated
		 */
		private final LinkedList<Resource> myUnSynchronizedResources = new LinkedList<Resource>();

		/**
		 * @generated
		 */
		private final IDiagramDocument myDocument;

		/**
		 * @generated
		 */
		private final IEditorInput myEditorInput;

		/**
		 * @generated
		 */
		private boolean myUpdateCache = true;

		/**
		 * @generated
		 */
		private boolean myModifiable = false;

		/**
		 * @generated
		 */
		private boolean myReadOnly = true;

		/**
		 * @generated
		 */
		private final ResourceSetModificationListener myResourceSetListener;

		/**
		 * @generated
		 */
		public ResourceSetInfo(final IDiagramDocument document, final IEditorInput editorInput) {
			super(document);
			this.myDocument = document;
			this.myEditorInput = editorInput;
			startResourceListening();
			this.myResourceSetListener = new ResourceSetModificationListener(this);
			getResourceSet().eAdapters().add(this.myResourceSetListener);
		}

		/**
		 * @generated
		 */
		public long getModificationStamp() {
			return this.myModificationStamp;
		}

		/**
		 * @generated
		 */
		public void setModificationStamp(final long modificationStamp) {
			this.myModificationStamp = modificationStamp;
		}

		/**
		 * @generated
		 */
		public TransactionalEditingDomain getEditingDomain() {
			return this.myDocument.getEditingDomain();
		}

		/**
		 * @generated
		 */
		public ResourceSet getResourceSet() {
			return getEditingDomain().getResourceSet();
		}

		/**
		 * @generated
		 */
		public Iterator<Resource> getLoadedResourcesIterator() {
			return new ArrayList<Resource>(getResourceSet().getResources()).iterator();
		}

		/**
		 * @generated
		 */
		public IEditorInput getEditorInput() {
			return this.myEditorInput;
		}

		/**
		 * @generated
		 */
		public void dispose() {
			stopResourceListening();
			getResourceSet().eAdapters().remove(this.myResourceSetListener);
			for (final Iterator<Resource> it = getLoadedResourcesIterator(); it.hasNext();) {
				final Resource resource = it.next();
				resource.unload();
			}
			getEditingDomain().dispose();
		}

		/**
		 * @generated
		 */
		public boolean isSynchronized() {
			return this.myUnSynchronizedResources.size() == 0;
		}

		/**
		 * @generated
		 */
		public void setUnSynchronized(final Resource resource) {
			this.myUnSynchronizedResources.add(resource);
		}

		/**
		 * @generated
		 */
		public void setSynchronized(final Resource resource) {
			this.myUnSynchronizedResources.remove(resource);
		}

		/**
		 * @generated
		 */
		public final void stopResourceListening() {
			this.mySynchronizer.dispose();
			this.mySynchronizer = null;
		}

		/**
		 * @generated
		 */
		public final void startResourceListening() {
			this.mySynchronizer = new WorkspaceSynchronizer(getEditingDomain(), new SynchronizerDelegate());
		}

		/**
		 * @generated
		 */
		public boolean isUpdateCache() {
			return this.myUpdateCache;
		}

		/**
		 * @generated
		 */
		public void setUpdateCache(final boolean update) {
			this.myUpdateCache = update;
		}

		/**
		 * @generated
		 */
		public boolean isModifiable() {
			return this.myModifiable;
		}

		/**
		 * @generated
		 */
		public void setModifiable(final boolean modifiable) {
			this.myModifiable = modifiable;
		}

		/**
		 * @generated
		 */
		public boolean isReadOnly() {
			return this.myReadOnly;
		}

		/**
		 * @generated
		 */
		public void setReadOnly(final boolean readOnly) {
			this.myReadOnly = readOnly;
		}

		/**
		 * @generated
		 */
		private class SynchronizerDelegate implements WorkspaceSynchronizer.Delegate {

			/**
			 * @generated
			 */
			public void dispose() {
			}

			/**
			 * @generated
			 */
			public boolean handleResourceChanged(final Resource resource) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						setUnSynchronized(resource);
						return true;
					}
				}
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						handleElementChanged(ResourceSetInfo.this, resource, null);
					}
				});
				return true;
			}

			/**
			 * @generated
			 */
			public boolean handleResourceDeleted(final Resource resource) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						setUnSynchronized(resource);
						return true;
					}
				}
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						fireElementDeleted(getEditorInput());
					}
				});
				return true;
			}

			/**
			 * @generated
			 */
			public boolean handleResourceMoved(final Resource resource, final URI newURI) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						setUnSynchronized(resource);
						return true;
					}
				}
				if (ResourceSetInfo.this.myDocument.getDiagram().eResource() == resource) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							handleElementMoved(getEditorInput(), newURI);
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
	 * @generated
	 */
	private class ResourceSetModificationListener extends EContentAdapter {

		/**
		 * @generated
		 */
		private final NotificationFilter myModifiedFilter;

		/**
		 * @generated
		 */
		private final ResourceSetInfo myInfo;

		/**
		 * @generated
		 */
		public ResourceSetModificationListener(final ResourceSetInfo info) {
			this.myInfo = info;
			this.myModifiedFilter = NotificationFilter.createEventTypeFilter(Notification.SET).or(NotificationFilter.createEventTypeFilter(Notification.UNSET))
					.and(NotificationFilter.createFeatureFilter(Resource.class, Resource.RESOURCE__IS_MODIFIED));
		}

		/**
		 * @generated
		 */
		@Override
		public void notifyChanged(final Notification notification) {
			if (notification.getNotifier() instanceof ResourceSet) {
				super.notifyChanged(notification);
			}
			if (!notification.isTouch() && this.myModifiedFilter.matches(notification)) {
				if (notification.getNotifier() instanceof Resource) {
					final Resource resource = (Resource) notification.getNotifier();
					if (resource.isLoaded()) {
						boolean modified = false;
						for (final Iterator/* <org.eclipse.emf.ecore.resource.Resource> */it = this.myInfo.getLoadedResourcesIterator(); it.hasNext()
								&& !modified;) {
							final Resource nextResource = (Resource) it.next();
							if (nextResource.isLoaded()) {
								modified = nextResource.isModified();
							}
						}
						boolean dirtyStateChanged = false;
						synchronized (this.myInfo) {
							if (modified != this.myInfo.fCanBeSaved) {
								this.myInfo.fCanBeSaved = modified;
								dirtyStateChanged = true;
							}
							if (!resource.isModified()) {
								this.myInfo.setSynchronized(resource);
							}
						}
						if (dirtyStateChanged) {
							fireElementDirtyStateChanged(this.myInfo.getEditorInput(), modified);

							if (!modified) {
								this.myInfo.setModificationStamp(computeModificationStamp(this.myInfo));
							}
						}
					}
				}
			}
		}

	}

}
